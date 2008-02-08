/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.widgets.grid.RowSelectionModel;
import com.gwtext.client.data.Record;

public interface RowSelectionListener {

    /**
     * Fires when a row is selected being selected, return false to cancel.
     *
     * @param sm           this
     * @param rowIndex     the row index
     * @param keepExisting false if other selections will be cleared
     * @param record the record
     * @return false the cancel the row select
     */
    boolean doBeforeRowSelect(RowSelectionModel sm, int rowIndex, boolean keepExisting, Record record);

    /**
     * Fires when a row is deselected.
     *
     * @param sm       this
     * @param rowIndex the row index
     * @param record the record
     */
    void onRowDeselect(RowSelectionModel sm, int rowIndex, Record record);

    /**
     * Fires when a row is selected.
     *
     * @param sm       this
     * @param rowIndex the row index
     * @param record the record
     */
    void onRowSelect(RowSelectionModel sm, int rowIndex, Record record);

    /**
     * Fires when the selection changes.
     *
     * @param sm this
     */
    void onSelectionChange(RowSelectionModel sm);
}
