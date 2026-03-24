// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.core;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.types.Dictionary;

/** An Event is a noteworthy occurrence (something that happens or might happen). */
public class Event extends UcoObject {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/core/Event";
    public static final String NAMESPACE_PREFIX = "uco-core";

    private List<java.time.ZonedDateTime> endTime;
    private List<Dictionary> eventAttribute;
    private List<UcoObject> eventContext;
    private List<String> eventType;
    private List<java.time.ZonedDateTime> startTime;

    public Event() {
        this.endTime = new ArrayList<>();
        this.eventAttribute = new ArrayList<>();
        this.eventContext = new ArrayList<>();
        this.eventType = new ArrayList<>();
        this.startTime = new ArrayList<>();
    }

    public List<java.time.ZonedDateTime> getEndTime() { return this.endTime; }
    public Event setEndTime(List<java.time.ZonedDateTime> value) { this.endTime = value; return this; }

    public List<Dictionary> getEventAttribute() { return this.eventAttribute; }
    public Event setEventAttribute(List<Dictionary> value) { this.eventAttribute = value; return this; }

    public List<UcoObject> getEventContext() { return this.eventContext; }
    public Event setEventContext(List<UcoObject> value) { this.eventContext = value; return this; }

    public List<String> getEventType() { return this.eventType; }
    public Event setEventType(List<String> value) { this.eventType = value; return this; }

    public List<java.time.ZonedDateTime> getStartTime() { return this.startTime; }
    public Event setStartTime(List<java.time.ZonedDateTime> value) { this.startTime = value; return this; }

}