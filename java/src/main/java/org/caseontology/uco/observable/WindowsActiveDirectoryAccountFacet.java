// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A Windows Active Directory account facet is a grouping of characteristics unique to an account managed by directory-based identity-related services of a Windows operating system. */
public class WindowsActiveDirectoryAccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsActiveDirectoryAccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> activeDirectoryGroups;
    private String objectGUID;

    public WindowsActiveDirectoryAccountFacet() {
        this.activeDirectoryGroups = new ArrayList<>();
    }

    public List<String> getActiveDirectoryGroups() { return this.activeDirectoryGroups; }
    public WindowsActiveDirectoryAccountFacet setActiveDirectoryGroups(List<String> value) { this.activeDirectoryGroups = value; return this; }

    public String getObjectGUID() { return this.objectGUID; }
    public WindowsActiveDirectoryAccountFacet setObjectGUID(String value) { this.objectGUID = value; return this; }

}