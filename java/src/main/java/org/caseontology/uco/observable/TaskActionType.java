// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A task action type is a grouping of characteristics for a scheduled action to be completed. */
public class TaskActionType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/TaskActionType";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String actionID;
    private List<String> actionType;
    private IComHandlerActionType iComHandlerAction;
    private ObservableObject iEmailAction;
    private IExecActionType iExecAction;
    private IShowMessageActionType iShowMessageAction;

    public TaskActionType() {
        this.actionType = new ArrayList<>();
    }

    public String getActionID() { return this.actionID; }
    public TaskActionType setActionID(String value) { this.actionID = value; return this; }

    public List<String> getActionType() { return this.actionType; }
    public TaskActionType setActionType(List<String> value) { this.actionType = value; return this; }

    public IComHandlerActionType getIComHandlerAction() { return this.iComHandlerAction; }
    public TaskActionType setIComHandlerAction(IComHandlerActionType value) { this.iComHandlerAction = value; return this; }

    public ObservableObject getIEmailAction() { return this.iEmailAction; }
    public TaskActionType setIEmailAction(ObservableObject value) { this.iEmailAction = value; return this; }

    public IExecActionType getIExecAction() { return this.iExecAction; }
    public TaskActionType setIExecAction(IExecActionType value) { this.iExecAction = value; return this; }

    public IShowMessageActionType getIShowMessageAction() { return this.iShowMessageAction; }
    public TaskActionType setIShowMessageAction(IShowMessageActionType value) { this.iShowMessageAction = value; return this; }

}