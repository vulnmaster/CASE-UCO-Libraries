// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A SIM card facet is a grouping of characteristics unique to a subscriber identification module card intended to securely store the international mobile subscriber identity (IMSI) number and its relate */
public class SIMCardFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/SIMCardFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String iCCID;
    private String iMSI;
    private String pIN;
    private String pUK;
    private String sIMForm;
    private String sIMType;
    private Identity carrier;
    private Long storageCapacityInBytes;

    public SIMCardFacet() {
    }

    public String getICCID() { return this.iCCID; }
    public SIMCardFacet setICCID(String value) { this.iCCID = value; return this; }

    public String getIMSI() { return this.iMSI; }
    public SIMCardFacet setIMSI(String value) { this.iMSI = value; return this; }

    public String getPIN() { return this.pIN; }
    public SIMCardFacet setPIN(String value) { this.pIN = value; return this; }

    public String getPUK() { return this.pUK; }
    public SIMCardFacet setPUK(String value) { this.pUK = value; return this; }

    public String getSIMForm() { return this.sIMForm; }
    public SIMCardFacet setSIMForm(String value) { this.sIMForm = value; return this; }

    public String getSIMType() { return this.sIMType; }
    public SIMCardFacet setSIMType(String value) { this.sIMType = value; return this; }

    public Identity getCarrier() { return this.carrier; }
    public SIMCardFacet setCarrier(Identity value) { this.carrier = value; return this; }

    public Long getStorageCapacityInBytes() { return this.storageCapacityInBytes; }
    public SIMCardFacet setStorageCapacityInBytes(Long value) { this.storageCapacityInBytes = value; return this; }

}