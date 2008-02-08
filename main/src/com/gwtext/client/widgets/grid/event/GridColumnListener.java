/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.widgets.grid.GridPanel;

public interface GridColumnListener {

    /**
     * Fires when the user moves a column.
     *
     * @param grid     this
     * @param oldIndex the old column index
     * @param newIndex the new column index
     */
    void onColumnMove(GridPanel grid, int oldIndex, int newIndex);

    /**
     * Fires when the user resizes a column.
     *
     * @param grid     this
     * @param colIndex the column index
     * @param newSize  the new column size
     */
    void onColumnResize(GridPanel grid, int colIndex, int newSize);
}
