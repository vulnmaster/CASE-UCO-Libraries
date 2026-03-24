// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A library facet is a grouping of characteristics unique to a suite of data and programming code that is used to develop software programs and applications. [based on https://www.techopedia.com/definit */
public class LibraryFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/LibraryFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String libraryType;

    public LibraryFacet() {
    }

    public String getLibraryType() { return this.libraryType; }
    public LibraryFacet setLibraryType(String value) { this.libraryType = value; return this; }

}