// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Item;

/** An observable object is a grouping of characteristics unique to a distinct article or unit within the digital domain. */
public class ObservableObject extends Item {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ObservableObject";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Boolean hasChanged;
    private String state;

    public ObservableObject() {
    }

    public Boolean getHasChanged() { return this.hasChanged; }
    public ObservableObject setHasChanged(Boolean value) { this.hasChanged = value; return this; }

    public String getState() { return this.state; }
    public ObservableObject setState(String value) { this.state = value; return this; }

}