// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** An MFT record facet is a grouping of characteristics unique to the details of a single file as managed in an NTFS (new technology filesystem) master file table (which is a collection of information ab */
public class MftRecordFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/MftRecordFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long mftFileID;
    private java.time.ZonedDateTime mftFileNameAccessedTime;
    private java.time.ZonedDateTime mftFileNameCreatedTime;
    private Long mftFileNameLength;
    private java.time.ZonedDateTime mftFileNameModifiedTime;
    private java.time.ZonedDateTime mftFileNameRecordChangeTime;
    private Long mftFlags;
    private Long mftParentID;
    private java.time.ZonedDateTime mftRecordChangeTime;
    private Long ntfsHardLinkCount;
    private String ntfsOwnerID;
    private String ntfsOwnerSID;

    public MftRecordFacet() {
    }

    public Long getMftFileID() { return this.mftFileID; }
    public MftRecordFacet setMftFileID(Long value) { this.mftFileID = value; return this; }

    public java.time.ZonedDateTime getMftFileNameAccessedTime() { return this.mftFileNameAccessedTime; }
    public MftRecordFacet setMftFileNameAccessedTime(java.time.ZonedDateTime value) { this.mftFileNameAccessedTime = value; return this; }

    public java.time.ZonedDateTime getMftFileNameCreatedTime() { return this.mftFileNameCreatedTime; }
    public MftRecordFacet setMftFileNameCreatedTime(java.time.ZonedDateTime value) { this.mftFileNameCreatedTime = value; return this; }

    public Long getMftFileNameLength() { return this.mftFileNameLength; }
    public MftRecordFacet setMftFileNameLength(Long value) { this.mftFileNameLength = value; return this; }

    public java.time.ZonedDateTime getMftFileNameModifiedTime() { return this.mftFileNameModifiedTime; }
    public MftRecordFacet setMftFileNameModifiedTime(java.time.ZonedDateTime value) { this.mftFileNameModifiedTime = value; return this; }

    public java.time.ZonedDateTime getMftFileNameRecordChangeTime() { return this.mftFileNameRecordChangeTime; }
    public MftRecordFacet setMftFileNameRecordChangeTime(java.time.ZonedDateTime value) { this.mftFileNameRecordChangeTime = value; return this; }

    public Long getMftFlags() { return this.mftFlags; }
    public MftRecordFacet setMftFlags(Long value) { this.mftFlags = value; return this; }

    public Long getMftParentID() { return this.mftParentID; }
    public MftRecordFacet setMftParentID(Long value) { this.mftParentID = value; return this; }

    public java.time.ZonedDateTime getMftRecordChangeTime() { return this.mftRecordChangeTime; }
    public MftRecordFacet setMftRecordChangeTime(java.time.ZonedDateTime value) { this.mftRecordChangeTime = value; return this; }

    public Long getNtfsHardLinkCount() { return this.ntfsHardLinkCount; }
    public MftRecordFacet setNtfsHardLinkCount(Long value) { this.ntfsHardLinkCount = value; return this; }

    public String getNtfsOwnerID() { return this.ntfsOwnerID; }
    public MftRecordFacet setNtfsOwnerID(String value) { this.ntfsOwnerID = value; return this; }

    public String getNtfsOwnerSID() { return this.ntfsOwnerSID; }
    public MftRecordFacet setNtfsOwnerSID(String value) { this.ntfsOwnerSID = value; return this; }

}