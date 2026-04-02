"""Model four Windows NTFS USN Journal entries in CASE/UCO.

Demonstrates structured reason flags, directory hierarchy, rename
before/after modeling, and forensic provenance for USN Journal data.
"""

from datetime import datetime, timezone, timedelta
from case_uco import CASEGraph
from case_uco.case.investigation import Investigation, InvestigativeAction
from case_uco.uco.tool import Tool
from case_uco.uco.core import Event
from case_uco.uco.observable import (
    ObservableObject,
    ObservableRelationship,
    FileFacet,
    FileSystemFacet,
    NTFSFileFacet,
    WindowsVolumeFacet,
    ContentDataFacet,
    EventRecordFacet,
)
from case_uco.uco.types import Dictionary, DictionaryEntry, Hash

graph = CASEGraph()

tz = timezone(timedelta(hours=-5))

# ============================================================
# Provenance: investigation, evidence source, extraction tool
# ============================================================

investigation = graph.create(
    Investigation,
    name="Case 2025-1114",
    focus=["File system activity analysis"],
    investigation_form=["incident"],
    start_time=datetime(2025, 11, 14, 8, 0, 0, tzinfo=tz),
)

disk_image = graph.create(
    ObservableObject,
    name="analyst-workstation.E01",
    has_facet=[
        FileFacet(
            file_name=["analyst-workstation.E01"],
            file_path=["/evidence/case-2025-1114/analyst-workstation.E01"],
            size_in_bytes=107374182400,
        ),
        ContentDataFacet(
            hash=[Hash(
                hash_method="SHA256",
                hash_value="e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855",
            )],
        ),
    ],
)

tool = graph.create(
    Tool,
    name="MFTECmd",
    version="1.3.2.1",
    tool_type="USN Journal Parser",
)

extraction_action = graph.create(
    InvestigativeAction,
    name="Parse USN Journal from analyst-workstation.E01",
    start_time=datetime(2025, 11, 14, 16, 30, 0, tzinfo=tz),
    end_time=datetime(2025, 11, 14, 16, 32, 15, tzinfo=tz),
    instrument=[tool],
    object=[disk_image],
)

# ============================================================
# NTFS volume
# ============================================================

volume = graph.create(
    ObservableObject,
    name="C: Volume",
    has_facet=[
        WindowsVolumeFacet(drive_letter="C:"),
        FileSystemFacet(file_system_type="NTFS", cluster_size=4096),
    ],
)

# ============================================================
# Directory hierarchy
# ============================================================

def make_dir(name, path, parent):
    d = graph.create(
        ObservableObject,
        name=name,
        has_facet=[FileFacet(file_name=[name], file_path=[path], is_directory=[True])],
    )
    graph.create(
        ObservableRelationship,
        is_directional=True,
        kind_of_relationship="Contained_Within",
        source=[d],
        target=parent,
    )
    return d

dir_users_analyst_documents = make_dir(
    "Documents", "C:\\Users\\analyst\\Documents", volume,
)
dir_programdata_appconfig = make_dir(
    "AppConfig", "C:\\ProgramData\\AppConfig", volume,
)
dir_logs = make_dir("Logs", "C:\\Logs", volume)
dir_users_analyst_downloads = make_dir(
    "Downloads", "C:\\Users\\analyst\\Downloads", volume,
)
dir_extend = make_dir("$Extend", "C:\\$Extend", volume)

# ============================================================
# USN Journal ($UsnJrnl:$J)
# ============================================================

usn_journal = graph.create(
    ObservableObject,
    name="$UsnJrnl:$J",
    has_facet=[
        FileFacet(
            file_name=["$UsnJrnl:$J"],
            file_path=["C:\\$Extend\\$UsnJrnl:$J"],
        ),
    ],
)

graph.create(
    ObservableRelationship,
    is_directional=True,
    kind_of_relationship="Contained_Within",
    source=[usn_journal],
    target=dir_extend,
)

# Link extraction action results to the journal
extraction_action.result.append(usn_journal)

# ============================================================
# Helper: create a USN change event
# ============================================================

def add_usn_entry(
    *,
    usn_number,
    timestamp,
    file_name,
    file_path,
    parent_dir,
    mft_entry_id,
    reason_flags,
    description,
    old_file_name=None,
    old_file_path=None,
):
    """Build a USN Journal entry as a structured Event + ObservableObject graph."""

    file_obj = graph.create(
        ObservableObject,
        name=file_name,
        has_facet=[
            FileFacet(file_name=[file_name], file_path=[file_path]),
            NTFSFileFacet(entry_id=mft_entry_id),
        ],
    )
    graph.create(
        ObservableRelationship,
        is_directional=True,
        kind_of_relationship="Contained_Within",
        source=[file_obj],
        target=parent_dir,
    )

    event_context_objects = [file_obj]

    # For renames, model the prior file state explicitly
    if old_file_name and old_file_path:
        old_file_obj = graph.create(
            ObservableObject,
            name=f"{old_file_name} (prior state)",
            has_facet=[
                FileFacet(
                    file_name=[old_file_name],
                    file_path=[old_file_path],
                ),
                NTFSFileFacet(entry_id=mft_entry_id),
            ],
        )
        graph.create(
            ObservableRelationship,
            is_directional=True,
            kind_of_relationship="Contained_Within",
            source=[old_file_obj],
            target=parent_dir,
        )
        graph.create(
            ObservableRelationship,
            is_directional=True,
            kind_of_relationship="Renamed_From",
            source=[file_obj],
            target=old_file_obj,
        )
        event_context_objects.append(old_file_obj)

    # The raw USN record observable
    record = graph.create(
        ObservableObject,
        name=f"USN Record {usn_number}",
        has_facet=[
            EventRecordFacet(
                event_record_id=str(usn_number),
                event_type="USN_CHANGE_JOURNAL",
                observable_created_time=timestamp,
                event_record_text=description,
                event_record_service_name="NTFS USN Journal",
                event_record_device=volume,
            ),
        ],
    )
    graph.create(
        ObservableRelationship,
        is_directional=True,
        kind_of_relationship="Contained_Within",
        source=[record],
        target=usn_journal,
    )
    event_context_objects.append(record)

    # Structured event with queryable reason flags and metadata.
    # Each reason flag becomes its own key (flags are present/absent),
    # keeping dictionary keys unique as required by SHACL validation.
    reason_entries = [
        DictionaryEntry(key=flag, value="true")
        for flag in reason_flags
    ]
    reason_entries.extend([
        DictionaryEntry(key="USN_NUMBER", value=str(usn_number)),
        DictionaryEntry(key="MFT_ENTRY_ID", value=str(mft_entry_id)),
    ])

    graph.create(
        Event,
        name=f"USN Change {usn_number}: {file_name}",
        start_time=[timestamp],
        event_type=reason_flags,
        event_context=event_context_objects,
        event_attribute=[Dictionary(entry=reason_entries)],
    )

    return file_obj, record


# ============================================================
# Entry 1: File created
# ============================================================
add_usn_entry(
    usn_number=109248,
    timestamp=datetime(2025, 11, 14, 9, 23, 17, tzinfo=tz),
    file_name="report.docx",
    file_path="C:\\Users\\analyst\\Documents\\report.docx",
    parent_dir=dir_users_analyst_documents,
    mft_entry_id=48291,
    reason_flags=["USN_REASON_FILE_CREATE", "USN_REASON_CLOSE"],
    description="File report.docx was created and handle closed",
)

# ============================================================
# Entry 2: File data modified (overwrite + extend)
# ============================================================
add_usn_entry(
    usn_number=109312,
    timestamp=datetime(2025, 11, 14, 10, 5, 42, tzinfo=tz),
    file_name="config.ini",
    file_path="C:\\ProgramData\\AppConfig\\config.ini",
    parent_dir=dir_programdata_appconfig,
    mft_entry_id=12044,
    reason_flags=[
        "USN_REASON_DATA_OVERWRITE",
        "USN_REASON_DATA_EXTEND",
        "USN_REASON_CLOSE",
    ],
    description="File config.ini had data overwritten and extended, then handle closed",
)

# ============================================================
# Entry 3: File renamed (old name → new name)
# ============================================================
add_usn_entry(
    usn_number=109456,
    timestamp=datetime(2025, 11, 14, 11, 18, 3, tzinfo=tz),
    file_name="system.log",
    file_path="C:\\Logs\\system.log",
    parent_dir=dir_logs,
    mft_entry_id=33107,
    reason_flags=[
        "USN_REASON_RENAME_OLD_NAME",
        "USN_REASON_RENAME_NEW_NAME",
        "USN_REASON_CLOSE",
    ],
    description="File renamed from temp.log to system.log, handle closed",
    old_file_name="temp.log",
    old_file_path="C:\\Logs\\temp.log",
)

# ============================================================
# Entry 4: File deleted
# ============================================================
add_usn_entry(
    usn_number=109520,
    timestamp=datetime(2025, 11, 14, 14, 47, 55, tzinfo=tz),
    file_name="malware.exe",
    file_path="C:\\Users\\analyst\\Downloads\\malware.exe",
    parent_dir=dir_users_analyst_downloads,
    mft_entry_id=51883,
    reason_flags=["USN_REASON_FILE_DELETE", "USN_REASON_CLOSE"],
    description="File malware.exe was deleted and handle closed",
)

graph.write("usn_journal.jsonld")
print("Wrote usn_journal.jsonld")
