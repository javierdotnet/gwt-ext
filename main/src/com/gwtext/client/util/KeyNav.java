/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;

/**
 * Provides a convenient wrapper for normalized keyboard navigation. KeyNav allows you to bind navigation keys to function
 * calls that will get called when the keys are pressed, providing an easy way to implement custom navigation schemes for any UI component.
 * <p/>
 * The following are all of the possible keys that can be implemented: enter, left, right, up, down, tab, esc, pageUp, pageDown, del, home, end.
 *
 * @see com.gwtext.client.util.KeyNavConfig
 */
public class KeyNav extends JsObject {

    public KeyNav(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Creates a new KeyNav isntance.
     *
     * @param id     the element ID
     * @param config the keynav configuration
     */
    public KeyNav(String id, KeyNavConfig config) {
        jsObj = create(id, config.getJsObj());
    }

    /**
     * Creates a new KeyNav isntance.
     *
     * @param el     the element
     * @param config the keynav configuration
     */
    public KeyNav(Element el, KeyNavConfig config) {
        jsObj = create(el, config.getJsObj());
    }

    private static native JavaScriptObject create(Element el, JavaScriptObject config) /*-{
        return new  $wnd.Ext.KeyNav(el, config);
    }-*/;

    private static native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new  $wnd.Ext.KeyNav(id, config);
    }-*/;

    /**
     * Disable the KeyNav.
     */
    public native void disable() /*-{
        var kn = this.@com.gwtext.client.core.JsObject::getJsObj()();
        kn.disable();
    }-*/;

    /**
     * Enable the KeyNav.
     */
    public native void enable() /*-{
        var kn = this.@com.gwtext.client.core.JsObject::getJsObj()();
        kn.enable();
    }-*/;
}