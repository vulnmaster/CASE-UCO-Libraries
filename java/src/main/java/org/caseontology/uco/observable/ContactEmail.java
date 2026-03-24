// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A contact email is a grouping of characteristics unique to details for contacting a contact entity by email. */
public class ContactEmail extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactEmail";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> contactEmailScope;
    private ObservableObject emailAddress;

    public ContactEmail() {
        this.contactEmailScope = new ArrayList<>();
    }

    public List<String> getContactEmailScope() { return this.contactEmailScope; }
    public ContactEmail setContactEmailScope(List<String> value) { this.contactEmailScope = value; return this; }

    public ObservableObject getEmailAddress() { return this.emailAddress; }
    public ContactEmail setEmailAddress(ObservableObject value) { this.emailAddress = value; return this; }

}