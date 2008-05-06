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
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

/**
 * Instances of this class encapsulate both record definition information, and record value information for use in Store objects,
 * or any code which needs to access Records cached in a Store object.
 *
 * @see com.gwtext.client.data.Store
 */
public class Record extends JsObject {

    public static final class Operation {
        private final String operation;

        private Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Operation)) return false;

            Operation operation1 = (Operation) o;

            if (!operation.equals(operation1.operation)) return false;

            return true;
        }

        public int hashCode() {
            return operation.hashCode();
        }
    }

    public static Operation EDIT = new Operation("edit");
    public static Operation REJECT = new Operation("reject");
    public static Operation COMMIT = new Operation("commit");

	/**
	 * This constructor is for internal / special uses only. Do not use this to create a new Record instance.
	 * You should use the factory method {@link com.gwtext.client.data.RecordDef#createRecord(String, Object[])} to create
	 * new Records.
	 *
	 * @param jsObj a native record object.
	 */
	public Record(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static Record instance(JavaScriptObject rec) {
        return new Record(rec);
    }

    /**
     * Returns the ID of the record or null if not defined.
     *
     * @return ID of the record
     */
    public native String getId() /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var id = record.id;
        return (id == null || id === undefined) ? null : id.toString();
    }-*/;

    /**
     * The Records modified state.
     *
     * @return true if this record has been modified
     */
    public native boolean isDirty() /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return record.dirty;
    }-*/;

    /**
     * Begin an edit. While in edit mode, no events are relayed to the containing store.
     */
    public native void beginEdit() /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.beginEdit();
    }-*/;

    /**
     * Cancels all changes made in the current edit operation.
     */
    public native void cancelEdit() /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.cancelEdit();
    }-*/;


    /**
     * Creates a copy of this record.
     *
     * @return copy of this Record
     */
    public native Record copy() /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var record2 = record.copy();
        return @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record2);
    }-*/;

    /**
     * Creates a copy of this record.
     *
     * @param id a new record id if you don't want to use this record's id
     * @return copy of this Record
     */
    public native Record copy(String id) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var record2 = record.copy(id);
        return @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record2);
    }-*/;

    /**
     * Usually called by the Store which owns the Record. Commits all changes made to the Record since either creation,
     * or the last commit operation. Developers should subscribe to {@link com.gwtext.client.data.event.StoreListener#onUpdate(Store, Record, com.gwtext.client.data.Record.Operation)} event
     * to have their code notified of commit operations.
     */
    public native void commit() /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.commit();
    }-*/;

    /**
     * Usually called by the Store which owns the Record. Commits all changes made to the Record since either creation,
     * or the last commit operation. Developers should subscribe to {@link com.gwtext.client.data.event.StoreListener#onUpdate(Store, Record, com.gwtext.client.data.Record.Operation)} event
     * to have their code notified of commit operations.
     *
     * @param silent true to skip notification of the owning store of the change (defaults to false)
     */
    public native void commit(boolean silent) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.commit(silent);
    }-*/;

    /**
     * End an edit. If any data was modified, the containing store is notified.
     */
    public native void endEdit() /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.endEdit();
    }-*/;

    //todo throw exception if field is invalid as opposed to null value for field?
    //throw new Error("JS Error Object");
    /**
     * Return the field value as String.
     *
     * @param field the field name
     * @return the field value
     */
    public native String getAsString(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var value = record.get(field);
        //todo?
        //if (value === undefined) throw new Error("Invalid field " + field);
        return (value === undefined || value == null || value === '') ? null : value.toString();
    }-*/;

    /**
     * Return the field value as Object.
     *
     * @param field the field name
     * @return the filed value
     */
    public native Object getAsObject(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var value = record.get(field);
        return (value === undefined || value == null || value === '') ? null : value;
    }-*/;

	/**
	 * Return true if specified field has been modified.
	 *
	 * @param fieldName the field name
	 * @return true if modified
	 */
	public native boolean isModified(String fieldName) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return record.isModified(fieldName);
    }-*/;
	
	/**
	 * Return true if specified field is null (or undefined)
	 *
	 * @param fieldName the field name
	 * @return true if null or undefined
	 */
	public native boolean isNull(String fieldName) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var value = record.get(fieldName);
        return value === undefined || value == null;
    }-*/;

	/**
     * Sets the fields Object value.
     *
     * @param field the field name
     * @param value the fiedl value
     */
    public native void set(String field, Object value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.set(field, value);
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */
    public native void set(String field, String value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.set(field, value);
    }-*/;

    /**
     * Returns the Records value as an integer.
     *
     * @param field the field name
     * @return the field value
     */
    public native int getAsInteger(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var value =  record.get(field);
        return (value === undefined || value == null ) ? 0 : parseInt(value);
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */
    public native void set(String field, int value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.set(field, value);
    }-*/;

    /**
     * Returns the Records value as a float.
     *
     * @param field the field name
     * @return the field value
     */
    public native float getAsFloat(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var value = record.get(field);
        return (value === undefined || value == null ) ? 0 : parseFloat(value);
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */
    public native void set(String field, float value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.set(field, value);
    }-*/;

    /**
     * Returns the Records value as a double.
     *
     * @param field the field name
     * @return the field value
     */
    public native double getAsDouble(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var value = record.get(field);
        return (value === undefined || value == null ) ? 0 : parseFloat(value);
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */
    public native void set(String field, double value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.set(field, value);
    }-*/;

    /**
     * Returns the Records value as a boolean value. If val is null, undefined, false, -0, +0, NaN, or an empty string (""),
     * this method returns false, otherwise it returns true for all other numbers and strings.
     *
     * @param field the field name
     * @return the field value
     */
    public native boolean getAsBoolean(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var value = record.get(field);
        return (value === undefined || value == null) ? false : Boolean(value);
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */
    public native void set(String field, boolean value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.set(field, value);
    }-*/;

    /**
     * Set the Record's ID.
     *
     * @param id the record ID
     */
    public native void setId(String id) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.id = id;
    }-*/;

    /**
     * Return the fields value as a Date.
     *
     * @param field the field name
     * @return the field value
     */
    public native Date getAsDate(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var val = record.get(field);
        if(val == null || val === undefined || val == '') {
            return null;
        } else {
            return @com.gwtext.client.util.DateUtil::create(D)(val.getTime());
        }
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */
    public native void set(String field, Date value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        if(value == null) {
            record.set(field, null);
        } else {
            var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(value);
            record.set(field, new $wnd.Date(millis));            
        }
    }-*/;

    /**
     * Return the names of the fields that are modified in this record.
     *
     * @return modified field names. Returns an empty array if no fields are modified.
     */
    public String[] getModifiedFields() {
        JavaScriptObject nativeArray = getModifiedFields(jsObj);
        return JavaScriptObjectHelper.convertToJavaStringArray(nativeArray);
    }

    public String[] getFields() {
        JavaScriptObject nativeArray = getFields(jsObj);
        return JavaScriptObjectHelper.convertToJavaStringArray(nativeArray);
    }

    private native JavaScriptObject getFields(JavaScriptObject record)/*-{
        var fields = @com.gwtext.client.util.JavaScriptObjectHelper::createJavaScriptArray()();
        var items = record.fields.items
        var cnt=items.length;
        for ( var i=0; i<cnt; ++i ){
            fields.push(items[i].name);
        }
          
        return fields;
    }-*/;

    private native JavaScriptObject getModifiedFields(JavaScriptObject record)/*-{
        if (record.modified === undefined) return  null;
        var fields = @com.gwtext.client.util.JavaScriptObjectHelper::createJavaScriptArray()();
        for(var key in record.modified) {
            fields.push(key);
        }
        return fields;
    }-*/;

    //see http://extjs.com/forum/showthread.php?t=2834&highlight=validateedit&page=2 for use
    /**
     * Usually called by the Store which owns the Record. Rejects all changes made to the Record since either creation,
     * or the last commit operation. Modified fields are reverted to their original values.  Developers should subscribe
     * to the {@link com.gwtext.client.data.event.StoreListener#onUpdate(Store, Record, com.gwtext.client.data.Record.Operation)} event
     * to have their code notified of reject operations.
     */
    public native void reject() /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.reject();
    }-*/;

    /**
     * Usually called by the Store which owns the Record. Rejects all changes made to the Record since either creation,
     * or the last commit operation. Modified fields are reverted to their original values.  Developers should subscribe
     * to the {@link com.gwtext.client.data.event.StoreListener#onUpdate(Store, Record, com.gwtext.client.data.Record.Operation)} event
     * to have their code notified of reject operations.
     *
     * @param silent true to skip notification of the owning store of the change (defaults to false)
     */
    public native void reject(boolean silent) /*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        record.reject(silent);
    }-*/;

    /**
     * Returns the field value as an Object.
     *
     * @return the data object
     */
    public native Object getDataAsObject()/*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return record.bean === undefined ? null : record.bean ;
    }-*/;

    /**
     * Returns the underlying native data representation like a Json or XML node.
     *
     * @return data as native object
     */
    public native JavaScriptObject getDataAsJsObject()/*-{
        var record = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var val = record.json || record.node;
        return val === undefined ? null : val;             
    }-*/;
}
