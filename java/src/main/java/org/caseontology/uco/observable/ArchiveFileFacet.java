// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An archive file facet is a grouping of characteristics unique to a file that is composed of one or more computer files along with metadata. */
public class ArchiveFileFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ArchiveFileFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String archiveType;
    private String comment;
    private String version;

    public ArchiveFileFacet() {
    }

    public String getArchiveType() { return this.archiveType; }
    public ArchiveFileFacet setArchiveType(String value) { this.archiveType = value; return this; }

    public String getComment() { return this.comment; }
    public ArchiveFileFacet setComment(String value) { this.comment = value; return this; }

    public String getVersion() { return this.version; }
    public ArchiveFileFacet setVersion(String value) { this.version = value; return this; }

}