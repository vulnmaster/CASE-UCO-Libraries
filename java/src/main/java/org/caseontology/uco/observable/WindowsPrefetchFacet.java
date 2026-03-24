// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A Windows prefetch facet is a grouping of characteristics unique to entries in the Windows prefetch file (used to speed up application startup starting with Windows XP). */
public class WindowsPrefetchFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/WindowsPrefetchFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<ObservableObject> accessedDirectory;
    private List<ObservableObject> accessedFile;
    private String applicationFileName;
    private java.time.ZonedDateTime firstRun;
    private java.time.ZonedDateTime lastRun;
    private String prefetchHash;
    private Long timesExecuted;
    private ObservableObject volume;

    public WindowsPrefetchFacet() {
        this.accessedDirectory = new ArrayList<>();
        this.accessedFile = new ArrayList<>();
    }

    public List<ObservableObject> getAccessedDirectory() { return this.accessedDirectory; }
    public WindowsPrefetchFacet setAccessedDirectory(List<ObservableObject> value) { this.accessedDirectory = value; return this; }

    public List<ObservableObject> getAccessedFile() { return this.accessedFile; }
    public WindowsPrefetchFacet setAccessedFile(List<ObservableObject> value) { this.accessedFile = value; return this; }

    public String getApplicationFileName() { return this.applicationFileName; }
    public WindowsPrefetchFacet setApplicationFileName(String value) { this.applicationFileName = value; return this; }

    public java.time.ZonedDateTime getFirstRun() { return this.firstRun; }
    public WindowsPrefetchFacet setFirstRun(java.time.ZonedDateTime value) { this.firstRun = value; return this; }

    public java.time.ZonedDateTime getLastRun() { return this.lastRun; }
    public WindowsPrefetchFacet setLastRun(java.time.ZonedDateTime value) { this.lastRun = value; return this; }

    public String getPrefetchHash() { return this.prefetchHash; }
    public WindowsPrefetchFacet setPrefetchHash(String value) { this.prefetchHash = value; return this; }

    public Long getTimesExecuted() { return this.timesExecuted; }
    public WindowsPrefetchFacet setTimesExecuted(Long value) { this.timesExecuted = value; return this; }

    public ObservableObject getVolume() { return this.volume; }
    public WindowsPrefetchFacet setVolume(ObservableObject value) { this.volume = value; return this; }

}