// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A computer specificaiton facet is a grouping of characteristics unique to the hardware and software of a programmable electronic device that can store, retrieve, and process data. [based on merriam-we */
public class ComputerSpecificationFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ComputerSpecificationFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long availableRam;
    private java.time.ZonedDateTime biosDate;
    private String biosManufacturer;
    private java.time.ZonedDateTime biosReleaseDate;
    private String biosSerialNumber;
    private String biosVersion;
    private String cpu;
    private String cpuFamily;
    private java.time.ZonedDateTime currentSystemDate;
    private String gpu;
    private String gpuFamily;
    private String hostname;
    private java.time.ZonedDateTime localTime;
    private List<ObservableObject> networkInterface;
    private String processorArchitecture;
    private java.time.ZonedDateTime systemTime;
    private String timezoneDST;
    private String timezoneStandard;
    private Long totalRam;
    private String uptime;

    public ComputerSpecificationFacet() {
        this.networkInterface = new ArrayList<>();
    }

    public Long getAvailableRam() { return this.availableRam; }
    public ComputerSpecificationFacet setAvailableRam(Long value) { this.availableRam = value; return this; }

    public java.time.ZonedDateTime getBiosDate() { return this.biosDate; }
    public ComputerSpecificationFacet setBiosDate(java.time.ZonedDateTime value) { this.biosDate = value; return this; }

    public String getBiosManufacturer() { return this.biosManufacturer; }
    public ComputerSpecificationFacet setBiosManufacturer(String value) { this.biosManufacturer = value; return this; }

    public java.time.ZonedDateTime getBiosReleaseDate() { return this.biosReleaseDate; }
    public ComputerSpecificationFacet setBiosReleaseDate(java.time.ZonedDateTime value) { this.biosReleaseDate = value; return this; }

    public String getBiosSerialNumber() { return this.biosSerialNumber; }
    public ComputerSpecificationFacet setBiosSerialNumber(String value) { this.biosSerialNumber = value; return this; }

    public String getBiosVersion() { return this.biosVersion; }
    public ComputerSpecificationFacet setBiosVersion(String value) { this.biosVersion = value; return this; }

    public String getCpu() { return this.cpu; }
    public ComputerSpecificationFacet setCpu(String value) { this.cpu = value; return this; }

    public String getCpuFamily() { return this.cpuFamily; }
    public ComputerSpecificationFacet setCpuFamily(String value) { this.cpuFamily = value; return this; }

    public java.time.ZonedDateTime getCurrentSystemDate() { return this.currentSystemDate; }
    public ComputerSpecificationFacet setCurrentSystemDate(java.time.ZonedDateTime value) { this.currentSystemDate = value; return this; }

    public String getGpu() { return this.gpu; }
    public ComputerSpecificationFacet setGpu(String value) { this.gpu = value; return this; }

    public String getGpuFamily() { return this.gpuFamily; }
    public ComputerSpecificationFacet setGpuFamily(String value) { this.gpuFamily = value; return this; }

    public String getHostname() { return this.hostname; }
    public ComputerSpecificationFacet setHostname(String value) { this.hostname = value; return this; }

    public java.time.ZonedDateTime getLocalTime() { return this.localTime; }
    public ComputerSpecificationFacet setLocalTime(java.time.ZonedDateTime value) { this.localTime = value; return this; }

    public List<ObservableObject> getNetworkInterface() { return this.networkInterface; }
    public ComputerSpecificationFacet setNetworkInterface(List<ObservableObject> value) { this.networkInterface = value; return this; }

    public String getProcessorArchitecture() { return this.processorArchitecture; }
    public ComputerSpecificationFacet setProcessorArchitecture(String value) { this.processorArchitecture = value; return this; }

    public java.time.ZonedDateTime getSystemTime() { return this.systemTime; }
    public ComputerSpecificationFacet setSystemTime(java.time.ZonedDateTime value) { this.systemTime = value; return this; }

    public String getTimezoneDST() { return this.timezoneDST; }
    public ComputerSpecificationFacet setTimezoneDST(String value) { this.timezoneDST = value; return this; }

    public String getTimezoneStandard() { return this.timezoneStandard; }
    public ComputerSpecificationFacet setTimezoneStandard(String value) { this.timezoneStandard = value; return this; }

    public Long getTotalRam() { return this.totalRam; }
    public ComputerSpecificationFacet setTotalRam(Long value) { this.totalRam = value; return this; }

    public String getUptime() { return this.uptime; }
    public ComputerSpecificationFacet setUptime(String value) { this.uptime = value; return this; }

}