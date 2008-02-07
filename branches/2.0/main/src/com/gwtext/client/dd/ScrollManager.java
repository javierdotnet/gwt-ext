/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.dd;

import com.google.gwt.user.client.Element;

/**
 * Provides automatic scrolling of overflow regions in the page during drag operations.
 */
public class ScrollManager {

    /**
     * Manually trigger a cache refresh.
     */
    public static native void refreshCache()/*-{
        $wnd.Ext.dd.ScrollManager.refreshCache();
    }-*/;

    /**
     * Registers a new overflow element to auto scroll.
     *
     * @param elementID the element ID 
     */
    public static native void register(String elementID)/*-{
        $wnd.Ext.dd.ScrollManager.register(elementID);
    }-*/;

    /**
     * Registers a new overflow element to auto scroll.
     *
     * @param element the element
     */
    public static native void register(Element element)/*-{
        $wnd.Ext.dd.ScrollManager.register(element);    
    }-*/;

    /**
     * Unregisters an overflow element so it are no longer scrolled.
     *
     * @param elementID the lement ID
     */
    public static native void unregister(String elementID)/*-{
        $wnd.Ext.dd.ScrollManager.unregister(elementID);
    }-*/;

    /**
     * Unregisters an overflow element so it are no longer scrolled.
     *
     * @param element the element
     */
    public static native void unregister(Element element)/*-{
        $wnd.Ext.dd.ScrollManager.unregister(element);    
    }-*/;

}
