/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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
 * <p/>
 * This would consume a returned object of the form:
 *
 * <pre>
 * <code>
 * {
 *   images: [
 *       {name: &lt;em&gt;'Image one'&lt;/em&gt;, url:&lt;em&gt;'/GetImage.php?id=1'&lt;/em&gt;, size:46.5, lastmod: &lt;b&gt;new&lt;/b&gt; Date(2007, 10, 29)},
 *       {name: &lt;em&gt;'Image Two'&lt;/em&gt;, url:&lt;em&gt;'/GetImage.php?id=2'&lt;/em&gt;, size:43.2, lastmod: &lt;b&gt;new&lt;/b&gt; Date(2007, 10, 30)}
 *   ]
 * }
 * </code>
 * </pre>
 */
public class JsonStore extends Store {

    /**
     * Create a new JsonStore.
     *
     * @param url    the URL that returns the Json data
     * @param root   name of the property which contains the Array of row objects
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
     * @param url       the URL that returns the Json data
     * @param root      name of the property which contains the Array of row objects
     * @param recordDef the record def
     */
    public JsonStore(String url, String root, RecordDef recordDef) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        JavaScriptObjectHelper.setAttribute(config, "root", root);
        JavaScriptObjectHelper.setAttribute(config, "recordType", recordDef.getJsObj());
        jsObj = create(config);
    }


    native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.data.JsonStore(config);
    }-*/;
}