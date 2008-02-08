/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;

public class QuickTip extends ToolTip {

    public QuickTip() {
    }

    public QuickTip(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
		return new $wnd.Ext.QuickTip(config);
    }-*/;

    public void setInterceptTitles(boolean interceptTitles) {
        setAttribute("interceptTitles", interceptTitles, true);
    }

}
