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
 * Data reader class to create an Array of{@link Record} objects from an XML document based on mappings.
 * <p>
 *
 * Note that in order for the browser to parse a returned XML document, the Content-Type header in the HTTP response must be set to "text/xml".
 * Example code :
 *
 * <pre>
 * <code>
 *
 * RecordDef recordDef = new RecordDef(new FieldDef[] {
 *         new StringFieldDef("name", "name"), // "mapping" property not needed if it's the same as "name"
 *         new StringFieldDef("occupation")  // This field will use "occupation" as the mapping.
 * });
 * XmlReaderConfig config = new XmlReaderConfig();
 * config.setRecord("row");
 * config.setId("id");
 * config.setTotalRecords("results");
 *
 * XmlReader reader = new XmlReader(config, recordDef);
 * </code>
 * </pre>
 *
 * This would consume XML like:
 * <pre>
 * <code>
 *
 * &lt;?xml?&gt;
 * &lt;dataset&gt;
 *  &lt;results&gt;2</results&gt;
 *  &lt;row&gt;
 *    &lt;id&gt;1</id&gt;
 *    &lt;name&gt;Bill</name&gt;
 *    &lt;occupation&gt;Gardener</occupation&gt;
 *  &lt;/row&gt;
 *  &lt;row&gt;
 *    &lt;id&gt;2</id&gt;
 *    &lt;name&gt;Ben</name&gt;
 *    &lt;occupation&gt;Horticulturalist</occupation&gt;
 *  &lt;/row&gt;
 * &lt;/dataset&gt;&lt;/code></pre>
 *
 */
public class XmlReader extends Reader {

    /**
     * Construct a new XmlReader.
     * 
     * @param record the name of the record tag in the XML data
     * @param recordDef the record def
     */
    public XmlReader(String record, RecordDef recordDef) {
        XmlReaderConfig config = new XmlReaderConfig();
        config.setRecord(record);
        jsObj = create(config.getJsObj(), recordDef.getJsObj());
        this.recordDef = recordDef;
    }

    /**
     * Construct a new XmlReader.
     *
     * @param config the XmlReader configuration
     * @param recordDef the record def
     */
    public XmlReader(XmlReaderConfig config, RecordDef recordDef) {
        jsObj = create(config.getJsObj(), recordDef.getJsObj());
        this.recordDef = recordDef;
    }

    private static native JavaScriptObject create(JavaScriptObject config, JavaScriptObject recordDef) /*-{
        return new $wnd.Ext.data.XmlReader(config, recordDef);
    }-*/;
}
