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
import com.google.gwt.xml.client.Element;
import com.gwtext.client.core.JsObject;
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


    public native void add(Record record) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var recordJ = record.@com.gwtext.client.core.JsObject::jsObj;
		return store.add(recordJ);
    }-*/;

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

    public native void clearFilter() /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.clearFilter();
    }-*/;

    public native void clearFilter(boolean suppressEvent) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.clearFilter(suppressEvent);
    }-*/;

    public native void commitChanges() /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.commitChanges();
    }-*/;

    public native void each(StoreTraversalCallback cb)/*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.each(function(r) {
            var rj = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            return cb.@com.gwtext.client.data.StoreTraversalCallback::execute(Lcom/gwtext/client/data/Record;)(rj);
        });
    }-*/;

    //todo support regexp vrsion
    public native void filter(String field, String value, boolean anyMatch) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.filter(field, value, anyMatch);
	}-*/;


    public native void filterBy(StoreTraversalCallback cb)/*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.filterBy(function(r) {
            var rj = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            return cb.@com.gwtext.client.data.StoreTraversalCallback::execute(Lcom/gwtext/client/data/Record;)(rj);
        });
    }-*/;

    public native Record getAt(int index) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var rec = store.getAt(index);
		if(rec == null || rec === undefined) return null;
		return @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
    }-*/;

    public native Record getById(String id) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var rec = store.getById(id);
		if(rec == null || rec === undefined) return null;
		return @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(rec);
	}-*/;

    public native int getCount() /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        return store.getCount();
    }-*/;

    //tested
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

    public Record[] getRange(int startIndex, int endIndex) {
        JavaScriptObject nativeArray = getRange(jsObj, startIndex, endIndex);
        return convertFromNativeRecordsArray(nativeArray);
    }

    private native JavaScriptObject getRange(JavaScriptObject store, int startIndex, int endIndex)/*-{
		return store.getRange(startIndex, endIndex);
	}-*/;

    public SortState getSortState() {
        JavaScriptObject sortState = getSortState(jsObj);
        return new SortState(JavaScriptObjectHelper.getAttribute(sortState, "field"),
                JavaScriptObjectHelper.getAttribute(sortState, "direction"));
    }

    private native JavaScriptObject getSortState(JavaScriptObject store)/*-{
		return store.getSortState();
	}-*/;

    public native int getTotalCount() /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        return store.getTotalCount();
    }-*/;

    public native int indexOf(Record record)/*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var rec = record.@com.gwtext.client.core.JsObject::jsObj;
        return store.indexOf(rec);
    }-*/;

    public native int indexOfId(String id)/*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        return store.indexOfId(id);
    }-*/;


    public native void insert(int index, Record record) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var recordJ = record.@com.gwtext.client.core.JsObject::jsObj;
		return store.insert(index, recordJ);
    }-*/;

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

    public native void load() /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.load();
	}-*/;

    public native void reload() /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.reload();
	}-*/;

    public native void load(int start, int limit) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.load({params:{start:start, limit:limit}});
	}-*/;

    public native void load(StoreLoadConfig config) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        store.load(configJS);
    }-*/;

    //needs to be xml dom document for XmlReader
    public native void loadData(Element doc, boolean append) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.loadData(doc, append);
    }-*/;

    //can be invoked from jsni code passing json object retreived from XHR response
    public native void loadData(JavaScriptObject data, boolean append) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.loadData(data, append);
    }-*/;

    public native void setProxy(DataProxy proxy) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var proxyJS = proxy.@com.gwtext.client.core.JsObject::jsObj;
        store.proxy = proxyJS;
    }-*/;

    public native void reload(StoreLoadConfig config) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        store.reload(configJS);
    }-*/;

    //todo query
    //queryBy

    public native void rejectChanges() /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.rejectChanges();
	}-*/;

    public native void remove(Record record) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		var recordJ = record.@com.gwtext.client.core.JsObject::jsObj;
		return store.remove(recordJ);
    }-*/;

    public native void removeAll() /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.removeAll();
	}-*/;

    public native void setDefaultSort(String field, String sortDir) /*-{
        var store = this.@com.gwtext.client.core.JsObject::jsObj;
        store.setDefaultSort(field, sortDir);
    }-*/;

    public native void sort(String field) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.sort(field);
	}-*/;

    public native void sort(String field, String direction) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		store.sort(field, direction);
	}-*/;

    public native float sum(String field) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.sum(field);
	}-*/;

    public native float sum(String field, int startIndex, int endIndex) /*-{
		var store = this.@com.gwtext.client.core.JsObject::jsObj;
		return store.sum(field, startIndex, endIndex);
	}-*/;

    public Record[] getRecords() {
        JavaScriptObject nativeArray = getRecords(jsObj);
        return convertFromNativeRecordsArray(nativeArray);
    }

    private native JavaScriptObject getRecords(JavaScriptObject store)/*-{
		return store.getRange();
	}-*/;

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
                return listener.@com.gwtext.client.data.event.StoreListener::onUpdate(Lcom/gwtext/client/data/Store;Lcom/gwtext/client/data/Record;Ljava/lang/String;)(storeJ, recordJ, operation);
            }
		);

        store.addListener('loadexception',
            function(proxy, arg1, response, e) {
                var err = null;
                if(e !== undefined && e.message != null) {
                    err = e.message;
                } else if(response != null && response.responseText != null && response.responseText !== undefined) {
                    err = response.status + ':' + response.responseText;
                } else if (response != null) {
                    err = response.toString();
                }
                listener.@com.gwtext.client.data.event.StoreListener::onLoadException(Ljava/lang/String;)(err);
            }
		);
     }-*/;
}
