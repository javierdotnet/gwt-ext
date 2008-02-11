/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.state;

import com.gwtext.client.core.JsObject;

/**
 * Abstract base class for state provider implementations.
 */
public abstract class Provider extends JsObject {

    /**
     * Clears a value from the state.
     *
     * @param name the key name
     */
    public native void clear(String name) /*-{
        var provider = this.@com.gwtext.client.core.JsObject::getJsObj()();
        provider.clear(name);
    }-*/;

    //todo add get and set
    /**
     * Returns the current value for a key
     *
     * @param name the key name
     * @return the key valeu as String
     */
    public native String getAsString(String name) /*-{
        var provider = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var val = provider.get(name);
        return val === undefined ? null : val.toString();
    }-*/;

    /**
     * Sets the value for a key.
     *
     * @param name  the key name
     * @param value the key value
     */
    public native void set(String name, String value) /*-{
        var provider = this.@com.gwtext.client.core.JsObject::getJsObj()();
        provider.set(name, value);
    }-*/;
}
