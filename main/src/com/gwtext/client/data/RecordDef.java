/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A record definition where the fields in the source data of a {@link Reader} are declared.
 *
 * <pre>
 * <code>
 *
 * Object[][] states = new Object[][]{
 *               new Object[]{"AL", "Alabama"},
 *               new Object[]{"AK", "Alaska"},
 *               new Object[]{"AZ", "Arizona"},
 *               new Object[]{"AR", "Arkansas"},
 *               new Object[]{"CA", "California"}};
 *
 * Reader reader = new ArrayReader(new RecordDef(
 *                new FieldDef[]{
 *                       new StringFieldDef("abbr"),
 *                       new StringFieldDef("state")
 *               }));
 *
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
        Object[] jsObjs = new Object[numFields];
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
     * @param id the Record ID
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
        if(rowData.length != numFields) {
            throw new IllegalArgumentException("Expected " + numFields  + " fields but was passed " + rowData.length + " fields.");
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