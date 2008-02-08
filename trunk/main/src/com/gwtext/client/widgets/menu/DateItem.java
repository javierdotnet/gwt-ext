/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.DatePicker;

/**
 * A menu item that wraps the {@link DatePicker} component.
 */
public class DateItem extends Item {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.menu.DateItem();
        @com.gwtext.client.widgets.menu.DateItem::configPrototype = c.initialConfig;
    }-*/;


    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    /**
     * Create a new DateItem.
     */
    public DateItem() {
    }


    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.menu.DateItem(config);
    }-*/;

    /**
     * The {@link DatePicker} object.
     *
     * @return the DatePicker object
     */
    public native DatePicker getPicker()/*-{
        var di = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return @com.gwtext.client.widgets.DatePicker::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(di.picker);
    }-*/;
}      
