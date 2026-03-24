// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An extInode facet is a grouping of characteristics unique to a file system object (file, directory, etc.) conformant to the extended file system (EXT or related derivations) specification. */
public class ExtInodeFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ExtInodeFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private java.time.ZonedDateTime extDeletionTime;
    private Long extFileType;
    private Long extFlags;
    private Long extHardLinkCount;
    private java.time.ZonedDateTime extInodeChangeTime;
    private Long extInodeID;
    private Long extPermissions;
    private Long extSGID;
    private Long extSUID;

    public ExtInodeFacet() {
    }

    public java.time.ZonedDateTime getExtDeletionTime() { return this.extDeletionTime; }
    public ExtInodeFacet setExtDeletionTime(java.time.ZonedDateTime value) { this.extDeletionTime = value; return this; }

    public Long getExtFileType() { return this.extFileType; }
    public ExtInodeFacet setExtFileType(Long value) { this.extFileType = value; return this; }

    public Long getExtFlags() { return this.extFlags; }
    public ExtInodeFacet setExtFlags(Long value) { this.extFlags = value; return this; }

    public Long getExtHardLinkCount() { return this.extHardLinkCount; }
    public ExtInodeFacet setExtHardLinkCount(Long value) { this.extHardLinkCount = value; return this; }

    public java.time.ZonedDateTime getExtInodeChangeTime() { return this.extInodeChangeTime; }
    public ExtInodeFacet setExtInodeChangeTime(java.time.ZonedDateTime value) { this.extInodeChangeTime = value; return this; }

    public Long getExtInodeID() { return this.extInodeID; }
    public ExtInodeFacet setExtInodeID(Long value) { this.extInodeID = value; return this; }

    public Long getExtPermissions() { return this.extPermissions; }
    public ExtInodeFacet setExtPermissions(Long value) { this.extPermissions = value; return this; }

    public Long getExtSGID() { return this.extSGID; }
    public ExtInodeFacet setExtSGID(Long value) { this.extSGID = value; return this; }

    public Long getExtSUID() { return this.extSUID; }
    public ExtInodeFacet setExtSUID(Long value) { this.extSUID = value; return this; }

}