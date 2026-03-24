// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A user session facet is a grouping of characteristics unique to a temporary and interactive information interchange between two or more communicating devices within the managed scope of a single user. */
public class UserSessionFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/UserSessionFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String effectiveGroup;
    private String effectiveGroupID;
    private ObservableObject effectiveUser;
    private java.time.ZonedDateTime loginTime;
    private java.time.ZonedDateTime logoutTime;

    public UserSessionFacet() {
    }

    public String getEffectiveGroup() { return this.effectiveGroup; }
    public UserSessionFacet setEffectiveGroup(String value) { this.effectiveGroup = value; return this; }

    public String getEffectiveGroupID() { return this.effectiveGroupID; }
    public UserSessionFacet setEffectiveGroupID(String value) { this.effectiveGroupID = value; return this; }

    public ObservableObject getEffectiveUser() { return this.effectiveUser; }
    public UserSessionFacet setEffectiveUser(ObservableObject value) { this.effectiveUser = value; return this; }

    public java.time.ZonedDateTime getLoginTime() { return this.loginTime; }
    public UserSessionFacet setLoginTime(java.time.ZonedDateTime value) { this.loginTime = value; return this; }

    public java.time.ZonedDateTime getLogoutTime() { return this.logoutTime; }
    public UserSessionFacet setLogoutTime(java.time.ZonedDateTime value) { this.logoutTime = value; return this; }

}