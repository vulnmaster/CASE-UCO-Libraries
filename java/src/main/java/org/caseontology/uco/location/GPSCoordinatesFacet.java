// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.location;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A GPS coordinates facet is a grouping of characteristics unique to the expression of quantified dilution of precision (DOP) for an asserted set of geolocation coordinates typically associated with sat */
public class GPSCoordinatesFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/location/GPSCoordinatesFacet";
    public static final String NAMESPACE_PREFIX = "uco-location";

    private java.math.BigDecimal hdop;
    private java.math.BigDecimal pdop;
    private java.math.BigDecimal tdop;
    private java.math.BigDecimal vdop;

    public GPSCoordinatesFacet() {
    }

    public java.math.BigDecimal getHdop() { return this.hdop; }
    public GPSCoordinatesFacet setHdop(java.math.BigDecimal value) { this.hdop = value; return this; }

    public java.math.BigDecimal getPdop() { return this.pdop; }
    public GPSCoordinatesFacet setPdop(java.math.BigDecimal value) { this.pdop = value; return this; }

    public java.math.BigDecimal getTdop() { return this.tdop; }
    public GPSCoordinatesFacet setTdop(java.math.BigDecimal value) { this.tdop = value; return this; }

    public java.math.BigDecimal getVdop() { return this.vdop; }
    public GPSCoordinatesFacet setVdop(java.math.BigDecimal value) { this.vdop = value; return this; }

}