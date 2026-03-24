// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.identity.Identity;

/** A Windows computer specification facet is a grouping of characteristics unique to the hardware and software of a programmable electronic device that can store, retrieve, and process data running a Mic */
public class WindowsComputerSpecificationFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsComputerSpecificationFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> domain;
    private List<GlobalFlagType> globalFlagList;
    private java.time.ZonedDateTime lastShutdownDate;
    private String msProductID;
    private String msProductName;
    private String netBIOSName;
    private java.time.ZonedDateTime osInstallDate;
    private java.time.ZonedDateTime osLastUpgradeDate;
    private Identity registeredOrganization;
    private Identity registeredOwner;
    private ObservableObject windowsDirectory;
    private ObservableObject windowsSystemDirectory;
    private ObservableObject windowsTempDirectory;

    public WindowsComputerSpecificationFacet() {
        this.domain = new ArrayList<>();
        this.globalFlagList = new ArrayList<>();
    }

    public List<String> getDomain() { return this.domain; }
    public WindowsComputerSpecificationFacet setDomain(List<String> value) { this.domain = value; return this; }

    public List<GlobalFlagType> getGlobalFlagList() { return this.globalFlagList; }
    public WindowsComputerSpecificationFacet setGlobalFlagList(List<GlobalFlagType> value) { this.globalFlagList = value; return this; }

    public java.time.ZonedDateTime getLastShutdownDate() { return this.lastShutdownDate; }
    public WindowsComputerSpecificationFacet setLastShutdownDate(java.time.ZonedDateTime value) { this.lastShutdownDate = value; return this; }

    public String getMsProductID() { return this.msProductID; }
    public WindowsComputerSpecificationFacet setMsProductID(String value) { this.msProductID = value; return this; }

    public String getMsProductName() { return this.msProductName; }
    public WindowsComputerSpecificationFacet setMsProductName(String value) { this.msProductName = value; return this; }

    public String getNetBIOSName() { return this.netBIOSName; }
    public WindowsComputerSpecificationFacet setNetBIOSName(String value) { this.netBIOSName = value; return this; }

    public java.time.ZonedDateTime getOsInstallDate() { return this.osInstallDate; }
    public WindowsComputerSpecificationFacet setOsInstallDate(java.time.ZonedDateTime value) { this.osInstallDate = value; return this; }

    public java.time.ZonedDateTime getOsLastUpgradeDate() { return this.osLastUpgradeDate; }
    public WindowsComputerSpecificationFacet setOsLastUpgradeDate(java.time.ZonedDateTime value) { this.osLastUpgradeDate = value; return this; }

    public Identity getRegisteredOrganization() { return this.registeredOrganization; }
    public WindowsComputerSpecificationFacet setRegisteredOrganization(Identity value) { this.registeredOrganization = value; return this; }

    public Identity getRegisteredOwner() { return this.registeredOwner; }
    public WindowsComputerSpecificationFacet setRegisteredOwner(Identity value) { this.registeredOwner = value; return this; }

    public ObservableObject getWindowsDirectory() { return this.windowsDirectory; }
    public WindowsComputerSpecificationFacet setWindowsDirectory(ObservableObject value) { this.windowsDirectory = value; return this; }

    public ObservableObject getWindowsSystemDirectory() { return this.windowsSystemDirectory; }
    public WindowsComputerSpecificationFacet setWindowsSystemDirectory(ObservableObject value) { this.windowsSystemDirectory = value; return this; }

    public ObservableObject getWindowsTempDirectory() { return this.windowsTempDirectory; }
    public WindowsComputerSpecificationFacet setWindowsTempDirectory(ObservableObject value) { this.windowsTempDirectory = value; return this; }

}