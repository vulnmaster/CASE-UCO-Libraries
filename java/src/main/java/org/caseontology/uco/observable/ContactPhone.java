// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A contact phone is a grouping of characteristics unique to details for contacting a contact entity by telephone. */
public class ContactPhone extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactPhone";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject contactPhoneNumber;
    private List<String> contactPhoneScope;

    public ContactPhone() {
        this.contactPhoneScope = new ArrayList<>();
    }

    public ObservableObject getContactPhoneNumber() { return this.contactPhoneNumber; }
    public ContactPhone setContactPhoneNumber(ObservableObject value) { this.contactPhoneNumber = value; return this; }

    public List<String> getContactPhoneScope() { return this.contactPhoneScope; }
    public ContactPhone setContactPhoneScope(List<String> value) { this.contactPhoneScope = value; return this; }

}