/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.grid.CellSelectionModel;

public interface CellSelectionModelListener {

    /**
     * Fires before a cell is selected.
     *
     * @param sm       this
     * @param rowIndex The selected row index
     * @param colIndex The selected cell index
     * @return false to cancel the row select
     */
    boolean doBeforeRowSelect(CellSelectionModel sm, int rowIndex, int colIndex);

    /**
     * Fires when a cell is selected.
     *
     * @param sm       this
     * @param rowIndex The selected row index
     * @param colIndex The selected cell index
     */
    void onCellSelect(CellSelectionModel sm, int rowIndex, int colIndex);

    /**
     * Fires when the active selection changes.
     *
     * @param sm               this
     * @param record           the selected record. null for no selection
     * @param rowIndexColIndex array of rowIndex, columnIndex
     */
    void onSelectionChange(CellSelectionModel sm, Record record, int[] rowIndexColIndex);
}
