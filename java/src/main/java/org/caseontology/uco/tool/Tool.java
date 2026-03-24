// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.tool;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoObject;
import org.caseontology.uco.identity.Identity;

/** A tool is an element of hardware and/or software utilized to carry out a particular function. */
public class Tool extends UcoObject {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/tool/Tool";
    public static final String NAMESPACE_PREFIX = "uco-tool";

    private Identity creator;
    private List<java.net.URI> references;
    private String servicePack;
    private String toolType;
    private String version;

    public Tool() {
        this.references = new ArrayList<>();
    }

    public Identity getCreator() { return this.creator; }
    public Tool setCreator(Identity value) { this.creator = value; return this; }

    public List<java.net.URI> getReferences() { return this.references; }
    public Tool setReferences(List<java.net.URI> value) { this.references = value; return this; }

    public String getServicePack() { return this.servicePack; }
    public Tool setServicePack(String value) { this.servicePack = value; return this; }

    public String getToolType() { return this.toolType; }
    public Tool setToolType(String value) { this.toolType = value; return this; }

    public String getVersion() { return this.version; }
    public Tool setVersion(String value) { this.version = value; return this; }

}