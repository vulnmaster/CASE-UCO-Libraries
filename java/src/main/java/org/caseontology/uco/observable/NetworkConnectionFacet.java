// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A network connection facet is a grouping of characteristics unique to a connection (complete or attempted) accross a digital network (a group of two or more computer systems linked together). [based o */
public class NetworkConnectionFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/NetworkConnectionFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long destinationPort;
    private List<ObservableObject> dst;
    private java.time.ZonedDateTime endTime;
    private Boolean isActive;
    private ControlledDictionary protocols;
    private Long sourcePort;
    private List<UcoObject> src;
    private java.time.ZonedDateTime startTime;

    public NetworkConnectionFacet() {
        this.dst = new ArrayList<>();
        this.src = new ArrayList<>();
    }

    public Long getDestinationPort() { return this.destinationPort; }
    public NetworkConnectionFacet setDestinationPort(Long value) { this.destinationPort = value; return this; }

    public List<ObservableObject> getDst() { return this.dst; }
    public NetworkConnectionFacet setDst(List<ObservableObject> value) { this.dst = value; return this; }

    public java.time.ZonedDateTime getEndTime() { return this.endTime; }
    public NetworkConnectionFacet setEndTime(java.time.ZonedDateTime value) { this.endTime = value; return this; }

    public Boolean getIsActive() { return this.isActive; }
    public NetworkConnectionFacet setIsActive(Boolean value) { this.isActive = value; return this; }

    public ControlledDictionary getProtocols() { return this.protocols; }
    public NetworkConnectionFacet setProtocols(ControlledDictionary value) { this.protocols = value; return this; }

    public Long getSourcePort() { return this.sourcePort; }
    public NetworkConnectionFacet setSourcePort(Long value) { this.sourcePort = value; return this; }

    public List<UcoObject> getSrc() { return this.src; }
    public NetworkConnectionFacet setSrc(List<UcoObject> value) { this.src = value; return this; }

    public java.time.ZonedDateTime getStartTime() { return this.startTime; }
    public NetworkConnectionFacet setStartTime(java.time.ZonedDateTime value) { this.startTime = value; return this; }

}