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
