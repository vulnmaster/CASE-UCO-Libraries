// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A contact address is a grouping of characteristics unique to a geolocation address of a contact entity. */
public class ContactAddress extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactAddress";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> contactAddressScope;
    private Location geolocationAddress;

    public ContactAddress() {
        this.contactAddressScope = new ArrayList<>();
    }

    public List<String> getContactAddressScope() { return this.contactAddressScope; }
    public ContactAddress setContactAddressScope(List<String> value) { this.contactAddressScope = value; return this; }

    public Location getGeolocationAddress() { return this.geolocationAddress; }
    public ContactAddress setGeolocationAddress(Location value) { this.geolocationAddress = value; return this; }

}