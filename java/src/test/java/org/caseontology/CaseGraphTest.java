// Tests for CaseGraph builder and JSON-LD serialization.
package org.caseontology;

import org.caseontology.uco.tool.Tool;
import org.caseontology.uco.observable.ObservableObject;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.List;

public class CaseGraphTest {

    @Test
    public void testCreateTool() {
        CaseGraph graph = new CaseGraph();
        Tool tool = new Tool();
        tool.setName("Magnet AXIOM");
        tool.setVersion("7.0");
        tool.setToolType("forensic");

        String id = graph.add(tool);
        assertTrue(id.startsWith("kb:Tool-"));
        Map<String, Object> doc = graph.toMap();
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> graphList = (List<Map<String, Object>>) doc.get("@graph");
        assertTrue(graphList.get(0).containsKey("uco-core:name"));
        assertFalse(graphList.get(0).containsKey("uco-tool:name"));
    }

    @Test
    public void testGetId() {
        CaseGraph graph = new CaseGraph();
        Tool tool = new Tool();
        String id = graph.add(tool);
        assertEquals(id, graph.getId(tool));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testMultipleObjects() {
        CaseGraph graph = new CaseGraph();
        graph.add(new Tool());
        graph.add(new Tool());

        Map<String, Object> doc = graph.toMap();
        List<Map<String, Object>> graphList = (List<Map<String, Object>>) doc.get("@graph");
        assertEquals(2, graphList.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testContextHasRequiredPrefixes() {
        CaseGraph graph = new CaseGraph();
        Map<String, Object> doc = graph.toMap();
        Map<String, String> context = (Map<String, String>) doc.get("@context");
        assertTrue(context.containsKey("uco-core"));
        assertTrue(context.containsKey("uco-tool"));
        assertTrue(context.containsKey("uco-observable"));
        assertTrue(context.containsKey("case-investigation"));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testCustomKbPrefix() {
        CaseGraph graph = new CaseGraph("http://mylab.example.org/case/");
        Map<String, Object> doc = graph.toMap();
        Map<String, String> context = (Map<String, String>) doc.get("@context");
        assertEquals("http://mylab.example.org/case/", context.get("kb"));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testBooleanTypedLiteral() {
        CaseGraph graph = new CaseGraph();
        ObservableObject observable = new ObservableObject();
        observable.setHasChanged(Boolean.TRUE);
        graph.add(observable);

        Map<String, Object> doc = graph.toMap();
        List<Map<String, Object>> graphList = (List<Map<String, Object>>) doc.get("@graph");
        Map<String, Object> observableJson = graphList.get(0);
        Map<String, String> typedLiteral = (Map<String, String>) observableJson.get("uco-observable:hasChanged");
        assertEquals("xsd:boolean", typedLiteral.get("@type"));
        assertEquals("true", typedLiteral.get("@value"));
    }
}
