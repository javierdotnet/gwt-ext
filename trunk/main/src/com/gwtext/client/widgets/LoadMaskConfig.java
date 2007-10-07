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

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * {@link LoadMask} config class.
 *
 * @see com.gwtext.client.widgets.LoadMask
 */
public class LoadMaskConfig extends BaseConfig {

    public LoadMaskConfig() {
    }

    /**
     * The text to display in a centered loading message box.
     *
     * @param msg text to dispaly
     */
    public LoadMaskConfig(String msg) {
        JavaScriptObjectHelper.setAttribute(jsObj, "msg", msg);
    }

    /**
     * The text to display in a centered loading message box (defaults to 'Loading...')
     *
     * @param msg message to display
     */
    public void setMsg(String msg) {
        JavaScriptObjectHelper.setAttribute(jsObj, "msg", msg);
    }

    /**
     * The CSS class to apply to the loading message element (defaults to "x-mask-loading").
     *
     * @param msgCls the message CSS class
     */
    public void setMsgCls(String msgCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "msgCls", msgCls);
    }

    /**
     * True to create a single-use mask that is automatically destroyed after loading (useful for page loads), False to persist
     * the mask element reference for multiple uses (e.g., for paged data widgets).
     *
     * @param removeMask defaults to false
     */
    public void setRemoveMask(boolean removeMask) {
        JavaScriptObjectHelper.setAttribute(jsObj, "removeMask", removeMask);
    }
}
