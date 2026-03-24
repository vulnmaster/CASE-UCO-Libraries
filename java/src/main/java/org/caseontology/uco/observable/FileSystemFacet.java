// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A file system facet is a grouping of characteristics unique to the process that manages how and where data on a storage medium is stored, accessed and managed. [based on https://www.techopedia.com/def */
public class FileSystemFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/FileSystemFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long clusterSize;
    private String fileSystemType;

    public FileSystemFacet() {
    }

    public Long getClusterSize() { return this.clusterSize; }
    public FileSystemFacet setClusterSize(Long value) { this.clusterSize = value; return this; }

    public String getFileSystemType() { return this.fileSystemType; }
    public FileSystemFacet setFileSystemType(String value) { this.fileSystemType = value; return this; }

}