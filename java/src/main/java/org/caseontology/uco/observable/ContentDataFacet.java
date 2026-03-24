// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A content data facet is a grouping of characteristics unique to a block of digital data. */
public class ContentDataFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContentDataFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> byteOrder;
    private String dataPayload;
    private ObservableObject dataPayloadReferenceURL;
    private java.math.BigDecimal entropy;
    private List<Hash> hash;
    private Boolean isEncrypted;
    private String magicNumber;
    private String mimeClass;
    private List<String> mimeType;
    private Long sizeInBytes;

    public ContentDataFacet() {
        this.byteOrder = new ArrayList<>();
        this.hash = new ArrayList<>();
        this.mimeType = new ArrayList<>();
    }

    public List<String> getByteOrder() { return this.byteOrder; }
    public ContentDataFacet setByteOrder(List<String> value) { this.byteOrder = value; return this; }

    public String getDataPayload() { return this.dataPayload; }
    public ContentDataFacet setDataPayload(String value) { this.dataPayload = value; return this; }

    public ObservableObject getDataPayloadReferenceURL() { return this.dataPayloadReferenceURL; }
    public ContentDataFacet setDataPayloadReferenceURL(ObservableObject value) { this.dataPayloadReferenceURL = value; return this; }

    public java.math.BigDecimal getEntropy() { return this.entropy; }
    public ContentDataFacet setEntropy(java.math.BigDecimal value) { this.entropy = value; return this; }

    public List<Hash> getHash() { return this.hash; }
    public ContentDataFacet setHash(List<Hash> value) { this.hash = value; return this; }

    public Boolean getIsEncrypted() { return this.isEncrypted; }
    public ContentDataFacet setIsEncrypted(Boolean value) { this.isEncrypted = value; return this; }

    public String getMagicNumber() { return this.magicNumber; }
    public ContentDataFacet setMagicNumber(String value) { this.magicNumber = value; return this; }

    public String getMimeClass() { return this.mimeClass; }
    public ContentDataFacet setMimeClass(String value) { this.mimeClass = value; return this; }

    public List<String> getMimeType() { return this.mimeType; }
    public ContentDataFacet setMimeType(List<String> value) { this.mimeType = value; return this; }

    public Long getSizeInBytes() { return this.sizeInBytes; }
    public ContentDataFacet setSizeInBytes(Long value) { this.sizeInBytes = value; return this; }

}