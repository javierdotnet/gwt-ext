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

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.menu.event.BaseItemListener;

/**
 * Configuration class for {@link BaseItem}.
 */
public class BaseItemConfig extends BaseConfig {

    private BaseItemListener baseItemListener;

    /**
     * Set the ID of the element.
     *
     * @param id the ID
     */
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
    }

    /**
     * Return the ID of the element.
     *
     * @return the element ID
     */
    public String getId() {
        return JavaScriptObjectHelper.getAttribute(jsObj, "id");
    }

    /**
     * The CSS class to use when the item becomes activated (defaults to "x-menu-item-active")
     *
     * @param activeClass the active CSS class
     */
    public void setActiveClass(String activeClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "activeClass", activeClass);
    }

    /**
     * True if this item can be visually activated (defaults to false)
     * 
     * @param canActivate true if can be activated
     */
    public void setCanActivate(boolean canActivate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "canActivate", canActivate);
    }

    /**
     * Length of time in milliseconds to wait before hiding after a click (defaults to 100).
     *
     * @param hideDelay the hide delay
     */
    public void setHideDelay(int hideDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideDelay", hideDelay);
    }

    /**
     * Length of time in milliseconds to wait before showing a hidden item  after a click (defaults to 100)
     *
     * @param showDelay the show delay
     */
    public void setShowDelay(int showDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "showDelay", showDelay);
    }

    /**
     * True to hide the containing menu after this item is clicked (defaults to true).
     * 
     * @param hideOnClick true to hide on click
     */
    public void setHideOnClick(boolean hideOnClick) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideOnClick", hideOnClick);
    }

    /**
     * Return the BaseItemListener.
     *
     * @return the listener
     */
    public BaseItemListener getBaseItemListener() {
        return baseItemListener;
    }

    /**
     * Set the BaseItemListener.
     *
     * @param baseItemListener the listener
     */
    public void setBaseItemListener(BaseItemListener baseItemListener) {
        this.baseItemListener = baseItemListener;
    }

    //TODO not sure it this works
    /**
     * Set the icon CSS class.
     *
     * @param iconCls the icon class
     */
    public void setIconCls(String iconCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "iconCls", iconCls);
    }
}
