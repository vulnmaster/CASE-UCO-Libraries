// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** An Android device facet is a grouping of characteristics unique to an Android device. [based on https://en.wikipedia.org/wiki/Android_(operating_system)] */
public class AndroidDeviceFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/AndroidDeviceFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String androidFingerprint;
    private byte[] androidID;
    private String androidVersion;
    private Boolean isADBRootEnabled;
    private Boolean isSURootEnabled;

    public AndroidDeviceFacet() {
    }

    public String getAndroidFingerprint() { return this.androidFingerprint; }
    public AndroidDeviceFacet setAndroidFingerprint(String value) { this.androidFingerprint = value; return this; }

    public byte[] getAndroidID() { return this.androidID; }
    public AndroidDeviceFacet setAndroidID(byte[] value) { this.androidID = value; return this; }

    public String getAndroidVersion() { return this.androidVersion; }
    public AndroidDeviceFacet setAndroidVersion(String value) { this.androidVersion = value; return this; }

    public Boolean getIsADBRootEnabled() { return this.isADBRootEnabled; }
    public AndroidDeviceFacet setIsADBRootEnabled(Boolean value) { this.isADBRootEnabled = value; return this; }

    public Boolean getIsSURootEnabled() { return this.isSURootEnabled; }
    public AndroidDeviceFacet setIsSURootEnabled(Boolean value) { this.isSURootEnabled = value; return this; }

}