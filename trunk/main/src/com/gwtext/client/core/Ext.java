/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.core;

import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.Component;

/**
 * Ext core utilities and functions.
 */
public class Ext {

    /**
     * URL to a blank file used by Ext when in secure mode for iframe src and onReady src to prevent the IE insecure content
     * warning (defaults to javascript:false).
     *
     * @param url the url
     */
    public static native void setSslSecureUrl(String url)/*-{
        $wnd.Ext.SSL_SECURE_URL = url;
    }-*/;

    /**
     * True to automatically uncache orphaned Ext.Elements periodically (defaults to true).
     *
     * @param enableGarbageCollector true to enable GC
     */
    public static native void setEnableGarbageCollector(boolean enableGarbageCollector)/*-{
        $wnd.Ext.enableGarbageCollector = enableGarbageCollector;
    }-*/;

    /**
     * Returns is Garbage Collector is enabled.
     *
     * @return true if GC enabled
     */
    public static native boolean isEnableGarbageCollector()/*-{
        return $wnd.Ext.enableGarbageCollector;
    }-*/;

    /**
     * True to automatically purge event listeners after uncaching an element (defaults to false). Note: this only happens if enableGarbageCollector is true.
     *
     * @param enableListenerCollection true to enable listener collection
     */
    public static native void setEnableListenerCollection(boolean enableListenerCollection)/*-{
        $wnd.Ext.enableListenerCollection = enableListenerCollection;
    }-*/;

    /**
     * Retruns true if listener collection is true.
     *
     * @return true if listener collection is enabled
     */
    public static native boolean isEnableListenerCollection()/*-{
        return $wnd.Ext.enableListenerCollection;
    }-*/;

    /**
     * @return true if bodex box
     */
    public static native boolean isBorderBox()/*-{
        return $wnd.Ext.isBorderBox;
    }-*/;

    /**
     * @return true if Gecko broswer
     */
    public static native boolean isGecko()/*-{
        return $wnd.Ext.isGecko;
    }-*/;

    /**
     * @return true if IE
     */
    public static native boolean isIE()/*-{
        return $wnd.Ext.isIE;
    }-*/;

    /**
     * @return true if IE6
     */
    public static native boolean isIE6()/*-{
        return $wnd.Ext.isIE6;
    }-*/;

    /**
     * @return true if IE7
     */
    public static native boolean isIE7()/*-{
        return $wnd.Ext.isIE7;
    }-*/;

    /**
     * @return true if Linux OS
     */
    public static native boolean isLinux()/*-{
        return $wnd.Ext.isLinux;
    }-*/;

    /**
     * @return true if Mac
     */
    public static native boolean isMac()/*-{
        return $wnd.Ext.isMac;
    }-*/;

    /**
     * @return true if running under Adobe AIR
     */
    public static native boolean isAir()/*-{
        return $wnd.Ext.isAir;
    }-*/;

    /**
     * @return true if Opera
     */
    public static native boolean isOpera()/*-{
        return $wnd.Ext.isOpera;
    }-*/;

    /**
     * @return true when the document is fully initialized and ready for action
     */
    public static native boolean isReady()/*-{
        return $wnd.Ext.isReady;
    }-*/;

    /**
     * @return true if Safari
     */
    public static native boolean isSafari()/*-{
        return $wnd.Ext.isSafari;
    }-*/;

    /**
     * @return true if the page is running over SSL
     */
    public static native boolean isSecure()/*-{
        return $wnd.Ext.isSecure;
    }-*/;

    /**
     * @return true if the browser is in strict mode
     */
    public static native boolean isStrict()/*-{
        return $wnd.Ext.isStrict;
    }-*/;

    /**
     * @return true if Windows OS
     */
    public static native boolean isWindows()/*-{
        return $wnd.Ext.isWindows;
    }-*/;


    /**
     * By default, Ext intelligently decides whether floating elements should be shimmed. If you are using flash, you
     * may want to set this to true.
     *
     * @param useShims true to use shims
     */
    public static native void setUseShims(boolean useShims)/*-{
        $wnd.Ext.useShims = useShims;
    }-*/;

    /**
     * @return true if use shims.
     */
    public static native boolean isUseShims()/*-{
        return $wnd.Ext.useShims;
    }-*/;

    /**
     * Escapes the passed string for use in a regular expression.
     *
     * @param str the String to escape
     * @return escaped String
     */
    public static native String escapeRe(String str)/*-{
        return $wnd.Ext.escapeRe(str);
    }-*/;

    //made package protected. Users don't need to call this anymore since it is handled internally on
    //applicaiotn startup.
    native static void setBlankImageUrl(String url) /*-{
        $wnd.Ext.BLANK_IMAGE_URL = url;    
    }-*/;

    /**
     * Method to retrieve Element objects. Uses simple caching to consistently return the same object. Automatically fixes if an object was recreated with the same id via AJAX or DOM.
     *
     * @param id element ID
     * @return the element
     */
    public static native ExtElement get(String id) /*-{
        var el = $wnd.Ext.get(id);
        return el == null || el === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Method to retrieve Element objects. Uses simple caching to consistently return the same object. Automatically fixes if an object was recreated with the same id via AJAX or DOM.
     *
     * @param element the element
     * @return the element
     */
    public static native ExtElement get(Element element) /*-{
        var el = $wnd.Ext.get(element);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Attempts to destroy the objects by removing all event listeners, removing them from the DOM (if applicable) and calling their destroy functions (if available).
     *
     * @param element the element to destroy
     */
    public static native void destroy(ExtElement element) /*-{
        var el = element.@com.gwtext.client.core.JsObject::jsObj;
        $wnd.Ext.destroy(el);
    }-*/;

    /**
     * Attempts to destroy the component passed to it by removing all event listeners, removing them from the DOM (if applicable) and calling their destroy functions (if available).
     *
     * @param component the component to destroy
     */
    public static native void destroy(Component component) /*-{
        var comp = component.@com.gwtext.client.widgets.Component::getJsObj()();
        $wnd.Ext.destroy(comp);
    }-*/;

    /**
     * Returns the current HTML document object as an {@link ExtElement}.
     *
     * @return the document
     */
    public static native ExtElement getDoc() /*-{
        var el = $wnd.Ext.getDoc();
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns the current document body as an{@link ExtElement}.
     *
     * @return the document body
     */
    public static native ExtElement getBody() /*-{
        var el = $wnd.Ext.getBody();
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as the active element. Do not store a reference
     * to this element - the dom node can be overwritten by other code.
     *
     * @param id the element ID
     * @return the ExtElement
     */
    public static native ExtElement fly(String id) /*-{
        var el = $wnd.Ext.fly(id);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as the active element. Do not store a reference
     * to this element - the dom node can be overwritten by other code.
     *
     * @param id    the element ID
     * @param named allows for creation of named reusable flyweights to prevent conflicts (e.g. internally Ext uses "_internal")
     * @return the ExtElement
     */
    public static native ExtElement fly(String id, String named) /*-{
        var el = $wnd.Ext.fly(id, named);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as the active element. Do not store a reference
     * to this element - the dom node can be overwritten by other code.
     *
     * @param element the element
     * @return the ExtElement
     */
    public static native ExtElement fly(Element element) /*-{
        var el = $wnd.Ext.fly(element);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as the active element. Do not store a reference
     * to this element - the dom node can be overwritten by other code.
     *
     * @param element the element
     * @param named   allows for creation of named reusable flyweights to prevent conflicts (e.g. internally Ext uses "_internal")
     * @return the ExtElement
     */
    public static native ExtElement fly(Element element, String named) /*-{
        var el = $wnd.Ext.fly(element, named);
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Generates unique ids.
     *
     * @return a unique ID
     */
    public static native String generateId()/*-{
        return $wnd.Ext.id();
    }-*/;

    /**
     * Generates unique ids.
     *
     * @param prefix Id prefix (defaults "ext-gen")
     * @return a unique ID
     */
    public static native String generateId(String prefix)/*-{
        return $wnd.Ext.id(null, prefix);
    }-*/;

    /**
     * Fires when the document is ready (before onload and before images are loaded).
     * Can alternatively use the GWT entry point mechanism.
     *
     * @param cb callback to execute
     */
    public static native void onReady(Function cb) /*-{
        $wnd.Ext.onReady(function() {
                cb.@com.gwtext.client.core.Function::execute()();
            });
    }-*/;

	/**
	 * Utility method to kick up Javascript debugger. Userful during development / troubleshooting where it is desired to step through
	 * Javascript code.
	 */
	public static native void debugger()/*-{
        debugger;
    }-*/;
}
