// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A message facet is a grouping of characteristics unique to a discrete unit of electronic communication intended by the source for consumption by some recipient or group of recipients. [based on https: */
public class MessageFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/MessageFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;
    private ObservableObject from;
    private String messageID;
    private String messageText;
    private String messageType;
    private java.time.ZonedDateTime sentTime;
    private String sessionID;
    private List<ObservableObject> to;

    public MessageFacet() {
        this.to = new ArrayList<>();
    }

    public ObservableObject getApplication() { return this.application; }
    public MessageFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public ObservableObject getFrom() { return this.from; }
    public MessageFacet setFrom(ObservableObject value) { this.from = value; return this; }

    public String getMessageID() { return this.messageID; }
    public MessageFacet setMessageID(String value) { this.messageID = value; return this; }

    public String getMessageText() { return this.messageText; }
    public MessageFacet setMessageText(String value) { this.messageText = value; return this; }

    public String getMessageType() { return this.messageType; }
    public MessageFacet setMessageType(String value) { this.messageType = value; return this; }

    public java.time.ZonedDateTime getSentTime() { return this.sentTime; }
    public MessageFacet setSentTime(java.time.ZonedDateTime value) { this.sentTime = value; return this; }

    public String getSessionID() { return this.sessionID; }
    public MessageFacet setSessionID(String value) { this.sessionID = value; return this; }

    public List<ObservableObject> getTo() { return this.to; }
    public MessageFacet setTo(List<ObservableObject> value) { this.to = value; return this; }

}