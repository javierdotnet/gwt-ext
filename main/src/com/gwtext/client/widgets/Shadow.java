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

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class Shadow extends BaseExtWidget {
    public Shadow(String mode, String offset) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "mode", mode);
        JavaScriptObjectHelper.setAttribute(config, "offset", offset);
        jsObj = create(config);
    }

    private native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Shadow(config);
    }-*/;

    public native void hide() /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.hide();
    }-*/;

    public native boolean isVisible() /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return shadow.isVisible();
    }-*/;

    public native void realign(int left, int top, int width, int height) /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.realign(left, top, width, height);
    }-*/;

    public native void setZIndex(int zindex) /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.setZIndex(zindex);
    }-*/;

    public native void show(String id) /*-{
        var shadow = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        shadow.show(id);
    }-*/;
}