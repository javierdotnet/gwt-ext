/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.dd;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.Component;

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
