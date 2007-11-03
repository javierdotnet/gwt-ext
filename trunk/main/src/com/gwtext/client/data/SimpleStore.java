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
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Convenience class that creates a Store directly using field names and local array data. Usage :
 *
 * <pre>
 * <code>
 *
 * Store store = new SimpleStore(new String[]{"theme", "label"}, new Object[][]{
 *                new Object[]{"xtheme-aero.css", "Aero Glass Theme"},
 *                new Object[]{"xtheme-gray.css", "Gray Theme"},
 *                new Object[]{"xtheme-vista.css", "Vista Dark Theme"}});
 * </code>
 * </pre>
 */
public class SimpleStore extends Store {

    /**
     * Construct a SimpleStore.
     *
     * @param fields array of field names
     * @param data store data. all fields are treated as String's
     */
    public SimpleStore(String[] fields, Object[][] data) {
        this(-1, fields, data);
    }

    /**
     * Construct a SimpleStore.
     *
     * @param id name of the ID field
     * @param fields array of field names. All Fields are treated as Strings
     * @param data store data
     */
    public SimpleStore(int id, String[] fields, Object[][] data) {
        SimpleStoreConfig config = new SimpleStoreConfig();
        if(id >= 0) config.setId(id);
        config.setFields(fields);
        config.setData(data);
        jsObj = create(config.getJsObj());
    }

    /**
     * Construct a SimpleStore.
     *
     * @param id name of the ID field
     * @param fields the field definitions
     * @param data store data
     */
    public SimpleStore(int id, FieldDef[] fields, Object[][] data) {
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

        public void setFields(FieldDef[] fields) {
            JavaScriptObjectHelper.setAttribute(jsObj, "fields", JavaScriptObjectHelper.convertToJavaScriptArray(fields));
        }

        public void setData(Object[][] data) {
            JavaScriptObjectHelper.setAttribute(jsObj, "data", JavaScriptObjectHelper.convertToJavaScriptArray(data));
        }
    }
}


