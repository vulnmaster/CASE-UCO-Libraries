// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A mobile account facet is a grouping of characteristics unique to an arrangement with an entity to enable and control the provision of some capability or service on a portable computing device. [based */
public class MobileAccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/MobileAccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String iMSI;
    private String mSISDN;
    private String mSISDNType;

    public MobileAccountFacet() {
    }

    public String getIMSI() { return this.iMSI; }
    public MobileAccountFacet setIMSI(String value) { this.iMSI = value; return this; }

    public String getMSISDN() { return this.mSISDN; }
    public MobileAccountFacet setMSISDN(String value) { this.mSISDN = value; return this; }

    public String getMSISDNType() { return this.mSISDNType; }
    public MobileAccountFacet setMSISDNType(String value) { this.mSISDNType = value; return this; }

}