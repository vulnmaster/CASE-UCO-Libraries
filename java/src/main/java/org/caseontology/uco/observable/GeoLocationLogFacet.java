// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A geolocation log facet is a grouping of characteristics unique to a record containing geolocation tracks and/or geolocation entries. */
public class GeoLocationLogFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/GeoLocationLogFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;
    private java.time.ZonedDateTime observableCreatedTime;

    public GeoLocationLogFacet() {
    }

    public ObservableObject getApplication() { return this.application; }
    public GeoLocationLogFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public GeoLocationLogFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

}