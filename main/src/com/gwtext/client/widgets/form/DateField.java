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

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Date;

public class DateField extends TriggerField {
    public DateField() {
        setJsObj(create(null));
    }

    public DateField(DateFieldConfig config) {
        super(config);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.DateField(jsObj);
    }-*/;

    public Date getValue() {
        long date = getTime(jsObj);
        return date == -1 ? null : new Date(date);
    }

    public void setValue(Date date) {
        long time = date.getTime();
        setTime(jsObj, time);
    }

    private native void setTime(JavaScriptObject df, long time)/*-{
        df.setValue(new $wnd.Date(time));
    }-*/;

    private native long getTime(JavaScriptObject df)/*-{
        //ext 1.1rc1 returns empty string.
        var val = df.getValue();
        return (val == '' || val == null || val === undefined)? -1 : df.getValue().getTime();
    }-*/;
}
