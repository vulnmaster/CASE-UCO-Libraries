// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.core;

import java.util.ArrayList;
import java.util.List;

/** A UCO object is a representation of a fundamental concept either directly inherent to the cyber domain or indirectly related to the cyber domain and necessary for contextually characterizing cyber dom */
public class UcoObject extends UcoThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/core/UcoObject";
    public static final String NAMESPACE_PREFIX = "uco-core";

    private IdentityAbstraction createdBy;
    private List<String> description;
    private List<ExternalReference> externalReference;
    private List<Facet> hasFacet;
    private List<java.time.ZonedDateTime> modifiedTime;
    private String name;
    private java.time.ZonedDateTime objectCreatedTime;
    private List<MarkingDefinitionAbstraction> objectMarking;
    private String objectStatus;
    private String specVersion;
    private List<String> tag;

    public UcoObject() {
        this.description = new ArrayList<>();
        this.externalReference = new ArrayList<>();
        this.hasFacet = new ArrayList<>();
        this.modifiedTime = new ArrayList<>();
        this.objectMarking = new ArrayList<>();
        this.tag = new ArrayList<>();
    }

    public IdentityAbstraction getCreatedBy() { return this.createdBy; }
    public UcoObject setCreatedBy(IdentityAbstraction value) { this.createdBy = value; return this; }

    public List<String> getDescription() { return this.description; }
    public UcoObject setDescription(List<String> value) { this.description = value; return this; }

    public List<ExternalReference> getExternalReference() { return this.externalReference; }
    public UcoObject setExternalReference(List<ExternalReference> value) { this.externalReference = value; return this; }

    public List<Facet> getHasFacet() { return this.hasFacet; }
    public UcoObject setHasFacet(List<Facet> value) { this.hasFacet = value; return this; }

    public List<java.time.ZonedDateTime> getModifiedTime() { return this.modifiedTime; }
    public UcoObject setModifiedTime(List<java.time.ZonedDateTime> value) { this.modifiedTime = value; return this; }

    public String getName() { return this.name; }
    public UcoObject setName(String value) { this.name = value; return this; }

    public java.time.ZonedDateTime getObjectCreatedTime() { return this.objectCreatedTime; }
    public UcoObject setObjectCreatedTime(java.time.ZonedDateTime value) { this.objectCreatedTime = value; return this; }

    public List<MarkingDefinitionAbstraction> getObjectMarking() { return this.objectMarking; }
    public UcoObject setObjectMarking(List<MarkingDefinitionAbstraction> value) { this.objectMarking = value; return this; }

    public String getObjectStatus() { return this.objectStatus; }
    public UcoObject setObjectStatus(String value) { this.objectStatus = value; return this; }

    public String getSpecVersion() { return this.specVersion; }
    public UcoObject setSpecVersion(String value) { this.specVersion = value; return this; }

    public List<String> getTag() { return this.tag; }
    public UcoObject setTag(List<String> value) { this.tag = value; return this; }

}