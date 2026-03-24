// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.location;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A lat long coordinates facet is a grouping of characteristics unique to the expression of a geolocation as the intersection of specific latitude, longitude, and altitude values. */
public class LatLongCoordinatesFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/location/LatLongCoordinatesFacet";
    public static final String NAMESPACE_PREFIX = "uco-location";

    private java.math.BigDecimal altitude;
    private java.math.BigDecimal latitude;
    private java.math.BigDecimal longitude;

    public LatLongCoordinatesFacet() {
    }

    public java.math.BigDecimal getAltitude() { return this.altitude; }
    public LatLongCoordinatesFacet setAltitude(java.math.BigDecimal value) { this.altitude = value; return this; }

    public java.math.BigDecimal getLatitude() { return this.latitude; }
    public LatLongCoordinatesFacet setLatitude(java.math.BigDecimal value) { this.latitude = value; return this; }

    public java.math.BigDecimal getLongitude() { return this.longitude; }
    public LatLongCoordinatesFacet setLongitude(java.math.BigDecimal value) { this.longitude = value; return this; }

}