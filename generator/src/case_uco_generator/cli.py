"""CLI entry point for the CASE/UCO code generator."""

from __future__ import annotations

import argparse
import logging
import sys
from pathlib import Path

from case_uco_generator.ontology_parser import parse_ontology
from case_uco_generator.backends.python_backend import PythonBackend
from case_uco_generator.backends.csharp_backend import CSharpBackend
from case_uco_generator.backends.java_backend import JavaBackend
from case_uco_generator.backends.rust_backend import RustBackend


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(
        prog="case-uco-generate",
        description="Generate CASE/UCO ontology libraries from OWL+SHACL Turtle files.",
    )
    parser.add_argument(
        "command",
        choices=["generate"],
        help="Command to run",
    )
    parser.add_argument(
        "--lang",
        choices=["python", "csharp", "java", "rust", "all"],
        default="all",
        help="Target language (default: all)",
    )
    parser.add_argument(
        "--ontology-dir",
        type=Path,
        default=None,
        help="Path to ontology/ directory (default: auto-detect from repo root)",
    )
    parser.add_argument(
        "--output-dir",
        type=Path,
        default=None,
        help="Output root directory (default: repo root)",
    )
    parser.add_argument(
        "-v", "--verbose",
        action="store_true",
        help="Enable verbose logging",
    )

    args = parser.parse_args(argv)

    logging.basicConfig(
        level=logging.DEBUG if args.verbose else logging.INFO,
        format="%(levelname)s: %(message)s",
    )

    # Find repo root — walk up from CWD looking for ontology/ dir
    repo_root = args.output_dir or Path.cwd()
    ontology_dir = args.ontology_dir or repo_root / "ontology"

    if not ontology_dir.exists():
        logging.error("Ontology directory not found: %s", ontology_dir)
        return 1

    logging.info("Parsing ontology from %s ...", ontology_dir)
    schema = parse_ontology(ontology_dir)
    logging.info(
        "Parsed %d classes, %d vocabs across %d modules",
        len(schema.classes),
        len(schema.vocabs),
        len(schema.modules),
    )

    languages = (
        ["python", "csharp", "java", "rust"]
        if args.lang == "all"
        else [args.lang]
    )

    output_root = repo_root
    total_files = 0
    for lang in languages:
        logging.info("Generating %s library ...", lang)
        backend = _create_backend(lang, schema, output_root)
        files = backend.generate()
        total_files += len(files)
        logging.info("  -> %d files generated for %s", len(files), lang)

    logging.info("Done: %d total files generated.", total_files)
    return 0


def _create_backend(lang: str, schema, output_root: Path):
    backends = {
        "python": (PythonBackend, output_root / "python" / "case_uco"),
        "csharp": (CSharpBackend, output_root / "csharp" / "CaseUco"),
        "java": (JavaBackend, output_root / "java" / "src" / "main" / "java" / "org" / "caseontology"),
        "rust": (RustBackend, output_root / "rust" / "src"),
    }
    cls, out_dir = backends[lang]
    return cls(schema, out_dir)


if __name__ == "__main__":
    sys.exit(main())
