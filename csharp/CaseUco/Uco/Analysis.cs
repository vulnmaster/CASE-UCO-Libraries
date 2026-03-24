// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-analysis

using System;
using System.Collections.Generic;
using CaseUco.Uco.Core;

namespace CaseUco.Uco.Analysis
{
    /// <summary>An analytic result facet is a grouping of characteristics unique to the results of an analysis action.</summary>
    public class AnalyticResultFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/analysis/AnalyticResultFacet";
        public new const string NamespacePrefix = "uco-analysis";
    }

    /// <summary>An artifact classification is a single specific assertion that a particular class of a classification taxonomy applies to something.</summary>
    public class ArtifactClassification : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/analysis/ArtifactClassification";
        public new const string NamespacePrefix = "uco-analysis";
        public List<string> Class { get; set; }
        public decimal? ClassificationConfidence { get; set; }
    }

    /// <summary>An artifact classification result facet is a grouping of characteristics unique to the results of an artifact classification analysis action.</summary>
    public class ArtifactClassificationResultFacet : AnalyticResultFacet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/analysis/ArtifactClassificationResultFacet";
        public new const string NamespacePrefix = "uco-analysis";
        public List<ArtifactClassification> Classification { get; set; }
    }

}