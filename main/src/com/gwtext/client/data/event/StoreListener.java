/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data.event;

import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;

/**
 * {@link Store} listener interface.
 */
public interface StoreListener {

    /**
     * Fires when Records have been added to the Store
     *
     * @param store   this
     * @param records the records added
     * @param index   the index at which the record(s) were added
     */
    void onAdd(Store store, Record[] records, int index);

    //todo : currently removed second "options" arg
    /**
     * Fires before a request is made for a new data object. If the beforeload handler returns false the load action will be canceled.
     *
     * @param store this
     * @return false to cancel the load action
     */
    boolean doBeforeLoad(Store store);

    /**
     * Fires when the data cache has been cleared.
     *
     * @param store this
     */
    void onClear(Store store);

    /**
     * Fires when the data cache has changed, and a widget which is using this Store as a Record cache should refresh its view.
     *
     * @param store this
     */
    void onDataChanged(Store store);

    //todo : currently removed second "options" arg
    /**
     * Fires after a new set of Records has been loaded.
     *
     * @param store   this
     * @param records the Records that were loaded
     */
    void onLoad(Store store, Record[] records);

    /**
     * Fires if an exception occurs in the Proxy during loading. When using HttpProxy,
     * {@link com.gwtext.client.data.HttpStoreLoadException} is raised if an exception occurs.
     *
     * @param error the error
     */
    void onLoadException(Throwable error);

    //todo json meta
    //void onMetaChange(Store store, String meta);

    /**
     * Fires when a Record has been removed from the Store.
     *
     * @param store  this
     * @param record the Record that was removed
     * @param index  the index at which the record was removed
     */
    void onRemove(Store store, Record record, int index);

    /**
     * Fires when a Record has been updated.
     *
     * @param store     this
     * @param record    the Record that was updated
     * @param operation the update operation being performed
     * @see com.gwtext.client.data.Record#EDIT
     * @see com.gwtext.client.data.Record#REJECT
     * @see com.gwtext.client.data.Record#COMMIT
     */
    void onUpdate(Store store, Record record, Record.Operation operation);
}
