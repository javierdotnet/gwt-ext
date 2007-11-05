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

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.event.DatePickerListener;

import java.util.Date;

/**
 * Simple date picker class.
 */
public class DatePicker extends Component {

    public DatePicker(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create a new Date picker using the specified condifuration.
     *
     * @param config the config
     */
    public DatePicker(DatePickerConfig config) {
        jsObj = create(jsObj, config.getJsObj());
    }

    private static native JavaScriptObject create(JavaScriptObject datePicker, JavaScriptObject config) /*-{
        return new $wnd.Ext.DatePicker(config);    
    }-*/;

    private static DatePicker instance(JavaScriptObject jsObj) {
        return new DatePicker(jsObj);
    }

    /**
     * Get the value ofa teh date picker.
     *
     * @return null if no value selected
     */
    public Date getValue() {
        long time = getValueMillis(jsObj);
        return time == -1 ? null : new Date(time);
    }

    private native long getValueMillis(JavaScriptObject dp)/*-{
        var date = dp.getValue();
        return (date == '' || date == null) ? -1 : data.getTime();
    }-*/;

    /**
     * Set the value of the date picker.
     *
     * @param date the date
     */
    public void setValue(Date date) {
        setValueMillis(jsObj, date.getTime());
    }

    private native void setValueMillis(JavaScriptObject dp, long time) /*-{
        var date = new $wnd.Date();
        date.setTime(time);
        dp.setValue(date);
    }-*/;

    /**
     * Add a Date Picker Listener.
     *
     * @param listener the listener
     */
    public native void addDatePickerListener(DatePickerListener listener) /*-{
        var componentJ = this;
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        component.addListener('select',
                function(datePicker, date) {
                    var d = @com.gwtext.client.util.DateUtil::create(J)(date.getTime());
                    listener.@com.gwtext.client.widgets.event.DatePickerListener::onSelect(Lcom/gwtext/client/widgets/DatePicker;Ljava/util/Date;)(componentJ, d);
                }
        );
    }-*/;
}
