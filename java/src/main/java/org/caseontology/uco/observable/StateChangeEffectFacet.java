// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A state change effect facet is a grouping of characteristics unique to the effects of actions upon observable objects where a state of the observable object is changed. */
public class StateChangeEffectFacet extends DefinedEffectFacet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/StateChangeEffectFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject newObject;
    private ObservableObject oldObject;

    public StateChangeEffectFacet() {
    }

    public ObservableObject getNewObject() { return this.newObject; }
    public StateChangeEffectFacet setNewObject(ObservableObject value) { this.newObject = value; return this; }

    public ObservableObject getOldObject() { return this.oldObject; }
    public StateChangeEffectFacet setOldObject(ObservableObject value) { this.oldObject = value; return this; }

}