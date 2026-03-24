// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** Recoverability status of name, metadata, and content. */
public class RecoveredObjectFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/RecoveredObjectFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> contentRecoveredStatus;
    private List<String> metadataRecoveredStatus;
    private List<String> nameRecoveredStatus;

    public RecoveredObjectFacet() {
        this.contentRecoveredStatus = new ArrayList<>();
        this.metadataRecoveredStatus = new ArrayList<>();
        this.nameRecoveredStatus = new ArrayList<>();
    }

    public List<String> getContentRecoveredStatus() { return this.contentRecoveredStatus; }
    public RecoveredObjectFacet setContentRecoveredStatus(List<String> value) { this.contentRecoveredStatus = value; return this; }

    public List<String> getMetadataRecoveredStatus() { return this.metadataRecoveredStatus; }
    public RecoveredObjectFacet setMetadataRecoveredStatus(List<String> value) { this.metadataRecoveredStatus = value; return this; }

    public List<String> getNameRecoveredStatus() { return this.nameRecoveredStatus; }
    public RecoveredObjectFacet setNameRecoveredStatus(List<String> value) { this.nameRecoveredStatus = value; return this; }

}