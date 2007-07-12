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
import com.gwtext.client.core.BaseConfig;

public class LayoutDialogConfig extends BaseConfig {

    public void setAnimateTarget(String animateTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animateTarget", animateTarget);
    }

    public void setAutoCreate(boolean autoCreate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoCreate", autoCreate);
    }

    public void setAutoScroll(boolean autoScroll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoScroll", autoScroll);
    }

    public void setAutoTabs(boolean autoTabs) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoTabs", autoTabs);
    }

    public void setButtonAlign(String buttonAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buttonAlign", buttonAlign);
    }

    public void setClosable(boolean closable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "closable", closable);
    }

    public void setCollapsible(boolean collapsible) {
        JavaScriptObjectHelper.setAttribute(jsObj, "collapsible", collapsible);
    }

    public void setConstrainttoviewport(boolean constrainttoviewport) {
        JavaScriptObjectHelper.setAttribute(jsObj, "constrainttoviewport", constrainttoviewport);
    }

    public void setDraggable(boolean draggable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "draggable", draggable);
    }

    public void setFixedcenter(boolean fixedcenter) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fixedcenter", fixedcenter);
    }

    public void setHeight(int height) {
        JavaScriptObjectHelper.setAttribute(jsObj, "height", height);
    }

    public void setMinButtonWidth(int minButtonWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minButtonWidth", minButtonWidth);
    }

    public void setMinHeight(int minHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minHeight", minHeight);
    }

    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    public void setModal(boolean modal) {
        JavaScriptObjectHelper.setAttribute(jsObj, "modal", modal);
    }

    public void setProxyDrag(boolean proxyDrag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "proxyDrag", proxyDrag);
    }

    public void setResizable(boolean resizable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizable", resizable);
    }

    public void setResizeHandles(String resizeHandles) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizeHandles", resizeHandles);
    }

    public void setShadow(boolean shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    public void setShadow(String shadow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadow", shadow);
    }

    public void setShadowOffset(int shadowOffset) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shadowOffset", shadowOffset);
    }

    public void setShim(boolean shim) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shim", shim);
    }

    public void setSyncHeightBeforeShow(boolean syncHeightBeforeShow) {
        JavaScriptObjectHelper.setAttribute(jsObj, "syncHeightBeforeShow", syncHeightBeforeShow);
    }

    public void setTabTag(String tabTag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "tabTag", tabTag);
    }

    public void setTitle(String title) {
        JavaScriptObjectHelper.setAttribute(jsObj, "title", title);
    }

    public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

    public void setX(int x) {
        JavaScriptObjectHelper.setAttribute(jsObj, "x", x);
    }

    public void setY(int y) {
        JavaScriptObjectHelper.setAttribute(jsObj, "y", y);
    }

}
