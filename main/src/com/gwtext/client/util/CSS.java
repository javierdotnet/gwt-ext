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

public class CSS {

    public static native void createStyleSheet(String cssText)/*-{
        $wnd.Ext.util.CSS.createStyleSheet(cssText);
    }-*/;

    public static native CSSRule getRule(String selector, boolean refreshCache)/*-{
        var rule = $wnd.Ext.util.CSS.getRule(selector, refreshCache);
        if(rule == null ||  rule === undefined) {
            return null;
        } else {
            return @com.gwtext.client.util.CSSRule::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(rule);
        }
    }-*/;

    public static native void refreshCache()/*-{
        $wnd.Ext.util.CSS.refreshCache();
    }-*/;

    public static native void removeStyleSheet(String id)/*-{
        $wnd.Ext.util.CSS.removeStyleSheet(id);
    }-*/;

    public static native void swapStyleSheet(String id, String url)/*-{
        $wnd.Ext.util.CSS.swapStyleSheet(id, url);
    }-*/;

    public static native void updateRule(String selector, String property, String value)/*-{
        $wnd.Ext.util.CSS.updateRule(selector, property, value);
    }-*/;
}
