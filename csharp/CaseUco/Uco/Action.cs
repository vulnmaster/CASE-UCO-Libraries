// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-action

using System;
using System.Collections.Generic;
using CaseUco.Uco.Core;
using CaseUco.Uco.Location;
using CaseUco.Uco.Pattern;

namespace CaseUco.Uco.Action
{
    /// <summary>An action is something that may be done or performed.</summary>
    public class Action : UcoObject
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/action/Action";
        public new const string NamespacePrefix = "uco-action";
        public ulong? ActionCount { get; set; }
        public List<string> ActionStatus { get; set; }
        public DateTime? EndTime { get; set; }
        public UcoObject Environment { get; set; }
        public List<UcoObject> Error { get; set; }
        public List<UcoObject> Instrument { get; set; }
        public List<Location> Location { get; set; }
        public List<UcoObject> Object { get; set; }
        public List<UcoObject> Participant { get; set; }
        public UcoObject Performer { get; set; }
        public List<UcoObject> Result { get; set; }
        public DateTime? StartTime { get; set; }
        public List<Action> Subaction { get; set; }
    }

    /// <summary>An action argument facet is a grouping of characteristics unique to a single parameter of an action.</summary>
    public class ActionArgumentFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/action/ActionArgumentFacet";
        public new const string NamespacePrefix = "uco-action";
        public string ArgumentName { get; set; }
        public string Value { get; set; }
    }

    /// <summary>An action estimation facet is a grouping of characteristics unique to decision-focused approximation aspects for an action that may potentially be performed.</summary>
    public class ActionEstimationFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/action/ActionEstimationFacet";
        public new const string NamespacePrefix = "uco-action";
        public string EstimatedCost { get; set; }
        public string EstimatedEfficacy { get; set; }
        public string EstimatedImpact { get; set; }
        public string Objective { get; set; }
    }

    /// <summary>An action frequency facet is a grouping of characteristics unique to the frequency of occurrence for an action.</summary>
    public class ActionFrequencyFacet : Facet
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/action/ActionFrequencyFacet";
        public new const string NamespacePrefix = "uco-action";
        public decimal Rate { get; set; }
        public string Scale { get; set; }
        public List<string> Trend { get; set; }
        public string Units { get; set; }
    }

    /// <summary>An action lifecycle is an action pattern consisting of an ordered set of multiple actions or subordinate action lifecycles.</summary>
    public class ActionLifecycle : Action
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/action/ActionLifecycle";
        public new const string NamespacePrefix = "uco-action";
        public List<ulong> ActionCount { get; set; }
        public List<DateTime> EndTime { get; set; }
        public List<UcoObject> Error { get; set; }
        public ArrayOfAction Phase { get; set; }
        public List<DateTime> StartTime { get; set; }
    }

    /// <summary>An action pattern is a grouping of characteristics unique to a combination of actions forming a consistent or characteristic arrangement.</summary>
    public class ActionPattern : Action
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/action/ActionPattern";
        public new const string NamespacePrefix = "uco-action";
    }

    /// <summary>An array of action is an ordered list of references to things that may be done or performed.</summary>
    public class ArrayOfAction : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/action/ArrayOfAction";
        public new const string NamespacePrefix = "uco-action";
        public List<Action> Action { get; set; }
    }

}