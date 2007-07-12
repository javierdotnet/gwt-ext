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

public class Record extends JsObject {
    public Record(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static Record instance(JavaScriptObject rec) {
        return new Record(rec);
    }

    public native String getId() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.id;
    }-*/;

    public native boolean isDirty() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.dirty;
    }-*/;

    public native String getAsString(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.get(field).toString();
    }-*/;

    public native void set(String field, String value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    public native int getAsInteger(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.get(field);
    }-*/;

    public native void set(String field, int value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    public native float getAsFloat(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.get(field);
    }-*/;

    public native void set(String field, float value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    public native double getAsDouble(String field) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        return record.get(field);
    }-*/;

    public native void set(String field, double value) /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.set(field, value);
    }-*/;

    //see http://extjs.com/forum/showthread.php?t=2834&highlight=validateedit&page=2 for use
    public native void reject() /*-{
        var record = this.@com.gwtext.client.core.JsObject::jsObj;
        record.reject();
    }-*/;

}
