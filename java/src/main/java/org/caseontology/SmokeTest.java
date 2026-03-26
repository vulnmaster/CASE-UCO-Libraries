// Smoke test — proves the library builds, links, and runs as a standalone binary.
package org.caseontology;

import org.caseontology.uco.tool.Tool;
import org.caseontology.uco.observable.ObservableObject;

public class SmokeTest {
    public static void main(String[] args) {
        CaseGraph graph = new CaseGraph();
        graph.add(new Tool().setName("smoke-test").setVersion("1.0"));
        graph.add(new ObservableObject());

        String json = graph.serialize();
        if (!json.contains("@context") || !json.contains("@graph")) {
            System.err.println("FAIL: serialized output missing expected JSON-LD structure");
            System.exit(1);
        }

        System.out.println("OK: case-uco smoke test passed (" + graph.size() + " objects serialized)");
    }
}
