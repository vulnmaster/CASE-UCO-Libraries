// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An NTFS file facet is a grouping of characteristics unique to a file on an NTFS (new technology filesystem) file system. */
public class NTFSFileFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/NTFSFileFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<AlternateDataStream> alternateDataStreams;
    private Long entryID;
    private String sid;

    public NTFSFileFacet() {
        this.alternateDataStreams = new ArrayList<>();
    }

    public List<AlternateDataStream> getAlternateDataStreams() { return this.alternateDataStreams; }
    public NTFSFileFacet setAlternateDataStreams(List<AlternateDataStream> value) { this.alternateDataStreams = value; return this; }

    public Long getEntryID() { return this.entryID; }
    public NTFSFileFacet setEntryID(Long value) { this.entryID = value; return this; }

    public String getSid() { return this.sid; }
    public NTFSFileFacet setSid(String value) { this.sid = value; return this; }

}