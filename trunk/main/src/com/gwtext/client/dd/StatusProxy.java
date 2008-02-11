/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.dd;

import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.Layer;
import com.google.gwt.core.client.JavaScriptObject;

public class StatusProxy extends JsObject {

    public StatusProxy(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public StatusProxy() {
        jsObj = create(null);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.StatusProxy(config);
    }-*/;


    private static StatusProxy instance(JavaScriptObject jsObj) {
        return new StatusProxy(jsObj);
    }
    /**
     * Returns the underlying proxy {@link Layer}.
     *
     * @return the underlying proxy Layer
     */
    public native Layer getEl() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var layer = proxy.getEl();
        return @com.gwtext.client.widgets.Layer::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(layer);
    }-*/;

    /**
     * Returns the ghost element.
     *
     * @return the ghost element
     */
    public native ExtElement getGhost() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var ghost = proxy.getGhost();
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ghost);
    }-*/;

    public native void hide() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.hide();
    }-*/;

    public native void hide(boolean clear) /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.hide(clear);
    }-*/;

    public native void reset() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.reset();
    }-*/;

    public native void reset(boolean clearGhost) /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.reset(clearGhost);
    }-*/;

    public native void setStatus(String cssClass) /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.setStatus(cssClass);
    }-*/;

    public native void show() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.show();
    }-*/;

    public native void stop() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.stop();
    }-*/;

    public native void sync() /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.sync();
    }-*/;

    public native void update(String html) /*-{
        var proxy = this.@com.gwtext.client.core.JsObject::getJsObj()();
        proxy.update(html);
    }-*/;
}
