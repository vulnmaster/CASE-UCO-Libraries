// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A Windows PE file header is a grouping of characteristics unique to the 'header' of a Windows PE (Portable Executable) file, consisting of a collection of metadata about the overall nature and structu */
public class WindowsPEFileHeader extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPEFileHeader";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private java.time.ZonedDateTime timeDateStamp;

    public WindowsPEFileHeader() {
    }

    public java.time.ZonedDateTime getTimeDateStamp() { return this.timeDateStamp; }
    public WindowsPEFileHeader setTimeDateStamp(java.time.ZonedDateTime value) { this.timeDateStamp = value; return this; }

}