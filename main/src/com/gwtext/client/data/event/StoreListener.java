/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
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
     * @param store this
     * @param records the records added
     * @param index the index at which the record(s) were added
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
     *  Fires when the data cache has changed, and a widget which is using this Store as a Record cache should refresh its view.
     * 
     * @param store this
     */
    void onDataChanged(Store store);

    //todo : currently removed second "options" arg
    /**
     * Fires after a new set of Records has been loaded.
     *
     * @param store this
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
     * @param store this
     * @param record the Record that was removed
     * @param index the index at which the record was removed
     */
    void onRemove(Store store, Record record, int index);

    //todo enum operatiion is Ext.data.Record.EDIT, operation is Ext.data.Record.REJECT or operatiion is Ext.data.Record.COMMIT
    /**
     *  Fires when a Record has been updated.
     * 
     * @param store this
     * @param record the Record that was updated
     * @param operation the update operation being performed
     * @see com.gwtext.client.data.Record#EDIT
     * @see com.gwtext.client.data.Record#REJECT
     * @see com.gwtext.client.data.Record#COMMIT
     */
    void onUpdate(Store store, Record record, Record.Operation operation);
}
