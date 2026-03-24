// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.tool;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.configuration.Configuration;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A build information type is a grouping of characteristics that describe how a particular version of software was converted from source code to executable code. */
public class BuildInformationType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/tool/BuildInformationType";
    public static final String NAMESPACE_PREFIX = "uco-tool";

    private Configuration buildConfiguration;
    private String buildID;
    private String buildLabel;
    private String buildOutputLog;
    private String buildProject;
    private String buildScript;
    private BuildUtilityType buildUtility;
    private String buildVersion;
    private java.time.ZonedDateTime compilationDate;
    private List<CompilerType> compilers;
    private List<LibraryType> libraries;

    public BuildInformationType() {
        this.compilers = new ArrayList<>();
        this.libraries = new ArrayList<>();
    }

    public Configuration getBuildConfiguration() { return this.buildConfiguration; }
    public BuildInformationType setBuildConfiguration(Configuration value) { this.buildConfiguration = value; return this; }

    public String getBuildID() { return this.buildID; }
    public BuildInformationType setBuildID(String value) { this.buildID = value; return this; }

    public String getBuildLabel() { return this.buildLabel; }
    public BuildInformationType setBuildLabel(String value) { this.buildLabel = value; return this; }

    public String getBuildOutputLog() { return this.buildOutputLog; }
    public BuildInformationType setBuildOutputLog(String value) { this.buildOutputLog = value; return this; }

    public String getBuildProject() { return this.buildProject; }
    public BuildInformationType setBuildProject(String value) { this.buildProject = value; return this; }

    public String getBuildScript() { return this.buildScript; }
    public BuildInformationType setBuildScript(String value) { this.buildScript = value; return this; }

    public BuildUtilityType getBuildUtility() { return this.buildUtility; }
    public BuildInformationType setBuildUtility(BuildUtilityType value) { this.buildUtility = value; return this; }

    public String getBuildVersion() { return this.buildVersion; }
    public BuildInformationType setBuildVersion(String value) { this.buildVersion = value; return this; }

    public java.time.ZonedDateTime getCompilationDate() { return this.compilationDate; }
    public BuildInformationType setCompilationDate(java.time.ZonedDateTime value) { this.compilationDate = value; return this; }

    public List<CompilerType> getCompilers() { return this.compilers; }
    public BuildInformationType setCompilers(List<CompilerType> value) { this.compilers = value; return this; }

    public List<LibraryType> getLibraries() { return this.libraries; }
    public BuildInformationType setLibraries(List<LibraryType> value) { this.libraries = value; return this; }

}