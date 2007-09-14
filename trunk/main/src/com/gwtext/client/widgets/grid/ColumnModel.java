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
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.event.ColumnModelListener;

public class ColumnModel extends JsObject {

    public ColumnModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ColumnModel(ColumnConfig[] columns) {
        JavaScriptObject[] config = new JavaScriptObject[columns.length];
        for (int i = 0; i < columns.length; i++) {
            ColumnConfig column = columns[i];
            config[i] = column.getJsObj();
        }
        JavaScriptObject configJS = JavaScriptObjectHelper.convertToJavaScriptArray(config);
        jsObj = create(configJS);
    }

    public native JavaScriptObject create(JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.ColumnModel(configJS);
    }-*/;


    public native void setDefaultSortable(boolean defaultSortable)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.defaultSortable = defaultSortable;
    }-*/;

    public native void setDefaultWidth(int defaultWidth)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.defaultWidth = defaultWidth;
    }-*/;

    //TODO
    //http://extjs.com/forum/showthread.php?t=6025&highlight=getCellEditor
    //need to support way to allow user to plug in logic based cell editors
    //public GridEditor getCellEditor(int colIndex, int rowIndex)

    public native int getColumnCount()/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnCount();
    }-*/;

    public native String getColumnHeader(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnHeader(colIndex);
    }-*/;

    /**
     * @param colIndex
     * @return the column id set by the user using {@link com.gwtext.client.widgets.grid.ColumnConfig#setId(String)}. If the
     *         user did not set the id for the column, then the column position is returned as a String.
     */
    public native String getColumnId(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnId(colIndex).toString();
    }-*/;

    public native String getColumnTooltip(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnTooltip(colIndex);
    }-*/;

    public native int getColumnWidth(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnWidth(colIndex);
    }-*/;

    //TODO
    //getColumnsBy(Function fn, [Object scope]) : Array

    public native String getDataIndex(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getDataIndex(colIndex).toString();
    }-*/;

    /**
     * Returns the index for a specified column id.
     * @param id column id used in ColumnConfig when defining the ColumnModel
     * @return column index (0 based), -1 if not found
     * @see ColumnConfig#setId(String)
     */
    public native int getIndexById(String id) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getIndexById(id);
    }-*/;

    //TODO getRenderer is required??

    public native int getTotalWidth()/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getTotalWidth();
    }-*/;

    public native int getTotalWidth(boolean includeHidden)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getTotalWidth(includeHidden);
    }-*/;

    //TODO support pluggable strategy for logic of editable cells
    public native boolean isCellEditable(int colIndex, int rowIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isCellEditable(colIndex, rowIndex);
    }-*/;

    public native boolean isFixed(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isFixed(colIndex);
    }-*/;

    public native boolean isHidden(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isHidden(colIndex);
    }-*/;

    /**
     * Returns if the column is locked.
     * @param colIndex column index (0 based)
     * @return locked
     */
    public native boolean isLocked(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;

        var locked = null;
        try {
            cm.isLocked(colIndex);
        } catch(e) {
            locked = false;
        }
        return locked === undefined || locked == null? false : locked;
    }-*/;

    public native boolean isResizable(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isResizable(colIndex);
    }-*/;

    public native boolean isSortable(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isSortable(colIndex);
    }-*/;

    public native void setColumnHeader(int colIndex, String header) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setColumnHeader(colIndex, header);
    }-*/;

    public native void setColumnWidth(int colIndex, int width) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setColumnWidth(colIndex, width);
    }-*/;

    public native void setDataIndex(int colIndex, int dataIndex) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setDataIndex(colIndex, dataIndex);
    }-*/;

    public native void setEditable(int colIndex, boolean editable) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setEditable(colIndex, editable);
    }-*/;

    public native void setEditor(int colIndex, GridEditor editor) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setEditor(colIndex, editor.@com.gwtext.client.core.JsObject::jsObj);
    }-*/;

    public native void setHidden(int colIndex, boolean hidden) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setHidden(colIndex, hidden);
    }-*/;

    private static CellMetadata createCellMetadata(final JavaScriptObject jsObj) {
        return new CellMetadata() {
            public void setCssClass(String cssClass) {
                JavaScriptObjectHelper.setAttribute(jsObj, "css", cssClass);
            }

            public void setHtmlAttribute(String htmlAttribute) {
                JavaScriptObjectHelper.setAttribute(jsObj, "attr", htmlAttribute);
            }
        };
    }

    public native void setRenderer(int colIndex, Renderer renderer) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setRenderer(colIndex, function(val, cell, r, rowIndex, colNum, store) {
            var valJ = (val  == null || val === undefined ) ? null : $wnd.GwtExt.convertToJavaType(val);
            var recJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            var cellJ = @com.gwtext.client.widgets.grid.ColumnModel::createCellMetadata(Lcom/google/gwt/core/client/JavaScriptObject;)(cell);
            var storeJ = @com.gwtext.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
            return renderer.@com.gwtext.client.widgets.grid.Renderer::render(Ljava/lang/Object;Lcom/gwtext/client/widgets/grid/CellMetadata;Lcom/gwtext/client/data/Record;IILcom/gwtext/client/data/Store;)(valJ, cellJ, recJ, rowIndex, colNum, storeJ);                        
        });
    }-*/;

    public native void addColumnModelListener(ColumnModelListener listener) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        var cmJ = this;

        cm.addListener('columnlockchange',
                function(source, colIndex, locked) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onColumnLockChange(Lcom/gwtext/client/widgets/grid/ColumnModel;IZ)(cmJ, colIndex, locked);
                }
        );

        cm.addListener('columnmoved',
                function(source, oldIndex, newIndex) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onColumnMoved(Lcom/gwtext/client/widgets/grid/ColumnModel;II)(cmJ, oldIndex, newIndex);
                }
        );

        cm.addListener('headerchange',
                function(source, colIndex, newText) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onHeaderChange(Lcom/gwtext/client/widgets/grid/ColumnModel;ILjava/lang/String;)(cmJ, colIndex, newText);
                }
        );

        cm.addListener('hiddenchange',
                function(source, colIndex, hidden) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onHiddenChange(Lcom/gwtext/client/widgets/grid/ColumnModel;IZ)(cmJ, colIndex, hidden);
                }
        );

        cm.addListener('widthchange',
                function(source, colIndex, newWidth) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onWidthChange(Lcom/gwtext/client/widgets/grid/ColumnModel;II)(cmJ, colIndex, newWidth);
                }
        );
    }-*/;

}
