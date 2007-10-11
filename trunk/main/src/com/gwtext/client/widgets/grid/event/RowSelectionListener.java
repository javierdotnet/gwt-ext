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

import com.gwtext.client.widgets.grid.RowSelectionModel;

public interface RowSelectionListener {

    /**
     * Fires when a row is selected being selected, return false to cancel.
     *
     * @param sm this
     * @param rowIndex the row index
     * @param keepExisting false if other selections will be cleared
     * @return false the cancel the row select
     */
    boolean doBeforeRowSelect(RowSelectionModel sm, int rowIndex, boolean keepExisting);

    /**
     * Fires when a row is deselected.
     *
     * @param sm this
     * @param rowIndex the row index
     */
    void onRowDeselect(RowSelectionModel sm, int rowIndex);

    /**
     * Fires when a row is selected.
     *
     * @param sm this
     * @param rowIndex the row index
     */
    void onRowSelect(RowSelectionModel sm, int rowIndex);

    /**
     * Fires when the selection changes.
     *
     * @param sm this
     */
    void onSelectionChange(RowSelectionModel sm);
}
