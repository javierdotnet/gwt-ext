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

import com.gwtext.client.util.JavaScriptObjectHelper;

public class DateFieldConfig extends TriggerFieldConfig {

    public void setDisableDates(String[] disableDates) {
        JavaScriptObjectHelper.setAttributeAsStringArray(jsObj, "disableDates", disableDates);
    }

    public void setDisabledDatesText(String disabledDatesText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDatesText", disabledDatesText);
    }

    public void setDisableDays(int[] disableDays) {
        JavaScriptObjectHelper.setAttributeAsIntArray(jsObj, "disableDays", disableDays);
    }

    public void setDisabledDaysText(String disabledDaysText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDaysText", disabledDaysText);
    }

    public void setFormat(String format) {
        JavaScriptObjectHelper.setAttribute(jsObj, "format", format);
    }

    public void setInvalidText(String invalidText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "invalidText", invalidText);
    }


    public void setMaxText(String maxText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxText", maxText);
    }

    public void setMaxValue(String maxValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxValue", maxValue);
    }

    public void setMinValue(String minValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minValue", minValue);
    }


}
