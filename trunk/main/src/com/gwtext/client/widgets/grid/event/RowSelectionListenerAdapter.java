/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid.event;

import com.gwtext.client.widgets.grid.RowSelectionModel;
import com.gwtext.client.data.Record;

public class RowSelectionListenerAdapter implements RowSelectionListener {

    public boolean doBeforeRowSelect(RowSelectionModel sm, int rowIndex, boolean keepExisting, Record record) {
        return true;
    }

    public void onRowDeselect(RowSelectionModel sm, int rowIndex, Record record) {
    }

    public void onRowSelect(RowSelectionModel sm, int rowIndex, Record record) {
    }

    public void onSelectionChange(RowSelectionModel sm) {
    }
}
