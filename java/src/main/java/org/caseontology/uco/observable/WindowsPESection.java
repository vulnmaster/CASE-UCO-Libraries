// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;
import org.caseontology.uco.types.Hash;

/** A Windows PE section is a grouping of characteristics unique to a specific default or custom-defined region of a Windows PE (Portable Executable) file, consisting of an individual portion of the actua */
public class WindowsPESection extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPESection";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String name;
    private java.math.BigDecimal entropy;
    private List<Hash> hashes;
    private Long size;

    public WindowsPESection() {
        this.hashes = new ArrayList<>();
    }

    public String getName() { return this.name; }
    public WindowsPESection setName(String value) { this.name = value; return this; }

    public java.math.BigDecimal getEntropy() { return this.entropy; }
    public WindowsPESection setEntropy(java.math.BigDecimal value) { this.entropy = value; return this; }

    public List<Hash> getHashes() { return this.hashes; }
    public WindowsPESection setHashes(List<Hash> value) { this.hashes = value; return this; }

    public Long getSize() { return this.size; }
    public WindowsPESection setSize(Long value) { this.size = value; return this; }

}