# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.3.0] - 2026-03-26

### Added

#### Toolcap Extension v0.2.0 — Forensic Tool Benchmarking and Access Control

The `extensions/toolcap/` extension ontology has been expanded from a simple
capability matrix into a full benchmarking and access-control framework for
forensic tool evaluation. The extension now supports vendor-claimed vs.
independently benchmarked capability data, structured platform specifications,
point-in-time benchmark observations, and security/licensing access restrictions.

- **3 new classes:**
  - `BenchmarkObservation` (`uco-core:UcoObject`) — a single point-in-time
    record of testing a forensic tool against an application, with optional
    metrics for pass/fail, completeness, accuracy, false positives/negatives,
    processing duration, dataset size, and parsed/missed observable categories
  - `PlatformSpecification` (`uco-core:UcoObject`) — structured replacement for
    the deprecated `supportedPlatform` string, capturing operating system, OS
    version, device model, and extraction method(s) including BFU (Before First
    Unlock) acquisition
  - `AccessRestriction` (`uco-core:UcoObject`) — security, licensing,
    classification, operational security, or legal authority constraints on tool
    usage, with optional link to `case-investigation:Authorization`
- **New properties on `ToolCapability`:**
  - `claimedByVendor` / `verifiedByBenchmark` — distinguish vendor-reported
    capabilities from independently tested ones
  - `applicationVersion` — target application version(s) the capability applies to
  - `dataFormatVersion` — data storage format version(s) (e.g., `.pst` vs `.nst`)
  - `supportsPlatform` — object property linking to `PlatformSpecification`
    instances (replaces the deprecated `supportedPlatform` string)
  - `hasAccessRestriction` — links to `AccessRestriction` instances
  - `hasObservation` — links to `BenchmarkObservation` instances (append-only)
- **Inverse property pair:** `hasObservation` / `capability` declared with
  `owl:inverseOf` for bidirectional traversal between capabilities and their
  benchmark evidence
- **`hasCapability`** — new object property on `CapabilityMatrix`, declared as
  `rdfs:subPropertyOf uco-core:object` for semantically precise matrix membership
- **Deprecated** `supportedPlatform` datatype property with `owl:deprecated true`;
  retained for backward compatibility with v0.1.0 data
- **14 benchmark metric properties** (all optional): `parseSuccess`,
  `completenessScore`, `accuracyScore`, `falsePositiveCount`,
  `falseNegativeCount`, `processingDuration`, `datasetSizeInBytes`,
  `parsedCategory`, `missedCategory`, `benchmarkNotes`, `benchmarkDate`,
  `testedToolVersion`, `testedApplicationVersion`, `testedDataFormatVersion`
- **SHACL shapes** for all new classes with value range constraints
  (`sh:minInclusive`/`sh:maxInclusive` for score properties)
- **Updated exemplar** (`toolcap-exemplar.ttl`) with a realistic scenario:
  two tools, a messaging app, and Microsoft Outlook with both `.pst` (pass)
  and `.nst` (fail) data format benchmarks, BFU acquisition, and
  law-enforcement-only access restrictions
- **Updated Python example** (`example_capability_matrix.py`) demonstrating all
  new classes including benchmark observations, platform specifications, and
  access restrictions
- All exemplar data validated with `case_validate --built-version case-1.4.0`
  (`Conforms: True`)

## [1.2.0] - 2026-03-26

### Added

#### Gap Detection and Change Proposals

- **Agent-assisted gap detection** — when `search_classes`, `find_classes_for_domain`,
  or `get_class_details` returns no adequate match, the AI agent proactively suggests
  drafting a change proposal for the missing concept
- **Two new MCP tools** for the change proposal workflow:
  - `check_existing_proposals(concept)` — searches open GitHub issues in both the
    [UCO](https://github.com/ucoProject/UCO/issues) and
    [CASE](https://github.com/casework/CASE/issues) repositories for prior proposals
    matching the concept; falls back gracefully when GitHub is unreachable
  - `draft_change_proposal(concept, description, scenario, ...)` — generates a
    filled-in change proposal markdown file using the official CDO template, including
    auto-generated competency questions, draft SPARQL queries, and example JSON-LD;
    writes the result to `change_proposals/`
- **UCO vs. CASE auto-triage** — `suggest_target_repo()` in `domain_index.py`
  determines whether a proposed concept belongs in UCO (general cyber-domain) or CASE
  (investigation-specific) based on keyword analysis, with reasoning explanation
- **Change proposal template** at `docs/templates/change-proposal-template.md` —
  the official CDO issue template for structured proposal submissions
- **Change proposal recipe** at `docs/recipes/change-proposal.md` — step-by-step
  workflow covering gap confirmation, existing proposal checks, UCO vs. CASE
  determination, proposal drafting, example data creation, and local extension
  scaffolding
- **`change_proposals/` directory** for locally-drafted proposals with README
  explaining the workflow and submission process
- Updated Cursor rules (`.cursor/rules/case-uco-sdk.mdc`) with gap detection
  guidance and change proposal workflow integration
- Updated recipe index with "Contributing to the ontology" section

#### Example Change Proposal

- `change_proposals/cryptocurrency-address-and-sanctions-designation.md` — a complete
  worked example proposing `CryptocurrencyAddressFacet`, `CryptocurrencyTypeVocab`,
  and `SanctionsDesignationFacet` for modeling blockchain addresses placed on
  government sanctions lists, with properties mapped to the
  [Chainalysis Sanctions Screening API](https://www.chainalysis.com/free-cryptocurrency-sanctions-screening-tools/)

## [1.1.0] - 2026-03-25

### Added

#### Testing & Quality

- **Exhaustive class instantiation tests** for all four languages — every generated class is constructed with defaults to catch broken imports, missing defaults, and inheritance issues across the entire object model (428 classes)
  - Python: dynamic test using the registry (`test_exhaustive.py`)
  - C#, Java, Rust: auto-generated by the code generator, stays in sync with the ontology
- **Smoke test binaries** for compiled languages — standalone executables that
  import the library, create objects, and serialize, proving the built artifacts
  actually link and run (C# `CaseUco.Smoke`, Java `SmokeTest`, Rust `examples/smoke.rs`)
- **Python strict type checking** with mypy (`[tool.mypy]` in `pyproject.toml`)
  - PEP 561 `py.typed` marker for downstream type checker support
  - `TYPE_CHECKING` imports for cross-module type references in generated code
  - `datetime` and `Any` imports added to generated modules where needed
- **Rust clippy** lint integration (`cargo clippy -- -D warnings`)
- New Makefile targets: `lint`, `typecheck-python`, `lint-rust`, `smoke`,
  `smoke-csharp`, `smoke-java`, `smoke-rust`, `check` (full local verification)
- CI pipeline additions: mypy type checking, clippy linting, smoke tests for
  all three compiled languages

### Fixed

- Generated Python classes now use `Optional[T]` for all non-list fields,
  matching the runtime behavior where all fields default to `None` (required-field validation is enforced by `CASEGraph`, not at construction)
- Generated Python modules now import `datetime` and cross-module types correctly
  for static type analysis
- Rust builder `build()` no longer panics on unset required fields — required-field validation is deferred to graph creation time, consistent with Python
- `graph.py` type annotation fixes: parameterized `dict`/`Field` generics, explicit metadata typing
- Rust `graph.rs` clippy fixes: `std::io::Error::other()`, redundant closure removal
- Python code generator now detects and avoids cyclic `TYPE_CHECKING` imports
  between modules with mutual dependencies (e.g., `uco.core` ↔ `uco.types`)
- C# and Java exhaustive tests use direct instantiation instead of `graph.Add()`
  to avoid required-field validation failures on classes like `SubjectActionLifecycle`
- Java `SmokeTest` no longer chains inherited setters (parent-type return breaks
  the chain); Java directory generation now applies `safe_identifier` to match
  package declarations

## [1.0.0] - 2026-03-25

Initial release of the CASE/UCO SDK — a multi-language data modeling library for
digital forensics, cyber-investigation, and cyber-observable data.

### Added

#### Core SDK

- Full typed class coverage for CASE 1.4.0 and UCO 1.4.0 (428 classes across 15 modules)
- Four language targets: **Python**, **C#**, **Java**, **Rust** — all sharing the same
  JSON-LD context and producing interoperable output
- `CASEGraph` API with `create()`, `serialize()`, `write()`, `load()`, and `load_file()`
- Required-field validation at insertion time (Python, C#, Java)
- Deterministic ID support (`create(id=...)`) for reproducible IRIs
- Round-trip serialization — load existing JSON-LD, add objects, re-serialize
- Triple estimation (`estimate_triples()`) for memory planning
- Graph splitting (`split()`) for catalog-style independent-object graphs
- Multi-file merge (`merge_files()`) for combining graphs
- Typed deserialization (`from_jsonld()`) in Python
- Automatic JSON-LD context with all 18 CASE/UCO namespace prefixes
- Runtime provenance metadata (`UCO_VERSION`, `CASE_VERSION`)

#### Runtime Registry

- `search(query)` — keyword search across all class names and descriptions
- `get_class(name)` — full property table with types, cardinalities, required flags
- `list_modules()`, `list_classes()`, `find_facets()`, `find_by_property_type()`
- `list_vocabs()` — all vocabulary/enum types with members
- Auto-generated `_registry.json` backing all four language runtimes

#### MCP Server for AI-Assisted Development

- FastMCP server (`mcp_server/server.py`) giving AI coding assistants programmatic
  ontology access
- Six tools: `search_classes`, `get_class_details`, `find_classes_for_domain`,
  `list_all_facets`, `get_recipe`, `list_all_vocabs`
- Three resources: `case-uco://domains`, `case-uco://modules`, `case-uco://patterns`
- Domain index (`domain_index.py`) mapping natural-language forensic tasks to the right
  CASE/UCO classes
- Cursor rules (`.cursor/rules/`) encoding SDK patterns, the ObservableObject + Facet
  model, validation requirements, and common pitfalls
- Pre-configured `.cursor/mcp.json` for zero-setup Cursor integration

#### Documentation

- **31 recipes** in `docs/recipes/` covering forensic workflows, devices, files,
  communication artifacts, and SDK patterns:
  - Forensic workflows: forensic tool, configured tool, chain of custody, analysis and
    classification, investigation lifecycle, network investigation, spear phishing
  - Devices and identity: device/workstation, mobile device + SIM, mobile forensics,
    cell site/tower, location, multi-platform accounts, events/auth logs
  - Files and data: file system, advanced file patterns, fragments/multipart, recovery
    and carving, partitions, bulk extractor paths, EXIF metadata, database records
  - Communication: email/messaging, threaded messaging (WhatsApp/chat), call logs,
    SMS/contacts, network artifacts
  - SDK patterns: runtime discovery, extensions, round-trip serialization, large
    datasets, existence intervals
- Recipe index (`docs/recipes/INDEX.md`) with cross-references to official CASE-Examples
- `ONTOLOGY_REFERENCE.md` — complete auto-generated class reference with property tables
- `docs/MAPPING_GUIDE.md` — maps forensic domains to the right classes
- `docs/PERFORMANCE_GUIDE.md` — benchmarks, hardware sizing, partitioning strategies
- `docs/ECOSYSTEM.md` — companion tools, community extensions, ontology sources
- `mcp_server/README.md` — MCP server setup, tool reference, troubleshooting

#### Relationship Tagging Convention

- `tag` property on `Relationship` objects to classify evidence basis:
  `observed` (from packet/artifact data), `inferred` (derived from analysis),
  `configuration` (network topology / infrastructure)
- Recipes updated with tagging guidance so agents produce semantically precise graphs

#### Example Agent/MCP Outputs

- `example_agentmcp_outputs/` — three complete worked examples showing end-to-end
  AI-assisted graph generation:
  - **WiFi packet capture** (`wifi_capture.py` / `.jsonld` / `.pcapng`) — three-layer
    network investigation with acquisition, observed network, and analysis attribution
  - **Cellebrite Samsung extraction** (`cellbrite_samsung_extraction.py` / `.jsonld`) —
    mobile device forensics with WhatsApp messages, GPS data, and app artifacts
  - **Field office custody** (`field_office_custody.py` / `.jsonld`) — chain of custody
    for evidence received from a field office

#### Extension Support

- `case-uco-generate scaffold` command for auto-generating typed classes from custom
  OWL Turtle extensions
- `extensions/toolcap/` — validated example extension for forensic tool capability
  comparison
- Extension ontology integration in the CLI explorer and documentation generators

#### Build and CI

- `Makefile` with `init`, `generate`, `build`, `test` targets
- GitHub Actions workflows: CI, CodeQL, dependency review, release
- Dependabot configuration for automated dependency updates

[1.3.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.3.0
[1.2.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.2.0
[1.1.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.1.0
[1.0.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.0.0
