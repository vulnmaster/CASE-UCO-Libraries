// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;
import org.caseontology.uco.types.ControlledDictionary;

/** An EXIF (exchangeable image file format) facet is a grouping of characteristics unique to the formats for images, sound, and ancillary tags used by digital cameras (including smartphones), scanners an */
public class EXIFFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/EXIFFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<ControlledDictionary> exifData;

    public EXIFFacet() {
        this.exifData = new ArrayList<>();
    }

    public List<ControlledDictionary> getExifData() { return this.exifData; }
    public EXIFFacet setExifData(List<ControlledDictionary> value) { this.exifData = value; return this; }

}