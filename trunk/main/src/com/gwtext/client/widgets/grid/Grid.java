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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.Ext;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.BaseExtWidget;
import com.gwtext.client.widgets.grid.event.*;

public class Grid extends BaseExtWidget {

    public Grid(String id, String width, String height, Store store, ColumnModel columnModel) {
        this(id, width, height, store, columnModel, new GridConfig());
    }
    public Grid(String id,  String width, String height, Store store, ColumnModel columnModel, GridConfig config) {
        this(id, width, height, store, columnModel, null, config);
    }

    public Grid(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public Grid(String id, String width, String height, Store store, ColumnModel columnModel, AbstractSelectionModel selectionModel, GridConfig config) {

        RootPanel.get().add(new HTML("<div id='" + id + "'></div>"));
        Element div = DOM.getElementById(id);

        final JavaScriptObject configJS = config.getJsObj();
        JavaScriptObjectHelper.setAttribute(configJS, "ds", store.getJsObj());
        JavaScriptObjectHelper.setAttribute(configJS, "cm", columnModel.getJsObj());
        if (selectionModel != null)
            JavaScriptObjectHelper.setAttribute(configJS, "selModel", selectionModel.getJsObj());

        jsObj = create(id, configJS);
        setElement(div);
        setHeight(height);
        setWidth(width);

    }

    protected native JavaScriptObject create(String id, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.Grid(id, configJS);
    }-*/;


    protected native JavaScriptObject create(Element elem, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.Grid(elem, configJS);
    }-*/;

    public native void autoSize() /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.autoSize();
    }-*/;

    public native void destroy() /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.destroy();
    }-*/;

    public native void destroy(boolean removeEl) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.destroy(removeEl);
    }-*/;

    public ColumnModel getColumnModel() {
        return new ColumnModel(getColumnModel(jsObj));
    }

    private native JavaScriptObject getColumnModel(JavaScriptObject grid) /*-{
        return grid.getColumnModel();
    }-*/;

    //intead of getDataSource()
    public Store getStore() {
        return new Store(getStore(jsObj));
    }

    public native JavaScriptObject getStore(JavaScriptObject grid) /*-{
        return grid.getDataSource();
    }-*/;

    public native String getDragDropText() /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return grid.getDragDropText();
    }-*/;

    public native void getDragDropText(String text) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.ddText = text;
    }-*/;

    public RowSelectionModel getSelectionModel() {
        return new RowSelectionModel(getSelectionModel(jsObj));
    }

    private native JavaScriptObject getSelectionModel(JavaScriptObject grid) /*-{
        return grid.getSelectionModel();            
    }-*/;

    public GridView getView() {
        return new GridView(getView(jsObj));
    }

    private native JavaScriptObject getView(JavaScriptObject grid) /*-{
        return grid.getView();
    }-*/;

    public void render() {
        render(jsObj);
        //fixes issue with grid being displayed in table
        //see http://extjs.com/forum/showthread.php?t=2613
        if (Ext.isIE()) {
            addGridColumnListener(new GridColumnListenerAdapter() {
                public void onColumnResize(Grid grid, int colIndex, int newSize) {
                    adjustColumns(grid.getJsObj());
                }
            });
        }
    }

    //fix for grid rendering issues in IE when grid in table
    private native void adjustColumns(JavaScriptObject grid) /*-{
        var view = grid.getView();
        view.refresh();
        view.updateHeaders();
        view.updateColumns();
        view.updateSplitters();
        view.updateHeaderSortState();
        view.renderPhase2.defer(1, grid);

    }-*/;


    public native void render(JavaScriptObject grid) /*-{
        grid.render();
    }-*/;


    //TODO reconfigure()
    //http://extjs.com/forum/showthread.php?t=8694&highlight=grid+reconfigure
    
    public native void addGridCellListener(GridCellListener listener) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;

        grid.addListener('cellclick',
                function(self, rowIndex, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridCellListener::onCellClick(Lcom/gwtext/client/widgets/grid/Grid;IILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, colIndex, e);
                }
        );

        grid.addListener('cellcontextmenu',
                function(self, rowIndex, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridCellListener::onCellContextMenu(Lcom/gwtext/client/widgets/grid/Grid;IILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, colIndex, e);
                }
        );

        grid.addListener('celldblclick',
                function(self, rowIndex, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridCellListener::onCellDblClick(Lcom/gwtext/client/widgets/grid/Grid;IILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, colIndex, e);
                }
        );
    }-*/;

    public native void addGridColumnListener(GridColumnListener listener) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;

        grid.addListener('columnmove',
                function(oldIndex, newIndex) {
                    listener.@com.gwtext.client.widgets.grid.event.GridColumnListener::onColumnMove(Lcom/gwtext/client/widgets/grid/Grid;II)(gridJ, oldIndex, newIndex);
                }
        );
        grid.addListener('columnresize',
                function(colIndex, newSize) {
                    listener.@com.gwtext.client.widgets.grid.event.GridColumnListener::onColumnResize(Lcom/gwtext/client/widgets/grid/Grid;II)(gridJ, colIndex, newSize);
                }
        );
    }-*/;

    public native void addGridDragListener(GridDragListener listener) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;

       //TODO
    }-*/;

    public native void addGridHeaderListener(GridHeaderListener listener) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;

        grid.addListener('click',
                function(g, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridHeaderListener::onHeaderClick(Lcom/gwtext/client/widgets/grid/Grid;ILcom/gwtext/client/core/EventObject;)(gridJ, colIndex, e);
                }
        );
        grid.addListener('headercontextmenu',
                function(g, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridHeaderListener::onHeaderContextMenu(Lcom/gwtext/client/widgets/grid/Grid;ILcom/gwtext/client/core/EventObject;)(gridJ, colIndex, e);
                }
        );
        //todo check signature as it currently has rowindex
        grid.addListener('headerdblclick',
                function(g, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridHeaderListener::onHeaderDblClick(Lcom/gwtext/client/widgets/grid/Grid;ILcom/gwtext/client/core/EventObject;)(gridJ, colIndex, e);
                }
        );
    }-*/;

    public native void addGridListener(GridListener listener) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;

        grid.addListener('bodyscroll',
                function(scrollLeft, scrollTop) {
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onBodyScroll(II)(scrollLeft, scrollTop);
                }
        );
        grid.addListener('click',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onClick(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );
        grid.addListener('contextmenu',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onContextMenu(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );
        grid.addListener('dblclick',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onDblClick(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );

        grid.addListener('keydown',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onKeyDown(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );

        grid.addListener('keypress',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onKeyPress(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );

        grid.addListener('render',
                function(g) {
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onRender(Lcom/gwtext/client/widgets/grid/Grid;)(gridJ);
                }
        );

    }-*/;

    public native void addGridMouseListener(GridMouseListener listener) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;

        grid.addListener('mousedown',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridMouseListener::onMouseDown(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );
        grid.addListener('mouseout',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridMouseListener::onMouseOut(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );
        grid.addListener('mouseover',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridMouseListener::onMouseOver(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );

        grid.addListener('mouseup',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridMouseListener::onMouseUp(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );
    }-*/;

    public native void addGridRowListener(GridRowListener listener) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;

        grid.addListener('rowclick',
                function(source, rowIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridRowListener::onRowClick(Lcom/gwtext/client/widgets/grid/Grid;ILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, e);
                }
        );

        grid.addListener('rowdblclick',
                function(source, rowIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridRowListener::onRowDblClick(Lcom/gwtext/client/widgets/grid/Grid;ILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, e);
                }
        );

        grid.addListener('rowcontextmenu',
                function(source, rowIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridRowListener::onRowContextMenu(Lcom/gwtext/client/widgets/grid/Grid;ILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, e);
                }
        );
    }-*/;


}
