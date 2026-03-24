// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A whois facet is a grouping of characteristics unique to a response record conformant to the WHOIS protocol standard (RFC 3912). [based on https://en.wikipedia.org/wiki/WHOIS] */
public class WhoIsFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WhoIsFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private java.time.ZonedDateTime creationDate;
    private WhoisDNSSECTypeVocab dnssec;
    private String domainID;
    private ObservableObject domainName;
    private java.time.ZonedDateTime expirationDate;
    private ObservableObject ipAddress;
    private java.time.ZonedDateTime lookupDate;
    private List<ObservableObject> nameServer;
    private List<String> regionalInternetRegistry;
    private ObservableObject registrantContactInfo;
    private List<String> registrantIDs;
    private WhoisRegistrarInfoType registrarInfo;
    private String remarks;
    private ObservableObject serverName;
    private String sponsoringRegistrar;
    private List<String> status;
    private java.time.ZonedDateTime updatedDate;

    public WhoIsFacet() {
        this.nameServer = new ArrayList<>();
        this.regionalInternetRegistry = new ArrayList<>();
        this.registrantIDs = new ArrayList<>();
        this.status = new ArrayList<>();
    }

    public java.time.ZonedDateTime getCreationDate() { return this.creationDate; }
    public WhoIsFacet setCreationDate(java.time.ZonedDateTime value) { this.creationDate = value; return this; }

    public WhoisDNSSECTypeVocab getDnssec() { return this.dnssec; }
    public WhoIsFacet setDnssec(WhoisDNSSECTypeVocab value) { this.dnssec = value; return this; }

    public String getDomainID() { return this.domainID; }
    public WhoIsFacet setDomainID(String value) { this.domainID = value; return this; }

    public ObservableObject getDomainName() { return this.domainName; }
    public WhoIsFacet setDomainName(ObservableObject value) { this.domainName = value; return this; }

    public java.time.ZonedDateTime getExpirationDate() { return this.expirationDate; }
    public WhoIsFacet setExpirationDate(java.time.ZonedDateTime value) { this.expirationDate = value; return this; }

    public ObservableObject getIpAddress() { return this.ipAddress; }
    public WhoIsFacet setIpAddress(ObservableObject value) { this.ipAddress = value; return this; }

    public java.time.ZonedDateTime getLookupDate() { return this.lookupDate; }
    public WhoIsFacet setLookupDate(java.time.ZonedDateTime value) { this.lookupDate = value; return this; }

    public List<ObservableObject> getNameServer() { return this.nameServer; }
    public WhoIsFacet setNameServer(List<ObservableObject> value) { this.nameServer = value; return this; }

    public List<String> getRegionalInternetRegistry() { return this.regionalInternetRegistry; }
    public WhoIsFacet setRegionalInternetRegistry(List<String> value) { this.regionalInternetRegistry = value; return this; }

    public ObservableObject getRegistrantContactInfo() { return this.registrantContactInfo; }
    public WhoIsFacet setRegistrantContactInfo(ObservableObject value) { this.registrantContactInfo = value; return this; }

    public List<String> getRegistrantIDs() { return this.registrantIDs; }
    public WhoIsFacet setRegistrantIDs(List<String> value) { this.registrantIDs = value; return this; }

    public WhoisRegistrarInfoType getRegistrarInfo() { return this.registrarInfo; }
    public WhoIsFacet setRegistrarInfo(WhoisRegistrarInfoType value) { this.registrarInfo = value; return this; }

    public String getRemarks() { return this.remarks; }
    public WhoIsFacet setRemarks(String value) { this.remarks = value; return this; }

    public ObservableObject getServerName() { return this.serverName; }
    public WhoIsFacet setServerName(ObservableObject value) { this.serverName = value; return this; }

    public String getSponsoringRegistrar() { return this.sponsoringRegistrar; }
    public WhoIsFacet setSponsoringRegistrar(String value) { this.sponsoringRegistrar = value; return this; }

    public List<String> getStatus() { return this.status; }
    public WhoIsFacet setStatus(List<String> value) { this.status = value; return this; }

    public java.time.ZonedDateTime getUpdatedDate() { return this.updatedDate; }
    public WhoIsFacet setUpdatedDate(java.time.ZonedDateTime value) { this.updatedDate = value; return this; }

}