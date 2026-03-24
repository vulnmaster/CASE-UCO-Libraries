// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.action;

import java.util.ArrayList;
import java.util.List;

/** An action is something that may be done or performed. */
public class Action extends UcoObject {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/action/Action";
    public static final String NAMESPACE_PREFIX = "uco-action";

    private Long actionCount;
    private List<String> actionStatus;
    private java.time.ZonedDateTime endTime;
    private UcoObject environment;
    private List<UcoObject> error;
    private List<UcoObject> instrument;
    private List<Location> location;
    private List<UcoObject> object;
    private List<UcoObject> participant;
    private UcoObject performer;
    private List<UcoObject> result;
    private java.time.ZonedDateTime startTime;
    private List<Action> subaction;

    public Action() {
        this.actionStatus = new ArrayList<>();
        this.error = new ArrayList<>();
        this.instrument = new ArrayList<>();
        this.location = new ArrayList<>();
        this.object = new ArrayList<>();
        this.participant = new ArrayList<>();
        this.result = new ArrayList<>();
        this.subaction = new ArrayList<>();
    }

    public Long getActionCount() { return this.actionCount; }
    public Action setActionCount(Long value) { this.actionCount = value; return this; }

    public List<String> getActionStatus() { return this.actionStatus; }
    public Action setActionStatus(List<String> value) { this.actionStatus = value; return this; }

    public java.time.ZonedDateTime getEndTime() { return this.endTime; }
    public Action setEndTime(java.time.ZonedDateTime value) { this.endTime = value; return this; }

    public UcoObject getEnvironment() { return this.environment; }
    public Action setEnvironment(UcoObject value) { this.environment = value; return this; }

    public List<UcoObject> getError() { return this.error; }
    public Action setError(List<UcoObject> value) { this.error = value; return this; }

    public List<UcoObject> getInstrument() { return this.instrument; }
    public Action setInstrument(List<UcoObject> value) { this.instrument = value; return this; }

    public List<Location> getLocation() { return this.location; }
    public Action setLocation(List<Location> value) { this.location = value; return this; }

    public List<UcoObject> getObject() { return this.object; }
    public Action setObject(List<UcoObject> value) { this.object = value; return this; }

    public List<UcoObject> getParticipant() { return this.participant; }
    public Action setParticipant(List<UcoObject> value) { this.participant = value; return this; }

    public UcoObject getPerformer() { return this.performer; }
    public Action setPerformer(UcoObject value) { this.performer = value; return this; }

    public List<UcoObject> getResult() { return this.result; }
    public Action setResult(List<UcoObject> value) { this.result = value; return this; }

    public java.time.ZonedDateTime getStartTime() { return this.startTime; }
    public Action setStartTime(java.time.ZonedDateTime value) { this.startTime = value; return this; }

    public List<Action> getSubaction() { return this.subaction; }
    public Action setSubaction(List<Action> value) { this.subaction = value; return this; }

}