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
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.LoadMaskConfig;

/**
 * The {@link Grid} configuration class.
 */
public class GridConfig extends BaseConfig {

    /**
     * Enable column locking.
     *
     * @param enableColLock false to disable locking
     */
    public void setEnableColLock(boolean enableColLock) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColLock", enableColLock);
    }

    /**
     * The minimum width a column can be resized to. Default is 25.
     *
     * @param minColumnWidth the min column width
     */
    public void setMinColumnWidth(int minColumnWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minColumnWidth", minColumnWidth);
    }

    //todo messes up display when grid in table
    /**
     * True to automatically resize the columns to fit their content on initial render. It is more efficient to explicitly size
     * the columns through {@link com.gwtext.client.widgets.grid.ColumnConfig#setWidth(int)} option. Default is false.
     * 
     * @param autoSizeColumns true to autosize columns
     */
    public void setAutoSizeColumns(boolean autoSizeColumns) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoSizeColumns", autoSizeColumns);
    }

    /**
     * True to measure headers with column data when auto sizing columns. Default is true.
     * 
     * @param autoSizeHeaders true to autosize headers
     */
    public void setAutoSizeHeaders(boolean autoSizeHeaders) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoSizeHeaders", autoSizeHeaders);
    }

    //todo not documented by ext
    public void setAutoWidth(boolean autoWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoWidth", autoWidth);
    }

    /**
     * True to autoSize the grid when the window resizes. Default is true.
     * 
     * @param monitorWindowResize true to monitor window resize
     */
    public void setMonitorWindowResize(boolean monitorWindowResize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monitorWindowResize", monitorWindowResize);
    }

    /**
     * If autoSizeColumns is on, maxRowsToMeasure can be used to limit the number of rows measured to get a columns size.
     * Default is 0 (all rows).
     *
     * @param maxRowsToMeasure max rows to measure
     */
    public void setMaxRowsToMeasure(int maxRowsToMeasure) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxRowsToMeasure", maxRowsToMeasure);
    }

    /**
     * True to highlight rows when the mouse is over. Default is true.
     *
     * @param trackMouseOver true to highlight rows when mouse over
     */
    public void setTrackMouseOver(boolean trackMouseOver) {
        JavaScriptObjectHelper.setAttribute(jsObj, "trackMouseOver", trackMouseOver);
    }

    /**
     * True to enable Grid context menus.
     *
     * @param enableCtxMenu true to enable context menu
     */
    public void setEnableCtxMenu(boolean enableCtxMenu) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableCtxMenu", enableCtxMenu);
    }

    /**
     * True to enable column resize.
     *
     * @param enableColumnResize true to enable column resize
     */
    public void setEnableColumnResize(boolean enableColumnResize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColumnResize", enableColumnResize);
    }

    //http://extjs.com/forum/showthread.php?p=43678#post43678
    /**
     * True to enable drag and drop of rows. Default is false.
     *
     * @param enableDragDrop true to enable drag drop of rows
     */
    public void setEnableDragDrop(boolean enableDragDrop) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableDragDrop", enableDragDrop);
    }

    /**
     * True to enable drag and drop reorder of columns. Default is true.
     *
     * @param enableColumnMove true to enable column move
     */
    public void setEnableColumnMove(boolean enableColumnMove) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColumnMove", enableColumnMove);
    }

    /**
     * True to enable hiding of columns with the header context menu. Default is true
     *
     * @param enableColumnHide true to enable column hide
     */
    public void setEnableColumnHide(boolean enableColumnHide) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColumnHide", enableColumnHide);
    }

    /**
     * True to manually sync row heights across locked and not locked rows. Default is false.
     *
     * @param enableRowHeightSync true to sync row height
     */
    public void setEnableRowHeightSync(boolean enableRowHeightSync) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableRowHeightSync", enableRowHeightSync);
    }

    /**
     * True to stripe the rows. Default is true.
     *
     * @param stripeRows true to stripe rows
     */
    public void setStripeRows(boolean stripeRows) {
        JavaScriptObjectHelper.setAttribute(jsObj, "stripeRows", stripeRows);
    }

    /**
     *  True to fit the height of the grid container to the height of the data. Default is false.
     * 
     * @param autoHeight true to fit the height of the grid container to the height of the data
     */
    public void setAutoHeight(boolean autoHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoHeight", autoHeight);
    }

    /**
     * The id of a column in this grid that should expand to fill unused space.
     * This id can not be 0. Default is false.
     * 
     * @param autoExpandColumn the column id
     */
    public void setAutoExpandColumn(String autoExpandColumn) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoExpandColumn", autoExpandColumn);
    }

    /**
     * The id of a column in this grid that should expand to fill unused space. This id can not be 0.
     * Default is false.
     *
     * @param autoExpandColumn the column id
     */
    public void setAutoExpandColumn(int autoExpandColumn) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoExpandColumn", autoExpandColumn);
    }

    /**
     * The minimum width the autoExpandColumn can have (if enabled). Default is 50.
     *
     * @param autoExpandMin the min expand value
     */
    public void setAutoExpandMin(int autoExpandMin) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoExpandMin", autoExpandMin);
    }

    /**
     * The maximum width the autoExpandColumn can have (if enabled). Default is 1000.
     *
     * @param autoExpandMax the max expand value
     */
    public void setAutoExpandMax(int autoExpandMax) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoExpandMax", autoExpandMax);
    }

    /**
     * The {@link GridView} used by the grid.
     *
     * @param view the grid view
     */
    public void setView(GridView view) {
        JavaScriptObjectHelper.setAttribute(jsObj, "view", view.getJsObj());
    }

    /**
     * True to mask the grid while loading. Default is false.
     *
     * @param loadMask true to mask grid
     */
    public void setLoadMask(boolean loadMask) {
        JavaScriptObjectHelper.setAttribute(jsObj, "loadMask", loadMask);
    }

    /**
     * A {@link com.gwtext.client.widgets.LoadMaskConfig} to mask the grid while loading. Default is disable masking.
     *
     * @param loadMask the laod mask config
     */
    public void setLoadMask(LoadMaskConfig loadMask) {
        JavaScriptObjectHelper.setAttribute(jsObj, "loadMask", loadMask.getJsObj());
    }    
}
