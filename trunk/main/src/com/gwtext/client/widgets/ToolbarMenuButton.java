/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.event.SplitButtonListener;
import com.gwtext.client.widgets.menu.Menu;

/**
 * A menu button that renders into a toolbar. Also known as ToolbarSplitButton.
 */
public class ToolbarMenuButton extends SplitButton {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.Toolbar.SplitButton();
        @com.gwtext.client.widgets.ToolbarMenuButton::configPrototype = c.initialConfig;
    }-*/;


    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "tbsplit";
    }

    /**
     * Create a new ToolbarMenuButton.
     */
    public ToolbarMenuButton() {
    }

    /**
     * Create a new ToolbarMenuButton.
     *
     * @param text the button text
     */
    public ToolbarMenuButton(String text) {
        super(text);
    }

    /**
     * Create a new ToolbarMenuButton.
     *
     * @param text     the button text
     * @param listener the button listner
     */
    public ToolbarMenuButton(String text, SplitButtonListener listener) {
        super(text, listener);
    }

    /**
     * Create a new ToolbarMenuButton.
     *
     * @param text the button text
     * @param menu the button menu
     */
    public ToolbarMenuButton(String text, Menu menu) {
        if (text != null) setText(text);
        setMenu(menu);
    }

    /**
     * Create a new ToolbarMenuButton.
     *
     * @param text the button text
     * @param menu the button menu
     * @param listener the button listener
     */
    public ToolbarMenuButton(String text, Menu menu, SplitButtonListener listener) {
        if (text != null) setText(text);
        setMenu(menu);
        addListener(listener);
    }

    public ToolbarMenuButton(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Toolbar.SplitButton(config);
    }-*/;
}
