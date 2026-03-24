// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.core;

import java.util.ArrayList;
import java.util.List;

/** An attributed name is a name of an entity issued by some attributed naming authority. */
public class AttributedName extends UcoObject {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/core/AttributedName";
    public static final String NAMESPACE_PREFIX = "uco-core";

    private String namingAuthority;

    public AttributedName() {
    }

    public String getNamingAuthority() { return this.namingAuthority; }
    public AttributedName setNamingAuthority(String value) { this.namingAuthority = value; return this; }

}