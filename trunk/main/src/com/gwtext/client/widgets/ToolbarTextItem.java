/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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