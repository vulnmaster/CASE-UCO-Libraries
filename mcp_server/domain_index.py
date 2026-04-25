"""Domain index for AI-assisted CASE/UCO development.

Maps investigative tasks to SDK classes and provides a searchable recipe index,
optimized for consumption by AI coding agents via MCP tools.
"""

from __future__ import annotations

# ---------------------------------------------------------------------------
# UCO vs. CASE triage
# ---------------------------------------------------------------------------

CASE_INDICATORS: list[str] = [
    "investigation", "investigative", "forensic lifecycle", "examiner",
    "exhibit", "custody", "authorization", "warrant", "provenance",
    "analyst", "technician", "role", "case metadata", "chain of custody",
    "investigator", "examination", "reporting phase", "case management",
]

UCO_INDICATORS: list[str] = [
    "observable", "facet", "device", "file", "network", "account",
    "identity", "action", "tool", "location", "marking", "pattern",
    "configuration", "hash", "address", "application", "software",
    "email", "message", "url", "domain", "disk", "partition",
    "process", "service", "credential", "browser", "registry",
    "mobile", "sim", "bluetooth", "wifi", "gps", "telemetry",
    "crypto", "malware", "artifact", "content", "data", "log",
]


def suggest_target_repo(concept: str, description: str = "") -> dict[str, str]:
    """Suggest whether a proposed concept belongs in UCO or CASE.

    Returns ``{"suggestion": "UCO"|"CASE"|"unsure", "reasoning": "..."}``.
    """
    text = f"{concept} {description}".lower()

    case_score = sum(1 for kw in CASE_INDICATORS if kw in text)
    uco_score = sum(1 for kw in UCO_INDICATORS if kw in text)

    if case_score > 0 and uco_score == 0:
        return {
            "suggestion": "CASE",
            "reasoning": (
                f"The concept matches investigation-specific indicators "
                f"({', '.join(k for k in CASE_INDICATORS if k in text)}). "
                f"CASE covers concepts specific to the cyber-investigation process."
            ),
        }

    if uco_score > 0 and case_score == 0:
        return {
            "suggestion": "UCO",
            "reasoning": (
                f"The concept matches general cyber-domain indicators "
                f"({', '.join(k for k in UCO_INDICATORS if k in text)}). "
                f"UCO covers observables, identities, actions, and data structures "
                f"with broad utility across the cyber domain."
            ),
        }

    if uco_score > case_score:
        return {
            "suggestion": "UCO",
            "reasoning": (
                f"The concept matches both UCO ({uco_score}) and CASE ({case_score}) "
                f"indicators, but leans toward UCO. UCO covers general cyber-domain "
                f"concepts; CASE covers investigation-specific concepts."
            ),
        }

    if case_score > uco_score:
        return {
            "suggestion": "CASE",
            "reasoning": (
                f"The concept matches both CASE ({case_score}) and UCO ({uco_score}) "
                f"indicators, but leans toward CASE. CASE covers investigation-specific "
                f"concepts; UCO covers general cyber-domain concepts."
            ),
        }

    return {
        "suggestion": "unsure",
        "reasoning": (
            "Unable to determine whether this concept belongs in UCO (general "
            "cyber-domain) or CASE (investigation-specific). Please consider: "
            "Is this concept specific to the process of conducting an investigation "
            "(roles, exhibits, authorization, case metadata)? If so, target CASE. "
            "Is it a general observable, identity, tool, or data structure with "
            "utility beyond investigation? If so, target UCO."
        ),
    }


# ---------------------------------------------------------------------------
# Change proposal template sections
# ---------------------------------------------------------------------------

CHANGE_PROPOSAL_SECTIONS: dict[str, str] = {
    "background": (
        "# Background\n\n"
        "{background}\n"
    ),
    "requirements": (
        "# Requirements\n\n"
        "{requirements}\n"
    ),
    "risk_benefit": (
        "# Risk / Benefit analysis\n\n"
        "## Benefits\n\n{benefits}\n\n"
        "## Risks\n\n{risks}\n"
    ),
    "competencies": (
        "# Competencies demonstrated\n\n"
        "{competencies}\n"
    ),
    "solution": (
        "# Solution suggestion\n\n"
        "{solution}\n"
    ),
}

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
    "model AI image analysis or ML inference pipeline": [
        ("Investigation", "The case container"),
        ("InvestigativeAction", "Each step in the analysis pipeline (one per model/tool)"),
        ("AnalyticTool", "The AI/ML model or analysis tool"),
        ("RasterPicture", "Image files (use instead of File for .jpg, .png, etc.)"),
        ("RasterPictureFacet", "Image dimensions, compression, picture type"),
        ("FileFacet", "Filename, path, size, timestamps"),
        ("ContentDataFacet", "Hashes and MIME type for evidentiary integrity"),
        ("ConfidenceFacet", "Per-result similarity/confidence score"),
        ("Relationship", "Explicit input/output links (Selected_From, Derived_From)"),
        ("ProvenanceRecord", "Groups the pipeline and its artifacts"),
    ],
    "model digital evidence for court": [
        ("Investigation", "The case container"),
        ("ProvenanceRecord", "Provenance and chain of custody"),
        ("InvestigativeAction", "Each forensic step taken"),
        ("Tool", "Tools used with version information"),
        ("ObservableObject", "Evidence items"),
        ("ContentDataFacet", "Hash values for integrity verification"),
    ],
    "model online grooming and cybertip workflow": [
        ("CACInvestigation", "The CAC-specific investigation container (from cac extension)"),
        ("GroomingBehavior", "The grooming behavior event with phases (from cac extension)"),
        ("OnlineGrooming", "Online grooming behavior subclass (from cac extension)"),
        ("GroomingMessage", "Grooming-specific message with explicitness/tone (from cac extension)"),
        ("ChildVictim", "Child victim role with vulnerability modeling (from cac extension)"),
        ("OnlinePredator", "Online predator role (from cac extension)"),
        ("NCMECCybertipReport", "NCMEC CyberTipline report structure (from cac extension)"),
        ("OnlineEnticementIncident", "NCMEC incident type for enticement (from cac extension)"),
        ("MessageThread", "Core UCO chat thread container"),
        ("MessageFacet", "Core UCO message metadata"),
        ("ApplicationAccount", "Core UCO social media account"),
        ("RasterPicture", "Core UCO image for CSAM evidence"),
        ("Relationship", "Core UCO links between entities"),
    ],
    "model child sex trafficking ring or recruitment network": [
        ("CACInvestigation", "The CAC investigation container (from cac extension)"),
        ("TraffickingEnterprise", "Trafficking ring / network organization (from cac extension)"),
        ("TraffickingRing", "Specific ring structure with role hierarchy (from cac extension)"),
        ("TraffickingCell", "Sub-cell within a ring (from cac extension)"),
        ("TraffickingVictimRole", "Victim role in the trafficking enterprise (from cac extension)"),
        ("MinorTraffickingVictimRole", "Minor-specific trafficking victim role (from cac extension)"),
        ("TraffickingVictimRescue", "Rescue event tied to a trafficking victim (from cac extension)"),
        ("VictimRotation", "Movement of victims between locations/buyers (from cac extension)"),
        ("InterstateVictimTransport", "Cross-state movement of victims (from cac extension)"),
        ("InterstateTraffickingNetwork", "Trafficking network spanning multiple states (from cac extension)"),
        ("PeerRecruitmentNetwork", "Peer-to-peer recruitment chains (from cac extension)"),
        ("ClassmateRecruitmentNetwork", "Classmate-to-classmate recruitment chains (from cac extension)"),
        ("SchoolBasedRecruitment", "Recruitment occurring at or via schools (from cac extension)"),
        ("StreetBasedRecruitment", "Pretext-based street recruitment (from cac extension)"),
        ("HelpOfferApproach", "'Need help?' pretext approach (from cac extension)"),
        ("FoodOfferApproach", "Food-offer pretext approach (from cac extension)"),
        ("TransportationOfferApproach", "Transportation-offer pretext approach (from cac extension)"),
        ("PhoneChargingOffer", "Phone-charging pretext approach (from cac extension)"),
        ("RapidEscalationRecruitment", "Compressed-timeline recruitment pattern (from cac extension)"),
        ("DigitalToPhysicalBridge", "Online-to-offline meet event (from cac extension)"),
        ("MandatoryReportingActivation", "Triggering of mandatory-reporter obligations (from cac extension)"),
        ("Identity", "Core UCO identity for traffickers, recruiters, victims"),
        ("Relationship", "Core UCO link between participants and the enterprise"),
    ],
    "model multi-jurisdictional task force operation or rescue": [
        ("CACInvestigation", "The CAC investigation container (from cac extension)"),
        ("Jurisdiction", "Jurisdiction at any level (from cac extension)"),
        ("LocalJurisdiction", "City/county-level jurisdiction (from cac extension)"),
        ("StateJurisdiction", "State-level jurisdiction (from cac extension)"),
        ("FederalJurisdiction", "Federal jurisdiction (e.g., FBI, HSI) (from cac extension)"),
        ("InternationalJurisdiction", "Cross-border jurisdiction (from cac extension)"),
        ("TaskForce", "Multi-agency task force (e.g., ICAC) (from cac extension)"),
        ("JointInvestigation", "Investigation spanning agencies (from cac extension)"),
        ("JurisdictionalHandoff", "Transfer of investigative lead between agencies (from cac extension)"),
        ("MutualAidRequest", "Cross-jurisdiction request for assistance (from cac extension)"),
        ("MassChildRescueOperation", "Coordinated multi-victim rescue (from cac extension)"),
        ("InvestigativeAction", "Core CASE action for each operational step"),
        ("ProvenanceRecord", "Provenance binding the operation's evidence"),
    ],
    "model tactical arrest or high-risk operation": [
        ("CACInvestigation", "The CAC investigation container (from cac extension)"),
        ("ArrestOperation", "Arrest operation event (from cac extension)"),
        ("HighRiskArrest", "High-risk arrest sub-type (from cac extension)"),
        ("DynamicEntry", "Forced/dynamic entry event (from cac extension)"),
        ("SuspectProfile", "Pre-operation suspect threat/profile (from cac extension)"),
        ("ThreatAssessment", "Pre-operation threat assessment (from cac extension)"),
        ("UndercoverOperation", "Undercover operation context (from cac extension)"),
        ("AssetForfeitureAction", "Property seizure tied to CSE/trafficking (from cac extension)"),
        ("InvestigativeAction", "Core CASE action wrapper"),
        ("Tool", "Core UCO tool for tactical equipment, where applicable"),
        ("Identity", "Core UCO identity for officers and suspects"),
    ],
    "model victim rescue extraction and post-rescue services": [
        ("CACInvestigation", "The CAC investigation container (from cac extension)"),
        ("EmergencyResponse", "Initial emergency response to identified victim (from cac extension)"),
        ("VictimExtraction", "Physical extraction of a victim (from cac extension)"),
        ("OngoingDangerAssessment", "Post-rescue danger assessment (from cac extension)"),
        ("SafetyPlanning", "Victim safety plan (from cac extension)"),
        ("MultiAgencyVictimResponse", "DCFS / medical / mental-health coordination (from cac extension)"),
        ("TraumaIndicator", "Observed trauma indicator on victim (from cac extension)"),
        ("HelpSeekingBarrier", "Barrier preventing victim from seeking help (from cac extension)"),
        ("RecantationAssessment", "Victim recantation assessment (from cac extension)"),
        ("PartialRecantationStatement", "Partial recantation statement (from cac extension)"),
        ("ReaffirmedDisclosureStatement", "Disclosure reaffirmed after pressure to recant (from cac extension)"),
        ("PostRecantationForensicInterview", "Forensic interview following recantation (from cac extension)"),
        ("ChildVictim", "Child victim role with vulnerability modeling (from cac extension)"),
        ("InvestigativeAction", "Core CASE action wrapper"),
    ],
    "model CSAM provenance forensics and victim identification": [
        ("ForensicAcquisitionAction", "Forensic acquisition of CSAM evidence (from cac extension)"),
        ("ChainOfCustodyAction", "Each chain-of-custody event (from cac extension)"),
        ("EvidenceVerificationAction", "Hash/signature verification (from cac extension)"),
        ("MetadataCorrelation", "EXIF / file-system / app metadata correlation (from cac extension)"),
        ("TemporalPatternAnalysis", "Temporal-pattern analysis across artifacts (from cac extension)"),
        ("GeospatialCorrelation", "Geospatial correlation of CSAM/related evidence (from cac extension)"),
        ("CrossPlatformCorrelation", "Same actor/victim across multiple platforms (from cac extension)"),
        ("BehavioralFingerprinting", "Behavioral pattern fingerprinting of an offender (from cac extension)"),
        ("VictimIdentificationProcess", "Victim ID workflow against known-victim data (from cac extension)"),
        ("ContentHashingTool", "PhotoDNA / perceptual hashing tool (from cac extension)"),
        ("RasterPicture", "Core UCO image for the CSAM artifact"),
        ("ContentDataFacet", "Core UCO hashes for evidentiary integrity"),
        ("ProvenanceRecord", "Core CASE provenance record"),
        ("Relationship", "Core UCO links between artifacts, actors, and actions"),
    ],
    "model CSAM detection and platform reporting to NCMEC": [
        ("AutomatedDetectionAction", "Platform CSAM detection action (from cac extension)"),
        ("ContentHashingTool", "PhotoDNA or perceptual hashing tool (from cac extension)"),
        ("MachineLearningDetectionTool", "ML-based CSAM classifier (from cac extension)"),
        ("DetectionResult", "Detection confidence and classification (from cac extension)"),
        ("NCMECCybertipReport", "NCMEC CyberTipline report (from cac extension)"),
        ("PlatformCooperation", "ESP cooperation with law enforcement (from cac extension)"),
        ("ElectronicServiceProvider", "The reporting platform organization (from cac extension)"),
        ("ContentModerationAction", "Platform content moderation event (from cac extension)"),
        ("InvestigativeAction", "Core CASE investigative action"),
        ("AnalyticTool", "Core UCO analytic tool"),
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
        "description": "Investigative actions, tool runs, observations, analysis events, and AI/ML inference pipelines.",
        "keywords": ["action", "event", "observation", "analysis", "pattern",
                     "lifecycle", "pipeline", "inference", "ai", "ml",
                     "prediction", "detection"],
    },
    {
        "name": "investigation_metadata",
        "title": "Investigation Metadata",
        "description": "Investigations, case metadata, provenance, and authorization.",
        "keywords": ["investigation", "case", "provenance", "authorization",
                     "exhibit", "custody"],
    },
    {
        "name": "child_exploitation",
        "title": "Child Exploitation and Crimes Against Children",
        "description": "Online grooming, CSAM detection, CyberTip reports, NCMEC workflows, sextortion, victim identification, and platform reporting.",
        "keywords": ["child", "csam", "grooming", "ncmec", "cybertip", "exploitation",
                     "victim", "offender", "enticement", "sextortion", "predator",
                     "minor", "abuse", "production", "hotline", "cac",
                     "icac", "crimes against children"],
    },
    {
        "name": "child_trafficking",
        "title": "Child Sex Trafficking and Exploitation Networks",
        "description": (
            "Trafficking rings, cells, and role hierarchies; victim rotation and "
            "interstate transport; recruitment networks (school-based, peer, "
            "street pretexts such as help/food/transportation/phone-charging "
            "offers); rapid-escalation recruitment; vulnerability indicators; "
            "digital-to-physical bridge events; mass child rescue operations."
        ),
        "keywords": ["trafficking", "traffic", "trafficker", "trafficked",
                     "ring", "cell", "rotation", "transport", "interstate",
                     "recruitment", "recruit", "recruiter", "pretext",
                     "school-based", "peer", "street", "vulnerability",
                     "digital-to-physical", "bridge", "rescue",
                     "mass rescue", "csec", "cse"],
    },
    {
        "name": "victim_rescue_response",
        "title": "Victim Rescue, Extraction, and Post-Rescue Response",
        "description": (
            "Emergency response to identified victims, victim extraction, "
            "ongoing-danger and threat assessments, safety planning, "
            "trauma indicators, help-seeking barriers, recantation, and "
            "multi-agency victim response (DCFS, medical, mental health)."
        ),
        "keywords": ["rescue", "extraction", "extract", "emergency",
                     "safety", "safe", "trauma", "victim impact",
                     "victim service", "victim response", "recantation",
                     "danger", "threat assessment", "help-seeking",
                     "multi-agency", "dcfs", "child protective"],
    },
    {
        "name": "multi_jurisdictional_operations",
        "title": "Multi-Jurisdictional Operations and Task Forces",
        "description": (
            "Local/State/Federal/International jurisdictions, joint "
            "investigations, ICAC and HSI task forces, jurisdictional "
            "handoffs, mutual aid requests, federal/state legal "
            "harmonization, and international cooperation."
        ),
        "keywords": ["jurisdiction", "jurisdictional", "multi-jurisdiction",
                     "taskforce", "task force", "joint investigation",
                     "joint operation", "handoff", "mutual aid",
                     "federal", "state", "local", "international",
                     "interpol", "hsi", "fbi", "icac", "harmonization",
                     "cooperation"],
    },
    {
        "name": "tactical_operations",
        "title": "Tactical and Arrest Operations",
        "description": (
            "Arrest operations (high-risk and standard), dynamic entry, "
            "suspect profiling, threat assessment, undercover operations, "
            "specialized units, and asset forfeiture tied to CSE/trafficking."
        ),
        "keywords": ["tactical", "arrest", "high-risk", "dynamic entry",
                     "suspect profile", "undercover", "specialized unit",
                     "swat", "warrant service", "asset forfeiture",
                     "seizure", "operation", "raid"],
    },
    {
        "name": "csam_provenance",
        "title": "CSAM Forensics, Chain of Custody, and Provenance",
        "description": (
            "Forensic acquisition of CSAM evidence, chain-of-custody actions, "
            "evidence verification, metadata correlation, temporal pattern "
            "analysis, geospatial correlation, cross-platform correlation, "
            "behavioral fingerprinting, and victim identification processes."
        ),
        "keywords": ["acquisition", "chain of custody", "evidence verification",
                     "metadata correlation", "temporal pattern",
                     "geospatial correlation", "cross-platform",
                     "behavioral fingerprint", "victim identification",
                     "provenance", "csam forensic", "image hashing",
                     "perceptual hash", "photodna"],
    },
    {
        "name": "tool_information",
        "title": "Tool Information",
        "description": "Forensic and analysis tools, AI/ML models, their versions, and configurations.",
        "keywords": ["tool", "version", "configuration", "build", "model",
                     "analytic", "classifier", "neural", "embedding"],
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

UCO_PROFILES: list[dict[str, str | list[str] | dict[str, str]]] = [
    {
        "id": "bfo",
        "name": "CDO-Shapes-BFO",
        "full_name": "Basic Formal Ontology (BFO 2020)",
        "ontology_url": "https://github.com/BFO-ontology/BFO-2020",
        "repo_url": "https://github.com/Cyber-Domain-Ontology/CDO-Shapes-BFO",
        "profile_type": "top-level",
        "ontology_file": "uco-bfo.ttl",
        "status": "exploratory",
        "description": (
            "Grounds UCO in BFO's Endurant/Perdurant distinction. "
            "Useful for formal reasoning, biomedical and scientific ontology interop."
        ),
        "keywords": ["bfo", "foundational", "upper", "top-level", "endurant",
                      "perdurant", "formal", "reasoning", "biomedical", "scientific"],
        "related_domains": ["actions_and_events", "time_and_temporal"],
        "related_recipes": ["docs/recipes/existence-intervals.md"],
        "extension_compatibility": {
            "cac": "not_recommended",
            "aeo": "compatible",
        },
    },
    {
        "id": "gufo",
        "name": "CDO-Shapes-gufo",
        "full_name": "gentle Unified Foundational Ontology (gUFO)",
        "ontology_url": "https://github.com/nemo-ufes/gufo",
        "repo_url": "https://github.com/Cyber-Domain-Ontology/CDO-Shapes-gufo",
        "profile_type": "top-level",
        "ontology_file": "uco-gufo.ttl",
        "status": "exploratory",
        "description": (
            "Grounds UCO in gUFO types and relators (OntoUML-based). "
            "The CAC Ontology extends both UCO/CASE and gUFO."
        ),
        "keywords": ["gufo", "ontouml", "foundational", "upper", "top-level",
                      "relator", "cac", "children", "project vic"],
        "related_domains": ["actions_and_events", "time_and_temporal"],
        "related_recipes": ["docs/recipes/existence-intervals.md"],
        "extension_compatibility": {
            "cac": "included",
            "aeo": "compatible",
        },
    },
    {
        "id": "prov-o",
        "name": "CDO-Shapes-PROV-O",
        "full_name": "W3C PROV-O (Provenance Ontology)",
        "ontology_url": "https://www.w3.org/TR/prov-o/",
        "repo_url": "https://github.com/Cyber-Domain-Ontology/CDO-Shapes-PROV-O",
        "profile_type": "adopting",
        "ontology_file": "uco-prov-o.ttl",
        "status": "exploratory",
        "description": (
            "Aligns UCO actions and provenance concepts with PROV-O Activities, "
            "Entities, and Agents for W3C provenance tooling interop."
        ),
        "keywords": ["provenance", "prov-o", "prov", "w3c", "activity", "entity",
                      "agent", "custody", "chain", "lineage", "derivation"],
        "related_domains": ["investigation_metadata", "actions_and_events"],
        "related_recipes": ["docs/recipes/chain-of-custody.md"],
        "extension_compatibility": {
            "cac": "compatible",
            "aeo": "compatible",
        },
    },
    {
        "id": "time",
        "name": "CDO-Shapes-Time",
        "full_name": "W3C OWL-Time",
        "ontology_url": "https://www.w3.org/TR/owl-time/",
        "repo_url": "https://github.com/Cyber-Domain-Ontology/CDO-Shapes-Time",
        "profile_type": "adopting",
        "ontology_file": "uco-time.ttl",
        "status": "exploratory",
        "description": (
            "Aligns UCO temporal concepts with OWL-Time instants and intervals "
            "for temporal reasoning, calendar/clock time modeling."
        ),
        "keywords": ["time", "temporal", "owl-time", "w3c", "instant", "interval",
                      "duration", "calendar", "clock", "period"],
        "related_domains": ["time_and_temporal"],
        "related_recipes": ["docs/recipes/existence-intervals.md"],
        "extension_compatibility": {
            "cac": "compatible",
            "aeo": "compatible",
        },
    },
    {
        "id": "geosparql",
        "name": "CDO-Shapes-GeoSPARQL",
        "full_name": "OGC GeoSPARQL 1.1",
        "ontology_url": "https://github.com/opengeospatial/ogc-geosparql",
        "repo_url": "https://github.com/Cyber-Domain-Ontology/CDO-Shapes-GeoSPARQL",
        "profile_type": "adopting",
        "ontology_file": "uco-geo.ttl",
        "status": "exploratory",
        "description": (
            "Aligns UCO locations with GeoSPARQL Features and Geometries "
            "for geospatial queries, CRS, and spatial reasoning."
        ),
        "keywords": ["geosparql", "geospatial", "geo", "spatial", "gps",
                      "location", "coordinate", "geometry", "feature", "ogc", "gis"],
        "related_domains": ["mobile_forensics"],
        "related_recipes": ["docs/recipes/location.md", "docs/recipes/cell-site.md"],
        "extension_compatibility": {
            "cac": "compatible",
            "aeo": "compatible",
        },
    },
    {
        "id": "foaf",
        "name": "CDO-Shapes-FOAF",
        "full_name": "Friend-of-a-Friend (FOAF)",
        "ontology_url": "http://xmlns.com/foaf/0.1/",
        "repo_url": "https://github.com/Cyber-Domain-Ontology/CDO-Shapes-FOAF",
        "profile_type": "adopting",
        "ontology_file": "uco-foaf.ttl",
        "status": "exploratory",
        "description": (
            "Aligns UCO identities with FOAF Persons, Organizations, and Agents "
            "for social network data and Linked Data interop."
        ),
        "keywords": ["foaf", "friend", "social", "identity", "person",
                      "organization", "agent", "linked data", "social network"],
        "related_domains": ["user_accounts_and_identity"],
        "related_recipes": ["docs/recipes/accounts.md"],
        "extension_compatibility": {
            "cac": "compatible",
            "aeo": "compatible",
        },
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

RECIPE_INDEX: list[dict[str, str]] = [
    {
        "title": "Modeling a Forensic Tool and Its Output",
        "description": "Create an investigation with a tool and investigative action.",
        "keywords": "tool investigation action forensic workflow",
        "file": "docs/recipes/forensic-tool.md",
    },
    {
        "title": "File System Forensics",
        "description": "Model files, directories, and file system metadata from a disk analysis.",
        "keywords": "file directory filesystem disk analysis extraction",
        "file": "docs/recipes/file-system.md",
    },
    {
        "title": "Network Artifact Extraction",
        "description": "Model network connections, DNS records, IP addresses, and URLs.",
        "keywords": "network dns ip url connection traffic capture packet",
        "file": "docs/recipes/network-artifacts.md",
    },
    {
        "title": "Mobile Device Forensics",
        "description": "Model mobile device extractions, app data, messages, and contacts.",
        "keywords": "mobile phone device app message contact sms call cellebrite graykey",
        "file": "docs/recipes/mobile-device.md",
    },
    {
        "title": "Email and Messaging",
        "description": "Model email messages, attachments, and messaging platform data.",
        "keywords": "email message attachment chat messaging calendar",
        "file": "docs/recipes/email-messaging.md",
    },
    {
        "title": "Chain of Custody",
        "description": "Track evidence handling, transfers, and provenance records.",
        "keywords": "custody chain provenance evidence handling transfer",
        "file": "docs/recipes/chain-of-custody.md",
    },
    {
        "title": "Discovering Classes at Runtime",
        "description": "Use the registry API to search for classes and inspect their properties.",
        "keywords": "search discover find class registry introspection",
        "file": "docs/recipes/runtime-discovery.md",
    },
    {
        "title": "Working with Extensions",
        "description": "Use extension ontology classes alongside the core SDK.",
        "keywords": "extension custom ontology scaffold toolcap",
        "file": "docs/recipes/extensions.md",
    },
    {
        "title": "Round-Trip: Serialize and Deserialize",
        "description": "Write a graph to JSON-LD and load it back with typed deserialization.",
        "keywords": "serialize deserialize load save round-trip json-ld",
        "file": "docs/recipes/round-trip.md",
    },
    {
        "title": "Managing Large Datasets",
        "description": "Partition large evidence sets by forensic boundary, estimate graph sizes.",
        "keywords": "large dataset partition split merge performance volume",
        "file": "docs/recipes/large-datasets.md",
    },
    {
        "title": "Call Log Records",
        "description": "Model phone call records, carrier accounts, and conference bridges.",
        "keywords": "call log phone carrier voip conference bridge dialer incoming outgoing missed",
        "file": "docs/recipes/call-log.md",
    },
    {
        "title": "SMS Messages and Contacts",
        "description": "Model SMS/MMS messages and contact list entries with account linking.",
        "keywords": "sms mms text message contact phone number account sim",
        "file": "docs/recipes/sms-and-contacts.md",
    },
    {
        "title": "EXIF and Image Metadata",
        "description": "Model image files with EXIF metadata, camera identification, and provenance.",
        "keywords": "exif image photo jpeg camera metadata gps picture raster",
        "file": "docs/recipes/exif-data.md",
    },
    {
        "title": "Database Record Extraction",
        "description": "Model SQLite records, table fields, and containment relationships.",
        "keywords": "database sqlite record table field row column wal journal sql",
        "file": "docs/recipes/database-records.md",
    },
    {
        "title": "Cell Site and Tower Data",
        "description": "Model cell tower connections, SIM cards, CDR data, and location tracking.",
        "keywords": "cell site tower cdr sim card imei imsi carrier antenna location tracking mobile",
        "file": "docs/recipes/cell-site.md",
    },
    {
        "title": "Forensic Analysis and Artifact Classification",
        "description": "Model malware analysis, automated classification with confidence scores.",
        "keywords": "analysis malware reverse engineering classification confidence artifact yara ida",
        "file": "docs/recipes/analysis.md",
    },
    {
        "title": "AI/ML Analysis Pipelines",
        "description": "Model AI/ML analysis workflows — multi-step inference, image search, per-result scoring, ranked outputs, and full provenance.",
        "keywords": "ai ml machine learning inference pipeline image search semantic embedding clip model scoring ranking similarity confidence raster picture photo detection prediction neural network",
        "file": "docs/recipes/ai-analysis-pipeline.md",
    },
    {
        "title": "Multi-Platform Account Linking",
        "description": "Model cross-platform identity correlation across social media, email, and cloud accounts.",
        "keywords": "account identity person facebook google email digital platform social media linking",
        "file": "docs/recipes/accounts.md",
    },
    {
        "title": "Configured Tools",
        "description": "Model forensic tools with specific configurations, command-line flags, and rulesets.",
        "keywords": "configured tool configuration ruleset flag parameter ida volatility",
        "file": "docs/recipes/configured-tool.md",
    },
    {
        "title": "Device and Workstation Modeling",
        "description": "Model computers and workstations with hardware specs, network addresses, and OS.",
        "keywords": "device workstation computer hardware cpu ram bios hostname ip address server desktop",
        "file": "docs/recipes/device.md",
    },
    {
        "title": "Events and Authentication Logs",
        "description": "Model authentication events, login/logout actions, and system events.",
        "keywords": "event authentication login logout mfa credential session log audit",
        "file": "docs/recipes/event.md",
    },
    {
        "title": "Location Modeling",
        "description": "Model geospatial locations with street addresses and GPS coordinates.",
        "keywords": "location address gps latitude longitude coordinates geolocation place site",
        "file": "docs/recipes/location.md",
    },
    {
        "title": "Advanced File Patterns",
        "description": "Model archives, encryption, SQLite blobs, and nested containment chains.",
        "keywords": "archive tar zip encrypted encoded base64 sqlite blob nested containment layer stream",
        "file": "docs/recipes/advanced-file-patterns.md",
    },
    {
        "title": "File Fragments and Multipart Files",
        "description": "Model split files, fragment reassembly, and embedded data like thumbnails.",
        "keywords": "fragment multipart split carve reassemble thumbnail embedded raw data",
        "file": "docs/recipes/file-fragments.md",
    },
    {
        "title": "File Recovery and Carving",
        "description": "Model recovered and carved files with recovery status and reconstruction workflows.",
        "keywords": "recovery carve carved reconstruct recovered scalpel photorec foremost deleted",
        "file": "docs/recipes/file-recovery.md",
    },
    {
        "title": "Threaded Messaging (WhatsApp, Chat)",
        "description": "Model ordered chat conversations with threads, participants, and attachments.",
        "keywords": "thread chat whatsapp messenger conversation participant attachment media social",
        "file": "docs/recipes/threaded-messaging.md",
    },
    {
        "title": "Mobile Device and SIM Card",
        "description": "Model a mobile handset with SIM card, carrier, IMEI/IMSI, and OS.",
        "keywords": "mobile device sim card imei imsi iccid carrier bluetooth wifi mac handset smartphone",
        "file": "docs/recipes/mobile-device-sim.md",
    },
    {
        "title": "Network Investigation with Bundle",
        "description": "Model a complete network investigation with warrant, PCAP extraction, and provenance.",
        "keywords": "network investigation bundle warrant authorization pcap capture connection host",
        "file": "docs/recipes/network-investigation.md",
    },
    {
        "title": "Forensic Investigation Lifecycle",
        "description": "Model ordered investigation phases: survey, preservation, examination, analysis, reporting.",
        "keywords": "lifecycle phase survey preservation examination analysis reporting ordered action",
        "file": "docs/recipes/forensic-lifecycle.md",
    },
    {
        "title": "Disk Partitions and Volume Recovery",
        "description": "Model disk partition structures, volumes, file systems, and deleted partition recovery.",
        "keywords": "partition disk volume filesystem recovery deleted sector offset table gpt mbr",
        "file": "docs/recipes/partitions.md",
    },
    {
        "title": "Bulk Extractor Forensic Paths",
        "description": "Model nested containment paths from bulk extraction tools with byte offsets.",
        "keywords": "bulk extractor forensic path nested containment compressed gzip offset binwalk",
        "file": "docs/recipes/bulk-extractor-path.md",
    },
    {
        "title": "Existence Intervals and Temporal Modeling",
        "description": "Model time-bounded existence with OWL-Time, gUFO, and BFO ontology patterns.",
        "keywords": "temporal interval time owl-time gufo bfo existence period duration role cac",
        "file": "docs/recipes/existence-intervals.md",
    },
    {
        "title": "Spear Phishing and Attack Narratives",
        "description": "Model spear-phishing attack chains with malware delivery and victim targeting.",
        "keywords": "spear phishing attack malware email payload exploit victim threat narrative incident",
        "file": "docs/recipes/spear-phishing.md",
    },
    {
        "title": "Online Grooming Chat Modeling",
        "description": "Model grooming chat evidence and CAC behavioral interpretation with phase progression, role separation, and message-level classification.",
        "keywords": "grooming csam child exploitation victim offender snapchat chat message phase escalation cac ontology crimes against children",
        "file": "docs/recipes/grooming-chat-modeling.md",
    },
    {
        "title": "NCMEC CyberTip Reporting Workflow",
        "description": "Model platform detection, ESP reporting, NCMEC CyberTip lifecycle, investigation triggering, and platform cooperation using CAC Ontology classes.",
        "keywords": "cybertip ncmec platform reporting enticement detection investigation trigger esp cooperation cac ontology crimes against children",
        "file": "docs/recipes/cybertip-ncmec-workflow.md",
    },
    {
        "title": "Proposing Changes to CASE/UCO",
        "description": "Identify gaps, research existing proposals, and draft change proposals for new ontology concepts.",
        "keywords": "change proposal gap missing concept extension contribute upstream issue ontology committee",
        "file": "docs/recipes/change-proposal.md",
    },
    {
        "title": "Starter Kit: Filesystem Report Mapping",
        "description": "End-to-end mapping of a filesystem report to CASE/UCO.",
        "keywords": "starter kit filesystem file report triage mapping end-to-end hash",
        "file": "docs/recipes/starter-filesystem-report.md",
        "is_starter_kit": True,
    },
    {
        "title": "Starter Kit: Mobile Extraction Mapping",
        "description": "End-to-end mapping of a mobile device extraction to CASE/UCO.",
        "keywords": "starter kit mobile phone extraction cellebrite graykey mapping end-to-end",
        "file": "docs/recipes/starter-mobile-extraction.md",
        "is_starter_kit": True,
    },
    {
        "title": "Starter Kit: Email Export Mapping",
        "description": "End-to-end mapping of an email export to CASE/UCO.",
        "keywords": "starter kit email export pst mbox mapping end-to-end",
        "file": "docs/recipes/starter-email-export.md",
        "is_starter_kit": True,
    },
    {
        "title": "Starter Kit: Tool Run Mapping",
        "description": "End-to-end mapping of a forensic tool run to CASE/UCO.",
        "keywords": "starter kit tool run action autopsy encase mapping end-to-end",
        "file": "docs/recipes/starter-tool-run.md",
        "is_starter_kit": True,
    },
]

# ---------------------------------------------------------------------------
# Mapping guide index — step-by-step guidance for common evidence sources
# ---------------------------------------------------------------------------

MAPPING_GUIDE_INDEX: list[dict] = [
    {
        "source": "filesystem report",
        "keywords": ["file", "directory", "triage", "listing", "report", "csv", "hash", "filesystem"],
        "pattern": "ObservableObject + FileFacet + ContentDataFacet",
        "classes": ["ObservableObject", "FileFacet", "ContentDataFacet", "InvestigativeAction", "Tool"],
        "anti_patterns": [
            "Don't create a separate ObservableObject for each facet — one object can have multiple facets",
            "Don't use Tool as a top-level evidence item — it describes the instrument, not the evidence",
        ],
        "starter_kit": "docs/recipes/starter-filesystem-report.md",
        "code_skeleton": "graph.create(ObservableObject, has_facet=[FileFacet(file_name=...), ContentDataFacet(hash_method=..., hash_value=...)])",
    },
    {
        "source": "mobile device extraction",
        "keywords": ["mobile", "phone", "cellebrite", "graykey", "ufed", "extraction", "android", "ios", "smartphone"],
        "pattern": "ObservableObject + DeviceFacet + ApplicationFacet + MessageFacet",
        "classes": ["ObservableObject", "DeviceFacet", "ApplicationFacet", "MessageFacet", "ContactFacet", "InvestigativeAction", "Tool"],
        "anti_patterns": [
            "Don't model the phone as an InvestigativeAction — the phone is an ObservableObject, the extraction is the action",
            "Don't flatten app data into one facet — use separate facets for messages, contacts, call logs",
        ],
        "starter_kit": "docs/recipes/starter-mobile-extraction.md",
        "code_skeleton": "device = graph.create(ObservableObject, has_facet=[DeviceFacet(manufacturer=..., model=...)])",
    },
    {
        "source": "email export",
        "keywords": ["email", "pst", "mbox", "eml", "outlook", "thunderbird", "gmail", "exchange", "mail"],
        "pattern": "ObservableObject + EmailMessageFacet + EmailAddressFacet",
        "classes": ["ObservableObject", "EmailMessageFacet", "EmailAddressFacet", "EmailAccountFacet", "ContentDataFacet"],
        "anti_patterns": [
            "Don't model sender and recipient as the same ObservableObject — use separate EmailAddressFacet instances",
            "Don't skip the EmailAccountFacet when account-level metadata is available",
        ],
        "starter_kit": "docs/recipes/starter-email-export.md",
        "code_skeleton": "graph.create(ObservableObject, has_facet=[EmailMessageFacet(subject=..., sent_time=...)])",
    },
    {
        "source": "forensic tool run",
        "keywords": ["tool", "autopsy", "encase", "ftk", "volatility", "sleuthkit", "run", "execution", "scan"],
        "pattern": "Investigation + InvestigativeAction + Tool + ObservableObject",
        "classes": ["Investigation", "InvestigativeAction", "Tool", "ObservableObject", "ProvenanceRecord"],
        "anti_patterns": [
            "Don't omit the Tool object — always record which tool (and version) performed the action",
            "Don't model tool output without linking it to the InvestigativeAction that produced it",
        ],
        "starter_kit": "docs/recipes/starter-tool-run.md",
        "code_skeleton": "tool = graph.create(Tool, name=..., version=...)\naction = graph.create(InvestigativeAction, name=..., instrument=tool)",
    },
    {
        "source": "pcap network capture",
        "keywords": ["pcap", "packet", "capture", "wireshark", "tcpdump", "network", "traffic", "sniff"],
        "pattern": "ObservableObject + NetworkConnectionFacet + IPAddressFacet",
        "classes": ["ObservableObject", "NetworkConnectionFacet", "IPAddressFacet", "DomainNameFacet", "URLFacet", "InvestigativeAction", "Tool"],
        "anti_patterns": [
            "Don't model each packet as a separate ObservableObject — group by connection or flow",
            "Don't put IP addresses in NetworkConnectionFacet text fields — use separate IPAddressFacet objects",
        ],
        "starter_kit": None,
        "code_skeleton": "graph.create(ObservableObject, has_facet=[NetworkConnectionFacet(src_ip=..., dst_ip=..., dst_port=...)])",
    },
    {
        "source": "disk image",
        "keywords": ["disk", "image", "dd", "e01", "raw", "ewf", "forensic", "acquisition", "clone"],
        "pattern": "ObservableObject + ImageFacet + ContentDataFacet + FileFacet",
        "classes": ["ObservableObject", "ImageFacet", "FileFacet", "ContentDataFacet", "InvestigativeAction", "Tool"],
        "anti_patterns": [
            "Don't confuse ImageFacet (disk image metadata) with picture/photo image data",
            "Don't skip ContentDataFacet — hash values are critical for disk image integrity",
        ],
        "starter_kit": None,
        "code_skeleton": "graph.create(ObservableObject, has_facet=[ImageFacet(image_type=...), ContentDataFacet(hash_method='SHA-256', hash_value=...)])",
    },
    {
        "source": "browser history",
        "keywords": ["browser", "history", "bookmark", "cookie", "chrome", "firefox", "safari", "edge", "url", "web"],
        "pattern": "ObservableObject + URLHistoryFacet + BrowserBookmarkFacet + CookieFacet",
        "classes": ["ObservableObject", "URLHistoryFacet", "BrowserBookmarkFacet", "CookieFacet", "URLFacet", "ApplicationFacet"],
        "anti_patterns": [
            "Don't model each URL visit as a separate ObservableObject — use URLHistoryFacet entries",
            "Don't forget ApplicationFacet to identify which browser produced the history",
        ],
        "starter_kit": None,
        "code_skeleton": "graph.create(ObservableObject, has_facet=[URLHistoryFacet(browser_info=..., url=..., last_visited=...)])",
    },
    {
        "source": "ai ml image analysis",
        "keywords": ["ai", "ml", "machine learning", "inference", "model", "image", "search",
                     "semantic", "embedding", "clip", "neural", "prediction", "detection",
                     "classification", "scoring", "ranking", "similarity", "pipeline",
                     "photo", "picture", "raster", "rescuebox"],
        "pattern": "InvestigativeAction (per pipeline step) + AnalyticTool + RasterPicture + ConfidenceFacet + Relationship",
        "classes": ["InvestigativeAction", "AnalyticTool", "RasterPicture", "RasterPictureFacet",
                    "FileFacet", "ContentDataFacet", "ConfidenceFacet", "Relationship",
                    "ProvenanceRecord", "Directory"],
        "anti_patterns": [
            "Don't hide structured facts (model name, query, thresholds, scores) inside uco-core:description as JSON strings — use explicit properties or ConfiguredTool",
            "Don't use ArtifactClassification for tool endpoint names — classification describes what the artifact IS (content label), not which tool processed it",
            "Don't model a multi-step pipeline as a single InvestigativeAction — each model/step gets its own action with its own inputs, outputs, and timestamps",
            "Don't use generic File or ObservableObject for image files — use RasterPicture with RasterPictureFacet",
            "Don't omit per-result scores — use ConfidenceFacet on each result for ranking and explainability",
            "Don't omit hashes and sizes on evidence files — without them the graph is a workflow log, not an evidentiary record",
        ],
        "starter_kit": None,
        "code_skeleton": (
            "# One InvestigativeAction per pipeline step\n"
            "step = graph.create(InvestigativeAction, name=..., instrument=[tool], object=[inputs], result=[outputs])\n"
            "# RasterPicture with score\n"
            "img = graph.create(RasterPicture, has_facet=[FileFacet(...), ContentDataFacet(hash=[...]), RasterPictureFacet(...), ConfidenceFacet(confidence=0.87)])\n"
            "# Explicit relationship\n"
            "graph.create(Relationship, source=[img], target=input_dir, kind_of_relationship='Selected_From', is_directional=True)"
        ),
    },
    {
        "source": "registry artifacts",
        "keywords": ["registry", "windows", "hive", "regedit", "sam", "ntuser", "system", "software", "key", "value"],
        "pattern": "ObservableObject + WindowsRegistryKeyFacet + WindowsRegistryValueFacet",
        "classes": ["ObservableObject", "WindowsRegistryKeyFacet", "WindowsRegistryValueFacet", "FileFacet"],
        "anti_patterns": [
            "Don't model registry values without their parent key — always include the key path",
            "Don't use generic FileFacet for registry hive content — use the specific registry facets",
        ],
        "starter_kit": None,
        "code_skeleton": "graph.create(ObservableObject, has_facet=[WindowsRegistryKeyFacet(key=...)])",
    },
    {
        "source": "child sex trafficking ring or recruitment network",
        "keywords": ["trafficking", "trafficker", "trafficked", "ring", "cell",
                     "rotation", "interstate transport", "recruitment",
                     "recruiter", "school-based", "peer recruitment",
                     "street recruitment", "pretext", "help offer",
                     "food offer", "transportation offer", "phone charging",
                     "rapid escalation", "digital-to-physical", "csec", "cse",
                     "icac"],
        "pattern": (
            "CACInvestigation + TraffickingEnterprise + (TraffickingRing | TraffickingCell) "
            "+ TraffickingVictimRole + (PeerRecruitmentNetwork | "
            "ClassmateRecruitmentNetwork) + (SchoolBasedRecruitment | "
            "StreetBasedRecruitment with pretext approach) + DigitalToPhysicalBridge"
        ),
        "classes": ["CACInvestigation", "TraffickingEnterprise", "TraffickingRing",
                    "TraffickingCell", "TraffickingVictimRole",
                    "MinorTraffickingVictimRole", "TraffickingVictimRescue",
                    "VictimRotation", "InterstateVictimTransport",
                    "InterstateTraffickingNetwork",
                    "PeerRecruitmentNetwork", "ClassmateRecruitmentNetwork",
                    "SchoolBasedRecruitment", "StreetBasedRecruitment",
                    "HelpOfferApproach", "FoodOfferApproach",
                    "TransportationOfferApproach", "PhoneChargingOffer",
                    "RapidEscalationRecruitment", "DigitalToPhysicalBridge",
                    "MandatoryReportingActivation", "Identity", "Location",
                    "Relationship"],
        "anti_patterns": [
            "Don't model a trafficking ring as a single Identity — use TraffickingEnterprise (or TraffickingRing/TraffickingCell) so role hierarchy and victim relationships have a structural anchor",
            "Don't reuse generic InvestigativeAction for each pretext approach — use the specific *OfferApproach subclass so analysts can query approach patterns",
            "Don't treat 'online recruitment then in-person meet' as one event — split it: one online behavior event plus a DigitalToPhysicalBridge for the meet, so the timeline shows the transition",
            "Don't forget to set CASE_UCO_EXTENSIONS=cac so trafficking and recruitment classes load",
        ],
        "starter_kit": None,
        "code_skeleton": (
            "# Requires CASE_UCO_EXTENSIONS=cac\n"
            "ring = graph.create(TraffickingRing, name='Ring 2026-014')\n"
            "victim_role = graph.create(MinorTraffickingVictimRole, name='Victim A role')\n"
            "approach = graph.create(TransportationOfferApproach, name='Bus-stop ride offer')\n"
            "bridge = graph.create(DigitalToPhysicalBridge, name='IG DM -> motel meet')\n"
            "graph.create(Relationship, source=[approach], target=[victim_role], kind_of_relationship='Targeted')"
        ),
    },
    {
        "source": "multi-jurisdictional rescue or task force operation",
        "keywords": ["multi-jurisdiction", "jurisdiction", "task force", "taskforce",
                     "joint investigation", "joint operation", "rescue",
                     "mass rescue", "mutual aid", "handoff", "icac", "hsi",
                     "fbi", "interpol", "federal", "interstate"],
        "pattern": (
            "CACInvestigation + TaskForce + (LocalJurisdiction | StateJurisdiction | "
            "FederalJurisdiction | InternationalJurisdiction) + JointInvestigation + "
            "(MassChildRescueOperation | VictimExtraction) + JurisdictionalHandoff + "
            "MutualAidRequest"
        ),
        "classes": ["CACInvestigation", "TaskForce", "JointInvestigation",
                    "Jurisdiction", "LocalJurisdiction", "StateJurisdiction",
                    "FederalJurisdiction", "InternationalJurisdiction",
                    "JurisdictionalHandoff", "MutualAidRequest",
                    "MassChildRescueOperation", "VictimExtraction",
                    "EmergencyResponse", "InvestigativeAction",
                    "ProvenanceRecord", "Identity", "Location"],
        "anti_patterns": [
            "Don't model the task force as a generic Identity — use TaskForce so participating jurisdictions/agencies have a structural relationship",
            "Don't bury jurisdictional transitions in a description string — use JurisdictionalHandoff (and MutualAidRequest where relevant) so the chain is queryable",
            "Don't lose per-victim provenance during a mass rescue — pair MassChildRescueOperation with one VictimExtraction per victim, each with its own ProvenanceRecord",
        ],
        "starter_kit": None,
        "code_skeleton": (
            "# Requires CASE_UCO_EXTENSIONS=cac\n"
            "tf = graph.create(TaskForce, name='Regional ICAC Task Force')\n"
            "op = graph.create(MassChildRescueOperation, name='Operation Lighthouse')\n"
            "fed = graph.create(FederalJurisdiction, name='HSI - Field Office X')\n"
            "state = graph.create(StateJurisdiction, name='State Police')\n"
            "graph.create(JurisdictionalHandoff, source=[state], target=[fed], name='Lead transferred to HSI')"
        ),
    },
    {
        "source": "tactical arrest or high-risk operation",
        "keywords": ["tactical", "arrest", "high-risk", "dynamic entry",
                     "warrant service", "swat", "raid", "undercover",
                     "asset forfeiture", "seizure"],
        "pattern": (
            "CACInvestigation + (ArrestOperation | HighRiskArrest) + DynamicEntry "
            "+ SuspectProfile + ThreatAssessment + AssetForfeitureAction"
        ),
        "classes": ["CACInvestigation", "ArrestOperation", "HighRiskArrest",
                    "DynamicEntry", "SuspectProfile", "ThreatAssessment",
                    "UndercoverOperation", "AssetForfeitureAction",
                    "InvestigativeAction", "Tool", "Identity", "Location"],
        "anti_patterns": [
            "Don't collapse pre-op planning and the entry into one action — pre-op SuspectProfile/ThreatAssessment justify the operational posture and need their own records",
            "Don't model seized property as plain ObservableObject — use AssetForfeitureAction so the legal-process linkage is explicit",
        ],
        "starter_kit": None,
        "code_skeleton": (
            "# Requires CASE_UCO_EXTENSIONS=cac\n"
            "ta = graph.create(ThreatAssessment, name='Pre-op threat assessment')\n"
            "arrest = graph.create(HighRiskArrest, name='Arrest of subject X')\n"
            "entry = graph.create(DynamicEntry, name='Front-door dynamic entry')\n"
            "forfeiture = graph.create(AssetForfeitureAction, name='Vehicle and electronics seizure')"
        ),
    },
    {
        "source": "victim rescue extraction and post-rescue services",
        "keywords": ["rescue", "extraction", "extract", "emergency response",
                     "victim service", "safety planning", "trauma",
                     "ongoing danger", "recantation", "multi-agency",
                     "dcfs", "child protective"],
        "pattern": (
            "CACInvestigation + EmergencyResponse + VictimExtraction + "
            "OngoingDangerAssessment + SafetyPlanning + MultiAgencyVictimResponse "
            "+ TraumaIndicator + HelpSeekingBarrier"
        ),
        "classes": ["CACInvestigation", "EmergencyResponse", "VictimExtraction",
                    "OngoingDangerAssessment", "SafetyPlanning",
                    "MultiAgencyVictimResponse", "TraumaIndicator",
                    "HelpSeekingBarrier", "RecantationAssessment",
                    "PartialRecantationStatement", "ReaffirmedDisclosureStatement",
                    "PostRecantationForensicInterview", "ChildVictim",
                    "InvestigativeAction"],
        "anti_patterns": [
            "Don't treat post-rescue services as out-of-scope — model MultiAgencyVictimResponse and SafetyPlanning so downstream services are auditable",
            "Don't conflate recantation with case closure — RecantationAssessment is its own event and may coexist with an ongoing investigation; pair it with ReaffirmedDisclosureStatement when the disclosure is later reaffirmed",
        ],
        "starter_kit": None,
        "code_skeleton": (
            "# Requires CASE_UCO_EXTENSIONS=cac\n"
            "extraction = graph.create(VictimExtraction, name='Victim extraction at motel')\n"
            "danger = graph.create(OngoingDangerAssessment, name='Trafficker still at-large')\n"
            "plan = graph.create(SafetyPlanning, name='Initial safety plan with DCFS')"
        ),
    },
    {
        "source": "csam provenance forensics and victim identification",
        "keywords": ["csam forensic", "csam provenance", "chain of custody",
                     "evidence verification", "metadata correlation",
                     "temporal pattern", "geospatial correlation",
                     "cross-platform correlation", "behavioral fingerprint",
                     "victim identification", "photodna",
                     "perceptual hash", "image hashing"],
        "pattern": (
            "ForensicAcquisitionAction + ChainOfCustodyAction (per event) + "
            "EvidenceVerificationAction + (MetadataCorrelation | TemporalPatternAnalysis "
            "| GeospatialCorrelation | CrossPlatformCorrelation | "
            "BehavioralFingerprinting) + VictimIdentificationProcess"
        ),
        "classes": ["ForensicAcquisitionAction", "ChainOfCustodyAction",
                    "EvidenceVerificationAction", "MetadataCorrelation",
                    "TemporalPatternAnalysis", "GeospatialCorrelation",
                    "CrossPlatformCorrelation", "BehavioralFingerprinting",
                    "VictimIdentificationProcess", "ContentHashingTool",
                    "RasterPicture", "RasterPictureFacet", "FileFacet",
                    "ContentDataFacet", "ProvenanceRecord", "Relationship"],
        "anti_patterns": [
            "Don't merge acquisition, verification, and analysis into one action — each is its own auditable step with its own tool, operator, and timestamp",
            "Don't omit hashes on CSAM artifacts — without ContentDataFacet entries the chain of custody is unverifiable",
            "Don't store correlation findings only in description text — use the matching CAC correlation class so the result is queryable",
        ],
        "starter_kit": None,
        "code_skeleton": (
            "# Requires CASE_UCO_EXTENSIONS=cac\n"
            "acq = graph.create(ForensicAcquisitionAction, name='Acquisition of seized device')\n"
            "verify = graph.create(EvidenceVerificationAction, name='SHA-256 verification')\n"
            "img = graph.create(RasterPicture, has_facet=[FileFacet(file_name=...), ContentDataFacet(hash_method='SHA-256', hash_value='...'), RasterPictureFacet(...)])\n"
            "vid = graph.create(VictimIdentificationProcess, name='Match against known-victim DB')"
        ),
    },
    {
        "source": "cybertip grooming report",
        "keywords": ["cybertip", "ncmec", "grooming", "csam", "child", "exploitation",
                     "victim", "offender", "enticement", "snapchat", "platform", "reporting",
                     "detection", "cac", "crimes against children", "hotline", "sextortion"],
        "pattern": "CACInvestigation + GroomingBehavior + NCMECCybertipReport + GroomingMessage + ChildVictim + OnlinePredator",
        "classes": ["CACInvestigation", "GroomingBehavior", "OnlineGrooming", "GroomingMessage",
                    "ChildVictim", "OnlinePredator", "NCMECCybertipReport", "OnlineEnticementIncident",
                    "AutomatedDetectionAction", "ElectronicServiceProvider", "MessageThread",
                    "MessageFacet", "ApplicationAccount", "RasterPicture", "Relationship"],
        "anti_patterns": [
            "Don't use generic InvestigativeAction for grooming phases — use GroomingBehavior with grooming stage properties from the CAC extension",
            "Don't model the CyberTip as a plain ObservableObject — use NCMECCybertipReport with incident type and annotations from the CAC extension",
            "Don't use freetext descriptions for grooming phases — use the structured GroomingPhase classes (InitialContactPhase, TrustBuildingPhase, etc.)",
            "Don't forget to set CASE_UCO_EXTENSIONS=cac to load CAC classes in the MCP server",
        ],
        "starter_kit": None,
        "code_skeleton": (
            "# Requires CASE_UCO_EXTENSIONS=cac\n"
            "# CAC grooming + NCMEC classes\n"
            "grooming = graph.create(OnlineGrooming, name=..., grooming_stage='trust_building')\n"
            "victim = graph.create(ChildVictim, name=...)\n"
            "offender = graph.create(OnlinePredator, name=...)\n"
            "cybertip = graph.create(NCMECCybertipReport, name=...)\n"
            "# Link to core UCO messaging\n"
            "thread = graph.create(MessageThread, has_facet=[MessageThreadFacet(participant=[offender_acct, victim_acct])])"
        ),
    },
]
