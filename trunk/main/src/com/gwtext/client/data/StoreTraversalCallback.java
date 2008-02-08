/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data;

/**
 * Store traversal callback.
 *
 * @see com.gwtext.client.data.Store#each(StoreTraversalCallback)
 * @see com.gwtext.client.data.Store#filterBy(StoreTraversalCallback)
 */
public interface StoreTraversalCallback {

    /**
     * The callback method.
     *
     * @param record the record being traversed
     * @return boolean value
     */
    boolean execute(Record record);
}
