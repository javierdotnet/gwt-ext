package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;

public class CheckboxSelectionModel extends RowSelectionModel {

    public CheckboxSelectionModel() {
        jsObj = create();
    }

    protected native JavaScriptObject create() /*-{
        return new $wnd.Ext.grid.CheckboxSelectionModel();
    }-*/;
}
