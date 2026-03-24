// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;
import org.caseontology.uco.identity.Organization;

/** A contact affiliation is a grouping of characteristics unique to details of an organizational affiliation for a single contact entity. */
public class ContactAffiliation extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactAffiliation";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<ContactEmail> contactEmail;
    private List<ContactMessaging> contactMessaging;
    private Organization contactOrganization;
    private List<ContactPhone> contactPhone;
    private List<ContactProfile> contactProfile;
    private List<ContactURL> contactURL;
    private String organizationDepartment;
    private List<ContactAddress> organizationLocation;
    private String organizationPosition;

    public ContactAffiliation() {
        this.contactEmail = new ArrayList<>();
        this.contactMessaging = new ArrayList<>();
        this.contactPhone = new ArrayList<>();
        this.contactProfile = new ArrayList<>();
        this.contactURL = new ArrayList<>();
        this.organizationLocation = new ArrayList<>();
    }

    public List<ContactEmail> getContactEmail() { return this.contactEmail; }
    public ContactAffiliation setContactEmail(List<ContactEmail> value) { this.contactEmail = value; return this; }

    public List<ContactMessaging> getContactMessaging() { return this.contactMessaging; }
    public ContactAffiliation setContactMessaging(List<ContactMessaging> value) { this.contactMessaging = value; return this; }

    public Organization getContactOrganization() { return this.contactOrganization; }
    public ContactAffiliation setContactOrganization(Organization value) { this.contactOrganization = value; return this; }

    public List<ContactPhone> getContactPhone() { return this.contactPhone; }
    public ContactAffiliation setContactPhone(List<ContactPhone> value) { this.contactPhone = value; return this; }

    public List<ContactProfile> getContactProfile() { return this.contactProfile; }
    public ContactAffiliation setContactProfile(List<ContactProfile> value) { this.contactProfile = value; return this; }

    public List<ContactURL> getContactURL() { return this.contactURL; }
    public ContactAffiliation setContactURL(List<ContactURL> value) { this.contactURL = value; return this; }

    public String getOrganizationDepartment() { return this.organizationDepartment; }
    public ContactAffiliation setOrganizationDepartment(String value) { this.organizationDepartment = value; return this; }

    public List<ContactAddress> getOrganizationLocation() { return this.organizationLocation; }
    public ContactAffiliation setOrganizationLocation(List<ContactAddress> value) { this.organizationLocation = value; return this; }

    public String getOrganizationPosition() { return this.organizationPosition; }
    public ContactAffiliation setOrganizationPosition(String value) { this.organizationPosition = value; return this; }

}