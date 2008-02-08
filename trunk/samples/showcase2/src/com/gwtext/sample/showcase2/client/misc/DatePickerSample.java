/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.misc;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.DatePicker;
import com.gwtext.client.widgets.event.DatePickerListenerAdapter;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.sample.showcase2.client.ShowcasePanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.Date;

public class DatePickerSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/misc/DatePickerSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            VerticalPanel verticalPanel = new VerticalPanel();
            verticalPanel.setSpacing(15);

            final TextField textField = new TextField("Date");
            textField.setWidth(200);

            DatePicker datePicker = new DatePicker();
            datePicker.setValue(new Date(101,1,2));
            datePicker.setTodayText("Now!!");
            datePicker.addListener(new DatePickerListenerAdapter() {
                public void onSelect(DatePicker dataPicker, Date date) {
                    textField.setValue(date.toString());
                }
            });
            verticalPanel.add(datePicker);
            verticalPanel.add(textField);

            panel.add(verticalPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "A customizable DatePicker. You can selectively enable / disable date ranges and attach listeners to determine the date selected by the user.";
    }    
}