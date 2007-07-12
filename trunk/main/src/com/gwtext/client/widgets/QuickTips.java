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

package com.gwtext.client.widgets;

public class QuickTips {

    public static native void disable()/*-{
        $wnd.Ext.QuickTips.disable();
    }-*/;

    public static native void enable()/*-{
        $wnd.Ext.QuickTips.enable();
    }-*/;

    public static native void init()/*-{
        $wnd.Ext.QuickTips.init();
    }-*/;

    public static native boolean isEnabled()/*-{
        return $wnd.Ext.QuickTips.isEnabled();
    }-*/;

    //todo test
    public native void register(String id, QuickTipsConfig config) /*-{
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        configJS['target'] = id;
        $wnd.Ext.QuickTips.register(configJS);
     }-*/;
}
