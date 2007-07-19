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
import com.gwtext.client.widgets.grid.event.CellSelectionModelListener;

public class CellSelectionModel extends AbstractSelectionModel {
    public CellSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public native void clearSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.clearSelections();
    }-*/;

    public native void clearSelections(boolean disableNotifications) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.clearSelections(disableNotifications);
    }-*/;

    /**
     * @return  array containing rowIndex, colIndex
     */
    public native int[] getSelectedCell() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var sc = sm.getSelectedCell();
        return sc == null ? null : @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(sc);
    }-*/;

    public native void addCellSelectionModelListener(CellSelectionModelListener listener) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
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
