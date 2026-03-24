// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.configuration;

import java.util.ArrayList;
import java.util.List;

/** A configuration is a grouping of characteristics unique to a set of parameters or initial settings for the use of a tool, application, software, or other cyber object. */
public class Configuration extends UcoObject {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/configuration/Configuration";
    public static final String NAMESPACE_PREFIX = "uco-configuration";

    private List<ConfigurationEntry> configurationEntry;
    private List<Dependency> dependencies;
    private List<String> usageContextAssumptions;

    public Configuration() {
        this.configurationEntry = new ArrayList<>();
        this.dependencies = new ArrayList<>();
        this.usageContextAssumptions = new ArrayList<>();
    }

    public List<ConfigurationEntry> getConfigurationEntry() { return this.configurationEntry; }
    public Configuration setConfigurationEntry(List<ConfigurationEntry> value) { this.configurationEntry = value; return this; }

    public List<Dependency> getDependencies() { return this.dependencies; }
    public Configuration setDependencies(List<Dependency> value) { this.dependencies = value; return this; }

    public List<String> getUsageContextAssumptions() { return this.usageContextAssumptions; }
    public Configuration setUsageContextAssumptions(List<String> value) { this.usageContextAssumptions = value; return this; }

}