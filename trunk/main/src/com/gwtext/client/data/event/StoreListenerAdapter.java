/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data.event;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;

/**
 * Store listener adapter.
 */
public class StoreListenerAdapter implements StoreListener {

    public void onAdd(Store store, Record[] records, int index) {
    }

    public boolean doBeforeLoad(Store store) {
        return true;
    }

    public void onClear(Store store) {
    }

    public void onDataChanged(Store store) {
    }

    public void onLoad(Store store, Record[] records) {
    }

    public void onRemove(Store store, Record record, int index) {
    }

    public void onUpdate(Store store, Record record, Record.Operation operation) {
    }

    //temporarily here so that users can update thier old code
    final public void onUpdate(Store store, Record record, String operation) {
    }

    public void onLoadException(Throwable error) {
        GWT.log("An error was encountered loading the store", error);
    }
}
