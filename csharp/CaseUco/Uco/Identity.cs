// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-identity

using System;
using System.Collections.Generic;

namespace CaseUco.Uco.Identity
{
    /// <summary>An address facet is a grouping of characteristics unique to an administrative identifier for a geolocation associated with a specific identity.</summary>
    public class AddressFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/AddressFacet";
        public const string NamespacePrefix = "uco-identity";
        public Location? Address { get; set; }
    }

    /// <summary>An affiliation is a grouping of characteristics unique to the established affiliations of an entity.</summary>
    public class AffiliationFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/AffiliationFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Birth information is a grouping of characteristics unique to information pertaining to the birth of an entity.</summary>
    public class BirthInformationFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/BirthInformationFacet";
        public const string NamespacePrefix = "uco-identity";
        public DateTime? Birthdate { get; set; }
    }

    /// <summary>Country of residence is a grouping of characteristics unique to information related to the country, or countries, where an entity resides.</summary>
    public class CountryOfResidenceFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/CountryOfResidenceFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Events is a grouping of characteristics unique to information related to specific relevant things that happen in the lifetime of an entity.</summary>
    public class EventsFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/EventsFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Identifier is a grouping of characteristics unique to information that uniquely and specifically identities an entity.</summary>
    public class IdentifierFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/IdentifierFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>An identity is a grouping of identifying characteristics unique to an individual or organization.</summary>
    public class Identity : IdentityAbstraction
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/Identity";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>An identity facet is a grouping of characteristics unique to a particular aspect of an identity.</summary>
    public class IdentityFacet : Facet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/IdentityFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Languages is a grouping of characteristics unique to specific syntactically and grammatically standardized forms of communication (human or computer) in which an entity has proficiency (comprehends, s</summary>
    public class LanguagesFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/LanguagesFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Nationality is a grouping of characteristics unique to the condition of an entity belonging to a particular nation.</summary>
    public class NationalityFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/NationalityFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Occupation is a grouping of characteristics unique to the job or profession of an entity.</summary>
    public class OccupationFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/OccupationFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>An organization is a grouping of identifying characteristics unique to a group of people who work together in an organized way for a shared purpose. [based on https://dictionary.cambridge.org/us/dicti</summary>
    public class Organization : Identity
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/Organization";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Organization details is a grouping of characteristics unique to an identity representing an administrative and functional structure.</summary>
    public class OrganizationDetailsFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/OrganizationDetailsFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>A person is a grouping of identifying characteristics unique to a human being regarded as an individual. [based on https://www.lexico.com/en/definition/person]</summary>
    public class Person : Identity
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/Person";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Personal details is a grouping of characteristics unique to an identity representing an individual person.</summary>
    public class PersonalDetailsFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/PersonalDetailsFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Physical info is a grouping of characteristics unique to the outwardly observable nature of an individual person.</summary>
    public class PhysicalInfoFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/PhysicalInfoFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>Qualification is a grouping of characteristics unique to particular skills, capabilities or their related achievements (educational, professional, etc.) of an entity.</summary>
    public class QualificationFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/QualificationFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary><Needs fleshed out from CIQ></summary>
    public class RelatedIdentityFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/RelatedIdentityFacet";
        public const string NamespacePrefix = "uco-identity";
    }

    /// <summary>A simple name facet is a grouping of characteristics unique to the personal name (e.g., Dr. John Smith Jr.) held by an identity.</summary>
    public class SimpleNameFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/SimpleNameFacet";
        public const string NamespacePrefix = "uco-identity";
        public List<string> FamilyName { get; set; }
        public List<string> GivenName { get; set; }
        public List<string> HonorificPrefix { get; set; }
        public List<string> HonorificSuffix { get; set; }
    }

    /// <summary>Visa is a grouping of characteristics unique to information related to a person's ability to enter, leave, or stay for a specified period of time in a country.</summary>
    public class VisaFacet : IdentityFacet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/identity/VisaFacet";
        public const string NamespacePrefix = "uco-identity";
    }

}