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

package com.gwtext.client.dd;

import com.google.gwt.core.client.JavaScriptObject;

public class DDProxy extends DD {

    public DDProxy(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DDProxy(String id) {
        super(id);
    }

    public DDProxy(String id, String sGroup) {
        super(id, sGroup);
    }

    public DDProxy(String id, String sGroup, DragDropProxyConfig config) {
        super(id, sGroup, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DDProxy(id, sGroup, config);
    }-*/;

    public native boolean isCenterFrame() /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::jsObj;
        return ddProxy.centerFrame ? true : false;
    }-*/;

    public native void setCenterFrame(boolean centerFrame) /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::jsObj;
        ddProxy.centerFrame = centerFrame;
    }-*/;

    public native boolean isResizeFrame() /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::jsObj;
        return ddProxy.resizeFrame ? true : false;
    }-*/;

    public native void setResizeFrame(boolean resizeFrame) /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::jsObj;
        ddProxy.resizeFrame = resizeFrame;
    }-*/;

    public native void createFrame() /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::jsObj;
        ddProxy.createFrame();
    }-*/;

    public native void initFrame() /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::jsObj;
        ddProxy.initFrame();
    }-*/;
}
