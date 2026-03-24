// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A UNIX process facet is a grouping of characteristics unique to an instance of a computer program executed on a UNIX operating system. */
public class UNIXProcessFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/UNIXProcessFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<Long> openFileDescriptor;
    private List<Long> ruid;

    public UNIXProcessFacet() {
        this.openFileDescriptor = new ArrayList<>();
        this.ruid = new ArrayList<>();
    }

    public List<Long> getOpenFileDescriptor() { return this.openFileDescriptor; }
    public UNIXProcessFacet setOpenFileDescriptor(List<Long> value) { this.openFileDescriptor = value; return this; }

    public List<Long> getRuid() { return this.ruid; }
    public UNIXProcessFacet setRuid(List<Long> value) { this.ruid = value; return this; }

}