/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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

    protected native JavaScriptObject create(boolean singleSelect) /*-{
        return new $wnd.Ext.grid.RowSelectionModel({singleSelect: singleSelect});
    }-*/;

    public RowSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Clears all selections.
     */
    public native void clearSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.clearSelections();
    }-*/;

    /**
     * Deselects a range of rows. All rows in between startRow and endRow are also deselected.
     *
     * @param startRow the index of the first row in the range
     * @param endRow   the index of the last row in the range
     */
    public native void deselectRange(int startRow, int endRow) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.deselectRange(startRow, endRow);
    }-*/;

    /**
     * Deselects a row.
     *
     * @param row the index of the row to deselect
     */
    public native void deselectRow(int row) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.deselectRow(row);
    }-*/;

    /**
     * Gets the number of selected rows.
     *
     * @return the number of selected rows
     */
    public native int getCount() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.getCount();
    }-*/;

    /**
     * Returns the first selected record.
     *
     * @return the first selected record
     */
    public native Record getSelected() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var selected = sm.getSelected();
        return selected == null ? null : @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(selected);
    }-*/;

    /**
     * Returns the selected records.
     *
     * @return the selected records
     */
    public native Record[] getSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var records = sm.getSelections();
        return records == null ? null : @com.gwtext.client.data.Store::convertFromNativeRecordsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
    }-*/;

    /**
     * Returns true if there is a selection.
     *
     * @return true if there is a selection
     */
    public native boolean hasSelection() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.hasSelection();
    }-*/;

    /**
     * Returns true if the specified record id is selected.
     *
     * @param id the id of record to check
     * @return true if selected
     */
    public native boolean isIdSelected(String id) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.isIdSelected(id);
    }-*/;

    /**
     * Returns true if the selections are locked.
     *
     * @return true if selections are locked
     */
    public native boolean isLocked() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.isLocked();
    }-*/;

    /**
     * Returns true if row is selected.
     *
     * @param row the row index
     * @return true if selected
     */
    public native boolean isSelected(int row) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.isSelected(row);
    }-*/;

    /**
     * Returns true if the record is selected.
     *
     * @param record the record to check
     * @return true if selected
     */
    public native boolean isSelected(Record record) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var recordJ = record.@com.gwtext.client.core.JsObject::getJsObj()();
        return sm.isSelected(recordJ);
    }-*/;

    /**
     * Selects all rows.
     */
    public native void selectAll() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectAll();
    }-*/;

    /**
     * Selects the first row.
     */
    public native void selectFirstRow() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectFirstRow();
    }-*/;

    /**
     * Selects the last row.
     */
    public native void selectLastRow() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectLastRow();
    }-*/;

    /**
     * Seletcs the last row.
     *
     * @param keepExisting true to keep existing selection
     */
    public native void selectLastRow(boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectLastRow(keepExisting);
    }-*/;

    /**
     * Selects the row immediately following the last selected row.
     */
    public native void selectNext() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectNext();
    }-*/;

    /**
     * Selects the row that precedes the last selected row.
     */
    public native void selectPrevious() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectPrevious();
    }-*/;

    /**
     * Selects a range of rows. All rows in between startRow and endRow are also selected.
     *
     * @param startRow the index of the first row
     * @param endRow   the index of the last row
     */
    public native void selectRange(int startRow, int endRow) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectRange(startRow, endRow);
    }-*/;

    /**
     * Selects a range of rows. All rows in between startRow and endRow are also selected.
     *
     * @param startRow     the index of the first row
     * @param endRow       the index of the last row
     * @param keepExisting keep the existing selection
     */
    public native void selectRange(int startRow, int endRow, boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectRange(startRow, endRow, keepExisting);
    }-*/;

    /**
     * Selects a row.
     *
     * @param row the row index to select
     */
    public native void selectRow(int row) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectRow(row);
    }-*/;

    /**
     * Selects a row.
     *
     * @param row          the row index to select
     * @param keepExisting keep existing selection
     */
    public native void selectRow(int row, boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.selectRow(row, keepExisting);
    }-*/;


    /**
     * Selects multiple rows.
     *
     * @param rows array of the indexes of the row to select
     */
    public native void selectRows(int[] rows) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var rowsJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(rows);
        sm.selectRows(rowsJS);
    }-*/;

    /**
     * Selects multiple rows.
     *
     * @param rows         array of the indexes of the row to select
     * @param keepExisting keep the existing selection
     */
    public native void selectRows(int[] rows, boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var rowsJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(rows);
        sm.selectRows(rowsJS, keepExisting);
    }-*/;

    /**
     * Add a Row selection listener.
     *
     * @param listener the listener
     */
    public native void addListener(RowSelectionListener listener) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var smJ = this;

        sm.addListener('beforerowselect',
                function(source, rowIndex, keepExisting, record) {
                    if(keepExisting === undefined) {
                        keepExisting = false;
                    }
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                    return listener.@com.gwtext.client.widgets.grid.event.RowSelectionListener::doBeforeRowSelect(Lcom/gwtext/client/widgets/grid/RowSelectionModel;IZLcom/gwtext/client/data/Record;)(smJ, rowIndex, keepExisting, recordJ);
                }
        );

        sm.addListener('rowselect',
                function(source, rowIndex, record) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                    listener.@com.gwtext.client.widgets.grid.event.RowSelectionListener::onRowSelect(Lcom/gwtext/client/widgets/grid/RowSelectionModel;ILcom/gwtext/client/data/Record;)(smJ, rowIndex, recordJ);
                }
        );

        sm.addListener('rowdeselect',
                function(source, rowIndex, record) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                    listener.@com.gwtext.client.widgets.grid.event.RowSelectionListener::onRowDeselect(Lcom/gwtext/client/widgets/grid/RowSelectionModel;ILcom/gwtext/client/data/Record;)(smJ, rowIndex, recordJ);
                }
        );

        sm.addListener('selectionchange',
                function(source) {
                    listener.@com.gwtext.client.widgets.grid.event.RowSelectionListener::onSelectionChange(Lcom/gwtext/client/widgets/grid/RowSelectionModel;)(smJ);
                }
        );
    }-*/;
}
