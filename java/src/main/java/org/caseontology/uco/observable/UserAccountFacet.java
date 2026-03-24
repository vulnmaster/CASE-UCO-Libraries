// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A user account facet is a grouping of characteristics unique to an account controlling a user's access to a network, system, or platform. */
public class UserAccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/UserAccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Boolean canEscalatePrivs;
    private String homeDirectory;
    private Boolean isPrivileged;
    private Boolean isServiceAccount;

    public UserAccountFacet() {
    }

    public Boolean getCanEscalatePrivs() { return this.canEscalatePrivs; }
    public UserAccountFacet setCanEscalatePrivs(Boolean value) { this.canEscalatePrivs = value; return this; }

    public String getHomeDirectory() { return this.homeDirectory; }
    public UserAccountFacet setHomeDirectory(String value) { this.homeDirectory = value; return this; }

    public Boolean getIsPrivileged() { return this.isPrivileged; }
    public UserAccountFacet setIsPrivileged(Boolean value) { this.isPrivileged = value; return this; }

    public Boolean getIsServiceAccount() { return this.isServiceAccount; }
    public UserAccountFacet setIsServiceAccount(Boolean value) { this.isServiceAccount = value; return this; }

}