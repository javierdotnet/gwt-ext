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
 

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * MenuItem class. This is useful for creating sumbmenu by adding a
 * MenuItem to the main Menu.
 *
 * @author Sanjiv Jivan
 * @see Menu#addItem(BaseItem)
 */
public class MenuItem extends BaseItem {

  private static JavaScriptObject configPrototype;
    private Menu menu;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.menu.Item();
        @com.gwtext.client.widgets.menu.MenuItem::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

    /**
     * Create a new MenuItem
     */
    public MenuItem() {
    }

    /**
     * Create a new MenuItem.
     *
     * @param text the menu text
     * @param submenu the submenu
     */
    public MenuItem(String text, Menu submenu) {
        setText(text);
        setMenu(submenu);
    }

	public MenuItem(JavaScriptObject jsObj) {
		super(jsObj);
	}

	protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.menu.Item(config);
    }-*/;

    // --- config options ---

    /**
     * Set the icon CSS class.
     *
     * @param iconCls the icon class
     */
    public void setIconCls(String iconCls) {
        JavaScriptObjectHelper.setAttribute(config, "iconCls", iconCls);
    }

    /**
     * @return the icon CSS class
     */
    public String getIconCls() {
        return JavaScriptObjectHelper.getAttribute(config, "iconCls");
    }

    /**
     * Set the text of the menu.
     *
     * @param text the menu text
     */
    public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(config, "text", text);
    }

    /**
     * Return the menu text.
     *
     * @return the menu text
     */
    public String getText() {
        return JavaScriptObjectHelper.getAttribute(config, "text");
    }

    /**
     * Set the sub-menu.
     *
     * @param menu the sub menu
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
        JavaScriptObjectHelper.setAttribute(config, "menu", menu.getOrCreateJsObj());
    }

    /**
     * Return the sub menu.
     *
     * @return the sub menu
     */
    public Menu getMenu() {
        return menu;
    }
}
