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

public class BaseItemConfig extends BaseConfig {

    private BaseItemListener baseItemListener;

    //TODO not sure it this works
    public void setId(String id) {
        JavaScriptObjectHelper.setAttribute(jsObj, "id", id);
    }

    public void setActiveClass(String activeClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "activeClass", activeClass);
    }

    public void setCanActivate(boolean canActivate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "canActivate", canActivate);
    }

    public void setHideDelay(int hideDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideDelay", hideDelay);
    }

    public void setShowDelay(int showDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "showDelay", showDelay);
    }

    public void setHideOnClick(boolean hideOnClick) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideOnClick", hideOnClick);
    }

    public BaseItemListener getBaseItemListener() {
        return baseItemListener;
    }

    public void setBaseItemListener(BaseItemListener baseItemListener) {
        this.baseItemListener = baseItemListener;
    }

    //TODO not sure it this works 
    public void setIconCls(String iconCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "iconCls", iconCls);
    }
}
