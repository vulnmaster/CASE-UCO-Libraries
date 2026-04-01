# Contributing to CASE/UCO SDK

Thank you for your interest in contributing! This document covers three tracks depending on your goal.

## Track 1: Use the SDK

If you just want to **build CASE/UCO graphs** in your application, you do not need to clone this repo. Install the SDK package for your language and start writing code.

### Getting Started

```bash
# Python (from GitHub release artifacts — PyPI coming soon)
pip install case_uco-1.8.0-py3-none-any.whl
pip install case-utils  # recommended: enables graph.validate()
```

For C#, Java, and Rust, see the install instructions in the [README](README.md#installation).

### Resources for SDK Users

- **[README](README.md)** — quickstart examples for all four languages
- **[docs/MAPPING_GUIDE.md](docs/MAPPING_GUIDE.md)** — maps forensic domains to the right classes
- **[docs/recipes/](docs/recipes/INDEX.md)** — step-by-step patterns for common workflows
- **[docs/CROSS_LANGUAGE_PARITY.md](docs/CROSS_LANGUAGE_PARITY.md)** — what's identical vs. idiomatic across languages
- **[ONTOLOGY_REFERENCE.md](ONTOLOGY_REFERENCE.md)** — full class and property reference

### Reporting Bugs as a User

Open a [GitHub issue](https://github.com/vulnmaster/CASE-UCO-SDK/issues/new) describing:
- What you expected to happen
- What actually happened
- Steps to reproduce
- Which language library is affected

## Track 2: Contribute to the SDK

If you want to **fix bugs, add features, improve docs, or extend tests**, this track is for you.

### Setup

```bash
git clone --recurse-submodules https://github.com/vulnmaster/CASE-UCO-SDK.git
cd CASE-UCO-SDK
make init      # create .venv, install all Python deps, generator + SDK
make check     # full verify: generate, build, test, lint, smoke (all languages)
```

### Project Structure

| Path | Role | Editable? |
|------|------|-----------|
| `generator/` | Code generator (Python) — changes here affect all four language outputs | Yes |
| `python/case_uco/graph.py` | Python runtime (graph API, serialization, validation) | Yes |
| `csharp/CaseUco/CaseGraph.cs` | C# runtime | Yes |
| `java/.../CaseGraph.java` | Java runtime | Yes |
| `rust/src/graph.rs` | Rust runtime | Yes |
| `python/case_uco/uco/`, `case/` | Generated Python classes | No — regenerate instead |
| `csharp/CaseUco/Uco/`, `Case/` | Generated C# classes | No — regenerate instead |
| `java/src/.../uco/`, `case/` | Generated Java classes | No — regenerate instead |
| `rust/src/uco/`, `case/` | Generated Rust modules | No — regenerate instead |
| `ontology/` | Upstream UCO + CASE ontology sources (git submodules) | No |
| `docs/` | Documentation, recipes, guides | Yes |
| `extensions/` | Extension ontology examples | Yes |

### Submitting Changes

1. Fork the repository and create a feature branch from `main`.
2. Make your changes. If modifying the generator, regenerate and test all four languages.
3. Run the full suite: `make check`
4. Ensure CI passes (all four language builds + CodeQL + Rust security scanning).
5. Open a pull request with a clear description.

### Generator Changes

If your change modifies how code is generated:

1. Edit files under `generator/src/case_uco_generator/`.
2. Regenerate: `make generate`
3. Run all tests: `make test`
4. Commit both the generator change and the regenerated output.

### Code Style

| Language | Convention |
|----------|-----------|
| Python | PEP 8, strict mypy |
| C# | .NET PascalCase, warnings-as-errors |
| Java | Standard camelCase, javac -Xlint -Werror |
| Rust | rustfmt, clippy -D warnings |

### CI Checks

Every PR triggers:
- **CI** (`ci.yml`) — generate, build, test, lint all four languages
- **CodeQL** (`codeql.yml`) — static analysis for Python, C#, Java
- **Rust Security** (`rust-security.yml`) — cargo-audit + clippy security lints
- **Dependency Review** (`dependency-review.yml`) — fails on high-severity dependency changes

## Track 3: Extend or Regenerate the Ontology Bindings

If you want to **add extension ontologies, modify the code generator, or regenerate bindings for a new ontology version**, this track covers the advanced workflows.

### Adding a New Ontology Extension

1. Create a directory under `extensions/` with:
   - A Turtle (`.ttl`) file defining your OWL+SHACL extension
   - A working example script
   - A `README.md` documenting the extension
2. Follow the pattern in `extensions/toolcap/` for reference.
3. Use `case-uco-generate scaffold` to auto-generate typed classes:

```bash
case-uco-generate scaffold \
  --extension path/to/myext.ttl path/to/myext-shapes.ttl \
  --output-dir my_project/
```

See the [extensions recipe](docs/recipes/extensions.md) for the full workflow.

### Regenerating for a New Ontology Version

1. Update the ontology submodules under `ontology/`:
   ```bash
   cd ontology/UCO && git checkout <new-tag> && cd ../..
   cd ontology/CASE && git checkout <new-tag> && cd ../..
   ```
2. Update version constants in the generator and package manifests.
3. Regenerate: `make generate`
4. Run full verification: `make check`
5. Update `CHANGELOG.md` and tag the release.

### Proposing Changes to the CASE/UCO Ontology

If the ontology doesn't cover your domain, you can draft a formal change proposal. See the [change proposal recipe](docs/recipes/change-proposal.md) for the full workflow, or use the MCP tools (`check_existing_proposals`, `draft_change_proposal`) for AI-assisted drafting.

### MCP Server Development

The MCP server (`mcp_server/`) provides AI coding assistants with ontology discovery tools. To work on it:

```bash
pip install fastmcp
cd mcp_server && python server.py  # starts the development server
```

See `mcp_server/README.md` for the tool reference and architecture.

### Stability Guarantees

- **Stable API**: The graph operations (`create`, `serialize`, `write`, `load`, `validate`) and registry operations will not be renamed or removed without a major version bump.
- **Stable output**: JSON-LD output format is defined by the ontology and does not change within an ontology version.
- **Unstable internals**: Generated module structure, internal file organization, and import paths may change between releases.

See [docs/CROSS_LANGUAGE_PARITY.md](docs/CROSS_LANGUAGE_PARITY.md) for the full parity contract.

## Security

See [SECURITY.md](SECURITY.md) for our vulnerability reporting policy.

## License

By contributing, you agree that your contributions will be licensed under the Apache-2.0 License.
