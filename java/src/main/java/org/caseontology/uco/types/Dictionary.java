// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.types;

import java.util.ArrayList;
import java.util.List;

/** A dictionary is list of (term/key, value) pairs with each term/key having an expectation to exist no more than once.  types:Dictionary alone does not validate this expectation, but validation is avail */
public class Dictionary extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/types/Dictionary";
    public static final String NAMESPACE_PREFIX = "uco-types";

    private List<DictionaryEntry> entry;

    public Dictionary() {
        this.entry = new ArrayList<>();
    }

    public List<DictionaryEntry> getEntry() { return this.entry; }
    public Dictionary setEntry(List<DictionaryEntry> value) { this.entry = value; return this; }

}