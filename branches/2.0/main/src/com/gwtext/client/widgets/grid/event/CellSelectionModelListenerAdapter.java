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

public class CellSelectionModelListenerAdapter implements CellSelectionModelListener {

    public boolean doBeforeRowSelect(CellSelectionModel sm, int rowIndex, int colIndex) {
        return true;
    }

    public void onCellSelect(CellSelectionModel sm, int rowIndex, int colIndex) {
    }

    public void onSelectionChange(CellSelectionModel sm, Record record, int[] rowIndexColIndex) {
    }
}
