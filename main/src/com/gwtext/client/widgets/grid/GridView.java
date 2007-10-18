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
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.data.Record;

/**
 * A Grid's View class.
 */
public class GridView extends JsObject {

    public GridView(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Constructs a new GridView.
     *
     */
    public GridView() {
        jsObj = create();
    }

    private native JavaScriptObject create() /*-{
        var gridJ = this;
        var gridV = new $wnd.Ext.grid.GridView();
        gridV.getRowClass = function(record, index) {
            var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return gridJ.@com.gwtext.client.widgets.grid.GridView::getRowClass(Lcom/gwtext/client/data/Record;I)(recordJ, index);
        }
        return gridV;
    }-*/;

    /**
     * Gets a panel in the header of the grid that can be used for toolbars etc. After modifying the contents of
     * this panel a call to {@link com.gwtext.client.widgets.grid.Grid#autoSize()} may be required to register any changes in size.
     *
     * @param doShow by default the header is hidden. Pass true to show the panel
     * @return the header element
     */
    public ExtElement getHeaderPanel(boolean doShow) {
        return new ExtElement(getHeaderPanel(jsObj, doShow));
    }

    private native JavaScriptObject getHeaderPanel(JavaScriptObject view, boolean doShow) /*-{
        return view.getHeaderPanel(doShow);
    }-*/;

    /**
     * Gets a panel in the footer of the grid that can be used for toolbars etc. After modifying the contents of this panel a
     * call to {@link com.gwtext.client.widgets.grid.Grid#autoSize()} may be required to register any changes in size.
     *
     * @param doShow by default the header is hidden. Pass true to show the panel
     * @return the footer panel
     */
    public ExtElement getFooterPanel(boolean doShow) {
        return new ExtElement(getFooterPanel(jsObj, doShow));
    }

    private native JavaScriptObject getFooterPanel(JavaScriptObject view, boolean doShow) /*-{
        return view.getFooterPanel(doShow);
    }-*/;

    /**
     * Refreshes the grid.
     */
    public native void refresh() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.refresh();
    }-*/;

    /**
     * Refreshes the grid.
     *
     * @param headersToo true to refresh the headers too
     */
    public native void refresh(boolean headersToo) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.refresh(headersToo);
    }-*/;

    /**
     * Override this function to apply custom css classes to rows during rendering.
     *
     * @param record the record for the row
     * @param index the row index
     * @return the row CSS class
     */
    public String getRowClass(Record record, int index) {
        return "";
    }

    /**
     * Refresh a row.
     *
     * @param index the row to refresh
     */
    public native void refreshRow(int index) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.refreshRow(index);
    }-*/;

    /**
     * The record to refresh.
     *
     * @param record the record
     */
    public native void refreshRow(Record record) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var recordJS = record.@com.gwtext.client.core.JsObject::jsObj;
        view.refreshRow(recordJS);
    }-*/;

    /**
     * Scrolls the grid to the top.
     */
    public native void scrollToTop() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.scrollToTop();
    }-*/;

    /**
     * Return the header cell.
     *
     * @param index header index
     * @return the header cell
     */
    public native Element getHeaderCell(int index)/*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var headerCellEl = view.getHeaderCell(index);
        return headerCellEl === undefined ? null : headerCellEl;
    }-*/;


    public native Element getLockedRow(int index)/*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var rowEl = view.getLockedRow(index);
        return rowEl === undefined ? null : rowEl;
    }-*/;

    /**
     * Returns the row element.
     *
     * @param index row index
     * @return the row element
     */
    public native Element getRow(int index)/*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var rowEl = view.getRow(index);
        return rowEl === undefined ? null : rowEl;
    }-*/;

    /**
     * Returns a cells element.
     *
     * @param rowIndex the row index
     * @param colIndex the column index
     * @return the cell element
     */
    public native Element getCell(int rowIndex, int colIndex)/*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = view.getCell(rowIndex, colIndex);
        return el=== undefined ? null : el;
    }-*/;

    /**
     * Focusses the specified row.
     *
     * @param rowIndex the row index
     */
    public native void focusRow(int rowIndex) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.focusRow(rowIndex);
    }-*/;

    /**
     * Focuses the specified cell.
     *
     * @param rowIndex the row index
     * @param colIndex the column index
     * @param hscroll false to disable horizontal scrolling
     */
    public native void focusCell(int rowIndex, int colIndex, boolean hscroll) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.focusCell(rowIndex, colIndex, hscroll);
    }-*/;

    /**
     * Scrolls the specified cell into view.
     * 
     * @param rowIndex the row index
     * @param colIndex the column index
     * @param hscroll false to disable horizontal scrolling
     */
    public native void ensureVisible(int rowIndex, int colIndex, boolean hscroll) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.ensureVisible(rowIndex, colIndex, hscroll);
    }-*/;

    public native void hideColumn(int colIndex) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.hideColumn(colIndex);
    }-*/;

    public native void unhideColumn(int colIndex) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.unhideColumn(colIndex);
    }-*/;

    public native void updateRows() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.updateRows();
    }-*/;

    public native void stripeRows(int startRow) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.stripeRows(startRow);
    }-*/;

    /**
     * Autofit a column to its content.
     *
     * @param colIndex the column index
     * @param forceMinSize true to force the column to go smaller if possible
     */
    public native void autoSizeColumn(int colIndex, boolean forceMinSize) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.autoSizeColumn(colIndex, forceMinSize);
    }-*/;

    /**
     * Autofit a column to its content.
     *
     * @param colIndex the column index
     * @param forceMinSize true to force the column to go smaller if possible
     * @param suppressEvent true to suppress solumn resize event
     */
    public native void autoSizeColumn(int colIndex, boolean forceMinSize, boolean suppressEvent) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.autoSizeColumn(colIndex, forceMinSize, suppressEvent);
    }-*/;

    /**
     * Autofits all columns to their content and then expands to fit any extra space in the grid.
     */
    public native void autoSizeColumns() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.autoSizeColumns();
    }-*/;

    /**
     * Autofits all columns to the grid's width proportionate with their current size.
     * 
     * @param reserveScrollSpace reserve space for a scrollbar
     */
    public native void fitColumns(boolean reserveScrollSpace) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.fitColumns(reserveScrollSpace);
    }-*/;

    /**
     * Update the headers sort state.
     */
    public native void updateHeaderSortState() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.updateHeaderSortState();
    }-*/;
}
