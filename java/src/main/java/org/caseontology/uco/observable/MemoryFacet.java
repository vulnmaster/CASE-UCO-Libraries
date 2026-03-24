// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A memory facet is a grouping of characteristics unique to a particular region of temporary information storage (e.g., RAM (random access memory), ROM (read only memory)) on a digital device. */
public class MemoryFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/MemoryFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> blockType;
    private Boolean isInjected;
    private Boolean isMapped;
    private Boolean isProtected;
    private Boolean isVolatile;
    private List<byte[]> regionEndAddress;
    private Long regionSize;
    private List<byte[]> regionStartAddress;

    public MemoryFacet() {
        this.blockType = new ArrayList<>();
        this.regionEndAddress = new ArrayList<>();
        this.regionStartAddress = new ArrayList<>();
    }

    public List<String> getBlockType() { return this.blockType; }
    public MemoryFacet setBlockType(List<String> value) { this.blockType = value; return this; }

    public Boolean getIsInjected() { return this.isInjected; }
    public MemoryFacet setIsInjected(Boolean value) { this.isInjected = value; return this; }

    public Boolean getIsMapped() { return this.isMapped; }
    public MemoryFacet setIsMapped(Boolean value) { this.isMapped = value; return this; }

    public Boolean getIsProtected() { return this.isProtected; }
    public MemoryFacet setIsProtected(Boolean value) { this.isProtected = value; return this; }

    public Boolean getIsVolatile() { return this.isVolatile; }
    public MemoryFacet setIsVolatile(Boolean value) { this.isVolatile = value; return this; }

    public List<byte[]> getRegionEndAddress() { return this.regionEndAddress; }
    public MemoryFacet setRegionEndAddress(List<byte[]> value) { this.regionEndAddress = value; return this; }

    public Long getRegionSize() { return this.regionSize; }
    public MemoryFacet setRegionSize(Long value) { this.regionSize = value; return this; }

    public List<byte[]> getRegionStartAddress() { return this.regionStartAddress; }
    public MemoryFacet setRegionStartAddress(List<byte[]> value) { this.regionStartAddress = value; return this; }

}