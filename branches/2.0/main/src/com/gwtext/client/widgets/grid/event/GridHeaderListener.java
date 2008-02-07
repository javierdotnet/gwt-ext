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

public interface GridHeaderListener {

    /**
     * Fires when a header is clicked.
     *
     * @param grid     this
     * @param colIndex the column index
     * @param e        the event object
     */
    void onHeaderClick(GridPanel grid, int colIndex, EventObject e);

    /**
     * Fires when a header is right clicked.
     *
     * @param grid     this
     * @param colIndex the column index
     * @param e        the event object
     */
    void onHeaderContextMenu(GridPanel grid, int colIndex, EventObject e);

    /**
     * Fires when a header cell is double clicked.
     *
     * @param grid     this
     * @param colIndex the column index
     * @param e        the event object
     */
    void onHeaderDblClick(GridPanel grid, int colIndex, EventObject e);
}
