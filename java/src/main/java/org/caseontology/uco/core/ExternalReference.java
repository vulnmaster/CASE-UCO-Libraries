// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.core;

import java.util.ArrayList;
import java.util.List;

/** Characteristics of a reference to a resource outside of the UCO. */
public class ExternalReference extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/core/ExternalReference";
    public static final String NAMESPACE_PREFIX = "uco-core";

    private String definingContext;
    private String externalIdentifier;
    private java.net.URI referenceURL;

    public ExternalReference() {
    }

    public String getDefiningContext() { return this.definingContext; }
    public ExternalReference setDefiningContext(String value) { this.definingContext = value; return this; }

    public String getExternalIdentifier() { return this.externalIdentifier; }
    public ExternalReference setExternalIdentifier(String value) { this.externalIdentifier = value; return this; }

    public java.net.URI getReferenceURL() { return this.referenceURL; }
    public ExternalReference setReferenceURL(java.net.URI value) { this.referenceURL = value; return this; }

}