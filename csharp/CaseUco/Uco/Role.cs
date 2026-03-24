// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-role

using System;
using System.Collections.Generic;

namespace CaseUco.Uco.Role
{
    /// <summary>A benevolent role is a role with positive and/or beneficial intent.</summary>
    public class BenevolentRole : Role
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/role/BenevolentRole";
        public const string NamespacePrefix = "uco-role";
    }

    /// <summary>A malicious role is a role with malevolent intent.</summary>
    public class MaliciousRole : Role
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/role/MaliciousRole";
        public const string NamespacePrefix = "uco-role";
    }

    /// <summary>A neutral role is a role with impartial intent.</summary>
    public class NeutralRole : Role
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/role/NeutralRole";
        public const string NamespacePrefix = "uco-role";
    }

    /// <summary>A role is a usual or customary function based on contextual perspective.</summary>
    public class Role : UcoObject
    {
        public const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/role/Role";
        public const string NamespacePrefix = "uco-role";
    }

}