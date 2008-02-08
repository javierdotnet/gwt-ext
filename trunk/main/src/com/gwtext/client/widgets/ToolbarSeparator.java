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
 * Toolbar separator class.
 */
public class ToolbarSeparator extends ToolbarItem {

    public ToolbarSeparator(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new separator.
     */
    public ToolbarSeparator() {
        setJsObj(create());
    }

    private native JavaScriptObject create() /*-{
        return new $wnd.Ext.Toolbar.Separator();
    }-*/;
}
