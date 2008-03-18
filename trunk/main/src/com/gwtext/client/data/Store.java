/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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

/**
 * The Store class encapsulates a client side cache of {@link Record} objects which provide input data for widgets such
 * as the {@link com.gwtext.client.widgets.grid.GridPanel}, or the {@link com.gwtext.client.widgets.form.ComboBox}.
 * <p/>
 * A Store object uses an implementation of {@link DataProxy} to access a data object unless you call loadData() directly
 * and pass in your data. The Store object has no knowledge of the format of the data returned by the Proxy.
 * <p/>
 * A Store object uses its configured implementation of {@link Reader} to {@link Record} instances from the data object.
 * These records are cached and made available through accessor functions. Usage :
 * <p/>
 * <pre>
 * <code>
 * <p/>
 * Object[][] states = new Object[][]{
 *               new Object[]{"AL", "Alabama"},
 *               new Object[]{"AK", "Alaska"},
 *               new Object[]{"AZ", "Arizona"},
 *               new Object[]{"AR", "Arkansas"},
 *               new Object[]{"CA", "California"}};
 * <p/>
 * Reader reader = new ArrayReader(new RecordDef(
 *                new FieldDef[]{
 *                       new StringFieldDef("abbr"),
 *                       new StringFieldDef("state")
 *               }));
 * <p/>
 * Store store = new Store(proxy, reader);
 * </code>
 * </pre>
 *
 * @see com.gwtext.client.data.XmlReader
 * @see com.gwtext.client.data.JsonReader
 * @see com.gwtext.client.data.HttpProxy
 * @see com.gwtext.client.data.MemoryProxy
 */
public class Store extends JsObject {

    protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();

    protected Store() {
    }

    public Store(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static Store instance(JavaScriptObject jsObj) {
        return new Store(jsObj);
    }

    //http://extjs.com/forum/showthread.php?t=3564&highlight=memoryproxy
    /**
     * Create a Store using the specified {@link RecordDef}. Data can be added to the Store using
     * {@link #add(Record)}
     *
     * @param recordDef the record def
     */
    public Store(RecordDef recordDef) {
        setRecordDef(recordDef);
    }

    /**
     * Create a Store using the specified {@link Reader}.
     *
     * @param reader the reader
     */
    public Store(Reader reader) {
        setReader(reader);
    }

    /**
     * Create a Store using the specified {@link com.gwtext.client.data.DataProxy} and {@link Reader}.
     *
     * @param dataProxy the data proxy
     * @param reader    the reader
     */
    public Store(DataProxy dataProxy, Reader reader) {
        setDataProxy(dataProxy);
        setReader(reader);
    }

    /**
     * Create a Store using the specified {@link com.gwtext.client.data.DataProxy} and {@link Reader}.
     *
     * @param dataProxy  the data proxy
     * @param reader     the reader
     * @param remoteSort true to enable remote sort of the data
     */
    public Store(DataProxy dataProxy, Reader reader, boolean remoteSort) {
        setDataProxy(dataProxy);
        setReader(reader);
        setRemoteSort(remoteSort);
    }

    /**
     * Create a Store using the specified configuration.
     *
     * @param dataProxy        the data proxy
     * @param reader           the reader
     * @param baseParams       base params which are to be sent as parameters on any HTTP request. Used only for Http based proxies.
     * @param initialSortState the initial sort field name and direction
     * @param remoteSort       true to enable remote sort
     */
    public Store(DataProxy dataProxy, Reader reader, UrlParam[] baseParams, SortState initialSortState, boolean remoteSort) {
        setDataProxy(dataProxy);
        setReader(reader);
        setBaseParams(baseParams);
        setInitialSortState(initialSortState);
        setRemoteSort(remoteSort);
    }


    native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.data.Store(config);
    }-*/;

    public JavaScriptObject getJsObj() {
        if(jsObj == null) {
            jsObj = create(configJS);
        }
        return jsObj;
    }

    /**
     * Base params which are to be sent as parameters on any HTTP request. Used only for Http based proxies.
     *
     * @param baseParams the base params
     */
    private native void setBaseParamsCreated(UrlParam[] baseParams) /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var baseParamsJS = @com.gwtext.client.core.NameValuePair::getJsObj([Lcom/gwtext/client/core/NameValuePair;)(baseParams);
        store.baseParams = baseParamsJS;
    }-*/;

    /**
     * Return the base params.
     *
     * @return the base params                      
     */
    public UrlParam[] getBaseParams() {
        JavaScriptObject baseParamsNative = getBaseParams(getJsObj());

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
            params[i] = param.@com.gwtext.client.core.JsObject::getJsObj()();
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
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		var recordJ = record.@com.gwtext.client.core.JsObject::getJsObj()();
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
        add(getJsObj(), nativeRecordsArray);
    }

    private native void add(JavaScriptObject store, JavaScriptObject nativeRecordsArray)/*-{
		store.add(nativeRecordsArray);
    }-*/;

    /**
     * (Local sort only) Inserts the passed the record in the Store at the index where it should go based on the
     * current sort information.
     *
     * @param record the record to add
     */
    public native void addSorted(Record record) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		var recordJ = record.@com.gwtext.client.core.JsObject::getJsObj()();
		return store.addSorted(recordJ);
    }-*/;

    /**
     * Revert to a view of the Record cache / snapshot with no filtering applied.  A snapshot of the data is taken when {@link #filter(String, String)} is called.
     * Records added to the Store after filter is caleld will be lost if clearFilter is subsequently called.
     */
    public native void clearFilter() /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return store.clearFilter();
    }-*/;

    /**
     * Revert to a view of the Record cache with no filtering applied.
     *
     * @param suppressEvent if true the filter is cleared silently without notifying listeners
     */
    public native void clearFilter(boolean suppressEvent) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return store.clearFilter(suppressEvent);
    }-*/;

    /**
     * Commit all Records with outstanding changes. To handle updates for changes, subscribe to the Store's "update" event,
     * and perform updating when the third parameter {@link Record#COMMIT}.
     */
    public native void commitChanges() /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return store.commitChanges();
    }-*/;

    //todo add collect() method

    /**
     * Calls the specified function for each of the Records in the cache.
     *
     * @param cb the Store traversal callback
     */
    public native void each(StoreTraversalCallback cb)/*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        store.each(function(r) {
            var rj = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            return cb.@com.gwtext.client.data.StoreTraversalCallback::execute(Lcom/gwtext/client/data/Record;)(rj);
        });
    }-*/;

    /**
     * Filter the records by a specified property using a Regular expression.
     *
     * @param field  the filed to filter on
     * @param regexp the regular expression to test field value against
     */
    public native void filter(String field, RegExp regexp) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var re = regexp.@com.gwtext.client.core.JsObject::getJsObj()();
        store.filter(field, re);
	}-*/;

    /**
     * Filter the records by a specified property .
     *
     * @param field the filed to filter on
     * @param value a string that the field should start with
     */
    public native void filter(String field, String value) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		store.filter(field, value);
	}-*/;

    /**
     * Filter the records by a specified property .
     *
     * @param field    the filed to filter on
     * @param value    a string that the field should start with
     * @param anyMatch true to match any part not just the beginning
     */
    public native void filter(String field, String value, boolean anyMatch) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		store.filter(field, value, anyMatch);
	}-*/;

    /**
     * Filter by a function. The specified function will be called with each record in this data source. If the function returns
     * true the record is included, otherwise it is filtered.
     *
     * @param cb the filter function
     */
    public native void filterBy(StoreTraversalCallback cb)/*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return store.getCount();
    }-*/;

    /**
     * Gets all records modified since the last commit. Modified records are persisted across load operations (e.g., during paging).
     *
     * @return the modified Records. Returns an empty array if no records were modified
     */
    public Record[] getModifiedRecords() {
        JavaScriptObject nativeArray = getModifiedRecords(getJsObj());
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
     * @param endIndex   the ending index
     * @return array of Records
     */
    public Record[] getRange(int startIndex, int endIndex) {
        JavaScriptObject nativeArray = getRange(getJsObj(), startIndex, endIndex);
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
        JavaScriptObject sortState = getSortState(getJsObj());
        return new SortState(JavaScriptObjectHelper.getAttribute(sortState, "field"),
                SortDir.getValue(JavaScriptObjectHelper.getAttribute(sortState, "direction")));
    }

    private native JavaScriptObject getSortState(JavaScriptObject store)/*-{
		return store.getSortState();
	}-*/;

    /**
     * Gets the total number of records in the dataset as returned by the server. If using paging, for this to
     * be accurate, the data object used by the Reader must contain the dataset size.
     *
     * @return total record count
     */
    public native int getTotalCount() /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return store.getTotalCount();
    }-*/;

    /**
     * Get the index within the cache of the passed Record.
     *
     * @param record the Record to find
     * @return the index of the passed Record. Returns -1 if not found
     */
    public native int indexOf(Record record)/*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var rec = record.@com.gwtext.client.core.JsObject::getJsObj()();
        return store.indexOf(rec);
    }-*/;

    /**
     * Get the index within the cache of the Record with the passed id.
     *
     * @param id the Record ID
     * @return the index of the Record. Returns -1 if not found
     */
    public native int indexOfId(String id)/*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return store.indexOfId(id);
    }-*/;

    /**
     * Inserts Records to the Store at the given index and fires the add event.
     *
     * @param index  the start index at which to insert the passed Record
     * @param record the Record to insert
     */
    public native void insert(int index, Record record) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		var recordJ = record.@com.gwtext.client.core.JsObject::getJsObj()();
		return store.insert(index, recordJ);
    }-*/;

    /**
     * Inserts Records to the Store at the given index and fires the add event.
     *
     * @param index   the start index at which to insert the passed Records
     * @param records the Records to insert
     */
    public void insert(int index, Record[] records) {
        JavaScriptObject[] recordsJS = new JavaScriptObject[records.length];
        for (int i = 0; i < records.length; i++) {
            Record record = records[i];
            recordsJS[i] = record.getJsObj();
        }
        JavaScriptObject nativeRecordsArray = JavaScriptObjectHelper.convertToJavaScriptArray(recordsJS);
        insert(index, getJsObj(), nativeRecordsArray);
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
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
     * @param params the load params
     */
     public void load(UrlParam[] params) {
         load(params, false);

     }

    /**
     * Loads the Record cache from the configured Proxy using the configured Reader.
     * <br/><br/>
     * If using remote paging, then the first load call must specify the start and limit properties
     * to establish the initial position within the dataset by calling {@link #load(int, int)} , and the number of Records
     * to cache on each read from the Proxy. It is important to note that for remote data sources, loading is asynchronous,
     * and this call will return before the new data has been loaded. Perform any post-processing in a "load" event handler.
     *
     * @param params the load params
     * @param add true to append loaded records rather than replace the current cache
     */
    public void load(UrlParam[] params, boolean add) {
        JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
        if(params != null && params.length > 0) {
            JavaScriptObjectHelper.setAttribute(configJS, "params", UrlParam.getJsObj(params));
        }
        JavaScriptObjectHelper.setAttribute(configJS, "add", add);
        load(configJS);
     }

    private native void load(JavaScriptObject configJS) /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        store.load(configJS);
    }-*/;

    /**
     * Reloads the Record cache from the configured Proxy using the configured Reader and the options
     * from the last load operation performed.
     */
    public native void reload() /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        store.reload();
	}-*/;


    /**
     * Load data from a local Json String
     *
     * @param jsonString the Json String
     * @param append     true to append to the Store
     */
    public native void loadJsonData(String jsonString, boolean append) /*-{
        var json = $wnd.Ext.util.JSON.decode(jsonString);
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        store.loadData(json, append);
    }-*/;

    /**
     * Load data from XML returned from a URL.
     *
     * @param url    the url that returns the XML data
     * @param append true to append records
     */
    public native void loadXmlDataFromUrl(String url, boolean append) /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        $wnd.Ext.Ajax.request( {method:"GET", url: url,
            callback: function(connection, options, response) {
                store.loadData(response.responseXML, append);
            } } );
    }-*/;

    /**
     * Load data from a local XML String.
     *
     * @param xmlString the XML data
     * @param append    true to append records
     */
    public native void loadXmlData(String xmlString, boolean append) /*-{
        var doc = function() {
            var objdoc;

            if (window.ActiveXObject) {
                objdoc = new ActiveXObject ("Microsoft.XMLDOM");
                objdoc.async =  "false";
                objdoc.loadXML(xmlString);
            }
            else {
                objdoc = new DOMParser().parseFromString(xmlString, "text/xml");
            }
            return objdoc;
        }();
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        store.loadData(doc, append);
    }-*/;

    /**
     * Sets the Store's DataProxy.
     *
     * @param proxy the data proxy
     */
    private native void setDataProxyCreated(DataProxy proxy) /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var proxyJS = proxy.@com.gwtext.client.core.JsObject::getJsObj()();
        store.proxy = proxyJS;
    }-*/;


    /**
     * Reloads the Record cache from the configured Proxy using the configured Reader and the options
     * from the last load operation performed.
     *
     * @param params the request params
     */
     public void reload(UrlParam[] params) {
         reload(params, false);

     }

    /**
     * Reloads the Record cache from the configured Proxy using the configured Reader and the options
     * from the last load operation performed.
     *
     * @param params the request params
     * @param add true to append loaded records rather than replace the current cache
     */
    public void reload(UrlParam[] params, boolean add) {
        JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
        if(params != null && params.length > 0) {
            JavaScriptObjectHelper.setAttribute(configJS, "params", UrlParam.getJsObj(params));
        }
        JavaScriptObjectHelper.setAttribute(configJS, "add", add);
        reload(configJS);
     }

    private native void reload(JavaScriptObject configJS) /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var records = store.query(field, value, anyMatch);
        return records.items;
    }-*/;

    /**
     * Query the records by a specified property.
     *
     * @param field    the field to query on
     * @param value    a string that the field should start with
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
     * @param field  the field to query on
     * @param regexp a RegExp to test against the field
     * @return array of match records or empty array if no match found
     */
    public Record[] query(String field, RegExp regexp) {
        JavaScriptObject nativeArray = doQuery(field, regexp);
        return convertFromNativeRecordsArray(nativeArray);
    }

    private native JavaScriptObject doQuery(String field, RegExp regexp) /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var re = regexp.@com.gwtext.client.core.JsObject::getJsObj()();
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
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		store.rejectChanges();
	}-*/;

    /**
     * Remove a Record from the Store and fires the remove event.
     *
     * @param record the record to remove
     */
    public native void remove(Record record) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		var recordJ = record.@com.gwtext.client.core.JsObject::getJsObj()();
		return store.remove(recordJ);
    }-*/;

    /**
     * Remove all Records from the Store and fires the clear event.
     */
    public native void removeAll() /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		store.removeAll();
	}-*/;

    /**
     * Sets the default sort column and order to be used by the next load operation.
     *
     * @param field   the name of the field to sort by
     * @param sortDir the sort order
     */
    public void setDefaultSort(String field, SortDir sortDir) {
        setDefaultSort(field, sortDir.getDirection());
    }

    /**
     * Sets the default sort column and order to be used by the next load operation.
     *
     * @param field   the name of the field to sort by
     * @param sortDir the sort order, "ASC" or "DESC" (defaults to "ASC")
     * @deprecated Use {@link #setDefaultSort(String, com.gwtext.client.core.SortDir)}
     */
    public native void setDefaultSort(String field, String sortDir) /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        store.setDefaultSort(field, sortDir);
    }-*/;

    /**
     * Sort the Records. If remote sorting is used, the sort is performed on the server, and the cache is reloaded.
     * If local sorting is used, the cache is sorted internally.
     *
     * @param field the name of the field to sort by
     */
    public native void sort(String field) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		store.sort(field);
	}-*/;

    /**
     * Sort the Records. If remote sorting is used, the sort is performed on the server, and the cache is reloaded.
     * If local sorting is used, the cache is sorted internally.
     *
     * @param field     the name of the field to sort by
     * @param direction the sort order
     */
    public void sort(String field, SortDir direction) {
        sort(field, direction.getDirection());
    }

    /**
     * Sort the Records. If remote sorting is used, the sort is performed on the server, and the cache is reloaded.
     * If local sorting is used, the cache is sorted internally.
     *
     * @param field     the name of the field to sort by
     * @param direction the sort order, "ASC" or "DESC" (defaults to "ASC")
     * @deprecated Use {@link #sort(String, com.gwtext.client.core.SortDir)}
     */
    public native void sort(String field, String direction) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		store.sort(field, direction);
	}-*/;

    /**
     * Sums the value of property for each record between start and end and returns the result.
     *
     * @param field field on your records
     * @return the sum
     */
    public native float sum(String field) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return store.sum(field);
	}-*/;

    /**
     * Sums the value of property for each record between start and end and returns the result.
     *
     * @param field      field on your records
     * @param startIndex the record index to start at (defaults to 0)
     * @param endIndex   the last record index to include
     * @return the sum
     */
    public native float sum(String field, int startIndex, int endIndex) /*-{
		var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
		return store.sum(field, startIndex, endIndex);
	}-*/;

    /**
     * Return all the Records in the Store.
     *
     * @return the Records
     */
    public Record[] getRecords() {
        JavaScriptObject nativeArray = getRecords(getJsObj());
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
    
    /**
     * Add a Store listener.
     *
     * @param listener the listener
     */
    public native void addStoreListener(StoreListener listener) /*-{
	    var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
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
                    isException = e.je != null && e.je !== undefined;
                }

                if(isException) {
                    err = e.je;
                } else if(e !== undefined && e.message != null && e.message !== undefined) {
                    err = @com.gwtext.client.data.Store::createStoreLoadException(Ljava/lang/String;)(e.message);
                } else if(response != null && response.responseText != null && response.responseText !== undefined) {
                    err = err = @com.gwtext.client.data.Store::createHttpStoreLoadExeption(ILjava/lang/String;)(response.status, response.responseText);
                } else if (response != null) {
                    err = @com.gwtext.client.data.Store::createStoreLoadException(Ljava/lang/String;)(response.toString());
                } else {
                    err = @com.gwtext.client.data.Store::createStoreLoadException(Ljava/lang/String;)('Unknown error.');
                }
                listener.@com.gwtext.client.data.event.StoreListener::onLoadException(Ljava/lang/Throwable;)(err);
            }
		);
     }-*/;

    //config options
   /**
     * If true, this store's load method is automatically called after creation.
     *
     * @param autoLoad true to auto laod
     */
    public void setAutoLoad(boolean autoLoad) {
        JavaScriptObjectHelper.setAttribute(configJS, "autoLoad", autoLoad);
    }

    /**
     * Url params which are to be sent as parameters on any HTTP request.
     *
     * @param baseParams the base params
     */
    public void setBaseParams(UrlParam[] baseParams) {
        if(!isCreated()) {
             if (baseParams != null && baseParams.length > 0) {
                JavaScriptObject paramObj = UrlParam.getJsObj(baseParams);
                JavaScriptObjectHelper.setAttribute(configJS, "baseParams", paramObj);
            }
        } else {
            setBaseParamsCreated(baseParams);
        }
    }

    /**
     * The Proxy object which provides access to a data object..
     *
     * @param proxy the data proxy
     */
    public void setDataProxy(DataProxy proxy) {
        if(!isCreated()) {
            JavaScriptObjectHelper.setAttribute(configJS, "proxy", proxy.getJsObj());
        } else {
            setDataProxyCreated(proxy);
        }
    }

    /**
     * True to clear all modified record information each time the store is loaded or when a record is removed. (defaults to false).
     *
     * @param pruneModifiedRecords true to prune modified records
     */
    public void setPruneModifiedRecords(boolean pruneModifiedRecords) {
        JavaScriptObjectHelper.setAttribute(configJS, "pruneModifiedRecords", pruneModifiedRecords);
    }

    /**
     * The Reader object which processes the data object and returns an Array of Ext.data.record objects which are cached
     * keyed by their id property.
     *
     * @param reader the reader
     */
    public void setReader(Reader reader) {
        JavaScriptObjectHelper.setAttribute(configJS, "reader", reader.getJsObj());
    }

    /**
     * True if sorting is to be handled by requesting the Proxy to provide a refreshed version of the data object in sorted order, as opposed to sorting the Record cache in place (defaults to false).
     * If remote sorting is specified, then clicking on a column header causes the current page to be requested from the server with the addition of the following two parameters:
     * <p/>
     * sort : String  The name (as specified in the Record's Field definition) of the field to sort on.
     * dir : String The direction of the sort, "ASC" or "DESC".
     *
     * @param remoteSort true to enable remote sort
     */
    public void setRemoteSort(boolean remoteSort) {
        JavaScriptObjectHelper.setAttribute(configJS, "remoteSort", remoteSort);
    }

    /**
     * The initial field to sort and its direction
     *
     * @param sortInfo the sort info
     */
    public void setSortInfo(SortState sortInfo) {
        JavaScriptObjectHelper.setAttribute(configJS, "sortInfo", sortInfo.getJsObj());
    }

    /**
     * If passed, the id to use to register with the StoreMgr.
     *
     * @param storeId the store ID
     */
    public void setStoreId(String storeId) {
        JavaScriptObjectHelper.setAttribute(configJS, "storeId", storeId);
    }

    /**
     * If passed, an HttpProxy is created for the passed URL.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        JavaScriptObjectHelper.setAttribute(configJS, "url", url);
    }

    /**
     * Sets the record def for the Store.
     *
     * @param recordDef the stores record def 
     */
    public void setRecordDef(RecordDef recordDef) {
        JavaScriptObjectHelper.setAttribute(configJS, "recordType", recordDef.getJsObj());
    }

    /**
     * Set the initial sort state.
     *
     * @param initialSortState the initial sort state
     */
    public void setInitialSortState(SortState initialSortState) {
        if (initialSortState != null) {
            JavaScriptObject sortStateParamObj = JavaScriptObjectHelper.createObject();
            JavaScriptObjectHelper.setAttribute(sortStateParamObj, "field", initialSortState.getField());
            JavaScriptObjectHelper.setAttribute(sortStateParamObj, "direction", initialSortState.getDirection().getDirection());
            JavaScriptObjectHelper.setAttribute(configJS, "sortInfo ", sortStateParamObj);
        }
    }

    public native JavaScriptObject getRecordsAsJS() /*-{
        var store = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var records = store.getRange();
        var cnt = records.length;
        var data = @com.gwtext.client.util.JavaScriptObjectHelper::createJavaScriptArray()();
        for(var i = 0; i < cnt; i++) {
            var record = records[i];
            var items = record.fields.items
            var cnt2=items.length;
            var o = {};
            for ( var j=0; j<cnt2; ++j ){
                var fname = items[j].name;
                o[fname] = record.get(fname);
            }
            data.push(o);
        }
        return data;
    }-*/;

    public String[] getFields() {
        JavaScriptObject nativeArray = getFields(jsObj);
        return JavaScriptObjectHelper.convertToJavaStringArray(nativeArray);
    }

    private native JavaScriptObject getFields(JavaScriptObject store)/*-{
        var fields = @com.gwtext.client.util.JavaScriptObjectHelper::createJavaScriptArray()();
        var items = store.fields.items
        var cnt=items.length;
        for ( var i=0; i<cnt; ++i ){
            fields.push(items[i].name);
        }

        return fields;
    }-*/;
}
