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

import java.util.Date;

public class DateFieldConfig extends TriggerFieldConfig {

    public void setaltFormats(String altFormats) {
        JavaScriptObjectHelper.setAttribute(jsObj, "altFormats", altFormats);
    }

    public void setDisabledDates(String[] disabledDates) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDates", disabledDates);
    }

    public void setDisabledDatesText(String disabledDatesText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDatesText", disabledDatesText);
    }

    public void setDisabledDays(int[] disabledDays) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDays", disabledDays);
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

    public void setMinValue(String minValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minValue", minValue);
    }

    public void setMinValue(Date minValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minValue", minValue);
    }

    public void setMinText(String minText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minText", minText);
    }

    public void setMaxValue(String maxValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxValue", maxValue);
    }

    public void setMaxValue(Date maxValue) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxValue", maxValue);
    }

    public void setMaxText(String maxText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxText", maxText);
    }
}
