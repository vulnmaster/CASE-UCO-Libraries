// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** An application facet is a grouping of characteristics unique to a particular software program designed for end users. */
public class ApplicationFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ApplicationFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String applicationIdentifier;
    private List<ApplicationVersion> installedVersionHistory;
    private Long numberOfLaunches;
    private ObservableObject operatingSystem;
    private String version;

    public ApplicationFacet() {
        this.installedVersionHistory = new ArrayList<>();
    }

    public String getApplicationIdentifier() { return this.applicationIdentifier; }
    public ApplicationFacet setApplicationIdentifier(String value) { this.applicationIdentifier = value; return this; }

    public List<ApplicationVersion> getInstalledVersionHistory() { return this.installedVersionHistory; }
    public ApplicationFacet setInstalledVersionHistory(List<ApplicationVersion> value) { this.installedVersionHistory = value; return this; }

    public Long getNumberOfLaunches() { return this.numberOfLaunches; }
    public ApplicationFacet setNumberOfLaunches(Long value) { this.numberOfLaunches = value; return this; }

    public ObservableObject getOperatingSystem() { return this.operatingSystem; }
    public ApplicationFacet setOperatingSystem(ObservableObject value) { this.operatingSystem = value; return this; }

    public String getVersion() { return this.version; }
    public ApplicationFacet setVersion(String value) { this.version = value; return this; }

}