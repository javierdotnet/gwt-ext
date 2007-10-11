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

import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.grid.CellSelectionModel;

public interface CellSelectionModelListener {

    /**
     * Fires before a cell is selected.
     *
     * @param sm this
     * @param rowIndex The selected row index
     * @param colIndex The selected cell index
     * @return false to cancel the row select
     */
    boolean doBeforeRowSelect(CellSelectionModel sm, int rowIndex, int colIndex);

    /**
     * Fires when a cell is selected.
     *
     * @param sm this
     * @param rowIndex The selected row index
     * @param colIndex The selected cell index
     */
    void onCellSelect(CellSelectionModel sm, int rowIndex, int colIndex);

    /**
     * Fires when the active selection changes.
     *
     * @param sm this
     * @param record the selected record. null for no selection
     * @param rowIndexColIndex array of rowIndex, columnIndex
     */
    void onSelectionChange(CellSelectionModel sm, Record record, int[] rowIndexColIndex);
}
