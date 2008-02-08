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
        var provider = this.@com.gwtext.client.core.JsObject::jsObj;
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
        var provider = this.@com.gwtext.client.core.JsObject::jsObj;
        var val = provider.get(name);
        return val === undefined ? null : val.toString();
    }-*/;

    /**
     * Sets the value for a key.
     * 
     * @param name the key name
     * @param value the key value
     */
    public native void set(String name, String value) /*-{
        var provider = this.@com.gwtext.client.core.JsObject::jsObj;
        provider.set(name, value);
    }-*/;
}
