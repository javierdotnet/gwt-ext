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

public class RowSelectionModel extends AbstractSelectionModel {

    public RowSelectionModel() {
        this(false);
    }

    public RowSelectionModel(boolean singleSelect) {
        jsObj = create(singleSelect);
    }

    private native JavaScriptObject create(boolean singleSelect) /*-{
        return new $wnd.Ext.grid.RowSelectionModel({singleSelect: singleSelect});
    }-*/;

    public RowSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public native void clearSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.clearSelections();
    }-*/;

    public native void deselectRange(int startRow, int endRow) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.deselectRange(startRow, endRow);
    }-*/;

    public native void deselectRow(int row) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.deselectRow(row);
    }-*/;

    public native int getCount() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.getCount();
    }-*/;

    public native Record getSelected() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var selected = sm.getSelected();
        return selected == null ? null : @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(selected);
    }-*/;

    public native Record[] getSelections() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var records = sm.getSelections();
        return records == null ? null : @com.gwtext.client.data.Store::convertFromNativeRecordsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
    }-*/;

    public native boolean hasSelection() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.hasSelection();
    }-*/;

    public native boolean isIdSelected(String id) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.isIdSelected(id);
    }-*/;

    public native boolean isSelected(int row) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.isSelected(row);
    }-*/;

    public native void selectAll() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectAll();
    }-*/;

    public native void selectFirstRow() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectFirstRow();
    }-*/;

    public native void selectLastRow() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectLastRow();
    }-*/;

    public native void selectLastRow(boolean keepExisting) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectLastRow(keepExisting);
    }-*/;

    public native void selectNext() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectNext();
    }-*/;

    public native void selectPrevious() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectPrevious();
    }-*/;

    public native void selectRange(int startRow, int endRow) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectRange(startRow, endRow);
    }-*/;

    public native void selectRow(int row) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.selectRow(row);
    }-*/;

    public native void selectRows(int[] rows) /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        var rowsJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(rows);
        sm.selectRows(rowsJS);
    }-*/;

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
