// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A PDF file facet is a grouping of characteristics unique to a PDF (Portable Document Format) file. */
public class PDFFileFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/PDFFileFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private ControlledDictionary documentInformationDictionary;
    private Boolean isOptimized;
    private java.time.ZonedDateTime pdfCreationDate;
    private List<String> pdfId0;
    private String pdfId1;
    private java.time.ZonedDateTime pdfModDate;
    private String version;

    public PDFFileFacet() {
        this.pdfId0 = new ArrayList<>();
    }

    public ControlledDictionary getDocumentInformationDictionary() { return this.documentInformationDictionary; }
    public PDFFileFacet setDocumentInformationDictionary(ControlledDictionary value) { this.documentInformationDictionary = value; return this; }

    public Boolean getIsOptimized() { return this.isOptimized; }
    public PDFFileFacet setIsOptimized(Boolean value) { this.isOptimized = value; return this; }

    public java.time.ZonedDateTime getPdfCreationDate() { return this.pdfCreationDate; }
    public PDFFileFacet setPdfCreationDate(java.time.ZonedDateTime value) { this.pdfCreationDate = value; return this; }

    public List<String> getPdfId0() { return this.pdfId0; }
    public PDFFileFacet setPdfId0(List<String> value) { this.pdfId0 = value; return this; }

    public String getPdfId1() { return this.pdfId1; }
    public PDFFileFacet setPdfId1(String value) { this.pdfId1 = value; return this; }

    public java.time.ZonedDateTime getPdfModDate() { return this.pdfModDate; }
    public PDFFileFacet setPdfModDate(java.time.ZonedDateTime value) { this.pdfModDate = value; return this; }

    public String getVersion() { return this.version; }
    public PDFFileFacet setVersion(String value) { this.version = value; return this; }

}