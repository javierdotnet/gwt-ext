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
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.Ext;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.BaseExtWidget;
import com.gwtext.client.widgets.grid.event.*;

/**
 * A Grid widget.
 * <br/></br/>
 * <b>Common Problems:</b>
 * <ul>
 * <li>Grid does not resize properly when going smaller: Setting overflow hidden on the container element will correct this</li>
 * <li>If you get el.style[camel]= NaNpx or -2px or something related, be certain you have given your container element dimensions. The grid adapts to your container's size, if your container has no size defined then the results are unpredictable.</li>
 * <li>Do not render the grid into an element with display:none. Try using visibility:hidden. Otherwise there is no way for the grid to calculate dimensions/offsets.</li>
 * </ul>
 */
public class Grid extends BaseExtWidget {

    public Grid(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Creates a new Grid.
     *
     * @param id the Grid ID
     * @param width the Grid width
     * @param height the Grid height
     * @param store the Grid's data store
     * @param columnModel the Grid's column model
     */
    public Grid(String id, String width, String height, Store store, ColumnModel columnModel) {
        this(id, width, height, store, columnModel, new GridConfig());
    }

    /**
     * Creates a new Grid.
     *
     * @param id the Grid ID
     * @param width the Grid width
     * @param height the Grid height
     * @param store the Grid's data store
     * @param columnModel the Grid's column model
     * @param config the grid configuration
     */
    public Grid(String id, String width, String height, Store store, ColumnModel columnModel, GridConfig config) {
        this(id, width, height, store, columnModel, null, config);
    }

    /**
     * Creates a new Grid.
     *
     * @param id the Grid ID
     * @param width the Grid width
     * @param height the Grid height
     * @param store the Grid's data store
     * @param columnModel the Grid's column model
     * @param selectionModel the Grid's selection model
     * @param config the grid configuration
     */
    public Grid(String id, String width, String height, Store store, ColumnModel columnModel, AbstractSelectionModel selectionModel, GridConfig config) {

        Element div = DOM.getElementById(id);
        if (div == null) {
            RootPanel.get().add(new HTML("<div id='" + id + "'></div>"));
            div = DOM.getElementById(id);
        }

        final JavaScriptObject configJS = config == null ? null : config.getJsObj();
        JavaScriptObjectHelper.setAttribute(configJS, "ds", store.getJsObj());
        JavaScriptObjectHelper.setAttribute(configJS, "cm", columnModel.getJsObj());
        if (selectionModel != null)
            JavaScriptObjectHelper.setAttribute(configJS, "selModel", selectionModel.getJsObj());

        jsObj = create(id, configJS);
        setElement(div);

        if (width != null) setWidth(width);
        if (height != null) setHeight(height);
    }

    protected native JavaScriptObject create(String id, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.Grid(id, configJS);
    }-*/;

    protected native JavaScriptObject create(Element elem, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.Grid(elem, configJS);
    }-*/;

    /**
     * Causes the grid to manually recalculate its dimensions. Generally this is done automatically, but if manual update
     * is required this method will initiate it.
     */
    public native void autoSize() /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.autoSize();
    }-*/;

    /**
     * Destroy this grid.
     */
    public native void destroy() /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.destroy();
    }-*/;

    /**
     * Destroy this grid.
     *
     * @param removeEl true to remove the element
     */
    public native void destroy(boolean removeEl) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.destroy(removeEl);
    }-*/;

    /**
     * Returns the grid's ColumnModel.
     *
     * @return the column model
     */
    public ColumnModel getColumnModel() {
        return new ColumnModel(getColumnModel(jsObj));
    }

    private native JavaScriptObject getColumnModel(JavaScriptObject grid) /*-{
        return grid.getColumnModel();
    }-*/;

    /**
     * Returns the Grid's Store
     *
     * @return the Grids Store
     */
    public Store getStore() {
        return new Store(getStore(jsObj));
    }

    public native JavaScriptObject getStore(JavaScriptObject grid) /*-{
        return grid.getDataSource();
    }-*/;

    /**
     * Called to get Grid's drag proxy text.
     * 
     * @return the grids drag drop text
     */
    public native String getDragDropText() /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return grid.getDragDropText();
    }-*/;

    /**
     * Sets the Grid's drag drop text
     *
     * @param text the drag drop text
     */
    public native void setDragDropText(String text) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.ddText = text;
    }-*/;

    /**
     * Returns the Grid's row selection model
     *
     * @return the selection model
     */
    public RowSelectionModel getSelectionModel() {
        return new RowSelectionModel(getSelectionModel(jsObj));
    }

    private native JavaScriptObject getSelectionModel(JavaScriptObject grid) /*-{
        return grid.getSelectionModel();            
    }-*/;

    /**
     * Returns the grid's GridView object.
     *
     * @return grid view
     */
    public GridView getView() {
        return new GridView(getView(jsObj));
    }

    private native JavaScriptObject getView(JavaScriptObject grid) /*-{
        return grid.getView();
    }-*/;


    /**
     * Hides the specified column.
     *
     * @param colID the column ID
     */
    public void hideColumn(String colID) {
        int colIndex = getColumnModel().getIndexById(colID);
        if(colIndex != -1) {
            hideColumn(colIndex);
        }
    }

    /**
     * Hides the specified column.
     *
     * @param colIndex the column index
     */
    public void hideColumn(int colIndex) {
        getColumnModel().setHidden(colIndex, true);
        if (Ext.isIE()) {
            Timer t = new Timer() {
                public void run() {
                    getView().refresh();
                    getView().updateHeaderSortState();
                }
            };
            t.schedule(10);
        }
    }

    public void render() {
        render(jsObj);
        //fixes issue with grid being displayed in table
        //see http://extjs.com/forum/showthread.php?t=2613
        if (Ext.isIE()) {
            addGridColumnListener(new GridColumnListenerAdapter() {
                public void onColumnResize(Grid grid, int colIndex, int newSize) {
                    adjustColumns();
                }
            });
            Timer t = new Timer() {
                public void run() {
                    getView().refresh();
                    getView().updateHeaderSortState();
                }
            };
            t.schedule(10);
        }
    }

    public void adjustColumns() {
        doAdjustColumns(jsObj);
    }

    //fix for grid rendering issues in IE when grid in table
    private native void doAdjustColumns(JavaScriptObject grid) /*-{
        var view = grid.getView();
        view.refresh();
        view.updateHeaders();
        view.updateColumns();
        view.updateSplitters();
        view.updateHeaderSortState();
        //view.renderPhase2.defer(1, grid);

    }-*/;

    public native void render(JavaScriptObject grid) /*-{
        grid.render();
    }-*/;

    //http://extjs.com/forum/showthread.php?t=8694&highlight=grid+reconfigure
    /**
     * Reconfigures the grid to use a different Store and Column Model. The View will be bound to the new objects and refreshed.
     * 
     * @param store the new Store
     * @param columnModel the new ColumnModel
     */
    public native void reconfigure(Store store, ColumnModel columnModel) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var storeJS = store.@com.gwtext.client.core.JsObject::jsObj;
        var columnModelJS = columnModel.@com.gwtext.client.core.JsObject::jsObj;
        grid.reconfigure(storeJS, columnModelJS);
    }-*/;

    /**
     *  Sets the load mask message for the grid.
     * 
     * @param message the load mask text
     */
    public native void setLoadMask(String message)/*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        grid.loadMask.msg = message;
    }-*/;

    /**
     * Show the specified column.
     *
     * @param colID the column ID
     */
    public void showColumn(String colID) {
        int colIndex = getColumnModel().getIndexById(colID);
        if(colIndex != -1) {
            showColumn(colIndex);
        }
    }

    /**
     * Shows the specified column.
     *
     * @param colIndex the column index
     */
    public void showColumn(int colIndex) {
        getColumnModel().setHidden(colIndex, false);
        if (Ext.isIE()) {
            Timer t = new Timer() {
                public void run() {
                    getView().refresh();
                    getView().updateHeaderSortState();
                }
            };
            t.schedule(10);
        }
    }

    /**
     * Add a Grid Cell listener.
     *
     * @param listener the listener
     */
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

    /**
     * Add a Grid Column listener.
     *
     * @param listener the listener
     */
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

    //todo
    public native void addGridDragListener(GridDragListener listener) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;
    }-*/;

    /**
     * Add a Grid Header listener.
     *
     * @param listener the listener
     */
    public native void addGridHeaderListener(GridHeaderListener listener) /*-{
        var grid = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var gridJ = this;

        grid.addListener('headerclick',
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

    /**
     * Add a Grid Cell listener.
     *
     * @param listener the listener
     */
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

    /**
     * Add a Grid mouse listener.
     *
     * @param listener the listener
     */
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

    /**
     * Add a Grid row listener.
     *
     * @param listener the listener
     */
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
