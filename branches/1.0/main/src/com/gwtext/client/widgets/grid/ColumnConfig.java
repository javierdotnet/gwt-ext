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

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.TextAlign;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * The Grid Column configuration.
 *
 * @see com.gwtext.client.widgets.grid.Grid
 * @see com.gwtext.client.widgets.grid.ColumnModel
 */
public class ColumnConfig extends BaseConfig {

    /**
     * Set the CSS text-align property of the column. Defaults to undefined.
     *
     * @param align the text-align value
     * @deprecated User {@link #setAlign(com.gwtext.client.core.TextAlign)}
     */
    public void setAlign(String align) {
        JavaScriptObjectHelper.setAttribute(jsObj, "align", align);
    }

    /**
     * Set the CSS text-align property of the column. Defaults to undefined.
     *
     * @param align the text-align position
     */
    public void setAlign(TextAlign align) {
        JavaScriptObjectHelper.setAttribute(jsObj, "align", align.getPosition());
    }

    /**
     * Assigning id to ColumnConfig results in the column dom element having that ID.
     * This is useful to apply custom css to the entire column. (e.g. .x-grid-col-topic b { color:#333 }) .
     *
     * @param id the column ID
     */
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
    }

    /**
     * The name of the field in the grid's {@link com.gwtext.client.data.Store}'s {@link com.gwtext.client.data.Record} definition
     * from which to draw the column's value. If not specified, the column's index is used as an index into the Record's data array.
     * 
     * @param dataIndex the data index
     */
    public void setDataIndex(String dataIndex) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dataIndex", dataIndex);
    }

    /**
     *  Adda tooltip to the column header
     *
     * @param tooltip the tooltip
     */
    public void setTooltip(String tooltip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tooltip", tooltip);
    }
    /**
     * Sets teh CSS class for the column,
     *
     * @param css the CSS class
     */
    public void setCss(String css) {
        JavaScriptObjectHelper.setAttribute(jsObj, "css", css);
    }

    /**
     *  The header text to display in the Grid view. You can use arbitrary html for the header.
     *
     * @param header the column header
     */
    public void setHeader(String header) {
        JavaScriptObjectHelper.setAttribute(jsObj, "header", header);
    }

    /**
     * True to hide the column. Defaults to false.
     *
     * @param hidden true to hide column
     */
    public void setHidden(boolean hidden) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hidden", hidden);
    }

    /**
     * True to lock the column in place while scrolling the Grid. Defaults to false.
     *
     * @param locked true to lock column
     */
    public void setLocked(boolean locked) {
        JavaScriptObjectHelper.setAttribute(jsObj, "locked", locked);
    }

    /**
     * True to make the column width fixed.
     *
     * @param fixed true for fixed width
     */
    public void setFixed(boolean fixed) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fixed", fixed);
    }

    /**
     * Sets the rendering (formatting) function for a column.
     *
     * @param renderer the column renderer
     */
    public native void setRenderer(Renderer renderer) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;

        config['renderer'] = function(val, cell, r, rowIndex, colNum, store) {
            var valJ = (val  == null || val === undefined || val === '') ? null : $wnd.GwtExt.convertToJavaType(val);
            var recJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            var cellJ = @com.gwtext.client.widgets.grid.ColumnModel::createCellMetadata(Lcom/google/gwt/core/client/JavaScriptObject;)(cell);
            var storeJ = @com.gwtext.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
            return renderer.@com.gwtext.client.widgets.grid.Renderer::render(Ljava/lang/Object;Lcom/gwtext/client/widgets/grid/CellMetadata;Lcom/gwtext/client/data/Record;IILcom/gwtext/client/data/Store;)(valJ, cellJ, recJ, rowIndex, colNum, storeJ);
        }
    }-*/;

    /**
     * False to disable column resizing. Defaults to true.
     * 
     * @param resizable false to disable column resizing
     */
    public void setResizable(boolean resizable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizable", resizable);
    }

    //todo see possible format strings in Ext.util.Format
    public void setRenderer(String renderer) {
        JavaScriptObjectHelper.setAttribute(jsObj, "renderer", renderer);
    }

    /**
     * True if sorting is to be allowed on this column. Defaults to the value of {@link com.gwtext.client.widgets.grid.ColumnModel#setDefaultSortable(boolean)}.
     * Whether local/remote sorting is used is specified in {@link com.gwtext.client.data.Store#Store(com.gwtext.client.data.DataProxy, com.gwtext.client.data.Reader, boolean)}
     *
     * @param sortable false to disable sorting
     */
    public void setSortable(boolean sortable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "sortable", sortable);
    }

    /**
     * The initial width in pixels of the column. Using this instead of {@link com.gwtext.client.widgets.grid.GridConfig#setAutoSizeColumns(boolean)}  is more efficient.
     *
     * @param width the column width
     */
    public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

    /**
     * Sets the editor for a column.
     *
     * @param editor the column editor
     */
    public void setEditor(GridEditor editor) {
        JavaScriptObjectHelper.setAttribute(jsObj, "editor", editor.getJsObj());
    }
}
