// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A Windows registry value is a grouping of characteristics unique to a particular value within a Windows registry (a hierarchical database that stores low-level settings for the Microsoft Windows opera */
public class WindowsRegistryValue extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsRegistryValue";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String name;
    private String data;
    private String dataType;

    public WindowsRegistryValue() {
    }

    public String getName() { return this.name; }
    public WindowsRegistryValue setName(String value) { this.name = value; return this; }

    public String getData() { return this.data; }
    public WindowsRegistryValue setData(String value) { this.data = value; return this; }

    public String getDataType() { return this.dataType; }
    public WindowsRegistryValue setDataType(String value) { this.dataType = value; return this; }

}