// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** An ICMP connection facet is a grouping of characteristics unique to portions of a network connection that are conformant to the Internet Control Message Protocol (ICMP) standard. */
public class ICMPConnectionFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ICMPConnectionFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<byte[]> icmpCode;
    private List<byte[]> icmpType;

    public ICMPConnectionFacet() {
        this.icmpCode = new ArrayList<>();
        this.icmpType = new ArrayList<>();
    }

    public List<byte[]> getIcmpCode() { return this.icmpCode; }
    public ICMPConnectionFacet setIcmpCode(List<byte[]> value) { this.icmpCode = value; return this; }

    public List<byte[]> getIcmpType() { return this.icmpType; }
    public ICMPConnectionFacet setIcmpType(List<byte[]> value) { this.icmpType = value; return this; }

}