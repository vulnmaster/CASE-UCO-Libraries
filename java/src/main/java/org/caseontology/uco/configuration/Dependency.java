// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.configuration;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A dependency is a grouping of characteristics unique to something that a tool or other software relies on to function as intended. */
public class Dependency extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/configuration/Dependency";
    public static final String NAMESPACE_PREFIX = "uco-configuration";

    private String dependencyDescription;
    private String dependencyType;

    public Dependency() {
    }

    public String getDependencyDescription() { return this.dependencyDescription; }
    public Dependency setDependencyDescription(String value) { this.dependencyDescription = value; return this; }

    public String getDependencyType() { return this.dependencyType; }
    public Dependency setDependencyType(String value) { this.dependencyType = value; return this; }

}