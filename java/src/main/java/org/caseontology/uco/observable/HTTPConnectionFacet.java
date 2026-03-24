// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.types.Dictionary;

/** An HTTP connection facet is a grouping of characteristics unique to portions of a network connection that are conformant to the Hypertext Transfer Protocol (HTTP) standard. */
public class HTTPConnectionFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/HTTPConnectionFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long httpMesageBodyLength;
    private ObservableObject httpMessageBodyData;
    private Dictionary httpRequestHeader;
    private String requestMethod;
    private String requestValue;
    private String requestVersion;

    public HTTPConnectionFacet() {
    }

    public Long getHttpMesageBodyLength() { return this.httpMesageBodyLength; }
    public HTTPConnectionFacet setHttpMesageBodyLength(Long value) { this.httpMesageBodyLength = value; return this; }

    public ObservableObject getHttpMessageBodyData() { return this.httpMessageBodyData; }
    public HTTPConnectionFacet setHttpMessageBodyData(ObservableObject value) { this.httpMessageBodyData = value; return this; }

    public Dictionary getHttpRequestHeader() { return this.httpRequestHeader; }
    public HTTPConnectionFacet setHttpRequestHeader(Dictionary value) { this.httpRequestHeader = value; return this; }

    public String getRequestMethod() { return this.requestMethod; }
    public HTTPConnectionFacet setRequestMethod(String value) { this.requestMethod = value; return this; }

    public String getRequestValue() { return this.requestValue; }
    public HTTPConnectionFacet setRequestValue(String value) { this.requestValue = value; return this; }

    public String getRequestVersion() { return this.requestVersion; }
    public HTTPConnectionFacet setRequestVersion(String value) { this.requestVersion = value; return this; }

}