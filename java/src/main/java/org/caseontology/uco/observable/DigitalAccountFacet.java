// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A digital account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of some capability or service within the digital domain. */
public class DigitalAccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalAccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> accountLogin;
    private String displayName;
    private java.time.ZonedDateTime firstLoginTime;
    private Boolean isDisabled;
    private java.time.ZonedDateTime lastLoginTime;

    public DigitalAccountFacet() {
        this.accountLogin = new ArrayList<>();
    }

    public List<String> getAccountLogin() { return this.accountLogin; }
    public DigitalAccountFacet setAccountLogin(List<String> value) { this.accountLogin = value; return this; }

    public String getDisplayName() { return this.displayName; }
    public DigitalAccountFacet setDisplayName(String value) { this.displayName = value; return this; }

    public java.time.ZonedDateTime getFirstLoginTime() { return this.firstLoginTime; }
    public DigitalAccountFacet setFirstLoginTime(java.time.ZonedDateTime value) { this.firstLoginTime = value; return this; }

    public Boolean getIsDisabled() { return this.isDisabled; }
    public DigitalAccountFacet setIsDisabled(Boolean value) { this.isDisabled = value; return this; }

    public java.time.ZonedDateTime getLastLoginTime() { return this.lastLoginTime; }
    public DigitalAccountFacet setLastLoginTime(java.time.ZonedDateTime value) { this.lastLoginTime = value; return this; }

}