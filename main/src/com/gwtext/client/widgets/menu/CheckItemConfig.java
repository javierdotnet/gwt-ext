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

/**
 * Configuration class for {@link CheckItem}.
 */
public class CheckItemConfig extends ItemConfig {

    private CheckItemListener listener;

    /**
     * The text of the check item.
     * 
     * @param text the text
     */
    public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
    }

    /**
     * True to initialize this checkbox as checked (defaults to false). Note that if this checkbox is part of a radio group (group = true) only the last item in the group that is initialized with checked = true will be rendered as checked.
     *
     * @param checked true to set as checked
     */
    public void setChecked(boolean checked) {
        JavaScriptObjectHelper.setAttribute(jsObj, "checked", checked);
    }

    /**
     * All check items with the same group name will automatically be grouped into a single-select radio button group (defaults to '').
     *
     * @param group the group name
     */
    public void setGroup(String group) {
        JavaScriptObjectHelper.setAttribute(jsObj, "group", group);
    }

    /**
     * The default CSS class to use for radio group check items (defaults to "x-menu-group-item").
     * 
     * @param groupClass the group CSS class
     */
    public void setGroupClass(String groupClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "groupClass", groupClass);
    }

    /**
     * The default CSS class to use for check items (defaults to "x-menu-item x-menu-check-item").
     *
     * @param itemCls
     */
    public void setItemCls(String itemCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "itemCls", itemCls);
    }

    /**
     * Set a CheckItem listener.
     *
     * @param listener the listener
     */
    public void setCheckItemListener(CheckItemListener listener) {
        this.listener = listener;
    }

    /**
     * Return the CheckItemListener.
     *
     * @return the listener
     */
    public CheckItemListener getCheckItemListener() {
        return listener;
    }
}
