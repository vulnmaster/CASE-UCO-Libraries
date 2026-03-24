// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.tool;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A compiler type is a grouping of characteristics unique to a specific program that translates computer code written in one programming language (the source language) into another language (the target  */
public class CompilerType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/tool/CompilerType";
    public static final String NAMESPACE_PREFIX = "uco-tool";

    private String compilerInformalDescription;
    private String cpeid;
    private String swid;

    public CompilerType() {
    }

    public String getCompilerInformalDescription() { return this.compilerInformalDescription; }
    public CompilerType setCompilerInformalDescription(String value) { this.compilerInformalDescription = value; return this; }

    public String getCpeid() { return this.cpeid; }
    public CompilerType setCpeid(String value) { this.cpeid = value; return this; }

    public String getSwid() { return this.swid; }
    public CompilerType setSwid(String value) { this.swid = value; return this; }

}