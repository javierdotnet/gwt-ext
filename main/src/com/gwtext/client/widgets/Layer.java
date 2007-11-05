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

/**
 * An extended {@link ExtElement} object that supports a shadow and shim, constrain to viewport and automatic maintaining of shadow/shim positions.
 */
public class Layer extends ExtElement {

    /**
     * Create a new Layer.
     *
     * @param config the layer config
     */
    public Layer(LayerConfig config) {
        this(config, null);
    }

    /**
     * Create a new Layer.
     *
     * @param config the layer config
     * @param existingEl an existing element
     */
    public Layer(LayerConfig config, Element existingEl) {
        jsObj = create(config.getJsObj(), existingEl);
    }

    private static native JavaScriptObject create(JavaScriptObject config, Element existingEl) /*-{
        return new $wnd.Ext.Layer(config, existingEl);
    }-*/;

    /**
     * Sets the z-index of this layer and adjusts any shadow and shim z-indexes. The layer z-index is automatically
     * incremented by two more than the value passed in so that it always shows above any shadow or shim (the shadow element, 
     * if any, will be assigned z-index + 1, and the shim element, if any, will be assigned the unmodified z-index).
     *
     * @param zindex the z index
     */
    public native void setZIndex(int zindex) /*-{
        var layer = this.@com.gwtext.client.core.JsObject::jsObj;
        layer.setZIndex(zindex);
    }-*/;
}
