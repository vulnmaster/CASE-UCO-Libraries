// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A SMS message facet is a grouping of characteristics unique to a message conformant to the short message service (SMS) communication protocol standards. */
public class SMSMessageFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/SMSMessageFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Boolean isRead;

    public SMSMessageFacet() {
    }

    public Boolean getIsRead() { return this.isRead; }
    public SMSMessageFacet setIsRead(Boolean value) { this.isRead = value; return this; }

}