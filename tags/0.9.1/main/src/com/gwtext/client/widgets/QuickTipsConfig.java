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

public class QuickTipsConfig extends BaseConfig {

    //todo check ext source code
    /*
    public void setDelay(int delay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "Delay", delay);
    }

    public void setTrue(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "True", value);
    }
    */

    public void setTitle(String title) {
        JavaScriptObjectHelper.setAttribute(jsObj, "title", title);
    }

    public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
    }


    public void setAnimate(boolean animate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animate", animate);
    }

    public void setAutoHide(boolean autoHide) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoHide", autoHide);
    }

    public void setHideDelay(int hideDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideDelay", hideDelay);
    }

    public void setHideOnClick(boolean hideOnClick) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideOnClick", hideOnClick);
    }

    public void setInterceptTitles(boolean interceptTitles) {
        JavaScriptObjectHelper.setAttribute(jsObj, "interceptTitles", interceptTitles);
    }

    public void setMaxWidth(int maxWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxWidth", maxWidth);
    }

    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    public void setShowDelay(int showDelay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "showDelay", showDelay);
    }

    public void setTrackMouse(boolean trackMouse) {
        JavaScriptObjectHelper.setAttribute(jsObj, "trackMouse", trackMouse);
    }
}
