// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.types.Hash;

/** A X.509 certificate facet is a grouping of characteristics unique to a public key digital identity certificate conformant to the X.509 PKI (Public Key Infrastructure) standard.  */
public class X509CertificateFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/X509CertificateFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Boolean isSelfSigned;
    private String issuer;
    private Hash issuerHash;
    private String serialNumber;
    private String signature;
    private String signatureAlgorithm;
    private String subject;
    private Hash subjectHash;
    private String subjectPublicKeyAlgorithm;
    private Long subjectPublicKeyExponent;
    private String subjectPublicKeyModulus;
    private Hash thumbprintHash;
    private java.time.ZonedDateTime validityNotAfter;
    private java.time.ZonedDateTime validityNotBefore;
    private String version;
    private X509V3ExtensionsFacet x509v3extensions;

    public X509CertificateFacet() {
    }

    public Boolean getIsSelfSigned() { return this.isSelfSigned; }
    public X509CertificateFacet setIsSelfSigned(Boolean value) { this.isSelfSigned = value; return this; }

    public String getIssuer() { return this.issuer; }
    public X509CertificateFacet setIssuer(String value) { this.issuer = value; return this; }

    public Hash getIssuerHash() { return this.issuerHash; }
    public X509CertificateFacet setIssuerHash(Hash value) { this.issuerHash = value; return this; }

    public String getSerialNumber() { return this.serialNumber; }
    public X509CertificateFacet setSerialNumber(String value) { this.serialNumber = value; return this; }

    public String getSignature() { return this.signature; }
    public X509CertificateFacet setSignature(String value) { this.signature = value; return this; }

    public String getSignatureAlgorithm() { return this.signatureAlgorithm; }
    public X509CertificateFacet setSignatureAlgorithm(String value) { this.signatureAlgorithm = value; return this; }

    public String getSubject() { return this.subject; }
    public X509CertificateFacet setSubject(String value) { this.subject = value; return this; }

    public Hash getSubjectHash() { return this.subjectHash; }
    public X509CertificateFacet setSubjectHash(Hash value) { this.subjectHash = value; return this; }

    public String getSubjectPublicKeyAlgorithm() { return this.subjectPublicKeyAlgorithm; }
    public X509CertificateFacet setSubjectPublicKeyAlgorithm(String value) { this.subjectPublicKeyAlgorithm = value; return this; }

    public Long getSubjectPublicKeyExponent() { return this.subjectPublicKeyExponent; }
    public X509CertificateFacet setSubjectPublicKeyExponent(Long value) { this.subjectPublicKeyExponent = value; return this; }

    public String getSubjectPublicKeyModulus() { return this.subjectPublicKeyModulus; }
    public X509CertificateFacet setSubjectPublicKeyModulus(String value) { this.subjectPublicKeyModulus = value; return this; }

    public Hash getThumbprintHash() { return this.thumbprintHash; }
    public X509CertificateFacet setThumbprintHash(Hash value) { this.thumbprintHash = value; return this; }

    public java.time.ZonedDateTime getValidityNotAfter() { return this.validityNotAfter; }
    public X509CertificateFacet setValidityNotAfter(java.time.ZonedDateTime value) { this.validityNotAfter = value; return this; }

    public java.time.ZonedDateTime getValidityNotBefore() { return this.validityNotBefore; }
    public X509CertificateFacet setValidityNotBefore(java.time.ZonedDateTime value) { this.validityNotBefore = value; return this; }

    public String getVersion() { return this.version; }
    public X509CertificateFacet setVersion(String value) { this.version = value; return this; }

    public X509V3ExtensionsFacet getX509v3extensions() { return this.x509v3extensions; }
    public X509CertificateFacet setX509v3extensions(X509V3ExtensionsFacet value) { this.x509v3extensions = value; return this; }

}