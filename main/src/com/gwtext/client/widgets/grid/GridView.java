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

public class GridView extends JsObject {

    public GridView(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ExtElement getHeaderPanel(boolean doShow) {
        return new ExtElement(getHeaderPanel(jsObj, doShow));
    }

    private native JavaScriptObject getHeaderPanel(JavaScriptObject view, boolean doShow) /*-{
        return view.getHeaderPanel(doShow);
    }-*/;

    public ExtElement getFooterPanel(boolean doShow) {
        return new ExtElement(getFooterPanel(jsObj, doShow));
    }

    private native JavaScriptObject getFooterPanel(JavaScriptObject view, boolean doShow) /*-{
        return view.getFooterPanel(doShow);
    }-*/;

    public native void refresh() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.refresh();
    }-*/;

    public native void refresh(boolean headersToo) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.refresh(headersToo);
    }-*/;

    public native void refreshRow(int index) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.refreshRow(index);
    }-*/;

    public native void refreshRow(Record record) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var recordJS = record.@com.gwtext.client.core.JsObject::jsObj;
        view.refreshRow(recordJS);
    }-*/;

    public native void scrollToTop() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.scrollToTop();
    }-*/;

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

    public native Element getRow(int index)/*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var rowEl = view.getRow(index);
        return rowEl === undefined ? null : rowEl;
    }-*/;

    public native Element getCell(int rowIndex, int colIndex)/*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = view.getCell(rowIndex, colIndex);
        return el=== undefined ? null : el;
    }-*/;

    public native void focusRow(int rowIndex) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.focusRow(rowIndex);
    }-*/;

    public native void focusCell(int rowIndex, int colIndex, boolean hscroll) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.focusCell(rowIndex, colIndex, hscroll);
    }-*/;

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

    public native void autoSizeColumn(int colIndex, boolean forceMinSize) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.autoSizeColumn(colIndex, forceMinSize);
    }-*/;

    public native void autoSizeColumn(int colIndex, boolean forceMinSize, boolean suppressEvent) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.autoSizeColumn(colIndex, forceMinSize, suppressEvent);
    }-*/;

    public native void autoSizeColumns() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.autoSizeColumns();
    }-*/;

    public native void fitColumns(boolean reserveScrollSpace) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.fitColumns(reserveScrollSpace);
    }-*/;

    public native void updateHeaderSortState() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.updateHeaderSortState();
    }-*/;
}
