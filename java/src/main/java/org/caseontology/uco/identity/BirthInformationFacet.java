// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.identity;

import java.util.ArrayList;
import java.util.List;

/** Birth information is a grouping of characteristics unique to information pertaining to the birth of an entity. */
public class BirthInformationFacet extends IdentityFacet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/identity/BirthInformationFacet";
    public static final String NAMESPACE_PREFIX = "uco-identity";

    private java.time.ZonedDateTime birthdate;

    public BirthInformationFacet() {
    }

    public java.time.ZonedDateTime getBirthdate() { return this.birthdate; }
    public BirthInformationFacet setBirthdate(java.time.ZonedDateTime value) { this.birthdate = value; return this; }

}