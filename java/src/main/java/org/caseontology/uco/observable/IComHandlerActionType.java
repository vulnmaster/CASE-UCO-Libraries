// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An IComHandler action type is a grouping of characteristics unique to a Windows Task-related action that fires a Windows COM handler (smart code in the client address space that can optimize calls bet */
public class IComHandlerActionType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/IComHandlerActionType";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String comClassID;
    private String comData;

    public IComHandlerActionType() {
    }

    public String getComClassID() { return this.comClassID; }
    public IComHandlerActionType setComClassID(String value) { this.comClassID = value; return this; }

    public String getComData() { return this.comData; }
    public IComHandlerActionType setComData(String value) { this.comData = value; return this; }

}