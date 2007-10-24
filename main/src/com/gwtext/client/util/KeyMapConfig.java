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
package com.gwtext.client.util;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.widgets.event.KeyListener;

/**
 * KeyMap configuration class.
 */
public class KeyMapConfig extends BaseConfig {

    public KeyMapConfig() {
    }

    /**
     * The keycode to handle.
     *
     * @param keyCode the keycode
     */
    public KeyMapConfig(int keyCode) {
        JavaScriptObjectHelper.setAttribute(jsObj, "key", keyCode);
    }

    /**
     * An array of keycodes to handle.
     *
     * @param keyCodes keycodes
     */
    public KeyMapConfig(int[] keyCodes) {
        JavaScriptObjectHelper.setAttribute(jsObj, "key", JavaScriptObjectHelper.convertToJavaScriptArray(keyCodes));
    }

    /**
     * A list of keys to handle.
     *
     * @param keys the keys to handles
     */
    public KeyMapConfig(String keys) {
        JavaScriptObjectHelper.setAttribute(jsObj, "key", keys);
    }

    /**
     * The keycode to handle.
     *
     * @param key the keycode
     */
    public void setKey(int key) {
        JavaScriptObjectHelper.setAttribute(jsObj, "key", key);
    }

    /**
     * A list of keys to handle.
     *
     * @param keys the keys to handles
     */
    public void setKey(String keys) {
        JavaScriptObjectHelper.setAttribute(jsObj, "key", keys);
    }

    /**
     * An array of keycodes to handle.
     *
     * @param keyCodes keycodes
     */    
    public void setKey(int[] keyCodes) {
        JavaScriptObjectHelper.setAttribute(jsObj, "key", JavaScriptObjectHelper.convertToJavaScriptArray(keyCodes));
    }

    /**
     * True to handle key only when ctrl is pressed (defaults to false).
     *
     * @param ctrl true to handle ctrl
     */
    public void setCtrl(boolean ctrl) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ctrl", ctrl);
    }

    /**
     * True to handle key only when alt is pressed (defaults to false).
     *
     * @param alt true to handle alt
     */
    public void setAlt(boolean alt) {
        JavaScriptObjectHelper.setAttribute(jsObj, "alt", alt);
    }

    /**
     * True to handle key only when shift is pressed (defaults to false)
     *
     * @param shift true to handle shift
     */
    public void setShift(boolean shift) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shift", shift);
    }

    /**
     *  The listener to call when KeyMap finds the expected key combination.
     *
     * @param listener the listener
     */
    public native void setKeyListener(KeyListener listener) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['fn'] = function(key, event) {
            var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
            listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
        };
    }-*/;
}
