// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.tool;

import java.util.ArrayList;
import java.util.List;

/** A build facet is a grouping of characteristics unique to a particular version of a software. */
public class BuildFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/tool/BuildFacet";
    public static final String NAMESPACE_PREFIX = "uco-tool";

    private BuildInformationType buildInformation;

    public BuildFacet() {
    }

    public BuildInformationType getBuildInformation() { return this.buildInformation; }
    public BuildFacet setBuildInformation(BuildInformationType value) { this.buildInformation = value; return this; }

}