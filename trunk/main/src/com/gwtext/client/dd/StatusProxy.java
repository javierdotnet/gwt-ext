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

import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.Layer;
import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 * @author Sanjiv Jivan
 */
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
