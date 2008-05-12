/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.grid.CellSelectionModel;

/**
 *
 * @author Sanjiv Jivan
 */
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
