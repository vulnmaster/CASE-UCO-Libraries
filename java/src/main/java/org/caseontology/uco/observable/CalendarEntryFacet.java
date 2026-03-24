// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A calendar entry facet is a grouping of characteristics unique to an appointment, meeting, or event within a collection of appointments, meetings, and events. */
public class CalendarEntryFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/CalendarEntryFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;
    private List<Identity> attendant;
    private Long duration;
    private java.time.ZonedDateTime endTime;
    private String eventStatus;
    private String eventType;
    private Boolean isPrivate;
    private Location location;
    private java.time.ZonedDateTime modifiedTime;
    private java.time.ZonedDateTime observableCreatedTime;
    private UcoObject owner;
    private String recurrence;
    private java.time.ZonedDateTime remindTime;
    private java.time.ZonedDateTime startTime;
    private String subject;

    public CalendarEntryFacet() {
        this.attendant = new ArrayList<>();
    }

    public ObservableObject getApplication() { return this.application; }
    public CalendarEntryFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public List<Identity> getAttendant() { return this.attendant; }
    public CalendarEntryFacet setAttendant(List<Identity> value) { this.attendant = value; return this; }

    public Long getDuration() { return this.duration; }
    public CalendarEntryFacet setDuration(Long value) { this.duration = value; return this; }

    public java.time.ZonedDateTime getEndTime() { return this.endTime; }
    public CalendarEntryFacet setEndTime(java.time.ZonedDateTime value) { this.endTime = value; return this; }

    public String getEventStatus() { return this.eventStatus; }
    public CalendarEntryFacet setEventStatus(String value) { this.eventStatus = value; return this; }

    public String getEventType() { return this.eventType; }
    public CalendarEntryFacet setEventType(String value) { this.eventType = value; return this; }

    public Boolean getIsPrivate() { return this.isPrivate; }
    public CalendarEntryFacet setIsPrivate(Boolean value) { this.isPrivate = value; return this; }

    public Location getLocation() { return this.location; }
    public CalendarEntryFacet setLocation(Location value) { this.location = value; return this; }

    public java.time.ZonedDateTime getModifiedTime() { return this.modifiedTime; }
    public CalendarEntryFacet setModifiedTime(java.time.ZonedDateTime value) { this.modifiedTime = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public CalendarEntryFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

    public UcoObject getOwner() { return this.owner; }
    public CalendarEntryFacet setOwner(UcoObject value) { this.owner = value; return this; }

    public String getRecurrence() { return this.recurrence; }
    public CalendarEntryFacet setRecurrence(String value) { this.recurrence = value; return this; }

    public java.time.ZonedDateTime getRemindTime() { return this.remindTime; }
    public CalendarEntryFacet setRemindTime(java.time.ZonedDateTime value) { this.remindTime = value; return this; }

    public java.time.ZonedDateTime getStartTime() { return this.startTime; }
    public CalendarEntryFacet setStartTime(java.time.ZonedDateTime value) { this.startTime = value; return this; }

    public String getSubject() { return this.subject; }
    public CalendarEntryFacet setSubject(String value) { this.subject = value; return this; }

}