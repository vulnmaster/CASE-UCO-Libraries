// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An IShow message action type is a grouping of characteristics unique to an action that shows a message box when a task is activate. [based on https://docs.microsoft.com/en-us/windows/win32/api/tasksch */
public class IShowMessageActionType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/IShowMessageActionType";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String showMessageBody;
    private String showMessageTitle;

    public IShowMessageActionType() {
    }

    public String getShowMessageBody() { return this.showMessageBody; }
    public IShowMessageActionType setShowMessageBody(String value) { this.showMessageBody = value; return this; }

    public String getShowMessageTitle() { return this.showMessageTitle; }
    public IShowMessageActionType setShowMessageTitle(String value) { this.showMessageTitle = value; return this; }

}