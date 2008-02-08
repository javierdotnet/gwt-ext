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
 * A simple element that adds a greedy (100% width) horizontal space to a toolbar.
 */
public class ToolbarFill extends ToolbarItem {

    /**
     * Create a new Toolbar Fill.
     */
    public ToolbarFill() {
        setJsObj(create());
    }

    private native JavaScriptObject create() /*-{
        return new $wnd.Ext.Toolbar.Fill();
    }-*/;
}