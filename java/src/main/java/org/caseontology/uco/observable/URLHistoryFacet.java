// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A URL history facet is a grouping of characteristics unique to the stored URL history for a particular web browser */
public class URLHistoryFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/URLHistoryFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject browserInformation;
    private List<URLHistoryEntry> urlHistoryEntry;

    public URLHistoryFacet() {
        this.urlHistoryEntry = new ArrayList<>();
    }

    public ObservableObject getBrowserInformation() { return this.browserInformation; }
    public URLHistoryFacet setBrowserInformation(ObservableObject value) { this.browserInformation = value; return this; }

    public List<URLHistoryEntry> getUrlHistoryEntry() { return this.urlHistoryEntry; }
    public URLHistoryFacet setUrlHistoryEntry(List<URLHistoryEntry> value) { this.urlHistoryEntry = value; return this; }

}