// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A volume facet is a grouping of characteristics unique to a single accessible storage area (volume) with a single file system. [based on https://en.wikipedia.org/wiki/Volume_(computing)] */
public class VolumeFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/VolumeFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long sectorSize;
    private String volumeID;

    public VolumeFacet() {
    }

    public Long getSectorSize() { return this.sectorSize; }
    public VolumeFacet setSectorSize(Long value) { this.sectorSize = value; return this; }

    public String getVolumeID() { return this.volumeID; }
    public VolumeFacet setVolumeID(String value) { this.volumeID = value; return this; }

}