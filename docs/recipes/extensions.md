# Working with Extensions

> See [Recipe Index](INDEX.md) for all recipes.

Use extension ontologies to model domain-specific concepts that aren't covered by the core CASE/UCO specification. Extensions define new OWL classes and SHACL shapes that build on UCO/CASE, and can be submitted to the [CDO Community Playground](https://docs.google.com/document/d/1EiXQiAeUGk-629xdKx7HZHVn927k891LGkPcQzNLLr8/edit?usp=sharing) for others to explore and re-use.

## Extension File Structure

Every extension should have three separate files:

| File | Purpose | Contains |
|------|---------|----------|
| `myext.ttl` | OWL definitions (T-Box) | Classes, properties, labels, descriptions |
| `myext-shapes.ttl` | SHACL constraints | NodeShapes, property shapes, cardinalities |
| `myext-exemplar.ttl` | Example instances (A-Box) | Instance data using UUID-based IRIs |

Separating OWL and SHACL avoids redundancies during testing.

## Critical Rules for Extension Classes

1. **Use `owl:Class`, never `owl:NamedIndividual`** for schema concepts. This is the most common AI mistake — `owl:NamedIndividual` is not instantiable.
2. **Every class must subclass** an existing UCO, CASE, or community extension class via `rdfs:subClassOf`.
3. **Include `rdfs:label` and a descriptive `rdfs:comment`** (`@en`) for every class and property. Err on the side of longer, more detailed descriptions. Descriptions should include citations to a canonical source that is web accessible (e.g., an RFC, W3C spec, NIST publication, or authoritative reference URL).
4. **Multiple superclasses are allowed**, as long as class disjointedness is respected.
5. **Reference [CASE-Examples](https://github.com/casework/CASE-Examples)** for validated patterns to emulate.

## Scaffolding Typed Classes

The scaffold command generates starter classes for all four SDK languages:

```bash
# Generate starter code from your extension's TTL files
case-uco-generate scaffold \
  --extension extensions/toolcap/toolcap.ttl extensions/toolcap/toolcap-shapes.ttl \
  --output-dir my_project/

# Generate for a single language
case-uco-generate scaffold \
  --extension extensions/toolcap/toolcap.ttl extensions/toolcap/toolcap-shapes.ttl \
  --lang python --output-dir my_project/
```

<details open><summary>Python — using scaffolded classes</summary>

```python
from toolcap_classes import ToolCapability, CapabilityMatrix
from case_uco import CASEGraph
from case_uco.uco.tool import Tool

graph = CASEGraph(extra_context={
    "toolcap": "http://example.org/ontology/toolcap/",
})

tool = graph.create(Tool, name="Tool A", version="4.0")

cap = ToolCapability(
    tool=tool,
    supported_platform=["Android", "iOS"],
    parsed_observable_type=["SMS", "Contacts", "Call Logs"],
    tool_version="4.0",
    is_verified=True,
)
graph.add(cap)

print(graph.serialize())
```

</details>

<details><summary>C# — using scaffolded classes</summary>

```csharp
using CaseUco;
using CaseUco.Ext.Toolcap;

var graph = new CaseGraph();
graph.AddContext("toolcap", "http://example.org/ontology/toolcap/");

var toolId = graph.Add(new Tool { Name = "Tool A", Version = "4.0" });

graph.Add(new ToolCapability {
    ToolVersion = "4.0",
    SupportedPlatform = { "Android", "iOS" },
    ParsedObservableType = { "SMS", "Contacts", "Call Logs" },
    IsVerified = true
});

Console.WriteLine(graph.Serialize());
```

</details>

<details><summary>Java — using scaffolded classes</summary>

```java
import org.caseontology.*;
import org.caseontology.ext.toolcap.*;

CaseGraph graph = new CaseGraph();
graph.addContext("toolcap", "http://example.org/ontology/toolcap/");

var tool = new Tool();
tool.setName("Tool A");
tool.setVersion("4.0");
graph.add(tool);

var cap = new ToolCapability();
cap.setToolVersion("4.0");
cap.getSupportedPlatform().add("Android");
cap.getSupportedPlatform().add("iOS");
cap.getParsedObservableType().add("SMS");
cap.getParsedObservableType().add("Contacts");
graph.add(cap);

System.out.println(graph.serialize());
```

</details>

## Validating Extensions

Extensions and their exemplar data MUST validate with `case_validate` before they are considered complete.

### Basic Validation

```bash
pip install case-utils  # one-time install

case_validate --built-version case-1.4.0 \
  --ontology-graph myext.ttl \
  --ontology-graph myext-shapes.ttl \
  myext-exemplar.ttl
```

### Extensions That Subclass UCO/CASE Classes

When your extension adds subclasses of `uco-core:Facet`, `uco-core:UcoObject`, or other UCO classes, include `--inference rdfs` so the validator infers the property hierarchy. Add `--allow-info` so informational results (UUID IRI suggestions, vocabulary hints) don't cause failure:

```bash
case_validate --built-version case-1.4.0 \
  --ontology-graph myext.ttl \
  --ontology-graph myext-shapes.ttl \
  --inference rdfs --allow-info \
  myext-exemplar.ttl
```

### Multiple Extension Namespaces

If your exemplar uses classes from multiple extension ontologies, pass each with a separate `--ontology-graph`:

```bash
case_validate --built-version case-1.4.0 \
  --ontology-graph ontology/action-ai-ext.ttl \
  --ontology-graph ontology/observable-ai-ext.ttl \
  exemplars/action-ai-ext-exemplar.ttl
```

The report MUST show **Conforms: True**. Common fixes:
- Use `^^xsd:string` for string literals where shapes expect a typed literal
- Satisfy `minCount` / `maxCount` property cardinalities
- Use `http://example.org/` prefix for extension terms to avoid the typo-checker

> **Note:** SHACL infers superclasses for free but does not infer superproperties. See the [W3C Data Shapes discussion](https://github.com/w3c/data-shapes/issues/232) for background.

## CDO Community Playground Testing

To submit an extension to the [CDO Community Playground](https://docs.google.com/document/d/1EiXQiAeUGk-629xdKx7HZHVn927k891LGkPcQzNLLr8/edit?usp=sharing), you must test it using the community's test infrastructure:

### Using the SDK Makefile (recommended)

```bash
make playground-test \
  EXT_OWL=extensions/myext/myext.ttl \
  EXT_SHAPES=extensions/myext/myext-shapes.ttl
```

This clones [CASE-Profile-Example](https://github.com/casework/CASE-Profile-Example), injects your ontology and shapes, then runs `make -j check`.

### Manual Testing

```bash
# 1. Clone the testing infrastructure
git clone https://github.com/casework/CASE-Profile-Example

# 2. Inject your ontology and shapes
cp myext.ttl CASE-Profile-Example/ontology/case-example.ttl
cp myext-shapes.ttl CASE-Profile-Example/shapes/sh-case-example.ttl

# 3. Run the full test suite
cd CASE-Profile-Example && make -j check
```

### Submitting

Once both `case_validate` and `make -j check` pass, place the extension in a public GitHub repository and notify the CASE/UCO Ontology Committee for listing on [cyberdomainontology.org](https://www.cyberdomainontology.org).

## Existing Community Playground Extensions

- **[CASE Ontology Extensions (AI-Generated)](https://github.com/vulnmaster/CASE-Ontology-Extensions-AI-Generated)** — CASE extensions derived from Project VIC International's work on ICAC taskforce workflows
- **[UCO Extensions (AI-Generated)](https://github.com/vulnmaster/Unified-Cyber-Ontology-Extensions-AI-Generated)** — UCO extensions for the same project

See [ECOSYSTEM.md](../ECOSYSTEM.md#community-extensions) for the full list of community extensions.
