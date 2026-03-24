// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An application version is a grouping of characteristics unique to a particular software program version. */
public class ApplicationVersion extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ApplicationVersion";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private java.time.ZonedDateTime installDate;
    private java.time.ZonedDateTime uninstallDate;
    private String version;

    public ApplicationVersion() {
    }

    public java.time.ZonedDateTime getInstallDate() { return this.installDate; }
    public ApplicationVersion setInstallDate(java.time.ZonedDateTime value) { this.installDate = value; return this; }

    public java.time.ZonedDateTime getUninstallDate() { return this.uninstallDate; }
    public ApplicationVersion setUninstallDate(java.time.ZonedDateTime value) { this.uninstallDate = value; return this; }

    public String getVersion() { return this.version; }
    public ApplicationVersion setVersion(String value) { this.version = value; return this; }

}