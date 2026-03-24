# CASE/UCO Standard Libraries

Auto-generated, full-coverage builder libraries for the [CASE](https://caseontology.org/) (Cyber-investigation Analysis Standard Expression) and [UCO](https://unifiedcyberontology.org/) (Unified Cyber Ontology) ontologies.

## Overview

This monorepo contains:

- **generator/** — A Python-based code generator that parses the UCO/CASE OWL+SHACL ontology (Turtle files) and produces idiomatic builder libraries
- **python/** — Generated Python library (`case-uco`)
- **csharp/** — Generated C# library (`CaseUco`)
- **java/** — Generated Java library (`case-uco`)
- **rust/** — Generated Rust crate (`case-uco`)
- **ontology/** — Git submodules for the [UCO](https://github.com/ucoProject/UCO) and [CASE](https://github.com/casework/CASE) ontology sources

## Quick Start

### Prerequisites

- Python 3.9+ (for the code generator and Python library)
- .NET SDK 6.0+ (for C# library)
- JDK 11+ and Maven (for Java library)
- Rust toolchain (for Rust library)

### Generate All Libraries

```bash
# Clone with submodules
git clone --recurse-submodules https://github.com/vulnmaster/CASE-UCO-Libraries.git
cd CASE-UCO-Libraries

# Install generator dependencies
pip install -e generator/

# Generate all libraries
python -m case_uco_generator generate --lang all
```

### Python Usage

```python
from case_uco import CASEGraph
from case_uco.uco.tool import Tool
from case_uco.uco.observable import ObservableObject, ApplicationFacet

graph = CASEGraph(kb_prefix="http://example.org/kb/")

axiom = graph.create(Tool, name="Magnet AXIOM")
wechat = graph.create(
    ObservableObject,
    has_facet=[
        ApplicationFacet(application_identifier="com.tencent.mm")
    ],
)

print(graph.serialize())
```

## Ontology Versions

| Component | Version |
|-----------|---------|
| UCO | 1.4.0 |
| CASE | 1.4.0 |

## Related Projects

- [UCO Ontology](https://github.com/ucoProject/UCO)
- [CASE Ontology](https://github.com/casework/CASE)
- [CASE Examples](https://github.com/casework/CASE-Examples)
- [CASE Mapping Template Stubs](https://github.com/casework/CASE-Mapping-Template-Stubs)
- [CASE Mappings](https://github.com/casework/CASE-Mappings)

## License

Apache-2.0
