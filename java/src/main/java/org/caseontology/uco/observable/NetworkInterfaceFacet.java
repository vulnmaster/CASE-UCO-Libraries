// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A network interface facet is a grouping of characteristics unique to a software or hardware interface between two pieces of equipment or protocol layers in a computer network. */
public class NetworkInterfaceFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkInterfaceFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String adapterName;
    private java.time.ZonedDateTime dhcpLeaseExpires;
    private java.time.ZonedDateTime dhcpLeaseObtained;
    private List<ObservableObject> dhcpServer;
    private List<ObservableObject> ip;
    private List<ObservableObject> ipGateway;
    private ObservableObject macAddress;

    public NetworkInterfaceFacet() {
        this.dhcpServer = new ArrayList<>();
        this.ip = new ArrayList<>();
        this.ipGateway = new ArrayList<>();
    }

    public String getAdapterName() { return this.adapterName; }
    public NetworkInterfaceFacet setAdapterName(String value) { this.adapterName = value; return this; }

    public java.time.ZonedDateTime getDhcpLeaseExpires() { return this.dhcpLeaseExpires; }
    public NetworkInterfaceFacet setDhcpLeaseExpires(java.time.ZonedDateTime value) { this.dhcpLeaseExpires = value; return this; }

    public java.time.ZonedDateTime getDhcpLeaseObtained() { return this.dhcpLeaseObtained; }
    public NetworkInterfaceFacet setDhcpLeaseObtained(java.time.ZonedDateTime value) { this.dhcpLeaseObtained = value; return this; }

    public List<ObservableObject> getDhcpServer() { return this.dhcpServer; }
    public NetworkInterfaceFacet setDhcpServer(List<ObservableObject> value) { this.dhcpServer = value; return this; }

    public List<ObservableObject> getIp() { return this.ip; }
    public NetworkInterfaceFacet setIp(List<ObservableObject> value) { this.ip = value; return this; }

    public List<ObservableObject> getIpGateway() { return this.ipGateway; }
    public NetworkInterfaceFacet setIpGateway(List<ObservableObject> value) { this.ipGateway = value; return this; }

    public ObservableObject getMacAddress() { return this.macAddress; }
    public NetworkInterfaceFacet setMacAddress(ObservableObject value) { this.macAddress = value; return this; }

}