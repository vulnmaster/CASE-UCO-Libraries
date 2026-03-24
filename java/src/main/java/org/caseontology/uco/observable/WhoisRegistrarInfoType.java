// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;
import org.caseontology.uco.location.Location;

/** A Whois registrar info type is a grouping of characteristics unique to registrar-related information present in a response record conformant to the WHOIS protocol standard (RFC 3912). [based on https: */
public class WhoisRegistrarInfoType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WhoisRegistrarInfoType";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject contactPhoneNumber;
    private ObservableObject emailAddress;
    private Location geolocationAddress;
    private ObservableObject referralURL;
    private String registrarGUID;
    private String registrarID;
    private String registrarName;
    private ObservableObject whoisServer;

    public WhoisRegistrarInfoType() {
    }

    public ObservableObject getContactPhoneNumber() { return this.contactPhoneNumber; }
    public WhoisRegistrarInfoType setContactPhoneNumber(ObservableObject value) { this.contactPhoneNumber = value; return this; }

    public ObservableObject getEmailAddress() { return this.emailAddress; }
    public WhoisRegistrarInfoType setEmailAddress(ObservableObject value) { this.emailAddress = value; return this; }

    public Location getGeolocationAddress() { return this.geolocationAddress; }
    public WhoisRegistrarInfoType setGeolocationAddress(Location value) { this.geolocationAddress = value; return this; }

    public ObservableObject getReferralURL() { return this.referralURL; }
    public WhoisRegistrarInfoType setReferralURL(ObservableObject value) { this.referralURL = value; return this; }

    public String getRegistrarGUID() { return this.registrarGUID; }
    public WhoisRegistrarInfoType setRegistrarGUID(String value) { this.registrarGUID = value; return this; }

    public String getRegistrarID() { return this.registrarID; }
    public WhoisRegistrarInfoType setRegistrarID(String value) { this.registrarID = value; return this; }

    public String getRegistrarName() { return this.registrarName; }
    public WhoisRegistrarInfoType setRegistrarName(String value) { this.registrarName = value; return this; }

    public ObservableObject getWhoisServer() { return this.whoisServer; }
    public WhoisRegistrarInfoType setWhoisServer(ObservableObject value) { this.whoisServer = value; return this; }

}