// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A Windows PE optional header is a grouping of characteristics unique to the 'optional header' of a Windows PE (Portable Executable) file, consisting of a collection of metadata about the executable co */
public class WindowsPEOptionalHeader extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPEOptionalHeader";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<Long> addressOfEntryPoint;
    private List<Long> baseOfCode;
    private List<Long> checksum;
    private List<Integer> dllCharacteristics;
    private List<Long> fileAlignment;
    private List<Long> imageBase;
    private List<Long> loaderFlags;
    private List<Integer> magic;
    private List<Integer> majorImageVersion;
    private List<Byte> majorLinkerVersion;
    private List<Integer> majorOSVersion;
    private List<Integer> majorSubsystemVersion;
    private List<Integer> minorImageVersion;
    private List<Byte> minorLinkerVersion;
    private List<Integer> minorOSVersion;
    private List<Integer> minorSubsystemVersion;
    private List<Long> numberOfRVAAndSizes;
    private List<Long> sectionAlignment;
    private List<Long> sizeOfCode;
    private List<Long> sizeOfHeaders;
    private List<Long> sizeOfHeapCommit;
    private List<Long> sizeOfHeapReserve;
    private List<Long> sizeOfImage;
    private List<Long> sizeOfInitializedData;
    private List<Long> sizeOfStackCommit;
    private List<Long> sizeOfStackReserve;
    private List<Long> sizeOfUninitializedData;
    private List<Integer> subsystem;
    private List<Long> win32VersionValue;

    public WindowsPEOptionalHeader() {
        this.addressOfEntryPoint = new ArrayList<>();
        this.baseOfCode = new ArrayList<>();
        this.checksum = new ArrayList<>();
        this.dllCharacteristics = new ArrayList<>();
        this.fileAlignment = new ArrayList<>();
        this.imageBase = new ArrayList<>();
        this.loaderFlags = new ArrayList<>();
        this.magic = new ArrayList<>();
        this.majorImageVersion = new ArrayList<>();
        this.majorLinkerVersion = new ArrayList<>();
        this.majorOSVersion = new ArrayList<>();
        this.majorSubsystemVersion = new ArrayList<>();
        this.minorImageVersion = new ArrayList<>();
        this.minorLinkerVersion = new ArrayList<>();
        this.minorOSVersion = new ArrayList<>();
        this.minorSubsystemVersion = new ArrayList<>();
        this.numberOfRVAAndSizes = new ArrayList<>();
        this.sectionAlignment = new ArrayList<>();
        this.sizeOfCode = new ArrayList<>();
        this.sizeOfHeaders = new ArrayList<>();
        this.sizeOfHeapCommit = new ArrayList<>();
        this.sizeOfHeapReserve = new ArrayList<>();
        this.sizeOfImage = new ArrayList<>();
        this.sizeOfInitializedData = new ArrayList<>();
        this.sizeOfStackCommit = new ArrayList<>();
        this.sizeOfStackReserve = new ArrayList<>();
        this.sizeOfUninitializedData = new ArrayList<>();
        this.subsystem = new ArrayList<>();
        this.win32VersionValue = new ArrayList<>();
    }

    public List<Long> getAddressOfEntryPoint() { return this.addressOfEntryPoint; }
    public WindowsPEOptionalHeader setAddressOfEntryPoint(List<Long> value) { this.addressOfEntryPoint = value; return this; }

    public List<Long> getBaseOfCode() { return this.baseOfCode; }
    public WindowsPEOptionalHeader setBaseOfCode(List<Long> value) { this.baseOfCode = value; return this; }

    public List<Long> getChecksum() { return this.checksum; }
    public WindowsPEOptionalHeader setChecksum(List<Long> value) { this.checksum = value; return this; }

    public List<Integer> getDllCharacteristics() { return this.dllCharacteristics; }
    public WindowsPEOptionalHeader setDllCharacteristics(List<Integer> value) { this.dllCharacteristics = value; return this; }

    public List<Long> getFileAlignment() { return this.fileAlignment; }
    public WindowsPEOptionalHeader setFileAlignment(List<Long> value) { this.fileAlignment = value; return this; }

    public List<Long> getImageBase() { return this.imageBase; }
    public WindowsPEOptionalHeader setImageBase(List<Long> value) { this.imageBase = value; return this; }

    public List<Long> getLoaderFlags() { return this.loaderFlags; }
    public WindowsPEOptionalHeader setLoaderFlags(List<Long> value) { this.loaderFlags = value; return this; }

    public List<Integer> getMagic() { return this.magic; }
    public WindowsPEOptionalHeader setMagic(List<Integer> value) { this.magic = value; return this; }

    public List<Integer> getMajorImageVersion() { return this.majorImageVersion; }
    public WindowsPEOptionalHeader setMajorImageVersion(List<Integer> value) { this.majorImageVersion = value; return this; }

    public List<Byte> getMajorLinkerVersion() { return this.majorLinkerVersion; }
    public WindowsPEOptionalHeader setMajorLinkerVersion(List<Byte> value) { this.majorLinkerVersion = value; return this; }

    public List<Integer> getMajorOSVersion() { return this.majorOSVersion; }
    public WindowsPEOptionalHeader setMajorOSVersion(List<Integer> value) { this.majorOSVersion = value; return this; }

    public List<Integer> getMajorSubsystemVersion() { return this.majorSubsystemVersion; }
    public WindowsPEOptionalHeader setMajorSubsystemVersion(List<Integer> value) { this.majorSubsystemVersion = value; return this; }

    public List<Integer> getMinorImageVersion() { return this.minorImageVersion; }
    public WindowsPEOptionalHeader setMinorImageVersion(List<Integer> value) { this.minorImageVersion = value; return this; }

    public List<Byte> getMinorLinkerVersion() { return this.minorLinkerVersion; }
    public WindowsPEOptionalHeader setMinorLinkerVersion(List<Byte> value) { this.minorLinkerVersion = value; return this; }

    public List<Integer> getMinorOSVersion() { return this.minorOSVersion; }
    public WindowsPEOptionalHeader setMinorOSVersion(List<Integer> value) { this.minorOSVersion = value; return this; }

    public List<Integer> getMinorSubsystemVersion() { return this.minorSubsystemVersion; }
    public WindowsPEOptionalHeader setMinorSubsystemVersion(List<Integer> value) { this.minorSubsystemVersion = value; return this; }

    public List<Long> getNumberOfRVAAndSizes() { return this.numberOfRVAAndSizes; }
    public WindowsPEOptionalHeader setNumberOfRVAAndSizes(List<Long> value) { this.numberOfRVAAndSizes = value; return this; }

    public List<Long> getSectionAlignment() { return this.sectionAlignment; }
    public WindowsPEOptionalHeader setSectionAlignment(List<Long> value) { this.sectionAlignment = value; return this; }

    public List<Long> getSizeOfCode() { return this.sizeOfCode; }
    public WindowsPEOptionalHeader setSizeOfCode(List<Long> value) { this.sizeOfCode = value; return this; }

    public List<Long> getSizeOfHeaders() { return this.sizeOfHeaders; }
    public WindowsPEOptionalHeader setSizeOfHeaders(List<Long> value) { this.sizeOfHeaders = value; return this; }

    public List<Long> getSizeOfHeapCommit() { return this.sizeOfHeapCommit; }
    public WindowsPEOptionalHeader setSizeOfHeapCommit(List<Long> value) { this.sizeOfHeapCommit = value; return this; }

    public List<Long> getSizeOfHeapReserve() { return this.sizeOfHeapReserve; }
    public WindowsPEOptionalHeader setSizeOfHeapReserve(List<Long> value) { this.sizeOfHeapReserve = value; return this; }

    public List<Long> getSizeOfImage() { return this.sizeOfImage; }
    public WindowsPEOptionalHeader setSizeOfImage(List<Long> value) { this.sizeOfImage = value; return this; }

    public List<Long> getSizeOfInitializedData() { return this.sizeOfInitializedData; }
    public WindowsPEOptionalHeader setSizeOfInitializedData(List<Long> value) { this.sizeOfInitializedData = value; return this; }

    public List<Long> getSizeOfStackCommit() { return this.sizeOfStackCommit; }
    public WindowsPEOptionalHeader setSizeOfStackCommit(List<Long> value) { this.sizeOfStackCommit = value; return this; }

    public List<Long> getSizeOfStackReserve() { return this.sizeOfStackReserve; }
    public WindowsPEOptionalHeader setSizeOfStackReserve(List<Long> value) { this.sizeOfStackReserve = value; return this; }

    public List<Long> getSizeOfUninitializedData() { return this.sizeOfUninitializedData; }
    public WindowsPEOptionalHeader setSizeOfUninitializedData(List<Long> value) { this.sizeOfUninitializedData = value; return this; }

    public List<Integer> getSubsystem() { return this.subsystem; }
    public WindowsPEOptionalHeader setSubsystem(List<Integer> value) { this.subsystem = value; return this; }

    public List<Long> getWin32VersionValue() { return this.win32VersionValue; }
    public WindowsPEOptionalHeader setWin32VersionValue(List<Long> value) { this.win32VersionValue = value; return this; }

}