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
 

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.event.ButtonListener;
import com.gwtext.client.widgets.event.SplitButtonListener;
import com.gwtext.client.widgets.menu.Menu;

/**
 * A menu button that renders into a toolbar. Also known as ToolbarSplitButton.
 *
 * @author Sanjiv Jivan
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
    public ToolbarMenuButton(String text, Menu menu, ButtonListener listener) {
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
