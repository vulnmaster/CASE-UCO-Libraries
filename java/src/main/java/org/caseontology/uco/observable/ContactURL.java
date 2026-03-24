// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A contact URL is a grouping of characteristics unique to details for contacting a contact entity by Uniform Resource Locator (URL). */
public class ContactURL extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/ContactURL";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private List<String> contactURLScope;
    private ObservableObject url;

    public ContactURL() {
        this.contactURLScope = new ArrayList<>();
    }

    public List<String> getContactURLScope() { return this.contactURLScope; }
    public ContactURL setContactURLScope(List<String> value) { this.contactURLScope = value; return this; }

    public ObservableObject getUrl() { return this.url; }
    public ContactURL setUrl(ObservableObject value) { this.url = value; return this; }

}