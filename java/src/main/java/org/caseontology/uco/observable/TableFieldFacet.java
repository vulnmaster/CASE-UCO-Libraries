// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;

/** A database record facet contains properties associated with a specific table record value from a database. */
public class TableFieldFacet extends Facet {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/TableFieldFacet";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private Boolean recordFieldIsNull;
    private String recordFieldName;
    private Object recordFieldValue;
    private Object recordRowID;
    private String tableName;
    private String tableSchema;

    public TableFieldFacet() {
    }

    public Boolean getRecordFieldIsNull() { return this.recordFieldIsNull; }
    public TableFieldFacet setRecordFieldIsNull(Boolean value) { this.recordFieldIsNull = value; return this; }

    public String getRecordFieldName() { return this.recordFieldName; }
    public TableFieldFacet setRecordFieldName(String value) { this.recordFieldName = value; return this; }

    public Object getRecordFieldValue() { return this.recordFieldValue; }
    public TableFieldFacet setRecordFieldValue(Object value) { this.recordFieldValue = value; return this; }

    public Object getRecordRowID() { return this.recordRowID; }
    public TableFieldFacet setRecordRowID(Object value) { this.recordRowID = value; return this; }

    public String getTableName() { return this.tableName; }
    public TableFieldFacet setTableName(String value) { this.tableName = value; return this; }

    public String getTableSchema() { return this.tableSchema; }
    public TableFieldFacet setTableSchema(String value) { this.tableSchema = value; return this; }

}