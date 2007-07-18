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
package com.gwtext.client.form;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.DateFieldConfig;

import java.util.Date;

public class FieldTest extends GWTTestCase {
    public String getModuleName() {
        return "com.gwtext.Test";
    }

    public void testDateFieldSetValue() {
        DateField dateField = new DateField(new DateFieldConfig() {
            {
                setDisableDays(new int[]{0, 4});
                setFieldLabel("Sample Date");
            }
        });

        RootPanel.get().add(dateField);

        Date date = new Date(2007,2 ,3, 4, 5, 6);
        dateField.setValue(date);

        Date dateVal = dateField.getValue();

        assertEquals(date.getTime(), dateVal.getTime());

    }
}
