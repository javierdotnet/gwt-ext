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
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.core.BaseConfig;

public class SimpleStore extends Store {
    
    public SimpleStore(String[] fields, Object[][] data) {
        this(-1, fields, data);
    }

    public SimpleStore(int id, String[] fields, Object[][] data) {
        SimpleStoreConfig config = new SimpleStoreConfig();
        if(id >= 0) config.setId(id);
        config.setFields(fields);
        config.setData(data);
        jsObj = create(config.getJsObj());
    }

    public SimpleStore(int id, Field[] fields, Object[][] data) {
        SimpleStoreConfig config = new SimpleStoreConfig();
        if(id >= 0) config.setId(id);
        config.setFields(fields);
        config.setData(data);
        jsObj = create(config.getJsObj());
    }

    private static native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.data.SimpleStore(config);
    }-*/;

    private static class SimpleStoreConfig extends BaseConfig {

        public void setId(int id) {
            JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
        }

        public void setFields(String[] fields) {
            JavaScriptObjectHelper.setAttribute(jsObj, "fields", JavaScriptObjectHelper.convertToJavaScriptArray(fields));
        }

        public void setFields(Field[] fields) {
            JavaScriptObjectHelper.setAttribute(jsObj, "fields", JavaScriptObjectHelper.convertToJavaScriptArray(fields));
        }

        public void setData(Object[][] data) {
            JavaScriptObjectHelper.setAttribute(jsObj, "data", JavaScriptObjectHelper.convertToJavaScriptArray(data));
        }
    }
}


