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

public class ResizableConfig extends BaseConfig {

    public void setAutoAdjustments() {
        JavaScriptObjectHelper.setAttribute(jsObj, "adjustments", "auto");
    }
    public void setAdjustments(int widthAdjustment, int heightAdjustment) {
        int[] adjustments = new int[]{widthAdjustment, heightAdjustment};
        JavaScriptObjectHelper.setAttribute(jsObj, "adjustments", adjustments);
    }

    public void setAnimate(boolean animate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animate", animate);
    }

    public void setDisableTrackOver(boolean disableTrackOver) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disableTrackOver", disableTrackOver);
    }

    public void setDraggable(boolean draggable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "draggable", draggable);
    }

    public void setDuration(float duration) {
        JavaScriptObjectHelper.setAttribute(jsObj, "duration", duration);
    }

    public void setDynamic(boolean dynamic) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dynamic", dynamic);
    }

    public void setEasing(String easing) {
        JavaScriptObjectHelper.setAttribute(jsObj, "easing", easing);
    }

    public void setEnabled(boolean enabled) {
        JavaScriptObjectHelper.setAttribute(jsObj, "enabled", enabled);
    }

    public void setHandles(boolean handles) {
        //temp fix for Ext bug : http://extjs.com/forum/showthread.php?t=9813
        if(handles) {
            setHandles("all");
        } else  {
            JavaScriptObjectHelper.setAttribute(jsObj, "handles", handles);
        }
    }

    public void setHandles(String handles) {
        JavaScriptObjectHelper.setAttribute(jsObj, "handles", handles);
    }

    public void setHeight(int height) {
        JavaScriptObjectHelper.setAttribute(jsObj, "height", height);
    }

    public void setHeightIncrement(int heightIncrement) {
        JavaScriptObjectHelper.setAttribute(jsObj, "heightIncrement", heightIncrement);
    }

    public void setMaxHeight(int maxHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxHeight", maxHeight);
    }

    public void setMaxWidth(int maxWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxWidth", maxWidth);
    }

    public void setMinHeight(int minHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minHeight", minHeight);
    }

    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    public void setMinX(int minX) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minX", minX);
    }

    public void setMinY(int minY) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minY", minY);
    }

    public void setMultiDirectional(boolean multiDirectional) {
        JavaScriptObjectHelper.setAttribute(jsObj, "multiDirectional", multiDirectional);
    }

    public void setPinned(boolean pinned) {
        JavaScriptObjectHelper.setAttribute(jsObj, "pinned", pinned);
    }

    public void setPreserveRation(boolean preserveRation) {
        JavaScriptObjectHelper.setAttribute(jsObj, "preserveRation", preserveRation);
    }

    public void setResizeChild(boolean resizeChild) {
        JavaScriptObjectHelper.setAttribute(jsObj, "resizeChild", resizeChild);
    }

    public void setTransparent(boolean transparent) {
        JavaScriptObjectHelper.setAttribute(jsObj, "transparent", transparent);
    }

    public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }

    public void setWidthIncrement(boolean widthIncrement) {
        JavaScriptObjectHelper.setAttribute(jsObj, "widthIncrement", widthIncrement);
    }

    public void setWrap(boolean wrap) {
        JavaScriptObjectHelper.setAttribute(jsObj, "wrap", wrap);
    }
                                                                                                  
}
