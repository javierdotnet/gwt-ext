/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.grid.GridPanel;

//deails here http://extjs.com/forum/showthread.php?t=2834&highlight=validateedit
public interface EditorGridListener {

    /**
     * Fires after a cell is edited.
     *
     * @param grid     this
     * @param record   the record being edited
     * @param field    the field name being edited
     * @param newValue the value being set
     * @param oldValue the original value for the field, before the edit.
     * @param rowIndex the grid row index
     * @param colIndex the grid column index
     */
    void onAfterEdit(GridPanel grid, Record record, String field, Object newValue, Object oldValue, int rowIndex, int colIndex);

    /**
     * Fires before cell editing is triggered.
     *
     * @param grid     This grid
     * @param record   the record being edited
     * @param field    the field name being edited
     * @param value    the value for the field being edited
     * @param rowIndex the grid row index
     * @param colIndex the grid column index
     * @return false to cancel the edit
     */
    boolean doBeforeEdit(GridPanel grid, Record record, String field, Object value, int rowIndex, int colIndex);

    /**
     * Fires after a cell is edited, but before the value is set in the record. Return false to cancel the change.
     *
     * @param grid          this
     * @param record        the record being edited
     * @param field         the field name being edited
     * @param value         the value being set
     * @param originalValue the original value for the field, before the edit
     * @param rowIndex      the grid row index
     * @param colIndex      the grid column index
     * @return false to cancel the change
     */
    boolean doValidateEdit(GridPanel grid, Record record, String field, Object value, Object originalValue, int rowIndex, int colIndex);
}