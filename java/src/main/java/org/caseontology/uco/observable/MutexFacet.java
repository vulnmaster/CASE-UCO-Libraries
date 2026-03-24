// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A mutex facet is a grouping of characteristics unique to a mechanism that enforces limits on access to a resource when there are many threads of execution. A mutex is designed to enforce a mutual excl */
public class MutexFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/MutexFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Boolean isNamed;
    private String mutexName;

    public MutexFacet() {
    }

    public Boolean getIsNamed() { return this.isNamed; }
    public MutexFacet setIsNamed(Boolean value) { this.isNamed = value; return this; }

    public String getMutexName() { return this.mutexName; }
    public MutexFacet setMutexName(String value) { this.mutexName = value; return this; }

}