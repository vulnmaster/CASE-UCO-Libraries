// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A browser bookmark facet is a grouping of characteristics unique to a saved shortcut that directs a WWW (World Wide Web) browser software program to a particular WWW accessible resource. [based on htt */
public class BrowserBookmarkFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/BrowserBookmarkFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private java.time.ZonedDateTime accessedTime;
    private ObservableObject application;
    private String bookmarkPath;
    private java.time.ZonedDateTime modifiedTime;
    private java.time.ZonedDateTime observableCreatedTime;
    private List<java.net.URI> urlTargeted;
    private Long visitCount;

    public BrowserBookmarkFacet() {
        this.urlTargeted = new ArrayList<>();
    }

    public java.time.ZonedDateTime getAccessedTime() { return this.accessedTime; }
    public BrowserBookmarkFacet setAccessedTime(java.time.ZonedDateTime value) { this.accessedTime = value; return this; }

    public ObservableObject getApplication() { return this.application; }
    public BrowserBookmarkFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public String getBookmarkPath() { return this.bookmarkPath; }
    public BrowserBookmarkFacet setBookmarkPath(String value) { this.bookmarkPath = value; return this; }

    public java.time.ZonedDateTime getModifiedTime() { return this.modifiedTime; }
    public BrowserBookmarkFacet setModifiedTime(java.time.ZonedDateTime value) { this.modifiedTime = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public BrowserBookmarkFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

    public List<java.net.URI> getUrlTargeted() { return this.urlTargeted; }
    public BrowserBookmarkFacet setUrlTargeted(List<java.net.URI> value) { this.urlTargeted = value; return this; }

    public Long getVisitCount() { return this.visitCount; }
    public BrowserBookmarkFacet setVisitCount(Long value) { this.visitCount = value; return this; }

}