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

import com.gwtext.client.widgets.grid.Grid;

public interface GridColumnListener {

    /**
     * Fires when the user moves a column.
     *
     * @param grid this
     * @param oldIndex the old column index
     * @param newIndex the new column index
     */
    void onColumnMove(Grid grid, int oldIndex, int newIndex);

    /**
     * Fires when the user resizes a column.
     *  
     * @param grid this
     * @param colIndex the column index
     * @param newSize the new column size
     */
    void onColumnResize(Grid grid, int colIndex, int newSize);
}
