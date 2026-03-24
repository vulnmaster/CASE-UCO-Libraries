// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An event record facet is a grouping of characteristics unique to something that happens in a digital context (e.g., operating system events). */
public class EventRecordFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/EventRecordFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject account;
    private ObservableObject application;
    private ObservableAction cyberAction;
    private java.time.ZonedDateTime endTime;
    private String eventID;
    private ObservableObject eventRecordDevice;
    private String eventRecordID;
    private String eventRecordRaw;
    private String eventRecordServiceName;
    private String eventRecordText;
    private String eventType;
    private java.time.ZonedDateTime observableCreatedTime;
    private java.time.ZonedDateTime startTime;

    public EventRecordFacet() {
    }

    public ObservableObject getAccount() { return this.account; }
    public EventRecordFacet setAccount(ObservableObject value) { this.account = value; return this; }

    public ObservableObject getApplication() { return this.application; }
    public EventRecordFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public ObservableAction getCyberAction() { return this.cyberAction; }
    public EventRecordFacet setCyberAction(ObservableAction value) { this.cyberAction = value; return this; }

    public java.time.ZonedDateTime getEndTime() { return this.endTime; }
    public EventRecordFacet setEndTime(java.time.ZonedDateTime value) { this.endTime = value; return this; }

    public String getEventID() { return this.eventID; }
    public EventRecordFacet setEventID(String value) { this.eventID = value; return this; }

    public ObservableObject getEventRecordDevice() { return this.eventRecordDevice; }
    public EventRecordFacet setEventRecordDevice(ObservableObject value) { this.eventRecordDevice = value; return this; }

    public String getEventRecordID() { return this.eventRecordID; }
    public EventRecordFacet setEventRecordID(String value) { this.eventRecordID = value; return this; }

    public String getEventRecordRaw() { return this.eventRecordRaw; }
    public EventRecordFacet setEventRecordRaw(String value) { this.eventRecordRaw = value; return this; }

    public String getEventRecordServiceName() { return this.eventRecordServiceName; }
    public EventRecordFacet setEventRecordServiceName(String value) { this.eventRecordServiceName = value; return this; }

    public String getEventRecordText() { return this.eventRecordText; }
    public EventRecordFacet setEventRecordText(String value) { this.eventRecordText = value; return this; }

    public String getEventType() { return this.eventType; }
    public EventRecordFacet setEventType(String value) { this.eventType = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public EventRecordFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

    public java.time.ZonedDateTime getStartTime() { return this.startTime; }
    public EventRecordFacet setStartTime(java.time.ZonedDateTime value) { this.startTime = value; return this; }

}