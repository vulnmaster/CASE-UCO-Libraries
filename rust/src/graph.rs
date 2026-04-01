//! CaseGraph — main entry point for building and serializing CASE/UCO graphs in Rust.

use serde::Serialize;
use serde_json::{json, Map, Value};
use std::collections::HashMap;
use uuid::Uuid;

/// Trait implemented by generated CASE/UCO types so that `CaseGraph::create`
/// can read the class IRI and type name without manual arguments.
pub trait CaseObject {
    fn class_iri() -> &'static str;
    fn type_name() -> &'static str;
    /// Validate ontology-required fields. Returns `Ok(())` if all required
    /// fields are present, or `Err` with a message identifying the first
    /// missing field.
    fn validate(&self) -> Result<(), String> {
        Ok(())
    }
}

/// Build a CASE/UCO JSON-LD graph with typed objects.
pub struct CaseGraph {
    context: HashMap<String, String>,
    objects: Vec<Value>,
}

impl CaseGraph {
    pub fn new(kb_prefix: &str) -> Self {
        let mut context = default_context();
        context.insert("kb".to_string(), kb_prefix.to_string());

        CaseGraph {
            context,
            objects: Vec::new(),
        }
    }

    pub fn add_context(&mut self, prefix: &str, iri: &str) {
        self.context.insert(prefix.to_string(), iri.to_string());
    }

    /// Add a generated CASE/UCO object to the graph, auto-generating a UUID-based @id.
    ///
    /// This is the preferred API — the type name and class IRI are read from
    /// the [`CaseObject`] trait that the code generator implements on every
    /// generated struct. Returns the assigned @id.
    ///
    /// Panics if any ontology-required field is missing.
    pub fn create<T: CaseObject + Serialize>(&mut self, instance: &T) -> String {
        if let Err(msg) = instance.validate() {
            panic!("{}", msg);
        }
        let id = format!("kb:{}-{}", T::type_name(), Uuid::new_v4());
        self.add_with_id(&id, T::class_iri(), instance)
    }

    /// Add a generated CASE/UCO object with a user-supplied @id.
    ///
    /// Use this when you need deterministic or externally-controlled IRIs
    /// instead of auto-generated UUIDs.
    ///
    /// Panics if any ontology-required field is missing.
    pub fn create_with_id<T: CaseObject + Serialize>(&mut self, id: &str, instance: &T) -> String {
        if let Err(msg) = instance.validate() {
            panic!("{}", msg);
        }
        self.add_with_id(id, T::class_iri(), instance)
    }

    /// Add a serializable object to the graph with explicit type info.
    /// Returns the assigned @id.
    pub fn add<T: Serialize>(&mut self, type_name: &str, class_iri: &str, instance: &T) -> String {
        let id = format!("kb:{}-{}", type_name, Uuid::new_v4());
        self.add_with_id(&id, class_iri, instance)
    }

    /// Add a serializable object with a specific @id and class IRI.
    pub fn add_with_id<T: Serialize>(&mut self, id: &str, class_iri: &str, instance: &T) -> String {
        let compact_type = self.compact_iri(class_iri);

        let mut obj_value = match serde_json::to_value(instance) {
            Ok(v) => v,
            Err(e) => panic!("failed to serialize object into JSON-LD value: {e}"),
        };
        obj_value = self.convert_value(obj_value);
        if let Value::Object(ref mut map) = obj_value {
            map.insert("@id".to_string(), Value::String(id.to_string()));
            map.insert("@type".to_string(), Value::String(compact_type));
            map.remove("class_iri");
        }

        self.objects.push(obj_value);
        id.to_string()
    }

    /// Return the number of objects in the graph.
    pub fn len(&self) -> usize {
        self.objects.len()
    }

    /// Return true if the graph contains no objects.
    pub fn is_empty(&self) -> bool {
        self.objects.is_empty()
    }

    /// Load a JSON-LD string into this graph, appending its objects.
    ///
    /// The loaded context entries are merged into the graph's context,
    /// and all `@graph` objects are appended to the object list.
    pub fn load(&mut self, json: &str) -> Result<(), serde_json::Error> {
        let doc: Value = serde_json::from_str(json)?;
        if let Some(ctx) = doc.get("@context") {
            if let Some(ctx_map) = ctx.as_object() {
                for (k, v) in ctx_map {
                    if let Some(s) = v.as_str() {
                        self.context.insert(k.clone(), s.to_string());
                    }
                }
            }
        }
        if let Some(graph) = doc.get("@graph") {
            if let Some(arr) = graph.as_array() {
                for obj in arr {
                    self.objects.push(obj.clone());
                }
            }
        }
        Ok(())
    }

    /// Read and load a JSON-LD file into this graph.
    pub fn load_file(&mut self, path: &str) -> Result<(), Box<dyn std::error::Error>> {
        let json = std::fs::read_to_string(path)?;
        self.load(&json)?;
        Ok(())
    }

    /// Parse a JSON-LD string and return the graph with its objects.
    ///
    /// Since Rust lacks runtime reflection, objects are returned as raw
    /// `serde_json::Value` items rather than typed structs. Consumers can
    /// match on `@type` fields manually to downcast.
    pub fn from_jsonld(json: &str) -> Result<(CaseGraph, Vec<Value>), String> {
        let doc: Value =
            serde_json::from_str(json).map_err(|e| format!("Failed to parse JSON: {e}"))?;

        let mut graph = CaseGraph::new("http://example.org/kb/");

        if let Some(ctx) = doc.get("@context").and_then(|c| c.as_object()) {
            for (k, v) in ctx {
                if let Some(s) = v.as_str() {
                    graph.context.insert(k.clone(), s.to_string());
                }
            }
        }

        let mut objects = Vec::new();
        if let Some(arr) = doc.get("@graph").and_then(|g| g.as_array()) {
            for obj in arr {
                graph.objects.push(obj.clone());
                objects.push(obj.clone());
            }
        }

        Ok((graph, objects))
    }

    /// Serialize the graph to a JSON-LD string.
    ///
    /// Returns `Err` if the internal structure cannot be serialized
    /// (should not happen under normal use).
    pub fn serialize(&self) -> Result<String, serde_json::Error> {
        let context_value: Map<String, Value> = self
            .context
            .iter()
            .map(|(k, v)| (k.clone(), Value::String(v.clone())))
            .collect();

        let doc = json!({
            "@context": context_value,
            "@graph": self.objects,
        });

        serde_json::to_string_pretty(&doc)
    }

    /// Write the graph to a file.
    pub fn write(&self, path: &str) -> std::io::Result<()> {
        let json = self.serialize().map_err(std::io::Error::other)?;
        std::fs::write(path, json)
    }

    /// Validate this graph against CASE/UCO SHACL constraints using `case_validate`.
    ///
    /// Requires `case-utils` (`pip install case-utils`) and `case_validate` on PATH.
    /// Returns the validation output on success, or an error message on failure.
    pub fn validate(&self, case_version: &str) -> Result<String, String> {
        use std::io::Write;
        let json = self.serialize().map_err(|e| format!("Serialization failed: {e}"))?;
        let mut tmp = tempfile::NamedTempFile::new()
            .map_err(|e| format!("Failed to create temp file: {e}"))?;
        tmp.write_all(json.as_bytes())
            .map_err(|e| format!("Failed to write temp file: {e}"))?;
        let output = std::process::Command::new("case_validate")
            .arg("--built-version")
            .arg(case_version)
            .arg(tmp.path())
            .output()
            .map_err(|e| format!("case_validate not found on PATH (pip install case-utils): {e}"))?;
        if !output.status.success() {
            let stderr = String::from_utf8_lossy(&output.stderr);
            let stdout = String::from_utf8_lossy(&output.stdout);
            let msg = if stderr.is_empty() { stdout } else { stderr };
            return Err(format!("Validation failed:\n{}", msg.trim()));
        }
        Ok(String::from_utf8_lossy(&output.stdout).to_string())
    }

    /// Estimate the number of RDF triples this graph will produce.
    pub fn estimate_triples(&self) -> usize {
        self.objects.iter().map(count_triples).sum()
    }

    /// Split the graph into smaller chunks of at most `max_objects` each.
    ///
    /// Each chunk gets a clone of the context. The original graph is not modified.
    pub fn split(&self, max_objects: usize) -> Vec<CaseGraph> {
        self.objects
            .chunks(max_objects)
            .map(|chunk| CaseGraph {
                context: self.context.clone(),
                objects: chunk.to_vec(),
            })
            .collect()
    }

    /// Load and merge multiple JSON-LD files into a single graph.
    pub fn merge_files(paths: &[&str], kb_prefix: &str) -> Result<CaseGraph, Box<dyn std::error::Error>> {
        let mut merged = CaseGraph::new(kb_prefix);
        for path in paths {
            merged.load_file(path)?;
        }
        Ok(merged)
    }

    fn compact_iri(&self, iri: &str) -> String {
        for (prefix, ns) in &self.context {
            if iri.starts_with(ns.as_str()) {
                return format!("{}:{}", prefix, &iri[ns.len()..]);
            }
        }
        iri.to_string()
    }

    fn convert_value(&self, value: Value) -> Value {
        match value {
            Value::Object(map) => {
                let converted: Map<String, Value> = map
                    .into_iter()
                    .map(|(k, v)| (k, self.convert_value(v)))
                    .collect();
                Value::Object(converted)
            }
            Value::Array(items) => {
                Value::Array(items.into_iter().map(|item| self.convert_value(item)).collect())
            }
            Value::Bool(boolean) => json!({
                "@type": "xsd:boolean",
                "@value": if boolean { "true" } else { "false" },
            }),
            Value::Number(number) => {
                if number.is_i64() || number.is_u64() {
                    json!({
                        "@type": "xsd:integer",
                        "@value": number.to_string(),
                    })
                } else {
                    json!({
                        "@type": "xsd:decimal",
                        "@value": number.to_string(),
                    })
                }
            }
            other => other,
        }
    }
}

fn count_triples(value: &Value) -> usize {
    match value {
        Value::Object(map) => {
            let mut count = 0;
            for (key, val) in map {
                if key == "@id" {
                    continue;
                }
                if key == "@type" {
                    count += 1;
                    continue;
                }
                match val {
                    Value::Array(items) => {
                        for item in items {
                            if item.is_object() {
                                count += 1 + count_triples(item);
                            } else {
                                count += 1;
                            }
                        }
                    }
                    Value::Object(inner) => {
                        if inner.contains_key("@value") {
                            count += 1;
                        } else {
                            count += 1 + count_triples(val);
                        }
                    }
                    _ => {
                        count += 1;
                    }
                }
            }
            count
        }
        _ => 0,
    }
}

fn default_context() -> HashMap<String, String> {
    let mut ctx = HashMap::new();
    ctx.insert("case-investigation".into(), "https://ontology.caseontology.org/case/investigation/".into());
    ctx.insert("kb".into(), "http://example.org/kb/".into());
    ctx.insert("uco-action".into(), "https://ontology.unifiedcyberontology.org/uco/action/".into());
    ctx.insert("uco-analysis".into(), "https://ontology.unifiedcyberontology.org/uco/analysis/".into());
    ctx.insert("uco-configuration".into(), "https://ontology.unifiedcyberontology.org/uco/configuration/".into());
    ctx.insert("uco-core".into(), "https://ontology.unifiedcyberontology.org/uco/core/".into());
    ctx.insert("uco-identity".into(), "https://ontology.unifiedcyberontology.org/uco/identity/".into());
    ctx.insert("uco-location".into(), "https://ontology.unifiedcyberontology.org/uco/location/".into());
    ctx.insert("uco-marking".into(), "https://ontology.unifiedcyberontology.org/uco/marking/".into());
    ctx.insert("uco-observable".into(), "https://ontology.unifiedcyberontology.org/uco/observable/".into());
    ctx.insert("uco-pattern".into(), "https://ontology.unifiedcyberontology.org/uco/pattern/".into());
    ctx.insert("uco-role".into(), "https://ontology.unifiedcyberontology.org/uco/role/".into());
    ctx.insert("uco-time".into(), "https://ontology.unifiedcyberontology.org/uco/time/".into());
    ctx.insert("uco-tool".into(), "https://ontology.unifiedcyberontology.org/uco/tool/".into());
    ctx.insert("uco-types".into(), "https://ontology.unifiedcyberontology.org/uco/types/".into());
    ctx.insert("uco-victim".into(), "https://ontology.unifiedcyberontology.org/uco/victim/".into());
    ctx.insert("uco-vocabulary".into(), "https://ontology.unifiedcyberontology.org/uco/vocabulary/".into());
    ctx.insert("xsd".into(), "http://www.w3.org/2001/XMLSchema#".into());
    ctx
}
