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

    public RecordDef(FieldDef[] fields) {
        Object[] jsObjs = new Object[fields.length];
        for (int i = 0; i < jsObjs.length; i++) {
            JavaScriptObject jsObj = fields[i].getJsObj();
            jsObjs[i] = jsObj;
        }
        jsObj = getJsObj(JavaScriptObjectHelper.convertToJavaScriptArray(jsObjs));
    }

    private native JavaScriptObject getJsObj(JavaScriptObject recordDef) /*-{
        return $wnd.Ext.data.Record.create(recordDef);
    }-*/;

    //tested - works
    public Record createRecord(Object[] rowData) {
        MemoryProxy proxy = new MemoryProxy(new Object[][]{rowData});
        ArrayReader reader = new ArrayReader(this);
        Store temp = new Store(proxy, reader);
        temp.load();
        return temp.getAt(0);
    }
}