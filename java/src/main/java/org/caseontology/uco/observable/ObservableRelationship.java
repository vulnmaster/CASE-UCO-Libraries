// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Relationship;

/** An observable relationship is a grouping of characteristics unique to an assertion of an association between two observable objects. */
public class ObservableRelationship extends Relationship {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ObservableRelationship";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<Observable> source;
    private List<Observable> target;

    public ObservableRelationship() {
        this.source = new ArrayList<>();
        this.target = new ArrayList<>();
    }

    public List<Observable> getSourceValue() { return this.source; }
    public ObservableRelationship setSourceValue(List<Observable> value) { this.source = value; return this; }

    public List<Observable> getTargetValue() { return this.target; }
    public ObservableRelationship setTargetValue(List<Observable> value) { this.target = value; return this; }

}