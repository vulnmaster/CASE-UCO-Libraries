// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A digital address facet is a grouping of characteristics unique to an identifier assigned to enable routing and management of digital communication. */
public class DigitalAddressFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalAddressFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String addressValue;
    private String displayName;

    public DigitalAddressFacet() {
    }

    public String getAddressValue() { return this.addressValue; }
    public DigitalAddressFacet setAddressValue(String value) { this.addressValue = value; return this; }

    public String getDisplayName() { return this.displayName; }
    public DigitalAddressFacet setDisplayName(String value) { this.displayName = value; return this; }

}