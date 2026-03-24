// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.Facet;

/** An SQLite blob facet is a grouping of characteristics unique to a blob (binary large object) of data within an SQLite database. [based on https://en.wikipedia.org/wiki/SQLite] */
public class SQLiteBlobFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/SQLiteBlobFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String columnName;
    private String rowCondition;
    private List<Long> rowIndex;
    private String tableName;

    public SQLiteBlobFacet() {
        this.rowIndex = new ArrayList<>();
    }

    public String getColumnName() { return this.columnName; }
    public SQLiteBlobFacet setColumnName(String value) { this.columnName = value; return this; }

    public String getRowCondition() { return this.rowCondition; }
    public SQLiteBlobFacet setRowCondition(String value) { this.rowCondition = value; return this; }

    public List<Long> getRowIndex() { return this.rowIndex; }
    public SQLiteBlobFacet setRowIndex(List<Long> value) { this.rowIndex = value; return this; }

    public String getTableName() { return this.tableName; }
    public SQLiteBlobFacet setTableName(String value) { this.tableName = value; return this; }

}