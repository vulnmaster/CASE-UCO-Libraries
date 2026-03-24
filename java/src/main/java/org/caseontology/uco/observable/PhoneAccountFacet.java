// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A phone account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of a telephony capability or service. */
public class PhoneAccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/PhoneAccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String phoneNumber;

    public PhoneAccountFacet() {
    }

    public String getPhoneNumber() { return this.phoneNumber; }
    public PhoneAccountFacet setPhoneNumber(String value) { this.phoneNumber = value; return this; }

}