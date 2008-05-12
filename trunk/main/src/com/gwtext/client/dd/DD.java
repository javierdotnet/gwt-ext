/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.dd;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.Component;

/**
 * @author Sanjiv Jivan
 */
public class DD extends DragDrop {

    public DD(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DD(String id) {
        this(id, null);
    }

    public DD(Component component) {
        super(component);
    }

    public DD(String id, String sGroup) {
        this(id, sGroup, null);
    }

    public DD(Component component, String sGroup) {
        super(component, sGroup);
    }

    public DD(String id, String sGroup, DragDropConfig config) {
        super(id, sGroup, config);
    }

    public DD(Component component, String sGroup, DragDropConfig config) {
        super(component, sGroup, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DD(id, sGroup, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DD(element, sGroup, config);
    }-*/;

    private static DD instance(JavaScriptObject jsObj) {
        return new DD(jsObj);
    }

    public native boolean isScroll() /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return dd.scroll ? true : false;
    }-*/;

    public native void setScroll(boolean scroll) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.scroll = scroll;
    }-*/;

    public native void alignElWithMouse(Element el, int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.alignElWithMouse(el, iPageX, iPageY);
    }-*/;

    public native void autoOffset(int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.autoOffset(iPageX, iPageY);
    }-*/;

    public native void cachePosition(int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.cachePosition(iPageX, iPageY);
    }-*/;

    public native void setDelta(int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.setDelta(iPageX, iPageY);
    }-*/;

    public native void setDragElPos(int iPageX, int iPageY) /*-{
        var dd = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dd.setDragElPos(iPageX, iPageY);
    }-*/;
}
