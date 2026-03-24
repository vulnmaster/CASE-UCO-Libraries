// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A Windows process facet is a grouping of characteristics unique to a program running on a Windows operating system. */
public class WindowsProcessFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsProcessFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Boolean aslrEnabled;
    private Boolean depEnabled;
    private String ownerSID;
    private String priority;
    private Dictionary startupInfo;
    private String windowTitle;

    public WindowsProcessFacet() {
    }

    public Boolean getAslrEnabled() { return this.aslrEnabled; }
    public WindowsProcessFacet setAslrEnabled(Boolean value) { this.aslrEnabled = value; return this; }

    public Boolean getDepEnabled() { return this.depEnabled; }
    public WindowsProcessFacet setDepEnabled(Boolean value) { this.depEnabled = value; return this; }

    public String getOwnerSID() { return this.ownerSID; }
    public WindowsProcessFacet setOwnerSID(String value) { this.ownerSID = value; return this; }

    public String getPriority() { return this.priority; }
    public WindowsProcessFacet setPriority(String value) { this.priority = value; return this; }

    public Dictionary getStartupInfo() { return this.startupInfo; }
    public WindowsProcessFacet setStartupInfo(Dictionary value) { this.startupInfo = value; return this; }

    public String getWindowTitle() { return this.windowTitle; }
    public WindowsProcessFacet setWindowTitle(String value) { this.windowTitle = value; return this; }

}