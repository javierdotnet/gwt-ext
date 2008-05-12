/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
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
 * @author Sanjiv Jivan
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