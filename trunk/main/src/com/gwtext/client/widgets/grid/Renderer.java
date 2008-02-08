/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid;

import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;

/**
 * Inteface for custom Grid column rendering.
 *
 * @see com.gwtext.client.widgets.grid.ColumnConfig#setRenderer(Renderer)
 */
public interface Renderer {

    /**
     * Renderer function.
     *
     * @param value        the cells value. When working with numberic data, cast the value to {@link java.lang.Number}
     *                     and not to a specific data type line Integer or Float as the class type is inferred from the data
     * @param cellMetadata the grid cell metadata. Can be use to customize the apperanace of the grid cell
     * @param record       the record corresponding to the row
     * @param rowIndex     the row index
     * @param colNum       the column number
     * @param store        the Grid's data store
     * @return the rendered cell content (can include html)
     */
    String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store);
}
