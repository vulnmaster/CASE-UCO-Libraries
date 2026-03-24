// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An image facet is a grouping of characteristics unique to a complete copy of a hard disk, memory, or other digital media. */
public class ImageFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ImageFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String imageType;

    public ImageFacet() {
    }

    public String getImageType() { return this.imageType; }
    public ImageFacet setImageType(String value) { this.imageType = value; return this; }

}