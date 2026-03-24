// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A contact messaging is a grouping of characteristics unique to details for contacting a contact entity by digital messaging. */
public class ContactMessaging extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactMessaging";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject contactMessagingPlatform;
    private ObservableObject messagingAddress;

    public ContactMessaging() {
    }

    public ObservableObject getContactMessagingPlatform() { return this.contactMessagingPlatform; }
    public ContactMessaging setContactMessagingPlatform(ObservableObject value) { this.contactMessagingPlatform = value; return this; }

    public ObservableObject getMessagingAddress() { return this.messagingAddress; }
    public ContactMessaging setMessagingAddress(ObservableObject value) { this.messagingAddress = value; return this; }

}