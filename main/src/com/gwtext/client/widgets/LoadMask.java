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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;

public class LoadMask extends JsObject {

    public LoadMask(Element element, LoadMaskConfig config) {
        jsObj = create(element, config.getJsObj());
    }

    public LoadMask(String id, LoadMaskConfig config) {
        jsObj = create(id, config.getJsObj());
    }

    private native JavaScriptObject create(Element element, JavaScriptObject config) /*-{
        return new $wnd.Ext.LoadMask(element, config);
    }-*/;

    private native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.LoadMask(id, config);
    }-*/;

    public native void disable() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::jsObj;
        lm.disable();
    }-*/;

    public native void enable() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::jsObj;
        lm.enable();
    }-*/;

    public native boolean isDisabled() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::jsObj;
        return lm.disabled;
    }-*/;
}
