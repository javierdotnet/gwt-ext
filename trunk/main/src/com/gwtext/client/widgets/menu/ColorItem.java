/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.ColorPalette;

/**
 * A menu item that wraps the {@link ColorPalette} component.
 *
 */
public class ColorItem extends Item {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.menu.ColorItem();
        @com.gwtext.client.widgets.menu.ColorItem::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

    /**
     * Create a new ColorItem.
     */
    public ColorItem() {
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.menu.ColorItem(config);    
    }-*/;

    /**
     * Return the CollorPalette associated with the menu item.
     *
     * @return the ColorPalette
     */
    public native ColorPalette getPalette() /*-{
        var ci = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return @com.gwtext.client.widgets.ColorPalette::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ci.palette);
    }-*/;
}