// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A contact SIP is a grouping of characteristics unique to details for contacting a contact entity by Session Initiation Protocol (SIP). */
public class ContactSIP extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactSIP";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> contactSIPScope;
    private ObservableObject sipAddress;

    public ContactSIP() {
        this.contactSIPScope = new ArrayList<>();
    }

    public List<String> getContactSIPScope() { return this.contactSIPScope; }
    public ContactSIP setContactSIPScope(List<String> value) { this.contactSIPScope = value; return this; }

    public ObservableObject getSipAddress() { return this.sipAddress; }
    public ContactSIP setSipAddress(ObservableObject value) { this.sipAddress = value; return this; }

}