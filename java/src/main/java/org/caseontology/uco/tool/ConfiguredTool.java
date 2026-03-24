// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.tool;

import java.util.ArrayList;
import java.util.List;

/** A ConfiguredTool is a Tool that is known to be configured to run in a more specified manner than some unconfigured or less-configured Tool. */
public class ConfiguredTool extends Tool {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/tool/ConfiguredTool";
    public static final String NAMESPACE_PREFIX = "uco-tool";

    private Tool isConfigurationOf;
    private Configuration usesConfiguration;

    public ConfiguredTool() {
    }

    public Tool getIsConfigurationOf() { return this.isConfigurationOf; }
    public ConfiguredTool setIsConfigurationOf(Tool value) { this.isConfigurationOf = value; return this; }

    public Configuration getUsesConfiguration() { return this.usesConfiguration; }
    public ConfiguredTool setUsesConfiguration(Configuration value) { this.usesConfiguration = value; return this; }

}