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
 * Data reader class to create an Array of Ext.data.Record objects from a JSON response
 * based on mappings in a provided Ext.data.Record constructor.
 * <p>
 * Example code:
 * </p><pre><code>
 *  RecordDef recordDef = new RecordDef(new FieldDef[]{
 *             new StringFieldDef("name", "name"), // "mapping" property not needed if it's the same as "name"
 *             new StringFieldDef("occupation")    // this field will use "occupation" as the mapping.
 *     });
 * <p/>
 *  JsonReader reader = new JsonReader(new JsonReaderConfig() {
 *      {
 *          setTotalProperty("results"); // The property which contains the total dataset size (optional)
 *          setRoot("rows");             // The property which contains an Array of row objects
 *          setId("id");                 // The property within each row object that provides an ID for the record (optional)
 *      }}, recordDef);
 * </code>
 * </pre>
 * <p>
 * This would consume a JSON file like this:
 * </p><pre><code>{ <em>'results'</em>: 2, <em>'rows'</em>: [
 *     { <em>'id'</em>: 1, <em>'name'</em>: <em>'Bill'</em>, occupation: <em>'Gardener'</em> },
 *     { <em>'id'</em>: 2, <em>'name'</em>: <em>'Ben'</em>, occupation: <em>'Horticulturalist'</em> } ]
 * }</code></pre>
 *
 *
 * @author Sanjiv Jivan
 */
public class JsonReader extends Reader {

    /**
     * Constructs a new JsonReader.
     *
     * @param recordDef the record def
     */
    public JsonReader(RecordDef recordDef) {
        setRecordDef(recordDef);
    }

    /**
     * Constructs a new JsonReader.
     *
     * @param root the root property
     * @param recordDef the record def
     */
    public JsonReader(String root, RecordDef recordDef) {
        setRoot(root);
        setRecordDef(recordDef);
    }

    protected native JavaScriptObject create(JavaScriptObject config, JavaScriptObject recordDef) /*-{
        return new $wnd.Ext.data.JsonReader(config, recordDef);
    }-*/;

    //config

    /**
     * Name of the property within a row object that contains a record identifier value.
     *
     * @param id the id property
     */
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(configJS, "id", id);
    }

    /**
     * Name of the property which contains the Array of row objects.
     *
     * @param root the root property
     */
    public void setRoot(String root) {
        JavaScriptObjectHelper.setAttribute(configJS, "root", root);
    }

    /**
     * Name of the property from which to retrieve the success attribute used by forms.
     *
     * @param successProperty the success property
     */
    public void setSuccessProperty(String successProperty) {
        JavaScriptObjectHelper.setAttribute(configJS, "successProperty", successProperty);
    }

    /**
     * Name of the property from which to retrieve the total number of records in the dataset.
     * This is only needed if the whole dataset is not passed in one go, but is being paged from the remote server.
     *
     * @param totalProperty proeprty for total number of records
     */
    public void setTotalProperty(String totalProperty) {
        JavaScriptObjectHelper.setAttribute(configJS, "totalProperty", totalProperty);
    }
}