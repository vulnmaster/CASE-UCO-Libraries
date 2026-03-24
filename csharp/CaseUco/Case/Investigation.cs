// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: case-investigation

using System;
using System.Collections.Generic;

namespace CaseUco.Case.Investigation
{
    /// <summary>Attorney is a role involved in preparing, interpreting, and applying law.</summary>
    public class Attorney : Role
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/Attorney";
        public const string NamespacePrefix = "case-investigation";
    }

    /// <summary>An authorization is a grouping of characteristics unique to some form of authoritative permission identified for investigative action.</summary>
    public class Authorization : UcoObject
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/Authorization";
        public const string NamespacePrefix = "case-investigation";
        public List<string> AuthorizationIdentifier { get; set; }
        public string? AuthorizationType { get; set; }
        public DateTime? EndTime { get; set; }
        public DateTime? StartTime { get; set; }
    }

    /// <summary>Examiner is a role involved in providing scientific evaluations of evidence that are used to aid law enforcement investigations and court cases.</summary>
    public class Examiner : Role
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/Examiner";
        public const string NamespacePrefix = "case-investigation";
    }

    /// <summary>An investigation is a grouping of characteristics unique to an exploration of the facts involved in a cyber-relevant set of suspicious activity.</summary>
    public class Investigation : ContextualCompilation
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/Investigation";
        public const string NamespacePrefix = "case-investigation";
        public List<string> Focus { get; set; }
        public List<string> InvestigationForm { get; set; }
        public string? InvestigationStatus { get; set; }
        public List<Authorization> RelevantAuthorization { get; set; }
        public DateTime? EndTime { get; set; }
        public DateTime? StartTime { get; set; }
    }

    /// <summary>An investigative action is something that may be done or performed within the context of an investigation, typically to examine or analyze evidence or other data.</summary>
    public class InvestigativeAction : Action
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/InvestigativeAction";
        public const string NamespacePrefix = "case-investigation";
        public List<InvestigativeAction> WasInformedBy { get; set; }
    }

    /// <summary>Investigator is a role involved in coordinating an investigation.</summary>
    public class Investigator : Role
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/Investigator";
        public const string NamespacePrefix = "case-investigation";
    }

    /// <summary>A provenance record is a grouping of characteristics unique to the provenantial (chronology of the ownership, custody or location) connection between an investigative action and a set of observations </summary>
    public class ProvenanceRecord : ContextualCompilation
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/ProvenanceRecord";
        public const string NamespacePrefix = "case-investigation";
        public string? ExhibitNumber { get; set; }
        public List<string> RootExhibitNumber { get; set; }
    }

    /// <summary>Subject is a role whose conduct is within the scope of an investigation.</summary>
    public class Subject : Role
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/Subject";
        public const string NamespacePrefix = "case-investigation";
    }

    /// <summary>A subject action lifecycle is an action pattern consisting of an ordered set of multiple actions or subordinate action-lifecycles performed by an entity acting in a role whose conduct may be within th</summary>
    public class SubjectActionLifecycle : ActionLifecycle
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/SubjectActionLifecycle";
        public const string NamespacePrefix = "case-investigation";
    }

    /// <summary>A victim action lifecycle is an action pattern consisting of an ordered set of multiple actions or subordinate action-lifecycles performed by an entity acting in a role characterized by its potential </summary>
    public class VictimActionLifecycle : ActionLifecycle
    {
        public const string ClassIri = "https://ontology.caseontology.org/case/investigation/VictimActionLifecycle";
        public const string NamespacePrefix = "case-investigation";
    }

}