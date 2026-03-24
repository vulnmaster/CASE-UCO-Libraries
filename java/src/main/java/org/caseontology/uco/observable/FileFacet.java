// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A file facet is a grouping of characteristics unique to the storage of a file (computer resource for recording data discretely in a computer storage device) on a file system (process that manages how  */
public class FileFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/FileFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private java.time.ZonedDateTime accessedTime;
    private String allocationStatus;
    private String extension;
    private List<String> fileName;
    private List<String> filePath;
    private List<Boolean> isDirectory;
    private java.time.ZonedDateTime metadataChangeTime;
    private java.time.ZonedDateTime modifiedTime;
    private java.time.ZonedDateTime observableCreatedTime;
    private Long sizeInBytes;

    public FileFacet() {
        this.fileName = new ArrayList<>();
        this.filePath = new ArrayList<>();
        this.isDirectory = new ArrayList<>();
    }

    public java.time.ZonedDateTime getAccessedTime() { return this.accessedTime; }
    public FileFacet setAccessedTime(java.time.ZonedDateTime value) { this.accessedTime = value; return this; }

    public String getAllocationStatus() { return this.allocationStatus; }
    public FileFacet setAllocationStatus(String value) { this.allocationStatus = value; return this; }

    public String getExtension() { return this.extension; }
    public FileFacet setExtension(String value) { this.extension = value; return this; }

    public List<String> getFileName() { return this.fileName; }
    public FileFacet setFileName(List<String> value) { this.fileName = value; return this; }

    public List<String> getFilePath() { return this.filePath; }
    public FileFacet setFilePath(List<String> value) { this.filePath = value; return this; }

    public List<Boolean> getIsDirectory() { return this.isDirectory; }
    public FileFacet setIsDirectory(List<Boolean> value) { this.isDirectory = value; return this; }

    public java.time.ZonedDateTime getMetadataChangeTime() { return this.metadataChangeTime; }
    public FileFacet setMetadataChangeTime(java.time.ZonedDateTime value) { this.metadataChangeTime = value; return this; }

    public java.time.ZonedDateTime getModifiedTime() { return this.modifiedTime; }
    public FileFacet setModifiedTime(java.time.ZonedDateTime value) { this.modifiedTime = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public FileFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

    public Long getSizeInBytes() { return this.sizeInBytes; }
    public FileFacet setSizeInBytes(Long value) { this.sizeInBytes = value; return this; }

}