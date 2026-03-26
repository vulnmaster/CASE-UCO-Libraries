// Smoke test — proves the library builds, links, and runs as a standalone binary.
using CaseUco;
using CaseUco.Uco.Tool;
using CaseUco.Uco.Observable;

var graph = new CaseGraph();
graph.Add(new Tool { Name = "smoke-test", Version = "1.0" });
graph.Add(new ObservableObject());

var json = graph.Serialize();
if (!json.Contains("@context") || !json.Contains("@graph"))
{
    Console.Error.WriteLine("FAIL: serialized output missing expected JSON-LD structure");
    return 1;
}

Console.WriteLine($"OK: CaseUco smoke test passed ({graph.Count} objects serialized)");
return 0;
