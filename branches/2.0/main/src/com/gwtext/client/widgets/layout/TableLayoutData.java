/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.layout;

import com.gwtext.client.util.JavaScriptObjectHelper;

public class TableLayoutData extends LayoutData {

    public TableLayoutData() {
    }

    public TableLayoutData(int colspan) {
        setColspan(colspan);
    }

    public void setColspan(int colspan) {
        JavaScriptObjectHelper.setAttribute(jsObj, "colspan", colspan);
    }

    public void setRowspan(int rowspan) {
        JavaScriptObjectHelper.setAttribute(jsObj, "rowspan", rowspan);
    }
}