// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A contact facet is a grouping of characteristics unique to a set of identification and communication related details for a single entity. */
public class ContactFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private java.time.ZonedDateTime birthdate;
    private List<ContactAddress> contactAddress;
    private List<ContactAffiliation> contactAffiliation;
    private List<ContactEmail> contactEmail;
    private List<String> contactGroup;
    private String contactID;
    private List<ContactMessaging> contactMessaging;
    private List<String> contactNote;
    private List<ContactPhone> contactPhone;
    private List<ContactProfile> contactProfile;
    private List<ContactSIP> contactSIP;
    private List<ContactURL> contactURL;
    private String displayName;
    private String firstName;
    private String lastName;
    private java.time.ZonedDateTime lastTimeContacted;
    private String middleName;
    private String namePhonetic;
    private String namePrefix;
    private String nameSuffix;
    private List<String> nickname;
    private Long numberTimesContacted;
    private ObservableObject sourceApplication;

    public ContactFacet() {
        this.contactAddress = new ArrayList<>();
        this.contactAffiliation = new ArrayList<>();
        this.contactEmail = new ArrayList<>();
        this.contactGroup = new ArrayList<>();
        this.contactMessaging = new ArrayList<>();
        this.contactNote = new ArrayList<>();
        this.contactPhone = new ArrayList<>();
        this.contactProfile = new ArrayList<>();
        this.contactSIP = new ArrayList<>();
        this.contactURL = new ArrayList<>();
        this.nickname = new ArrayList<>();
    }

    public java.time.ZonedDateTime getBirthdate() { return this.birthdate; }
    public ContactFacet setBirthdate(java.time.ZonedDateTime value) { this.birthdate = value; return this; }

    public List<ContactAddress> getContactAddress() { return this.contactAddress; }
    public ContactFacet setContactAddress(List<ContactAddress> value) { this.contactAddress = value; return this; }

    public List<ContactAffiliation> getContactAffiliation() { return this.contactAffiliation; }
    public ContactFacet setContactAffiliation(List<ContactAffiliation> value) { this.contactAffiliation = value; return this; }

    public List<ContactEmail> getContactEmail() { return this.contactEmail; }
    public ContactFacet setContactEmail(List<ContactEmail> value) { this.contactEmail = value; return this; }

    public List<String> getContactGroup() { return this.contactGroup; }
    public ContactFacet setContactGroup(List<String> value) { this.contactGroup = value; return this; }

    public String getContactID() { return this.contactID; }
    public ContactFacet setContactID(String value) { this.contactID = value; return this; }

    public List<ContactMessaging> getContactMessaging() { return this.contactMessaging; }
    public ContactFacet setContactMessaging(List<ContactMessaging> value) { this.contactMessaging = value; return this; }

    public List<String> getContactNote() { return this.contactNote; }
    public ContactFacet setContactNote(List<String> value) { this.contactNote = value; return this; }

    public List<ContactPhone> getContactPhone() { return this.contactPhone; }
    public ContactFacet setContactPhone(List<ContactPhone> value) { this.contactPhone = value; return this; }

    public List<ContactProfile> getContactProfile() { return this.contactProfile; }
    public ContactFacet setContactProfile(List<ContactProfile> value) { this.contactProfile = value; return this; }

    public List<ContactSIP> getContactSIP() { return this.contactSIP; }
    public ContactFacet setContactSIP(List<ContactSIP> value) { this.contactSIP = value; return this; }

    public List<ContactURL> getContactURL() { return this.contactURL; }
    public ContactFacet setContactURL(List<ContactURL> value) { this.contactURL = value; return this; }

    public String getDisplayName() { return this.displayName; }
    public ContactFacet setDisplayName(String value) { this.displayName = value; return this; }

    public String getFirstName() { return this.firstName; }
    public ContactFacet setFirstName(String value) { this.firstName = value; return this; }

    public String getLastName() { return this.lastName; }
    public ContactFacet setLastName(String value) { this.lastName = value; return this; }

    public java.time.ZonedDateTime getLastTimeContacted() { return this.lastTimeContacted; }
    public ContactFacet setLastTimeContacted(java.time.ZonedDateTime value) { this.lastTimeContacted = value; return this; }

    public String getMiddleName() { return this.middleName; }
    public ContactFacet setMiddleName(String value) { this.middleName = value; return this; }

    public String getNamePhonetic() { return this.namePhonetic; }
    public ContactFacet setNamePhonetic(String value) { this.namePhonetic = value; return this; }

    public String getNamePrefix() { return this.namePrefix; }
    public ContactFacet setNamePrefix(String value) { this.namePrefix = value; return this; }

    public String getNameSuffix() { return this.nameSuffix; }
    public ContactFacet setNameSuffix(String value) { this.nameSuffix = value; return this; }

    public List<String> getNickname() { return this.nickname; }
    public ContactFacet setNickname(List<String> value) { this.nickname = value; return this; }

    public Long getNumberTimesContacted() { return this.numberTimesContacted; }
    public ContactFacet setNumberTimesContacted(Long value) { this.numberTimesContacted = value; return this; }

    public ObservableObject getSourceApplication() { return this.sourceApplication; }
    public ContactFacet setSourceApplication(ObservableObject value) { this.sourceApplication = value; return this; }

}