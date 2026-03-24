// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.types.Dictionary;

/** A process facet is a grouping of characteristics unique to an instance of a computer program executed on an operating system. */
public class ProcessFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ProcessFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> arguments;
    private ObservableObject binary;
    private ObservableObject creatorUser;
    private String currentWorkingDirectory;
    private Dictionary environmentVariables;
    private Long exitStatus;
    private java.time.ZonedDateTime exitTime;
    private Boolean isHidden;
    private java.time.ZonedDateTime observableCreatedTime;
    private ObservableObject parent;
    private Long pid;
    private String status;

    public ProcessFacet() {
        this.arguments = new ArrayList<>();
    }

    public List<String> getArguments() { return this.arguments; }
    public ProcessFacet setArguments(List<String> value) { this.arguments = value; return this; }

    public ObservableObject getBinary() { return this.binary; }
    public ProcessFacet setBinary(ObservableObject value) { this.binary = value; return this; }

    public ObservableObject getCreatorUser() { return this.creatorUser; }
    public ProcessFacet setCreatorUser(ObservableObject value) { this.creatorUser = value; return this; }

    public String getCurrentWorkingDirectory() { return this.currentWorkingDirectory; }
    public ProcessFacet setCurrentWorkingDirectory(String value) { this.currentWorkingDirectory = value; return this; }

    public Dictionary getEnvironmentVariables() { return this.environmentVariables; }
    public ProcessFacet setEnvironmentVariables(Dictionary value) { this.environmentVariables = value; return this; }

    public Long getExitStatus() { return this.exitStatus; }
    public ProcessFacet setExitStatus(Long value) { this.exitStatus = value; return this; }

    public java.time.ZonedDateTime getExitTime() { return this.exitTime; }
    public ProcessFacet setExitTime(java.time.ZonedDateTime value) { this.exitTime = value; return this; }

    public Boolean getIsHidden() { return this.isHidden; }
    public ProcessFacet setIsHidden(Boolean value) { this.isHidden = value; return this; }

    public java.time.ZonedDateTime getObservableCreatedTime() { return this.observableCreatedTime; }
    public ProcessFacet setObservableCreatedTime(java.time.ZonedDateTime value) { this.observableCreatedTime = value; return this; }

    public ObservableObject getParent() { return this.parent; }
    public ProcessFacet setParent(ObservableObject value) { this.parent = value; return this; }

    public Long getPid() { return this.pid; }
    public ProcessFacet setPid(Long value) { this.pid = value; return this; }

    public String getStatus() { return this.status; }
    public ProcessFacet setStatus(String value) { this.status = value; return this; }

}