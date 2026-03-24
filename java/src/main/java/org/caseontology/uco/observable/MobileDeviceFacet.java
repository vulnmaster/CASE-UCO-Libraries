// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A mobile device facet is a grouping of characteristics unique to a portable computing device. [based on https://www.lexico.com/definition/mobile_device] */
public class MobileDeviceFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/MobileDeviceFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String eSN;
    private List<String> iMEI;
    private String bluetoothDeviceName;
    private java.time.ZonedDateTime clockSetting;
    private String keypadUnlockCode;
    private Boolean mockLocationsAllowed;
    private String network;
    private java.time.ZonedDateTime phoneActivationTime;
    private Long storageCapacityInBytes;

    public MobileDeviceFacet() {
        this.iMEI = new ArrayList<>();
    }

    public String getESN() { return this.eSN; }
    public MobileDeviceFacet setESN(String value) { this.eSN = value; return this; }

    public List<String> getIMEI() { return this.iMEI; }
    public MobileDeviceFacet setIMEI(List<String> value) { this.iMEI = value; return this; }

    public String getBluetoothDeviceName() { return this.bluetoothDeviceName; }
    public MobileDeviceFacet setBluetoothDeviceName(String value) { this.bluetoothDeviceName = value; return this; }

    public java.time.ZonedDateTime getClockSetting() { return this.clockSetting; }
    public MobileDeviceFacet setClockSetting(java.time.ZonedDateTime value) { this.clockSetting = value; return this; }

    public String getKeypadUnlockCode() { return this.keypadUnlockCode; }
    public MobileDeviceFacet setKeypadUnlockCode(String value) { this.keypadUnlockCode = value; return this; }

    public Boolean getMockLocationsAllowed() { return this.mockLocationsAllowed; }
    public MobileDeviceFacet setMockLocationsAllowed(Boolean value) { this.mockLocationsAllowed = value; return this; }

    public String getNetwork() { return this.network; }
    public MobileDeviceFacet setNetwork(String value) { this.network = value; return this; }

    public java.time.ZonedDateTime getPhoneActivationTime() { return this.phoneActivationTime; }
    public MobileDeviceFacet setPhoneActivationTime(java.time.ZonedDateTime value) { this.phoneActivationTime = value; return this; }

    public Long getStorageCapacityInBytes() { return this.storageCapacityInBytes; }
    public MobileDeviceFacet setStorageCapacityInBytes(Long value) { this.storageCapacityInBytes = value; return this; }

}