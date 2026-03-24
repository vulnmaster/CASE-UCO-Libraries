// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A disk partition facet is a grouping of characteristics unique to a particular managed region on a storage mechanism. */
public class DiskPartitionFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/DiskPartitionFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String diskPartitionType;
    private String mountPoint;
    private java.time.ZonedDateTime observableCreatedTime;
    private String partitionID;
    private Long partitionLength;
    private Long partitionOffset;
    private Long spaceLeft;
    private Long spaceUsed;
    private Long totalSpace;

    public DiskPartitionFacet() {
    }

    public String getDiskPartitionType() { return this.diskPartitionType; }
    public DiskPartitionFacet setDiskPartitionType(String value) { this.diskPartitionType = value; return this; }

    public String getMountPoint() { return this.mountPoint; }
    public DiskPartitionFacet setMountPoint(String value) { this.mountPoint = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public DiskPartitionFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

    public String getPartitionID() { return this.partitionID; }
    public DiskPartitionFacet setPartitionID(String value) { this.partitionID = value; return this; }

    public Long getPartitionLength() { return this.partitionLength; }
    public DiskPartitionFacet setPartitionLength(Long value) { this.partitionLength = value; return this; }

    public Long getPartitionOffset() { return this.partitionOffset; }
    public DiskPartitionFacet setPartitionOffset(Long value) { this.partitionOffset = value; return this; }

    public Long getSpaceLeft() { return this.spaceLeft; }
    public DiskPartitionFacet setSpaceLeft(Long value) { this.spaceLeft = value; return this; }

    public Long getSpaceUsed() { return this.spaceUsed; }
    public DiskPartitionFacet setSpaceUsed(Long value) { this.spaceUsed = value; return this; }

    public Long getTotalSpace() { return this.totalSpace; }
    public DiskPartitionFacet setTotalSpace(Long value) { this.totalSpace = value; return this; }

}