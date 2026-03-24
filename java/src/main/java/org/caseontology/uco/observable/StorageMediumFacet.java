// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A storage medium facet is a grouping of characteristics unique to a the storage capabilities of a piece of equipment or a mechanism designed to serve a special purpose or perform a special function. */
public class StorageMediumFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/StorageMediumFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long totalStorageCapacityInBytes;

    public StorageMediumFacet() {
    }

    public Long getTotalStorageCapacityInBytes() { return this.totalStorageCapacityInBytes; }
    public StorageMediumFacet setTotalStorageCapacityInBytes(Long value) { this.totalStorageCapacityInBytes = value; return this; }

}