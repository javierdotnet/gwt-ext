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
import com.google.gwt.user.client.Element;

public class DD extends DragDrop {

    public DD(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DD(String id) {
        this(id, null);
    }

    public DD(String id, String sGroup) {
        this(id, sGroup, null);
    }

    public DD(String id, String sGroup, DragDropConfig config) {
        super(id, sGroup, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DD(id, sGroup, config);
    }-*/;

    private static DD instance(JavaScriptObject jsObj) {
        return new DD(jsObj);
    }

    public native boolean isScroll() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        return dd.scroll ? true : false;
    }-*/;

    public native void setScroll(boolean scroll) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.scroll = scroll;
    }-*/;

    public native void alignElWithMouse(Element el, int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.alignElWithMouse(el, iPageX, iPageY);
    }-*/;

    public native void autoOffset(int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.autoOffset(iPageX, iPageY);
    }-*/;

    public native void cachePosition(int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.cachePosition(iPageX, iPageY);
    }-*/;

    public native void setDelta(int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.setDelta(iPageX, iPageY);
    }-*/;

    public native void setDragElPos(int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::jsObj;
        dd.setDragElPos(iPageX, iPageY);
    }-*/;
}
