// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.core;

import java.util.ArrayList;
import java.util.List;

/** An assertion is a statement declared to be true. */
public class Assertion extends UcoObject {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/core/Assertion";
    public static final String NAMESPACE_PREFIX = "uco-core";

    private List<String> statement;

    public Assertion() {
        this.statement = new ArrayList<>();
    }

    public List<String> getStatement() { return this.statement; }
    public Assertion setStatement(List<String> value) { this.statement = value; return this; }

}