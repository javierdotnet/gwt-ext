/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.grid.GridPanel;

public interface GridCellListener {

    /**
     * Fires when a cell is clicked.
     *
     * @param grid     this
     * @param rowIndex the row index
     * @param colIndex the column index
     * @param e        the event object
     */
    void onCellClick(GridPanel grid, int rowIndex, int colIndex, EventObject e);

    /**
     * Fires when a cell is right clicked.
     *
     * @param grid      this
     * @param rowIndex  the row index
     * @param cellIndex the cell index
     * @param e         the event object
     */
    void onCellContextMenu(GridPanel grid, int rowIndex, int cellIndex, EventObject e);

    /**
     * Fires when a cell is double clicked.
     *
     * @param grid     this
     * @param rowIndex the row index
     * @param colIndex the column index
     * @param e        the event object
     */
    void onCellDblClick(GridPanel grid, int rowIndex, int colIndex, EventObject e);
}
