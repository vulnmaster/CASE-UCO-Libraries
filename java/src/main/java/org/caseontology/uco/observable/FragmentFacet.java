// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A fragment facet is a grouping of characteristics unique to an individual piece of the content of a file. */
public class FragmentFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/FragmentFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<Long> fragmentIndex;
    private List<Long> totalFragments;

    public FragmentFacet() {
        this.fragmentIndex = new ArrayList<>();
        this.totalFragments = new ArrayList<>();
    }

    public List<Long> getFragmentIndex() { return this.fragmentIndex; }
    public FragmentFacet setFragmentIndex(List<Long> value) { this.fragmentIndex = value; return this; }

    public List<Long> getTotalFragments() { return this.totalFragments; }
    public FragmentFacet setTotalFragments(List<Long> value) { this.totalFragments = value; return this; }

}