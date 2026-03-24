// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A network flow facet is a grouping of characteristics unique to a sequence of data transiting one or more digital network (a group of two or more computer systems linked together) connections. [based  */
public class NetworkFlowFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkFlowFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long dstBytes;
    private Long dstPackets;
    private ObservableObject dstPayload;
    private Dictionary ipfix;
    private Long srcBytes;
    private Long srcPackets;
    private ObservableObject srcPayload;

    public NetworkFlowFacet() {
    }

    public Long getDstBytes() { return this.dstBytes; }
    public NetworkFlowFacet setDstBytes(Long value) { this.dstBytes = value; return this; }

    public Long getDstPackets() { return this.dstPackets; }
    public NetworkFlowFacet setDstPackets(Long value) { this.dstPackets = value; return this; }

    public ObservableObject getDstPayload() { return this.dstPayload; }
    public NetworkFlowFacet setDstPayload(ObservableObject value) { this.dstPayload = value; return this; }

    public Dictionary getIpfix() { return this.ipfix; }
    public NetworkFlowFacet setIpfix(Dictionary value) { this.ipfix = value; return this; }

    public Long getSrcBytes() { return this.srcBytes; }
    public NetworkFlowFacet setSrcBytes(Long value) { this.srcBytes = value; return this; }

    public Long getSrcPackets() { return this.srcPackets; }
    public NetworkFlowFacet setSrcPackets(Long value) { this.srcPackets = value; return this; }

    public ObservableObject getSrcPayload() { return this.srcPayload; }
    public NetworkFlowFacet setSrcPayload(ObservableObject value) { this.srcPayload = value; return this; }

}