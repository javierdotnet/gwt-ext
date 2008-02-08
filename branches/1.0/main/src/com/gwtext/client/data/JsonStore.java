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

/**
 * Small helper class to make creating Stores for JSON data easier. 
 * <pre>
 *  <code>
 *  JsonStore store = new JsonStore("get-images.php", "images",new RecordDef(new FieldDef[]{
 *          new StringFieldDef("name"),
 *          new StringFieldDef("url"),
 *          new FloatFieldDef("size"),
 *          new DateFieldDef("lastmod")}));
 *  </code>
 * </pre>
 */
public class JsonStore extends Store {

    /**
     * Create a new JsonStore.
     *
     * @param url the URL that returns the Json data
     * @param root name of the property which contains the Array of row objects
     * @param fields the name of the fields
     */
    public JsonStore(String url, String root, String[] fields) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        JavaScriptObjectHelper.setAttribute(config, "root", root);
        JavaScriptObjectHelper.setAttribute(config, "fields", fields);
        jsObj = create(config);
    }

    /**
     * Create a new JsonStore.
     *
     * @param url the URL that returns the Json data
     * @param root name of the property which contains the Array of row objects
     * @param recordDef the record def
     */
    public JsonStore(String url, String root, RecordDef recordDef) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        JavaScriptObjectHelper.setAttribute(config, "root", root);
        JavaScriptObjectHelper.setAttribute(config, "recordType", recordDef.getJsObj());
        jsObj = create(config);
    }

    /**
     * Create a new JsonStore.
     *
     * @param url the URL that returns the Json data
     * @param jsonConfig the Json reader config
     * @param recordDef the record def
     */
    public JsonStore(String url, JsonReaderConfig jsonConfig, RecordDef recordDef) {
        JavaScriptObject config = jsonConfig.getJsObj();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        JavaScriptObjectHelper.setAttribute(config, "recordType", recordDef.getJsObj());
        jsObj = create(config);
    }

    private static native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.data.JsonStore(config);
    }-*/;
}