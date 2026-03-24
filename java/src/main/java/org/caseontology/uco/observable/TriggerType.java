// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A trigger type is a grouping of characterizes unique to a set of criteria that, when met, starts the execution of a task within a Windows operating system. [based on https://docs.microsoft.com/en-us/w */
public class TriggerType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/TriggerType";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Boolean isEnabled;
    private java.time.ZonedDateTime triggerBeginTime;
    private String triggerDelay;
    private java.time.ZonedDateTime triggerEndTime;
    private List<String> triggerFrequency;
    private String triggerMaxRunTime;
    private String triggerSessionChangeType;
    private List<String> triggerType;

    public TriggerType() {
        this.triggerFrequency = new ArrayList<>();
        this.triggerType = new ArrayList<>();
    }

    public Boolean getIsEnabled() { return this.isEnabled; }
    public TriggerType setIsEnabled(Boolean value) { this.isEnabled = value; return this; }

    public java.time.ZonedDateTime getTriggerBeginTime() { return this.triggerBeginTime; }
    public TriggerType setTriggerBeginTime(java.time.ZonedDateTime value) { this.triggerBeginTime = value; return this; }

    public String getTriggerDelay() { return this.triggerDelay; }
    public TriggerType setTriggerDelay(String value) { this.triggerDelay = value; return this; }

    public java.time.ZonedDateTime getTriggerEndTime() { return this.triggerEndTime; }
    public TriggerType setTriggerEndTime(java.time.ZonedDateTime value) { this.triggerEndTime = value; return this; }

    public List<String> getTriggerFrequency() { return this.triggerFrequency; }
    public TriggerType setTriggerFrequency(List<String> value) { this.triggerFrequency = value; return this; }

    public String getTriggerMaxRunTime() { return this.triggerMaxRunTime; }
    public TriggerType setTriggerMaxRunTime(String value) { this.triggerMaxRunTime = value; return this; }

    public String getTriggerSessionChangeType() { return this.triggerSessionChangeType; }
    public TriggerType setTriggerSessionChangeType(String value) { this.triggerSessionChangeType = value; return this; }

    public List<String> getTriggerType() { return this.triggerType; }
    public TriggerType setTriggerType(List<String> value) { this.triggerType = value; return this; }

}