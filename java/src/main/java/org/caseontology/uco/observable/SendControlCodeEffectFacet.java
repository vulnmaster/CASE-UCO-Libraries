// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A send control code effect facet is a grouping of characteristics unique to the effects of actions upon observable objects where a control code, or other control-oriented communication signal, is sent */
public class SendControlCodeEffectFacet extends DefinedEffectFacet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/SendControlCodeEffectFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String controlCode;

    public SendControlCodeEffectFacet() {
    }

    public String getControlCode() { return this.controlCode; }
    public SendControlCodeEffectFacet setControlCode(String value) { this.controlCode = value; return this; }

}