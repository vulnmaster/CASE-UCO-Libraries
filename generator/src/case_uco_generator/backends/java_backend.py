"""Java code generation backend — emits CASE/UCO classes using Apache Jena."""

from __future__ import annotations

from pathlib import Path

from case_uco_generator.backends.base import CodegenBackend
from case_uco_generator.schema_model import (
    Cardinality,
    OntologyClass,
    OntologyProperty,
    OntologyVocab,
    iri_local_name,
)


class JavaBackend(CodegenBackend):
    """Generate Java classes for CASE/UCO."""

    def generate(self) -> list[Path]:
        created: list[Path] = []

        for module_key, class_iris in sorted(self.schema.modules.items()):
            top, mod = module_key.split(".", 1)
            pkg_dir = self.output_dir / top / mod
            pkg_dir.mkdir(parents=True, exist_ok=True)

            classes = sorted(
                [self.schema.classes[iri] for iri in class_iris if iri in self.schema.classes],
                key=lambda c: c.name,
            )

            for cls in classes:
                file_path = pkg_dir / f"{cls.name}.java"
                content = self._render_class_file(top, mod, cls)
                file_path.write_text(content, encoding="utf-8")
                created.append(file_path)

            module_vocabs = self._vocabs_for_module(classes)
            for vocab in module_vocabs:
                file_path = pkg_dir / f"{vocab.name}.java"
                content = self._render_vocab_file(top, mod, vocab)
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

    def _render_class_file(self, top: str, mod: str, cls: OntologyClass) -> str:
        pkg = f"org.caseontology.{top}.{mod}"
        lines: list[str] = []
        lines.append(f"// Auto-generated CASE/UCO ontology class — do not edit manually.")
        lines.append(f"package {pkg};")
        lines.append("")
        lines.append("import java.util.ArrayList;")
        lines.append("import java.util.List;")
        lines.append("")

        parent_name = cls.all_parent_names[0] if cls.all_parent_names else None
        extends = f" extends {parent_name}" if parent_name else ""
        desc = cls.description[:200] if cls.description else cls.name

        lines.append(f"/** {desc} */")
        lines.append(f"public class {cls.name}{extends} {{")
        lines.append(f'    public static final String CLASS_IRI = "{cls.iri}";')
        lines.append(f'    public static final String NAMESPACE_PREFIX = "{cls.namespace_prefix}";')
        lines.append("")

        for prop in cls.properties:
            java_type = self._java_type(prop)
            field_name = self.to_camel_case(prop.name)
            field_name = self.safe_identifier(field_name, "java")
            lines.append(f"    private {java_type} {field_name};")

        lines.append("")

        # Constructor
        lines.append(f"    public {cls.name}() {{")
        for prop in cls.properties:
            if prop.cardinality.is_list:
                field_name = self.to_camel_case(prop.name)
                field_name = self.safe_identifier(field_name, "java")
                lines.append(f"        this.{field_name} = new ArrayList<>();")
        lines.append("    }")
        lines.append("")

        # Getters/setters
        for prop in cls.properties:
            java_type = self._java_type(prop)
            field_name = self.to_camel_case(prop.name)
            field_name = self.safe_identifier(field_name, "java")
            getter_name = f"get{self.to_pascal_case(prop.name)}"
            setter_name = f"set{self.to_pascal_case(prop.name)}"

            lines.append(f"    public {java_type} {getter_name}() {{ return this.{field_name}; }}")
            lines.append(f"    public {cls.name} {setter_name}({java_type} value) {{ this.{field_name} = value; return this; }}")
            lines.append("")

        lines.append("}")
        return "\n".join(lines)

    def _render_vocab_file(self, top: str, mod: str, vocab: OntologyVocab) -> str:
        pkg = f"org.caseontology.{top}.{mod}"
        lines: list[str] = []
        lines.append(f"// Auto-generated CASE/UCO vocabulary — do not edit manually.")
        lines.append(f"package {pkg};")
        lines.append("")
        lines.append(f"/** Vocabulary: {vocab.name} */")
        lines.append(f"public final class {vocab.name} {{")
        lines.append(f'    public static final String IRI = "{vocab.iri}";')
        for member in vocab.members:
            attr = self._vocab_attr_name(member)
            lines.append(f'    public static final String {attr} = "{member}";')
        lines.append("")
        lines.append(f"    private {vocab.name}() {{}}")
        lines.append("}")
        return "\n".join(lines)

    def _vocab_attr_name(self, member: str) -> str:
        name = member.replace(" ", "_").replace("-", "_").replace("(", "").replace(")", "")
        name = "".join(c if c.isalnum() or c == "_" else "_" for c in name)
        if name and name[0].isdigit():
            name = f"_{name}"
        return name.upper()

    def _java_type(self, prop: OntologyProperty) -> str:
        base = prop.type_name_for("java")
        # Box primitives for nullable
        boxed = {
            "boolean": "Boolean", "int": "Integer", "long": "Long",
            "float": "Float", "double": "Double", "short": "Short", "byte": "Byte",
        }
        if prop.cardinality.is_list:
            return f"List<{boxed.get(base, base)}>"
        if not prop.cardinality.is_required and base in boxed:
            return boxed[base]
        return base
