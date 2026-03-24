// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.identity;

import java.util.ArrayList;
import java.util.List;

/** A simple name facet is a grouping of characteristics unique to the personal name (e.g., Dr. John Smith Jr.) held by an identity. */
public class SimpleNameFacet extends IdentityFacet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/identity/SimpleNameFacet";
    public static final String NAMESPACE_PREFIX = "uco-identity";

    private List<String> familyName;
    private List<String> givenName;
    private List<String> honorificPrefix;
    private List<String> honorificSuffix;

    public SimpleNameFacet() {
        this.familyName = new ArrayList<>();
        this.givenName = new ArrayList<>();
        this.honorificPrefix = new ArrayList<>();
        this.honorificSuffix = new ArrayList<>();
    }

    public List<String> getFamilyName() { return this.familyName; }
    public SimpleNameFacet setFamilyName(List<String> value) { this.familyName = value; return this; }

    public List<String> getGivenName() { return this.givenName; }
    public SimpleNameFacet setGivenName(List<String> value) { this.givenName = value; return this; }

    public List<String> getHonorificPrefix() { return this.honorificPrefix; }
    public SimpleNameFacet setHonorificPrefix(List<String> value) { this.honorificPrefix = value; return this; }

    public List<String> getHonorificSuffix() { return this.honorificSuffix; }
    public SimpleNameFacet setHonorificSuffix(List<String> value) { this.honorificSuffix = value; return this; }

}