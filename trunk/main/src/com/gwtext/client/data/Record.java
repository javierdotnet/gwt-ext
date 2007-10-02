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

public class Record extends JsObject {

    public Record(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static Record instance(JavaScriptObject rec) {
        return new Record(rec);
    }

    public native String getId() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var id = record.id;
        return (id == null || id === undefined) ? null : id.toString();
    }-*/;

    public native boolean isDirty() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.dirty;
    }-*/;

    public native Record copy() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var record2 = record.copy();
        return @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record2);
    }-*/;

    public native Record copy(String id) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var record2 = record.copy(id);
        return @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record2);
    }-*/;

    public native void commit() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.commit();
    }-*/;


    //todo throw exception if field is invalid as opposed to null value for field?
    //throw new Error("JS Error Object");
    public native String getAsString(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var value = record.get(field);
        //todo?
        //if (value === undefined) throw new Error("Invalid field " + field);
        return (value === undefined || value == null ) ? null : value.toString();
    }-*/;

    public native void set(String field, String value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    public native int getAsInteger(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var value =  record.get(field);
        return (value === undefined || value == null ) ? 0 : value;
    }-*/;

    public native void set(String field, int value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    public native float getAsFloat(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var value = record.get(field);
        return (value === undefined || value == null ) ? null : value;
    }-*/;

    public native void set(String field, float value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    public native double getAsDouble(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var value = record.get(field);
        return (value === undefined || value == null ) ? null : value;
    }-*/;

    public native void set(String field, double value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    public native boolean getAsBoolean(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var value = record.get(field);
        return (value === undefined || value == null) ? false : value;
    }-*/;

    public native void set(String field, boolean value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    public native void setId(String id) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.id = id;
    }-*/;

    public native Date getAsDate(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var val = record.get(field);
        if(val == null || val === undefined || val == '') {
            return null;
        } else {
            return @com.gwtext.client.util.DateUtil::create(J)(val.getTime());
        }
    }-*/;

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
    public native void reject() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.reject();
    }-*/;

    public native Object getDataAsObject()/*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.bean === undefined ? null : record.bean ;
    }-*/;

    public native JavaScriptObject getDataAsJsObject()/*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        var val = record.json || record.node;
        return val === undefined ? null : val;             
    }-*/;

    public native void commitData()/*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.commitData();             
    }-*/;
}
