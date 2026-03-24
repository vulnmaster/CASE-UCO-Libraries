// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** An email account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of electronic mail (email) capabilities or services. */
public class EmailAccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/EmailAccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject emailAddress;

    public EmailAccountFacet() {
    }

    public ObservableObject getEmailAddress() { return this.emailAddress; }
    public EmailAccountFacet setEmailAddress(ObservableObject value) { this.emailAddress = value; return this; }

}