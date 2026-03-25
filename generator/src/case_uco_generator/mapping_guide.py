"""Mapping guide generator — maps common forensic/cyber concepts to CASE/UCO classes.

Produces docs/MAPPING_GUIDE.md with predefined domain categories and
auto-populated class lists based on module membership and keyword matching.
Extension ontologies are included when available.
"""

from __future__ import annotations

from pathlib import Path

from case_uco_generator.schema_model import OntologyClass, OntologySchema, iri_local_name


DOMAIN_CATEGORIES: list[dict] = [
    {
        "title": "Files and Filesystem",
        "description": (
            "Classes for representing files, directories, file systems, and their "
            "metadata. Use these when your tool extracts or analyzes file-level artifacts."
        ),
        "modules": ["uco.observable"],
        "keywords": [
            "file", "path", "directory", "content", "filesystem", "volume",
            "disk", "partition", "ntfs", "ext", "fragment",
        ],
        "example_python": (
            'from case_uco.uco.observable import ObservableObject, FileFacet\n'
            '\n'
            'graph.create(ObservableObject, has_facet=[\n'
            '    FileFacet(file_name="evidence.dd", size_in_bytes=1073741824)\n'
            '])'
        ),
        "example_csharp": (
            'graph.Add(new ObservableObject {\n'
            '    HasFacet = { new FileFacet { FileName = "evidence.dd", SizeInBytes = 1073741824 } }\n'
            '});'
        ),
        "example_java": (
            'var facet = new FileFacet();\n'
            'facet.setFileName("evidence.dd");\n'
            'facet.setSizeInBytes(1073741824L);\n'
            'var obs = new ObservableObject();\n'
            'obs.getHasFacet().add(facet);\n'
            'graph.add(obs);'
        ),
        "example_rust": (
            'let facet = FileFacet::builder()\n'
            '    .file_name("evidence.dd".into())\n'
            '    .size_in_bytes(1073741824)\n'
            '    .build();\n'
            'graph.create(&ObservableObject::default());'
        ),
    },
    {
        "title": "Network Activity",
        "description": (
            "Classes for network connections, IP addresses, DNS records, URLs, and "
            "related artifacts. Use these when modeling network traffic captures, "
            "connection logs, or web-related evidence."
        ),
        "modules": ["uco.observable"],
        "keywords": [
            "network", "ip", "ipv4", "ipv6", "dns", "url", "uri", "domain",
            "connection", "socket", "tcp", "http", "port", "host", "protocol",
            "wifi", "wireless", "mac address",
        ],
        "example_python": (
            'from case_uco.uco.observable import ObservableObject, IPv4AddressFacet\n'
            '\n'
            'graph.create(ObservableObject, has_facet=[\n'
            '    IPv4AddressFacet(address_value="192.168.1.100")\n'
            '])'
        ),
        "example_csharp": (
            'graph.Add(new ObservableObject {\n'
            '    HasFacet = { new IPv4AddressFacet { AddressValue = "192.168.1.100" } }\n'
            '});'
        ),
        "example_java": (
            'var facet = new IPv4AddressFacet();\n'
            'facet.setAddressValue("192.168.1.100");\n'
            'var obs = new ObservableObject();\n'
            'obs.getHasFacet().add(facet);\n'
            'graph.add(obs);'
        ),
        "example_rust": (
            'let facet = IPv4AddressFacet::builder()\n'
            '    .address_value("192.168.1.100".into())\n'
            '    .build();\n'
            'graph.create(&ObservableObject::default());'
        ),
    },
    {
        "title": "Devices and Hardware",
        "description": (
            "Classes for physical and virtual devices, storage media, and hardware "
            "characteristics. Use these when documenting the devices involved in an "
            "investigation or the hardware from which data was extracted."
        ),
        "modules": ["uco.observable"],
        "keywords": [
            "device", "hardware", "computer", "phone", "mobile", "storage",
            "disk", "drive", "manufacturer", "model", "serial",
        ],
        "example_python": (
            'from case_uco.uco.observable import ObservableObject, DeviceFacet\n'
            '\n'
            'graph.create(ObservableObject, has_facet=[\n'
            '    DeviceFacet(manufacturer="ExampleCorp", model="X1000")\n'
            '])'
        ),
        "example_csharp": (
            'graph.Add(new ObservableObject {\n'
            '    HasFacet = { new DeviceFacet { Manufacturer = "ExampleCorp", Model = "X1000" } }\n'
            '});'
        ),
        "example_java": (
            'var facet = new DeviceFacet();\n'
            'facet.setManufacturer("ExampleCorp");\n'
            'facet.setModel("X1000");\n'
            'var obs = new ObservableObject();\n'
            'obs.getHasFacet().add(facet);\n'
            'graph.add(obs);'
        ),
        "example_rust": (
            'let facet = DeviceFacet::builder()\n'
            '    .manufacturer("ExampleCorp".into())\n'
            '    .model("X1000".into())\n'
            '    .build();\n'
            'graph.create(&ObservableObject::default());'
        ),
    },
    {
        "title": "Applications and Software",
        "description": (
            "Classes for installed applications, operating systems, software packages, "
            "and processes. Use these when modeling which software was present on a "
            "device or which processes were running."
        ),
        "modules": ["uco.observable"],
        "keywords": [
            "application", "software", "process", "browser", "operating system",
            "installed", "package", "program", "executable", "library",
        ],
        "example_python": (
            'from case_uco.uco.observable import ObservableObject, ApplicationFacet\n'
            '\n'
            'graph.create(ObservableObject, has_facet=[\n'
            '    ApplicationFacet(application_identifier="com.example.app")\n'
            '])'
        ),
        "example_csharp": (
            'graph.Add(new ObservableObject {\n'
            '    HasFacet = { new ApplicationFacet { ApplicationIdentifier = "com.example.app" } }\n'
            '});'
        ),
        "example_java": (
            'var facet = new ApplicationFacet();\n'
            'facet.setApplicationIdentifier("com.example.app");\n'
            'var obs = new ObservableObject();\n'
            'obs.getHasFacet().add(facet);\n'
            'graph.add(obs);'
        ),
        "example_rust": (
            'let facet = ApplicationFacet::builder()\n'
            '    .application_identifier("com.example.app".into())\n'
            '    .build();\n'
            'graph.create(&ObservableObject::default());'
        ),
    },
    {
        "title": "User Accounts and Identity",
        "description": (
            "Classes for user accounts, identities, organizations, and authentication "
            "artifacts. Use these when documenting who was involved, what accounts "
            "existed, or organizational relationships."
        ),
        "modules": ["uco.identity", "uco.observable"],
        "keywords": [
            "account", "user", "identity", "person", "organization", "profile",
            "credential", "authentication", "login", "password", "email address",
        ],
        "example_python": (
            'from case_uco.uco.observable import ObservableObject, AccountFacet\n'
            '\n'
            'graph.create(ObservableObject, has_facet=[\n'
            '    AccountFacet(account_identifier="user123")\n'
            '])'
        ),
        "example_csharp": (
            'graph.Add(new ObservableObject {\n'
            '    HasFacet = { new AccountFacet { AccountIdentifier = "user123" } }\n'
            '});'
        ),
        "example_java": (
            'var facet = new AccountFacet();\n'
            'facet.setAccountIdentifier("user123");\n'
            'var obs = new ObservableObject();\n'
            'obs.getHasFacet().add(facet);\n'
            'graph.add(obs);'
        ),
        "example_rust": (
            'let facet = AccountFacet::builder()\n'
            '    .account_identifier("user123".into())\n'
            '    .build();\n'
            'graph.create(&ObservableObject::default());'
        ),
    },
    {
        "title": "Email and Messaging",
        "description": (
            "Classes for email messages, SMS/MMS, chat messages, and communication "
            "metadata. Use these when modeling extracted communications."
        ),
        "modules": ["uco.observable"],
        "keywords": [
            "email", "message", "sms", "mms", "chat", "conversation",
            "attachment", "recipient", "sender", "subject", "mime",
        ],
        "example_python": (
            'from case_uco.uco.observable import ObservableObject, EmailMessageFacet\n'
            '\n'
            'graph.create(ObservableObject, has_facet=[\n'
            '    EmailMessageFacet(subject="Important evidence")\n'
            '])'
        ),
        "example_csharp": (
            'graph.Add(new ObservableObject {\n'
            '    HasFacet = { new EmailMessageFacet { Subject = "Important evidence" } }\n'
            '});'
        ),
        "example_java": (
            'var facet = new EmailMessageFacet();\n'
            'facet.setSubject("Important evidence");\n'
            'var obs = new ObservableObject();\n'
            'obs.getHasFacet().add(facet);\n'
            'graph.add(obs);'
        ),
        "example_rust": (
            'let facet = EmailMessageFacet::builder()\n'
            '    .subject("Important evidence".into())\n'
            '    .build();\n'
            'graph.create(&ObservableObject::default());'
        ),
    },
    {
        "title": "Mobile Forensics",
        "description": (
            "Classes specific to mobile device forensics: SIM cards, contacts, "
            "call logs, calendar entries, and cellular network artifacts."
        ),
        "modules": ["uco.observable"],
        "keywords": [
            "sim", "cell", "mobile", "imei", "imsi", "calendar", "contact",
            "call", "phone", "bluetooth", "gps", "location",
        ],
        "example_python": (
            'from case_uco.uco.observable import ObservableObject, SIMCardFacet\n'
            '\n'
            'graph.create(ObservableObject, has_facet=[\n'
            '    SIMCardFacet(icc_id="8901260123456789012")\n'
            '])'
        ),
        "example_csharp": (
            'graph.Add(new ObservableObject {\n'
            '    HasFacet = { new SIMCardFacet { IccId = "8901260123456789012" } }\n'
            '});'
        ),
        "example_java": (
            'var facet = new SIMCardFacet();\n'
            'facet.setIccId("8901260123456789012");\n'
            'var obs = new ObservableObject();\n'
            'obs.getHasFacet().add(facet);\n'
            'graph.add(obs);'
        ),
        "example_rust": (
            'let facet = SIMCardFacet::builder()\n'
            '    .icc_id("8901260123456789012".into())\n'
            '    .build();\n'
            'graph.create(&ObservableObject::default());'
        ),
    },
    {
        "title": "Actions and Events",
        "description": (
            "Classes for modeling actions taken during an investigation or actions "
            "performed by software/users that are relevant to the case. Includes "
            "action lifecycle tracking and patterns."
        ),
        "modules": ["uco.action"],
        "keywords": [
            "action", "event", "perform", "execute", "lifecycle", "result",
            "instrument", "environment",
        ],
        "example_python": (
            'from case_uco.uco.action import Action\n'
            '\n'
            'graph.create(Action, name="Disk Imaging", description="Created forensic image")'
        ),
        "example_csharp": (
            'graph.Add(new Action { Name = "Disk Imaging", Description = "Created forensic image" });'
        ),
        "example_java": (
            'var action = new Action();\n'
            'action.setName("Disk Imaging");\n'
            'action.setDescription("Created forensic image");\n'
            'graph.add(action);'
        ),
        "example_rust": (
            'let action = Action::builder()\n'
            '    .name("Disk Imaging".into())\n'
            '    .description("Created forensic image".into())\n'
            '    .build();\n'
            'graph.create(&action);'
        ),
    },
    {
        "title": "Investigation Metadata",
        "description": (
            "CASE-specific classes for structuring an investigation: cases, "
            "investigative actions, provenance records, and authorization."
        ),
        "modules": ["case.investigation"],
        "keywords": [
            "investigation", "case", "provenance", "authorization", "exhibit",
            "forensic", "examiner", "chain of custody",
        ],
        "example_python": (
            'from case_uco.case.investigation import Investigation, InvestigativeAction\n'
            '\n'
            'graph.create(Investigation, name="Case 2024-001")\n'
            'graph.create(InvestigativeAction, name="Device Acquisition")'
        ),
        "example_csharp": (
            'graph.Add(new Investigation { Name = "Case 2024-001" });\n'
            'graph.Add(new InvestigativeAction { Name = "Device Acquisition" });'
        ),
        "example_java": (
            'var inv = new Investigation();\n'
            'inv.setName("Case 2024-001");\n'
            'graph.add(inv);\n'
            'var action = new InvestigativeAction();\n'
            'action.setName("Device Acquisition");\n'
            'graph.add(action);'
        ),
        "example_rust": (
            'graph.create(&Investigation::builder().name("Case 2024-001".into()).build());\n'
            'graph.create(&InvestigativeAction::builder().name("Device Acquisition".into()).build());'
        ),
    },
    {
        "title": "Tool Information",
        "description": (
            "Classes for documenting forensic tools, their versions, build information, "
            "and configuration. Use these to record provenance about which tools "
            "produced the data."
        ),
        "modules": ["uco.tool"],
        "keywords": [
            "tool", "build", "version", "configuration", "software",
        ],
        "example_python": (
            'from case_uco.uco.tool import Tool\n'
            '\n'
            'graph.create(Tool, name="My Forensic Tool", version="3.0")'
        ),
        "example_csharp": (
            'graph.Add(new Tool { Name = "My Forensic Tool", Version = "3.0" });'
        ),
        "example_java": (
            'var tool = new Tool();\n'
            'tool.setName("My Forensic Tool");\n'
            'tool.setVersion("3.0");\n'
            'graph.add(tool);'
        ),
        "example_rust": (
            'let tool = Tool::builder()\n'
            '    .name("My Forensic Tool".into())\n'
            '    .version("3.0".into())\n'
            '    .build();\n'
            'graph.create(&tool);'
        ),
    },
    {
        "title": "Time and Temporal Data",
        "description": (
            "Classes for representing timestamps, time intervals, and temporal "
            "relationships between events."
        ),
        "modules": ["uco.time"],
        "keywords": [
            "time", "instant", "interval", "temporal", "duration", "timestamp",
            "date", "period",
        ],
        "example_python": (
            'from case_uco.uco.time import Instant\n'
            '\n'
            'graph.create(Instant)'
        ),
        "example_csharp": 'graph.Add(new Instant());',
        "example_java": 'graph.add(new Instant());',
        "example_rust": 'graph.create(&Instant::default());',
    },
    {
        "title": "Marking and Access Control",
        "description": (
            "Classes for marking data with handling restrictions, classification "
            "levels, TLP designations, and license information."
        ),
        "modules": ["uco.marking"],
        "keywords": [
            "marking", "classification", "tlp", "license", "handling",
            "restriction", "access", "granular",
        ],
        "example_python": (
            'from case_uco.uco.marking import MarkingDefinition\n'
            '\n'
            'graph.create(MarkingDefinition)'
        ),
        "example_csharp": 'graph.Add(new MarkingDefinition());',
        "example_java": 'graph.add(new MarkingDefinition());',
        "example_rust": 'graph.create(&MarkingDefinition::default());',
    },
]


_LARGE_MODULES = {"uco.observable"}


def _match_class(cls: OntologyClass, category: dict) -> bool:
    """Check if a class belongs to a category by module or keyword match.

    For large modules like uco.observable, module membership alone is not
    sufficient — the class must also match at least one keyword.
    """
    text = f"{cls.name} {cls.description}".lower()
    keyword_hit = any(kw in text for kw in category["keywords"])

    if cls.module in category["modules"]:
        if cls.module in _LARGE_MODULES:
            return keyword_hit
        return True

    return keyword_hit


def generate_mapping_guide(
    schema: OntologySchema,
    output_path: Path,
) -> Path:
    """Generate the comprehensive domain mapping guide."""
    lines: list[str] = []

    lines.append("# CASE/UCO Domain Mapping Guide")
    lines.append("")
    lines.append(
        "This guide maps common digital forensics, cyber-investigation, and "
        "cyber-observable concepts to the right CASE/UCO classes. If you know "
        "what kind of data you have but don't know which CASE/UCO class to use, "
        "start here."
    )
    lines.append("")
    lines.append(
        "For the complete class reference with all properties, see "
        "[ONTOLOGY_REFERENCE.md](../ONTOLOGY_REFERENCE.md)."
    )
    lines.append("")

    # TOC
    lines.append("## Contents")
    lines.append("")
    for cat in DOMAIN_CATEGORIES:
        anchor = cat["title"].lower().replace(" ", "-").replace("/", "")
        lines.append(f"- [{cat['title']}](#{anchor})")
    lines.append("- [Extension Ontologies](#extension-ontologies)")
    lines.append("- [Tips for Finding the Right Class](#tips-for-finding-the-right-class)")
    lines.append("")

    for cat in DOMAIN_CATEGORIES:
        _render_category(lines, schema, cat)

    _render_extensions(lines, schema)
    _render_tips(lines)

    output_path.parent.mkdir(parents=True, exist_ok=True)
    output_path.write_text("\n".join(lines), encoding="utf-8")
    return output_path


def _render_category(
    lines: list[str],
    schema: OntologySchema,
    category: dict,
) -> None:
    lines.append(f"## {category['title']}")
    lines.append("")
    lines.append(category["description"])
    lines.append("")

    matched: list[OntologyClass] = []
    for cls in schema.classes.values():
        if _match_class(cls, category):
            matched.append(cls)
    matched.sort(key=lambda c: c.name)

    if matched:
        lines.append("| Class | Module | Type | Description |")
        lines.append("|-------|--------|------|-------------|")
        for cls in matched:
            cls_type = "Facet" if cls.is_facet else "Class"
            desc = cls.description.replace("|", "\\|").replace("\n", " ")
            if len(desc) > 100:
                desc = desc[:97] + "..."
            lines.append(f"| **{cls.name}** | {cls.module} | {cls_type} | {desc} |")
        lines.append("")

        key_classes = [c for c in matched if not c.is_facet][:3]
        if not key_classes:
            key_classes = matched[:3]
        for cls in key_classes:
            all_props = schema.resolve_all_properties(cls)
            if all_props:
                lines.append(f"**{cls.name}** key properties:")
                lines.append("")
                lines.append("| Property | Type | Required |")
                lines.append("|----------|------|----------|")
                for prop in all_props[:8]:
                    type_name = iri_local_name(prop.range_iri)
                    req = "Yes" if prop.cardinality.is_required else "No"
                    lines.append(f"| {prop.name} | {type_name} | {req} |")
                if len(all_props) > 8:
                    lines.append(f"| *... {len(all_props) - 8} more* | | |")
                lines.append("")
    else:
        lines.append("*No matching classes found for this category.*")
        lines.append("")

    _render_examples(lines, category)


_LANG_LABELS = [
    ("example_python", "python", "Python"),
    ("example_csharp", "csharp", "C#"),
    ("example_java", "java", "Java"),
    ("example_rust", "rust", "Rust"),
]


def _render_examples(lines: list[str], category: dict) -> None:
    has_any = any(category.get(key) for key, _, _ in _LANG_LABELS)
    if not has_any:
        return

    lines.append("**Example usage:**")
    lines.append("")

    for key, lang_tag, label in _LANG_LABELS:
        example = category.get(key)
        if not example:
            continue
        lines.append(f"<details><summary>{label}</summary>")
        lines.append("")
        lines.append(f"```{lang_tag}")
        lines.append(example)
        lines.append("```")
        lines.append("")
        lines.append("</details>")
        lines.append("")


def _render_extensions(lines: list[str], schema: OntologySchema) -> None:
    lines.append("## Extension Ontologies")
    lines.append("")
    lines.append(
        "Extension ontologies add domain-specific classes beyond the core CASE/UCO "
        "specification. These are contributed by the community and may cover "
        "specialized forensic domains."
    )
    lines.append("")

    ext_modules = {
        key: iris for key, iris in schema.modules.items()
        if key.startswith("ext.")
    }

    if not ext_modules:
        lines.append(
            "*No extension ontologies loaded. Use `--extensions-dir` to include them.*"
        )
        lines.append("")
        return

    for module_key in sorted(ext_modules):
        ext_name = module_key.split(".", 1)[1]
        classes = sorted(
            (schema.classes[iri] for iri in ext_modules[module_key] if iri in schema.classes),
            key=lambda c: c.name,
        )
        lines.append(f"### {ext_name}")
        lines.append("")
        if classes:
            lines.append("| Class | Type | Description |")
            lines.append("|-------|------|-------------|")
            for cls in classes:
                cls_type = "Facet" if cls.is_facet else "Class"
                desc = cls.description.replace("|", "\\|").replace("\n", " ")
                if len(desc) > 100:
                    desc = desc[:97] + "..."
                lines.append(f"| **{cls.name}** | {cls_type} | {desc} |")
            lines.append("")


def _render_tips(lines: list[str]) -> None:
    lines.append("## Tips for Finding the Right Class")
    lines.append("")
    lines.append("1. **Start with the domain category** above that matches your data type.")
    lines.append("")
    lines.append(
        "2. **Use the CLI explorer** to search by keyword:\n"
        "   ```bash\n"
        '   case-uco-explore search "browser"\n'
        "   case-uco-explore class BrowserBookmarkFacet\n"
        "   ```"
    )
    lines.append("")
    lines.append(
        "3. **Use the runtime registry** for programmatic discovery in any language:\n"
        "\n"
        "   **Python:**\n"
        "   ```python\n"
        "   from case_uco.registry import search, get_class\n"
        '   search("browser")\n'
        '   get_class("BrowserBookmarkFacet")\n'
        "   ```\n"
        "\n"
        "   **C#:**\n"
        "   ```csharp\n"
        '   OntologyRegistry.Search("browser");\n'
        '   OntologyRegistry.GetClass("BrowserBookmarkFacet");\n'
        "   ```\n"
        "\n"
        "   **Java:**\n"
        "   ```java\n"
        '   OntologyRegistry.search("browser");\n'
        '   OntologyRegistry.getClass("BrowserBookmarkFacet");\n'
        "   ```\n"
        "\n"
        "   **Rust:**\n"
        "   ```rust\n"
        '   registry::search("browser");\n'
        '   registry::get_class("BrowserBookmarkFacet");\n'
        "   ```"
    )
    lines.append("")
    lines.append(
        "4. **Most observable data uses `ObservableObject` + Facets.** The pattern is:\n"
        "   - Create an `ObservableObject`\n"
        "   - Attach one or more Facets (e.g., `FileFacet`, `ContentDataFacet`) to describe it\n"
        "   - A single observable can have multiple facets"
    )
    lines.append("")
    lines.append(
        "5. **Check the full reference** in [ONTOLOGY_REFERENCE.md](../ONTOLOGY_REFERENCE.md) "
        "for complete property tables and inheritance hierarchies."
    )
    lines.append("")
    lines.append(
        "6. **Browse the ontology modules** to understand how classes are organized:\n"
        "   ```bash\n"
        "   case-uco-explore modules              # list all modules\n"
        "   case-uco-explore module observable     # browse a specific module\n"
        "   ```"
    )
    lines.append("")
