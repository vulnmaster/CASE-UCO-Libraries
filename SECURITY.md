# Security Policy

## Supported Versions

| Version | Supported |
|---------|-----------|
| 1.8.x   | Yes       |
| < 1.7.0 | No        |

This project tracks the CASE 1.4.0 and UCO 1.4.0 ontology releases. Only the latest SDK version receives security updates.

## Reporting a Vulnerability

**Do not open a public GitHub issue for security vulnerabilities.**

Instead, please report vulnerabilities privately using one of these methods:

1. **GitHub Security Advisories** (preferred): Use the [private vulnerability reporting](https://github.com/vulnmaster/CASE-UCO-SDK/security/advisories/new) feature on this repository.
2. **Email**: Send details to the repository maintainers via the contact information in the GitHub profile.

### What to Include

- Description of the vulnerability
- Steps to reproduce (or a proof-of-concept)
- Which language library is affected (Python, C#, Java, Rust, or the generator)
- Impact assessment (what an attacker could achieve)
- Any suggested fix, if you have one

### What to Expect

- **Acknowledgment** within 72 hours of your report.
- **Triage and assessment** within 7 days. We will confirm whether the report is accepted as a vulnerability or declined with explanation.
- **Fix timeline**: Critical vulnerabilities will be patched within 30 days. Lower-severity issues will be addressed in the next scheduled release.
- **Disclosure**: We follow coordinated disclosure. We will work with you on timing and credit in the advisory.

## Security Measures

This project employs the following security practices:

### Static Analysis
- **CodeQL** scanning for Python, C#, and Java on every push and pull request, plus weekly scheduled scans
- **cargo-audit** for Rust dependency vulnerability scanning in CI
- **Dependency review** on pull requests, failing on high-severity dependency changes

### Dependency Management
- **Dependabot** monitors all seven dependency ecosystems (GitHub Actions, pip/Python, pip/generator, NuGet, Maven, Cargo, git submodules) with weekly update checks
- Dependency review gate blocks PRs that introduce known-vulnerable dependencies at high severity or above

### Build Integrity
- CI builds all four languages from generated source on every push to `main` and `develop`
- Generated code is reproducible from tagged ontology submodule versions
- All generated artifacts include provenance metadata (`UCO_VERSION`, `CASE_VERSION`) traceable to specific ontology commits

### Release Process
- Releases are triggered by signed tags and built in CI
- Release artifacts include Software Bill of Materials (SBOM) for supply-chain transparency
- Package manifests are version-locked to the repository release version

## Scope

This security policy covers:
- The four language SDK libraries (Python `case-uco`, C# `CaseUco`, Java `case-uco`, Rust `case-uco`)
- The code generator (`case-uco-generator`)
- The MCP server (`mcp_server/`)
- CI/CD workflows and build infrastructure

It does **not** cover:
- The upstream CASE and UCO ontology sources (report issues to [UCO](https://github.com/ucoProject/UCO/security) or [CASE](https://github.com/casework/CASE/security) directly)
- Third-party tools referenced in documentation (case-utils, Apache Jena, etc.)
- Extension ontologies in `extensions/` (these are examples, not production dependencies)
