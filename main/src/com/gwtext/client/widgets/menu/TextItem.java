/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.menu.event.BaseItemListener;

/**
 * Adds a static text string to a menu, usually used as either a heading or group separator.
 */
public class TextItem extends BaseItem {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        var c = new $wnd.Ext.menu.TextItem();
        @com.gwtext.client.widgets.menu.TextItem::configPrototype = c.initialConfig;
    }-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}

    public TextItem() {
    }

    /**
     * Create a new TextItem.
     *
     * @param text the text. can pass html like <b class="menu-title">Choose a Theme</b> for custom styling
     */
    public TextItem(String text) {
       setText(text);
    }

    /**
     * Create a new TextItem.
     *
     * @param text the text. can pass html like <b class="menu-title">Choose a Theme</b> for custom styling
     * @param listener the listener
     */
    public TextItem(String text, BaseItemListener listener) {
        setText(text);
        addListener(listener);
    }

	public TextItem(JavaScriptObject jsObj) {
		super(jsObj);
	}

	protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.menu.TextItem(config['text'] ||'');
    }-*/;

	// --- config properties ---
	/**
	 * Sets the text.
	 *
	 * @param text the text
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
	 */
	public void setText(String text) throws IllegalStateException {
		setAttribute("text", text, true);
	}

	/**
	 * Return the items text.
	 *
	 * @return the item text
	 */
	public String getText() {
		return getAttribute("text");
	}

	/**
     * The default CSS class to use for text items (defaults to "x-menu-text").
     *
     * @param itemCls the item CSS class
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setItemCls(String itemCls) throws IllegalStateException {
        setAttribute("itemCls", itemCls, true);
    }

    /**
     * The default CSS class to use for text items (defaults to "x-menu-text").
     *
     * @return the default CSS class to use for text items
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered 
     */
    public String getItemCls() throws IllegalStateException {
        return JavaScriptObjectHelper.getAttribute(config, "itemCls");
    }

}
