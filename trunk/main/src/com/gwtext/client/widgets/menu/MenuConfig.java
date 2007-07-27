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
import com.gwtext.client.widgets.menu.event.MenuListener;

public class MenuConfig extends BaseConfig {

    private MenuListener menuListener;

    public void setAllowOtherMenus(boolean allowOtherMenus) {
        JavaScriptObjectHelper.setAttribute(jsObj, "allowOtherMenus", allowOtherMenus);
    }

    //TODO make enum
    public void setDefaultAlign(String defaultAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultAlign", defaultAlign);
    }

    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    public void setShadow(boolean shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    //TODO make enum
    public void setShadow(String shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    //TODO make enum
    public void setSubMenuAlign(String subMenuAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "subMenuAlign", subMenuAlign);
    }

    public MenuListener getMenuListener() {
        return menuListener;
    }

    public void setMenuListener(MenuListener menuListener) {
        this.menuListener = menuListener;
    }
}
