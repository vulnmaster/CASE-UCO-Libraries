// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A calendar facet is a grouping of characteristics unique to a collection of appointments, meetings, and events. */
public class CalendarFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/CalendarFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;
    private UcoObject owner;

    public CalendarFacet() {
    }

    public ObservableObject getApplication() { return this.application; }
    public CalendarFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public UcoObject getOwner() { return this.owner; }
    public CalendarFacet setOwner(UcoObject value) { this.owner = value; return this; }

}