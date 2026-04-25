# Cross-Domain Extension Usage

This recipe shows how to use extension ontology packages (CAC Ontology, Adversary Engagement Ontology) alongside the core CASE/UCO SDK, including cross-domain composition where multiple extensions are combined in a single graph.

## Prerequisites

```bash
pip install case-uco          # Core SDK
pip install case-uco-cac      # CAC Ontology bindings (optional)
pip install case-uco-aeo      # AEO bindings (optional)
```

## Using CAC Classes with CASE Investigations

The CAC Ontology provides specialized classes for crimes against children investigations. These classes extend UCO/CASE concepts and can be used in the same graph as standard CASE investigation data.

### Python

```python
from case_uco import CASEGraph

graph = CASEGraph(extra_context={
    "cac-core": "https://cacontology.projectvic.org/core#",
    "cacontology-forensics": "https://cacontology.projectvic.org/forensics#",
    "cacontology-detection": "https://cacontology.projectvic.org/detection#",
})

# Standard CASE investigation container
graph.add_node("kb:investigation-1", "case-investigation:Investigation", {
    "case-investigation:name": "ICAC Task Force Case 2024-1234",
    "uco-core:description": "Multi-jurisdictional CSAM investigation",
})

# Standard CASE forensic action
graph.add_node("kb:action-1", "case-investigation:InvestigativeAction", {
    "uco-core:name": "Hash Analysis",
    "uco-action:startTime": "2024-03-15T10:00:00Z",
})

# CAC-specific detection result (extends CASE concepts)
graph.add_node("kb:detection-1", "cacontology-detection:HashMatchDetection", {
    "uco-core:name": "PhotoDNA match against NCMEC database",
    "cacontology-detection:confidenceScore": 0.99,
})

graph.write("cac-investigation.jsonld")
```

### Validation

```bash
case_validate \
  --ontology-graph extensions/cac/ontology/ontology/cacontology-core-spine.ttl \
  --ontology-graph extensions/cac/ontology/ontology/cacontology-core-spine-shapes.ttl \
  --ontology-graph extensions/cac/ontology/ontology/cacontology-detection.ttl \
  --ontology-graph extensions/cac/ontology/ontology/cacontology-detection-shapes.ttl \
  cac-investigation.jsonld
```

Or use the manifest-driven validation helper:

```bash
make validate-extension EXT=cac DATA=cac-investigation.jsonld
```

## Using AEO Classes with CASE Investigations

The Adversary Engagement Ontology provides classes for modeling cyber deception operations — honeypots, decoys, lures, and adversary engagement narratives.

### Python

```python
from case_uco import CASEGraph

graph = CASEGraph(extra_context={
    "engagement": "https://ontology.adversaryengagement.org/ae/engagement/",
    "objective": "https://ontology.adversaryengagement.org/ae/objective/",
})

# A deception operation modeled as a CASE investigation
graph.add_node("kb:operation-1", "case-investigation:Investigation", {
    "case-investigation:name": "Honeypot Campaign Alpha",
})

# AEO-specific engagement concepts
graph.add_node("kb:honeypot-1", "engagement:Honeypot", {
    "uco-core:name": "SSH Honeypot (Cowrie)",
    "engagement:deploymentDate": "2024-01-15T00:00:00Z",
})

graph.add_node("kb:objective-1", "objective:Detect", {
    "uco-core:description": "Detect adversary lateral movement techniques",
})

graph.write("aeo-operation.jsonld")
```

## Mixing CAC and AEO in a Single Graph

Child exploitation investigations sometimes involve cyber deception techniques (e.g., undercover operations in online forums). Both extension ontologies can coexist in the same graph.

### Python

```python
from case_uco import CASEGraph

graph = CASEGraph(extra_context={
    "cac-core": "https://cacontology.projectvic.org/core#",
    "cacontology-undercover": "https://cacontology.projectvic.org/undercover#",
    "engagement": "https://ontology.adversaryengagement.org/ae/engagement/",
    "objective": "https://ontology.adversaryengagement.org/ae/objective/",
})

# The investigation spans both domains
graph.add_node("kb:investigation-1", "case-investigation:Investigation", {
    "case-investigation:name": "Operation Safe Haven",
    "uco-core:description": "Undercover operation targeting CSAM distribution network",
})

# CAC undercover operation modeling
graph.add_node("kb:undercover-1", "cacontology-undercover:UndercoverOperation", {
    "uco-core:name": "Forum Infiltration Phase",
})

# AEO engagement concepts for the cyber deception component
graph.add_node("kb:decoy-1", "engagement:Decoy", {
    "uco-core:name": "Decoy file share",
    "uco-core:description": "Monitored file share for tracking distribution",
})

graph.write("cross-domain.jsonld")
```

## MCP Server Configuration

To enable extension class discovery in the MCP server, set the `CASE_UCO_EXTENSIONS` environment variable in `.cursor/mcp.json`:

```json
{
  "mcpServers": {
    "case-uco": {
      "command": "python",
      "args": ["mcp_server/server.py"],
      "env": {
        "CASE_UCO_EXTENSIONS": "cac,aeo"
      }
    }
  }
}
```

Then use scoped searches:

```
search_classes("detection", scope="cac")     # CAC classes only
search_classes("honeypot", scope="aeo")      # AEO classes only
search_classes("investigation", scope="all") # Everything
```

## CDO Shapes Profile Compatibility

When using extension ontologies with CDO Shapes profiles, be aware of compatibility constraints:

- **CAC + CDO-Shapes-gufo**: Already included — CAC's semantic spine directly imports gUFO
- **CAC + CDO-Shapes-BFO**: Not recommended — BFO axioms may conflict with CAC's gUFO alignment
- **AEO + any CDO Shapes profile**: All compatible — AEO has no upper ontology dependency

Use `get_uco_profiles()` in the MCP server to see compatibility annotations for loaded extensions.

## Generating Extension Binding Packages

To generate publishable binding packages for an extension:

```bash
case-uco-generate generate-extension \
  --extension extensions/cac/ \
  --output-dir packages/case-uco-cac/ \
  --lang all
```

This produces:
- `packages/case-uco-cac/python/` — Python package with `pyproject.toml` and entry points
- `packages/case-uco-cac/csharp/` — C# project with `.csproj`
- `packages/case-uco-cac/java/` — Java project with `pom.xml`
- `packages/case-uco-cac/rust/` — Rust crate with `Cargo.toml`
- `packages/case-uco-cac/_registry.json` — Extension registry for MCP and runtime discovery
