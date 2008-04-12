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

/**
 * Provides attractive and customizable tooltips for any element. The QuickTips singleton is used to configure and manage
 * tooltips globally for multiple elements in a generic manner. To create individual tooltips with maximum customizability,
 * you should consider either {@link Tip} or {@link ToolTip}.
 * <p/>
 * Quicktips can be configured via tag attributes directly in markup, or by registering quick tips programmatically via the register method.
 * <p/>
 * The singleton's instance of {@link QuickTip} is available via {@link QuickTips#getQuickTip}, and supports all the methods,
 * and all the all the configuration properties of {@link QuickTip}. These settings will apply to all tooltips shown by the
 * singleton.
 * <p/>
 * To register a quick tip in markup, you simply add one or more of the valid QuickTip attributes prefixed with the <b>ext:</b>
 * namespace. The HTML element itself is automatically set as the quick tip target. Here is the summary of supported attributes
 * (optional unless otherwise noted):
 * <ul>
 * <li>hide: Specifying "user" is equivalent to setting autoHide = false. Any other value will be the same as autoHide = true.</li>
 * <li>qclass: A CSS class to be applied to the quick tip (equivalent to the 'cls' target element config).</li>
 * <li>qtip (required): The quick tip text (equivalent to the 'text' target element config).</li>
 * <li>qtitle: The quick tip title (equivalent to the 'title' target element config).</li>
 * <li>qwidth: The quick tip width (equivalent to the 'width' target element config).</li>
 * </ul>
 * <p/>
 * <p/>
 * Here is an example of configuring an HTML element to display a tooltip from markup:
 * <pre>
 * <code>
 * // Add a quick tip to an HTML button
 * &lt;input type="button" value="OK" ext:qtitle="OK Button" ext:qwidth="100" ext:qtip="This is a quick tip from markup!"&gt;&lt;/input&gt;
 * </ode>
 * </pre>
 * <p/>
 */
public class QuickTips {
    /**
     * Disable this quick tip.
     */
    public static native void disable()/*-{
        $wnd.Ext.QuickTips.disable();
    }-*/;

    /**
     * Enable this quick tip.
     */
    public static native void enable()/*-{
        $wnd.Ext.QuickTips.enable();
    }-*/;

    /**
     * Gets the global QuickTips instance.
     *
     * @return the global QuickTips instance.
     */
    public static QuickTip getQuickTip() {
        return new QuickTip(doGetQuickTip());
    }

    private static native JavaScriptObject doGetQuickTip() /*-{
        return $wnd.Ext.QuickTips.getQuickTip();
    }-*/;

    /**
     * Initialize and enable QuickTips for first use. This should be called once before the first attempt to access or display QuickTips in a page.
     */
    public static native void init()/*-{
        $wnd.Ext.QuickTips.init();
    }-*/;

    /**
     * Returns true if the quick tip is enabled, else false.
     *
     * @return true if enabled
     */
    public static native boolean isEnabled()/*-{
        return $wnd.Ext.QuickTips.isEnabled();
    }-*/;

    /**
     * Configures a new quick tip instance and assigns it to a target element.
     *
     * @param id     target element id
     * @param config the config
     */
    public native void register(String id, QuickTipsConfig config) /*-{
        var configJS = config.@com.gwtext.client.core.JsObject::getJsObj()();
        configJS['target'] = id;
        $wnd.Ext.QuickTips.register(configJS);
     }-*/;

    /**
     * Configures a new quick tip instance and assigns it to a target element.
     * 
     * @param element the target element
     * @param config the quick tip config
     */
    public native void register(Element element, QuickTipsConfig config) /*-{
        var configJS = config.@com.gwtext.client.core.JsObject::getJsObj()();
        configJS['target'] = element;
        $wnd.Ext.QuickTips.register(configJS);
     }-*/;

    /**
     * Removes any registered quick tip from the target element and destroys it.
     *
     * @param elementID the element ID
     */
    public native void unregister(String elementID) /*-{
        $wnd.Ext.QuickTips.unregister(elementID);
    }-*/;

    /**
     * Removes any registered quick tip from the target element and destroys it.
     *
     * @param element the element
     */
    public native void unregister(Element element) /*-{
        $wnd.Ext.QuickTips.unregister(element);
    }-*/;



}
