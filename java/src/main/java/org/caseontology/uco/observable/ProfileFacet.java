// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.identity.Identity;

/** A profile facet is a grouping of characteristics unique to an explicit digital representation of identity and characteristics of the owner of a single user account associated with an online service or */
public class ProfileFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ProfileFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String name;
    private ContactAddress contactAddress;
    private ContactEmail contactEmail;
    private ContactMessaging contactMessaging;
    private ContactPhone contactPhone;
    private ContactURL contactURL;
    private String displayName;
    private ObservableObject profileAccount;
    private java.time.ZonedDateTime profileCreated;
    private Identity profileIdentity;
    private List<String> profileLanguage;
    private ObservableObject profileService;
    private ObservableObject profileWebsite;

    public ProfileFacet() {
        this.profileLanguage = new ArrayList<>();
    }

    public String getName() { return this.name; }
    public ProfileFacet setName(String value) { this.name = value; return this; }

    public ContactAddress getContactAddress() { return this.contactAddress; }
    public ProfileFacet setContactAddress(ContactAddress value) { this.contactAddress = value; return this; }

    public ContactEmail getContactEmail() { return this.contactEmail; }
    public ProfileFacet setContactEmail(ContactEmail value) { this.contactEmail = value; return this; }

    public ContactMessaging getContactMessaging() { return this.contactMessaging; }
    public ProfileFacet setContactMessaging(ContactMessaging value) { this.contactMessaging = value; return this; }

    public ContactPhone getContactPhone() { return this.contactPhone; }
    public ProfileFacet setContactPhone(ContactPhone value) { this.contactPhone = value; return this; }

    public ContactURL getContactURL() { return this.contactURL; }
    public ProfileFacet setContactURL(ContactURL value) { this.contactURL = value; return this; }

    public String getDisplayName() { return this.displayName; }
    public ProfileFacet setDisplayName(String value) { this.displayName = value; return this; }

    public ObservableObject getProfileAccount() { return this.profileAccount; }
    public ProfileFacet setProfileAccount(ObservableObject value) { this.profileAccount = value; return this; }

    public java.time.ZonedDateTime getProfileCreated() { return this.profileCreated; }
    public ProfileFacet setProfileCreated(java.time.ZonedDateTime value) { this.profileCreated = value; return this; }

    public Identity getProfileIdentity() { return this.profileIdentity; }
    public ProfileFacet setProfileIdentity(Identity value) { this.profileIdentity = value; return this; }

    public List<String> getProfileLanguage() { return this.profileLanguage; }
    public ProfileFacet setProfileLanguage(List<String> value) { this.profileLanguage = value; return this; }

    public ObservableObject getProfileService() { return this.profileService; }
    public ProfileFacet setProfileService(ObservableObject value) { this.profileService = value; return this; }

    public ObservableObject getProfileWebsite() { return this.profileWebsite; }
    public ProfileFacet setProfileWebsite(ObservableObject value) { this.profileWebsite = value; return this; }

}