// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A UNIX volume facet is a grouping of characteristics unique to a single accessible storage area (volume) with a single UNIX file system. [based on https://en.wikipedia.org/wiki/Volume_(computing)] */
public class UNIXVolumeFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXVolumeFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String mountPoint;
    private String options;

    public UNIXVolumeFacet() {
    }

    public String getMountPoint() { return this.mountPoint; }
    public UNIXVolumeFacet setMountPoint(String value) { this.mountPoint = value; return this; }

    public String getOptions() { return this.options; }
    public UNIXVolumeFacet setOptions(String value) { this.options = value; return this; }

}