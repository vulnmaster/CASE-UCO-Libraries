// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.tool;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** A library type is a grouping of characteristics unique to a collection of resources incorporated into the build of a software. */
public class LibraryType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/tool/LibraryType";
    public static final String NAMESPACE_PREFIX = "uco-tool";

    private String libraryName;
    private String libraryVersion;

    public LibraryType() {
    }

    public String getLibraryName() { return this.libraryName; }
    public LibraryType setLibraryName(String value) { this.libraryName = value; return this; }

    public String getLibraryVersion() { return this.libraryVersion; }
    public LibraryType setLibraryVersion(String value) { this.libraryVersion = value; return this; }

}