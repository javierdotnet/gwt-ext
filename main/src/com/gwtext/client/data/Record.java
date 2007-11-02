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
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var id = record.id;
        return (id == null || id === undefined) ? null : id.toString();
    }-*/;

    /**
     *  The Records modified state.
     *
     * @return true if this record has been modified
     */
    public native boolean isDirty() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.dirty;
    }-*/;

    /**
     * Creates a copy of this record.
     *
     * @return copy of this Record
     */
    public native Record copy() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
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
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var record2 = record.copy(id);
        return @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record2);
    }-*/;

    /**
     * Usually called by the Store which owns the Record. Commits all changes made to the Record since either creation,
     * or the last commit operation. Developers should subscribe to {@link com.gwtext.client.data.event.StoreListener#onUpdate(Store, Record, com.gwtext.client.data.Record.Operation)} event
     * to have their code notified of commit operations.
     */
    public native void commit() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.commit();
    }-*/;


    //todo throw exception if field is invalid as opposed to null value for field?
    //throw new Error("JS Error Object");
    /**
     * REtrund the field value as String.
     *
     * @param field the field name
     * @return the field value
     */
    public native String getAsString(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var value = record.get(field);
        //todo?
        //if (value === undefined) throw new Error("Invalid field " + field);
        return (value === undefined || value == null ) ? null : value.toString();
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */
    public native void set(String field, String value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    /**
     * Returns the Records value as an integer.
     *
     * @param field the field name
     * @return the field value
     */
    public native int getAsInteger(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
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
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    /**
     * Returns the Records value as a float.
     *
     * @param field the field name
     * @return the field value
     */
    public native float getAsFloat(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var value = record.get(field);
        return (value === undefined || value == null ) ? null : parseFloat(value);
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */
    public native void set(String field, float value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    /**
     * Returns the Records value as a double.
     *
     * @param field the field name
     * @return the field value
     */
    public native double getAsDouble(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var value = record.get(field);
        return (value === undefined || value == null ) ? null : parseFloat(value);
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */
    public native void set(String field, double value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
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
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
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
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    /**
     * Set the Record's ID.
     *
     * @param id the record ID
     */
    public native void setId(String id) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.id = id;
    }-*/;

    /**
     * Return the fields value as a Date.
     *
     * @param field the field name
     * @return the field value
     */
    public native Date getAsDate(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var val = record.get(field);
        if(val == null || val === undefined || val == '') {
            return null;
        } else {
            return @com.gwtext.client.util.DateUtil::create(J)(val.getTime());
        }
    }-*/;

    /**
     * Sets the fields value.
     *
     * @param field the field name
     * @param value the field value
     */    
    public native void set(String field, Date value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        if(value == null) {
            record.set(field, null);
        } else {
            var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(value);
            record.set(field, new $wnd.Date(millis));            
        }
    }-*/;

    //see http://extjs.com/forum/showthread.php?t=2834&highlight=validateedit&page=2 for use
    /**
     * Usually called by the Store which owns the Record. Rejects all changes made to the Record since either creation,
     * or the last commit operation. Modified fields are reverted to their original values.  Developers should subscribe
     * to the {@link com.gwtext.client.data.event.StoreListener#onUpdate(Store, Record, com.gwtext.client.data.Record.Operation)} event
     * to have their code notified of reject operations.
     *
     */
    public native void reject() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.reject();
    }-*/;

    /**
     * Returns the field value as an Object.
     *
     * @return the data object
     */
    public native Object getDataAsObject()/*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.bean === undefined ? null : record.bean ;
    }-*/;

    /**
     * Returns the underlying native data representation like a Json or XML node.
     *
     * @return data as native object
     */
    public native JavaScriptObject getDataAsJsObject()/*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var val = record.json || record.node;
        return val === undefined ? null : val;             
    }-*/;
}
