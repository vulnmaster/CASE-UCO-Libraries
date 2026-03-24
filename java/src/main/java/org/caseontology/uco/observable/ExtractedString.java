// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;

/** An extracted string is a grouping of characteristics unique to a series of characters pulled from an observable object. */
public class ExtractedString extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ExtractedString";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private byte[] byteStringValue;
    private String encoding;
    private String englishTranslation;
    private String language;
    private Long length;
    private String stringValue;

    public ExtractedString() {
    }

    public byte[] getByteStringValue() { return this.byteStringValue; }
    public ExtractedString setByteStringValue(byte[] value) { this.byteStringValue = value; return this; }

    public String getEncoding() { return this.encoding; }
    public ExtractedString setEncoding(String value) { this.encoding = value; return this; }

    public String getEnglishTranslation() { return this.englishTranslation; }
    public ExtractedString setEnglishTranslation(String value) { this.englishTranslation = value; return this; }

    public String getLanguage() { return this.language; }
    public ExtractedString setLanguage(String value) { this.language = value; return this; }

    public Long getLength() { return this.length; }
    public ExtractedString setLength(Long value) { this.length = value; return this; }

    public String getStringValue() { return this.stringValue; }
    public ExtractedString setStringValue(String value) { this.stringValue = value; return this; }

}