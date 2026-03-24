// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A Whois contact type is a grouping of characteristics unique to contact-related information present in a response record conformant to the WHOIS protocol standard (RFC 3912). [based on https://en.wiki */
public class WhoisContactFacet extends ContactFacet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WhoisContactFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> whoisContactType;

    public WhoisContactFacet() {
        this.whoisContactType = new ArrayList<>();
    }

    public List<String> getWhoisContactType() { return this.whoisContactType; }
    public WhoisContactFacet setWhoisContactType(List<String> value) { this.whoisContactType = value; return this; }

}