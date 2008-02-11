/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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
     * @param config     the layer config
     * @param existingEl an existing element
     */
    public Layer(LayerConfig config, Element existingEl) {
        jsObj = create(config.getJsObj(), existingEl);
    }

    public Layer(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static Layer instance(JavaScriptObject jsObj) {
        return new Layer(jsObj);
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
        var layer = this.@com.gwtext.client.core.JsObject::getJsObj()();
        layer.setZIndex(zindex);
    }-*/;
}
