// Smoke test — proves the library builds, links, and runs as a standalone binary.
package org.caseontology;

import org.caseontology.uco.tool.Tool;
import org.caseontology.uco.observable.ObservableObject;

public class SmokeTest {
    public static void main(String[] args) {
        CaseGraph graph = new CaseGraph();
        Tool tool = new Tool();
        tool.setName("smoke-test");
        tool.setVersion("1.0");
        graph.add(tool);
        graph.add(new ObservableObject());

        String json = graph.serialize();
        if (!json.contains("@context") || !json.contains("@graph")) {
            System.err.println("FAIL: serialized output missing expected JSON-LD structure");
            System.exit(1);
        }

        System.out.println("OK: case-uco smoke test passed (" + graph.size() + " objects serialized)");
    }
}
