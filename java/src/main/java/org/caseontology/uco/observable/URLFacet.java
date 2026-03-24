// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A URL facet is a grouping of characteristics unique to a uniform resource locator (URL) acting as a resolvable address to a particular WWW (World Wide Web) accessible resource. */
public class URLFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/URLFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String fragment;
    private String fullValue;
    private ObservableObject host;
    private String password;
    private String path;
    private Long port;
    private String query;
    private String scheme;
    private String userName;

    public URLFacet() {
    }

    public String getFragment() { return this.fragment; }
    public URLFacet setFragment(String value) { this.fragment = value; return this; }

    public String getFullValue() { return this.fullValue; }
    public URLFacet setFullValue(String value) { this.fullValue = value; return this; }

    public ObservableObject getHost() { return this.host; }
    public URLFacet setHost(ObservableObject value) { this.host = value; return this; }

    public String getPassword() { return this.password; }
    public URLFacet setPassword(String value) { this.password = value; return this; }

    public String getPath() { return this.path; }
    public URLFacet setPath(String value) { this.path = value; return this; }

    public Long getPort() { return this.port; }
    public URLFacet setPort(Long value) { this.port = value; return this; }

    public String getQuery() { return this.query; }
    public URLFacet setQuery(String value) { this.query = value; return this; }

    public String getScheme() { return this.scheme; }
    public URLFacet setScheme(String value) { this.scheme = value; return this; }

    public String getUserName() { return this.userName; }
    public URLFacet setUserName(String value) { this.userName = value; return this; }

}