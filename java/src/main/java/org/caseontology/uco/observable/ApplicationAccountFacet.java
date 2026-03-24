// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An application account facet is a grouping of characteristics unique to an account within a particular software program designed for end users. */
public class ApplicationAccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ApplicationAccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;

    public ApplicationAccountFacet() {
    }

    public ObservableObject getApplication() { return this.application; }
    public ApplicationAccountFacet setApplication(ObservableObject value) { this.application = value; return this; }

}