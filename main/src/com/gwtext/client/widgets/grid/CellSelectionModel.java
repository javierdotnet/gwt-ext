/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.grid.event.CellSelectionModelListener;

/**
 * This class provides the basic implementation for cell selection in a grid.
 */
public class CellSelectionModel extends AbstractSelectionModel {

    public CellSelectionModel(JavaScriptObject jsObj) {
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
     * Clears all selections.
     *
     * @param disableNotifications true to disable notifications to the {@link GridView}
     */
    public native void clearSelections(boolean disableNotifications) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.clearSelections(disableNotifications);
    }-*/;

    /**
     * Returns the currently selected cell.
     *
     * @return array containing rowIndex, colIndex
     */
    public native int[] getSelectedCell() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var sc = sm.getSelectedCell();
        return sc == null ? null : @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(sc);
    }-*/;

    /**
     * Selects a cell.
     *
     * @param rowIndex  row index of cell
     * @param cellIndex column index of cell
     */
    public native void select(int rowIndex, int cellIndex)/*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        sm.select(rowIndex, cellIndex);
    }-*/;

    /**
     * Adds a Cell Selection model listener.
     *
     * @param listener the listener
     */
    public native void addListener(CellSelectionModelListener listener) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var smJ = this;

        sm.addListener('beforerowselect',
                function(source, rowIndex, colIndex) {
                    return listener.@com.gwtext.client.widgets.grid.event.CellSelectionModelListener::doBeforeRowSelect(Lcom/gwtext/client/widgets/grid/CellSelectionModel;II)(smJ, rowIndex, colIndex);
                }
        );

        sm.addListener('cellselect',
                function(source, rowIndex, colIndex) {
                    listener.@com.gwtext.client.widgets.grid.event.CellSelectionModelListener::onCellSelect(Lcom/gwtext/client/widgets/grid/CellSelectionModel;II)(smJ, rowIndex, colIndex);
                }
        );

        sm.addListener('selectionchange',
                function(source, selection) {
                    var recordJ = null;
                    var cell = null;
                    if(selection != null && selection.record != null) {
                        recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(selection.record);
                        cell = selection.cell;
                    }
                    var cellJ = (cell == null || cell === undefined) ? null : @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(cell);
                    listener.@com.gwtext.client.widgets.grid.event.CellSelectionModelListener::onSelectionChange(Lcom/gwtext/client/widgets/grid/CellSelectionModel;Lcom/gwtext/client/data/Record;[I)(smJ, recordJ, cellJ);
                }
        );
    }-*/;
}
