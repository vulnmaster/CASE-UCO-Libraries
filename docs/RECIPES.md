# CASE/UCO SDK Recipes

Practical patterns for common digital forensics and cyber-investigation workflows. Each recipe shows how to model real-world data using the SDK.

For the full class reference, see [ONTOLOGY_REFERENCE.md](../ONTOLOGY_REFERENCE.md). For domain-to-class mapping, see [MAPPING_GUIDE.md](MAPPING_GUIDE.md). For performance guidance, see [PERFORMANCE_GUIDE.md](PERFORMANCE_GUIDE.md).

## Contents

- [Modeling a Forensic Tool and Its Output](#modeling-a-forensic-tool-and-its-output)
- [File System Forensics](#file-system-forensics)
- [Network Artifact Extraction](#network-artifact-extraction)
- [Mobile Device Forensics](#mobile-device-forensics)
- [Email and Messaging](#email-and-messaging)
- [Chain of Custody](#chain-of-custody)
- [Disk Image Acquisition](#disk-image-acquisition)
- [Browser History](#browser-history)
- [Timestamp Handling](#timestamp-handling)
- [Working with Extensions](#working-with-extensions)
- [Round-Trip: Serialize and Deserialize](#round-trip-serialize-and-deserialize)
- [Partitioning Large Datasets](#partitioning-large-datasets)

---

## Modeling a Forensic Tool and Its Output

Every forensic workflow starts with a tool and the investigation it supports.

```python
from case_uco import CASEGraph
from case_uco.uco.tool import Tool
from case_uco.case.investigation import Investigation, InvestigativeAction
from case_uco.uco.core import Bundle

graph = CASEGraph()

# The investigation
investigation = graph.create(Investigation,
    name="Case 2024-001",
    description="Unauthorized access investigation",
)

# The tool used
tool = graph.create(Tool,
    name="Autopsy",
    version="4.21.0",
    tool_type="Forensic Analysis",
)

# An action taken with the tool
action = graph.create(InvestigativeAction,
    name="Full disk analysis",
    description="Analyzed suspect disk image with Autopsy",
)

print(graph.serialize())
```

## File System Forensics

Model files, directories, and their metadata extracted from a disk image.

```python
from case_uco import CASEGraph
from case_uco.uco.observable import (
    File, FileFacet, ContentDataFacet,
    ObservableObject,
)
from datetime import datetime

graph = CASEGraph()

# A file found on the suspect's drive
evidence_file = graph.create(ObservableObject,
    has_facet=[
        FileFacet(
            file_name="quarterly_report.xlsx",
            file_path="/Users/suspect/Documents/quarterly_report.xlsx",
            size_in_bytes=245760,
            accessed_time=datetime(2024, 3, 15, 9, 30, 0),
            modified_time=datetime(2024, 3, 14, 16, 45, 0),
            created_time=datetime(2024, 1, 10, 8, 0, 0),
        ),
        ContentDataFacet(
            hash_method="SHA-256",
            hash_value="a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
            size_in_bytes=245760,
            mime_type="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
        ),
    ],
)

print(graph.serialize())
```

## Network Artifact Extraction

Model network connections, DNS lookups, and URLs found in forensic artifacts.

```python
from case_uco import CASEGraph
from case_uco.uco.observable import (
    ObservableObject,
    URLFacet,
    DomainNameFacet,
    IPv4AddressFacet,
    NetworkConnectionFacet,
)
from datetime import datetime

graph = CASEGraph()

# A suspicious URL
url = graph.create(ObservableObject,
    has_facet=[
        URLFacet(
            full_value="https://exfil-server.example.com/upload?session=abc123",
        ),
    ],
)

# The domain it resolved to
domain = graph.create(ObservableObject,
    has_facet=[
        DomainNameFacet(
            value="exfil-server.example.com",
        ),
    ],
)

# The IP address
ip = graph.create(ObservableObject,
    has_facet=[
        IPv4AddressFacet(
            value="198.51.100.42",
        ),
    ],
)

# A network connection to the server
connection = graph.create(ObservableObject,
    has_facet=[
        NetworkConnectionFacet(
            dst_port=443,
            src_port=52341,
            protocols=["TCP", "TLS", "HTTPS"],
            start_time=datetime(2024, 3, 15, 2, 14, 33),
            end_time=datetime(2024, 3, 15, 2, 14, 35),
        ),
    ],
)

print(graph.serialize())
```

## Mobile Device Forensics

Model mobile device artifacts including apps and their data.

```python
from case_uco import CASEGraph
from case_uco.uco.observable import (
    ObservableObject,
    DeviceFacet,
    ApplicationFacet,
    OperatingSystemFacet,
    AccountFacet,
)

graph = CASEGraph()

# The mobile device
phone = graph.create(ObservableObject,
    has_facet=[
        DeviceFacet(
            manufacturer="Samsung",
            model="Galaxy S24",
            serial="RZ8T30EXAMPLE",
            device_type="Mobile Phone",
        ),
        OperatingSystemFacet(
            name="Android",
            version="14",
        ),
    ],
)

# An app installed on the device
messaging_app = graph.create(ObservableObject,
    has_facet=[
        ApplicationFacet(
            application_identifier="com.example.messenger",
            name="Messenger App",
            version="5.2.1",
        ),
    ],
)

# A user account in the app
account = graph.create(ObservableObject,
    has_facet=[
        AccountFacet(
            account_identifier="user@example.com",
            account_type="email",
            is_active=True,
        ),
    ],
)

print(graph.serialize())
```

## Email and Messaging

Model email messages and their metadata.

```python
from case_uco import CASEGraph
from case_uco.uco.observable import (
    ObservableObject,
    EmailMessageFacet,
    EmailAccountFacet,
    EmailAddressFacet,
)
from datetime import datetime

graph = CASEGraph()

# Sender's email address
sender = graph.create(ObservableObject,
    has_facet=[
        EmailAddressFacet(
            address_value="suspect@example.com",
            display_name="John Doe",
        ),
    ],
)

# The email message
email = graph.create(ObservableObject,
    has_facet=[
        EmailMessageFacet(
            subject="Project Files",
            sent_time=datetime(2024, 3, 14, 16, 30, 0),
            is_read=True,
            content_type="text/plain",
            body="See attached files for the project deliverables.",
        ),
    ],
)

print(graph.serialize())
```

## Chain of Custody

Model evidence provenance, including who handled it and when.

```python
from case_uco import CASEGraph
from case_uco.uco.core import UcoObject
from case_uco.uco.action import Action
from case_uco.uco.identity import Identity
from case_uco.uco.observable import ObservableObject, DeviceFacet
from datetime import datetime

graph = CASEGraph()

# The examiner
examiner = graph.create(Identity,
    name="Jane Smith, CFCE",
)

# The evidence item
laptop = graph.create(ObservableObject,
    has_facet=[
        DeviceFacet(
            manufacturer="Dell",
            model="Latitude 5540",
            serial="SVC-TAG-12345",
        ),
    ],
)

# Seizure action
seizure = graph.create(Action,
    id="kb:action-seizure-001",
    name="Evidence seizure",
    description="Laptop seized from suspect's office, Rm 204",
    start_time=datetime(2024, 3, 10, 14, 22, 0),
    end_time=datetime(2024, 3, 10, 14, 35, 0),
)

# Transfer to lab
transfer = graph.create(Action,
    id="kb:action-transfer-001",
    name="Evidence transfer to forensic lab",
    description="Transported in evidence bag #EV-2024-0042",
    start_time=datetime(2024, 3, 10, 15, 0, 0),
    end_time=datetime(2024, 3, 10, 16, 30, 0),
)

print(graph.serialize())
```

## Disk Image Acquisition

Model the imaging process and resulting forensic image.

```python
from case_uco import CASEGraph
from case_uco.uco.observable import (
    ObservableObject,
    ContentDataFacet,
    DiskFacet,
    ImageFacet,
    FileFacet,
)
from case_uco.uco.tool import Tool
from case_uco.case.investigation import InvestigativeAction
from datetime import datetime

graph = CASEGraph()

# Imaging tool
tool = graph.create(Tool,
    name="FTK Imager",
    version="4.7.1",
)

# Source disk
source_disk = graph.create(ObservableObject,
    has_facet=[
        DiskFacet(
            disk_size=512110190592,
            disk_type="SSD",
        ),
    ],
)

# Resulting forensic image
forensic_image = graph.create(ObservableObject,
    has_facet=[
        FileFacet(
            file_name="suspect_laptop.E01",
            file_path="/evidence/case-2024-001/suspect_laptop.E01",
            size_in_bytes=512110190592,
        ),
        ContentDataFacet(
            hash_method="SHA-256",
            hash_value="b5bb9d8014a0f9b1d61e21e796d78dccdf1352f23cd32812f4850b878ae4944c",
        ),
    ],
)

# Imaging action
imaging = graph.create(InvestigativeAction,
    name="Disk imaging",
    description="Created forensic image of suspect laptop SSD",
    start_time=datetime(2024, 3, 11, 9, 0, 0),
    end_time=datetime(2024, 3, 11, 11, 45, 0),
)

print(graph.serialize())
```

## Browser History

Model browser artifacts including history, bookmarks, and cookies.

```python
from case_uco import CASEGraph
from case_uco.uco.observable import (
    ObservableObject,
    URLFacet,
    URLHistoryFacet,
    URLVisit,
    BrowserBookmarkFacet,
)
from datetime import datetime

graph = CASEGraph()

# A visited URL
visited = graph.create(ObservableObject,
    has_facet=[
        URLFacet(
            full_value="https://internal-wiki.example.com/confidential/strategy",
        ),
        URLHistoryFacet(
            browser_information="Chrome 122.0.6261.112",
            url_history_entry=[
                URLVisit(
                    visit_time=datetime(2024, 3, 14, 10, 15, 0),
                    visit_duration_seconds=342,
                ),
                URLVisit(
                    visit_time=datetime(2024, 3, 15, 8, 45, 0),
                    visit_duration_seconds=128,
                ),
            ],
        ),
    ],
)

# A bookmark
bookmark = graph.create(ObservableObject,
    has_facet=[
        BrowserBookmarkFacet(
            url_targeted="https://filehosting.example.com",
            bookmark_path="Bookmarks Bar/Tools",
            accessed_time=datetime(2024, 3, 13, 22, 10, 0),
        ),
    ],
)

print(graph.serialize())
```

## Timestamp Handling

CASE/UCO uses `xsd:dateTime` for all timestamps. The SDK handles conversion automatically.

```python
from case_uco import CASEGraph
from case_uco.uco.observable import ObservableObject, FileFacet
from datetime import datetime, timezone, timedelta

graph = CASEGraph()

# UTC timestamp (recommended)
utc_time = datetime(2024, 3, 15, 14, 30, 0, tzinfo=timezone.utc)

# Timezone-aware timestamp
eastern = timezone(timedelta(hours=-5))
local_time = datetime(2024, 3, 15, 9, 30, 0, tzinfo=eastern)

# Unix epoch conversion
epoch_seconds = 1710510600
epoch_time = datetime.fromtimestamp(epoch_seconds, tz=timezone.utc)

file_obj = graph.create(ObservableObject,
    has_facet=[
        FileFacet(
            file_name="evidence.dat",
            created_time=utc_time,
            modified_time=local_time,
            accessed_time=epoch_time,
        ),
    ],
)

output = graph.serialize()
# Timestamps are serialized as xsd:dateTime typed literals:
# {"@type": "xsd:dateTime", "@value": "2024-03-15T14:30:00+00:00"}
```

## Working with Extensions

Use extension ontologies (like `toolcap`) to model domain-specific concepts.

### Using scaffolded classes

```bash
# Generate starter code from your extension's TTL files
case-uco-generate scaffold \
  --extension extensions/toolcap/toolcap.ttl extensions/toolcap/toolcap-shapes.ttl \
  --output-dir my_project/ \
  --lang python
```

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

### Using inline classes

If you don't need scaffolded code, define extension classes inline:

```python
from dataclasses import dataclass, field
from typing import Optional

@dataclass
class ToolCapability:
    CLASS_IRI: str = "http://example.org/ontology/toolcap/ToolCapability"
    NAMESPACE_PREFIX: str = "toolcap"

    tool_version: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:toolVersion',
    })
    supported_platform: list[str] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:supportedPlatform',
    })
```

## Round-Trip: Serialize and Deserialize

The Python SDK supports typed deserialization via `from_jsonld()`.

```python
from case_uco import CASEGraph
from case_uco.uco.tool import Tool

# Build and serialize
graph = CASEGraph()
graph.create(Tool, name="Tool A", version="4.0")
json_str = graph.serialize()

# Deserialize back to typed objects
graph2, objects = CASEGraph.from_jsonld(json_str)

for obj in objects:
    if isinstance(obj, Tool):
        print(f"Tool: {obj.name} v{obj.version}")
    else:
        print(f"Untyped: {type(obj).__name__}")

# Extension classes work too — pass them as extra_classes
# graph2, objects = CASEGraph.from_jsonld(json_str, extra_classes=[ToolCapability])
```

## Partitioning Large Datasets

When processing large evidence sets (e.g., full file system forensics), partition your data into manageable chunks.

```python
from case_uco import CASEGraph
from case_uco.uco.observable import ObservableObject, FileFacet

graph = CASEGraph()

# Simulate adding many files from a filesystem scan
for i in range(50000):
    graph.create(ObservableObject,
        has_facet=[
            FileFacet(file_name=f"file_{i}.dat", size_in_bytes=i * 100),
        ],
    )

# Check estimated triple count
print(f"Estimated triples: {graph.estimate_triples()}")

# Split into chunks of 5,000 objects each
chunks = graph.split(max_objects=5000)
print(f"Split into {len(chunks)} partitions")

# Write each partition to a separate file
for i, chunk in enumerate(chunks):
    chunk.write(f"evidence_part_{i:03d}.jsonld")
    print(f"  Part {i}: {len(chunk)} objects, ~{chunk.estimate_triples()} triples")

# Later, merge them back for analysis
merged = CASEGraph.merge_files(
    [f"evidence_part_{i:03d}.jsonld" for i in range(len(chunks))]
)
print(f"Merged: {len(merged)} objects")
```

### Loading partitions into a graph database

```python
from case_uco import CASEGraph

# Process partitions individually — no need to load everything at once
for part_file in sorted(pathlib.Path(".").glob("evidence_part_*.jsonld")):
    graph = CASEGraph()
    graph.load_file(str(part_file))

    # Process each partition (e.g., load into SPARQL endpoint)
    triples = graph.estimate_triples()
    print(f"{part_file.name}: {len(graph)} objects, ~{triples} triples")

    # Your graph database loading code here
    # sparql_client.load(graph.serialize())
```

See [PERFORMANCE_GUIDE.md](PERFORMANCE_GUIDE.md) for benchmark data on serialization times, memory usage, and validation performance across different dataset sizes.
