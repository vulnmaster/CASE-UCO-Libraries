// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.identity;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.location.Location;

/** An address facet is a grouping of characteristics unique to an administrative identifier for a geolocation associated with a specific identity. */
public class AddressFacet extends IdentityFacet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/identity/AddressFacet";
    public static final String NAMESPACE_PREFIX = "uco-identity";

    private Location address;

    public AddressFacet() {
    }

    public Location getAddress() { return this.address; }
    public AddressFacet setAddress(Location value) { this.address = value; return this; }

}