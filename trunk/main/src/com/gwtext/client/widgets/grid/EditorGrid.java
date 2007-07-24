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
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.grid.event.EditorGridListener;

public class EditorGrid extends Grid {

    public EditorGrid(String id, String width, String height, Store store, ColumnModel columnModel) {
        this(id, width, height, store, columnModel, new EditorGridConfig());
    }
    
    public EditorGrid(String id, String width, String height, Store store, ColumnModel columnModel, EditorGridConfig config) {
        super(id, width, height, store, columnModel, config);
    }

    public EditorGrid(String id, String width, String height, Store store, ColumnModel columnModel, AbstractSelectionModel selectionModel, EditorGridConfig config) {
        super(id, width, height, store, columnModel, selectionModel, config);
    }

    protected native JavaScriptObject create(String id, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.EditorGrid(id, configJS);
    }-*/;

    //todo need to convert values to string : via toString() as cell value may be non string data type.
    //Or need to find way to introspect and convert JS type into corresponding java 'Object' type
    public native void addEditorGridListener(EditorGridListener listener)/*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;

        grid.addListener('afteredit',
                function(e) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e.record);
                    var value = e.value == null ? null : e.value.toString();
                    var originalValue = e.originalValue == null ? null : e.originalValue.toString();
                    listener.@com.gwtext.client.widgets.grid.event.EditorGridListener::onAfterEdit(Lcom/gwtext/client/widgets/grid/Grid;Lcom/gwtext/client/data/Record;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)(gridJ, recordJ, e.field, value , originalValue, e.row, e.column);
                }
        );        

        grid.addListener('beforeedit',
                function(e) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e.record);
                    var value = e.value == null ? null : e.value.toString();
                    return listener.@com.gwtext.client.widgets.grid.event.EditorGridListener::doBeforeEdit(Lcom/gwtext/client/widgets/grid/Grid;Lcom/gwtext/client/data/Record;Ljava/lang/String;Ljava/lang/String;II)(gridJ, recordJ, e.field, value, e.row, e.column);
                }
        );

        grid.addListener('validateedit',
                function(e) {
                    var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e.record);
                    var value = e.value == null ? null : e.value.toString();
                    var originalValue = e.originalValue == null ? null : e.originalValue.toString();
                    return listener.@com.gwtext.client.widgets.grid.event.EditorGridListener::doValidateEdit(Lcom/gwtext/client/widgets/grid/Grid;Lcom/gwtext/client/data/Record;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)(gridJ, recordJ, e.field, value, originalValue,  e.row, e.column);
                }
        );
    }-*/;

    public native void startEditing(int rowIndex, int colIndex) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.startEditing(rowIndex, colIndex);
    }-*/;

    public native void stopEditing() /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.stopEditing();
    }-*/;
        
    public CellSelectionModel getCellSelectionModel() {
        return new CellSelectionModel(getSelectionModel(jsObj));
    }

    private native JavaScriptObject getSelectionModel(JavaScriptObject grid) /*-{
        return grid.getSelectionModel();
    }-*/;
}
