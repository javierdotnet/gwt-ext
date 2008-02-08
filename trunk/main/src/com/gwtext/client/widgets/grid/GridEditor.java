/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.widgets.form.Field;

/**
 * Field Editor for a Grid column.
 *
 * @see com.gwtext.client.widgets.grid.ColumnConfig#setEditor(GridEditor)
 * @see com.gwtext.client.widgets.grid.ColumnModel#setEditor(String, GridEditor)
 */
public class GridEditor extends JsObject {

    /**
     * Creates a new Grid Editor field.
     *
     * @param field the field
     */
    public GridEditor(Field field) {
        jsObj = create(field.getOrCreateJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject field) /*-{
        return new $wnd.Ext.grid.GridEditor(field);
    }-*/;
}
