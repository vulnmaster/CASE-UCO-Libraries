// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A Windows account facet is a grouping of characteristics unique to a user account on a Windows operating system. */
public class WindowsAccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsAccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> groups;

    public WindowsAccountFacet() {
        this.groups = new ArrayList<>();
    }

    public List<String> getGroups() { return this.groups; }
    public WindowsAccountFacet setGroups(List<String> value) { this.groups = value; return this; }

}