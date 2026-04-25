// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-analysis

using System.Collections.Generic;

namespace CaseUco.Uco.Analysis
{
    /// <summary>An analysis is an action of detailed examination of something in order to understand its nature, context or essential features.</summary>
    public class Analysis : CaseUco.Uco.Action.Action
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/analysis/Analysis";
        public new const string NamespacePrefix = "uco-analysis";
    }

    /// <summary>An analytic result is a characterization of the understanding resulting from an analysis action.</summary>
    public class AnalyticResult : CaseUco.Uco.Core.Assertion
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/analysis/AnalyticResult";
        public new const string NamespacePrefix = "uco-analysis";
    }

    /// <summary>An analytic result facet is a grouping of characteristics unique to the results of an analysis action.</summary>
    public class AnalyticResultFacet : CaseUco.Uco.Core.Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/analysis/AnalyticResultFacet";
        public new const string NamespacePrefix = "uco-analysis";
    }

    /// <summary>An artifact classification is a single specific assertion that a particular class of a classification taxonomy applies to something.</summary>
    public class ArtifactClassification : CaseUco.Uco.Core.UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/analysis/ArtifactClassification";
        public new const string NamespacePrefix = "uco-analysis";
        [global::CaseUco.CaseRequired]
        [global::CaseUco.JsonLdProperty("uco-analysis:class")]
        public List<string> Class { get; set; }
        [global::CaseUco.JsonLdProperty("uco-analysis:classificationConfidence")]
        public decimal? ClassificationConfidence { get; set; }
    }

    /// <summary>An artifact classification result facet is a grouping of characteristics unique to the results of an artifact classification analysis action.</summary>
    public class ArtifactClassificationResultFacet : CaseUco.Uco.Analysis.AnalyticResultFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/analysis/ArtifactClassificationResultFacet";
        public new const string NamespacePrefix = "uco-analysis";
        [global::CaseUco.JsonLdProperty("uco-analysis:classification")]
        public List<CaseUco.Uco.Analysis.ArtifactClassification> Classification { get; set; }
    }

}