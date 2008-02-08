/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.data;

/**
 * Exception raised when loading data into a Store.
 *
 * @see com.gwtext.client.data.event.StoreListener#onLoadException(Throwable)
 */
public class StoreLoadException extends Exception {

    public StoreLoadException(String message) {
        super(message);
    }
}
