# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.7.0] - 2026-04-01

### Added

#### Security Policy and Supply-Chain Hardening

- **`SECURITY.md`** — vulnerability reporting policy with private disclosure
  via GitHub Security Advisories, 72-hour acknowledgment SLA, and coordinated
  disclosure process. Documents all security measures (CodeQL, cargo-audit,
  dependency review, Dependabot) and defines scope.

#### Rust Security Scanning

- **`rust-security.yml`** workflow — dedicated CI pipeline for Rust
  supply-chain security, running on push/PR to `main`/`develop` plus weekly
  schedule:
  - `cargo audit` for dependency vulnerability scanning (filling the gap
    left by CodeQL, which does not support Rust)
  - `clippy` with `unwrap_used` and `expect_used` security-focused lints

#### Hardened Release Pipeline

- **`release.yml`** completely rewritten from a simple GitHub Release creator
  to a full build-and-attest pipeline:
  - Builds all four language packages from generated source (Python wheel/sdist,
    C# NuGet, Java JAR, Rust crate)
  - Generates Python SBOM in CycloneDX format via `pip-audit`
  - Produces SHA256 checksums (`SHA256SUMS.txt`) for all release assets
  - Creates SLSA build provenance attestations via
    `actions/attest-build-provenance@v2`
  - Requests `id-token: write` and `attestations: write` permissions for
    OIDC-based trusted provenance
  - Uses a `release` environment for deployment protection rules

#### Change Proposal Improvements (Ontology Committee Feedback)

Based on feedback from the CASE/UCO Ontology Committee, the change
proposal workflow now includes:

- **Target release** — every proposal must specify which CASE/UCO release
  it targets (e.g., 1.5.0, 2.0.0). Added to the template, recipe, and
  MCP tool (`target_release` parameter, defaults to "1.5.0")
- **Example graph generation** — `draft_change_proposal` now generates a
  companion `.jsonld` file alongside the proposal markdown, containing
  the example instance data that the submitter wants to build and share
- **SPARQL query file** — `draft_change_proposal` now generates a companion
  `.sparql` file with the competency queries for automated testing
- **Pre-submission testing** section added to the template requiring
  submitters to report SPARQL test results, graph validation output,
  and any unresolved issues before the proposal goes to manual review
- **`make test-proposal PROPOSAL=<slug>`** — new Makefile target that
  validates the example `.jsonld` graph with `case_validate` and tests
  all SPARQL queries against the example data using RDFLib
- **`make validate-proposal`** and **`make sparql-test-proposal`** —
  individual Makefile targets for running validation or SPARQL tests
  separately
- **Extension compatibility testing** against multiple CASE/UCO branches:
  - `make test-extension-compat` — tests an extension ontology against
    `main` (current stable), `develop` (v1.5.0), and `develop-2.0.0`
    (v2.0.0) branches
  - Individual targets: `test-extension-main`, `test-extension-develop`,
    `test-extension-develop2`
  - This helps ontologists review change proposals by showing
    compatibility across release targets
- Updated `docs/templates/change-proposal-template.md` with Target
  release, Example instance data, and Pre-submission testing sections
- Updated `docs/recipes/change-proposal.md` with new Steps 3 (target
  release selection), 5 (example data), and 6 (test before submission)
- File convention documentation for proposal artifacts: `.md`, `.jsonld`,
  `.sparql`, `.ttl`, `-shapes.ttl`

#### UCO Profile Ontology Integration

UCO maintains [Profile repositories](https://cyberdomainontology.org/ontology/development/#profiles)
that align UCO classes with established external ontologies. The SDK now
surfaces all six profiles to developers:

- **New MCP tool `get_uco_profiles()`** — search and browse UCO Profile
  ontologies (BFO, gUFO, PROV-O, OWL-Time, GeoSPARQL, FOAF) with
  descriptions, repo links, related recipes, and integration guidance
- **New MCP resource `case-uco://profiles`** — browsable profile catalog
  for AI agent context
- **`find_classes_for_domain` now returns matching profiles** — when a
  domain query matches a profile's keywords or related domains, the
  response includes `related_profiles` with links and descriptions
- **`UCO_PROFILES` data structure** in `domain_index.py` — complete
  metadata for all six profiles including keywords, related domains,
  related recipes, ontology file names, and profile types (top-level
  vs. adopting)
- **`docs/ECOSYSTEM.md`** — new "UCO Profiles — Interoperability with
  Other Ontologies" section with:
  - Profile table with descriptions and use cases
  - "For Developers Coming from Other Ontologies" cross-reference table
  - SDK integration code example
  - Profile repository structure reference
- **`README.md`** — new "UCO Profiles" subsection in Ecosystem & Tools
  with quick-reference table
- **`docs/MAPPING_GUIDE.md`** — new Tip #8 connecting domain mappings
  to relevant profile ontologies with concrete examples

#### CDO Community Playground Guide Integration

Aligned the SDK's extension authoring workflow with the updated
[CDO Community Playground Guide](https://docs.google.com/document/d/1EiXQiAeUGk-629xdKx7HZHVn927k891LGkPcQzNLLr8/edit?usp=sharing):

- **`.cursor/rules/extension-authoring.mdc`** rewritten with Playground
  Guide constraints: T-Box vs. A-Box rules (never `owl:NamedIndividual`
  for schema elements), mandatory subclassing, descriptive documentation,
  `case_validate` flags (`--inference rdfs`, `--allow-info`,
  `--ontology-graph`), CASE-Profile-Example testing workflow, and
  recommended chain of thought for AI agents generating extensions
- **`.cursor/rules/case-uco-sdk.mdc`** updated validation section with
  extension-specific `case_validate` flags and new "Extension Ontology
  Authoring" section summarizing Playground Guide rules
- **`docs/recipes/extensions.md`** expanded with extension file structure
  guidance, critical rules for extension classes, validation examples
  (basic, subclass inference, multiple namespaces), CDO Community
  Playground testing workflow (manual and via `make playground-test`),
  and links to existing community playground extensions
- **`docs/ECOSYSTEM.md`** — new "CDO Community Playground Extensions"
  subsection listing AI-generated CASE and UCO extensions from
  Project VIC International's ICAC taskforce work
- **`make playground-test`** — new Makefile target that clones
  [CASE-Profile-Example](https://github.com/casework/CASE-Profile-Example),
  injects the extension ontology and shapes, and runs `make -j check`
  per the Playground Guide submission requirements

#### Rust Security Lint Fix

- Replaced `.expect()` calls in `rust/src/graph.rs` and
  `rust/src/registry.rs` with `match` + `panic!` to satisfy
  `clippy::expect_used` security lint in the `rust-security` CI workflow

#### Cross-Language Parity Contract

- **`docs/CROSS_LANGUAGE_PARITY.md`** — formal specification of what is
  intentionally identical across all four languages (operation names, registry
  API, JSON-LD output, validation behavior) vs. what is intentionally
  language-idiomatic (object construction, naming conventions). Includes
  stability guarantees and migration guidance.

### Changed

#### Version Alignment

- All four package manifests now track the repository release version:
  - Python `pyproject.toml`: 0.1.0 → 1.7.0
  - Rust `Cargo.toml`: 0.1.0 → 1.7.0
  - Java `pom.xml`: 0.1.0 → 1.7.0
  - C# `CaseUco.csproj`: 0.1.0 → 1.7.0
- Previously, package versions were stuck at 0.1.0 while the repo was at
  v1.6.0, creating a provenance and support-expectation mismatch

#### README Restructured for Consumer vs. Contributor Paths

- **Installation section** split into "Use the SDK (Consumer Install)" and
  "Contribute to the SDK (Developer Install)" — consumers no longer need to
  clone the repo or run the generator
- Added install-from-release-artifact instructions with placeholder for
  future package registry lines (PyPI, NuGet, Maven Central, crates.io)
- Python quickstart example now ends with `graph.validate()` instead of
  just `graph.write()`, making validation part of the default developer path
- Added **Version Matrix** section showing lockstep package versions across
  all four languages and their corresponding ontology versions
- Added **Cross-Language Parity** section linking to the parity contract
- Added **Security** section linking to `SECURITY.md`
- Architecture diagram updated to reflect new files

#### Community Integration (ECOSYSTEM.md and MAPPING_GUIDE.md)

- **CDO Project Release Flow** section in `ECOSYSTEM.md` — documents the
  established community release pipeline (UCO → CASE → case-utils → case-
  validation-action → downstream projects) and positions the SDK within it,
  per guidance from the CASE/UCO Ontology Committee
- **Community Mappings and Implementations** section in `ECOSYSTEM.md` —
  references the full landscape of existing community mapping work:
  - Mapping specifications: CASE-Mappings (SleuthKit, Cellebrite, Bulk
    Extractor, NSRL), CASE-Mapping-Template-Stubs, CASE-Mapping-Template-
    Python, CASE-Mapping-Python (INSPECTr)
  - 10 tool implementation repositories (UFED-XML, ExifTool, AXIOM, XRY,
    DC3DD, GNU-Time, Plaso, Volatility, macOS System Profiler, PROV-O)
  - Templates for new implementations
- **Community Mapping Resources** section in `MAPPING_GUIDE.md` — links the
  auto-generated domain mapping guide to the community's hand-written tool
  mappings, noting the v0.1.0-era terminology differences and the
  complementary relationship between the two

#### CONTRIBUTING.md Reorganized into Three Tracks

- **Track 1: Use the SDK** — for developers who just want to consume the
  package (install, resources, bug reporting)
- **Track 2: Contribute to the SDK** — for developers fixing bugs or adding
  features (setup, project structure, CI checks, code style)
- **Track 3: Extend or Regenerate** — for advanced users adding extension
  ontologies, modifying the generator, or updating ontology versions
- Each track links to the relevant docs without requiring knowledge of the
  other tracks

## [1.6.0] - 2026-03-27

### Added

#### Rust — Required-Field Validation

The Rust library now validates ontology-required fields when adding objects
to a graph via `create()` and `create_with_id()`, matching the existing
behavior in Python, C#, and Java.

- Added `validate()` method to the `CaseObject` trait with a default no-op
  implementation
- Generated structs with required properties now implement `validate()`,
  checking that `Option` fields are `Some` and required `Vec` fields are
  non-empty
- `CaseGraph::create()` and `CaseGraph::create_with_id()` call `validate()`
  before insertion, panicking with a descriptive error if a required field
  is missing
- Updated the Rust code generator (`rust_backend.py`) to emit `validate()`
  implementations based on `prop.cardinality.is_required`
- Updated the Rust exhaustive test to instantiate without adding to graph
  (matching the C# and Java exhaustive test pattern)

#### C# — Static Analysis (Warnings-as-Errors)

- Enabled `<TreatWarningsAsErrors>true</TreatWarningsAsErrors>` and
  `<EnforceCodeStyleInBuild>true</EnforceCodeStyleInBuild>` in
  `CaseUco.csproj`, so all Roslyn compiler warnings are treated as
  build-breaking errors
- Added `lint-csharp` Makefile target (`dotnet build /p:TreatWarningsAsErrors=true`)
- Fixed pre-existing CS0108 warning in `ReferenceEqualityComparer.Equals()`
  (missing `new` modifier)

#### Java — Static Analysis (javac -Xlint + -Werror)

- Added `maven-compiler-plugin` configuration with `-Xlint:all,-options`
  and `-Werror`, so all javac warnings (unused imports, unchecked casts,
  deprecations, etc.) are treated as compilation errors
- Added `lint-java` Makefile target (`mvn compile`)
- Updated `pom.xml` to use `maven-compiler-plugin` 3.12.1

### Changed

- The `make lint` target now runs all four linters: mypy (Python),
  dotnet warnings-as-errors (C#), javac -Xlint -Werror (Java), and
  clippy (Rust)

## [1.5.0] - 2026-03-27

### Changed

#### CLI Ontology Explorer — Terminal-Width-Adaptive Output

The `case-uco-explore` CLI now dynamically adjusts table output to fit the
current terminal width, instead of truncating descriptions at a fixed character
limit regardless of available space.

- **`format_class_detail`** property table — the Description column now expands
  to fill remaining terminal width after the Name, Type, Cardinality, and Req
  columns, replacing the previous hard-coded 50-character truncation
- **`format_class_list`** (used by `search`, `module`, and `properties`
  commands) — the Description column similarly expands to fill remaining width
  after the Module and Class columns, replacing the previous 60-character limit
- Both formatters enforce a minimum description width of 20 characters for
  narrow terminals and fall back to 80 columns when terminal size cannot be
  detected (e.g., piped output)
- The `max_desc` parameter remains available for callers who need to override
  automatic width detection

## [1.4.1] - 2026-03-26

### Changed

#### Toolcap Extension v0.3.1 — Semantic Tightening

A cleanup pass focused on semantic precision and validation constraints,
informed by peer review feedback.

- **`owl:imports`** — explicit imports added for `uco-core`, `uco-tool`,
  `uco-observable`, and `case-investigation` modules to improve reasoning,
  validation, and reuse reliability
- **SHACL `sh:or` constraint** on `ToolCapability-Shape` — every
  `ToolCapability` must now declare at least one of `application` (for
  app-level capabilities) or `forensicTaskType` (for CFTT task-level
  capabilities). Prevents underspecified instances with neither property.
- **SHACL SPARQL constraint** on `BenchmarkObservation-Shape` — when
  `submittedCount`, `truePositiveCount`, and `falsePositiveCount` are all
  present, validates that `submittedCount == TP + FP`
- **Clarified metric semantics** in `rdfs:comment` for three properties:
  - `parseSuccess` — now explicitly defines "true = produced usable output"
    vs "false = total failure"; documents expected relationship with other
    metrics when false
  - `completenessScore` — distinguished from `recallScore`: completeness is
    a holistic data recovery measure (including partial records, structural
    integrity), while recall is the strict IR metric `TP / (TP + FN)` based
    on binary item-level matching
  - `accuracyScore` — distinguished from `precisionScore`: accuracy measures
    content-level fidelity of recovered items (timestamps, metadata correct),
    while precision is the strict IR metric `TP / (TP + FP)` measuring what
    fraction of reported items are real
- **Refreshed class comments** on `CapabilityMatrix` and
  `BenchmarkObservation` to reflect the v0.3.0+ scope (forensic tasks, IR
  metrics, benchmark provenance) rather than app-parsing only
- **Version bumped** to `owl:versionIRI toolcap:0.3.1` with
  `owl:priorVersion toolcap:0.3.0`
- All exemplar data validated with `case_validate --built-version case-1.4.0`
  (`Conforms: True`)

## [1.4.0] - 2026-03-26

### Added

#### Toolcap Extension v0.3.0 — NIST CFTT Task-Level Capabilities and IR Metrics

The `extensions/toolcap/` extension ontology has been expanded to support NIST
CFTT-style forensic task benchmarking. Tools can now declare task-level
capabilities (string search, file carving, deleted file recovery, Windows
registry recovery, SQLite recovery) in addition to app-level capabilities.
Benchmark observations now capture standard information retrieval metrics and
benchmark provenance for reproducibility and cross-framework comparison.

- **New property on `ToolCapability`:**
  - `forensicTaskType` — CFTT task category (e.g., `string-search`,
    `deleted-file-recovery`, `file-carving`, `windows-registry-recovery`,
    `sqlite-recovery`); enables task-level capabilities without a specific
    target application
  - `application` relaxed from required (1..1) to optional (0..1) in SHACL
    shapes to accommodate task-level capabilities

- **6 new IR metrics on `BenchmarkObservation`:**
  - `precisionScore` — TP / (TP + FP), 0.0–1.0
  - `recallScore` — TP / (TP + FN), 0.0–1.0
  - `f1Score` — harmonic mean of precision and recall, 0.0–1.0
  - `truePositiveCount` — number of correctly identified items
  - `groundTruthCount` — total items in reference dataset
  - `submittedCount` — total items reported by the tool (TP + FP)

- **3 new provenance properties on `BenchmarkObservation`:**
  - `benchmarkFramework` — framework name (e.g., `AutoDFBench`, `NIST-CFTT`)
  - `testCaseIdentifier` — unique test case ID within the framework
  - `benchmarkSuiteScore` — overall composite score, 0.0–1.0

- **New property on `PlatformSpecification`:**
  - `fileSystemType` — filesystem type (e.g., `FAT32`, `NTFS`, `ext4`, `HFS+`)
    for forensic tasks where tool performance varies by filesystem

- **SHACL shapes** updated with constraints for all new properties including
  `sh:minInclusive`/`sh:maxInclusive` range constraints on score properties

- **Updated exemplar** (`toolcap-exemplar.ttl`) with three new CFTT-style
  scenarios: Tool A file carving on NTFS, Tool A deleted file recovery on
  FAT32, and Tool B string search on ext4 — all with full AutoDFBench IR
  metrics and provenance

- **Updated Python example** (`example_capability_matrix.py`) demonstrating
  task-level capabilities, filesystem-aware platforms, and AutoDFBench
  benchmark observations with IR metrics

- All exemplar data validated with `case_validate --built-version case-1.4.0`
  (`Conforms: True`)

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

[1.7.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.7.0
[1.6.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.6.0
[1.5.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.5.0
[1.4.1]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.4.1
[1.4.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.4.0
[1.3.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.3.0
[1.2.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.2.0
[1.1.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.1.0
[1.0.0]: https://github.com/vulnmaster/CASE-UCO-SDK/releases/tag/v1.0.0
