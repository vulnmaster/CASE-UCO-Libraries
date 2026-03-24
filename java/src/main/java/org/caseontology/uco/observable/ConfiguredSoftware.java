// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A ConfiguredSoftware is a Software that is known to be configured to run in a more specified manner than some unconfigured or less-configured Software. */
public class ConfiguredSoftware extends Software {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ConfiguredSoftware";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Software isConfigurationOf;
    private Configuration usesConfiguration;

    public ConfiguredSoftware() {
    }

    public Software getIsConfigurationOf() { return this.isConfigurationOf; }
    public ConfiguredSoftware setIsConfigurationOf(Software value) { this.isConfigurationOf = value; return this; }

    public Configuration getUsesConfiguration() { return this.usesConfiguration; }
    public ConfiguredSoftware setUsesConfiguration(Configuration value) { this.usesConfiguration = value; return this; }

}