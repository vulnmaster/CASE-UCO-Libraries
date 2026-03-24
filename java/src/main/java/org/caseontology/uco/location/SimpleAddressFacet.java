// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.location;

import java.util.ArrayList;
import java.util.List;

/** A simple address facet is a grouping of characteristics unique to a geolocation expressed as an administrative address. */
public class SimpleAddressFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/location/SimpleAddressFacet";
    public static final String NAMESPACE_PREFIX = "uco-location";

    private String addressType;
    private String country;
    private String locality;
    private String postalCode;
    private String region;
    private String street;

    public SimpleAddressFacet() {
    }

    public String getAddressType() { return this.addressType; }
    public SimpleAddressFacet setAddressType(String value) { this.addressType = value; return this; }

    public String getCountry() { return this.country; }
    public SimpleAddressFacet setCountry(String value) { this.country = value; return this; }

    public String getLocality() { return this.locality; }
    public SimpleAddressFacet setLocality(String value) { this.locality = value; return this; }

    public String getPostalCode() { return this.postalCode; }
    public SimpleAddressFacet setPostalCode(String value) { this.postalCode = value; return this; }

    public String getRegion() { return this.region; }
    public SimpleAddressFacet setRegion(String value) { this.region = value; return this; }

    public String getStreet() { return this.street; }
    public SimpleAddressFacet setStreet(String value) { this.street = value; return this; }

}