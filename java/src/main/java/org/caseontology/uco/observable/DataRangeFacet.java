// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A data range facet is a grouping of characteristics unique to a particular contiguous scope within a block of digital data. */
public class DataRangeFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/DataRangeFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long rangeOffset;
    private String rangeOffsetType;
    private Long rangeSize;

    public DataRangeFacet() {
    }

    public Long getRangeOffset() { return this.rangeOffset; }
    public DataRangeFacet setRangeOffset(Long value) { this.rangeOffset = value; return this; }

    public String getRangeOffsetType() { return this.rangeOffsetType; }
    public DataRangeFacet setRangeOffsetType(String value) { this.rangeOffsetType = value; return this; }

    public Long getRangeSize() { return this.rangeSize; }
    public DataRangeFacet setRangeSize(Long value) { this.rangeSize = value; return this; }

}