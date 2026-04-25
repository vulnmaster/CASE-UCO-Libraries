#!/usr/bin/env python3
"""Validate extension ontology data against its manifest-declared TTL files.

Usage:
    python scripts/validate_extension.py extensions/cac/manifest.json data.jsonld
    python scripts/validate_extension.py extensions/aeo/manifest.json data.jsonld

Reads the manifest.json to discover all OWL and SHACL files, then invokes
case_validate with the appropriate --ontology-graph flags.
"""

from __future__ import annotations

import json
import subprocess
import sys
from pathlib import Path


def main() -> int:
    if len(sys.argv) < 3:
        print(f"Usage: {sys.argv[0]} <manifest.json> <data.jsonld>", file=sys.stderr)
        return 1

    manifest_path = Path(sys.argv[1])
    data_path = Path(sys.argv[2])

    if not manifest_path.exists():
        print(f"Manifest not found: {manifest_path}", file=sys.stderr)
        return 1

    if not data_path.exists():
        print(f"Data file not found: {data_path}", file=sys.stderr)
        return 1

    manifest = json.loads(manifest_path.read_text(encoding="utf-8"))
    ext_dir = manifest_path.parent
    ext_name = manifest.get("name", ext_dir.name)

    ontology_graphs: list[str] = []
    for key in ("owl_files", "shacl_files", "bridge_files"):
        for rel_path in manifest.get(key, []):
            full_path = ext_dir / rel_path
            if full_path.exists():
                ontology_graphs.append(str(full_path))
            else:
                print(f"  Warning: {rel_path} not found (skipping)", file=sys.stderr)

    print(f"Validating with extension '{ext_name}'")
    print(f"  Ontology graphs: {len(ontology_graphs)}")
    print(f"  Data file: {data_path}")

    cmd = ["case_validate"]
    for graph_path in ontology_graphs:
        cmd.extend(["--ontology-graph", graph_path])
    cmd.append(str(data_path))

    print(f"  Running: {' '.join(cmd[:6])} ... ({len(cmd) - 1} args total)")
    result = subprocess.run(cmd)
    return result.returncode


if __name__ == "__main__":
    sys.exit(main())
