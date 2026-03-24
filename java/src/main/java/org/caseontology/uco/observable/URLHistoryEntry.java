// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A URL history entry is a grouping of characteristics unique to the properties of a single URL history entry for a particular browser. */
public class URLHistoryEntry extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/URLHistoryEntry";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String browserUserProfile;
    private java.time.ZonedDateTime expirationTime;
    private java.time.ZonedDateTime firstVisit;
    private String hostname;
    private List<String> keywordSearchTerm;
    private java.time.ZonedDateTime lastVisit;
    private Long manuallyEnteredCount;
    private String pageTitle;
    private List<ObservableObject> referrerUrl;
    private ObservableObject url;
    private Long visitCount;

    public URLHistoryEntry() {
        this.keywordSearchTerm = new ArrayList<>();
        this.referrerUrl = new ArrayList<>();
    }

    public String getBrowserUserProfile() { return this.browserUserProfile; }
    public URLHistoryEntry setBrowserUserProfile(String value) { this.browserUserProfile = value; return this; }

    public java.time.ZonedDateTime getExpirationTime() { return this.expirationTime; }
    public URLHistoryEntry setExpirationTime(java.time.ZonedDateTime value) { this.expirationTime = value; return this; }

    public java.time.ZonedDateTime getFirstVisit() { return this.firstVisit; }
    public URLHistoryEntry setFirstVisit(java.time.ZonedDateTime value) { this.firstVisit = value; return this; }

    public String getHostname() { return this.hostname; }
    public URLHistoryEntry setHostname(String value) { this.hostname = value; return this; }

    public List<String> getKeywordSearchTerm() { return this.keywordSearchTerm; }
    public URLHistoryEntry setKeywordSearchTerm(List<String> value) { this.keywordSearchTerm = value; return this; }

    public java.time.ZonedDateTime getLastVisit() { return this.lastVisit; }
    public URLHistoryEntry setLastVisit(java.time.ZonedDateTime value) { this.lastVisit = value; return this; }

    public Long getManuallyEnteredCount() { return this.manuallyEnteredCount; }
    public URLHistoryEntry setManuallyEnteredCount(Long value) { this.manuallyEnteredCount = value; return this; }

    public String getPageTitle() { return this.pageTitle; }
    public URLHistoryEntry setPageTitle(String value) { this.pageTitle = value; return this; }

    public List<ObservableObject> getReferrerUrl() { return this.referrerUrl; }
    public URLHistoryEntry setReferrerUrl(List<ObservableObject> value) { this.referrerUrl = value; return this; }

    public ObservableObject getUrl() { return this.url; }
    public URLHistoryEntry setUrl(ObservableObject value) { this.url = value; return this; }

    public Long getVisitCount() { return this.visitCount; }
    public URLHistoryEntry setVisitCount(Long value) { this.visitCount = value; return this; }

}