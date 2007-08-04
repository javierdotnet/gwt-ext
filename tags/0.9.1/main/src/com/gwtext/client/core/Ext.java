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

package com.gwtext.client.core;

import com.google.gwt.user.client.Element;

public class Ext {

    public static native void setSslSecureUrl(String url)/*-{
        $wnd.Ext.SSL_SECURE_URL = url;
    }-*/;

    public static native void setEnableGarbageCollector(boolean enableGarbageCollector)/*-{
        $wnd.Ext.enableGarbageCollector = enableGarbageCollector;
    }-*/;

    public static native void isEnableGarbageCollector()/*-{
        return $wnd.Ext.enableGarbageCollector;
    }-*/;

    public static native void setEnableListenerCollection(boolean enableListenerCollection)/*-{
        $wnd.Ext.enableListenerCollection = enableListenerCollection;
    }-*/;

    public static native void isEnableListenerCollection()/*-{
        return $wnd.Ext.enableListenerCollection;
    }-*/;

    public static native boolean isBorderBox()/*-{
        return $wnd.Ext.isBorderBox;
    }-*/;

    public static native boolean isGecko()/*-{
        return $wnd.Ext.isGecko;
    }-*/;

    public static native boolean isIE()/*-{
        return $wnd.Ext.isIE;
    }-*/;

    public static native boolean isIE7()/*-{
        return $wnd.Ext.isIE7;
    }-*/;

    public static native boolean isLinux()/*-{
        return $wnd.Ext.isLinux;
    }-*/;

    public static native boolean isMac()/*-{
        return $wnd.Ext.isMac;
    }-*/;

    public static native boolean isOpera()/*-{
        return $wnd.Ext.isOpera;
    }-*/;

    public static native boolean isReady()/*-{
        return $wnd.Ext.isReady;
    }-*/;

    public static native boolean isSafari()/*-{
        return $wnd.Ext.isSafari;
    }-*/;

    public static native boolean isSecure()/*-{
        return $wnd.Ext.isSecure;
    }-*/;

    public static native boolean isStrict()/*-{
        return $wnd.Ext.isStrict;
    }-*/;

    public static native boolean isWindows()/*-{
        return $wnd.Ext.isWindows;
    }-*/;

    public static native boolean isUseShims()/*-{
        return $wnd.Ext.useShims;
    }-*/;

    public static native String escapeRe(String str)/*-{
        return $wnd.Ext.escapeRe(str);
    }-*/;

    //made package protected. Users don't need to call this anymore since it is handled internally on
    //applicaiotn startup.
    native static void setBlankImageUrl(String url) /*-{
        $wnd.Ext.BLANK_IMAGE_URL = url;    
    }-*/;

    public static native ExtElement get(String id) /*-{
        var el = $wnd.Ext.get(id);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public static native ExtElement get(Element element) /*-{
        var el = $wnd.Ext.get(element);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public static native ExtElement fly(String id) /*-{
        var el = $wnd.Ext.fly(id);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public static native ExtElement fly(String id, String named) /*-{
        var el = $wnd.Ext.fly(id, named);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public static native ExtElement fly(Element element) /*-{
        var el = $wnd.Ext.fly(element);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public static native ExtElement fly(Element element, String named) /*-{
        var el = $wnd.Ext.fly(element, named);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public static native String generateId()/*-{
        return $wnd.Ext.id();
    }-*/;

    public static native String generateId(String prefix)/*-{
        return $wnd.Ext.id(null, prefix);
    }-*/;
}
