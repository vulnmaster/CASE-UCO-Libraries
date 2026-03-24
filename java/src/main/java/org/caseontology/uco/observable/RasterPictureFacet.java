// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** A raster picture facet is a grouping of characteristics unique to a raster (or bitmap) image. */
public class RasterPictureFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/RasterPictureFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Long bitsPerPixel;
    private ObservableObject camera;
    private String imageCompressionMethod;
    private Long pictureHeight;
    private String pictureType;
    private Long pictureWidth;

    public RasterPictureFacet() {
    }

    public Long getBitsPerPixel() { return this.bitsPerPixel; }
    public RasterPictureFacet setBitsPerPixel(Long value) { this.bitsPerPixel = value; return this; }

    public ObservableObject getCamera() { return this.camera; }
    public RasterPictureFacet setCamera(ObservableObject value) { this.camera = value; return this; }

    public String getImageCompressionMethod() { return this.imageCompressionMethod; }
    public RasterPictureFacet setImageCompressionMethod(String value) { this.imageCompressionMethod = value; return this; }

    public Long getPictureHeight() { return this.pictureHeight; }
    public RasterPictureFacet setPictureHeight(Long value) { this.pictureHeight = value; return this; }

    public String getPictureType() { return this.pictureType; }
    public RasterPictureFacet setPictureType(String value) { this.pictureType = value; return this; }

    public Long getPictureWidth() { return this.pictureWidth; }
    public RasterPictureFacet setPictureWidth(Long value) { this.pictureWidth = value; return this; }

}