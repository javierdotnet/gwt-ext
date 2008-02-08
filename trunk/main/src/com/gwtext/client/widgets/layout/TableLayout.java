/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class TableLayout extends ContainerLayout {
    private int columns;

    public TableLayout() {
    }

    public TableLayout(int columns) {
        this.columns = columns;
        setColumns(columns);
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
        JavaScriptObjectHelper.setAttribute(configJS, "columns", columns);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.layout.TableLayout(config);
    }-*/;
}