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

public class RecordDef extends JsObject {

    private FieldDef[] fields;

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

    public Record createRecord(String id, Object[] rowData) {
        Record record = createRecord(rowData);
        record.setId(id);
        return record;
    }

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

    public FieldDef[] getFields() {
        return fields;
    }
}