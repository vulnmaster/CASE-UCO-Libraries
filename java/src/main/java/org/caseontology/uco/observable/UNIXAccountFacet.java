// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A UNIX account facet is a grouping of characteristics unique to an account on a UNIX operating system. */
public class UNIXAccountFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXAccountFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long gid;
    private String shell;

    public UNIXAccountFacet() {
    }

    public Long getGid() { return this.gid; }
    public UNIXAccountFacet setGid(Long value) { this.gid = value; return this; }

    public String getShell() { return this.shell; }
    public UNIXAccountFacet setShell(String value) { this.shell = value; return this; }

}