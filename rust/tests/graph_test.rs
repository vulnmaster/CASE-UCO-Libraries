//! Tests for CaseGraph builder and JSON-LD serialization.

use case_uco::graph::CaseGraph;
use case_uco::uco::observable::ObservableObject;
use case_uco::uco::tool::Tool;

#[test]
fn test_create_tool() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    let tool = Tool::builder()
        .version("7.0".to_string())
        .tool_type("forensic".to_string())
        .build();

    let id = graph.create(&tool);
    assert!(id.starts_with("kb:Tool-"));
}

#[test]
fn test_legacy_add_api() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    let tool = Tool::builder().build();
    let id = graph.add("Tool", Tool::CLASS_IRI, &tool);
    assert!(id.starts_with("kb:Tool-"));
}

#[test]
fn test_create_with_custom_id() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    let tool = Tool::builder()
        .version("7.0".to_string())
        .build();

    let id = graph.create_with_id("kb:Tool-my-stable-id", &tool);
    assert_eq!(id, "kb:Tool-my-stable-id");

    let json = graph.serialize().expect("serialization should succeed");
    assert!(json.contains("kb:Tool-my-stable-id"));
}

#[test]
fn test_serialize_produces_valid_json() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    let tool = Tool::builder().build();
    graph.create(&tool);

    let json = graph.serialize().expect("serialization should succeed");
    let parsed: serde_json::Value = serde_json::from_str(&json).unwrap();
    assert!(parsed.get("@context").is_some());
    assert!(parsed.get("@graph").is_some());
}

#[test]
fn test_prefixed_property_names() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    let tool = Tool::builder()
        .tool_type("forensic".to_string())
        .version("7.0".to_string())
        .build();
    graph.create(&tool);

    let json = graph.serialize().expect("serialization should succeed");
    let parsed: serde_json::Value = serde_json::from_str(&json).unwrap();
    let obj = parsed.get("@graph").unwrap().as_array().unwrap()[0].clone();
    assert!(obj.get("uco-tool:toolType").is_some());
    assert!(obj.get("tool_type").is_none());
}

#[test]
fn test_typed_boolean_literals() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    let observable = ObservableObject::builder().has_changed(true).build();
    graph.create(&observable);

    let json = graph.serialize().expect("serialization should succeed");
    let parsed: serde_json::Value = serde_json::from_str(&json).unwrap();
    let obj = parsed.get("@graph").unwrap().as_array().unwrap()[0].clone();
    assert_eq!(obj["uco-observable:hasChanged"]["@type"], "xsd:boolean");
    assert_eq!(obj["uco-observable:hasChanged"]["@value"], "true");
}

#[test]
fn test_multiple_objects() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    let t1 = Tool::builder().build();
    let t2 = Tool::builder().build();
    graph.create(&t1);
    graph.create(&t2);

    let json = graph.serialize().expect("serialization should succeed");
    let parsed: serde_json::Value = serde_json::from_str(&json).unwrap();
    let graph_array = parsed.get("@graph").unwrap().as_array().unwrap();
    assert_eq!(graph_array.len(), 2);
}

#[test]
fn test_context_prunes_unused_prefixes() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    let tool = Tool::builder()
        .version("1.0".to_string())
        .build();
    graph.create(&tool);

    let json = graph.serialize().expect("serialization should succeed");
    let parsed: serde_json::Value = serde_json::from_str(&json).unwrap();
    let ctx = parsed.get("@context").unwrap();

    assert!(ctx.get("kb").is_some(), "used prefix kb should be present");
    assert!(ctx.get("uco-tool").is_some(), "used prefix uco-tool should be present");

    let unused = vec![
        "uco-identity", "uco-location", "uco-role", "uco-victim",
        "uco-configuration", "uco-marking", "uco-pattern", "uco-time",
    ];
    for prefix in unused {
        assert!(ctx.get(prefix).is_none(), "unused prefix should be pruned: {}", prefix);
    }
}

#[test]
fn test_empty_graph_has_empty_context() {
    let graph = CaseGraph::new("http://example.org/kb/");
    let json = graph.serialize().expect("serialization should succeed");
    let parsed: serde_json::Value = serde_json::from_str(&json).unwrap();
    let ctx = parsed.get("@context").unwrap().as_object().unwrap();
    assert!(ctx.is_empty(), "empty graph should have empty context");
}

#[test]
fn test_len_and_is_empty() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    assert!(graph.is_empty());
    assert_eq!(graph.len(), 0);

    graph.create(&Tool::builder().build());
    assert!(!graph.is_empty());
    assert_eq!(graph.len(), 1);
}

#[test]
fn test_load_json_ld() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    let json_ld = r#"{
        "@context": {
            "kb": "http://example.org/kb/",
            "uco-tool": "https://ontology.unifiedcyberontology.org/uco/tool/"
        },
        "@graph": [
            {
                "@id": "kb:Tool-existing-001",
                "@type": "uco-tool:Tool"
            }
        ]
    }"#;

    graph.load(json_ld).expect("load should succeed");
    assert_eq!(graph.len(), 1);

    let output = graph.serialize().expect("serialization should succeed");
    assert!(output.contains("kb:Tool-existing-001"));
}
