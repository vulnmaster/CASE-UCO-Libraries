// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.analysis;

import java.util.ArrayList;
import java.util.List;

/** An artifact classification result facet is a grouping of characteristics unique to the results of an artifact classification analysis action. */
public class ArtifactClassificationResultFacet extends AnalyticResultFacet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/analysis/ArtifactClassificationResultFacet";
    public static final String NAMESPACE_PREFIX = "uco-analysis";

    private List<ArtifactClassification> classification;

    public ArtifactClassificationResultFacet() {
        this.classification = new ArrayList<>();
    }

    public List<ArtifactClassification> getClassification() { return this.classification; }
    public ArtifactClassificationResultFacet setClassification(List<ArtifactClassification> value) { this.classification = value; return this; }

}