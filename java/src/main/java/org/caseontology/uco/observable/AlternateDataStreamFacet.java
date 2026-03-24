// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.types.Hash;

/** An alternate data stream facet is a grouping of characteristics unique to data content stored within an NTFS file that is independent of the standard content stream of the file and is hidden from acce */
public class AlternateDataStreamFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/AlternateDataStreamFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String name;
    private Hash hashes;
    private Long size;

    public AlternateDataStreamFacet() {
    }

    public String getName() { return this.name; }
    public AlternateDataStreamFacet setName(String value) { this.name = value; return this; }

    public Hash getHashes() { return this.hashes; }
    public AlternateDataStreamFacet setHashes(Hash value) { this.hashes = value; return this; }

    public Long getSize() { return this.size; }
    public AlternateDataStreamFacet setSize(Long value) { this.size = value; return this; }

}