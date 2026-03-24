// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A call facet is a grouping of characteristics unique to a connection as part of a realtime cyber communication between one or more parties. */
public class CallFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/CallFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;
    private String callType;
    private Long duration;
    private java.time.ZonedDateTime endTime;
    private ObservableObject from;
    private List<ObservableObject> participant;
    private java.time.ZonedDateTime startTime;
    private List<ObservableObject> to;

    public CallFacet() {
        this.participant = new ArrayList<>();
        this.to = new ArrayList<>();
    }

    public ObservableObject getApplication() { return this.application; }
    public CallFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public String getCallType() { return this.callType; }
    public CallFacet setCallType(String value) { this.callType = value; return this; }

    public Long getDuration() { return this.duration; }
    public CallFacet setDuration(Long value) { this.duration = value; return this; }

    public java.time.ZonedDateTime getEndTime() { return this.endTime; }
    public CallFacet setEndTime(java.time.ZonedDateTime value) { this.endTime = value; return this; }

    public ObservableObject getFrom() { return this.from; }
    public CallFacet setFrom(ObservableObject value) { this.from = value; return this; }

    public List<ObservableObject> getParticipant() { return this.participant; }
    public CallFacet setParticipant(List<ObservableObject> value) { this.participant = value; return this; }

    public java.time.ZonedDateTime getStartTime() { return this.startTime; }
    public CallFacet setStartTime(java.time.ZonedDateTime value) { this.startTime = value; return this; }

    public List<ObservableObject> getTo() { return this.to; }
    public CallFacet setTo(List<ObservableObject> value) { this.to = value; return this; }

}