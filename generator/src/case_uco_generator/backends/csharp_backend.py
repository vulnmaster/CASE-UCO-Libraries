"""C# code generation backend — emits CASE/UCO classes using dotNetRdf."""

from __future__ import annotations

from pathlib import Path

from case_uco_generator.backends.base import CodegenBackend
from case_uco_generator.schema_model import (
    Cardinality,
    OntologyClass,
    OntologyProperty,
    OntologySchema,
    OntologyVocab,
    iri_local_name,
)


class CSharpBackend(CodegenBackend):
    """Generate C# classes for CASE/UCO."""

    def generate(self) -> list[Path]:
        created: list[Path] = []

        for module_key, class_iris in sorted(self.schema.modules.items()):
            top, mod = module_key.split(".", 1)
            ns_dir = self.output_dir / self.to_pascal_case(top)
            ns_dir.mkdir(parents=True, exist_ok=True)
            file_path = ns_dir / f"{self.to_pascal_case(mod)}.cs"

            classes = sorted(
                [self.schema.classes[iri] for iri in class_iris if iri in self.schema.classes],
                key=lambda c: c.name,
            )

            module_vocabs = self._vocabs_for_module(classes)
            content = self._render_module(top, mod, classes, module_vocabs)
            file_path.write_text(content, encoding="utf-8")
            created.append(file_path)

        return created

    def _vocabs_for_module(self, classes: list[OntologyClass]) -> list[OntologyVocab]:
        vocab_iris: set[str] = set()
        for cls in classes:
            for prop in cls.properties:
                if prop.is_vocab_type and prop.range_iri in self.schema.vocabs:
                    vocab_iris.add(prop.range_iri)
        return [self.schema.vocabs[iri] for iri in sorted(vocab_iris)]

    def _render_module(
        self, top: str, mod: str, classes: list[OntologyClass], vocabs: list[OntologyVocab]
    ) -> str:
        ns = f"CaseUco.{self.to_pascal_case(top)}.{self.to_pascal_case(mod)}"
        lines: list[str] = []
        lines.append("// Auto-generated CASE/UCO ontology classes — do not edit manually.")
        lines.append(f"// Module: {top}-{mod}")
        lines.append("")
        lines.append("using System;")
        lines.append("using System.Collections.Generic;")
        lines.append("")
        lines.append(f"namespace {ns}")
        lines.append("{")

        for vocab in vocabs:
            lines.extend(self._render_vocab(vocab, indent=1))
            lines.append("")

        for cls in classes:
            lines.extend(self._render_class(cls, indent=1))
            lines.append("")

        lines.append("}")
        return "\n".join(lines)

    def _render_vocab(self, vocab: OntologyVocab, indent: int) -> list[str]:
        pad = "    " * indent
        lines: list[str] = []
        lines.append(f"{pad}/// <summary>Vocabulary: {vocab.name}</summary>")
        lines.append(f"{pad}public static class {vocab.name}")
        lines.append(f"{pad}{{")
        lines.append(f'{pad}    public const string IRI = "{vocab.iri}";')
        for member in vocab.members:
            attr = self._vocab_attr_name(member)
            lines.append(f'{pad}    public const string {attr} = "{member}";')
        lines.append(f"{pad}}}")
        return lines

    def _vocab_attr_name(self, member: str) -> str:
        name = member.replace(" ", "_").replace("-", "_").replace("(", "").replace(")", "")
        name = "".join(c if c.isalnum() or c == "_" else "_" for c in name)
        if name and name[0].isdigit():
            name = f"_{name}"
        return name

    def _render_class(self, cls: OntologyClass, indent: int) -> list[str]:
        pad = "    " * indent
        lines: list[str] = []

        parent_name = cls.all_parent_names[0] if cls.all_parent_names else None
        base = f" : {parent_name}" if parent_name else ""

        lines.append(f"{pad}/// <summary>{cls.description[:200] if cls.description else cls.name}</summary>")
        lines.append(f"{pad}public class {cls.name}{base}")
        lines.append(f"{pad}{{")
        lines.append(f'{pad}    public const string ClassIri = "{cls.iri}";')
        lines.append(f'{pad}    public const string NamespacePrefix = "{cls.namespace_prefix}";')

        for prop in cls.properties:
            cs_type = self._csharp_type(prop)
            prop_name = self.to_pascal_case(prop.name)
            prop_name = self.safe_identifier(prop_name, "csharp")
            lines.append(f"{pad}    public {cs_type} {prop_name} {{ get; set; }}")

        lines.append(f"{pad}}}")
        return lines

    def _csharp_type(self, prop: OntologyProperty) -> str:
        base = prop.type_name_for("csharp")
        if prop.cardinality.is_list:
            return f"List<{base}>"
        if not prop.cardinality.is_required:
            return f"{base}?"  # Nullable in C# 8+
        return base
