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

public class GridConfig extends BaseConfig {

    //todo missing form ext docs
    public void setEnableColLock(boolean enableColLock) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColLock", enableColLock);
    }

    public void setMinColumnWidth(int minColumnWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minColumnWidth", minColumnWidth);
    }

    //todo messes up display when grid in table
    public void setAutoSizeColumns(boolean autoSizeColumns) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoSizeColumns", autoSizeColumns);
    }

    public void setAutoSizeHeaders(boolean autoSizeHeaders) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoSizeHeaders", autoSizeHeaders);
    }

    //todo not documented by ext
    public void setAutoWidth(boolean autoWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoWidth", autoWidth);
    }

    public void setMonitorWindowResize(boolean monitorWindowResize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monitorWindowResize", monitorWindowResize);
    }

    public void setMaxRowsToMeasure(int maxRowsToMeasure) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxRowsToMeasure", maxRowsToMeasure);
    }

    public void setTrackMouseOver(boolean trackMouseOver) {
        JavaScriptObjectHelper.setAttribute(jsObj, "trackMouseOver", trackMouseOver);
    }

    public void setEnableCtxMenu(boolean enableCtxMenu) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableCtxMenu", enableCtxMenu);
    }

    public void setEnableColumnResize(boolean enableColumnResize) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColumnResize", enableColumnResize);
    }

    //http://extjs.com/forum/showthread.php?p=43678#post43678
    public void setEnableDragDrop(boolean enableDragDrop) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableDragDrop", enableDragDrop);
    }

    public void setEnableColumnMove(boolean enableColumnMove) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColumnMove", enableColumnMove);
    }

    public void setEnableColumnHide(boolean enableColumnHide) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableColumnHide", enableColumnHide);
    }

    public void setEnableRowHeightSync(boolean enableRowHeightSync) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enableRowHeightSync", enableRowHeightSync);
    }

    public void setStripeRows(boolean stripeRows) {
        JavaScriptObjectHelper.setAttribute(jsObj, "stripeRows", stripeRows);
    }

    public void setAutoHeight(boolean autoHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoHeight", autoHeight);
    }

    /**
     * @param autoExpandColumn the column id
     */
    public void setAutoExpandColumn(String autoExpandColumn) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoExpandColumn", autoExpandColumn);
    }

    /**
     * @param autoExpandColumn the column id
     */
    public void setAutoExpandColumn(int autoExpandColumn) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoExpandColumn", autoExpandColumn);
    }

    public void setAutoExpandMin(int autoExpandMin) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoExpandMin", autoExpandMin);
    }

    public void setAutoExpandMax(int autoExpandMax) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoExpandMax", autoExpandMax);
    }

    //todo view

    public void setAllowTextSelectionPattern(String allowTextSelectionPattern) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowTextSelectionPattern", allowTextSelectionPattern);
    }

    public void setLoadMask(boolean loadMask) {
        JavaScriptObjectHelper.setAttribute(jsObj, "loadMask", loadMask);
    }
}
