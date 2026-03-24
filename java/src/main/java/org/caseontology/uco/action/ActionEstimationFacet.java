// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.action;

import java.util.ArrayList;
import java.util.List;

/** An action estimation facet is a grouping of characteristics unique to decision-focused approximation aspects for an action that may potentially be performed. */
public class ActionEstimationFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/action/ActionEstimationFacet";
    public static final String NAMESPACE_PREFIX = "uco-action";

    private String estimatedCost;
    private String estimatedEfficacy;
    private String estimatedImpact;
    private String objective;

    public ActionEstimationFacet() {
    }

    public String getEstimatedCost() { return this.estimatedCost; }
    public ActionEstimationFacet setEstimatedCost(String value) { this.estimatedCost = value; return this; }

    public String getEstimatedEfficacy() { return this.estimatedEfficacy; }
    public ActionEstimationFacet setEstimatedEfficacy(String value) { this.estimatedEfficacy = value; return this; }

    public String getEstimatedImpact() { return this.estimatedImpact; }
    public ActionEstimationFacet setEstimatedImpact(String value) { this.estimatedImpact = value; return this; }

    public String getObjective() { return this.objective; }
    public ActionEstimationFacet setObjective(String value) { this.objective = value; return this; }

}