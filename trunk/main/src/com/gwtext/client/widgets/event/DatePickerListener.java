/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.DatePicker;

import java.util.Date;

/**
 * {@link com.gwtext.client.widgets.DatePicker} listener.
 */
public interface DatePickerListener extends ComponentListener {

    /**
     * Fires when a date is selected.
     *
     * @param dataPicker this
     * @param date       the selected date
     */
    void onSelect(DatePicker dataPicker, Date date);
}
