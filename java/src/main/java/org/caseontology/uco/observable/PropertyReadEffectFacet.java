// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A properties read effect facet is a grouping of characteristics unique to the effects of actions upon observable objects where a characteristic is read from an observable object. An example of this wo */
public class PropertyReadEffectFacet extends DefinedEffectFacet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/PropertyReadEffectFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String propertyName;
    private String value;

    public PropertyReadEffectFacet() {
    }

    public String getPropertyName() { return this.propertyName; }
    public PropertyReadEffectFacet setPropertyName(String value) { this.propertyName = value; return this; }

    public String getValue() { return this.value; }
    public PropertyReadEffectFacet setValue(String value) { this.value = value; return this; }

}