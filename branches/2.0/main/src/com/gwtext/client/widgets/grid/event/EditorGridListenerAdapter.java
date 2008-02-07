/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.grid.GridPanel;

public class EditorGridListenerAdapter implements EditorGridListener {

    public void onAfterEdit(GridPanel grid, Record record, String field, Object newValue, Object oldValue, int rowIndex, int colIndex) {
    }

    public boolean doBeforeEdit(GridPanel grid, Record record, String field, Object value, int rowIndex, int colIndex) {
        return true;
    }

    public boolean doValidateEdit(GridPanel grid, Record record, String field, Object value, Object originalValue, int rowIndex, int colIndex) {
        return true;
    }
}
