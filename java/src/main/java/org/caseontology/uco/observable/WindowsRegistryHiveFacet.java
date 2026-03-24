// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A Windows registry hive facet is a grouping of characteristics unique to a particular logical group of keys, subkeys, and values in a Windows registry (a hierarchical database that stores low-level se */
public class WindowsRegistryHiveFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsRegistryHiveFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String hiveType;

    public WindowsRegistryHiveFacet() {
    }

    public String getHiveType() { return this.hiveType; }
    public WindowsRegistryHiveFacet setHiveType(String value) { this.hiveType = value; return this; }

}