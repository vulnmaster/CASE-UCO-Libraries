# CAC Ontology Extension

This extension integrates the [Crimes Against Children (CAC) Ontology](https://github.com/Project-VIC-International/CAC-Ontology) into the CASE/UCO SDK.

## Overview

The CAC Ontology is developed by [Project VIC International](https://projectvic.org/) and provides a comprehensive vocabulary for modeling crimes against children investigations, spanning grooming, sextortion, forensics, detection, legal outcomes, and more.

- **Version**: 3.0.0
- **Modules**: 47 domain modules (~97 TTL files), all indexed in `_registry.json`
- **Classes**: 1,993 OWL classes (T-Box-complete, including classes without SHACL shapes)
- **Upper Ontology**: gUFO (directly imported via the semantic spine)
- **UCO Compatibility**: 1.4.0

## Architecture

CAC uses a "semantic spine" (`cac-core`) that directly imports gUFO and establishes dual inheritance with both gUFO and UCO/CASE classes. Domain modules extend the spine with specialized concepts.

## Usage

### Python

```bash
pip install case-uco-cac
```

```python
from case_uco import CASEGraph
from case_uco_cac import core, grooming, forensics

graph = CASEGraph(extra_context={
    "cac-core": "https://cacontology.projectvic.org/core#",
    "cacontology": "https://cacontology.projectvic.org#",
})
```

### MCP Server

Set the `CASE_UCO_EXTENSIONS` environment variable to include CAC:

```json
{
  "env": {
    "CASE_UCO_EXTENSIONS": "cac"
  }
}
```

## CDO Shapes Compatibility

| Profile | Status |
|---------|--------|
| CDO-Shapes-gufo | Included (CAC spine imports gUFO directly) |
| CDO-Shapes-BFO | Not recommended (may conflict with gUFO axioms) |
| CDO-Shapes-PROV-O | Compatible |
| CDO-Shapes-Time | Compatible |
| CDO-Shapes-GeoSPARQL | Compatible |
| CDO-Shapes-FOAF | Compatible |

## Submodule

The `ontology/` directory is a git submodule pointing to the upstream CAC Ontology repository.

```bash
git submodule update --init extensions/cac/ontology
```

## Registry Coverage

The `_registry.json` is the source of truth for runtime discovery (`search_classes`,
`get_class_details`, `find_classes_for_domain`) used by the SDKs and the MCP server.
It is regenerated from the TTL submodule with:

```bash
case-uco-generate generate-extension --extension extensions/cac \
    --output-dir extensions/cac/_build --lang python
cp extensions/cac/_build/_registry.json extensions/cac/_registry.json
```

The generator indexes both:

1. OWL classes targeted by `sh:NodeShape` (yields full property lists), and
2. T-Box-only OWL classes that lack SHACL shapes (yields the class itself with
   no enforced property cardinalities).

Module names in the registry use the manifest namespace prefix verbatim
(e.g. `cacontology-sex-trafficking`). Generated language bindings sanitize
hyphens to underscores for valid identifiers (e.g.
`case_uco_cac.cacontology_sex_trafficking`).

If you add a new TTL file or a new namespace in the upstream submodule,
update `manifest.json` so the namespace prefix matches the IRI declared in
the TTL, then regenerate the registry.
