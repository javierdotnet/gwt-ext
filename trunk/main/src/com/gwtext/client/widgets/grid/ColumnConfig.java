/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid;

import com.gwtext.client.core.TextAlign;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * The Grid Column configuration.
 * 
 * @see com.gwtext.client.widgets.grid.ColumnModel
 */
public class ColumnConfig extends BaseColumnConfig {

    /**
     * Create a new ColumnConfig.
     */
    public ColumnConfig() {
    }

    /**
     * Create a new ColumnConfig.
     *
     * @param header the column header
     * @param dataIndex the data index (the field name pf the Store associated with the Grid)
     */
    public ColumnConfig(String header, String dataIndex) {
        setHeader(header);
        setDataIndex(dataIndex);
    }
    
    /**
     * Create a new ColumnConfig.
     *
     * @param header the column header
     * @param dataIndex the data index (the field name pf the Store associated with the Grid)
     * @param width the column width
     */
    public ColumnConfig(String header, String dataIndex, int width) {
        this(header, dataIndex, width, false);
    }

    /**
     * Create a new ColumnConfig.
     *
     * @param header the column header
     * @param dataIndex the data index (the field name pf the Store associated with the Grid)
     * @param width the column width
     * @param sortable true for sortable
     */
    public ColumnConfig( String header, String dataIndex, int width,  boolean sortable) {
        this(header, dataIndex, width, sortable, null);
    }

    /**
     * Create a new ColumnConfig.
     *
     * @param header the column header
     * @param dataIndex the data index (the field name pf the Store associated with the Grid)
     * @param width the column width
     * @param sortable true for sortable
     * @param renderer a renderer to allow custom formating of cells of this column
     */
    public ColumnConfig( String header, String dataIndex, int width,  boolean sortable, Renderer renderer) {
       this(header, dataIndex, width, sortable, renderer, null);
    }
    
    /**
     * Create a new ColumnConfig.
     *
     * @param header the column header
     * @param dataIndex the data index (the field name pf the Store associated with the Grid)
     * @param width the column width
     * @param sortable true for sortable
     * @param renderer a renderer to allow custom formating of cells of this column
     * @param id the grid  ID
     */
    public ColumnConfig(String header, String dataIndex, int width,  boolean sortable, Renderer renderer, String id) {
        if(id != null) setId(id);
        setHeader(header);
        setDataIndex(dataIndex);
        setWidth(width);
        setSortable(sortable);
        if(renderer != null) setRenderer(renderer);
    }
    /**
     * Set the CSS text-align property of the column. Defaults to undefined.
     *
     * @param align the text-align position
     */
    public void setAlign(TextAlign align) {
        JavaScriptObjectHelper.setAttribute(jsObj, "align", align.getPosition());
	}

	public String getTextAlign() {
		return JavaScriptObjectHelper.getAttribute(jsObj, "textAlign");
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

	public String getId() {
		return JavaScriptObjectHelper.getAttribute(jsObj, "id");
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

	public String getDataIndex() {
		return JavaScriptObjectHelper.getAttribute(jsObj, "dataIndex");
	}

	/**
     * A text string to use as the column header's tooltip. If Quicktips are enabled, this value will be used as the text
     * of the quick tip, otherwise it will be set as the header's HTML title attribute. Defaults to ''.
     *
     * @param tooltip the tooltip
     */
    public void setTooltip(String tooltip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tooltip", tooltip);
    }

	public String getTooltip() {
		return JavaScriptObjectHelper.getAttribute(jsObj, "tooltip");
	}

	/**
     * Sets teh CSS class for the column,
     *
     * @param css the CSS class
     */
    public void setCss(String css) {
        JavaScriptObjectHelper.setAttribute(jsObj, "css", css);
    }

	public String getCss() {
		return JavaScriptObjectHelper.getAttribute(jsObj, "css");
	}

	/**
     * The header text to display in the Grid view. You can use arbitrary html for the header.
     *
     * @param header the column header
     */
    public void setHeader(String header) {
        JavaScriptObjectHelper.setAttribute(jsObj, "header", header);
    }

	public String getHeader() {
		return JavaScriptObjectHelper.getAttribute(jsObj, "header");
	}

	/**
     * True to hide the column. Defaults to false.
     *
     * @param hidden true to hide column
     */
    public void setHidden(boolean hidden) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hidden", hidden);
    }

	public boolean getHidden() {
		return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, "hidden");
	}

	/**
     * True to make the column width fixed.
     *
     * @param fixed true for fixed width
     */
    public void setFixed(boolean fixed) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fixed", fixed);
    }

	public boolean getFixed() {
		return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, "fixed");
	}

	/**
     * Sets the rendering (formatting) function for a column.
     *
     * @param renderer the column renderer
     */
    public native void setRenderer(Renderer renderer) /*-{
        var config = this.@com.gwtext.client.core.JsObject::getJsObj()();

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

	public boolean getResizable() {
		return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, "resizable");
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

	public boolean getSortable() {
		return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, "sortable");
	}


    /**
     * The initial width in pixels of the column.
     *
     * @param width the column width
     */
    public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

	public int getWidth() {
		return JavaScriptObjectHelper.getAttributeAsInt(jsObj, "width");
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
