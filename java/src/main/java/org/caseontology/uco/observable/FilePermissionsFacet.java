// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.core.UcoObject;

/** A file permissions facet is a grouping of characteristics unique to the access rights (e.g., view, change, navigate, execute) of a file on a file system. */
public class FilePermissionsFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/FilePermissionsFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private UcoObject owner;

    public FilePermissionsFacet() {
    }

    public UcoObject getOwner() { return this.owner; }
    public FilePermissionsFacet setOwner(UcoObject value) { this.owner = value; return this; }

}