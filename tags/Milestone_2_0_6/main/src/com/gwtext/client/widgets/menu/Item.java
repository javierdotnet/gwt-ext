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
import com.gwtext.client.widgets.menu.event.BaseItemListener;

/**
 * A base class for all menu items that require menu-related functionality (like sub-menus) and are not static display
 * items. Item extends the base functionality of {@link BaseItem} by adding menu-specific activation and click handling.
 *
 * @author Sanjiv Jivan
 */
public class Item extends BaseItem {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
        $wnd.Ext.reg('menu-item', $wnd.Ext.menu.Item);
        var c = new $wnd.Ext.menu.Item();
        @com.gwtext.client.widgets.menu.Item::configPrototype = c.initialConfig;
    }-*/;


    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "menu-tem";
    }

    public Item() {
    }

    public Item(String text) {
        if (text != null) setText(text);
    }

    public Item(String text, BaseItemListener listener) {
        if (text != null) setText(text);
        addListener(listener);
    }

    public Item(String text, BaseItemListener listener, String icon) {
        if (text != null) setText(text);
        addListener(listener);
        setIcon(icon);
    }

    public Item(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.menu.Item(config);
    }-*/;


    /**
     * The text of the check item.
     *
     * @param text the text
     */
    public void setText(String text) {
        if (!isRendered()) {
            setAttribute("text", text, true);
        } else {
            setTextRendered(text);
        }
    }


    /**
     * Sets the text of the item.
     *
     * @param text the item text
     */
    private native void setTextRendered(String text) /*-{
        var item = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        item.setText(text);
    }-*/;

    /**
     * Retrun the text of the item.
     *
     * @return the item text
     */
    public String getText() {
        if(!isRendered()) {
            return JavaScriptObjectHelper.getAttribute(config, "text");
        } else {
            return getTextRendered();
        }
    }

    /**
     * Return the item text.
     *
     * @return the item text
     */
    private native String getTextRendered() /*-{
        var item = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return item.text;
    }-*/;


    public void setIconCls(String iconCls) {
        if(!isRendered()) {
            setAttribute("iconCls", iconCls, true);
        } else {
            setIconClsRendered(iconCls);
        }

    }

    private native void setIconClsRendered(String iconCls) /*-{
        var item = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        item.setIconClass(iconCls);
    }-*/;

    /**
     * @return the icon CSS class
     */
    public String getIconCls() {
        if(!isRendered()) {
            return JavaScriptObjectHelper.getAttribute(config, "iconCls");
        } else {
            return JavaScriptObjectHelper.getAttribute(getJsObj(), "iconCls");
        }
    }    

    // -- config properties ---

    /**
     * The href attribute to use for the underlying anchor link (defaults to '#').
     *
     * @param href the href attribute
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHref(String href) throws IllegalStateException {
        JavaScriptObjectHelper.setAttribute(config, "href", href);
    }

    /**
     * The href attribute to use for the underlying anchor link (defaults to '#').
     *
     * @return the href attribute
     *
     */
    public String getHref() {
        return JavaScriptObjectHelper.getAttribute(config, "href");
    }

    /**
     * The target attribute to use for the underlying anchor link (defaults to '').
     *
     * @param hrefTarget the href target
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setHrefTarget(String hrefTarget) throws IllegalStateException {
        JavaScriptObjectHelper.setAttribute(config, "hrefTarget", hrefTarget);
    }

    /**
     * The target attribute to use for the underlying anchor link (defaults to '').
     *
     * @return the href target
     */
    public String getHrefTarget()  {
        return JavaScriptObjectHelper.getAttribute(config, "hrefTarget");
    }

    /**
     * The item's icon.
     *
     * @param icon the icon
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setIcon(String icon) throws IllegalStateException {
        JavaScriptObjectHelper.setAttribute(config, "icon", icon);
    }

    /**
     * The default CSS class to use for menu items (defaults to 'x-menu-item')
     *
     * @param itemCls the CSS clas
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setItemCls(String itemCls) throws IllegalStateException {
        JavaScriptObjectHelper.setAttribute(config, "itemCls", itemCls);
    }

    /**
     * The default CSS class to use for menu items.
     * 
     * @return the default CSS class to use for menu items
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public String getItemCls() throws IllegalStateException {
        return JavaScriptObjectHelper.getAttribute(config, "itemCls");
    }
}
