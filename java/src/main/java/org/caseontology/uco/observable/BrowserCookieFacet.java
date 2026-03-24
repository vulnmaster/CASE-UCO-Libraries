// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A browser cookie facet is a grouping of characteristics unique to a piece of data sent from a website and stored on the user's computer by the user's web browser while the user is browsing. [based on  */
public class BrowserCookieFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/BrowserCookieFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private java.time.ZonedDateTime accessedTime;
    private ObservableObject application;
    private ObservableObject cookieDomain;
    private String cookieName;
    private String cookiePath;
    private java.time.ZonedDateTime expirationTime;
    private Boolean isSecure;
    private java.time.ZonedDateTime observableCreatedTime;

    public BrowserCookieFacet() {
    }

    public java.time.ZonedDateTime getAccessedTime() { return this.accessedTime; }
    public BrowserCookieFacet setAccessedTime(java.time.ZonedDateTime value) { this.accessedTime = value; return this; }

    public ObservableObject getApplication() { return this.application; }
    public BrowserCookieFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public ObservableObject getCookieDomain() { return this.cookieDomain; }
    public BrowserCookieFacet setCookieDomain(ObservableObject value) { this.cookieDomain = value; return this; }

    public String getCookieName() { return this.cookieName; }
    public BrowserCookieFacet setCookieName(String value) { this.cookieName = value; return this; }

    public String getCookiePath() { return this.cookiePath; }
    public BrowserCookieFacet setCookiePath(String value) { this.cookiePath = value; return this; }

    public java.time.ZonedDateTime getExpirationTime() { return this.expirationTime; }
    public BrowserCookieFacet setExpirationTime(java.time.ZonedDateTime value) { this.expirationTime = value; return this; }

    public Boolean getIsSecure() { return this.isSecure; }
    public BrowserCookieFacet setIsSecure(Boolean value) { this.isSecure = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public BrowserCookieFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

}