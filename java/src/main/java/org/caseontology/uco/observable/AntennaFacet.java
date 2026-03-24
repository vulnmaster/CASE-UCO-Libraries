// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An antenna alignment facet contains the metadata surrounding the cell tower's antenna position. */
public class AntennaFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/AntennaFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private java.math.BigDecimal antennaHeight;
    private java.math.BigDecimal azimuth;
    private java.math.BigDecimal elevation;
    private java.math.BigDecimal horizontalBeamWidth;
    private java.math.BigDecimal signalStrength;
    private java.math.BigDecimal skew;

    public AntennaFacet() {
    }

    public java.math.BigDecimal getAntennaHeight() { return this.antennaHeight; }
    public AntennaFacet setAntennaHeight(java.math.BigDecimal value) { this.antennaHeight = value; return this; }

    public java.math.BigDecimal getAzimuth() { return this.azimuth; }
    public AntennaFacet setAzimuth(java.math.BigDecimal value) { this.azimuth = value; return this; }

    public java.math.BigDecimal getElevation() { return this.elevation; }
    public AntennaFacet setElevation(java.math.BigDecimal value) { this.elevation = value; return this; }

    public java.math.BigDecimal getHorizontalBeamWidth() { return this.horizontalBeamWidth; }
    public AntennaFacet setHorizontalBeamWidth(java.math.BigDecimal value) { this.horizontalBeamWidth = value; return this; }

    public java.math.BigDecimal getSignalStrength() { return this.signalStrength; }
    public AntennaFacet setSignalStrength(java.math.BigDecimal value) { this.signalStrength = value; return this; }

    public java.math.BigDecimal getSkew() { return this.skew; }
    public AntennaFacet setSkew(java.math.BigDecimal value) { this.skew = value; return this; }

}