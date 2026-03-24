// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A domain name facet is a grouping of characteristics unique to an identification string that defines a realm of administrative autonomy, authority or control within the Internet. [based on https://en. */
public class DomainNameFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/DomainNameFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Boolean isTLD;
    private String value;

    public DomainNameFacet() {
    }

    public Boolean getIsTLD() { return this.isTLD; }
    public DomainNameFacet setIsTLD(Boolean value) { this.isTLD = value; return this; }

    public String getValue() { return this.value; }
    public DomainNameFacet setValue(String value) { this.value = value; return this; }

}