// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An encrypted stream facet is a grouping of characteristics unique to the conversion of a body of data content from one form to another obfuscated form in such a way that reversing the conversion to ob */
public class EncryptedStreamFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/EncryptedStreamFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> encryptionIV;
    private List<String> encryptionKey;
    private String encryptionMethod;
    private String encryptionMode;

    public EncryptedStreamFacet() {
        this.encryptionIV = new ArrayList<>();
        this.encryptionKey = new ArrayList<>();
    }

    public List<String> getEncryptionIV() { return this.encryptionIV; }
    public EncryptedStreamFacet setEncryptionIV(List<String> value) { this.encryptionIV = value; return this; }

    public List<String> getEncryptionKey() { return this.encryptionKey; }
    public EncryptedStreamFacet setEncryptionKey(List<String> value) { this.encryptionKey = value; return this; }

    public String getEncryptionMethod() { return this.encryptionMethod; }
    public EncryptedStreamFacet setEncryptionMethod(String value) { this.encryptionMethod = value; return this; }

    public String getEncryptionMode() { return this.encryptionMode; }
    public EncryptedStreamFacet setEncryptionMode(String value) { this.encryptionMode = value; return this; }

}