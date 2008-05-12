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
 

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.grid.event.CellSelectionModelListener;

/**
 * This class provides the basic implementation for cell selection in a grid.
 *
 * @author Sanjiv Jivan
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
