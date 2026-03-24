// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-pattern

using System;
using System.Collections.Generic;

namespace CaseUco.Uco.Pattern
{
    /// <summary>A logical pattern is a grouping of characteristics unique to an informational pattern expressed via a structured pattern expression following the rules of logic.</summary>
    public class LogicalPattern : Pattern
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/pattern/LogicalPattern";
        public const string NamespacePrefix = "uco-pattern";
        public PatternExpression? PatternExpression { get; set; }
    }

    /// <summary>A pattern is a combination of properties, acts, tendencies, etc., forming a consistent or characteristic arrangement.</summary>
    public class Pattern : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/pattern/Pattern";
        public const string NamespacePrefix = "uco-pattern";
    }

    /// <summary>A pattern expression is a grouping of characteristics unique to an explicit logical expression defining a pattern (e.g., regular expression, SQL Select expression, etc.).</summary>
    public class PatternExpression : UcoInherentCharacterizationThing
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/pattern/PatternExpression";
        public const string NamespacePrefix = "uco-pattern";
    }

}