// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-configuration

using System;
using System.Collections.Generic;
using CaseUco.Uco.Core;

namespace CaseUco.Uco.Configuration
{
    /// <summary>A configuration is a grouping of characteristics unique to a set of parameters or initial settings for the use of a tool, application, software, or other cyber object.</summary>
    public class Configuration : UcoObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/configuration/Configuration";
        public new const string NamespacePrefix = "uco-configuration";
        public List<ConfigurationEntry> ConfigurationEntry { get; set; }
        public List<Dependency> Dependencies { get; set; }
        public List<string> UsageContextAssumptions { get; set; }
    }

    /// <summary>A configuration entry is a grouping of characteristics unique to a particular parameter or initial setting for the use of a tool, application, software, or other cyber object.</summary>
    public class ConfigurationEntry : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/configuration/ConfigurationEntry";
        public new const string NamespacePrefix = "uco-configuration";
        public string ItemDescription { get; set; }
        public string ItemName { get; set; }
        public List<UcoObject> ItemObject { get; set; }
        public string ItemType { get; set; }
        public List<string> ItemValue { get; set; }
    }

    /// <summary>A dependency is a grouping of characteristics unique to something that a tool or other software relies on to function as intended.</summary>
    public class Dependency : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/configuration/Dependency";
        public new const string NamespacePrefix = "uco-configuration";
        public string DependencyDescription { get; set; }
        public string DependencyType { get; set; }
    }

}