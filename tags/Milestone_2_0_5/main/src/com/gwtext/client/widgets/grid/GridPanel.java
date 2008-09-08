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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.Function;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.event.*;

/**
 * A Grid widget.
 * <br/></br/>
 * <b>Common Problems:</b>
 * <ul>
 * <li>Grid does not resize properly when going smaller: Setting overflow hidden on the container element will correct this</li>
 * <li>If you get el.style[camel]= NaNpx or -2px or something related, be certain you have given your container element dimensions.
 * The grid adapts to your container's size, if your container has no size defined then the results are unpredictable.</li>
 * <li>Do not render the grid into an element with display:none. Try using visibility:hidden. Otherwise there is no way for
 *  the grid to calculate dimensions/offsets.</li>
 * </ul>
 *
 * <br>
 * CSS can be used to style or customize the behaviour of headers an cells.
 * <br>
 * For example, use this to wrap all cell contents globally
 * <pre>
 * .x-grid3-cell-inner {
 *      overflow: visible; white-space: normal !important;
 * }
 * </pre> 
 * To wrap cell contents on a certain table only, set an ID to the Grid panel (say company-grid) and then use the CSS
 * <pre>
 * #company-grid  .x-grid3-cell-inner {
 *      overflow: visible; white-space: normal !important;
 * }
 * </pre>
 * To wrap long header titles
 * For all grids
 * <pre>
 * .x-grid3-hd-inner  {
 *     overflow: visible; white-space: normal;
 * }
 * </pre>
 *
 * For specific grid
 * <pre>
 * #company-grid .x-grid3-hd-inner  {
 *     overflow: visible; white-space: normal;
 * }
 * </pre>
 *
 * For specific column
 * <pre>
 * .x-grid3-hd-company {
 *      overflow: visible; white-space: normal !important;
 * }
 * </pre>
 * 	
 * @author Sanjiv Jivan
 */
public class GridPanel extends Panel {

    private static JavaScriptObject configPrototype;
    private Store store = null;
    
    static {
        init();
    }

    private static native void init()/*-{
		var c = new $wnd.Ext.grid.GridPanel();
		@com.gwtext.client.widgets.grid.GridPanel::configPrototype = c.initialConfig;
	}-*/;

    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "grid";
    }

    public GridPanel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public GridPanel() {
    }

    /**
     * Creates a new Grid.
     *
     * @param store       the Grid's data store
     * @param columnModel the Grid's column model
     */
    public GridPanel(Store store, ColumnModel columnModel) {
        setStore(store);
        setColumnModel(columnModel);
    }
    
    /**
     * Static method which returns the GridPanel instance based
     * on the JavaScriptObject
     * @param jsObj the JavaScript Object that represents the GridPanel
     * @return The GridPanel instance based on the JavaScriptObject passed in
     */
    public static GridPanel instance(JavaScriptObject jsObj) {
        return new GridPanel(jsObj);
    }

    /**
     * Creates a new Grid.
     *
     * @param id          the Grid ID
     * @param width       the Grid width
     * @param height      the Grid height
     * @param store       the Grid's data store
     * @param columnModel the Grid's column model
     */
    public GridPanel(String id, int width, int height, Store store, ColumnModel columnModel) {
        setId(id);
        setWidth(width);
        setHeight(height);
        setStore(store);
        setColumnModel(columnModel);
    }

    protected native JavaScriptObject create(JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.GridPanel(configJS);
    }-*/;


	protected void initComponent() {
		super.initComponent();
		if (!GWT.isScript()) {
			Store store = getStore();
			if (store == null && !(this instanceof PropertyGridPanel)) {
				error("A Store must be assigned to the GridPanel. See setStore(..)");
			}
		}
	}

	/**
	 * Clear the sort state of the grid. This resets the sort arrow indicators on the Grid
	 *
	 * @param reload true to reload the store after clearing the sort state
	 */
	public native void clearSortState(boolean reload) /*-{
		var grid = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		var view = grid.getView();
		var sc = view.sortClasses;
        var hds = view.mainHd.select('td').removeClass(sc);
		var store = grid.store;
		store.sortInfo = null;
		store.lastOptions = null;
		if(reload) {
			store.reload({});
		}
	}-*/;

	/**
     * Returns the grid's ColumnModel.
     *
     * @return the column model
     */
    public ColumnModel getColumnModel() {
        return new ColumnModel(getColumnModel(getOrCreateJsObj()));
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
        if(store != null) {
			return store;
		} else {
			//handle case where java Grid reference is not held locally but constructed by new Grid(jsObj)
			JavaScriptObject storeJS = getAttributeAsJavaScriptObject("store");
        	return storeJS == null ? null : new Store(storeJS);
		}
    }

    /**
     * Called to get Grid's drag proxy text.
     *
     * @return the grids drag drop text
     */
    public native String getDragDropText() /*-{
        var grid = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return grid.getDragDropText();
    }-*/;

    /**
     * Sets the Grid's drag drop text
     *
     * @param text the drag drop text
     */
    public native void setDragDropText(String text) /*-{
        var grid = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        grid.ddText = text;
    }-*/;

    /**
     * Returns the Grid's row selection model
     *
     * @return the selection model
     */
    public RowSelectionModel getSelectionModel() {
    	JavaScriptObject smObj = getSelectionModelAsJavaScriptObject();
    	if(smObj != null) {
    		return new RowSelectionModel(smObj);
    	} else {
    		RowSelectionModel sm = new RowSelectionModel();
    		setSelectionModel(sm);
    		return sm;
    	}
    }
    
    /**
     * Returns the Grid's selection model, as a raw JavaScriptObject
     *
     * @return the selection model's raw JavaScriptObject (null if called before
     * grid creation or calling setSelectionModel(...) )
     */
    public JavaScriptObject getSelectionModelAsJavaScriptObject() {
    	if(isCreated()) {
    		return getSelectionModel(getJsObj());
    	} else {
    		return JavaScriptObjectHelper.getAttributeAsJavaScriptObject(config, "sm");
    	}
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
        return new GridView(getView(getOrCreateJsObj()));
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
        if (colIndex != -1) {
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
        if (isRendered() && Ext.isIE()) {
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
     * Hides the column header of the grid.
     */
    public void hideColumnHeader() {
        if (isRendered()) {
            Element el = getEl().child("div[class=x-grid3-header]");
            Ext.fly(el).setStyle("display", "none");
        } else {
            addListener("render", new Function() {
                public void execute() {
                    hideColumnHeader();
                }
            });
        }
    }

    public native void render(JavaScriptObject grid) /*-{
        grid.render();
    }-*/;

    //http://extjs.com/forum/showthread.php?t=8694&highlight=grid+reconfigure
    /**
     * Reconfigures the grid to use a different Store and Column Model. The View will be bound to the new objects and refreshed.
     *
     * @param store       the new Store
     * @param columnModel the new ColumnModel
     */
    public native void reconfigure(Store store, ColumnModel columnModel) /*-{
        var grid = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var storeJS = store.@com.gwtext.client.core.JsObject::getJsObj()();
        var columnModelJS = columnModel.@com.gwtext.client.core.JsObject::getJsObj()();
        grid.reconfigure(storeJS, columnModelJS);
    }-*/;

    /**
     * Sets the load mask message for the grid.
     *
     * @param message the load mask text
     */
    public native void setLoadMask(String message)/*-{
        var grid = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        grid.loadMask.msg = message;
    }-*/;


    /**
     * Show the specified column.
     *
     * @param colID the column ID
     */
    public void showColumn(String colID) {
        int colIndex = getColumnModel().getIndexById(colID);
        if (colIndex != -1) {
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
        var gridJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('cellclick',
                function(self, rowIndex, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridCellListener::onCellClick(Lcom/gwtext/client/widgets/grid/GridPanel;IILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, colIndex, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('cellcontextmenu',
                function(self, rowIndex, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridCellListener::onCellContextMenu(Lcom/gwtext/client/widgets/grid/GridPanel;IILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, colIndex, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('celldblclick',
                function(self, rowIndex, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridCellListener::onCellDblClick(Lcom/gwtext/client/widgets/grid/GridPanel;IILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, colIndex, e);
                }
        );
    }-*/;

    /**
     * Add a Grid Column listener.
     *
     * @param listener the listener
     */
    public native void addGridColumnListener(GridColumnListener listener) /*-{

        var gridJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('columnmove',
                function(oldIndex, newIndex) {
                    listener.@com.gwtext.client.widgets.grid.event.GridColumnListener::onColumnMove(Lcom/gwtext/client/widgets/grid/GridPanel;II)(gridJ, oldIndex, newIndex);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('columnresize',
                function(colIndex, newSize) {
                    listener.@com.gwtext.client.widgets.grid.event.GridColumnListener::onColumnResize(Lcom/gwtext/client/widgets/grid/GridPanel;II)(gridJ, colIndex, newSize);
                }
        );
    }-*/;

    /**
     * Add a Grid Header listener.
     *
     * @param listener the listener
     */
    public native void addGridHeaderListener(GridHeaderListener listener) /*-{
        var gridJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('headerclick',
                function(g, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridHeaderListener::onHeaderClick(Lcom/gwtext/client/widgets/grid/GridPanel;ILcom/gwtext/client/core/EventObject;)(gridJ, colIndex, e);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('headercontextmenu',
                function(g, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridHeaderListener::onHeaderContextMenu(Lcom/gwtext/client/widgets/grid/GridPanel;ILcom/gwtext/client/core/EventObject;)(gridJ, colIndex, e);
                }
        );
        //todo check signature as it currently has rowindex
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('headerdblclick',
                function(g, colIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridHeaderListener::onHeaderDblClick(Lcom/gwtext/client/widgets/grid/GridPanel;ILcom/gwtext/client/core/EventObject;)(gridJ, colIndex, e);
                }
        );
    }-*/;

    /**
     * Add a Grid Cell listener.
     *
     * @param listener the listener
     */
    public native void addGridListener(GridListener listener) /*-{
        var gridJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('bodyscroll',
                function(scrollLeft, scrollTop) {
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onBodyScroll(II)(scrollLeft, scrollTop);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('click',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onClick(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('contextmenu',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onContextMenu(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('dblclick',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onDblClick(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('keydown',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onKeyDown(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('keypress',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridListener::onKeyPress(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );

    }-*/;

    /**
     * Add a Grid mouse listener.
     *
     * @param listener the listener
     */
    public native void addGridMouseListener(GridMouseListener listener) /*-{
        var gridJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mousedown',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridMouseListener::onMouseDown(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseout',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridMouseListener::onMouseOut(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );
        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseover',
                function(event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridMouseListener::onMouseOver(Lcom/gwtext/client/core/EventObject;)(e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('mouseup',
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
        var gridJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('rowclick',
                function(source, rowIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridRowListener::onRowClick(Lcom/gwtext/client/widgets/grid/GridPanel;ILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('rowdblclick',
                function(source, rowIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridRowListener::onRowDblClick(Lcom/gwtext/client/widgets/grid/GridPanel;ILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, e);
                }
        );

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('rowcontextmenu',
                function(source, rowIndex, event) {
                    var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                    listener.@com.gwtext.client.widgets.grid.event.GridRowListener::onRowContextMenu(Lcom/gwtext/client/widgets/grid/GridPanel;ILcom/gwtext/client/core/EventObject;)(gridJ, rowIndex, e);
                }
        );
    }-*/;

    // --- config properties ---

    /**
     * The DD group this GridPanel belongs to (defaults to 'GridDD').
     *
     * @param ddGroup the DD group
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDdGroup(String ddGroup) throws IllegalStateException {
        setAttribute("ddGroup", ddGroup, true);
    }

    /**
     * The minimum width a column can be resized to. Default is 25.
     *
     * @param minColumnWidth the min column width
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMinColumnWidth(int minColumnWidth) throws IllegalStateException {
        setAttribute("minColumnWidth", minColumnWidth, true);
    }

    /**
     * True to autoSize the grid when the window resizes. Default is true.
     *
     * @param monitorWindowResize true to monitor window resize
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMonitorWindowResize(boolean monitorWindowResize) throws IllegalStateException {
        setAttribute("monitorWindowResize", monitorWindowResize, true);
    }

    /**
     * If autoSizeColumns is on, maxRowsToMeasure can be used to limit the number of rows measured to get a columns size.
     * Default is 0 (all rows).
     *
     * @param maxRowsToMeasure max rows to measure
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setMaxRowsToMeasure(int maxRowsToMeasure) throws IllegalStateException {
        setAttribute("maxRowsToMeasure", maxRowsToMeasure, true);
    }

    /**
     * True to highlight rows when the mouse is over. Default is true.
     *
     * @param trackMouseOver true to highlight rows when mouse over
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setTrackMouseOver(boolean trackMouseOver) throws IllegalStateException {
        setAttribute("trackMouseOver", trackMouseOver, true);
    }

    /**
     * True to enable the drop down button for menu in the headers.
     *
     * @param enableHdMenu true to enable the drop down button for menu in the headers.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setEnableHdMenu(boolean enableHdMenu) throws IllegalStateException {
        setAttribute("enableHdMenu", enableHdMenu, true);
    }

    /**
     * True to enable column resize.
     *
     * @param enableColumnResize true to enable column resize
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setEnableColumnResize(boolean enableColumnResize) throws IllegalStateException {
        setAttribute("enableColumnResize", enableColumnResize, true);
    }

    //http://extjs.com/forum/showthread.php?p=43678#post43678
    /**
     * True to enable drag and drop of rows. Default is false.
     *
     * @param enableDragDrop true to enable drag drop of rows
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setEnableDragDrop(boolean enableDragDrop) throws IllegalStateException {
        setAttribute("enableDragDrop", enableDragDrop, true);
    }

    /**
     * True to enable drag and drop reorder of columns. Default is true.
     *
     * @param enableColumnMove true to enable column move
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setEnableColumnMove(boolean enableColumnMove) throws IllegalStateException {
        setAttribute("enableColumnMove", enableColumnMove, true);
    }

    /**
     * True to enable hiding of columns with the header context menu. Default is true
     *
     * @param enableColumnHide true to enable column hide
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setEnableColumnHide(boolean enableColumnHide) throws IllegalStateException {
        setAttribute("enableColumnHide", enableColumnHide, true);
    }

    /**
     * True to stripe the rows. Default is true.
     *
     * @param stripeRows true to stripe rows
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setStripeRows(boolean stripeRows) throws IllegalStateException {
        setAttribute("stripeRows", stripeRows, true);
    }

    /**
     * Set the GridPanel's selection model.
     *
     * @param selectionModel the selection model/
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setSelectionModel(AbstractSelectionModel selectionModel) throws IllegalStateException {
        setAttribute("sm", selectionModel.getJsObj(), true);
    }

    /**
     * True to fit the height of the grid container to the height of the data. Default is false.
     *
     * @param autoHeight true to fit the height of the grid container to the height of the data
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAutoHeight(boolean autoHeight) throws IllegalStateException {
        setAttribute("autoHeight", autoHeight, true);
    }

    /**
     * The id of a column in this grid that should expand to fill unused space.
     * This id can not be 0. Default is false. <br>
     * <b>Note : You must pass the ID of the ColumnConfig, and not the dataIndex of the corresponding ColumnConfig.</b>
     *
     * @param autoExpandColumn the column id
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     * @see com.gwtext.client.widgets.grid.ColumnConfig#setId(String)
     */
    public void setAutoExpandColumn(String autoExpandColumn) throws IllegalStateException {
        setAttribute("autoExpandColumn", autoExpandColumn, true);
    }

    /**
     * The id of a column in this grid that should expand to fill unused space. This id can not be 0.
     * Default is false.
     *
     * @param autoExpandColumn the column id
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAutoExpandColumn(int autoExpandColumn) throws IllegalStateException {
        setAttribute("autoExpandColumn", autoExpandColumn, true);
    }

    /**
     * The minimum width the autoExpandColumn can have (if enabled). Default is 50.
     *
     * @param autoExpandMin the min expand value
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAutoExpandMin(int autoExpandMin) throws IllegalStateException {
        setAttribute("autoExpandMin", autoExpandMin, true);
    }

    /**
     * The maximum width the autoExpandColumn can have (if enabled). Default is 1000.
     *
     * @param autoExpandMax the max expand value
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setAutoExpandMax(int autoExpandMax) throws IllegalStateException {
        setAttribute("autoExpandMax", autoExpandMax, true);
    }

	/**
	 * True to disable selections in the grid (defaults to false). - ignored a SelectionModel is specified
	 *
	 * @param disableSelection true to disable selections in the grid (defaults to false). - ignored a SelectionModel is specified
	 * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setDisableSelection(boolean disableSelection) throws IllegalStateException {
		setAttribute("disableSelection", disableSelection, true);
	}

	/**
     * Hides the column header of the grid if passed true.
     *
     * @param hideColumnHeader true to hide the column headers
     */
    public void setHideColumnHeader(boolean hideColumnHeader) {
        if (hideColumnHeader) {
            hideColumnHeader();
        }
    }

    /**
     * Sets the {@link GridView} used by the grid.
     *
     * @param view the grid view
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setView(GridView view) throws IllegalStateException {
        setAttribute("view", view.getJsObj(), true);
    }

    /**
     * True to mask the grid while loading. Default is false.
     *
     * @param loadMask true to mask grid
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setLoadMask(boolean loadMask) throws IllegalStateException {
        setAttribute("loadMask", loadMask, true);
    }

    /**
     * Sets the {@link com.gwtext.client.widgets.LoadMask} to mask the grid while loading. Default is disable masking.
     *
     * @param message    the load mask message
     * @param messageCls the load mask message CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setLoadMask(String message, String messageCls) throws IllegalStateException {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "msg", message);
        JavaScriptObjectHelper.setAttribute(config, "msgCls", messageCls);
        setAttribute("loadMask", config, true);

    }

    /**
     * The Store the grid should use as its data source (required).
     *
     * @param store the store
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setStore(Store store) throws IllegalStateException {
        setAttribute("store", store.getJsObj(), true);
        this.store = store;
    }

    /**
     * The {@link ColumnModel} to use when rendering the grid (required).
     *
     * @param columnModel the grids column model
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setColumnModel(ColumnModel columnModel) throws IllegalStateException {
        setAttribute("cm", columnModel.getJsObj(), true);
    }

    /**
     * True to stripe the rows. Default is false.
     *
     * @param stripeRows true to stripe the rows. Default is false.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void stripeRows(boolean stripeRows) throws IllegalStateException {
		setAttribute("stripeRows", stripeRows, true);
	}
}