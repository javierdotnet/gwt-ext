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

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.grid.event.RowSelectionListener;

/**
 * A Grid's row based selection model.
 */
public class RowSelectionModel extends AbstractSelectionModel {

    /**
     * Cretes a new RowSelectionModel.
     */
    public RowSelectionModel() {
        this(false);
    }

    /**
     * Cretes a new RowSelectionModel.
     *
     * @param singleSelect true to allow selection of only one row at a time (defaults to false)
     */
    public RowSelectionModel(boolean singleSelect) {
        jsObj = create(singleSelect);
    }

    private native JavaScriptObject create(boolean singleSelect) /*-{
        return new $wnd.Ext.grid.RowSelectionModel({singleSelect: singleSelect});
    }-*/;

    public RowSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Clears all selections.
     */
    public native void clearSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.clearSelections();
    }-*/;

    /**
     * Deselects a range of rows. All rows in between startRow and endRow are also deselected.
     *
     * @param startRow the index of the first row in the range
     * @param endRow the index of the last row in the range
     */
    public native void deselectRange(int startRow, int endRow) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.deselectRange(startRow, endRow);
    }-*/;

    /**
     * Deselects a row.
     * 
     * @param row the index of the row to deselect
     */
    public native void deselectRow(int row) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.deselectRow(row);
    }-*/;

    /**
     * Gets the number of selected rows.
     *
     * @return the number of selected rows
     */
    public native int getCount() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.getCount();
    }-*/;

    /**
     * Returns the first selected record.
     *
     * @return the first selected record
     */
    public native Record getSelected() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var selected = sm.getSelected();
        return selected == null ? null : @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(selected);
    }-*/;

    /**
     * Returns the selected records.
     * 
     * @return the selected records
     */
    public native Record[] getSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var records = sm.getSelections();
        return records == null ? null : @com.gwtext.client.data.Store::convertFromNativeRecordsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
    }-*/;

    /**
     * Returns true if there is a selection.
     *
     * @return true if there is a selection
     */
    public native boolean hasSelection() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.hasSelection();
    }-*/;

    /**
     * Returns true if the specified record id is selected.
     *
     * @param id the id of record to check
     * @return true if selected
     */
    public native boolean isIdSelected(String id) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.isIdSelected(id);
    }-*/;

    /**
     * Returns true if the selections are locked.
     *
     * @return true if selections are locked
     */
    public native boolean isLocked() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.isLocked();
    }-*/;

    /**
     * Returns true if row is selected.
     *
     * @param row the row index
     * @return true if selected
     */
    public native boolean isSelected(int row) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.isSelected(row);
    }-*/;

    /**
     * Returns true if the record is selected.
     *
     * @param record the record to check
     * @return true if selected
     */
    public native boolean isSelected(Record record) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var recordJ = record.@com.gwtext.client.core.JsObject::jsObj;
        return sm.isSelected(recordJ);
    }-*/;
    
    /**
     * Selects all rows.
     */
    public native void selectAll() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectAll();
    }-*/;

    /**
     * Selects the first row.
     */
    public native void selectFirstRow() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectFirstRow();
    }-*/;

    /**
     * Selects the last row.
     */
    public native void selectLastRow() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectLastRow();
    }-*/;

    /**
     * Seletcs the last row.
     *
     * @param keepExisting true to keep existing selection
     */
    public native void selectLastRow(boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectLastRow(keepExisting);
    }-*/;

    /**
     * Selects the row immediately following the last selected row.
     */
    public native void selectNext() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectNext();
    }-*/;

    /**
     * Selects the row that precedes the last selected row.
     */
    public native void selectPrevious() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectPrevious();
    }-*/;

    /**
     * Selects a range of rows. All rows in between startRow and endRow are also selected.
     * 
     * @param startRow the index of the first row
     * @param endRow the index of the last row
     */
    public native void selectRange(int startRow, int endRow) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectRange(startRow, endRow);
    }-*/;

    /**
     * Selects a range of rows. All rows in between startRow and endRow are also selected.
     *
     * @param startRow the index of the first row
     * @param endRow the index of the last row
     * @param keepExisting keep the existing selection
     */
    public native void selectRange(int startRow, int endRow, boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectRange(startRow, endRow, keepExisting);
    }-*/;

    /**
     * Selects a row.
     *
     * @param row the row index to select
     */
    public native void selectRow(int row) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectRow(row);
    }-*/;

    /**
     * Selects a row.
     *
     * @param row the row index to select
     * @param keepExisting keep existing selection
     */
    public native void selectRow(int row, boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectRow(row, keepExisting);
    }-*/;


    /**
     * Selects multiple rows.
     *
     * @param rows array of the indexes of the row to select
     */
    public native void selectRows(int[] rows) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var rowsJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(rows);
        sm.selectRows(rowsJS);
    }-*/;

    /**
     * Selects multiple rows.
     *
     * @param rows array of the indexes of the row to select
     * @param keepExisting keep the existing selection
     */
    public native void selectRows(int[] rows, boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var rowsJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(rows);
        sm.selectRows(rowsJS, keepExisting);
    }-*/;

    /**
     * Add a Row selection listener.
     *
     * @param listener the listener
     */
    public native void addRowSelectionListener(RowSelectionListener listener) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var smJ = this;

        sm.addListener('beforerowselect',
                function(source, rowIndex, keepExisting) {
                    return listener.@com.gwtext.client.widgets.grid.event.RowSelectionListener::doBeforeRowSelect(Lcom/gwtext/client/widgets/grid/RowSelectionModel;IZ)(smJ, rowIndex, keepExisting);
                }
        );

        sm.addListener('rowselect',
                function(source, rowIndex) {
                    listener.@com.gwtext.client.widgets.grid.event.RowSelectionListener::onRowSelect(Lcom/gwtext/client/widgets/grid/RowSelectionModel;I)(smJ, rowIndex);
                }
        );

        sm.addListener('rowdeselect',
                function(source, rowIndex) {
                    listener.@com.gwtext.client.widgets.grid.event.RowSelectionListener::onRowDeselect(Lcom/gwtext/client/widgets/grid/RowSelectionModel;I)(smJ, rowIndex);
                }
        );

        sm.addListener('selectionchange',
                function(source) {
                    listener.@com.gwtext.client.widgets.grid.event.RowSelectionListener::onSelectionChange(Lcom/gwtext/client/widgets/grid/RowSelectionModel;)(smJ);
                }
        );
    }-*/;
}
