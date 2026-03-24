// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A cell site facet contains the metadata surrounding the cell site. */
public class CellSiteFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/CellSiteFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String cellSiteCountryCode;
    private String cellSiteIdentifier;
    private String cellSiteLocationAreaCode;
    private String cellSiteNetworkCode;
    private String cellSiteType;

    public CellSiteFacet() {
    }

    public String getCellSiteCountryCode() { return this.cellSiteCountryCode; }
    public CellSiteFacet setCellSiteCountryCode(String value) { this.cellSiteCountryCode = value; return this; }

    public String getCellSiteIdentifier() { return this.cellSiteIdentifier; }
    public CellSiteFacet setCellSiteIdentifier(String value) { this.cellSiteIdentifier = value; return this; }

    public String getCellSiteLocationAreaCode() { return this.cellSiteLocationAreaCode; }
    public CellSiteFacet setCellSiteLocationAreaCode(String value) { this.cellSiteLocationAreaCode = value; return this; }

    public String getCellSiteNetworkCode() { return this.cellSiteNetworkCode; }
    public CellSiteFacet setCellSiteNetworkCode(String value) { this.cellSiteNetworkCode = value; return this; }

    public String getCellSiteType() { return this.cellSiteType; }
    public CellSiteFacet setCellSiteType(String value) { this.cellSiteType = value; return this; }

}