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
 *
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
 */
public class JsonReader extends Reader {

    public JsonReader(JsonReaderConfig config, RecordDef recordDef) {
        jsObj = create(config.getJsObj(), recordDef.getJsObj());
        this.recordDef = recordDef;
    }

    private static native JavaScriptObject create(JavaScriptObject config, JavaScriptObject recordDef) /*-{
        return new $wnd.Ext.data.JsonReader(config, recordDef);
    }-*/;
}