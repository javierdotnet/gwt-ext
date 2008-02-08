/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.data;

/**
 * Manager class that allows retreival of Stores by ID.
 */
public class StoreMgr {

    private StoreMgr() {
    }

    /**
     * Gets a registered Store by id.
     *
     * @param storeID the Store ID
     * @return the Store or null if not found
     */
    public static native Store lookup(String storeID) /*-{
        var store = $wnd.Ext.StoreMgr.lookup(storeID);
        if(store == null || store === undefined) {
            return null;
        }
        return @com.gwtext.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
    }-*/;
}
