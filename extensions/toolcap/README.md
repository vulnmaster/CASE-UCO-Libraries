# Forensic Tool Capability Extension (toolcap) v0.3.0

A CASE/UCO extension ontology for modeling which digital forensic tools can parse which applications or perform which forensic tasks (aligned with NIST CFTT programme), on which platforms (including filesystem types), and for which observable types. Supports both vendor-claimed and independently benchmarked capability data with standard IR metrics (precision, recall, F1) and benchmark provenance. Built in compliance with the [CDO Community Playground Guide](https://docs.google.com/document/d/1EiXQiAeUGk-629xdKx7HZHVn927k891LGkPcQzNLLr8/edit?usp=sharing).

## CDO Playground Compliance

This extension follows all CDO Community Playground requirements:

- **T-Box only** — All concepts are defined as `owl:Class`, `owl:ObjectProperty`, or `owl:DatatypeProperty` (never `owl:NamedIndividual`)
- **Mandatory subclassing** — `ToolCapability rdfs:subClassOf uco-core:UcoObject` and `CapabilityMatrix rdfs:subClassOf uco-core:ContextualCompilation`
- **Comprehensive documentation** — Every class and property includes `rdfs:label` and detailed `rdfs:comment`
- **Separate OWL and SHACL** — OWL definitions in `toolcap.ttl`, SHACL shapes in `toolcap-shapes.ttl`
- **Validated exemplar** — `toolcap-exemplar.ttl` passes `case_validate` with `Conforms: True`

## Files

| File | Purpose |
|------|---------|
| `toolcap.ttl` | OWL ontology (T-Box): class and property definitions |
| `toolcap-shapes.ttl` | SHACL shapes: property constraints for validation |
| `toolcap-exemplar.ttl` | Exemplar instances (A-Box): validated example data |
| `example_capability_matrix.py` | Python example using the CASE-UCO-SDK builders |

## Classes

- **ToolCapability** (`toolcap:ToolCapability`, subclass of `uco-core:UcoObject`) — A formal assertion that a specific digital forensic tool can successfully parse, extract, or decode data from a specific application or perform a fundamental forensic task (e.g., string search, file carving, deleted file recovery).
- **CapabilityMatrix** (`toolcap:CapabilityMatrix`, subclass of `uco-core:ContextualCompilation`) — A named, versioned collection of ToolCapability assertions that together represent a comprehensive comparison of which digital forensic tools support which applications and tasks.
- **BenchmarkObservation** (`toolcap:BenchmarkObservation`, subclass of `uco-core:UcoObject`) — A single point-in-time record of testing a forensic tool's capability with detailed metrics, IR scores, and benchmark provenance.
- **PlatformSpecification** (`toolcap:PlatformSpecification`, subclass of `uco-core:UcoObject`) — Describes the OS, version, device model, extraction method, and filesystem type relevant to a capability or benchmark.
- **AccessRestriction** (`toolcap:AccessRestriction`, subclass of `uco-core:UcoObject`) — Security, licensing, classification, or legal constraints on using a capability.

## Key Properties

### ToolCapability

| Property | Type | Cardinality | Description |
|----------|------|-------------|-------------|
| `toolcap:tool` | `uco-tool:Tool` | exactly 1 | The forensic tool that has this capability |
| `toolcap:application` | `uco-observable:ObservableObject` | 0..1 | The application whose data can be parsed (omit for task-level capabilities) |
| `toolcap:forensicTaskType` | `xsd:string` | 0..* | CFTT task category: `string-search`, `deleted-file-recovery`, `file-carving`, `windows-registry-recovery`, `sqlite-recovery` |
| `toolcap:supportsPlatform` | `toolcap:PlatformSpecification` | 0..* | Structured platform specifications |
| `toolcap:parsedObservableType` | `xsd:string` | 0..* | Observable types (messages, contacts, carved files, etc.) |
| `toolcap:toolVersion` | `xsd:string` | 0..1 | Tool version tested |
| `toolcap:applicationVersion` | `xsd:string` | 0..* | Target application versions |
| `toolcap:dataFormatVersion` | `xsd:string` | 0..* | Data storage format versions (.pst, .nst, etc.) |
| `toolcap:claimedByVendor` | `xsd:boolean` | 0..1 | Whether vendor-asserted |
| `toolcap:verifiedByBenchmark` | `xsd:boolean` | 0..1 | Whether independently benchmarked |
| `toolcap:hasAccessRestriction` | `toolcap:AccessRestriction` | 0..* | Access restrictions |
| `toolcap:hasObservation` | `toolcap:BenchmarkObservation` | 0..* | Linked benchmark observations |

### BenchmarkObservation — IR Metrics (v0.3.0)

| Property | Type | Cardinality | Description |
|----------|------|-------------|-------------|
| `toolcap:precisionScore` | `xsd:decimal` | 0..1 | Precision = TP / (TP + FP), 0.0–1.0 |
| `toolcap:recallScore` | `xsd:decimal` | 0..1 | Recall = TP / (TP + FN), 0.0–1.0 |
| `toolcap:f1Score` | `xsd:decimal` | 0..1 | F1 = 2·P·R / (P + R), 0.0–1.0 |
| `toolcap:truePositiveCount` | `xsd:nonNegativeInteger` | 0..1 | True positives |
| `toolcap:groundTruthCount` | `xsd:nonNegativeInteger` | 0..1 | Total items in ground truth |
| `toolcap:submittedCount` | `xsd:nonNegativeInteger` | 0..1 | Items reported by the tool (TP + FP) |

### BenchmarkObservation — Provenance (v0.3.0)

| Property | Type | Cardinality | Description |
|----------|------|-------------|-------------|
| `toolcap:benchmarkFramework` | `xsd:string` | 0..1 | Framework name (e.g., `AutoDFBench`, `NIST-CFTT`) |
| `toolcap:testCaseIdentifier` | `xsd:string` | 0..1 | Test case ID within the framework |
| `toolcap:benchmarkSuiteScore` | `xsd:decimal` | 0..1 | Overall composite score, 0.0–1.0 |

### PlatformSpecification — Filesystem (v0.3.0)

| Property | Type | Cardinality | Description |
|----------|------|-------------|-------------|
| `toolcap:fileSystemType` | `xsd:string` | 0..* | Filesystem type (FAT32, NTFS, ext4, HFS+, etc.) |

## Version History

| Version | Changes |
|---------|---------|
| 0.1.0 | Initial release with ToolCapability and CapabilityMatrix |
| 0.2.0 | Added BenchmarkObservation, PlatformSpecification, AccessRestriction; vendor/benchmark flags; application/format versioning; deprecated `supportedPlatform` string property |
| 0.3.0 | Added `forensicTaskType` for NIST CFTT task-level capabilities; IR metrics (precision, recall, F1, TP, ground truth, submitted counts); benchmark provenance (framework, test case ID, suite score); `fileSystemType` on PlatformSpecification; relaxed `application` to optional |

## Validation

Validate the exemplar with `case_validate` (from `pip install case-utils`):

```bash
case_validate --built-version case-1.4.0 \
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

## Python Builder Example

```bash
python extensions/toolcap/example_capability_matrix.py
```

See `example_capability_matrix.py` for a complete working example using the CASE-UCO-SDK Python builder to construct a capability matrix comparing two forensic tools across applications and NIST CFTT forensic tasks with full AutoDFBench IR metrics.
