// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A symbolic link facet is a grouping of characteristics unique to a file that contains a reference to another file or directory in the form of an absolute or relative path and that affects pathname res */
public class SymbolicLinkFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/SymbolicLinkFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject targetFile;

    public SymbolicLinkFacet() {
    }

    public ObservableObject getTargetFile() { return this.targetFile; }
    public SymbolicLinkFacet setTargetFile(ObservableObject value) { this.targetFile = value; return this; }

}