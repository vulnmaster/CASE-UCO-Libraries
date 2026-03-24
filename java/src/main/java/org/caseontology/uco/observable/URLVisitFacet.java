// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A URL visit facet is a grouping of characteristics unique to the properties of a visit of a URL within a particular browser. */
public class URLVisitFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/URLVisitFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject browserInformation;
    private ObservableObject fromURLVisit;
    private ObservableObject url;
    private List<String> urlTransitionType;
    private java.time.Duration visitDuration;
    private java.time.ZonedDateTime visitTime;

    public URLVisitFacet() {
        this.urlTransitionType = new ArrayList<>();
    }

    public ObservableObject getBrowserInformation() { return this.browserInformation; }
    public URLVisitFacet setBrowserInformation(ObservableObject value) { this.browserInformation = value; return this; }

    public ObservableObject getFromURLVisit() { return this.fromURLVisit; }
    public URLVisitFacet setFromURLVisit(ObservableObject value) { this.fromURLVisit = value; return this; }

    public ObservableObject getUrl() { return this.url; }
    public URLVisitFacet setUrl(ObservableObject value) { this.url = value; return this; }

    public List<String> getUrlTransitionType() { return this.urlTransitionType; }
    public URLVisitFacet setUrlTransitionType(List<String> value) { this.urlTransitionType = value; return this; }

    public java.time.Duration getVisitDuration() { return this.visitDuration; }
    public URLVisitFacet setVisitDuration(java.time.Duration value) { this.visitDuration = value; return this; }

    public java.time.ZonedDateTime getVisitTime() { return this.visitTime; }
    public URLVisitFacet setVisitTime(java.time.ZonedDateTime value) { this.visitTime = value; return this; }

}