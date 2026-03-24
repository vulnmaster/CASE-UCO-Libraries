// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A disk facet is a grouping of characteristics unique to a storage mechanism where data is recorded by various electronic, magnetic, optical, or mechanical changes to a surface layer of one or more rot */
public class DiskFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/DiskFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long diskSize;
    private String diskType;
    private Long freeSpace;
    private List<ObservableObject> partition;

    public DiskFacet() {
        this.partition = new ArrayList<>();
    }

    public Long getDiskSize() { return this.diskSize; }
    public DiskFacet setDiskSize(Long value) { this.diskSize = value; return this; }

    public String getDiskType() { return this.diskType; }
    public DiskFacet setDiskType(String value) { this.diskType = value; return this; }

    public Long getFreeSpace() { return this.freeSpace; }
    public DiskFacet setFreeSpace(Long value) { this.freeSpace = value; return this; }

    public List<ObservableObject> getPartition() { return this.partition; }
    public DiskFacet setPartition(List<ObservableObject> value) { this.partition = value; return this; }

}