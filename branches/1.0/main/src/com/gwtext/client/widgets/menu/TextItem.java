/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Adds a static text string to a menu, usually used as either a heading or group separator.
 */
public class TextItem extends Item {

    /**
     * Create a new TextItem.
     *
     * @param text the text. can pass html like <b class="menu-title">Choose a Theme</b> for custom styling
     */
    public TextItem(String text) {
        setJsObj(create(text, null));
    }

    /**
     * Create a new TextItem.
     *
     * @param text the text. can pass html like <b class="menu-title">Choose a Theme</b> for custom styling
     * @param config the config object
     */
    public TextItem(String text, TextItemConfig config) {
        setJsObj(create(text, config.getJsObj()));
    }

    private native JavaScriptObject create(String text, JavaScriptObject config) /*-{
        return new $wnd.Ext.menu.TextItem(text);
    }-*/;

    /**
     * Return the Item text.
     *
     * @return the text
     */
    public native String getText()/*-{
        var ti = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return ti.el.innerHTML;
    }-*/;

    /**
     * Sets the text.
     *
     * @param text the text
     */
    public native void setText(String text)/*-{
        var ti = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        ti.el.innerHTML = text;
    }-*/;
}
