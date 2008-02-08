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
 * Data reader class to create an Array of{@link Record} objects from an XML document based on mappings.
 * <p/>
 * <p/>
 * Note that in order for the browser to parse a returned XML document, the Content-Type header in the HTTP response must be set to "text/xml".
 * Example code :
 * <p/>
 * <pre>
 * <code>
 * <p/>
 * RecordDef recordDef = new RecordDef(new FieldDef[] {
 *         new StringFieldDef("name", "name"), // "mapping" property not needed if it's the same as "name"
 *         new StringFieldDef("occupation")  // This field will use "occupation" as the mapping.
 * });
 * XmlReaderConfig config = new XmlReaderConfig();
 * config.setRecord("row");
 * config.setId("id");
 * config.setTotalRecords("results");
 * <p/>
 * XmlReader reader = new XmlReader(config, recordDef);
 * </code>
 * </pre>
 * <p/>
 * This would consume XML like:
 * <pre>
 * <code>
 * <p/>
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
 */
public class XmlReader extends Reader {

    /**
     * Construct a new XmlReader.
     *
     * @param record    the name of the record tag in the XML data
     * @param recordDef the record def
     */
    public XmlReader(String record, RecordDef recordDef) {
        setRecord(record);
        setRecordDef(recordDef);
    }

    protected native JavaScriptObject create(JavaScriptObject config, JavaScriptObject recordDef) /*-{
        return new $wnd.Ext.data.XmlReader(config, recordDef);
    }-*/;

   //config
   /**
     * The {@link com.gwtext.client.core.DomQuery} path relative from the record element to the element that contains a record identifier value..
     * The simples case is the tag name in the XML that maps to the Record ID
     *
     * @param id the ID
     */
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(configJS, "id", id);
    }

    /**
     * The {@link com.gwtext.client.core.DomQuery} path to the repeated element which contains record information. The simples
     * case is the tag name in the XML that maps to the root tag of what corresponnds to a "record".
     *
     * @param record the record mapping
     */
    public void setRecord(String record) {
        JavaScriptObjectHelper.setAttribute(configJS, "record", record);
    }

    /**
     * The {@link com.gwtext.client.core.DomQuery} path to the success attribute used by forms.
     *
     * @param success the success {@link com.gwtext.client.core.DomQuery} path.
     */
    public void setSuccess(String success) {
        JavaScriptObjectHelper.setAttribute(configJS, "success", success);
    }

    /**
     * The {@link com.gwtext.client.core.DomQuery} path from which to retrieve the total number of records in the dataset.
     * This is only needed if the whole dataset is not passed in one go, but is being paged from the remote server.
     *
     * @param totalRecords the totalRecords DomQuery path
     */
    public void setTotalRecords(String totalRecords) {
        JavaScriptObjectHelper.setAttribute(configJS, "totalRecords", totalRecords);
    }
}
