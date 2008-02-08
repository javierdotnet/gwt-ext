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

package com.gwtext.client.widgets.menu;

import com.gwtext.client.core.AnchorPosition;
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.menu.event.MenuListener;

/**
 * Configuration class for {@link Menu}.
 */
public class MenuConfig extends BaseConfig {

    private MenuListener menuListener;

    /**
     * True to allow multiple menus to be displayed at the same time (defaults to false).
     *
     * @param allowOtherMenus true to allow multiple menus
     */
    public void setAllowOtherMenus(boolean allowOtherMenus) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowOtherMenus", allowOtherMenus);
    }

    /**
     * The default {@link com.gwtext.client.core.ExtElement#alignTo) anchor position value for this menu relative to its element of origin (defaults to "tl-bl").
     *
     * @param elementAnchor defaults to {@link com.gwtext.client.core.AnchorPosition#TOP_LEFT_CORNER}
     * @param targetAnchor  defaults to {@link com.gwtext.client.core.AnchorPosition#BOTTOM_LEFT_CORNER}
     */
    public void setDefaultAlign(AnchorPosition elementAnchor, AnchorPosition targetAnchor) {
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultAlign", elementAnchor.getPosition() + "-" + targetAnchor.getPosition() + "?");
    }

    /**
     * The minimum width of the menu in pixels (defaults to 120).
     *
     * @param minWidth the min width
     */
    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    /**
     * True for the default effect.
     *
     * @param shadow true for shadow
     */
    public void setShadow(boolean shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    /**
     * "sides" for the default effect, "frame" for 4-way shadow, and "drop" for bottom-right shadow (defaults to "sides")
     *
     * @param shadow the shadow settings
     */
    public void setShadow(String shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    /**
     * The Ext.Element.alignTo anchor position value to use for submenus of this menu (defaults to "tl-tr?").
     *
     * @param elementAnchor defaults to {@link com.gwtext.client.core.AnchorPosition#TOP_LEFT_CORNER}
     * @param targetAnchor  defaults to {@link com.gwtext.client.core.AnchorPosition#TOP_RIGHT_CORNER}
     */
    public void setSubMenuAlign(AnchorPosition elementAnchor, AnchorPosition targetAnchor) {
        JavaScriptObjectHelper.setAttribute(jsObj, "subMenuAlign", elementAnchor.getPosition() + "-" + targetAnchor.getPosition() + "?");
    }

    /**
     * Return the menu listener.
     *
     * @return the menu listener
     */
    public MenuListener getMenuListener() {
        return menuListener;
    }

    /**
     * Set the menu listener.
     *
     * @param menuListener the listener
     */
    public void setMenuListener(MenuListener menuListener) {
        this.menuListener = menuListener;
    }
}
