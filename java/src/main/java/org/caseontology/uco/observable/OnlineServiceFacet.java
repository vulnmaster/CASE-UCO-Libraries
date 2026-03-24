// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An online service facet is a grouping of characteristics unique to a particular provision mechanism of information access, distribution or manipulation over the Internet. */
public class OnlineServiceFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/OnlineServiceFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String name;
    private List<ObservableObject> inetLocation;
    private List<Location> location;

    public OnlineServiceFacet() {
        this.inetLocation = new ArrayList<>();
        this.location = new ArrayList<>();
    }

    public String getName() { return this.name; }
    public OnlineServiceFacet setName(String value) { this.name = value; return this; }

    public List<ObservableObject> getInetLocation() { return this.inetLocation; }
    public OnlineServiceFacet setInetLocation(List<ObservableObject> value) { this.inetLocation = value; return this; }

    public List<Location> getLocation() { return this.location; }
    public OnlineServiceFacet setLocation(List<Location> value) { this.location = value; return this; }

}