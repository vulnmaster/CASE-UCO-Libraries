// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A Windows service facet is a grouping of characteristics unique to a specific Windows service (a computer program that operates in the background of a Windows operating system, similar to the way a UN */
public class WindowsServiceFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsServiceFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> descriptions;
    private String displayName;
    private String groupName;
    private String serviceName;
    private String serviceStatus;
    private String serviceType;
    private String startCommandLine;
    private String startType;

    public WindowsServiceFacet() {
        this.descriptions = new ArrayList<>();
    }

    public List<String> getDescriptions() { return this.descriptions; }
    public WindowsServiceFacet setDescriptions(List<String> value) { this.descriptions = value; return this; }

    public String getDisplayName() { return this.displayName; }
    public WindowsServiceFacet setDisplayName(String value) { this.displayName = value; return this; }

    public String getGroupName() { return this.groupName; }
    public WindowsServiceFacet setGroupName(String value) { this.groupName = value; return this; }

    public String getServiceName() { return this.serviceName; }
    public WindowsServiceFacet setServiceName(String value) { this.serviceName = value; return this; }

    public String getServiceStatus() { return this.serviceStatus; }
    public WindowsServiceFacet setServiceStatus(String value) { this.serviceStatus = value; return this; }

    public String getServiceType() { return this.serviceType; }
    public WindowsServiceFacet setServiceType(String value) { this.serviceType = value; return this; }

    public String getStartCommandLine() { return this.startCommandLine; }
    public WindowsServiceFacet setStartCommandLine(String value) { this.startCommandLine = value; return this; }

    public String getStartType() { return this.startType; }
    public WindowsServiceFacet setStartType(String value) { this.startType = value; return this; }

}