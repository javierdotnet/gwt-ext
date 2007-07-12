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

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.menu.event.CheckItemListener;

public class CheckItemConfig extends ItemConfig {
    private CheckItemListener listener;

    public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
    }


    public void setChecked(boolean checked) {
        JavaScriptObjectHelper.setAttribute(jsObj, "checked", checked);
    }

    public void setGroup(String group) {
        JavaScriptObjectHelper.setAttribute(jsObj, "group", group);
    }

    public void setGroupClass(String groupClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "groupClass", groupClass);
    }

    public void setItemCls(String itemCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "itemCls", itemCls);
    }

    public void setCheckItemListener(CheckItemListener listener) {
        this.listener = listener;
    }

    public CheckItemListener getCheckItemListener() {
        return listener;
    }
}
