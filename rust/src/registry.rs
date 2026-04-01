//! Runtime ontology introspection — search and discover CASE/UCO classes from Rust.
//!
//! Loads the auto-generated `_registry.json` and exposes search, listing, and
//! query functions so developers can discover the right classes programmatically.
//!
//! ```no_run
//! use case_uco::registry;
//!
//! let results = registry::search("file");
//! for cls in &results {
//!     println!("{}: {}", cls.name, cls.module);
//! }
//!
//! if let Some(info) = registry::get_class("FileFacet") {
//!     println!("{}", info.description);
//! }
//! ```

use serde::Deserialize;
use std::collections::HashMap;
use std::path::PathBuf;
use std::sync::OnceLock;

static REGISTRY: OnceLock<Registry> = OnceLock::new();

#[derive(Debug, Clone, Deserialize)]
struct RawRegistry {
    modules: Vec<String>,
    classes: HashMap<String, RawClass>,
    vocabs: HashMap<String, RawVocab>,
}

#[derive(Debug, Clone, Deserialize)]
struct RawClass {
    iri: String,
    module: String,
    description: String,
    parents: Vec<String>,
    is_facet: bool,
    properties: Vec<RawProperty>,
}

#[derive(Debug, Clone, Deserialize)]
struct RawProperty {
    name: String,
    #[serde(rename = "type")]
    type_name: String,
    type_iri: String,
    cardinality: String,
    required: bool,
    description: String,
}

#[derive(Debug, Clone, Deserialize)]
struct RawVocab {
    iri: String,
    members: Vec<String>,
}

/// A resolved ontology class with its name included.
#[derive(Debug, Clone)]
pub struct OntologyClass {
    pub name: String,
    pub iri: String,
    pub module: String,
    pub description: String,
    pub parents: Vec<String>,
    pub is_facet: bool,
    pub properties: Vec<OntologyProperty>,
}

/// A property on an ontology class.
#[derive(Debug, Clone)]
pub struct OntologyProperty {
    pub name: String,
    pub type_name: String,
    pub type_iri: String,
    pub cardinality: String,
    pub required: bool,
    pub description: String,
}

/// A vocabulary type with its members.
#[derive(Debug, Clone)]
pub struct OntologyVocab {
    pub name: String,
    pub iri: String,
    pub members: Vec<String>,
}

struct Registry {
    modules: Vec<String>,
    classes: HashMap<String, RawClass>,
    classes_lower: HashMap<String, String>,
    vocabs: HashMap<String, RawVocab>,
}

fn load() -> &'static Registry {
    REGISTRY.get_or_init(|| {
        let json = load_json();
        let raw: RawRegistry = match serde_json::from_str(&json) {
            Ok(v) => v,
            Err(e) => panic!("Failed to parse _registry.json: {e}"),
        };

        let classes_lower: HashMap<String, String> = raw
            .classes
            .keys()
            .map(|k| (k.to_lowercase(), k.clone()))
            .collect();

        Registry {
            modules: raw.modules,
            classes: raw.classes,
            classes_lower,
            vocabs: raw.vocabs,
        }
    })
}

fn load_json() -> String {
    let candidates = vec![
        PathBuf::from(env!("CARGO_MANIFEST_DIR")).join("src/_registry.json"),
        PathBuf::from("src/_registry.json"),
        PathBuf::from("_registry.json"),
    ];
    for path in &candidates {
        if path.exists() {
            return std::fs::read_to_string(path)
                .unwrap_or_else(|e| panic!("Failed to read {}: {}", path.display(), e));
        }
    }
    panic!(
        "Ontology registry not found. Run 'case-uco-generate generate' to produce it. \
         Searched: {:?}",
        candidates
    );
}

fn raw_to_class(name: &str, raw: &RawClass) -> OntologyClass {
    OntologyClass {
        name: name.to_string(),
        iri: raw.iri.clone(),
        module: raw.module.clone(),
        description: raw.description.clone(),
        parents: raw.parents.clone(),
        is_facet: raw.is_facet,
        properties: raw
            .properties
            .iter()
            .map(|p| OntologyProperty {
                name: p.name.clone(),
                type_name: p.type_name.clone(),
                type_iri: p.type_iri.clone(),
                cardinality: p.cardinality.clone(),
                required: p.required,
                description: p.description.clone(),
            })
            .collect(),
    }
}

/// Search for classes by keyword (case-insensitive substring match on name and description).
pub fn search(query: &str) -> Vec<OntologyClass> {
    let reg = load();
    let q = query.to_lowercase();
    let mut results: Vec<OntologyClass> = reg
        .classes
        .iter()
        .filter(|(name, cls)| {
            name.to_lowercase().contains(&q) || cls.description.to_lowercase().contains(&q)
        })
        .map(|(name, cls)| raw_to_class(name, cls))
        .collect();
    results.sort_by(|a, b| (&a.module, &a.name).cmp(&(&b.module, &b.name)));
    results
}

/// List all module names.
pub fn list_modules() -> Vec<String> {
    let reg = load();
    let mut modules = reg.modules.clone();
    modules.sort();
    modules
}

/// List class names, optionally filtered by module (partial match).
pub fn list_classes(module: Option<&str>) -> Vec<String> {
    let reg = load();
    let mut results: Vec<String> = match module {
        None => reg.classes.keys().cloned().collect(),
        Some(m) => {
            let ml = m.to_lowercase();
            reg.classes
                .iter()
                .filter(|(_, cls)| cls.module.to_lowercase().contains(&ml))
                .map(|(name, _)| name.clone())
                .collect()
        }
    };
    results.sort();
    results
}

/// Get full details for a class by name (case-insensitive).
pub fn get_class(name: &str) -> Option<OntologyClass> {
    let reg = load();
    let canonical = reg.classes_lower.get(&name.to_lowercase())?;
    let raw = reg.classes.get(canonical)?;
    Some(raw_to_class(canonical, raw))
}

/// Find classes that have a property of the given type (case-insensitive).
pub fn find_by_property_type(type_name: &str) -> Vec<OntologyClass> {
    let reg = load();
    let t = type_name.to_lowercase();
    let mut results: Vec<OntologyClass> = reg
        .classes
        .iter()
        .filter(|(_, cls)| {
            cls.properties
                .iter()
                .any(|p| p.type_name.to_lowercase().contains(&t))
        })
        .map(|(name, cls)| raw_to_class(name, cls))
        .collect();
    results.sort_by(|a, b| a.name.cmp(&b.name));
    results
}

/// Find all Facet classes.
pub fn find_facets() -> Vec<OntologyClass> {
    let reg = load();
    let mut results: Vec<OntologyClass> = reg
        .classes
        .iter()
        .filter(|(_, cls)| cls.is_facet)
        .map(|(name, cls)| raw_to_class(name, cls))
        .collect();
    results.sort_by(|a, b| a.name.cmp(&b.name));
    results
}

/// List all vocabulary types with their members.
pub fn list_vocabs() -> Vec<OntologyVocab> {
    let reg = load();
    let mut results: Vec<OntologyVocab> = reg
        .vocabs
        .iter()
        .map(|(name, v)| OntologyVocab {
            name: name.clone(),
            iri: v.iri.clone(),
            members: v.members.clone(),
        })
        .collect();
    results.sort_by(|a, b| a.name.cmp(&b.name));
    results
}
