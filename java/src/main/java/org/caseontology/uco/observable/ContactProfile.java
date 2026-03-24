// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A contact profile is a grouping of characteristics unique to details for contacting a contact entity by online service. */
public class ContactProfile extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactProfile";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject contactProfilePlatform;
    private ObservableObject profile;

    public ContactProfile() {
    }

    public ObservableObject getContactProfilePlatform() { return this.contactProfilePlatform; }
    public ContactProfile setContactProfilePlatform(ObservableObject value) { this.contactProfilePlatform = value; return this; }

    public ObservableObject getProfile() { return this.profile; }
    public ContactProfile setProfile(ObservableObject value) { this.profile = value; return this; }

}