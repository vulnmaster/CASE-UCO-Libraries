// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-marking

using System;
using System.Collections.Generic;

namespace CaseUco.Uco.Marking
{
    /// <summary>A granular marking is a grouping of characteristics unique to specification of marking definitions (restrictions, permissions, and other guidance for how data can be used and shared) that apply to par</summary>
    public class GranularMarking : UcoInherentCharacterizationThing
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/marking/GranularMarking";
        public const string NamespacePrefix = "uco-marking";
        public List<string> ContentSelectors { get; set; }
        public List<MarkingDefinition> Marking { get; set; }
    }

    /// <summary>A license marking is a grouping of characteristics unique to the expression of data marking definitions (restrictions, permissions, and other guidance for how data can be used and shared) to convey de</summary>
    public class LicenseMarking : MarkingModel
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/marking/LicenseMarking";
        public const string NamespacePrefix = "uco-marking";
        public List<string> DefinitionType { get; set; }
        public string License { get; set; }
    }

    /// <summary>A marking definition is a grouping of characteristics unique to the expression of a specific data marking conveying restrictions, permissions, and other guidance for how marked data can be used and sh</summary>
    public class MarkingDefinition : MarkingDefinitionAbstraction
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/marking/MarkingDefinition";
        public const string NamespacePrefix = "uco-marking";
        public List<MarkingModel> Definition { get; set; }
        public string DefinitionType { get; set; }
    }

    /// <summary>A marking model is a grouping of characteristics unique to the expression of a particular form of data marking definitions (restrictions, permissions, and other guidance for how data can be used and s</summary>
    public class MarkingModel : UcoInherentCharacterizationThing
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/marking/MarkingModel";
        public const string NamespacePrefix = "uco-marking";
    }

    /// <summary>A release-to marking is a grouping of characteristics unique to the expression of data marking definitions (restrictions, permissions, and other guidance for how data can be used and shared) to convey</summary>
    public class ReleaseToMarking : MarkingModel
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/marking/ReleaseToMarking";
        public const string NamespacePrefix = "uco-marking";
        public List<string> AuthorizedIdentities { get; set; }
        public List<string> DefinitionType { get; set; }
    }

    /// <summary>A statement marking is a grouping of characteristics unique to the expression of data marking definitions (restrictions, permissions, and other guidance for how data can be used and shared) to convey </summary>
    public class StatementMarking : MarkingModel
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/marking/StatementMarking";
        public const string NamespacePrefix = "uco-marking";
        public List<string> DefinitionType { get; set; }
        public string Statement { get; set; }
    }

    /// <summary>A terms of use marking is a grouping of characteristics unique to the expression of data marking definitions (restrictions, permissions, and other guidance for how data can be used and shared) to conv</summary>
    public class TermsOfUseMarking : MarkingModel
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/marking/TermsOfUseMarking";
        public const string NamespacePrefix = "uco-marking";
        public List<string> DefinitionType { get; set; }
        public string TermsOfUse { get; set; }
    }

}