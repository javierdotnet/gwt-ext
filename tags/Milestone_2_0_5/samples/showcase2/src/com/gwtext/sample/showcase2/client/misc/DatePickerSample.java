/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
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