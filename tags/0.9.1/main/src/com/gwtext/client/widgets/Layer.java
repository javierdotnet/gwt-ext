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
import com.gwtext.client.core.ExtElement;

public class Layer extends ExtElement {

    public Layer(LayerConfig config) {
        this(config, null);
    }

    public Layer(LayerConfig config, Element existingEl) {
        jsObj = create(config.getJsObj(), existingEl);
    }

    private static native JavaScriptObject create(JavaScriptObject config, Element existingEl) /*-{
        return new $wnd.Ext.Layer(config, existingEl);
    }-*/;

    public native void setZIndex(int zindex) /*-{
        var layer = this.@com.gwtext.client.core.JsObject::jsObj;
        layer.setZIndex(zindex);
    }-*/;
}
