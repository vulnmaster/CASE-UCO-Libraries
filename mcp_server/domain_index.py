"""Domain index for AI-assisted CASE/UCO development.

Maps investigative tasks to SDK classes and provides a searchable recipe index,
optimized for consumption by AI coding agents via MCP tools.
"""

from __future__ import annotations

TASK_TO_CLASSES: dict[str, list[tuple[str, str]]] = {
    "model a forensic disk image extraction": [
        ("Investigation", "The case container"),
        ("InvestigativeAction", "The extraction action performed"),
        ("Tool", "The forensic tool used (e.g., FTK Imager, dd)"),
        ("ObservableObject", "The disk or device being imaged"),
        ("ImageFacet", "Disk image metadata (format, size)"),
        ("FileFacet", "Output image file details"),
        ("ContentDataFacet", "Hash values of the image"),
    ],
    "model mobile app data extraction": [
        ("Investigation", "The case container"),
        ("InvestigativeAction", "The extraction action"),
        ("Tool", "The extraction tool (e.g., Cellebrite, GrayKey)"),
        ("ObservableObject", "The mobile device"),
        ("DeviceFacet", "Device make, model, serial number"),
        ("ApplicationFacet", "The app being examined"),
        ("MessageFacet", "Chat messages found"),
        ("ContactFacet", "Contacts extracted"),
    ],
    "model network traffic capture": [
        ("Investigation", "The case container"),
        ("InvestigativeAction", "The capture action"),
        ("Tool", "The capture tool (e.g., Wireshark, tcpdump)"),
        ("ObservableObject", "Network connection or packet capture"),
        ("NetworkConnectionFacet", "Connection details (src/dst IP, ports)"),
        ("IPAddressFacet", "IP address details"),
        ("DomainNameFacet", "Domain name resolution"),
        ("URLFacet", "URLs observed in traffic"),
    ],
    "model email evidence": [
        ("Investigation", "The case container"),
        ("ObservableObject", "The email message"),
        ("EmailMessageFacet", "Email headers, subject, body"),
        ("EmailAddressFacet", "Sender/recipient addresses"),
        ("EmailAccountFacet", "Email account details"),
        ("ContentDataFacet", "Attachments and content hashes"),
    ],
    "model file system analysis": [
        ("Investigation", "The case container"),
        ("InvestigativeAction", "The analysis action"),
        ("Tool", "The analysis tool (e.g., Autopsy, EnCase)"),
        ("ObservableObject", "Files and directories found"),
        ("FileFacet", "File name, path, size, timestamps"),
        ("ContentDataFacet", "File hash values"),
        ("FileSystemFacet", "File system type and metadata"),
    ],
    "model browser history": [
        ("ObservableObject", "Browser artifact"),
        ("BrowserBookmarkFacet", "Bookmarked URLs"),
        ("URLHistoryFacet", "Browsing history entries"),
        ("URLFacet", "URL details"),
        ("CookieFacet", "Browser cookies"),
        ("ApplicationFacet", "The browser application"),
    ],
    "model chain of custody": [
        ("Investigation", "The case container"),
        ("ProvenanceRecord", "Custody transfer record"),
        ("InvestigativeAction", "Each custody event (receipt, transfer, analysis)"),
        ("Role", "Role of the person in custody chain"),
        ("Identity", "Person involved in custody"),
        ("ObservableObject", "The evidence item"),
    ],
    "model user account activity": [
        ("ObservableObject", "The account"),
        ("AccountFacet", "Account username, creation date"),
        ("DigitalAccountFacet", "Digital account details"),
        ("ApplicationAccountFacet", "App-specific account info"),
        ("Identity", "The account owner"),
    ],
    "model GPS or location data": [
        ("ObservableObject", "The location-bearing artifact"),
        ("LatLongCoordinatesFacet", "GPS coordinates"),
        ("GeoLocationEntryFacet", "Location log entry"),
        ("CellSiteFacet", "Cell tower connection data"),
    ],
    "model malware analysis": [
        ("Investigation", "The case container"),
        ("InvestigativeAction", "The analysis action"),
        ("Tool", "The analysis tool"),
        ("ObservableObject", "The malware sample"),
        ("FileFacet", "File details of the sample"),
        ("ContentDataFacet", "Hash values"),
        ("WindowsPEBinaryFileFacet", "PE header details"),
        ("OperatingSystemFacet", "Target OS"),
    ],
    "model social media evidence": [
        ("ObservableObject", "Social media content"),
        ("MessageFacet", "Messages or posts"),
        ("AccountFacet", "Social media account"),
        ("ProfileFacet", "User profile data"),
        ("URLFacet", "Links to content"),
        ("ApplicationFacet", "The social media platform"),
    ],
    "model registry or configuration artifacts": [
        ("ObservableObject", "The registry or config artifact"),
        ("WindowsRegistryKeyFacet", "Registry key path and values"),
        ("WindowsRegistryValueFacet", "Specific registry value"),
        ("ConfigurationEntryFacet", "Configuration setting"),
    ],
    "model wireless network evidence": [
        ("ObservableObject", "The wireless network"),
        ("WifiAddressFacet", "WiFi MAC address"),
        ("NetworkConnectionFacet", "Connection details"),
        ("SSIDFacet", "Network name / SSID"),
    ],
    "model a forensic tool and its capabilities": [
        ("Tool", "The forensic tool"),
        ("ObservableObject", "Tool-related observable"),
        ("ConfigurationEntryFacet", "Tool configuration"),
    ],
    "model digital evidence for court": [
        ("Investigation", "The case container"),
        ("ProvenanceRecord", "Provenance and chain of custody"),
        ("InvestigativeAction", "Each forensic step taken"),
        ("Tool", "Tools used with version information"),
        ("ObservableObject", "Evidence items"),
        ("ContentDataFacet", "Hash values for integrity verification"),
    ],
}

DOMAIN_CATEGORIES: list[dict[str, str | list[str]]] = [
    {
        "name": "files_and_filesystem",
        "title": "Files and Filesystem",
        "description": "Files, directories, file systems, and their metadata.",
        "keywords": ["file", "path", "directory", "content", "filesystem", "volume",
                     "disk", "partition", "ntfs", "ext", "fragment"],
    },
    {
        "name": "network_activity",
        "title": "Network Activity",
        "description": "Network connections, IP addresses, DNS records, URLs, and traffic captures.",
        "keywords": ["network", "ip", "address", "dns", "url", "domain", "tcp", "udp",
                     "http", "socket", "connection", "port", "packet"],
    },
    {
        "name": "devices_and_hardware",
        "title": "Devices and Hardware",
        "description": "Computers, phones, storage devices, and hardware components.",
        "keywords": ["device", "computer", "phone", "sim", "storage", "hardware",
                     "disk", "usb", "bluetooth"],
    },
    {
        "name": "applications_and_software",
        "title": "Applications and Software",
        "description": "Software applications, operating systems, and installed programs.",
        "keywords": ["application", "software", "operating system", "browser",
                     "program", "process", "service"],
    },
    {
        "name": "user_accounts_and_identity",
        "title": "User Accounts and Identity",
        "description": "User accounts, digital identities, authentication credentials.",
        "keywords": ["account", "identity", "user", "credential", "authentication",
                     "password", "profile", "digital account"],
    },
    {
        "name": "email_and_messaging",
        "title": "Email and Messaging",
        "description": "Email messages, chat messages, SMS, and messaging platforms.",
        "keywords": ["email", "message", "sms", "chat", "attachment", "messaging",
                     "calendar", "contact"],
    },
    {
        "name": "mobile_forensics",
        "title": "Mobile Forensics",
        "description": "Mobile device data, apps, call logs, GPS, and cell tower data.",
        "keywords": ["mobile", "phone", "call", "sms", "gps", "location", "cell",
                     "sim", "app", "android", "ios", "wifi"],
    },
    {
        "name": "actions_and_events",
        "title": "Actions and Events",
        "description": "Investigative actions, tool runs, observations, and analysis events.",
        "keywords": ["action", "event", "observation", "analysis", "pattern",
                     "lifecycle"],
    },
    {
        "name": "investigation_metadata",
        "title": "Investigation Metadata",
        "description": "Investigations, case metadata, provenance, and authorization.",
        "keywords": ["investigation", "case", "provenance", "authorization",
                     "exhibit", "custody"],
    },
    {
        "name": "tool_information",
        "title": "Tool Information",
        "description": "Forensic and analysis tools, their versions, and configurations.",
        "keywords": ["tool", "version", "configuration", "build"],
    },
    {
        "name": "time_and_temporal",
        "title": "Time and Temporal Data",
        "description": "Timestamps, time ranges, and temporal relationships.",
        "keywords": ["time", "date", "timestamp", "temporal", "instant", "interval"],
    },
    {
        "name": "marking_and_access_control",
        "title": "Marking and Access Control",
        "description": "Data markings, classification, TLP, and access restrictions.",
        "keywords": ["marking", "classification", "tlp", "access", "license",
                     "restriction"],
    },
]

CORE_PATTERNS: list[dict[str, str]] = [
    {
        "name": "ObservableObject + Facets",
        "description": (
            "The most common pattern. Create an ObservableObject and attach "
            "one or more Facets to describe it. A single observable can have "
            "multiple facets (e.g., FileFacet + ContentDataFacet for a file "
            "with its hash)."
        ),
        "python_example": (
            "graph.create(ObservableObject, has_facet=[\n"
            "    FileFacet(file_name='evidence.dd', size_in_bytes=1073741824),\n"
            "    ContentDataFacet(hash_method='SHA-256', hash_value='abc123...'),\n"
            "])"
        ),
    },
    {
        "name": "Investigation + Action + Tool",
        "description": (
            "Model a forensic workflow: an Investigation contains "
            "InvestigativeActions, each performed by a Tool that produces "
            "ObservableObjects as output."
        ),
        "python_example": (
            "inv = graph.create(Investigation, name='Case 2024-001')\n"
            "tool = graph.create(Tool, name='Autopsy', version='4.21.0')\n"
            "action = graph.create(InvestigativeAction, name='Disk analysis')"
        ),
    },
    {
        "name": "Identity + Role",
        "description": (
            "Associate a person or organization with a role in the "
            "investigation (examiner, subject, witness)."
        ),
        "python_example": (
            "person = graph.create(Identity, name='Jane Smith')\n"
            "role = graph.create(Role, name='Lead Examiner')"
        ),
    },
    {
        "name": "Provenance + Chain of Custody",
        "description": (
            "Track evidence handling with ProvenanceRecord and sequential "
            "InvestigativeActions for each custody event."
        ),
        "python_example": (
            "record = graph.create(ProvenanceRecord,\n"
            "    description='Evidence received from field office')"
        ),
    },
]

RECIPE_INDEX: list[dict[str, str | int]] = [
    {
        "title": "Modeling a Forensic Tool and Its Output",
        "description": "Create an investigation with a tool and investigative action.",
        "keywords": "tool investigation action forensic workflow",
        "file": "docs/RECIPES.md",
        "start_line": 42,
        "end_line": 163,
    },
    {
        "title": "File System Forensics",
        "description": "Model files, directories, and file system metadata from a disk analysis.",
        "keywords": "file directory filesystem disk analysis extraction",
        "file": "docs/RECIPES.md",
        "start_line": 165,
        "end_line": 267,
    },
    {
        "title": "Network Artifact Extraction",
        "description": "Model network connections, DNS records, IP addresses, and URLs.",
        "keywords": "network dns ip url connection traffic capture packet",
        "file": "docs/RECIPES.md",
        "start_line": 269,
        "end_line": 353,
    },
    {
        "title": "Mobile Device Forensics",
        "description": "Model mobile device extractions, app data, messages, and contacts.",
        "keywords": "mobile phone device app message contact sms call cellebrite graykey",
        "file": "docs/RECIPES.md",
        "start_line": 355,
        "end_line": 449,
    },
    {
        "title": "Email and Messaging",
        "description": "Model email messages, attachments, and messaging platform data.",
        "keywords": "email message attachment chat messaging calendar",
        "file": "docs/RECIPES.md",
        "start_line": 451,
        "end_line": 531,
    },
    {
        "title": "Chain of Custody",
        "description": "Track evidence handling, transfers, and provenance records.",
        "keywords": "custody chain provenance evidence handling transfer",
        "file": "docs/RECIPES.md",
        "start_line": 533,
        "end_line": 619,
    },
    {
        "title": "Discovering Classes at Runtime",
        "description": "Use the registry API to search for classes and inspect their properties.",
        "keywords": "search discover find class registry introspection",
        "file": "docs/RECIPES.md",
        "start_line": 621,
        "end_line": 740,
    },
    {
        "title": "Working with Extensions",
        "description": "Use extension ontology classes alongside the core SDK.",
        "keywords": "extension custom ontology scaffold toolcap",
        "file": "docs/RECIPES.md",
        "start_line": 742,
        "end_line": 833,
    },
    {
        "title": "Round-Trip: Serialize and Deserialize",
        "description": "Write a graph to JSON-LD and load it back with typed deserialization.",
        "keywords": "serialize deserialize load save round-trip json-ld",
        "file": "docs/RECIPES.md",
        "start_line": 835,
        "end_line": 903,
    },
    {
        "title": "Managing Large Datasets",
        "description": "Partition large evidence sets by forensic boundary, estimate graph sizes.",
        "keywords": "large dataset partition split merge performance volume",
        "file": "docs/RECIPES.md",
        "start_line": 905,
        "end_line": 1025,
    },
]
