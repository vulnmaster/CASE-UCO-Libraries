// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A wireless network connection facet is a grouping of characteristics unique to a connection (completed or attempted) across an IEEE 802.11 standards-conformant digital network (a group of two or more  */
public class WirelessNetworkConnectionFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WirelessNetworkConnectionFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String baseStation;
    private String password;
    private String ssid;
    private List<String> wirelessNetworkSecurityMode;

    public WirelessNetworkConnectionFacet() {
        this.wirelessNetworkSecurityMode = new ArrayList<>();
    }

    public String getBaseStation() { return this.baseStation; }
    public WirelessNetworkConnectionFacet setBaseStation(String value) { this.baseStation = value; return this; }

    public String getPassword() { return this.password; }
    public WirelessNetworkConnectionFacet setPassword(String value) { this.password = value; return this; }

    public String getSsid() { return this.ssid; }
    public WirelessNetworkConnectionFacet setSsid(String value) { this.ssid = value; return this; }

    public List<String> getWirelessNetworkSecurityMode() { return this.wirelessNetworkSecurityMode; }
    public WirelessNetworkConnectionFacet setWirelessNetworkSecurityMode(List<String> value) { this.wirelessNetworkSecurityMode = value; return this; }

}