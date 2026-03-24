// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.identity.Identity;

/** A software facet is a grouping of characteristics unique to a software program (a definitively scoped instance of a collection of data or computer instructions that tell the computer how to work). [ba */
public class SoftwareFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/SoftwareFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String cpeid;
    private String language;
    private Identity manufacturer;
    private String swid;
    private String version;

    public SoftwareFacet() {
    }

    public String getCpeid() { return this.cpeid; }
    public SoftwareFacet setCpeid(String value) { this.cpeid = value; return this; }

    public String getLanguage() { return this.language; }
    public SoftwareFacet setLanguage(String value) { this.language = value; return this; }

    public Identity getManufacturer() { return this.manufacturer; }
    public SoftwareFacet setManufacturer(Identity value) { this.manufacturer = value; return this; }

    public String getSwid() { return this.swid; }
    public SoftwareFacet setSwid(String value) { this.swid = value; return this; }

    public String getVersion() { return this.version; }
    public SoftwareFacet setVersion(String value) { this.version = value; return this; }

}