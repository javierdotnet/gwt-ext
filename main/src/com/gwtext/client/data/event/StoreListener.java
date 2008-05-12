/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.data.event;

import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;

/**
 * {@link Store} listener interface.
 *
 * @author Sanjiv Jivan
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
