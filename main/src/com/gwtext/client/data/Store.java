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

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.RegExp;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.event.StoreListener;
import com.gwtext.client.util.JavaScriptObjectHelper;

//todo baseParams, sortInfo in constructor

//todo fireRowsSorted missing?


public class Store extends JsObject {

    protected Store() {
    }

    public Store(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static Store instance(JavaScriptObject jsObj) {
        return new Store(jsObj);
    }

    //http://extjs.com/forum/showthread.php?t=3564&highlight=memoryproxy
    public Store(RecordDef recordDef) {
        JavaScriptObject params = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(params, "recordType", recordDef.getJsObj());
        jsObj = create(params);
    }

    public Store(Reader reader) {
        JavaScriptObject params = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(params, "reader", reader.getJsObj());
        jsObj = create(params);
    }

    public Store(DataProxy dataProxy, Reader reader) {
        this(dataProxy, reader, false);
    }

    public Store(DataProxy dataProxy, Reader reader, boolean remoteSort) {
        this(dataProxy, reader, null, null, remoteSort);
    }

    public Store(DataProxy dataProxy, Reader reader, UrlParam[] baseParams, SortState initialSortState, boolean remoteSort) {
        JavaScriptObject params = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(params, "proxy", dataProxy.getJsObj());
        JavaScriptObjectHelper.setAttribute(params, "reader", reader.getJsObj());

        setBaseParams(baseParams, params);
        if (initialSortState != null) {
            JavaScriptObject sortStateParamObj = JavaScriptObjectHelper.createObject();
            JavaScriptObjectHelper.setAttribute(sortStateParamObj, "field", initialSortState.getField());
            JavaScriptObjectHelper.setAttribute(sortStateParamObj, "direction", initialSortState.getDirection());
            JavaScriptObjectHelper.setAttribute(params, "sortInfo ", sortStateParamObj);
        }

        JavaScriptObjectHelper.setAttribute(params, "remoteSort", remoteSort);
        jsObj = create(params);
    }

    private void setBaseParams(UrlParam[] baseParams, JavaScriptObject params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(baseParams);
        JavaScriptObjectHelper.setAttribute(params, "baseParams", paramObj);
    }

    private static native JavaScriptObject create(JavaScriptObject params) /*-{
        return new $wnd.Ext.data.Store(params);        
    }-*/;

    public native void setBaseParams(UrlParam[] baseParams) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var baseParamsJS = @com.gwtext.client.core.NameValuePair::getJsObj([Lcom/gwtext/client/core/NameValuePair;)(baseParams);
        store.baseParams = baseParamsJS;
    }-*/;

    public UrlParam[] getBaseParams() {
        JavaScriptObject baseParamsNative = getBaseParams(jsObj);

        JavaScriptObject[] urlParamsJ = JavaScriptObjectHelper.toArray(baseParamsNative);
        UrlParam[] baseParams = new UrlParam[urlParamsJ.length];
        for (int i = 0; i < urlParamsJ.length; i++) {
            UrlParam urlParam = new UrlParam(urlParamsJ[i]);
            baseParams[i] = urlParam;
        }
        return baseParams;
    }

    private native JavaScriptObject getBaseParams(JavaScriptObject store) /*-{
        var params = new Array();
        var i = 0;
        var o = store.baseParams;
        for(var key in o){
            var ov = o[key];
            var param = @com.gwtext.client.core.UrlParam::instance(Ljava/lang/String;Ljava/lang/String;)(key, ov);
            params[i] = param.@com.gwtext.client.core.JsObject::jsObj;
            i++;
        }
        return params;
    }-*/;

    /**
     * Add a Record to the Store and fires the add event.
     *
     * @param record the Record to add
     */
    public native void add(Record record) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var recordJ = record.@com.gwtext.client.core.JsObject::jsObj;
		return store.add(recordJ);
    }-*/;

    /**
     * Add Records to the Store and fires the add event.
     *
     * @param records the Records to add
     */
    public void add(Record[] records) {
        JavaScriptObject[] recordsJS = new JavaScriptObject[records.length];
        for (int i = 0; i < records.length; i++) {
            Record record = records[i];
            recordsJS[i] = record.getJsObj();
        }
        JavaScriptObject nativeRecordsArray = JavaScriptObjectHelper.convertToJavaScriptArray(recordsJS);
        add(jsObj, nativeRecordsArray);
    }

    private native void add(JavaScriptObject store, JavaScriptObject nativeRecordsArray)/*-{
		store.add(nativeRecordsArray);
    }-*/;

    /**
     * Revert to a view of the Record cache / snapshot with no filtering applied.  A snapshot of the data is taken when {@link #filter(String, String)} is called.
     * Records added to the Store after filter is caleld will be lost if clearFilter is subsequently called.
     */
    public native void clearFilter() /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.clearFilter();
    }-*/;

    /**
     * Revert to a view of the Record cache with no filtering applied.
     *
     * @param suppressEvent if true the filter is cleared silently without notifying listeners
     */
    public native void clearFilter(boolean suppressEvent) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.clearFilter(suppressEvent);
    }-*/;

    /**
     * Commit all Records with outstanding changes. To handle updates for changes, subscribe to the Store's "update" event, 
     * and perform updating when the third parameter {@link Record#COMMIT}.
     */
    public native void commitChanges() /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.commitChanges();
    }-*/;

    /**
     * Calls the specified function for each of the Records in the cache.
     *
     * @param cb the Store traversal callback
     */
    public native void each(StoreTraversalCallback cb)/*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.each(function(r) {
            var rj = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            return cb.@com.gwtext.client.data.StoreTraversalCallback::execute(Lcom/gwtext/client/data/Record;)(rj);
        });
    }-*/;

    /**
     * Filter the records by a specified property using a Regular expression.
     *
     * @param field the filed to filter on
     * @param regexp the regular expression to test field value against
     */
    public native void filter(String field, RegExp regexp) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var re = regexp.@com.gwtext.client.core.JsObject::jsObj;
        store.filter(field, re);
	}-*/;

    /**
     * Filter the records by a specified property .
     *
     * @param field the filed to filter on
     * @param value a string that the field should start with
     */
    public native void filter(String field, String value) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.filter(field, value);
	}-*/;

    /**
     * Filter the records by a specified property .
     * 
     * @param field the filed to filter on
     * @param value a string that the field should start with
     * @param anyMatch true to match any part not just the beginning
     */
    public native void filter(String field, String value, boolean anyMatch) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.filter(field, value, anyMatch);
	}-*/;

    /**
     * Filter by a function. The specified function will be called with each record in this data source. If the function returns
     * true the record is included, otherwise it is filtered.
     *
     * @param cb the filter function
     */
    public native void filterBy(StoreTraversalCallback cb)/*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.filterBy(function(r) {
            var rj = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            return cb.@com.gwtext.client.data.StoreTraversalCallback::execute(Lcom/gwtext/client/data/Record;)(rj);
        });
    }-*/;

    /**
     * Returns the record at the specified index. This method is functionally equivalent to {@link #getAt(int)}.
     *
     * @param index the Store index
     * @return the Record at index
     */
    public Record getRecordAt(int index) {
        return getAt(index);
    }
    
    /**
     * Returns the record at the specified index.
     *
     * @param index the Store index
     * @return the Record at index
     */
    public native Record getAt(int index) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var rec = store.getAt(index);
		if(rec == null || rec === undefined) return null;
		return @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
    }-*/;

    /**
     * Get the Record with the specified id.
     *
     * @param id the Record ID
     * @return the matched Record or null if no match found
     */
    public native Record getById(String id) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var rec = store.getById(id);
		if(rec == null || rec === undefined) return null;
		return @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
	}-*/;

    /**
     * Gets the number of cached records. If using paging, this may not be the total size of the dataset. If the data
     * object used by the Reader contains the dataset size, then the getTotalCount() function returns the data set size
     *
     * @return the Record count
     */
    public native int getCount() /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        return store.getCount();
    }-*/;

    /**
     * Gets all records modified since the last commit. Modified records are persisted across load operations (e.g., during paging).
     *
     * @return the modified Records
     */
    public Record[] getModifiedRecords() {
        JavaScriptObject nativeArray = getModifiedRecords(jsObj);
        return convertFromNativeRecordsArray(nativeArray);
    }

    private static Record[] convertFromNativeRecordsArray(JavaScriptObject nativeArray) {
        JavaScriptObject[] recordsj = JavaScriptObjectHelper.toArray(nativeArray);
        Record[] records = new Record[recordsj.length];
        for (int i = 0; i < recordsj.length; i++) {
            JavaScriptObject record = recordsj[i];
            records[i] = new Record(record);
        }
        return records;
    }

    private native JavaScriptObject getModifiedRecords(JavaScriptObject store)/*-{
		return store.getModifiedRecords();
	}-*/;

    /**
     * Returns a range of Records between specified indices.
     *
     * @param startIndex the starting index (0 based)
     * @param endIndex the ending index
     * @return array of Records
     */
    public Record[] getRange(int startIndex, int endIndex) {
        JavaScriptObject nativeArray = getRange(jsObj, startIndex, endIndex);
        return convertFromNativeRecordsArray(nativeArray);
    }

    private native JavaScriptObject getRange(JavaScriptObject store, int startIndex, int endIndex)/*-{
		return store.getRange(startIndex, endIndex);
	}-*/;

    /**
     * Returns the sort state of the Store.
     * 
     * @return the Store sort state
     */
    public SortState getSortState() {
        JavaScriptObject sortState = getSortState(jsObj);
        return new SortState(JavaScriptObjectHelper.getAttribute(sortState, "field"),
                JavaScriptObjectHelper.getAttribute(sortState, "direction"));
    }

    private native JavaScriptObject getSortState(JavaScriptObject store)/*-{
		return store.getSortState();
	}-*/;

    /**
     * Gets the total number of records in the dataset as returned by the server. If using paging, for this to
     *  be accurate, the data object used by the Reader must contain the dataset size.
     *
     * @return total record count
     */
    public native int getTotalCount() /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        return store.getTotalCount();
    }-*/;

    /**
     *  Get the index within the cache of the passed Record.
     * 
     * @param record the Record to find
     * @return the index of the passed Record. Returns -1 if not found
     */
    public native int indexOf(Record record)/*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var rec = record.@com.gwtext.client.core.JsObject::jsObj;
        return store.indexOf(rec);
    }-*/;

    /**
     * Get the index within the cache of the Record with the passed id.
     * 
     * @param id the Record ID
     * @return  the index of the Record. Returns -1 if not found
     */
    public native int indexOfId(String id)/*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        return store.indexOfId(id);
    }-*/;

    /**
     * Inserts Records to the Store at the given index and fires the add event.
     * 
     * @param index the start index at which to insert the passed Record
     * @param record the Record to insert
     */
    public native void insert(int index, Record record) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var recordJ = record.@com.gwtext.client.core.JsObject::jsObj;
		return store.insert(index, recordJ);
    }-*/;

    /**
     * Inserts Records to the Store at the given index and fires the add event.
     *
     * @param index the start index at which to insert the passed Records
     * @param records the Records to insert
     */
    public void insert(int index, Record[] records) {
        JavaScriptObject[] recordsJS = new JavaScriptObject[records.length];
        for (int i = 0; i < records.length; i++) {
            Record record = records[i];
            recordsJS[i] = record.getJsObj();
        }
        JavaScriptObject nativeRecordsArray = JavaScriptObjectHelper.convertToJavaScriptArray(recordsJS);
        insert(index, jsObj, nativeRecordsArray);
    }

    private native void insert(int index, JavaScriptObject store, JavaScriptObject nativeRecordsArray)/*-{
		store.insert(index, nativeRecordsArray);
    }-*/;

    /**
     * Loads the Record cache from the configured Proxy using the configured Reader.
     * <br/><br/>
     * If using remote paging, then the first load call must specify the start and limit properties
     * to establish the initial position within the dataset by calling {@link #load(int, int)} , and the number of Records
     * to cache on each read from the Proxy. It is important to note that for remote data sources, loading is asynchronous,
     * and this call will return before the new data has been loaded. Perform any post-processing in a "load" event handler.
     */
    public native void load() /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.load();
	}-*/;

    /**
     * Loads the Record cache from the configured Proxy using the configured Reader.
     * <br/><br/>
     * If using remote paging, then the first load call must specify the start and limit properties
     * to establish the initial position within the dataset by calling {@link #load(int, int)} , and the number of Records
     * to cache on each read from the Proxy. It is important to note that for remote data sources, loading is asynchronous,
     * and this call will return before the new data has been loaded. Perform any post-processing in a "load" event handler.
     *
     * @param start start position
     * @param limit limit
     */
    public native void load(int start, int limit) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.load({params:{start:start, limit:limit}});
	}-*/;

    /**
     * Loads the Record cache from the configured Proxy using the configured Reader.
     * <br/><br/>
     * If using remote paging, then the first load call must specify the start and limit properties
     * to establish the initial position within the dataset by calling {@link #load(int, int)} , and the number of Records
     * to cache on each read from the Proxy. It is important to note that for remote data sources, loading is asynchronous,
     * and this call will return before the new data has been loaded. Perform any post-processing in a "load" event handler.
     *
     * @param config the load config
     */
    public native void load(StoreLoadConfig config) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        store.load(configJS);
    }-*/;

    /**
     * Reloads the Record cache from the configured Proxy using the configured Reader and the options
     * from the last load operation performed.
     */
    public native void reload() /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.reload();
	}-*/;
    
    //can be invoked from jsni code passing json object retreived from XHR response
    public native void loadData(JavaScriptObject data, boolean append) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.loadData(data, append);
    }-*/;

    /**
     * Sets the Store's DataProxy.
     *
     * @param proxy the data proxy
     */
    public native void setProxy(DataProxy proxy) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var proxyJS = proxy.@com.gwtext.client.core.JsObject::jsObj;
        store.proxy = proxyJS;
    }-*/;

    /**
     * Reloads the Record cache from the configured Proxy using the configured Reader and the options
     * from the last load operation performed.
     *
     * @param config reload config
     */
    public native void reload(StoreLoadConfig config) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        store.reload(configJS);
    }-*/;

    /**
     * Query the records by a specified property.
     * 
     * @param field the field to query on
     * @param value a string that the field should start with
     * @return array of match records or empty array if no match found
     */
    public Record[] query(String field, String value) {
        JavaScriptObject nativeArray = doQuery(field, value, false);
        return convertFromNativeRecordsArray(nativeArray);
    }

    private native JavaScriptObject doQuery(String field, String value, boolean anyMatch) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var records = store.query(field, value, anyMatch);
        return records.items;
    }-*/;

    /**
     * Query the records by a specified property.
     *
     * @param field the field to query on
     * @param value a string that the field should start with
     * @param anyMatch true to match any part not just the beginning
     * @return array of match records or empty array if no match found
     */
    public Record[] query(String field, String value, boolean anyMatch) {
        JavaScriptObject nativeArray = doQuery(field, value, anyMatch);
        return convertFromNativeRecordsArray(nativeArray);
    }

    /**
     * Query the records by a specified property.
     *
     * @param field the field to query on
     * @param regexp a RegExp to test against the field
     * @return array of match records or empty array if no match found
     */
    public Record[] query(String field, RegExp regexp) {
        JavaScriptObject nativeArray = doQuery(field, regexp);
        return convertFromNativeRecordsArray(nativeArray);
    }

    private native JavaScriptObject doQuery(String field, RegExp regexp) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var re = regexp.@com.gwtext.client.core.JsObject::jsObj;
        var records = store.query(field, re);
        return records.items;
    }-*/;


    /**
     * Query by a function. The specified function will be called with each record in this data source.
     * If the function returns true the record is included in the results.
     *
     * @param queryFunction the query function
     * @return array of match records or empty array if no match found
     */
    public Record[] queryBy(StoreQueryFunction queryFunction) {
        JavaScriptObject nativeArray = doQueryBy(queryFunction);
        return convertFromNativeRecordsArray(nativeArray);
    }

    private native JavaScriptObject doQueryBy(StoreQueryFunction queryFunction) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var results = store.queryBy(function(record, id) {
            id = (id === undefined)? null: id.toString();
            var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            return queryFunction.@com.gwtext.client.data.StoreQueryFunction::test(Lcom/gwtext/client/data/Record;Ljava/lang/String;)(recordJ, id);
        });
        return results.items;
    }-*/;

    /**
     * Cancel outstanding changes on all changed records.
     */
    public native void rejectChanges() /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.rejectChanges();
	}-*/;

    /**
     * Remove a Record from the Store and fires the remove event.
     * 
     * @param record the record to remove
     */
    public native void remove(Record record) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var recordJ = record.@com.gwtext.client.core.JsObject::jsObj;
		return store.remove(recordJ);
    }-*/;

    /**
     * Remove all Records from the Store and fires the clear event.
     */
    public native void removeAll() /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.removeAll();
	}-*/;

    /**
     * Sets the default sort column and order to be used by the next load operation.
     *
     * @param field the name of the field to sort by
     * @param sortDir the sort order
     */
    public void setDefaultSort(String field, SortDir sortDir){
        setDefaultSort(field, sortDir.getDirection());
    }

    /**
     * Sets the default sort column and order to be used by the next load operation.
     * 
     * @param field the name of the field to sort by
     * @param sortDir the sort order, "ASC" or "DESC" (defaults to "ASC")
     * @deprecated Use {@link #setDefaultSort(String, com.gwtext.client.core.SortDir)}
     */
    public native void setDefaultSort(String field, String sortDir) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.setDefaultSort(field, sortDir);
    }-*/;

    /**
     * Sort the Records. If remote sorting is used, the sort is performed on the server, and the cache is reloaded.
     * If local sorting is used, the cache is sorted internally.
     * 
     * @param field the name of the field to sort by
     */
    public native void sort(String field) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.sort(field);
	}-*/;

     /**
     * Sort the Records. If remote sorting is used, the sort is performed on the server, and the cache is reloaded.
     * If local sorting is used, the cache is sorted internally.
     *
     * @param field the name of the field to sort by
     * @param direction the sort order
     */
    public void sort(String field, SortDir direction) {
        sort(field, direction.getDirection());
    }
     /**
     * Sort the Records. If remote sorting is used, the sort is performed on the server, and the cache is reloaded.
     * If local sorting is used, the cache is sorted internally.
     *
     * @param field the name of the field to sort by
     * @param direction the sort order, "ASC" or "DESC" (defaults to "ASC")
     * @deprecated Use {@link #sort(String, com.gwtext.client.core.SortDir)} 
     */
    public native void sort(String field, String direction) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.sort(field, direction);
	}-*/;

    /**
     * Sums the value of property for each record between start and end and returns the result.
     * 
     * @param field field on your records
     * @return the sum
     */
    public native float sum(String field) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.sum(field);
	}-*/;

    /**
     * Sums the value of property for each record between start and end and returns the result.
     *
     * @param field field on your records
     * @param startIndex the record index to start at (defaults to 0)
     * @param endIndex the last record index to include
     * @return the sum
     */
    public native float sum(String field, int startIndex, int endIndex) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.sum(field, startIndex, endIndex);
	}-*/;

    /**
     * Return all the Records in the Store.
     *
     * @return the Records
     */
    public Record[] getRecords() {
        JavaScriptObject nativeArray = getRecords(jsObj);
        return convertFromNativeRecordsArray(nativeArray);
    }

    private native JavaScriptObject getRecords(JavaScriptObject store)/*-{
		return store.getRange();
	}-*/;


    private static StoreLoadException createStoreLoadException(String message) {
        return new StoreLoadException(message);
    }

    private static HttpStoreLoadException createHttpStoreLoadExeption(int httpStatus, String message) {
        return new HttpStoreLoadException(httpStatus, message);
    }

    private static boolean isThrowable(Object object) {
        return object instanceof Throwable;
    }

    /**
     * Add a Store listener.
     *
     * @param listener the listener
     */
    public native void addStoreListener(StoreListener listener) /*-{
	    var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var storeJ = this;

		store.addListener('add',
					function(self, records, index) {
						var recordsJ = @com.gwtext.client.data.Store::convertFromNativeRecordsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
						listener.@com.gwtext.client.data.event.StoreListener::onAdd(Lcom/gwtext/client/data/Store;[Lcom/gwtext/client/data/Record;I)(storeJ, recordsJ, index);
					}
		);

		store.addListener('beforeload',
            function(self) {
                return listener.@com.gwtext.client.data.event.StoreListener::doBeforeLoad(Lcom/gwtext/client/data/Store;)(storeJ);
            }
		);

		store.addListener('clear',
            function(self) {
                return listener.@com.gwtext.client.data.event.StoreListener::onClear(Lcom/gwtext/client/data/Store;)(storeJ);
            }
		);

		store.addListener('datachanged',
            function(self) {
                return listener.@com.gwtext.client.data.event.StoreListener::onDataChanged(Lcom/gwtext/client/data/Store;)(storeJ);
            }
		);

		store.addListener('load',
            function(self, records) {
                var recordsJ = @com.gwtext.client.data.Store::convertFromNativeRecordsArray(Lcom/google/gwt/core/client/JavaScriptObject;)(records);
                return listener.@com.gwtext.client.data.event.StoreListener::onLoad(Lcom/gwtext/client/data/Store;[Lcom/gwtext/client/data/Record;)(storeJ, recordsJ);
            }
		);

		store.addListener('remove',
            function(self, record, index) {
                var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                return listener.@com.gwtext.client.data.event.StoreListener::onRemove(Lcom/gwtext/client/data/Store;Lcom/gwtext/client/data/Record;I)(storeJ, recordJ, index);
            }
		);

		store.addListener('update',
            function(self, record, operation) {
                var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                var operationJ = null;
                if(operation =='edit') {
                    operationJ = @com.gwtext.client.data.Record::EDIT;
                } else if(operation == 'reject') {
                    operationJ = @com.gwtext.client.data.Record::REJECT;
                } else if (operation == 'commit') {
                    operationJ = @com.gwtext.client.data.Record::COMMIT;
                }
                return listener.@com.gwtext.client.data.event.StoreListener::onUpdate(Lcom/gwtext/client/data/Store;Lcom/gwtext/client/data/Record;Lcom/gwtext/client/data/Record$Operation;)(storeJ, recordJ, operationJ);
            }
		);

        store.addListener('loadexception',
            function(proxy, arg1, response, e) {
                var err = null;
                var isException = false;
                if(e != null && e !== undefined) {
                    isException = @com.gwtext.client.data.Store::isThrowable(Ljava/lang/Object;)(e);
                }
                if(isException) {
                    err = e;
                } else if(e !== undefined && e.message != null && e.message !== undefined) {
                    err = @com.gwtext.client.data.Store::createStoreLoadException(Ljava/lang/String;)(e.message);
                } else if(response != null && response.responseText != null && response.responseText !== undefined) {
                    err = err = @com.gwtext.client.data.Store::createHttpStoreLoadExeption(ILjava/lang/String;)(response.status, response.responseText);
                } else if (response != null) {
                    err = @com.gwtext.client.data.Store::createStoreLoadException(Ljava/lang/String;)(response.toString());
                }
                listener.@com.gwtext.client.data.event.StoreListener::onLoadException(Ljava/lang/Throwable;)(err);
            }
		);
     }-*/;
}
