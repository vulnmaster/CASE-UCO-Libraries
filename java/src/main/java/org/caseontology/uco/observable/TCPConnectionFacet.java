// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A TCP connection facet is a grouping of characteristics unique to portions of a network connection that are conformant to the Transmission Control Protocl (TCP) standard. */
public class TCPConnectionFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/TCPConnectionFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<byte[]> destinationFlags;
    private List<byte[]> sourceFlags;

    public TCPConnectionFacet() {
        this.destinationFlags = new ArrayList<>();
        this.sourceFlags = new ArrayList<>();
    }

    public List<byte[]> getDestinationFlags() { return this.destinationFlags; }
    public TCPConnectionFacet setDestinationFlags(List<byte[]> value) { this.destinationFlags = value; return this; }

    public List<byte[]> getSourceFlags() { return this.sourceFlags; }
    public TCPConnectionFacet setSourceFlags(List<byte[]> value) { this.sourceFlags = value; return this; }

}