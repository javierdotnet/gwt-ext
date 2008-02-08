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

package com.gwtext.client.widgets;

import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * The {@link com.gwtext.client.widgets.ColorPalette} configuration.
 */
public class ColorPaletteConfig extends ComponentConfig {

    /**
     * If set to true then reselecting a color that is already selected fires the selection event.
     *
     * @param allowReselect true to allow reselect
     */
    public void setAllowReselect(boolean allowReselect) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowReselect", allowReselect);
    }

    /**
     * The CSS class to apply to the containing element (defaults to "x-color-palette").
     *
     * @param itemCls the item CSS class
     */
    public void setItemCls(String itemCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "itemCls", itemCls);
    }

    /**
     * The initial color to highlight (should be a valid 6-digit color hex code without the # symbol).
     * Note that the hex codes are case-sensitive.
     *
     * @param value the initial color
     */
    public void setValue(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }
}
