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
 * Toolbar spacer class.
 */
public class ToolbarSpacer extends ToolbarItem {

    /**
     * Create a new Spacer.
     */
    public ToolbarSpacer() {
        setJsObj(create());
    }

    private native JavaScriptObject create() /*-{
        return new $wnd.Ext.Toolbar.Spacer();
    }-*/;
}