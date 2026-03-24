// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An email message facet is a grouping of characteristics unique to a message that is an instance of an electronic mail correspondence conformant to the internet message format described in RFC 5322 and */
public class EmailMessageFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/EmailMessageFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject application;
    private List<ObservableObject> bcc;
    private String body;
    private List<MimePartType> bodyMultipart;
    private ObservableObject bodyRaw;
    private List<String> categories;
    private List<ObservableObject> cc;
    private String contentDisposition;
    private String contentType;
    private ObservableObject from;
    private ObservableObject headerRaw;
    private String inReplyTo;
    private Boolean isMimeEncoded;
    private Boolean isMultipart;
    private Boolean isRead;
    private List<String> labels;
    private String messageID;
    private java.time.ZonedDateTime modifiedTime;
    private Dictionary otherHeaders;
    private String priority;
    private List<String> receivedLines;
    private java.time.ZonedDateTime receivedTime;
    private List<ObservableObject> references;
    private ObservableObject sender;
    private java.time.ZonedDateTime sentTime;
    private String subject;
    private List<ObservableObject> to;
    private String xMailer;
    private ObservableObject xOriginatingIP;

    public EmailMessageFacet() {
        this.bcc = new ArrayList<>();
        this.bodyMultipart = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.cc = new ArrayList<>();
        this.labels = new ArrayList<>();
        this.receivedLines = new ArrayList<>();
        this.references = new ArrayList<>();
        this.to = new ArrayList<>();
    }

    public ObservableObject getApplication() { return this.application; }
    public EmailMessageFacet setApplication(ObservableObject value) { this.application = value; return this; }

    public List<ObservableObject> getBcc() { return this.bcc; }
    public EmailMessageFacet setBcc(List<ObservableObject> value) { this.bcc = value; return this; }

    public String getBody() { return this.body; }
    public EmailMessageFacet setBody(String value) { this.body = value; return this; }

    public List<MimePartType> getBodyMultipart() { return this.bodyMultipart; }
    public EmailMessageFacet setBodyMultipart(List<MimePartType> value) { this.bodyMultipart = value; return this; }

    public ObservableObject getBodyRaw() { return this.bodyRaw; }
    public EmailMessageFacet setBodyRaw(ObservableObject value) { this.bodyRaw = value; return this; }

    public List<String> getCategories() { return this.categories; }
    public EmailMessageFacet setCategories(List<String> value) { this.categories = value; return this; }

    public List<ObservableObject> getCc() { return this.cc; }
    public EmailMessageFacet setCc(List<ObservableObject> value) { this.cc = value; return this; }

    public String getContentDisposition() { return this.contentDisposition; }
    public EmailMessageFacet setContentDisposition(String value) { this.contentDisposition = value; return this; }

    public String getContentType() { return this.contentType; }
    public EmailMessageFacet setContentType(String value) { this.contentType = value; return this; }

    public ObservableObject getFrom() { return this.from; }
    public EmailMessageFacet setFrom(ObservableObject value) { this.from = value; return this; }

    public ObservableObject getHeaderRaw() { return this.headerRaw; }
    public EmailMessageFacet setHeaderRaw(ObservableObject value) { this.headerRaw = value; return this; }

    public String getInReplyTo() { return this.inReplyTo; }
    public EmailMessageFacet setInReplyTo(String value) { this.inReplyTo = value; return this; }

    public Boolean getIsMimeEncoded() { return this.isMimeEncoded; }
    public EmailMessageFacet setIsMimeEncoded(Boolean value) { this.isMimeEncoded = value; return this; }

    public Boolean getIsMultipart() { return this.isMultipart; }
    public EmailMessageFacet setIsMultipart(Boolean value) { this.isMultipart = value; return this; }

    public Boolean getIsRead() { return this.isRead; }
    public EmailMessageFacet setIsRead(Boolean value) { this.isRead = value; return this; }

    public List<String> getLabels() { return this.labels; }
    public EmailMessageFacet setLabels(List<String> value) { this.labels = value; return this; }

    public String getMessageID() { return this.messageID; }
    public EmailMessageFacet setMessageID(String value) { this.messageID = value; return this; }

    public java.time.ZonedDateTime getModifiedTime() { return this.modifiedTime; }
    public EmailMessageFacet setModifiedTime(java.time.ZonedDateTime value) { this.modifiedTime = value; return this; }

    public Dictionary getOtherHeaders() { return this.otherHeaders; }
    public EmailMessageFacet setOtherHeaders(Dictionary value) { this.otherHeaders = value; return this; }

    public String getPriority() { return this.priority; }
    public EmailMessageFacet setPriority(String value) { this.priority = value; return this; }

    public List<String> getReceivedLines() { return this.receivedLines; }
    public EmailMessageFacet setReceivedLines(List<String> value) { this.receivedLines = value; return this; }

    public java.time.ZonedDateTime getReceivedTime() { return this.receivedTime; }
    public EmailMessageFacet setReceivedTime(java.time.ZonedDateTime value) { this.receivedTime = value; return this; }

    public List<ObservableObject> getReferences() { return this.references; }
    public EmailMessageFacet setReferences(List<ObservableObject> value) { this.references = value; return this; }

    public ObservableObject getSender() { return this.sender; }
    public EmailMessageFacet setSender(ObservableObject value) { this.sender = value; return this; }

    public java.time.ZonedDateTime getSentTime() { return this.sentTime; }
    public EmailMessageFacet setSentTime(java.time.ZonedDateTime value) { this.sentTime = value; return this; }

    public String getSubject() { return this.subject; }
    public EmailMessageFacet setSubject(String value) { this.subject = value; return this; }

    public List<ObservableObject> getTo() { return this.to; }
    public EmailMessageFacet setTo(List<ObservableObject> value) { this.to = value; return this; }

    public String getXMailer() { return this.xMailer; }
    public EmailMessageFacet setXMailer(String value) { this.xMailer = value; return this; }

    public ObservableObject getXOriginatingIP() { return this.xOriginatingIP; }
    public EmailMessageFacet setXOriginatingIP(ObservableObject value) { this.xOriginatingIP = value; return this; }

}