# Adversary Engagement Ontology (AEO) Extension

This extension integrates the [Adversary Engagement Ontology](https://github.com/UNHSAILLab/Adversary-Engagement-Ontology) into the CASE/UCO SDK.

## Overview

The AEO is developed by the [UNH SAIL Lab](https://unhsaillabwebsite.web.app/) and provides vocabulary for modeling cyber denial, deception, and adversary engagement operations.

- **Version**: 0.2.1
- **Modules**: ~6 domain modules (engagement, objective, attack, identity, role, vocabulary)
- **Upper Ontology**: None (extends UCO directly)
- **UCO Compatibility**: 1.2.0, 1.4.0

## Architecture

AEO extends UCO directly without an intermediate foundational ontology. SHACL constraints are embedded within the OWL files rather than in separate shapes files.

## Usage

### Python

```bash
pip install case-uco-aeo
```

```python
from case_uco import CASEGraph
from case_uco_aeo import engagement, objective

graph = CASEGraph(extra_context={
    "engagement": "https://ontology.adversaryengagement.org/ae/engagement/",
    "objective": "https://ontology.adversaryengagement.org/ae/objective/",
})
```

### MCP Server

Set the `CASE_UCO_EXTENSIONS` environment variable to include AEO:

```json
{
  "env": {
    "CASE_UCO_EXTENSIONS": "aeo"
  }
}
```

## CDO Shapes Compatibility

All CDO Shapes profiles are compatible with AEO since it does not import any upper ontology directly.

| Profile | Status |
|---------|--------|
| CDO-Shapes-gufo | Compatible |
| CDO-Shapes-BFO | Compatible |
| CDO-Shapes-PROV-O | Compatible |
| CDO-Shapes-Time | Compatible |
| CDO-Shapes-GeoSPARQL | Compatible |
| CDO-Shapes-FOAF | Compatible |

## Submodule

The `ontology/` directory is a git submodule pointing to the upstream AEO repository.

```bash
git submodule update --init extensions/aeo/ontology
```
