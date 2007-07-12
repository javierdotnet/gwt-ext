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

package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;

public class LayoutRegion {
    private JavaScriptObject jsObj;

    protected LayoutRegion(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public static LayoutRegion instance(JavaScriptObject jsObj) {
        return new LayoutRegion(jsObj);
    }

    public ContentPanel getPanel(String contentId) {
        return new ContentPanel(getPanel(jsObj, contentId));
    }

    private static native JavaScriptObject getPanel(JavaScriptObject layoutRegion, String contentId)/*-{
        layoutRegion.getPanel(contentId);
    }-*/;

    public native void showPanel(String contentId)/*-{
        var layoutRegion = this.@com.gwtext.client.widgets.layout.LayoutRegion::jsObj;
        layoutRegion.showPanel(contentId);
    }-*/;
}
