/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A record definition where the fields in the source data of a {@link Reader} are declared.
 * <p/>
 * <pre>
 * <code>
 * <p/>
 * Object[][] states = new Object[][]{
 *               new Object[]{"AL", "Alabama"},
 *               new Object[]{"AK", "Alaska"},
 *               new Object[]{"AZ", "Arizona"},
 *               new Object[]{"AR", "Arkansas"},
 *               new Object[]{"CA", "California"}};
 * <p/>
 * Reader reader = new ArrayReader(new RecordDef(
 *                new FieldDef[]{
 *                       new StringFieldDef("abbr"),
 *                       new StringFieldDef("state")
 *               }));
 * <p/>
 * Store store = new Store(proxy, reader);
 * </code>
 * </pre>
 *
 * @see Store
 * @see com.gwtext.client.data.MemoryProxy
 */
public class RecordDef extends JsObject {

    private FieldDef[] fields;

    /**
     * Construct a new RecordDef using the passed field definitions.
     *
     * @param fields the field defs
     */
    public RecordDef(FieldDef[] fields) {
        this.fields = fields;
        int numFields = fields.length;
        JavaScriptObject[] jsObjs = new JavaScriptObject[numFields];
        for (int i = 0; i < numFields; i++) {
            JavaScriptObject jsObj = fields[i].getJsObj();
            jsObjs[i] = jsObj;
        }
        jsObj = getJsObj(JavaScriptObjectHelper.convertToJavaScriptArray(jsObjs));
    }

    private native JavaScriptObject getJsObj(JavaScriptObject recordDef) /*-{
        return $wnd.Ext.data.Record.create(recordDef);
    }-*/;

    /**
     * Create a new Record instance using the passed data.
     *
     * @param id      the Record ID
     * @param rowData the record data
     * @return a Record instance
     */
    public Record createRecord(String id, Object[] rowData) {
        Record record = createRecord(rowData);
        record.setId(id);
        return record;
    }

    /**
     * Create a new Record instance using the passed data.
     *
     * @param rowData the record data
     * @return a Record instance
     */
    public Record createRecord(Object[] rowData) {
        int numFields = fields.length;
        if (rowData.length != numFields) {
            throw new IllegalArgumentException("Expected " + numFields + " fields but was passed " + rowData.length + " fields.");
        }
        MemoryProxy proxy = new MemoryProxy(new Object[][]{rowData});
        ArrayReader reader = new ArrayReader(this);
        Store temp = new Store(proxy, reader);
        temp.load();
        return temp.getAt(0);
    }

    /**
     * Return the fields defined for this RecordDef.
     *
     * @return the field defs
     */
    public FieldDef[] getFields() {
        return fields;
    }
}