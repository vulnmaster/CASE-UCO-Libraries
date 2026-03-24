// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.core;

import java.util.ArrayList;
import java.util.List;

/** A contextual compilation is a grouping of things sharing some context (e.g., a set of network connections observed on a given day, all accounts associated with a given person). */
public class ContextualCompilation extends Compilation {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/core/ContextualCompilation";
    public static final String NAMESPACE_PREFIX = "uco-core";

    private List<UcoObject> object;

    public ContextualCompilation() {
        this.object = new ArrayList<>();
    }

    public List<UcoObject> getObject() { return this.object; }
    public ContextualCompilation setObject(List<UcoObject> value) { this.object = value; return this; }

}