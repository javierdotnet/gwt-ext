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

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.grid.Grid;

public interface GridCellListener {

    /**
     * Fires when a cell is clicked.
     *
     * @param grid this
     * @param rowIndex the row index
     * @param colIndex the column index
     * @param e the event object
     */
    void onCellClick(Grid grid, int rowIndex, int colIndex, EventObject e);

    /**
     * Fires when a cell is right clicked.
     *
     * @param grid this
     * @param rowIndex the row index
     * @param cellIndex the cell index
     * @param e the event object
     */
    void onCellContextMenu(Grid grid, int rowIndex, int cellIndex, EventObject e);

    /**
     * Fires when a cell is double clicked.
     *
     * @param grid this
     * @param rowIndex the row index
     * @param colIndex the column index
     * @param e the event object
     */
    void onCellDblClick(Grid grid, int rowIndex, int colIndex, EventObject e);
}
