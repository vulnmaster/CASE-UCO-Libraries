// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** An audio facet is a grouping of characteristics unique to a digital representation of sound. */
public class AudioFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/AudioFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String audioType;
    private Long bitRate;
    private Long duration;
    private String format;

    public AudioFacet() {
    }

    public String getAudioType() { return this.audioType; }
    public AudioFacet setAudioType(String value) { this.audioType = value; return this; }

    public Long getBitRate() { return this.bitRate; }
    public AudioFacet setBitRate(Long value) { this.bitRate = value; return this; }

    public Long getDuration() { return this.duration; }
    public AudioFacet setDuration(Long value) { this.duration = value; return this; }

    public String getFormat() { return this.format; }
    public AudioFacet setFormat(String value) { this.format = value; return this; }

}