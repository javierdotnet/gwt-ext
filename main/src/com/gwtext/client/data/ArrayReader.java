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
 * Data reader class that is setup to consume data from an array data source. This class sets up the
 * field metadata for the data present in the array data source.
 * <pre>
 * Object[][] data = new Object[][]{
 *                new Object[]{"3m Co", new Double(71.72), new Double(0.02), new Double(0.03), "9/1 12:00am", 1},
 *                new Object[]{"Alcoa Inc", new Double(29.01), new Double(0.42), new Double(1.47), "9/1 12:00am", 2}};
 * ArrayReader reader = new ArrayReader(new RecordDef(
 *   new FieldDef[]{
 *     new StringFieldDef("company"),
 *     new FloatFieldDef("price"),
 *     new FloatFieldDef("change"),
 *     new FloatFieldDef("pctChange"),
 *     new DateFieldDef("lastChanged", "n/j h:ia")
 *     }
 *  ));
 * </pre>
 * <p/>
 * If the data array has data that doesn't exactly match the the fields you need in the Reader, then you can specify a
 * (zero based) positional mapper in the field definitions.
 * <p/>
 * <pre>
 * ArrayReader reader = new ArrayReader(new RecordDef(
 *   new FieldDef[]{
 *     new StringFieldDef("company"),   //equivalent to new StringField("company", 0);
 *     new FloatFieldDef("change", 2),
 *     new DateFieldDef("lastChanged", "n/j h:ia", 4)
 *     }
 *  ));
 * </pre>
 * <p/>
 * <pre>
 * MemoryProxy dataProxy = new MemoryProxy(data);
 * Store store = new Store(dataProxy, reader);
 * store.load();
 * </pre>
 * <p/>
 * Sometimes you might want to map a field in the data source to be the "ID" of the record. You indicate the position
 * of the data element that represents the ID by using constructor that takes the field ID index as the first argument.
 * <p/>
 * <pre>
 * ArrayReader reader = new ArrayReader(5, new RecordDef(
 *   new FieldDef[]{
 *     new StringFieldDef("company"),   //equivalent to new StringFieldDef("company", 0);
 *     new FloatFieldDef("change", 2),
 *     new DateFieldDef("lastChanged", "n/j h:ia", 4)
 *     }
 *  ));
 * </pre>
 * <p/>
 * So for the above data set the ID for the first record will get mapped to 1 (data index of 5 corresponts to the last
 * element in the array) and the ID of the second row gets mapped to 2.  Mapping ID's for Record's are useful when, say,
 * the data soource is mapped to a widget like a Grid and when the user clicks on a row, you want to geta handle of the
 * ID for that record which might correspond to the primary key of the database table from which the data is being read.
 *
 * @author Sanjiv Jivan
 * @see RecordDef
 * @since 0.9
 */
public class ArrayReader extends Reader {

    /**
     * Construct an ArrayRader using the specified {@link RecordDef}.
     *
     * @param recordDef the record definition
     */
    public ArrayReader(RecordDef recordDef) {
        setRecordDef(recordDef);
    }

    /**
     * Construct an ArrayRader using the specified {@link RecordDef}.
     *
     * @param id        position of the ID of the field in the underlying array data that provides an ID for the Record
     * @param recordDef the record definition
     * @see Record
     */
    public ArrayReader(int id, RecordDef recordDef) {
        setId(id);
        setRecordDef(recordDef);
    }

    protected native JavaScriptObject create(JavaScriptObject config, JavaScriptObject recordDef) /*-{
        return new $wnd.Ext.data.ArrayReader(config, recordDef);
    }-*/;

    //config
   /**
     * The position of the ID of the field in the underlying array data that provides an ID for the Record
     *
     * @param id the ID
     */
    public void setId(int id) {
        JavaScriptObjectHelper.setAttribute(configJS, "id", id);
    }


}
