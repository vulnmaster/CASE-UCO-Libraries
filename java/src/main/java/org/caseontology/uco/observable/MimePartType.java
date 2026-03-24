// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A mime part type is a grouping of characteristics unique to a component of a multi-part email body. */
public class MimePartType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/MimePartType";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String body;
    private ObservableObject bodyRaw;
    private String contentDisposition;
    private String contentType;

    public MimePartType() {
    }

    public String getBody() { return this.body; }
    public MimePartType setBody(String value) { this.body = value; return this; }

    public ObservableObject getBodyRaw() { return this.bodyRaw; }
    public MimePartType setBodyRaw(ObservableObject value) { this.bodyRaw = value; return this; }

    public String getContentDisposition() { return this.contentDisposition; }
    public MimePartType setContentDisposition(String value) { this.contentDisposition = value; return this; }

    public String getContentType() { return this.contentType; }
    public MimePartType setContentType(String value) { this.contentType = value; return this; }

}