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
package com.gwtext.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;

public class KeyMap extends JsObject {

    public KeyMap(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public KeyMap(String id, KeyMapConfig config) {
        this(id, config, null);
    }

    public KeyMap(Element el, KeyMapConfig config) {
        this(el, config, null);
    }

    public KeyMap(String id, KeyMapConfig config, String eventName) {
        jsObj = create(id, config.getJsObj(), eventName);
    }

    public KeyMap(Element el, KeyMapConfig config, String eventName) {
        jsObj = create(el, config.getJsObj(), eventName);
    }

    private static native JavaScriptObject create(Element el, JavaScriptObject config, String eventName) /*-{
        return new  $wnd.Ext.KeyMap(el, config, eventName);
    }-*/;

    private static native JavaScriptObject create(String id, JavaScriptObject config, String eventName) /*-{
        return new  $wnd.Ext.KeyMap(id, config, eventName);
    }-*/;

    public static KeyMap instance(JavaScriptObject jsObj) {
        return new KeyMap(jsObj);
    }

    public native void addBinding(KeyMapConfig config) /*-{
        var km = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = this.@com.gwtext.client.core.JsObject::jsObj;
        km.addBinding(configJS);
    }-*/;

    public native void disable() /*-{
        var km = this.@com.gwtext.client.core.JsObject::jsObj;
        km.disable();
    }-*/;

    public native void enable() /*-{
        var km = this.@com.gwtext.client.core.JsObject::jsObj;
        km.enable();
    }-*/;

    public native boolean isEnabled() /*-{
        var km = this.@com.gwtext.client.core.JsObject::jsObj;
        return km.isEnabled();
    }-*/;

    public native void setStopEvent(boolean stopEvent) /*-{
        var km = this.@com.gwtext.client.core.JsObject::jsObj;
        km.stopEvent = stopEvent;
    }-*/;
}
