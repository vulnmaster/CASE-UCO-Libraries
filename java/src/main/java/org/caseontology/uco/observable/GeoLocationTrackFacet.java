// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A geolocation track facet is a grouping of characteristics unique to a set of contiguous geolocation entries representing a path/track taken. */
public class GeoLocationTrackFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/GeoLocationTrackFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;
    private java.time.ZonedDateTime endTime;
    private List<ObservableObject> geoLocationEntry;
    private java.time.ZonedDateTime startTime;

    public GeoLocationTrackFacet() {
        this.geoLocationEntry = new ArrayList<>();
    }

    public ObservableObject getApplication() { return this.application; }
    public GeoLocationTrackFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public java.time.ZonedDateTime getEndTime() { return this.endTime; }
    public GeoLocationTrackFacet setEndTime(java.time.ZonedDateTime value) { this.endTime = value; return this; }

    public List<ObservableObject> getGeoLocationEntry() { return this.geoLocationEntry; }
    public GeoLocationTrackFacet setGeoLocationEntry(List<ObservableObject> value) { this.geoLocationEntry = value; return this; }

    public java.time.ZonedDateTime getStartTime() { return this.startTime; }
    public GeoLocationTrackFacet setStartTime(java.time.ZonedDateTime value) { this.startTime = value; return this; }

}