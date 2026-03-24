// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.types.Hash;

/** A Windows PE binary file facet is a grouping of characteristics unique to a Windows portable executable (PE) file. */
public class WindowsPEBinaryFileFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPEBinaryFileFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<Integer> characteristics;
    private List<Hash> fileHeaderHashes;
    private String impHash;
    private List<String> machine;
    private Long numberOfSections;
    private Long numberOfSymbols;
    private WindowsPEOptionalHeader optionalHeader;
    private String peType;
    private List<byte[]> pointerToSymbolTable;
    private List<WindowsPESection> sections;
    private Long sizeOfOptionalHeader;
    private java.time.ZonedDateTime timeDateStamp;

    public WindowsPEBinaryFileFacet() {
        this.characteristics = new ArrayList<>();
        this.fileHeaderHashes = new ArrayList<>();
        this.machine = new ArrayList<>();
        this.pointerToSymbolTable = new ArrayList<>();
        this.sections = new ArrayList<>();
    }

    public List<Integer> getCharacteristics() { return this.characteristics; }
    public WindowsPEBinaryFileFacet setCharacteristics(List<Integer> value) { this.characteristics = value; return this; }

    public List<Hash> getFileHeaderHashes() { return this.fileHeaderHashes; }
    public WindowsPEBinaryFileFacet setFileHeaderHashes(List<Hash> value) { this.fileHeaderHashes = value; return this; }

    public String getImpHash() { return this.impHash; }
    public WindowsPEBinaryFileFacet setImpHash(String value) { this.impHash = value; return this; }

    public List<String> getMachine() { return this.machine; }
    public WindowsPEBinaryFileFacet setMachine(List<String> value) { this.machine = value; return this; }

    public Long getNumberOfSections() { return this.numberOfSections; }
    public WindowsPEBinaryFileFacet setNumberOfSections(Long value) { this.numberOfSections = value; return this; }

    public Long getNumberOfSymbols() { return this.numberOfSymbols; }
    public WindowsPEBinaryFileFacet setNumberOfSymbols(Long value) { this.numberOfSymbols = value; return this; }

    public WindowsPEOptionalHeader getOptionalHeader() { return this.optionalHeader; }
    public WindowsPEBinaryFileFacet setOptionalHeader(WindowsPEOptionalHeader value) { this.optionalHeader = value; return this; }

    public String getPeType() { return this.peType; }
    public WindowsPEBinaryFileFacet setPeType(String value) { this.peType = value; return this; }

    public List<byte[]> getPointerToSymbolTable() { return this.pointerToSymbolTable; }
    public WindowsPEBinaryFileFacet setPointerToSymbolTable(List<byte[]> value) { this.pointerToSymbolTable = value; return this; }

    public List<WindowsPESection> getSections() { return this.sections; }
    public WindowsPEBinaryFileFacet setSections(List<WindowsPESection> value) { this.sections = value; return this; }

    public Long getSizeOfOptionalHeader() { return this.sizeOfOptionalHeader; }
    public WindowsPEBinaryFileFacet setSizeOfOptionalHeader(Long value) { this.sizeOfOptionalHeader = value; return this; }

    public java.time.ZonedDateTime getTimeDateStamp() { return this.timeDateStamp; }
    public WindowsPEBinaryFileFacet setTimeDateStamp(java.time.ZonedDateTime value) { this.timeDateStamp = value; return this; }

}