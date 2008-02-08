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

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * A simple class that renders text directly into a toolbar.
 */
public class ToolbarTextItem extends ToolbarItem {

    /**
     * Create a new ToolbarTextItem
     *
     * @param text the text
     */
    public ToolbarTextItem(String text) {
        setJsObj(create(text));
    }

    private native JavaScriptObject create(String text) /*-{
        return new $wnd.Ext.Toolbar.TextItem(text);
    }-*/;

    /**
     * Return the text.
     *
     * @return the text
     */
    public native String getText()/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return tbi.el.innerHTML;
    }-*/;

    /**
     * Sets the toolbar item text
     *
     * @param text the text to set
     */
    public native void setText(String text)/*-{
        var tbi = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        tbi.el.innerHTML = text;
    }-*/;     
}