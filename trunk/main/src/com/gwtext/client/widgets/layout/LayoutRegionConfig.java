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

package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class LayoutRegionConfig {

    public static class LayoutRegionConstant {
        private String direction;

        private LayoutRegionConstant(String direction) {
            this.direction = direction;
        }

        public String getDirection() {
            return direction;
        }
    }

    public static LayoutRegionConstant NORTH = new LayoutRegionConstant("north");
    public static LayoutRegionConstant SOUTH = new LayoutRegionConstant("south");
    public static LayoutRegionConstant WEST = new LayoutRegionConstant("west");
    public static LayoutRegionConstant EAST = new LayoutRegionConstant("east");
    public static LayoutRegionConstant CENTER = new LayoutRegionConstant("center");

    private JavaScriptObject jsObj;

    public LayoutRegionConfig() {
        this.jsObj = JavaScriptObjectHelper.createObject();
    }

    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    public void setAutoScroll(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoScroll", value);
    }

    public void setAlwaysShowTabs(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "alwaysShowTabs", value);
    }

    public void setAnimate(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animate", value);
    }

    public void setAutoHide(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoHide", value);
    }

    public void setCloseOnTab(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "closeOnTab", value);
    }

    public void setCollapsed(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "collapsed", value);
    }

    public void setCmargins(int top, int left, int right, int bottom) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();

        JavaScriptObjectHelper.setAttribute(config, "top", top);
        JavaScriptObjectHelper.setAttribute(config, "right", right);
        JavaScriptObjectHelper.setAttribute(config, "bottom", bottom);
        JavaScriptObjectHelper.setAttribute(config, "left", left);
        JavaScriptObjectHelper.setAttribute(jsObj, "cmargins", config);
    }

    public void setCollapsedTitle(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "collapsedTitle", value);
    }

    public void setCollapsible(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "collapsible", value);
    }

    public void setDisableTabTips(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disableTabTips", value);
    }

    public void setFloatable(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "floatable", value);
    }

    public void setHidden(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hidden", value);
    }

    public void setHideWhenEmpty(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideWhenEmpty", value);
    }

    public void setMinTabWidth(int value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minTabWidth", value);
    }

    public void setPreferredTabWidth(int value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "preferredTabWidth", value);
    }

    public void setPreservePanels(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "preservePanels", value);
    }

    public void setResizeTabs(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizeTabs", value);
    }

    public void setShowPin(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "showPin", value);
    }

    public void setShim(boolean shim) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shim", shim);
    }

    //TODO make constant
    public void setTabPosition(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tabPosition", value);
    }

    public void setMargins(int top, int left, int right, int bottom) {
        JavaScriptObject cmargins = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(cmargins, "top", top);
        JavaScriptObjectHelper.setAttribute(cmargins, "right", right);
        JavaScriptObjectHelper.setAttribute(cmargins, "bottom", bottom);
        JavaScriptObjectHelper.setAttribute(cmargins, "left", left);
        JavaScriptObjectHelper.setAttribute(jsObj, "margins", cmargins);
    }

    public void setTitle(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "title", value);
    }

    public void setTitlebar(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "titlebar", value);
    }

    public void setSplit(boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "split", value);
    }

    public void setInitialSize(int value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "initialSize", value);
    }

    public void setMinSize(int value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minSize", value);
    }

    public void setMaxSize(int value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxSize", value);
    }
}
