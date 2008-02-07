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

public interface GridRowListener {

    /**
     * Fires when a row is clicked.
     *
     * @param grid     this
     * @param rowIndex the row index
     * @param e        the event object
     */
    void onRowClick(GridPanel grid, int rowIndex, EventObject e);

    /**
     * Fires when a row is double clicked.
     *
     * @param grid     this
     * @param rowIndex the row index
     * @param e        the event object
     */
    void onRowDblClick(GridPanel grid, int rowIndex, EventObject e);

    /**
     * Fires when a row is right clicked.
     *
     * @param grid     this
     * @param rowIndex the row index
     * @param e        the event object
     */
    void onRowContextMenu(GridPanel grid, int rowIndex, EventObject e);
}
