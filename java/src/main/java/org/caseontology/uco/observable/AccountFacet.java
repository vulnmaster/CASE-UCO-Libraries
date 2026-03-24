// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.core.UcoObject;

/** An account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of some capability or service. */
public class AccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/AccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String accountIdentifier;
    private UcoObject accountIssuer;
    private List<String> accountType;
    private java.time.ZonedDateTime expirationTime;
    private Boolean isActive;
    private java.time.ZonedDateTime modifiedTime;
    private java.time.ZonedDateTime observableCreatedTime;
    private UcoObject owner;

    public AccountFacet() {
        this.accountType = new ArrayList<>();
    }

    public String getAccountIdentifier() { return this.accountIdentifier; }
    public AccountFacet setAccountIdentifier(String value) { this.accountIdentifier = value; return this; }

    public UcoObject getAccountIssuer() { return this.accountIssuer; }
    public AccountFacet setAccountIssuer(UcoObject value) { this.accountIssuer = value; return this; }

    public List<String> getAccountType() { return this.accountType; }
    public AccountFacet setAccountType(List<String> value) { this.accountType = value; return this; }

    public java.time.ZonedDateTime getExpirationTime() { return this.expirationTime; }
    public AccountFacet setExpirationTime(java.time.ZonedDateTime value) { this.expirationTime = value; return this; }

    public Boolean getIsActive() { return this.isActive; }
    public AccountFacet setIsActive(Boolean value) { this.isActive = value; return this; }

    public java.time.ZonedDateTime getModifiedTime() { return this.modifiedTime; }
    public AccountFacet setModifiedTime(java.time.ZonedDateTime value) { this.modifiedTime = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public AccountFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

    public UcoObject getOwner() { return this.owner; }
    public AccountFacet setOwner(UcoObject value) { this.owner = value; return this; }

}