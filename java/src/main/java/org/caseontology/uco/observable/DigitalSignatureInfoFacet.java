// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.core.UcoObject;
import org.caseontology.uco.identity.Identity;

/** A digital signature info facet is a grouping of characteristics unique to a value calculated via a mathematical scheme for demonstrating the authenticity of an electronic message or document. */
public class DigitalSignatureInfoFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/DigitalSignatureInfoFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Identity certificateIssuer;
    private UcoObject certificateSubject;
    private String signatureDescription;
    private Boolean signatureExists;
    private Boolean signatureVerified;

    public DigitalSignatureInfoFacet() {
    }

    public Identity getCertificateIssuer() { return this.certificateIssuer; }
    public DigitalSignatureInfoFacet setCertificateIssuer(Identity value) { this.certificateIssuer = value; return this; }

    public UcoObject getCertificateSubject() { return this.certificateSubject; }
    public DigitalSignatureInfoFacet setCertificateSubject(UcoObject value) { this.certificateSubject = value; return this; }

    public String getSignatureDescription() { return this.signatureDescription; }
    public DigitalSignatureInfoFacet setSignatureDescription(String value) { this.signatureDescription = value; return this; }

    public Boolean getSignatureExists() { return this.signatureExists; }
    public DigitalSignatureInfoFacet setSignatureExists(Boolean value) { this.signatureExists = value; return this; }

    public Boolean getSignatureVerified() { return this.signatureVerified; }
    public DigitalSignatureInfoFacet setSignatureVerified(Boolean value) { this.signatureVerified = value; return this; }

}