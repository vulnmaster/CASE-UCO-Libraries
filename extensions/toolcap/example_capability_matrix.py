#!/usr/bin/env python3
"""Example: Build a forensic tool capability matrix using CASE/UCO + toolcap extension v0.3.0.

This demonstrates the full toolcap workflow:
  - Define forensic tools and target applications
  - Create structured PlatformSpecifications (including BFU acquisition and filesystem types)
  - Declare ToolCapability assertions — both app-level and CFTT task-level (forensicTaskType)
  - Attach AccessRestrictions (licensing, OPSEC)
  - Record BenchmarkObservations with IR metrics (precision, recall, F1) and provenance
  - Assemble everything into a CapabilityMatrix

Scenario: Two tools (Tool A commercial, Tool B law-enforcement-only) are
compared for their ability to parse a messaging app on mobile and Outlook
on Windows. Outlook has a legacy .pst format (both tools pass) and a new
.nst format (both tools fail). Additionally, both tools are benchmarked on
NIST CFTT-style forensic tasks (file carving, deleted file recovery, string
search) using AutoDFBench with full IR metrics.

Output: A CASE/UCO-compliant JSON-LD graph representing the capability matrix.
"""

import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).parent.parent.parent / "python"))

from case_uco.graph import CASEGraph
from case_uco.uco.tool import Tool
from case_uco.uco.observable import ObservableObject, ApplicationFacet

from dataclasses import dataclass, field
from typing import Optional


# ---------------------------------------------------------------------------
# Extension dataclasses (mirrors the toolcap TTL definitions)
# ---------------------------------------------------------------------------

@dataclass
class PlatformSpecification:
    CLASS_IRI: str = "http://example.org/ontology/toolcap/PlatformSpecification"
    NAMESPACE_PREFIX: str = "toolcap"

    operating_system: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:operatingSystem', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    os_version: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:osVersion', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    device_model: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:deviceModel', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    extraction_method: list[str] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:extractionMethod', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    file_system_type: list[str] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:fileSystemType', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})


@dataclass
class AccessRestriction:
    CLASS_IRI: str = "http://example.org/ontology/toolcap/AccessRestriction"
    NAMESPACE_PREFIX: str = "toolcap"

    restriction_type: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:restrictionType', 'required': True, 'cardinality': 'exactly_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    restriction_level: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:restrictionLevel', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    restriction_description: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:restrictionDescription', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})


@dataclass
class ToolCapability:
    CLASS_IRI: str = "http://example.org/ontology/toolcap/ToolCapability"
    NAMESPACE_PREFIX: str = "toolcap"

    tool: Optional[Tool] = field(default=None, metadata={
        'jsonld_key': 'toolcap:tool', 'required': True, 'cardinality': 'exactly_one',
        'range_iri': 'https://ontology.unifiedcyberontology.org/uco/tool/Tool', 'alternate_range_iris': []})
    application: Optional[ObservableObject] = field(default=None, metadata={
        'jsonld_key': 'toolcap:application', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'https://ontology.unifiedcyberontology.org/uco/observable/ObservableObject', 'alternate_range_iris': []})
    forensic_task_type: list[str] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:forensicTaskType', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    supports_platform: list[PlatformSpecification] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:supportsPlatform', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://example.org/ontology/toolcap/PlatformSpecification', 'alternate_range_iris': []})
    parsed_observable_type: list[str] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:parsedObservableType', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    tool_version: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:toolVersion', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    application_version: list[str] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:applicationVersion', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    data_format_version: list[str] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:dataFormatVersion', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    claimed_by_vendor: Optional[bool] = field(default=None, metadata={
        'jsonld_key': 'toolcap:claimedByVendor', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#boolean', 'alternate_range_iris': []})
    verified_by_benchmark: Optional[bool] = field(default=None, metadata={
        'jsonld_key': 'toolcap:verifiedByBenchmark', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#boolean', 'alternate_range_iris': []})
    is_verified: Optional[bool] = field(default=None, metadata={
        'jsonld_key': 'toolcap:isVerified', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#boolean', 'alternate_range_iris': []})
    last_tested_date: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:lastTestedDate', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#dateTime', 'alternate_range_iris': []})
    has_access_restriction: list[AccessRestriction] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:hasAccessRestriction', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://example.org/ontology/toolcap/AccessRestriction', 'alternate_range_iris': []})


@dataclass
class BenchmarkObservation:
    CLASS_IRI: str = "http://example.org/ontology/toolcap/BenchmarkObservation"
    NAMESPACE_PREFIX: str = "toolcap"

    capability: Optional[ToolCapability] = field(default=None, metadata={
        'jsonld_key': 'toolcap:capability', 'required': True, 'cardinality': 'exactly_one',
        'range_iri': 'http://example.org/ontology/toolcap/ToolCapability', 'alternate_range_iris': []})
    benchmark_date: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:benchmarkDate', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#dateTime', 'alternate_range_iris': []})
    parse_success: Optional[bool] = field(default=None, metadata={
        'jsonld_key': 'toolcap:parseSuccess', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#boolean', 'alternate_range_iris': []})
    completeness_score: Optional[float] = field(default=None, metadata={
        'jsonld_key': 'toolcap:completenessScore', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#decimal', 'alternate_range_iris': []})
    accuracy_score: Optional[float] = field(default=None, metadata={
        'jsonld_key': 'toolcap:accuracyScore', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#decimal', 'alternate_range_iris': []})
    false_positive_count: Optional[int] = field(default=None, metadata={
        'jsonld_key': 'toolcap:falsePositiveCount', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#nonNegativeInteger', 'alternate_range_iris': []})
    false_negative_count: Optional[int] = field(default=None, metadata={
        'jsonld_key': 'toolcap:falseNegativeCount', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#nonNegativeInteger', 'alternate_range_iris': []})
    parsed_category: list[str] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:parsedCategory', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    missed_category: list[str] = field(default_factory=list, metadata={
        'jsonld_key': 'toolcap:missedCategory', 'required': False, 'cardinality': 'zero_or_more',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    benchmark_notes: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:benchmarkNotes', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    benchmark_platform: Optional[PlatformSpecification] = field(default=None, metadata={
        'jsonld_key': 'toolcap:benchmarkPlatform', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://example.org/ontology/toolcap/PlatformSpecification', 'alternate_range_iris': []})
    tested_tool_version: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:testedToolVersion', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    tested_application_version: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:testedApplicationVersion', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    tested_data_format_version: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:testedDataFormatVersion', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    precision_score: Optional[float] = field(default=None, metadata={
        'jsonld_key': 'toolcap:precisionScore', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#decimal', 'alternate_range_iris': []})
    recall_score: Optional[float] = field(default=None, metadata={
        'jsonld_key': 'toolcap:recallScore', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#decimal', 'alternate_range_iris': []})
    f1_score: Optional[float] = field(default=None, metadata={
        'jsonld_key': 'toolcap:f1Score', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#decimal', 'alternate_range_iris': []})
    true_positive_count: Optional[int] = field(default=None, metadata={
        'jsonld_key': 'toolcap:truePositiveCount', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#nonNegativeInteger', 'alternate_range_iris': []})
    ground_truth_count: Optional[int] = field(default=None, metadata={
        'jsonld_key': 'toolcap:groundTruthCount', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#nonNegativeInteger', 'alternate_range_iris': []})
    submitted_count: Optional[int] = field(default=None, metadata={
        'jsonld_key': 'toolcap:submittedCount', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#nonNegativeInteger', 'alternate_range_iris': []})
    benchmark_framework: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:benchmarkFramework', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    test_case_identifier: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:testCaseIdentifier', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    benchmark_suite_score: Optional[float] = field(default=None, metadata={
        'jsonld_key': 'toolcap:benchmarkSuiteScore', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#decimal', 'alternate_range_iris': []})
    processing_duration: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:processingDuration', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#duration', 'alternate_range_iris': []})
    dataset_size_in_bytes: Optional[int] = field(default=None, metadata={
        'jsonld_key': 'toolcap:datasetSizeInBytes', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#nonNegativeInteger', 'alternate_range_iris': []})


@dataclass
class CapabilityMatrix:
    CLASS_IRI: str = "http://example.org/ontology/toolcap/CapabilityMatrix"
    NAMESPACE_PREFIX: str = "toolcap"

    matrix_name: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:matrixName', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})
    matrix_version: Optional[str] = field(default=None, metadata={
        'jsonld_key': 'toolcap:matrixVersion', 'required': False, 'cardinality': 'zero_or_one',
        'range_iri': 'http://www.w3.org/2001/XMLSchema#string', 'alternate_range_iris': []})


# ---------------------------------------------------------------------------
# Build the graph
# ---------------------------------------------------------------------------

def main():
    graph = CASEGraph(
        kb_prefix="http://example.org/forensic-lab/kb/",
        extra_context={
            "toolcap": "http://example.org/ontology/toolcap/",
        },
    )

    # --- Tools ---
    tool_a = graph.create(Tool, name="Tool A", version="8.2.0", tool_type="forensic")
    tool_b = graph.create(Tool, name="Tool B", version="7.70", tool_type="forensic")

    # --- Applications ---
    app_alpha = graph.create(
        ObservableObject,
        has_facet=[ApplicationFacet(application_identifier="com.example.app.alpha")],
    )
    outlook = graph.create(
        ObservableObject,
        has_facet=[ApplicationFacet(application_identifier="com.microsoft.outlook")],
    )

    # --- Platforms ---
    android_physical = graph.add(PlatformSpecification(
        operating_system="Android",
        os_version="14",
        extraction_method=["physical", "file-system"],
    ))
    android_bfu = graph.add(PlatformSpecification(
        operating_system="Android",
        os_version="14",
        extraction_method=["BFU"],
    ))
    ios_logical = graph.add(PlatformSpecification(
        operating_system="iOS",
        os_version="17.4",
        device_model="iPhone 15",
        extraction_method=["logical"],
    ))
    windows_logical = graph.add(PlatformSpecification(
        operating_system="Windows",
        os_version="11 23H2",
        extraction_method=["logical"],
    ))

    # --- Access Restrictions ---
    commercial_license = graph.add(AccessRestriction(
        restriction_type="licensing",
        restriction_level="commercial-license-required",
        restriction_description="Requires an active commercial license. Annual subscription.",
    ))
    leo_only = graph.add(AccessRestriction(
        restriction_type="licensing",
        restriction_level="law-enforcement-only",
        restriction_description="Only available to sworn law enforcement and authorized government agencies.",
    ))
    opsec_bfu = graph.add(AccessRestriction(
        restriction_type="operational-security",
        restriction_level="covert-capable",
        restriction_description="BFU technique may be detectable. OPSEC review required.",
    ))

    # --- Capabilities ---
    cap_a_alpha = graph.add(ToolCapability(
        tool=tool_a,
        application=app_alpha,
        supports_platform=[android_physical, ios_logical],
        parsed_observable_type=["messages", "contacts", "media files", "call logs"],
        tool_version="8.2.0",
        application_version=["7.0.2"],
        claimed_by_vendor=True,
        verified_by_benchmark=True,
        is_verified=True,
        has_access_restriction=[commercial_license],
    ))

    cap_a_outlook = graph.add(ToolCapability(
        tool=tool_a,
        application=outlook,
        supports_platform=[windows_logical],
        parsed_observable_type=["emails", "contacts", "calendar events", "attachments"],
        tool_version="8.2.0",
        application_version=["Classic", "New (2024)"],
        data_format_version=[".pst", ".nst"],
        claimed_by_vendor=True,
        verified_by_benchmark=True,
        is_verified=True,
        has_access_restriction=[commercial_license],
    ))

    cap_b_alpha = graph.add(ToolCapability(
        tool=tool_b,
        application=app_alpha,
        supports_platform=[android_physical, android_bfu],
        parsed_observable_type=["messages", "contacts"],
        tool_version="7.70",
        application_version=["7.0.2"],
        claimed_by_vendor=True,
        verified_by_benchmark=True,
        is_verified=True,
        has_access_restriction=[leo_only, opsec_bfu],
    ))

    cap_b_outlook = graph.add(ToolCapability(
        tool=tool_b,
        application=outlook,
        supports_platform=[windows_logical],
        parsed_observable_type=["emails", "contacts", "calendar events"],
        tool_version="7.70",
        application_version=["Classic"],
        data_format_version=[".pst"],
        claimed_by_vendor=True,
        verified_by_benchmark=True,
        is_verified=True,
        has_access_restriction=[leo_only],
    ))

    # --- Benchmark Observations ---

    # Tool A / App Alpha — Android physical — pass
    graph.add(BenchmarkObservation(
        capability=cap_a_alpha,
        benchmark_date="2026-03-01T10:00:00Z",
        benchmark_platform=android_physical,
        parse_success=True,
        completeness_score=0.95,
        accuracy_score=0.98,
        false_positive_count=2,
        false_negative_count=12,
        parsed_category=["messages", "contacts", "media files", "call logs"],
        tested_tool_version="8.2.0",
        tested_application_version="7.0.2",
        benchmark_notes="Full physical image from Pixel 8. 12 deleted messages not recovered.",
    ))

    # Tool A / Outlook .pst — pass
    graph.add(BenchmarkObservation(
        capability=cap_a_outlook,
        benchmark_date="2026-03-10T09:00:00Z",
        benchmark_platform=windows_logical,
        parse_success=True,
        completeness_score=0.98,
        accuracy_score=0.99,
        parsed_category=["emails", "contacts", "calendar events", "attachments"],
        tested_tool_version="8.2.0",
        tested_application_version="Classic",
        tested_data_format_version=".pst",
        benchmark_notes="Mature parser. Near-complete recovery from legacy .pst.",
    ))

    # Tool A / Outlook .nst — FAIL
    graph.add(BenchmarkObservation(
        capability=cap_a_outlook,
        benchmark_date="2026-03-15T14:00:00Z",
        benchmark_platform=windows_logical,
        parse_success=False,
        completeness_score=0.0,
        missed_category=["emails", "contacts", "calendar events", "attachments"],
        tested_tool_version="8.2.0",
        tested_application_version="New (2024)",
        tested_data_format_version=".nst",
        benchmark_notes="Cannot recognize .nst format. Vendor plans parser update Q3 2026.",
    ))

    # Tool B / App Alpha — Android physical — pass
    graph.add(BenchmarkObservation(
        capability=cap_b_alpha,
        benchmark_date="2026-02-15T14:30:00Z",
        benchmark_platform=android_physical,
        parse_success=True,
        completeness_score=0.88,
        accuracy_score=0.96,
        false_positive_count=0,
        false_negative_count=28,
        parsed_category=["messages", "contacts"],
        missed_category=["media files"],
        tested_tool_version="7.70",
        tested_application_version="7.0.2",
        benchmark_notes="Messages and contacts recovered. Missed embedded media.",
    ))

    # Tool B / App Alpha — Android BFU — partial
    graph.add(BenchmarkObservation(
        capability=cap_b_alpha,
        benchmark_date="2026-02-20T09:00:00Z",
        benchmark_platform=android_bfu,
        parse_success=True,
        completeness_score=0.35,
        accuracy_score=0.99,
        parsed_category=["contacts"],
        missed_category=["messages", "media files"],
        tested_tool_version="7.70",
        tested_application_version="7.0.2",
        benchmark_notes="BFU: contact DB only. Messages encrypted until first unlock.",
    ))

    # Tool B / Outlook .pst — pass
    graph.add(BenchmarkObservation(
        capability=cap_b_outlook,
        benchmark_date="2026-03-10T09:00:00Z",
        benchmark_platform=windows_logical,
        parse_success=True,
        completeness_score=0.96,
        accuracy_score=0.97,
        parsed_category=["emails", "contacts", "calendar events"],
        tested_tool_version="7.70",
        tested_application_version="Classic",
        tested_data_format_version=".pst",
        benchmark_notes="Solid .pst parser. Slightly lower completeness than Tool A.",
    ))

    # Tool B / Outlook .nst — FAIL
    graph.add(BenchmarkObservation(
        capability=cap_b_outlook,
        benchmark_date="2026-03-10T11:00:00Z",
        benchmark_platform=windows_logical,
        parse_success=False,
        completeness_score=0.0,
        missed_category=["emails", "contacts", "calendar events"],
        tested_tool_version="7.70",
        tested_application_version="New (2024)",
        tested_data_format_version=".nst",
        benchmark_notes="Does not recognize .nst format. No vendor timeline for support.",
    ))

    # --- CFTT / AutoDFBench Platforms (with filesystem types) ---
    ntfs_env = graph.add(PlatformSpecification(
        operating_system="Windows",
        os_version="11 23H2",
        file_system_type=["NTFS"],
    ))
    fat32_env = graph.add(PlatformSpecification(
        operating_system="Windows",
        os_version="11 23H2",
        file_system_type=["FAT32"],
    ))
    ext4_env = graph.add(PlatformSpecification(
        operating_system="Linux",
        os_version="6.1",
        file_system_type=["ext4"],
    ))

    # --- Task-Level Capabilities (no application — uses forensicTaskType) ---
    cap_a_carving = graph.add(ToolCapability(
        tool=tool_a,
        forensic_task_type=["file-carving"],
        supports_platform=[ntfs_env],
        parsed_observable_type=["carved files"],
        tool_version="8.2.0",
        claimed_by_vendor=True,
        verified_by_benchmark=True,
        is_verified=True,
        has_access_restriction=[commercial_license],
    ))

    cap_a_dfr = graph.add(ToolCapability(
        tool=tool_a,
        forensic_task_type=["deleted-file-recovery"],
        supports_platform=[fat32_env],
        parsed_observable_type=["recovered files"],
        tool_version="8.2.0",
        claimed_by_vendor=True,
        verified_by_benchmark=True,
        is_verified=True,
        has_access_restriction=[commercial_license],
    ))

    cap_b_string_search = graph.add(ToolCapability(
        tool=tool_b,
        forensic_task_type=["string-search"],
        supports_platform=[ext4_env],
        parsed_observable_type=["string matches"],
        tool_version="7.70",
        claimed_by_vendor=True,
        verified_by_benchmark=True,
        is_verified=True,
        has_access_restriction=[leo_only],
    ))

    # --- AutoDFBench Benchmark Observations (with IR metrics + provenance) ---

    # Tool A / File Carving on NTFS — AutoDFBench
    graph.add(BenchmarkObservation(
        capability=cap_a_carving,
        benchmark_date="2026-03-20T08:00:00Z",
        benchmark_platform=ntfs_env,
        benchmark_framework="AutoDFBench",
        test_case_identifier="AutoDFBench-FC-NTFS-01",
        parse_success=True,
        ground_truth_count=150,
        submitted_count=142,
        true_positive_count=138,
        false_positive_count=4,
        false_negative_count=12,
        precision_score=0.9718,
        recall_score=0.92,
        f1_score=0.9452,
        completeness_score=0.92,
        accuracy_score=0.97,
        benchmark_suite_score=0.94,
        processing_duration="PT12M30S",
        dataset_size_in_bytes=2147483648,
        parsed_category=["JPEG", "PDF", "DOCX"],
        missed_category=["PNG"],
        tested_tool_version="8.2.0",
        benchmark_notes="138/150 planted files recovered. Missed 12 fragmented PNGs. 4 FP from JPEG remnants.",
    ))

    # Tool A / Deleted File Recovery on FAT32 — AutoDFBench
    graph.add(BenchmarkObservation(
        capability=cap_a_dfr,
        benchmark_date="2026-03-20T10:00:00Z",
        benchmark_platform=fat32_env,
        benchmark_framework="AutoDFBench",
        test_case_identifier="AutoDFBench-DFR-FAT32-01",
        parse_success=True,
        ground_truth_count=200,
        submitted_count=183,
        true_positive_count=178,
        false_positive_count=5,
        false_negative_count=22,
        precision_score=0.9727,
        recall_score=0.89,
        f1_score=0.9296,
        completeness_score=0.89,
        accuracy_score=0.97,
        benchmark_suite_score=0.92,
        processing_duration="PT8M15S",
        dataset_size_in_bytes=1073741824,
        parsed_category=["deleted files"],
        missed_category=["overwritten files"],
        tested_tool_version="8.2.0",
        benchmark_notes="178/200 deleted files recovered. 22 missed due to cluster reallocation.",
    ))

    # Tool B / String Search on ext4 — AutoDFBench
    graph.add(BenchmarkObservation(
        capability=cap_b_string_search,
        benchmark_date="2026-03-22T09:00:00Z",
        benchmark_platform=ext4_env,
        benchmark_framework="AutoDFBench",
        test_case_identifier="AutoDFBench-SS-ext4-01",
        parse_success=True,
        ground_truth_count=500,
        submitted_count=487,
        true_positive_count=482,
        false_positive_count=5,
        false_negative_count=18,
        precision_score=0.9897,
        recall_score=0.964,
        f1_score=0.9767,
        completeness_score=0.964,
        accuracy_score=0.99,
        benchmark_suite_score=0.97,
        processing_duration="PT2M10S",
        dataset_size_in_bytes=536870912,
        parsed_category=["ASCII strings", "UTF-8 strings"],
        missed_category=["UTF-16 strings"],
        tested_tool_version="7.70",
        benchmark_notes="Strong ASCII/UTF-8. Missed 18 UTF-16LE strings in unallocated space.",
    ))

    # --- Matrix ---
    graph.add(CapabilityMatrix(
        matrix_name="DFIR Tool Comparison Q1 2026",
        matrix_version="3.0",
    ))

    print(graph.serialize())


if __name__ == "__main__":
    main()
