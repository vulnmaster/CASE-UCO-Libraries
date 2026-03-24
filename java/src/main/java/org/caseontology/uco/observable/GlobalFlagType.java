// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A global flag type is a grouping of characteristics unique to the Windows systemwide global variable named NtGlobalFlag that enables various internal debugging, tracing, and validation support in the  */
public class GlobalFlagType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/GlobalFlagType";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String abbreviation;
    private String destination;
    private List<byte[]> hexadecimalValue;
    private String symbolicName;

    public GlobalFlagType() {
        this.hexadecimalValue = new ArrayList<>();
    }

    public String getAbbreviation() { return this.abbreviation; }
    public GlobalFlagType setAbbreviation(String value) { this.abbreviation = value; return this; }

    public String getDestination() { return this.destination; }
    public GlobalFlagType setDestination(String value) { this.destination = value; return this; }

    public List<byte[]> getHexadecimalValue() { return this.hexadecimalValue; }
    public GlobalFlagType setHexadecimalValue(List<byte[]> value) { this.hexadecimalValue = value; return this; }

    public String getSymbolicName() { return this.symbolicName; }
    public GlobalFlagType setSymbolicName(String value) { this.symbolicName = value; return this; }

}