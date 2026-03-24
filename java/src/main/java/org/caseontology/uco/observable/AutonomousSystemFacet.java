// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An autonomous system facet is a grouping of characteristics unique to a collection of connected Internet Protocol (IP) routing prefixes under the control of one or more network operators on behalf of  */
public class AutonomousSystemFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/AutonomousSystemFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String asHandle;
    private Long number;
    private List<String> regionalInternetRegistry;

    public AutonomousSystemFacet() {
        this.regionalInternetRegistry = new ArrayList<>();
    }

    public String getAsHandle() { return this.asHandle; }
    public AutonomousSystemFacet setAsHandle(String value) { this.asHandle = value; return this; }

    public Long getNumber() { return this.number; }
    public AutonomousSystemFacet setNumber(Long value) { this.number = value; return this; }

    public List<String> getRegionalInternetRegistry() { return this.regionalInternetRegistry; }
    public AutonomousSystemFacet setRegionalInternetRegistry(List<String> value) { this.regionalInternetRegistry = value; return this; }

}