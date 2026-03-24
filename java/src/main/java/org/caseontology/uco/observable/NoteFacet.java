// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A note facet is a grouping of characteristics unique to a brief textual record. */
public class NoteFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/NoteFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;
    private java.time.ZonedDateTime modifiedTime;
    private java.time.ZonedDateTime observableCreatedTime;
    private String text;

    public NoteFacet() {
    }

    public ObservableObject getApplication() { return this.application; }
    public NoteFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public java.time.ZonedDateTime getModifiedTime() { return this.modifiedTime; }
    public NoteFacet setModifiedTime(java.time.ZonedDateTime value) { this.modifiedTime = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public NoteFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

    public String getText() { return this.text; }
    public NoteFacet setText(String value) { this.text = value; return this; }

}