// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A path relation facet is a grouping of characteristics unique to the location of one object within another containing object. */
public class PathRelationFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/PathRelationFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> path;

    public PathRelationFacet() {
        this.path = new ArrayList<>();
    }

    public List<String> getPath() { return this.path; }
    public PathRelationFacet setPath(List<String> value) { this.path = value; return this; }

}