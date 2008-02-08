/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.widgets.grid.ColumnModel;

public interface ColumnModelListener {

    /**
     * Fires when a column's locked state is changed.
     *
     * @param cm       this
     * @param colIndex the column index
     * @param locked   true if locked
     */
    void onColumnLockChange(ColumnModel cm, int colIndex, boolean locked);

    /**
     * Fires when a column is moved.
     *
     * @param cm       this
     * @param oldIndex the old column index
     * @param newIndex the new column index
     */
    void onColumnMoved(ColumnModel cm, int oldIndex, int newIndex);

    /**
     * Fires when the text of a header changes.
     *
     * @param cm          this
     * @param columnIndex the column index
     * @param newText     the new header text
     */
    void onHeaderChange(ColumnModel cm, int columnIndex, String newText);

    /**
     * Fires when a column is hidden or "unhidden".
     *
     * @param cm       this
     * @param colIndex the column index
     * @param hidden   true if hidden, false otherwise
     */
    void onHiddenChange(ColumnModel cm, int colIndex, boolean hidden);

    /**
     * Fires when the width of a column changes.
     *
     * @param cm       this
     * @param colIndex the column index
     * @param newWidth the new width
     */
    void onWidthChange(ColumnModel cm, int colIndex, int newWidth);
}
