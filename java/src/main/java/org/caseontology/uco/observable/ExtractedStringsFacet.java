// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** An extracted strings facet is a grouping of characteristics unique to one or more sequences of characters pulled from an observable object. */
public class ExtractedStringsFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ExtractedStringsFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<ExtractedString> strings;

    public ExtractedStringsFacet() {
        this.strings = new ArrayList<>();
    }

    public List<ExtractedString> getStrings() { return this.strings; }
    public ExtractedStringsFacet setStrings(List<ExtractedString> value) { this.strings = value; return this; }

}