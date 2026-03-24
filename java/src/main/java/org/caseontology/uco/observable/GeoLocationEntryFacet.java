// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A geolocation entry facet is a grouping of characteristics unique to a single application-specific geolocation entry. */
public class GeoLocationEntryFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/GeoLocationEntryFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;
    private Location location;
    private java.time.ZonedDateTime observableCreatedTime;

    public GeoLocationEntryFacet() {
    }

    public ObservableObject getApplication() { return this.application; }
    public GeoLocationEntryFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public Location getLocation() { return this.location; }
    public GeoLocationEntryFacet setLocation(Location value) { this.location = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public GeoLocationEntryFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

}