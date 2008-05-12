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
 *
 * @author Sanjiv Jivan
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