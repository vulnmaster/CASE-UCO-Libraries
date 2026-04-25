# Online Grooming Chat Modeling

> See [Recipe Index](INDEX.md) for all recipes.

Model online grooming chat interactions using core CASE/UCO types and [CAC Ontology](https://cacontology.projectvic.org/) extension classes. This recipe covers the evidence and behavioral-interpretation layers. For the institutional reporting and investigation workflow, see [cybertip-ncmec-workflow.md](cybertip-ncmec-workflow.md). Based on the [snapchat-grooming-cybertip](../../examples/snapchat-grooming-cybertip.jsonld) example.

## Semantic layers

This pattern separates modeling into three distinct layers:

1. **Observable evidence** — raw digital artifacts (`Message`, `MessageThread`, `ApplicationAccount`, `RasterPicture`) with their `Facet` properties. This layer records *what was captured*.
2. **CAC behavioral interpretation** — domain-specific classification (`OnlineGrooming`, `GroomingMessage`, `SexualSolicitation`, `SecrecyRequest`, `VictimResponse`, `GroomingPhase` types) and role assignment (`OffenderRole`, `VictimRole`). This layer records *what the evidence means* in a child exploitation context.
3. **Institutional workflow** — reporting and investigative chain (`AutomatedDetectionAction`, `NCMECCybertipReport`, `InvestigationTrigger`, `CACInvestigation`). This layer records *how the system responded*. See [cybertip-ncmec-workflow.md](cybertip-ncmec-workflow.md).

## Key classes

| Class | Layer | Role |
|---|---|---|
| `Message` + `MessageFacet` | Evidence | Individual chat messages with sender, recipient, timestamp |
| `MessageThread` + `MessageThreadFacet` | Evidence | Chat session containers with participant lists |
| `ApplicationAccount` + `AccountFacet` | Evidence | User accounts on the platform (ownership via `uco-observable:owner`) |
| `RasterPicture` / `ProducedImage` | Evidence | CSAM image artifact |
| `Identity` + `SimpleNameFacet` | Evidence | Real-world person or organization |
| `OffenderRole` / `VictimRole` | Interpretation | CAC role types borne by Identity nodes via `has-role` Relationship |
| `OnlineGrooming` | Interpretation | Overarching grooming behavior with `targetsVictim`, `primaryPlatform`, `exhibitsPattern`, `hasPhase` |
| `GroomingMessage` / `SexualSolicitation` / `SecrecyRequest` | Interpretation | Message-level grooming classification with `groomingStage`, `evidencesPhase`, `emotionalTone`, `explicitnessLevel` |
| `VictimResponse` | Interpretation | Victim compliance tracking with `victimCompliance`, `seekingHelp` |
| `GroomingPhase` subtypes | Interpretation | Temporal grooming phases with `hasPhaseBeginPoint` / `hasPhaseEndPoint` |
| `EscalationPattern` | Interpretation | Cross-session escalation pattern with `escalationRate`, `patternConfidence` |

## Canonical pattern

```
LAYER 1 — EVIDENCE (raw observables):
  Identity (bearer)
  ApplicationAccount ──owner──▶ Identity (via AccountFacet)
  ApplicationAccount ──participates in──▶ MessageThread
  Message ──from/to──▶ ApplicationAccount
  Message ──in thread via──▶ sessionID match to MessageThread
  Message ──Attachment_Of──▶ RasterPicture

LAYER 2 — INTERPRETATION (CAC behavioral semantics):
  Identity ──has-role──▶ OffenderRole (Subject + OffenderRole)
  Identity ──has-role──▶ VictimRole (Victim + VictimRole)

  OnlineGrooming
      ├── targetsVictim ──▶ Identity (victim)
      ├── primaryPlatform ──▶ SocialMediaPlatform
      ├── exhibitsPattern ──▶ EscalationPattern
      └── hasPhase ──▶ InitialContactPhase → TrustBuildingPhase
                        → IsolationPhase → SexualizationPhase

  Each Message is multi-typed with its CAC interpretation:
      Message + GroomingMessage   (groomingStage, evidencesPhase, emotionalTone)
      Message + SecrecyRequest    (groomingStage = "isolation", evidencesPhase)
      Message + SexualSolicitation (groomingStage = "sexualization", evidencesPhase)
      Message + VictimResponse    (groomingStage, evidencesPhase, victimCompliance)
```

## Role vs. identity separation

The canonical pattern uses a **bearer → role** structure:

- **Identity nodes** (`uco-identity:Identity`) represent the real-world person. They carry `SimpleNameFacet` and are the `owner` referenced on `AccountFacet`. Identity nodes do **not** carry CAC role types.
- **Role objects** carry both CASE investigation roles (`case-investigation:Subject`, `uco-victim:Victim`) and CAC domain roles (`cacontology:OffenderRole`, `cacontology:VictimRole`) as multi-typed objects.
- **Identity → Role** is connected via a `has-role` Relationship.

This is an *interpretive* assertion: the same real-world person may bear different roles across investigations or time periods. Role assignment belongs in Layer 2, not Layer 1.

## Phase membership

Phase membership is modeled at two granularities:

### Message-level (per-utterance)

Every `GroomingMessage` and `VictimResponse` carries two properties:

1. **`groomingStage`** — a controlled string for easy SPARQL filtering (e.g., `"isolation"`).
2. **`evidencesPhase`** — an IRI link to the specific `GroomingPhase` object (e.g., `kb:phase-isolation`). This makes phase membership first-class and queryable without string matching.

### Behavior-level (temporal bounds)

Explicit `GroomingPhase` objects model the temporal extent of each phase and are linked from the `OnlineGrooming` behavior via `cacontology:hasPhase`.

| `groomingStage` value | Phase class | `evidencesPhase` target | Typical behaviors |
|---|---|---|---|
| `initial_contact` | `InitialContactPhase` | `kb:phase-initial-…` | Age probing, flattery, rapport building |
| `trust_building` | `TrustBuildingPhase` | `kb:phase-trust-…` | Emotional bonding, "you're special" language |
| `isolation` | `IsolationPhase` | `kb:phase-isolation-…` | Secrecy demands, separation from support systems |
| `sexualization` | `SexualizationPhase` | `kb:phase-sexualization-…` | Sexual solicitation, image requests, explicit content |
| `maintenance` | `MaintenancePhase` | `kb:phase-maintenance-…` | Continued control, requests for more material |

## Thread membership

Thread membership is currently implicit through `sessionID` matching between `MessageFacet` and `MessageThread` sessions. UCO does not define a direct `message` property on `MessageThreadFacet`. A future CASE/UCO change proposal or CAC extension property should formalize this link. See [change-proposal.md](change-proposal.md) for the proposal process.

## Controlled vocabulary guidance

The following properties use string values that should be treated as controlled vocabularies for cross-case consistency. A future improvement is to promote these to SKOS concepts or IRI-based named individuals.

- **`groomingStage`**: `initial_contact`, `trust_building`, `isolation`, `sexualization`, `maintenance`
- **`emotionalTone`**: `caring`, `seductive`, `manipulative`, `threatening`, `coercive`
- **`explicitnessLevel`**: `none`, `suggestive`, `explicit`, `graphic`
- **`victimCompliance`**: `resistant`, `hesitant`, `compliant`, `eager`
- **`rolePlayingTactic`**: `peer`, `mentor`, `romantic_interest`, `authority_figure`
- **`evidenceValue`**: `high`, `medium`, `low`

## Direct properties vs. generic Relationships

Prefer direct object properties from the CAC ontology over generic `Relationship` nodes:

| Instead of `Relationship` with... | Use direct property | On class |
|---|---|---|
| `kindOfRelationship: "Targets"` | `cacontology-grooming:targetsVictim` | `OnlineGrooming` → `Identity` |
| `kindOfRelationship: "Observed_In"` | `cacontology-grooming:exhibitsPattern` | `OnlineGrooming` → `EscalationPattern` |
| `kindOfRelationship: "Phase_Of"` | `cacontology-grooming:evidencesPhase` | `GroomingMessage` → `GroomingPhase` |

When a direct CASE/UCO property already captures the semantics, prefer it over adding a second generic relation. For example, `uco-observable:owner` on `AccountFacet` already captures account ownership — do not also add an `Owner_Of` Relationship.

Reserve generic `Relationship` nodes for semantics without a direct predicate (e.g., `has-role`, `Located_At`, `Attachment_Of`, `Performed_By`).

<details open><summary>Python</summary>

```python
from case_uco import CASEGraph
from case_uco.uco.core import Relationship
from case_uco.uco.observable import (
    ObservableObject, Message, MessageFacet,
    ApplicationFacet, AccountFacet, ApplicationAccountFacet,
    ContentDataFacet, RasterPictureFacet,
)
from datetime import datetime, timezone, timedelta

tz = timezone(timedelta(hours=-5))

graph = CASEGraph(extra_context={
    "cacontology": "https://cacontology.projectvic.org#",
    "cacontology-grooming": "https://cacontology.projectvic.org/grooming#",
    "cacontology-production": "https://cacontology.projectvic.org/production#",
    "cacontology-platforms": "https://cacontology.projectvic.org/platforms#",
})

# --- LAYER 1: Evidence ---

snapchat = graph.create(ObservableObject, name="Snapchat",
    extra_types=["cacontology-platforms:SocialMediaPlatform"],
    has_facet=[ApplicationFacet(application_identifier="com.snapchat.android")],
)

offender_identity = graph.create("uco-identity:Identity", name="John Doe")
victim_identity = graph.create("uco-identity:Identity", name="Jane Minor")

offender_account = graph.create(ObservableObject,
    has_facet=[
        AccountFacet(account_identifier="offender_user_2025",
                     owner=offender_identity),
        ApplicationAccountFacet(application=snapchat),
    ],
)

thread = graph.create(ObservableObject,
    extra_types=["uco-observable:MessageThread"],
    has_facet=[{"@type": "uco-observable:MessageThreadFacet",
                "uco-observable:participant": [
                    {"@id": offender_account.id},
                    {"@id": victim_identity.id}]}],
)

# --- LAYER 2: Interpretation ---

# Role objects (bearer → role pattern)
offender_role = graph.add_node("kb:offender-role", [
    "case-investigation:Subject", "cacontology:OffenderRole",
], {"uco-core:name": "Offender - Subject of Investigation"})

victim_role = graph.add_node("kb:victim-role", [
    "uco-victim:Victim", "cacontology:VictimRole",
], {"uco-core:name": "Child Victim of Grooming"})

graph.create(Relationship, source=[offender_identity], target=offender_role,
    kind_of_relationship="has-role", is_directional=True)
graph.create(Relationship, source=[victim_identity], target=victim_role,
    kind_of_relationship="has-role", is_directional=True)

# Grooming phases with temporal bounds
initial_phase = graph.add_node("kb:phase-initial",
    "cacontology-grooming:InitialContactPhase", {
    "uco-core:name": "Initial Contact Phase",
    "cacontology:hasPhaseBeginPoint": "2025-04-10T15:30:00-05:00",
    "cacontology:hasPhaseEndPoint": "2025-04-10T15:42:00-05:00",
})

# OnlineGrooming with direct properties
grooming = graph.add_node("kb:grooming-1", "cacontology-grooming:OnlineGrooming", {
    "cacontology-grooming:targetsVictim": {"@id": victim_identity.id},
    "cacontology-grooming:primaryPlatform": {"@id": snapchat.id},
    "cacontology:hasPhase": [{"@id": "kb:phase-initial"}],
})

# Grooming messages with dual phase membership
msg = graph.add_node("kb:msg-1", [
    "uco-observable:Message", "cacontology-grooming:GroomingMessage",
], {
    "cacontology-grooming:groomingStage": "initial_contact",
    "cacontology-grooming:evidencesPhase": {"@id": "kb:phase-initial"},
    "cacontology-grooming:emotionalTone": "caring",
    "cacontology-grooming:explicitnessLevel": "none",
    "uco-core:hasFacet": [{
        "@type": "uco-observable:MessageFacet",
        "uco-observable:messageText": "Hey! How old are you?",
        "uco-observable:sentTime": "2025-04-10T15:30:00-05:00",
        "uco-observable:from": {"@id": offender_account.id},
        "uco-observable:to": [{"@id": victim_identity.id}],
        "uco-observable:sessionID": "snap-session-20250410-001",
    }],
})

graph.write("grooming_chat.jsonld")
```

</details>

## Notes

- **CAC extension activation:** The CAC extension must be activated with `CASE_UCO_EXTENSIONS=cac` and requires `pip install case-uco-cac`.
- **`GroomingMessage` extends `uco-observable:Message`** — it inherits all `MessageFacet` properties (from, to, sentTime, messageText) and adds grooming-specific fields: `explicitnessLevel`, `emotionalTone`, `groomingStage`, `evidencesPhase`, and `contentType`.
- **`OffenderRole` and `VictimRole` are gUFO Roles** — they are borne by `Identity` nodes through `has-role` Relationships, not multi-typed onto Identity nodes directly. Role assignment is an interpretive assertion (Layer 2), not raw evidence.
- **`evidencesPhase`** is an IRI-based object property linking each grooming message to its `GroomingPhase` object. It complements the `groomingStage` string literal for formal reasoning and avoids reliance on string matching alone.
- **Grooming phase progression** is modeled through both explicit `GroomingPhase` objects (with temporal bounds) linked from `OnlineGrooming` via `hasPhase`, and per-message `groomingStage`/`evidencesPhase` for queryability ("which messages evidence isolation tactics?").
- **Thread membership** is implicit through `sessionID` matching between `MessageFacet` and `MessageThread` sessions. UCO does not currently define a direct `message` property on `MessageThreadFacet`. This is an identified gap for a future UCO change proposal.
- **Account ownership** is expressed via `uco-observable:owner` on `AccountFacet`. Do not duplicate this with a generic `Owner_Of` Relationship.
- **Without the CAC extension**, fall back to core CASE/UCO: use `Investigation` + `InvestigativeAction` + `Message` + `MessageFacet` + `Victim` + `Subject`. The core types cover the forensic workflow; CAC adds domain-specific semantics for child exploitation cases.

### Validation

```bash
case_validate --built-version case-1.4.0 \
  --ontology-graph extensions/cac/ontology/ontology/cacontology-core-spine.ttl \
  --ontology-graph extensions/cac/ontology/ontology/cacontology-grooming.ttl \
  --inference rdfs --allow-infos \
  grooming_chat.jsonld
```
