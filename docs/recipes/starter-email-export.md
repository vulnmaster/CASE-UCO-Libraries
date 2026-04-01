# Starter Kit: Email Export

> See [Recipe Index](INDEX.md) for all recipes.

Map an email export (headers, body, attachments) into a CASE/UCO graph.

## Source Input Shape

A JSON record representing one exported email:

```json
{
  "message_id": "<abc123@mail.example.com>",
  "from": { "address": "suspect@example.com", "name": "John Doe" },
  "to": [{ "address": "partner@example.com", "name": "Jane Smith" }],
  "subject": "Quarterly numbers",
  "body": "See attached spreadsheet for Q2 results.",
  "sent": "2025-06-15T09:30:00Z",
  "attachments": [
    { "filename": "q2-report.xlsx", "size": 142336, "sha256": "9f86d081884c7d659a2feaa0c55ad015..." }
  ]
}
```

## Modeling Choices

| Concept | CASE/UCO Class | Why |
|---|---|---|
| The email | `ObservableObject` + `EmailMessageFacet` | Central artifact; facet holds subject, body, timestamps, and references to sender/recipients |
| Sender & recipients | `ObservableObject` + `EmailAddressFacet` | Each address is its own observable so it can be linked across multiple emails |
| Attachments | `ObservableObject` + `FileFacet` + `ContentDataFacet` | Attachments are files with their own metadata and hashes |

## Anti-Patterns

- **Modeling addresses as strings.** Do NOT put `"suspect@example.com"` directly in `EmailMessageFacet.from_`. Create an `ObservableObject` with `EmailAddressFacet` and reference it. This enables cross-email address correlation.
- **Embedding the body in the wrong field.** Use `EmailMessageFacet.body` for plain-text content. For raw RFC 5322 source, use `body_raw` (an `ObservableObject` reference). Do not mix them.
- **Forgetting attachment hashes.** Attachments without `ContentDataFacet` lose integrity verification. Always include at least one hash.

## Complete Code

```python
from datetime import datetime
from case_uco import CASEGraph
from case_uco.uco.types import Hash
from case_uco.uco.observable import (
    ObservableObject, EmailMessageFacet, EmailAddressFacet,
    FileFacet, ContentDataFacet,
)

graph = CASEGraph()

sender = graph.create(ObservableObject,
    has_facet=[EmailAddressFacet(
        address_value="suspect@example.com",
        display_name="John Doe",
    )],
)

recipient = graph.create(ObservableObject,
    has_facet=[EmailAddressFacet(
        address_value="partner@example.com",
        display_name="Jane Smith",
    )],
)

attachment = graph.create(ObservableObject,
    has_facet=[
        FileFacet(
            file_name="q2-report.xlsx",
            size_in_bytes=142336,
        ),
        ContentDataFacet(
            hash=[Hash(hash_method="SHA256",
                        hash_value="9f86d081884c7d659a2feaa0c55ad015")],
            size_in_bytes=142336,
        ),
    ],
)

email = graph.create(ObservableObject,
    has_facet=[EmailMessageFacet(
        from_=sender,
        to=[recipient],
        subject="Quarterly numbers",
        body="See attached spreadsheet for Q2 results.",
        sent_time=datetime(2025, 6, 15, 9, 30, 0),
        is_read=True,
        content_type="multipart/mixed",
        message_id="<abc123@mail.example.com>",
    )],
)

graph.write("email-export.jsonld")
```

## Expected JSON-LD Output

```json
{
    "@context": { "...": "..." },
    "@graph": [
        {
            "@id": "kb:ObservableObject-...",
            "uco-core:hasFacet": [{
                "@type": "uco-observable:EmailAddressFacet",
                "uco-observable:addressValue": "suspect@example.com",
                "uco-observable:displayName": "John Doe"
            }]
        },
        {
            "@id": "kb:ObservableObject-...",
            "uco-core:hasFacet": [{
                "@type": "uco-observable:EmailAddressFacet",
                "uco-observable:addressValue": "partner@example.com"
            }]
        },
        {
            "@id": "kb:ObservableObject-...",
            "uco-core:hasFacet": [
                { "@type": "uco-observable:FileFacet", "uco-observable:fileName": "q2-report.xlsx" },
                {
                    "@type": "uco-observable:ContentDataFacet",
                    "uco-observable:hash": [{
                        "@type": "uco-types:Hash",
                        "uco-types:hashMethod": "SHA256",
                        "uco-types:hashValue": { "@type": "xsd:hexBinary", "@value": "9f86d081884c7d659a2feaa0c55ad015" }
                    }]
                }
            ]
        },
        {
            "@id": "kb:ObservableObject-...",
            "uco-core:hasFacet": [{
                "@type": "uco-observable:EmailMessageFacet",
                "uco-observable:from": { "@id": "kb:ObservableObject-..." },
                "uco-observable:to": [{ "@id": "kb:ObservableObject-..." }],
                "uco-observable:subject": "Quarterly numbers",
                "uco-observable:body": "See attached spreadsheet for Q2 results.",
                "uco-observable:sentTime": { "@type": "xsd:dateTime", "@value": "2025-06-15T09:30:00" }
            }]
        }
    ]
}
```

## Validation

```bash
case_validate --built-version case-1.4.0 email-export.jsonld
```
