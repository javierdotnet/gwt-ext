package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;

public class RowNumberingColumnConfig extends BaseColumnConfig {

    public RowNumberingColumnConfig() {
        jsObj = create();
    }

    protected native JavaScriptObject create() /*-{
        return new $wnd.Ext.grid.RowNumberer();
    }-*/;
}
