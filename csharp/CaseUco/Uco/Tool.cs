// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-tool

using System;
using System.Collections.Generic;
using CaseUco.Uco.Configuration;
using CaseUco.Uco.Core;
using CaseUco.Uco.Identity;

namespace CaseUco.Uco.Tool
{
    /// <summary>An analytic tool is an artifact of hardware and/or software utilized to accomplish a task or purpose of explanation, interpretation or logical reasoning.</summary>
    public class AnalyticTool : Tool
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/AnalyticTool";
        public new const string NamespacePrefix = "uco-tool";
    }

    /// <summary>A build facet is a grouping of characteristics unique to a particular version of a software.</summary>
    public class BuildFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/BuildFacet";
        public new const string NamespacePrefix = "uco-tool";
        public BuildInformationType BuildInformation { get; set; }
    }

    /// <summary>A build information type is a grouping of characteristics that describe how a particular version of software was converted from source code to executable code.</summary>
    public class BuildInformationType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/BuildInformationType";
        public new const string NamespacePrefix = "uco-tool";
        public Configuration BuildConfiguration { get; set; }
        public string BuildID { get; set; }
        public string BuildLabel { get; set; }
        public string BuildOutputLog { get; set; }
        public string BuildProject { get; set; }
        public string BuildScript { get; set; }
        public BuildUtilityType BuildUtility { get; set; }
        public string BuildVersion { get; set; }
        public DateTime? CompilationDate { get; set; }
        public List<CompilerType> Compilers { get; set; }
        public List<LibraryType> Libraries { get; set; }
    }

    /// <summary>A build utility type characterizes the tool used to convert from source code to executable code for a particular version of software.</summary>
    public class BuildUtilityType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/BuildUtilityType";
        public new const string NamespacePrefix = "uco-tool";
        public string BuildUtilityName { get; set; }
        public string Cpeid { get; set; }
        public string Swid { get; set; }
    }

    /// <summary>A compiler type is a grouping of characteristics unique to a specific program that translates computer code written in one programming language (the source language) into another language (the target </summary>
    public class CompilerType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/CompilerType";
        public new const string NamespacePrefix = "uco-tool";
        public string CompilerInformalDescription { get; set; }
        public string Cpeid { get; set; }
        public string Swid { get; set; }
    }

    /// <summary>A ConfiguredTool is a Tool that is known to be configured to run in a more specified manner than some unconfigured or less-configured Tool.</summary>
    public class ConfiguredTool : Tool
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/ConfiguredTool";
        public new const string NamespacePrefix = "uco-tool";
        public Tool IsConfigurationOf { get; set; }
        public Configuration UsesConfiguration { get; set; }
    }

    /// <summary>A defensive tool is an artifact of hardware and/or software utilized to accomplish a task or purpose of guarding.</summary>
    public class DefensiveTool : Tool
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/DefensiveTool";
        public new const string NamespacePrefix = "uco-tool";
    }

    /// <summary>A library type is a grouping of characteristics unique to a collection of resources incorporated into the build of a software.</summary>
    public class LibraryType : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/LibraryType";
        public new const string NamespacePrefix = "uco-tool";
        public string LibraryName { get; set; }
        public string LibraryVersion { get; set; }
    }

    /// <summary>A malicious tool is an artifact of hardware and/or software utilized to accomplish a malevolent task or purpose.</summary>
    public class MaliciousTool : Tool
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/MaliciousTool";
        public new const string NamespacePrefix = "uco-tool";
    }

    /// <summary>A tool is an element of hardware and/or software utilized to carry out a particular function.</summary>
    public class Tool : UcoObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/tool/Tool";
        public new const string NamespacePrefix = "uco-tool";
        public Identity Creator { get; set; }
        public List<Uri> References { get; set; }
        public string ServicePack { get; set; }
        public string ToolType { get; set; }
        public string Version { get; set; }
    }

}