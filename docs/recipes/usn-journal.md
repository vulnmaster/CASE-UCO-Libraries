# Windows USN Journal

> See [Recipe Index](INDEX.md) for all recipes.

Model entries from the Windows NTFS Update Sequence Number (USN) Change Journal — a system-maintained log of file-level operations (create, modify, rename, delete) on an NTFS volume. Each USN record carries one or more reason flags that describe what happened, making this a rich source for timeline analysis and incident response.

## Key classes

| Class | Role |
|---|---|
| `ObservableObject` + `EventRecordFacet` | Each USN record as a raw artifact from the journal |
| `Event` | The change event itself, with structured reason flags in `eventType` |
| `ObservableObject` + `FileFacet` + `NTFSFileFacet` | The file that was changed (with MFT entry ID) |
| `ObservableObject` + `FileFacet` (directory) | Directory nodes for nested containment |
| `ObservableObject` + `WindowsVolumeFacet` + `FileSystemFacet` | The NTFS volume |
| `ObservableRelationship` | Links: containment, rename before/after |
| `Dictionary` + `DictionaryEntry` | Structured USN metadata (USN number, MFT entry, reason flags) |
| `Investigation` + `InvestigativeAction` + `Tool` | Forensic provenance for the extraction |

## Pattern

```
Investigation ──────────────────────────────────────────────────────
    └── InvestigativeAction ("Parse USN Journal")
            ├── instrument ──▶ Tool (MFTECmd)
            ├── object ──▶ disk_image (ObservableObject)
            └── result ──▶ usn_journal ($UsnJrnl:$J)

Volume (ObservableObject + WindowsVolumeFacet + FileSystemFacet)
    ├── Directory ──▶ file (ObservableObject + FileFacet + NTFSFileFacet)
    └── $Extend ──▶ $UsnJrnl:$J
                       └── USN Record (ObservableObject + EventRecordFacet)

Event (per USN entry)
    ├── startTime = [timestamp]
    ├── eventType = ["USN_REASON_FILE_CREATE", "USN_REASON_CLOSE"]
    ├── eventContext ──▶ file (the changed file)
    │                ──▶ record (the raw USN record)
    └── eventAttribute ──▶ Dictionary
                              └── DictionaryEntry(key="USN_REASON_FILE_CREATE", value="true")
                              └── DictionaryEntry(key="USN_REASON_CLOSE", value="true")
                              └── DictionaryEntry(key="USN_NUMBER", value="109248")
                              └── DictionaryEntry(key="MFT_ENTRY_ID", value="48291")

Rename modeling (when applicable):
    old_file (ObservableObject, prior state) ◀── Renamed_From ── new_file
```

<details open><summary>Python</summary>

```python
from datetime import datetime, timezone, timedelta
from case_uco import CASEGraph
from case_uco.case.investigation import Investigation, InvestigativeAction
from case_uco.uco.tool import Tool
from case_uco.uco.core import Event
from case_uco.uco.observable import (
    ObservableObject, ObservableRelationship,
    FileFacet, FileSystemFacet, NTFSFileFacet,
    WindowsVolumeFacet, ContentDataFacet, EventRecordFacet,
)
from case_uco.uco.types import Dictionary, DictionaryEntry, Hash

graph = CASEGraph()
tz = timezone(timedelta(hours=...))  # from source

# --- Provenance ---
investigation = graph.create(Investigation,
    name="...",
    focus=["File system activity analysis"],
    investigation_form=["incident"],
    start_time=datetime(..., tzinfo=tz),
)

disk_image = graph.create(ObservableObject,
    name="...",
    has_facet=[
        FileFacet(file_name=["..."], file_path=["..."]),
        ContentDataFacet(hash=[Hash(hash_method="SHA256", hash_value="...")]),
    ],
)

tool = graph.create(Tool,
    name="MFTECmd",  # from source
    version="1.3.2.1",
    tool_type="USN Journal Parser",
)

extraction = graph.create(InvestigativeAction,
    name="Parse USN Journal from ...",
    start_time=datetime(..., tzinfo=tz),
    end_time=datetime(..., tzinfo=tz),
    instrument=[tool],
    object=[disk_image],
)

# --- NTFS Volume ---
volume = graph.create(ObservableObject,
    name="C: Volume",
    has_facet=[
        WindowsVolumeFacet(drive_letter="C:"),
        FileSystemFacet(file_system_type="NTFS", cluster_size=4096),
    ],
)

# --- Directories (nested containment) ---
parent_dir = graph.create(ObservableObject,
    name="Documents",
    has_facet=[FileFacet(
        file_name=["Documents"],
        file_path=["C:\\Users\\analyst\\Documents"],
        is_directory=[True],
    )],
)
graph.create(ObservableRelationship,
    is_directional=True,
    kind_of_relationship="Contained_Within",
    source=[parent_dir], target=volume,
)

# --- USN Journal ($UsnJrnl:$J) ---
usn_journal = graph.create(ObservableObject,
    name="$UsnJrnl:$J",
    has_facet=[FileFacet(
        file_name=["$UsnJrnl:$J"],
        file_path=["C:\\$Extend\\$UsnJrnl:$J"],
    )],
)
extraction.result.append(usn_journal)

# --- Per-entry: file + record + event ---
file_obj = graph.create(ObservableObject,
    name="report.docx",  # from source
    has_facet=[
        FileFacet(file_name=["report.docx"], file_path=["C:\\...\\report.docx"]),
        NTFSFileFacet(entry_id=48291),  # MFT entry number from source
    ],
)
graph.create(ObservableRelationship,
    is_directional=True,
    kind_of_relationship="Contained_Within",
    source=[file_obj], target=parent_dir,
)

record = graph.create(ObservableObject,
    name="USN Record 109248",
    has_facet=[EventRecordFacet(
        event_record_id="109248",  # USN number from source
        event_type="USN_CHANGE_JOURNAL",
        observable_created_time=datetime(..., tzinfo=tz),
        event_record_text="File report.docx was created and handle closed",
        event_record_service_name="NTFS USN Journal",
        event_record_device=volume,
    )],
)
graph.create(ObservableRelationship,
    is_directional=True,
    kind_of_relationship="Contained_Within",
    source=[record], target=usn_journal,
)

reason_flags = ["USN_REASON_FILE_CREATE", "USN_REASON_CLOSE"]  # from source
graph.create(Event,
    name="USN Change 109248: report.docx",
    start_time=[datetime(..., tzinfo=tz)],
    event_type=reason_flags,
    event_context=[file_obj, record],
    event_attribute=[Dictionary(entry=[
        DictionaryEntry(key=flag, value="true") for flag in reason_flags
    ] + [
        DictionaryEntry(key="USN_NUMBER", value="109248"),
        DictionaryEntry(key="MFT_ENTRY_ID", value="48291"),
    ])],
)

# --- Rename: model both old and new file states ---
new_file = graph.create(ObservableObject,
    name="system.log",
    has_facet=[
        FileFacet(file_name=["system.log"], file_path=["C:\\Logs\\system.log"]),
        NTFSFileFacet(entry_id=33107),
    ],
)
old_file = graph.create(ObservableObject,
    name="temp.log (prior state)",
    has_facet=[
        FileFacet(file_name=["temp.log"], file_path=["C:\\Logs\\temp.log"]),
        NTFSFileFacet(entry_id=33107),  # same MFT entry
    ],
)
graph.create(ObservableRelationship,
    is_directional=True,
    kind_of_relationship="Renamed_From",
    source=[new_file], target=old_file,
)
# ... then create the Event with both files in eventContext

graph.write("usn_journal.jsonld")
```

</details>

## Modeling decisions

### Structured reason flags, not free text

USN reason flags are the core forensic value of the journal. They are modeled in two complementary ways:

1. **`Event.eventType`** — a `list[str]` with each flag as a separate value. This makes SPARQL queries like "find all delete events" trivial:
   ```sparql
   SELECT ?event WHERE {
     ?event uco-core:eventType "USN_REASON_FILE_DELETE" .
   }
   ```

2. **`Dictionary` entries** — each flag as a unique key with value `"true"`, alongside numeric metadata (`USN_NUMBER`, `MFT_ENTRY_ID`). This avoids the SHACL key-uniqueness warning that occurs when using the same key for multiple values.

### Two-layer event model

Each USN entry produces two linked objects:

- An **`ObservableObject` + `EventRecordFacet`** — the raw USN record as a forensic artifact (with its USN number, timestamp, source device).
- A **`core:Event`** — the semantic change event with structured flags, linked to both the record and the affected file via `eventContext`.

This separates "what the artifact says" from "what happened," which supports both artifact-centric and event-centric queries.

### Rename before/after

Rename operations create two `ObservableObject` nodes sharing the same MFT entry ID but with different file names/paths. An `ObservableRelationship` with `kindOfRelationship="Renamed_From"` links new → old. Both file objects appear in the `Event.eventContext`, making the structural relationship queryable rather than trapped in free text.

### Directory hierarchy

Files are placed inside directory `ObservableObject` nodes (with `isDirectory=true`), which are themselves `Contained_Within` the volume. This preserves the actual file system structure rather than flattening everything directly under the volume.

### Forensic provenance

The graph records how the USN data was obtained:
- **`Investigation`** — the case context
- **`InvestigativeAction`** — the specific extraction step (with start/end times)
- **`Tool`** — the parser used (e.g., MFTECmd)
- **Evidence source** — the disk image as an `ObservableObject` with hash

The `InvestigativeAction.result` links to the extracted `$UsnJrnl:$J` object, establishing a chain from evidence through tool to parsed records.

## Common USN reason flags

| Flag | Meaning |
|---|---|
| `USN_REASON_DATA_OVERWRITE` | Data in the file was overwritten |
| `USN_REASON_DATA_EXTEND` | Data was appended to the file |
| `USN_REASON_DATA_TRUNCATION` | Data was removed from the end of the file |
| `USN_REASON_FILE_CREATE` | A new file was created |
| `USN_REASON_FILE_DELETE` | A file was deleted |
| `USN_REASON_RENAME_OLD_NAME` | The old name of a renamed file |
| `USN_REASON_RENAME_NEW_NAME` | The new name of a renamed file |
| `USN_REASON_SECURITY_CHANGE` | File permissions or ACLs were changed |
| `USN_REASON_BASIC_INFO_CHANGE` | File attributes or timestamps were changed |
| `USN_REASON_HARD_LINK_CHANGE` | A hard link was created or deleted |
| `USN_REASON_CLOSE` | The file handle was closed |

## Notes

- `Event.eventType` is `list[str]` — use one string per reason flag for queryability.
- Dictionary keys must be unique within a single Dictionary (SHACL validation enforces this). Use each flag name as a key rather than a repeated `USN_REASON_FLAG` key.
- `EventRecordFacet.eventRecordDevice` should reference the volume `ObservableObject`, not the disk image — the USN Journal is per-volume.
- The same MFT entry ID on two file objects (old name, new name) signals that they are the same underlying NTFS file record at different points in time.
- For high-volume USN data, partition by volume or time window rather than splitting mid-stream — USN records within a volume form a sequential log where cross-references (parent file reference numbers) need to resolve.
- See also: [Events and Authentication Logs](event.md) for the general Event/Dictionary pattern, [File System Forensics](file-system.md) for directory hierarchy patterns.
