// Auto-generated CASE/UCO ontology classes — do not edit manually.
// Module: uco-types

using System;
using System.Collections.Generic;
using CaseUco.Uco.Core;

namespace CaseUco.Uco.Types
{
    /// <summary>A controlled dictionary is a list of (term/key, value) pairs where each term/key exists no more than once and is constrained to an explicitly defined set of values.</summary>
    public class ControlledDictionary : Dictionary
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/types/ControlledDictionary";
        public new const string NamespacePrefix = "uco-types";
        public List<ControlledDictionaryEntry> Entry { get; set; }
    }

    /// <summary>A controlled dictionary entry is a single (term/key, value) pair where the term/key is constrained to an explicitly defined set of values.</summary>
    public class ControlledDictionaryEntry : DictionaryEntry
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/types/ControlledDictionaryEntry";
        public new const string NamespacePrefix = "uco-types";
    }

    /// <summary>A dictionary is list of (term/key, value) pairs with each term/key having an expectation to exist no more than once.  types:Dictionary alone does not validate this expectation, but validation is avail</summary>
    public class Dictionary : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/types/Dictionary";
        public new const string NamespacePrefix = "uco-types";
        public List<DictionaryEntry> Entry { get; set; }
    }

    /// <summary>A dictionary entry is a single (term/key, value) pair.</summary>
    public class DictionaryEntry : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/types/DictionaryEntry";
        public new const string NamespacePrefix = "uco-types";
        public string Key { get; set; }
        public string Value { get; set; }
    }

    /// <summary>A hash is a grouping of characteristics unique to the result of applying a mathematical algorithm that maps data of arbitrary size to a bit string (the 'hash') and is a one-way function, that is, a fu</summary>
    public class Hash : UcoInherentCharacterizationThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/types/Hash";
        public new const string NamespacePrefix = "uco-types";
        public List<string> HashMethod { get; set; }
        public byte[] HashValue { get; set; }
    }

    /// <summary>ImproperDictionary</summary>
    public class ImproperDictionary : Dictionary
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/types/ImproperDictionary";
        public new const string NamespacePrefix = "uco-types";
        public List<string> RepeatsKey { get; set; }
    }

    /// <summary>A proper dictionary is list of (term/key, value) pairs with each term/key existing no more than once.</summary>
    public class ProperDictionary : Dictionary
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/types/ProperDictionary";
        public new const string NamespacePrefix = "uco-types";
    }

    /// <summary>A semi-ordered array of items, that can be present in multiple copies.  Implemetation of a UCO Thread is similar to a Collections Ontology List, except a Thread may fork and merge - that is, one of it</summary>
    public class Thread : UcoThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/types/Thread";
        public new const string NamespacePrefix = "uco-types";
    }

    /// <summary>A ThreadItem is a member of a thread.</summary>
    public class ThreadItem : UcoThing
    {
        public new const string ClassIri = "https://ontology.unifiedcyberontology.org/uco/types/ThreadItem";
        public new const string NamespacePrefix = "uco-types";
    }

}