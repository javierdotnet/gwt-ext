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
 
package com.gwtext.client.form;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.widgets.form.DateField;

import java.util.Date;

public class FieldTest extends GWTTestCase {
    public String getModuleName() {
        return "com.gwtext.Test";
    }

    public void testDateFieldSetValue() {
        DateField dateField = new DateField();
        dateField.setDisabledDates(new String[]{"0", "4"});
        dateField.setFieldLabel("Sample Date");

        RootPanel.get().add(dateField);

        //Date date = new Date(2007,2 ,3, 4, 5, 6);
        Date date = new Date(2007, 2, 3, 0, 0, 0);
        dateField.setValue(date);

        Date dateVal = dateField.getValue();

        assertEquals(date.getTime(), dateVal.getTime());
    }
}
