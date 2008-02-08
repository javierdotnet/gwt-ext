/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Configuration class that represents an Elements position configuration.
 *
 * @see ExtElement#getPositioning()
 * @see ExtElement#setPositioning(PositioningConfig)
 */
public class PositioningConfig extends JsObject {

    public PositioningConfig(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    private static PositioningConfig instance(JavaScriptObject jsObj) {
        return new PositioningConfig(jsObj);
    }
}
