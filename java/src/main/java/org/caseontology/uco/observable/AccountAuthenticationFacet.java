// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An account authentication facet is a grouping of characteristics unique to the mechanism of accessing an account. */
public class AccountAuthenticationFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/AccountAuthenticationFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String password;
    private java.time.ZonedDateTime passwordLastChanged;
    private String passwordType;

    public AccountAuthenticationFacet() {
    }

    public String getPassword() { return this.password; }
    public AccountAuthenticationFacet setPassword(String value) { this.password = value; return this; }

    public java.time.ZonedDateTime getPasswordLastChanged() { return this.passwordLastChanged; }
    public AccountAuthenticationFacet setPasswordLastChanged(java.time.ZonedDateTime value) { this.passwordLastChanged = value; return this; }

    public String getPasswordType() { return this.passwordType; }
    public AccountAuthenticationFacet setPasswordType(String value) { this.passwordType = value; return this; }

}