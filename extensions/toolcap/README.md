# Forensic Tool Capability Extension (toolcap) v0.4.0

A CASE/UCO extension ontology for modeling forensic tool capabilities using a decomposed, graph-based model. Tools are related to modules and parsers, modules are linked to capabilities via `uco-core:Relationship`, and capabilities are described structurally using `uco-action:ActionPattern`. Supports both vendor-claimed and independently benchmarked capability data with standard IR metrics (precision, recall, F1) and benchmark provenance aligned with the NIST CFTT programme and AutoDFBench. Built in compliance with the [CDO Community Playground Guide](https://docs.google.com/document/d/1EiXQiAeUGk-629xdKx7HZHVn927k891LGkPcQzNLLr8/edit?usp=sharing).

## Architecture (v0.4.0)

v0.4.0 replaces the monolithic `ToolCapability` class with a decomposed model informed by Sean Barnum's data model design:

```
Tool --(mayUse)--> Module --(hasCapability)--> Capability
                   Module --(uses)--> Parser
                   Module --(analyticFocus)--> Application
Application --(runs-on)--> OperatingSystem
Application --(variation-of)--> Application (generic)
```

This enables graph-based path-finding queries (e.g., "which tool chain can produce text messages from iOS Snapchat?"), supports modular third-party assertions, and aligns with the proposed [UCO Capability namespace](../change_proposals/capability-namespace.md).

## CDO Playground Compliance

- **T-Box only** — All concepts are defined as `owl:Class`, `owl:ObjectProperty`, or `owl:DatatypeProperty` (never `owl:NamedIndividual`)
- **Mandatory subclassing** — Every class subclasses an appropriate CASE/UCO parent:
  - `BenchmarkObservation rdfs:subClassOf uco-core:Assertion`
  - `AccessRestriction rdfs:subClassOf uco-marking:MarkingDefinition`
  - `Capability rdfs:subClassOf uco-core:UcoObject` (proposed namespace)
  - `Module rdfs:subClassOf uco-observable:Software` (proposed namespace)
  - `Parser rdfs:subClassOf uco-observable:Software` (proposed namespace)
- **Comprehensive documentation** — Every class and property includes `rdfs:label` and detailed `rdfs:comment` with canonical references
- **Separate OWL and SHACL** — OWL definitions in `toolcap.ttl`, SHACL shapes in `toolcap-shapes.ttl`
- **Validated exemplar** — `toolcap-exemplar.ttl` passes `case_validate` with `Conforms: True`

## Files

| File | Purpose |
|------|---------|
| `toolcap.ttl` | OWL ontology (T-Box): class and property definitions |
| `toolcap-shapes.ttl` | SHACL shapes: property constraints for validation |
| `toolcap-exemplar.ttl` | Exemplar instances (A-Box): validated example data |

## Active Classes

### From the proposed `uco-capability` namespace

These classes are defined in `change_proposals/capability-namespace.ttl` and imported by toolcap:

- **Capability** (`capability:Capability`, subclass of `uco-core:UcoObject`) — The ability of an entity to perform some action or produce some result. Linked to possessors via `uco-core:Relationship` with `kindOfRelationship="hasCapability"`. Optionally described via `structuredCharacterization` (→ `uco-action:ActionPattern`) and `capabilityScope`.
- **Module** (`capability:Module`, subclass of `uco-observable:Software`) — A discrete, reusable component of a larger software system (e.g., a parsing module, carving module). Has `analyticFocus` pointing to the target application.
- **Parser** (`capability:Parser`, subclass of `uco-observable:Software`) — A type of software that takes structured/semi-structured input and extracts meaningful content.

### From toolcap

- **BenchmarkObservation** (`toolcap:BenchmarkObservation`, subclass of `uco-core:Assertion`) — A single point-in-time record of testing a forensic tool's capability. Subclasses `Assertion` because each observation is an empirical assertion about performance. Includes IR metrics (precision, recall, F1), confusion matrix counts, processing performance, benchmark provenance, and version tracking.
- **AccessRestriction** (`toolcap:AccessRestriction`, subclass of `uco-marking:MarkingDefinition`) — A marking definition describing security, licensing, classification, or legal constraints on capability use. Subclasses `MarkingDefinition` so restrictions integrate into UCO's standard marking pipeline and can be applied via `objectMarking`. The `restrictionType` property is a subproperty of `uco-marking:definitionType`.

### Deprecated (retained for backward compatibility)

- **ToolCapability** — Use `Capability` + Relationships instead
- **CapabilityMatrix** — The graph IS the matrix; query it with SPARQL
- **PlatformSpecification** — Use `uco-observable:OperatingSystem` + Relationships

## Relationship Vocabulary

The decomposed model uses `uco-core:Relationship` instances with these `kindOfRelationship` values:

| Relationship | Source | Target | Meaning |
|---|---|---|---|
| `mayUse` | Tool | Module | Tool has this module available |
| `uses` | Module | Parser | Module actively uses this parser |
| `hasCapability` | Module/Tool/Parser | Capability | Entity possesses this capability |
| `runs-on` | Application | OperatingSystem | Application runs on this OS |
| `variation-of` | Application | Application | Platform-specific variant of a generic app |
| `hasAccessRestriction` | Tool/Capability | AccessRestriction | Entity has this access constraint |

## Key Properties

### BenchmarkObservation

| Property | Type | Card. | Description |
|----------|------|-------|-------------|
| `toolcap:capability` | `capability:Capability` | 1 | The Capability this observation provides evidence for |
| `toolcap:benchmarkedBy` | `uco-core:IdentityAbstraction` | 0..1 | Who performed the benchmark |
| `toolcap:benchmarkEnvironment` | `uco-observable:OperatingSystem` | 0..1 | OS environment used |
| `toolcap:benchmarkDate` | `xsd:dateTime` | 0..1 | When the benchmark was conducted |
| `toolcap:parseSuccess` | `xsd:boolean` | 0..1 | Whether the tool produced usable output |
| `toolcap:precisionScore` | `xsd:decimal` | 0..1 | TP / (TP + FP), 0.0–1.0 |
| `toolcap:recallScore` | `xsd:decimal` | 0..1 | TP / (TP + FN), 0.0–1.0 |
| `toolcap:f1Score` | `xsd:decimal` | 0..1 | 2·P·R / (P + R), 0.0–1.0 |
| `toolcap:truePositiveCount` | `xsd:nonNegativeInteger` | 0..1 | Correctly identified items |
| `toolcap:falsePositiveCount` | `xsd:nonNegativeInteger` | 0..1 | Incorrectly reported items |
| `toolcap:falseNegativeCount` | `xsd:nonNegativeInteger` | 0..1 | Missed items |
| `toolcap:groundTruthCount` | `xsd:nonNegativeInteger` | 0..1 | Total items in ground truth |
| `toolcap:submittedCount` | `xsd:nonNegativeInteger` | 0..1 | Items reported (TP + FP) |
| `toolcap:benchmarkFramework` | `xsd:string` | 0..1 | Framework (e.g., `AutoDFBench`, `NIST-CFTT`) |
| `toolcap:testCaseIdentifier` | `xsd:string` | 0..1 | Test case ID within framework |
| `toolcap:benchmarkSuiteScore` | `xsd:decimal` | 0..1 | Composite score, 0.0–1.0 |

### AccessRestriction

| Property | Type | Card. | Description |
|----------|------|-------|-------------|
| `toolcap:restrictionType` | `xsd:string` | 1 | Category: `licensing`, `classification`, `operational-security`, `legal-authority` |
| `toolcap:restrictionLevel` | `xsd:string` | 0..1 | Specific value (e.g., `commercial-license-required`) |
| `toolcap:restrictionDescription` | `xsd:string` | 0..1 | Human-readable explanation |
| `toolcap:requiredAuthorization` | `case-investigation:Authorization` | 0..1 | Required investigative authorization |

## Version History

| Version | Changes |
|---------|---------|
| 0.1.0 | Initial release with ToolCapability and CapabilityMatrix |
| 0.2.0 | Added BenchmarkObservation, PlatformSpecification, AccessRestriction |
| 0.3.0 | Added NIST CFTT task-level capabilities, IR metrics, benchmark provenance, filesystem types |
| 0.4.0 | **Major refactor**: Decomposed model (Tool→Module→Parser→Capability→ActionPattern); generic Capability class (proposed for UCO); AccessRestriction subclasses `uco-marking:MarkingDefinition`; BenchmarkObservation subclasses `uco-core:Assertion`; deprecated ToolCapability, CapabilityMatrix, PlatformSpecification; companion UCO change proposal for `uco-capability` namespace |

## Validation

Validate the exemplar with `case_validate` (from `pip install case-utils`):

```bash
case_validate --built-version case-1.4.0 \
  --ontology-graph change_proposals/capability-namespace.ttl \
  --ontology-graph change_proposals/capability-namespace-shapes.ttl \
  --ontology-graph extensions/toolcap/toolcap.ttl \
  --ontology-graph extensions/toolcap/toolcap-shapes.ttl \
  --inference rdfs --allow-info \
  extensions/toolcap/toolcap-exemplar.ttl
```

Expected output:

```
Validation Report
Conforms: True
```

## Related

- [UCO Change Proposal: Capability namespace](../../change_proposals/capability-namespace.md) — Proposal to add `Capability`, `Module`, and `Parser` to UCO
- [UCO Issue #596: Restructuring the Software class hierarchy](https://github.com/ucoProject/UCO/issues/596) — Sean Barnum's related proposal
- [CASE Issue #185: SOLVE-IT notation](https://github.com/casework/CASE/issues/185) — Chris Hargreaves' capability path-finding work
