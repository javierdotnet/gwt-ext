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

    public DDProxy(Component component) {
        super(component);
    }

    public DDProxy(Component component, String sGroup) {
        super(component, sGroup);
    }

    public DDProxy(Component component, String sGroup, DragDropConfig config) {
        super(component, sGroup, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DDProxy(id, sGroup, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DDProxy(element, sGroup, config);
    }-*/;

    public native boolean isCenterFrame() /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ddProxy.centerFrame ? true : false;
    }-*/;

    public native void setCenterFrame(boolean centerFrame) /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ddProxy.centerFrame = centerFrame;
    }-*/;

    public native boolean isResizeFrame() /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ddProxy.resizeFrame ? true : false;
    }-*/;

    public native void setResizeFrame(boolean resizeFrame) /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ddProxy.resizeFrame = resizeFrame;
    }-*/;

    public native void createFrame() /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ddProxy.createFrame();
    }-*/;

    public native void initFrame() /*-{
        var ddProxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        ddProxy.initFrame();
    }-*/;
}
