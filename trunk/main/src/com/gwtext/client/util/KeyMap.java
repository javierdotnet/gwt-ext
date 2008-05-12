/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;

/**
 * Handles mapping keys to actions for an element. One key map can be used for multiple actions.
 * If you bind a callback function to a KeyMap, anytime the KeyMap handles an expected key combination it will call the
 * function with this signature (if the match is a multi-key combination the callback will still be called only once):
 * (String key, EventObject e) A KeyMap can also handle a string representation of keys.
 * <p/>
 * <pre>
 *       // map one key by key code
 *       KeyMap map = new KeyMap("my-element", new KeyMapConfig() {
 *           {
 *               setKey(13);  // or EventObject.ENTER
 *               setKeyListener(new KeyListener() {
 *                   public void onKey(int key, EventObject e) {
 *                       //handle key
 *                   }
 *               });
 *           }
 *       });
 * <p/>
 *       // map multiple keys to one action by string
 *       KeyMap map = new KeyMap("my-element", new KeyMapConfig() {
 *           {
 *               setKey("a\r\n\t");
 *               setKeyListener(new KeyListener() {
 *                   public void onKey(int key, EventObject e) {
 *                       //handle key
 *                   }
 *               });
 *           }
 *       });
 * <p/>
 *       KeyMap map = new KeyMap("my-element", new KeyMapConfig() {
 *          {
 *               setKey(new int[]{10, 13});
 *               setKeyListener(new KeyListener() {
 *                   public void onKey(int key, EventObject e) {
 *                       // return was pressed
 *                   }
 *               });
 *           }
 *       });
 * <p/>
 *       KeyMap map = new KeyMap("my-element", new KeyMapConfig() {
 *           {
 *               setKey("abc");
 *               setKeyListener(new KeyListener() {
 *                   public void onKey(int key, EventObject e) {
 *                       // a, b or c was pressed
 *                   }
 *               });
 *           }
 *       });
 * <p/>
 *       KeyMap map = new KeyMap("my-element", new KeyMapConfig() {
 *           {
 *               setKey("\t");
 *               setCtrl(true);
 *               setShift(true);
 *               setKeyListener(new KeyListener() {
 *                   public void onKey(int key, EventObject e) {
 *                       // Ctrl + shift + tab was pressed
 *                   }
 *               });
 *           }
 *       });
 * <p/>
 *  </pre>
 *
 * @author Sanjiv Jivan
 */
public class KeyMap extends JsObject {

    public KeyMap(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new key map for the element.
     *
     * @param id     the element id
     * @param config keymap config
     */
    public KeyMap(String id, KeyMapConfig config) {
        this(id, config, null);
    }

    /**
     * Create a new key map for the element.
     *
     * @param el     the element
     * @param config keymap config
     */
    public KeyMap(Element el, KeyMapConfig config) {
        this(el, config, null);
    }

    /**
     * Create a new key map for the element.
     *
     * @param id        the element id
     * @param config    keymap config
     * @param eventName the event to bind to (defaults to "keydown")
     */
    public KeyMap(String id, KeyMapConfig config, String eventName) {
        jsObj = create(id, config.getJsObj(), eventName);
    }

    /**
     * Create a new key map for the element.
     *
     * @param el        the element
     * @param config    keymap config
     * @param eventName the event to bind to (defaults to "keydown")
     */
    public KeyMap(Element el, KeyMapConfig config, String eventName) {
        jsObj = create(el, config.getJsObj(), eventName);
    }

    private static native JavaScriptObject create(Element el, JavaScriptObject config, String eventName) /*-{
        return new  $wnd.Ext.KeyMap(el, config, eventName);
    }-*/;

    private static native JavaScriptObject create(String id, JavaScriptObject config, String eventName) /*-{
        return new  $wnd.Ext.KeyMap(id, config, eventName);
    }-*/;

    private static KeyMap instance(JavaScriptObject jsObj) {
        return new KeyMap(jsObj);
    }

    /**
     * Add a new binding to this KeyMap.
     *
     * @param config new binding config
     */
    public native void addBinding(KeyMapConfig config) /*-{
        var km = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var configJS = this.@com.gwtext.client.core.JsObject::getJsObj()();
        km.addBinding(configJS);
    }-*/;

    /**
     * Disable this KeyMap.
     */
    public native void disable() /*-{
        var km = this.@com.gwtext.client.core.JsObject::getJsObj()();
        km.disable();
    }-*/;

    /**
     * Enable this KeyMap,
     */
    public native void enable() /*-{
        var km = this.@com.gwtext.client.core.JsObject::getJsObj()();
        km.enable();
    }-*/;

    /**
     * Returns true if this KeyMap is enabled.
     *
     * @return true if enabled
     */
    public native boolean isEnabled() /*-{
        var km = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return km.isEnabled();
    }-*/;

    /**
     * True to stop the event from bubbling and prevent the default browser action if the key was handled by the KeyMap
     * (defaults to false).
     *
     * @param stopEvent true to stop event bubbling
     */
    public native void setStopEvent(boolean stopEvent) /*-{
        var km = this.@com.gwtext.client.core.JsObject::getJsObj()();
        km.stopEvent = stopEvent;
    }-*/;
}
