// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.types;

import java.util.ArrayList;
import java.util.List;

/** A controlled dictionary is a list of (term/key, value) pairs where each term/key exists no more than once and is constrained to an explicitly defined set of values. */
public class ControlledDictionary extends Dictionary {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/types/ControlledDictionary";
    public static final String NAMESPACE_PREFIX = "uco-types";

    private List<ControlledDictionaryEntry> entry;

    public ControlledDictionary() {
        this.entry = new ArrayList<>();
    }

    public List<ControlledDictionaryEntry> getEntryValue() { return this.entry; }
    public ControlledDictionary setEntryValue(List<ControlledDictionaryEntry> value) { this.entry = value; return this; }

}