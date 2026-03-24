// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An X.509 v3 certificate extensions facet is a grouping of characteristics unique to a public key digital identity certificate conformant to the X.509 v3 PKI (Public Key Infrastructure) standard. */
public class X509V3ExtensionsFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/X509V3ExtensionsFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String authorityKeyIdentifier;
    private String basicConstraints;
    private String certificatePolicies;
    private String crlDistributionPoints;
    private String extendedKeyUsage;
    private String inhibitAnyPolicy;
    private String issuerAlternativeName;
    private String keyUsage;
    private String nameConstraints;
    private String policyConstraints;
    private String policyMappings;
    private java.time.ZonedDateTime privateKeyUsagePeriodNotAfter;
    private java.time.ZonedDateTime privateKeyUsagePeriodNotBefore;
    private String subjectAlternativeName;
    private String subjectDirectoryAttributes;
    private String subjectKeyIdentifier;

    public X509V3ExtensionsFacet() {
    }

    public String getAuthorityKeyIdentifier() { return this.authorityKeyIdentifier; }
    public X509V3ExtensionsFacet setAuthorityKeyIdentifier(String value) { this.authorityKeyIdentifier = value; return this; }

    public String getBasicConstraints() { return this.basicConstraints; }
    public X509V3ExtensionsFacet setBasicConstraints(String value) { this.basicConstraints = value; return this; }

    public String getCertificatePolicies() { return this.certificatePolicies; }
    public X509V3ExtensionsFacet setCertificatePolicies(String value) { this.certificatePolicies = value; return this; }

    public String getCrlDistributionPoints() { return this.crlDistributionPoints; }
    public X509V3ExtensionsFacet setCrlDistributionPoints(String value) { this.crlDistributionPoints = value; return this; }

    public String getExtendedKeyUsage() { return this.extendedKeyUsage; }
    public X509V3ExtensionsFacet setExtendedKeyUsage(String value) { this.extendedKeyUsage = value; return this; }

    public String getInhibitAnyPolicy() { return this.inhibitAnyPolicy; }
    public X509V3ExtensionsFacet setInhibitAnyPolicy(String value) { this.inhibitAnyPolicy = value; return this; }

    public String getIssuerAlternativeName() { return this.issuerAlternativeName; }
    public X509V3ExtensionsFacet setIssuerAlternativeName(String value) { this.issuerAlternativeName = value; return this; }

    public String getKeyUsage() { return this.keyUsage; }
    public X509V3ExtensionsFacet setKeyUsage(String value) { this.keyUsage = value; return this; }

    public String getNameConstraints() { return this.nameConstraints; }
    public X509V3ExtensionsFacet setNameConstraints(String value) { this.nameConstraints = value; return this; }

    public String getPolicyConstraints() { return this.policyConstraints; }
    public X509V3ExtensionsFacet setPolicyConstraints(String value) { this.policyConstraints = value; return this; }

    public String getPolicyMappings() { return this.policyMappings; }
    public X509V3ExtensionsFacet setPolicyMappings(String value) { this.policyMappings = value; return this; }

    public java.time.ZonedDateTime getPrivateKeyUsagePeriodNotAfter() { return this.privateKeyUsagePeriodNotAfter; }
    public X509V3ExtensionsFacet setPrivateKeyUsagePeriodNotAfter(java.time.ZonedDateTime value) { this.privateKeyUsagePeriodNotAfter = value; return this; }

    public java.time.ZonedDateTime getPrivateKeyUsagePeriodNotBefore() { return this.privateKeyUsagePeriodNotBefore; }
    public X509V3ExtensionsFacet setPrivateKeyUsagePeriodNotBefore(java.time.ZonedDateTime value) { this.privateKeyUsagePeriodNotBefore = value; return this; }

    public String getSubjectAlternativeName() { return this.subjectAlternativeName; }
    public X509V3ExtensionsFacet setSubjectAlternativeName(String value) { this.subjectAlternativeName = value; return this; }

    public String getSubjectDirectoryAttributes() { return this.subjectDirectoryAttributes; }
    public X509V3ExtensionsFacet setSubjectDirectoryAttributes(String value) { this.subjectDirectoryAttributes = value; return this; }

    public String getSubjectKeyIdentifier() { return this.subjectKeyIdentifier; }
    public X509V3ExtensionsFacet setSubjectKeyIdentifier(String value) { this.subjectKeyIdentifier = value; return this; }

}