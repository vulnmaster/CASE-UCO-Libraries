// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** An encoded stream facet is a grouping of characteristics unique to the conversion of a body of data content from one form to another form. */
public class EncodedStreamFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/EncodedStreamFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String encodingMethod;

    public EncodedStreamFacet() {
    }

    public String getEncodingMethod() { return this.encodingMethod; }
    public EncodedStreamFacet setEncodingMethod(String value) { this.encodingMethod = value; return this; }

}