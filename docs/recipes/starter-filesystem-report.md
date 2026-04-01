# Starter Kit: Filesystem Triage Report

> See [Recipe Index](INDEX.md) for all recipes.

Map a filesystem triage report (file listing with names, paths, sizes, hashes) into a CASE/UCO graph.

## Source Input Shape

A CSV file where each row describes one file found during triage:

```csv
file_name,file_path,size_bytes,sha256
budget.xlsx,/Users/jdoe/Documents/budget.xlsx,51200,e3b0c44298fc1c149afbf4c8996fb924...
keylog.exe,/Users/jdoe/AppData/Local/Temp/keylog.exe,89400,d7a8fbb307d7809469ca9abcb0082e4f...
```

## Modeling Choices

| Concept | CASE/UCO Class | Why |
|---|---|---|
| Each file | `ObservableObject` + `FileFacet` + `ContentDataFacet` | One observable per file; facets describe different aspects (filesystem metadata vs. content hashes) |
| The triage scan | `InvestigativeAction` | Captures who ran the scan, when, and what it produced |
| The triage tool | `Tool` | Records the software name and version used |
| Hash values | `Hash` (inside `ContentDataFacet.hash`) | Structured hash with method + value, not a flat string |

## Anti-Patterns

- **One ObservableObject per facet.** Do NOT create separate observables for the file metadata and its hash. A single `ObservableObject` carries both `FileFacet` and `ContentDataFacet` because they describe the same artifact.
- **Omitting hash values.** Hash values are critical for evidence integrity. Always populate `ContentDataFacet.hash` with a `Hash` object specifying the algorithm and digest.
- **Using Tool as evidence.** A `Tool` describes the software used in the investigation — it is not an evidence item. Do not add `FileFacet` to a `Tool`.

## Complete Code

```python
from datetime import datetime
from case_uco import CASEGraph
from case_uco.uco.tool import Tool
from case_uco.uco.types import Hash
from case_uco.case.investigation import InvestigativeAction
from case_uco.uco.observable import ObservableObject, FileFacet, ContentDataFacet

graph = CASEGraph()

tool = graph.create(Tool,
    name="Triage Collector",
    version="3.1.0",
    tool_type="Filesystem Triage",
)

file1 = graph.create(ObservableObject,
    has_facet=[
        FileFacet(
            file_name="budget.xlsx",
            file_path="/Users/jdoe/Documents/budget.xlsx",
            size_in_bytes=51200,
            modified_time=datetime(2025, 6, 10, 14, 22, 0),
        ),
        ContentDataFacet(
            hash=[Hash(hash_method="SHA256",
                        hash_value="e3b0c44298fc1c149afbf4c8996fb924")],
            size_in_bytes=51200,
        ),
    ],
)

file2 = graph.create(ObservableObject,
    has_facet=[
        FileFacet(
            file_name="keylog.exe",
            file_path="/Users/jdoe/AppData/Local/Temp/keylog.exe",
            size_in_bytes=89400,
        ),
        ContentDataFacet(
            hash=[Hash(hash_method="SHA256",
                        hash_value="d7a8fbb307d7809469ca9abcb0082e4f")],
            size_in_bytes=89400,
        ),
    ],
)

action = graph.create(InvestigativeAction,
    name="Filesystem triage scan",
    description=["Collected file listing from suspect workstation"],
    instrument=[tool],
    object=[file1, file2],
    start_time=datetime(2025, 6, 12, 9, 0, 0),
    end_time=datetime(2025, 6, 12, 9, 15, 0),
)

graph.write("filesystem-triage.jsonld")
```

## Expected JSON-LD Output

```json
{
    "@context": { "...": "..." },
    "@graph": [
        {
            "@id": "kb:Tool-...",
            "@type": "uco-tool:Tool",
            "uco-core:name": "Triage Collector",
            "uco-tool:version": "3.1.0",
            "uco-tool:toolType": "Filesystem Triage"
        },
        {
            "@id": "kb:ObservableObject-...",
            "@type": "uco-observable:ObservableObject",
            "uco-core:hasFacet": [
                {
                    "@id": "kb:FileFacet-...",
                    "@type": "uco-observable:FileFacet",
                    "uco-observable:fileName": "budget.xlsx",
                    "uco-observable:filePath": "/Users/jdoe/Documents/budget.xlsx",
                    "uco-observable:sizeInBytes": { "@type": "xsd:integer", "@value": "51200" }
                },
                {
                    "@id": "kb:ContentDataFacet-...",
                    "@type": "uco-observable:ContentDataFacet",
                    "uco-observable:hash": [
                        {
                            "@id": "kb:Hash-...",
                            "@type": "uco-types:Hash",
                            "uco-types:hashMethod": "SHA256",
                            "uco-types:hashValue": { "@type": "xsd:hexBinary", "@value": "e3b0c44298fc1c149afbf4c8996fb924" }
                        }
                    ],
                    "uco-observable:sizeInBytes": { "@type": "xsd:integer", "@value": "51200" }
                }
            ]
        },
        {
            "@id": "kb:InvestigativeAction-...",
            "@type": "case-investigation:InvestigativeAction",
            "uco-core:name": "Filesystem triage scan",
            "uco-action:instrument": [{ "@id": "kb:Tool-..." }],
            "uco-action:object": [{ "@id": "kb:ObservableObject-..." }, "..."]
        }
    ]
}
```

## Validation

```bash
case_validate --built-version case-1.4.0 filesystem-triage.jsonld
```
