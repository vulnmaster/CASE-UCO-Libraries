// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-core

using System;
using System.Collections.Generic;

namespace CaseUco.Uco.Core
{
    /// <summary>An annotation is an assertion made in relation to one or more objects.</summary>
    public class Annotation : Assertion
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/Annotation";
        public const string NamespacePrefix = "uco-core";
        public List<UcoObject> Object { get; set; }
    }

    /// <summary>An assertion is a statement declared to be true.</summary>
    public class Assertion : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/Assertion";
        public const string NamespacePrefix = "uco-core";
        public List<string> Statement { get; set; }
    }

    /// <summary>An attributed name is a name of an entity issued by some attributed naming authority.</summary>
    public class AttributedName : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/AttributedName";
        public const string NamespacePrefix = "uco-core";
        public string? NamingAuthority { get; set; }
    }

    /// <summary>A bundle is a container for a grouping of UCO content with no presumption of shared context.</summary>
    public class Bundle : EnclosingCompilation
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/Bundle";
        public const string NamespacePrefix = "uco-core";
    }

    /// <summary>A compilation is a grouping of things.</summary>
    public class Compilation : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/Compilation";
        public const string NamespacePrefix = "uco-core";
    }

    /// <summary>A confidence is a grouping of characteristics unique to an asserted level of certainty in the accuracy of some information.</summary>
    public class ConfidenceFacet : Facet
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/ConfidenceFacet";
        public const string NamespacePrefix = "uco-core";
        public ulong Confidence { get; set; }
    }

    /// <summary>A contextual compilation is a grouping of things sharing some context (e.g., a set of network connections observed on a given day, all accounts associated with a given person).</summary>
    public class ContextualCompilation : Compilation
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/ContextualCompilation";
        public const string NamespacePrefix = "uco-core";
        public List<UcoObject> Object { get; set; }
    }

    /// <summary>A controlled vocabulary is an explicitly constrained set of string values.</summary>
    public class ControlledVocabulary : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/ControlledVocabulary";
        public const string NamespacePrefix = "uco-core";
        public string? ConstrainingVocabularyName { get; set; }
        public Uri? ConstrainingVocabularyReference { get; set; }
        public string Value { get; set; }
    }

    /// <summary>An enclosing compilation is a container for a grouping of things.</summary>
    public class EnclosingCompilation : Compilation
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/EnclosingCompilation";
        public const string NamespacePrefix = "uco-core";
        public List<UcoObject> Object { get; set; }
    }

    /// <summary>An Event is a noteworthy occurrence (something that happens or might happen).</summary>
    public class Event : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/Event";
        public const string NamespacePrefix = "uco-core";
        public List<DateTime> EndTime { get; set; }
        public List<Dictionary> EventAttribute { get; set; }
        public List<UcoObject> EventContext { get; set; }
        public List<string> EventType { get; set; }
        public List<DateTime> StartTime { get; set; }
    }

    /// <summary>Characteristics of a reference to a resource outside of the UCO.</summary>
    public class ExternalReference : UcoInherentCharacterizationThing
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/ExternalReference";
        public const string NamespacePrefix = "uco-core";
        public string? DefiningContext { get; set; }
        public string? ExternalIdentifier { get; set; }
        public Uri? ReferenceURL { get; set; }
    }

    /// <summary>A facet is a grouping of characteristics singularly unique to a particular inherent aspect of a UCO domain object.</summary>
    public class Facet : UcoInherentCharacterizationThing
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/Facet";
        public const string NamespacePrefix = "uco-core";
    }

    /// <summary>A grouping is a compilation of referenced UCO content with a shared context.</summary>
    public class Grouping : ContextualCompilation
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/Grouping";
        public const string NamespacePrefix = "uco-core";
        public List<string> Context { get; set; }
    }

    /// <summary>An identity abstraction is a grouping of identifying characteristics unique to an individual or organization. This class is an ontological structural abstraction for this concept. Implementations of t</summary>
    public class IdentityAbstraction : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/IdentityAbstraction";
        public const string NamespacePrefix = "uco-core";
    }

    /// <summary>An item is a distinct article or unit.</summary>
    public class Item : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/Item";
        public const string NamespacePrefix = "uco-core";
    }

    /// <summary>A marking definition abstraction is a grouping of characteristics unique to the expression of a specific data marking conveying restrictions, permissions, and other guidance for how marked data can be</summary>
    public class MarkingDefinitionAbstraction : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/MarkingDefinitionAbstraction";
        public const string NamespacePrefix = "uco-core";
    }

    /// <summary>A modus operandi is a particular method of operation (how a particular entity behaves or the resources they use).</summary>
    public class ModusOperandi : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/ModusOperandi";
        public const string NamespacePrefix = "uco-core";
    }

    /// <summary>A relationship is a grouping of characteristics unique to an assertion that one or more objects are related to another object in some way.</summary>
    public class Relationship : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/Relationship";
        public const string NamespacePrefix = "uco-core";
        public List<DateTime> EndTime { get; set; }
        public bool IsDirectional { get; set; }
        public string? KindOfRelationship { get; set; }
        public List<UcoObject> Source { get; set; }
        public List<DateTime> StartTime { get; set; }
        public UcoObject Target { get; set; }
    }

    /// <summary>A UCO inherent characterization thing is a grouping of characteristics unique to a particular inherent aspect of a UCO domain object.</summary>
    public class UcoInherentCharacterizationThing : UcoThing
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/UcoInherentCharacterizationThing";
        public const string NamespacePrefix = "uco-core";
    }

    /// <summary>A UCO object is a representation of a fundamental concept either directly inherent to the cyber domain or indirectly related to the cyber domain and necessary for contextually characterizing cyber dom</summary>
    public class UcoObject : UcoThing
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/UcoObject";
        public const string NamespacePrefix = "uco-core";
        public IdentityAbstraction? CreatedBy { get; set; }
        public List<string> Description { get; set; }
        public List<ExternalReference> ExternalReference { get; set; }
        public List<Facet> HasFacet { get; set; }
        public List<DateTime> ModifiedTime { get; set; }
        public string? Name { get; set; }
        public DateTime? ObjectCreatedTime { get; set; }
        public List<MarkingDefinitionAbstraction> ObjectMarking { get; set; }
        public string? ObjectStatus { get; set; }
        public string? SpecVersion { get; set; }
        public List<string> Tag { get; set; }
    }

    /// <summary>UcoThing is the top-level class within UCO.</summary>
    public class UcoThing
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/core/UcoThing";
        public const string NamespacePrefix = "uco-core";
    }

}