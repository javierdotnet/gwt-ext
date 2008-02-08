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
 *
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
 * @since 0.9
 * @see RecordDef
 */
public class ArrayReader extends Reader {

    /**
     * Construct an ArrayRader using the specified {@link RecordDef}.
     *
     * @param recordDef the record definition
     */
    public ArrayReader(RecordDef recordDef) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        jsObj = create(recordDef.getJsObj(), config);
        this.recordDef = recordDef;
    }

    /**
     * Construct an ArrayRader using the specified {@link RecordDef}.
     *
     * @param id position of the ID of the field in the underlying array data that provides an ID for the Record
     * @param recordDef the record definition
     * @see Record
     */
    public ArrayReader(int id, RecordDef recordDef) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "id", id);
        jsObj = create(recordDef.getJsObj(), config);
        this.recordDef = recordDef;
    }

    private native JavaScriptObject create(JavaScriptObject recordDef, JavaScriptObject config) /*-{
        return new $wnd.Ext.data.ArrayReader(config, recordDef);
    }-*/;
}
