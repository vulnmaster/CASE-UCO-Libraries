// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.configuration;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;
import org.caseontology.uco.core.UcoObject;

/** A configuration entry is a grouping of characteristics unique to a particular parameter or initial setting for the use of a tool, application, software, or other cyber object. */
public class ConfigurationEntry extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/configuration/ConfigurationEntry";
    public static final String NAMESPACE_PREFIX = "uco-configuration";

    private String itemDescription;
    private String itemName;
    private List<UcoObject> itemObject;
    private String itemType;
    private List<String> itemValue;

    public ConfigurationEntry() {
        this.itemObject = new ArrayList<>();
        this.itemValue = new ArrayList<>();
    }

    public String getItemDescription() { return this.itemDescription; }
    public ConfigurationEntry setItemDescription(String value) { this.itemDescription = value; return this; }

    public String getItemName() { return this.itemName; }
    public ConfigurationEntry setItemName(String value) { this.itemName = value; return this; }

    public List<UcoObject> getItemObject() { return this.itemObject; }
    public ConfigurationEntry setItemObject(List<UcoObject> value) { this.itemObject = value; return this; }

    public String getItemType() { return this.itemType; }
    public ConfigurationEntry setItemType(String value) { this.itemType = value; return this; }

    public List<String> getItemValue() { return this.itemValue; }
    public ConfigurationEntry setItemValue(List<String> value) { this.itemValue = value; return this; }

}