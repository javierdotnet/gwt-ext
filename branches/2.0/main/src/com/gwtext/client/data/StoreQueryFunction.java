/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.data;

/**
 * Store query function.
 *
 * @see com.gwtext.client.data.Store#queryBy(StoreQueryFunction)
 */
public interface StoreQueryFunction {

    /**
     * Callback function invoked by {@link com.gwtext.client.data.Store#queryBy(StoreQueryFunction)}.
     * Return true if the record matches.
     *
     * @param record the record to test
     * @param id     the record ID
     * @return true to include Record in result
     * @see com.gwtext.client.data.Store#queryBy(StoreQueryFunction)
     */
    public boolean test(Record record, String id);
}
