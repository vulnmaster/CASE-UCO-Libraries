// Smoke test — proves the library builds, links, and runs as a standalone binary.

use case_uco::graph::CaseGraph;
use case_uco::uco::tool::Tool;
use case_uco::uco::observable::ObservableObject;

fn main() {
    let mut graph = CaseGraph::new("http://example.org/kb/");
    graph.create(&Tool::builder().build());
    graph.create(&ObservableObject::builder().build());

    let json = graph.serialize().expect("serialization should succeed");
    assert!(json.contains("@context"), "missing @context");
    assert!(json.contains("@graph"), "missing @graph");

    println!("OK: case-uco smoke test passed ({} objects serialized)", graph.len());
}
