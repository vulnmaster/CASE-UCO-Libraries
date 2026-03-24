// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A compressed stream facet is a grouping of characteristics unique to the application of a size-reduction process to a body of data content. */
public class CompressedStreamFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/CompressedStreamFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String compressionMethod;
    private java.math.BigDecimal compressionRatio;

    public CompressedStreamFacet() {
    }

    public String getCompressionMethod() { return this.compressionMethod; }
    public CompressedStreamFacet setCompressionMethod(String value) { this.compressionMethod = value; return this; }

    public java.math.BigDecimal getCompressionRatio() { return this.compressionRatio; }
    public CompressedStreamFacet setCompressionRatio(java.math.BigDecimal value) { this.compressionRatio = value; return this; }

}