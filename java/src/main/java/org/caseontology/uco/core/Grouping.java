// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.core;

import java.util.ArrayList;
import java.util.List;

/** A grouping is a compilation of referenced UCO content with a shared context. */
public class Grouping extends ContextualCompilation {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/core/Grouping";
    public static final String NAMESPACE_PREFIX = "uco-core";

    private List<String> context;

    public Grouping() {
        this.context = new ArrayList<>();
    }

    public List<String> getContext() { return this.context; }
    public Grouping setContext(List<String> value) { this.context = value; return this; }

}