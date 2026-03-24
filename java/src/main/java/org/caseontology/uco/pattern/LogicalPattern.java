// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.pattern;

import java.util.ArrayList;
import java.util.List;

/** A logical pattern is a grouping of characteristics unique to an informational pattern expressed via a structured pattern expression following the rules of logic. */
public class LogicalPattern extends Pattern {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/pattern/LogicalPattern";
    public static final String NAMESPACE_PREFIX = "uco-pattern";

    private PatternExpression patternExpression;

    public LogicalPattern() {
    }

    public PatternExpression getPatternExpression() { return this.patternExpression; }
    public LogicalPattern setPatternExpression(PatternExpression value) { this.patternExpression = value; return this; }

}