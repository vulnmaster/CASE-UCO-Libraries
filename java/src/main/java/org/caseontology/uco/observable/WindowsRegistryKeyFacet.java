// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A Windows registry key facet is a grouping of characteristics unique to a particular key within a Windows registry (A hierarchical database that stores low-level settings for the Microsoft Windows ope */
public class WindowsRegistryKeyFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsRegistryKeyFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ObservableObject creator;
    private String key;
    private java.time.ZonedDateTime modifiedTime;
    private Long numberOfSubkeys;
    private List<WindowsRegistryValue> registryValues;

    public WindowsRegistryKeyFacet() {
        this.registryValues = new ArrayList<>();
    }

    public ObservableObject getCreator() { return this.creator; }
    public WindowsRegistryKeyFacet setCreator(ObservableObject value) { this.creator = value; return this; }

    public String getKey() { return this.key; }
    public WindowsRegistryKeyFacet setKey(String value) { this.key = value; return this; }

    public java.time.ZonedDateTime getModifiedTime() { return this.modifiedTime; }
    public WindowsRegistryKeyFacet setModifiedTime(java.time.ZonedDateTime value) { this.modifiedTime = value; return this; }

    public Long getNumberOfSubkeys() { return this.numberOfSubkeys; }
    public WindowsRegistryKeyFacet setNumberOfSubkeys(Long value) { this.numberOfSubkeys = value; return this; }

    public List<WindowsRegistryValue> getRegistryValues() { return this.registryValues; }
    public WindowsRegistryKeyFacet setRegistryValues(List<WindowsRegistryValue> value) { this.registryValues = value; return this; }

}