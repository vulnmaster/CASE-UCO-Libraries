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
from case_uco_generator.backends.docs_backend import DocsBackend
from case_uco_generator.mapping_guide import generate_mapping_guide
from case_uco_generator.scaffold import scaffold_extension


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(
        prog="case-uco-generate",
        description="Generate CASE/UCO ontology libraries from OWL+SHACL Turtle files.",
    )
    parser.add_argument(
        "-v", "--verbose",
        action="store_true",
        help="Enable verbose logging",
    )

    subparsers = parser.add_subparsers(dest="command", help="Command to run")

    # --- generate subcommand ---
    gen_parser = subparsers.add_parser("generate", help="Generate typed libraries from ontology sources")
    gen_parser.add_argument(
        "--lang",
        choices=["python", "csharp", "java", "rust", "all"],
        default="all",
        help="Target language (default: all)",
    )
    gen_parser.add_argument("--ontology-dir", type=Path, default=None)
    gen_parser.add_argument("--output-dir", type=Path, default=None)
    gen_parser.add_argument("--extensions-dir", type=Path, default=None)
    gen_parser.add_argument("--no-extensions", action="store_true")

    # --- scaffold subcommand ---
    scaf_parser = subparsers.add_parser(
        "scaffold",
        help="Generate starter classes from an extension ontology TTL",
    )
    scaf_parser.add_argument(
        "--extension",
        type=Path,
        required=True,
        nargs="+",
        help="Path(s) to extension .ttl file(s) (OWL + SHACL shapes)",
    )
    scaf_parser.add_argument(
        "--lang",
        choices=["python", "csharp", "java", "rust", "all"],
        default="all",
        help="Target language(s) for scaffolded classes (default: all)",
    )
    scaf_parser.add_argument(
        "--output-dir",
        type=Path,
        default=None,
        help="Output directory for scaffolded files (default: current directory)",
    )

    args = parser.parse_args(argv)

    logging.basicConfig(
        level=logging.DEBUG if args.verbose else logging.INFO,
        format="%(levelname)s: %(message)s",
    )

    if not args.command:
        parser.print_help()
        return 1

    if args.command == "generate":
        return _cmd_generate(args)
    elif args.command == "scaffold":
        return _cmd_scaffold(args)

    return 0


def _cmd_generate(args) -> int:
    repo_root = args.output_dir or Path.cwd()
    ontology_dir = args.ontology_dir or repo_root / "ontology"
    extensions_dir = None if args.no_extensions else (args.extensions_dir or repo_root / "extensions")

    if not ontology_dir.exists():
        logging.error("Ontology directory not found: %s", ontology_dir)
        return 1

    logging.info("Parsing ontology from %s ...", ontology_dir)
    schema = parse_ontology(ontology_dir, extensions_dir=extensions_dir)
    logging.info(
        "Parsed %d classes, %d vocabs across %d modules",
        len(schema.classes), len(schema.vocabs), len(schema.modules),
    )

    languages = (
        ["python", "csharp", "java", "rust"]
        if args.lang == "all"
        else [args.lang]
    )

    core_schema = schema.without_extensions()
    output_root = repo_root
    total_files = 0
    for lang in languages:
        logging.info("Generating %s library ...", lang)
        backend = _create_backend(lang, core_schema, output_root)
        files = backend.generate()
        total_files += len(files)
        logging.info("  -> %d files generated for %s", len(files), lang)

    logging.info("Generating ontology reference ...")
    docs_backend = DocsBackend(schema, output_root)
    docs_files = docs_backend.generate()
    total_files += len(docs_files)
    logging.info("  -> %s", docs_files[0])

    logging.info("Generating mapping guide ...")
    guide_path = generate_mapping_guide(schema, output_root / "docs" / "MAPPING_GUIDE.md")
    total_files += 1
    logging.info("  -> %s", guide_path)

    if "python" in languages or args.lang == "all":
        logging.info("Generating runtime registry (full schema with extensions) ...")
        registry_backend = PythonBackend(schema, output_root / "python" / "case_uco")
        registry_path = registry_backend._emit_registry()
        logging.info("  -> %s", registry_path)

    logging.info("Done: %d total files generated.", total_files)
    return 0


def _cmd_scaffold(args) -> int:
    ttl_paths = [Path(p) for p in args.extension]
    for p in ttl_paths:
        if not p.exists():
            logging.error("Extension file not found: %s", p)
            return 1

    languages = (
        ["python", "csharp", "java", "rust"]
        if args.lang == "all"
        else [args.lang]
    )

    output_dir = args.output_dir or Path.cwd()
    logging.info("Scaffolding extension from %s ...", ", ".join(str(p) for p in ttl_paths))

    created = scaffold_extension(ttl_paths, output_dir, languages)

    if not created:
        logging.warning("No classes found. Ensure the TTL has OWL classes with SHACL NodeShapes.")
        return 1

    logging.info("Done: %d scaffolded files created.", len(created))
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
