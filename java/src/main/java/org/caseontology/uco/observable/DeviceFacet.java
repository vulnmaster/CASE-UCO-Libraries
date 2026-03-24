// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A device facet is a grouping of characteristics unique to a piece of equipment or a mechanism designed to serve a special purpose or perform a special function. [based on https://www.merriam-webster.c */
public class DeviceFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/DeviceFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String cpeid;
    private String deviceType;
    private Identity manufacturer;
    private String model;
    private String serialNumber;

    public DeviceFacet() {
    }

    public String getCpeid() { return this.cpeid; }
    public DeviceFacet setCpeid(String value) { this.cpeid = value; return this; }

    public String getDeviceType() { return this.deviceType; }
    public DeviceFacet setDeviceType(String value) { this.deviceType = value; return this; }

    public Identity getManufacturer() { return this.manufacturer; }
    public DeviceFacet setManufacturer(Identity value) { this.manufacturer = value; return this; }

    public String getModel() { return this.model; }
    public DeviceFacet setModel(String value) { this.model = value; return this; }

    public String getSerialNumber() { return this.serialNumber; }
    public DeviceFacet setSerialNumber(String value) { this.serialNumber = value; return this; }

}