/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu;

/**
 * Provides a common registry of all menu items on a page.
 */
public class MenuMgr {

    private MenuMgr() {
    }

    /**
     * Hides all menus that are currently visible.
     */
    public static native void hideAll()/*-{
        $wnd.Ext.menu.MenuMgr.hideAll();
    }-*/;
}
