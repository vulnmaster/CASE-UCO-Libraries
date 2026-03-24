// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An environment variable is a grouping of characteristics unique to a dynamic-named value that can affect the way running processes will behave on a computer. [based on https://en.wikipedia.org/wiki/En */
public class EnvironmentVariable extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/EnvironmentVariable";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String name;
    private String value;

    public EnvironmentVariable() {
    }

    public String getName() { return this.name; }
    public EnvironmentVariable setName(String value) { this.name = value; return this; }

    public String getValue() { return this.value; }
    public EnvironmentVariable setValue(String value) { this.value = value; return this; }

}