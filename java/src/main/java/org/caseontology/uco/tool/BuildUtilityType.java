// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.tool;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A build utility type characterizes the tool used to convert from source code to executable code for a particular version of software. */
public class BuildUtilityType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/tool/BuildUtilityType";
    public static final String NAMESPACE_PREFIX = "uco-tool";

    private String buildUtilityName;
    private String cpeid;
    private String swid;

    public BuildUtilityType() {
    }

    public String getBuildUtilityName() { return this.buildUtilityName; }
    public BuildUtilityType setBuildUtilityName(String value) { this.buildUtilityName = value; return this; }

    public String getCpeid() { return this.cpeid; }
    public BuildUtilityType setCpeid(String value) { this.cpeid = value; return this; }

    public String getSwid() { return this.swid; }
    public BuildUtilityType setSwid(String value) { this.swid = value; return this; }

}