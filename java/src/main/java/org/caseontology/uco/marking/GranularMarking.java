// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.marking;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A granular marking is a grouping of characteristics unique to specification of marking definitions (restrictions, permissions, and other guidance for how data can be used and shared) that apply to par */
public class GranularMarking extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/marking/GranularMarking";
    public static final String NAMESPACE_PREFIX = "uco-marking";

    private List<String> contentSelectors;
    private List<MarkingDefinition> marking;

    public GranularMarking() {
        this.contentSelectors = new ArrayList<>();
        this.marking = new ArrayList<>();
    }

    public List<String> getContentSelectors() { return this.contentSelectors; }
    public GranularMarking setContentSelectors(List<String> value) { this.contentSelectors = value; return this; }

    public List<MarkingDefinition> getMarking() { return this.marking; }
    public GranularMarking setMarking(List<MarkingDefinition> value) { this.marking = value; return this; }

}