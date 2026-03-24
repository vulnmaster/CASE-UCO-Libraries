// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A contact list facet is a grouping of characteristics unique to a set of multiple individual contacts such as that found in a digital address book. */
public class ContactListFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactListFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<ObservableObject> contact;
    private ObservableObject sourceApplication;

    public ContactListFacet() {
        this.contact = new ArrayList<>();
    }

    public List<ObservableObject> getContact() { return this.contact; }
    public ContactListFacet setContact(List<ObservableObject> value) { this.contact = value; return this; }

    public ObservableObject getSourceApplication() { return this.sourceApplication; }
    public ContactListFacet setSourceApplication(ObservableObject value) { this.sourceApplication = value; return this; }

}