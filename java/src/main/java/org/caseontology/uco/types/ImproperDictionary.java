// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.types;

import java.util.ArrayList;
import java.util.List;

/** ImproperDictionary */
public class ImproperDictionary extends Dictionary {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/types/ImproperDictionary";
    public static final String NAMESPACE_PREFIX = "uco-types";

    private List<String> repeatsKey;

    public ImproperDictionary() {
        this.repeatsKey = new ArrayList<>();
    }

    public List<String> getRepeatsKey() { return this.repeatsKey; }
    public ImproperDictionary setRepeatsKey(List<String> value) { this.repeatsKey = value; return this; }

}