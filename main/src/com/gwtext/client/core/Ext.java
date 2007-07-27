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

import com.google.gwt.core.client.JavaScriptObject;

public class Ext {

    public static ExtElement get(String id) {
        JavaScriptObject el = getEl(id);
        return el == null ? null : new ExtElement(el);
    }

    private static native JavaScriptObject getEl(String id)/*-{
        return $wnd.Ext.get(id);
    }-*/;

    public static native boolean isIE()/*-{
        return $wnd.Ext.isIE;
    }-*/;

    public static native String generateId()/*-{
        return $wnd.Ext.id();
    }-*/;

    //made package protected. Users don't need to call this anymore since it is handled internally on
    //applicaiotn startup.
    native static void setBlankImageUrl(String url) /*-{
        $wnd.Ext.BLANK_IMAGE_URL = url;    
    }-*/;
}
