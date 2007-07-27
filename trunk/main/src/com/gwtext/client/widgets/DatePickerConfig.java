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
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

public class DatePickerConfig extends ComponentConfig {

    public void setCancelText(String cancelText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cancelText", cancelText);
    }

    public void setConstrainToViewport(boolean constrainToViewport) {
        JavaScriptObjectHelper.setAttribute(jsObj, "constrainToViewport", constrainToViewport);
    }

    public void setDayNames(String[] dayNames) {
        JavaScriptObjectHelper.setAttribute(jsObj, "dayNames", JavaScriptObjectHelper.convertToJavaScriptArray(dayNames));
    }

    public void setDisabledDatesRE(String disabledDatesRE) {
        doSetDisabledDatesRE(jsObj, disabledDatesRE);
    }

    private native void doSetDisabledDatesRE(JavaScriptObject config, String disabledDatesRE) /*-{
        config['disabledDatesRE'] = new RegExp(disabledDatesRE);
    }-*/;

    public void setDisabledDatesText(String disabledDatesText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDatesText", disabledDatesText);
    }

    public void setDisabledDays(String[] disabledDays) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDays", JavaScriptObjectHelper.convertToJavaScriptArray(disabledDays));
    }

    public void setDisabledDaysText(String disabledDaysText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDaysText", disabledDaysText);
    }

    public void setFormat(String format) {
        JavaScriptObjectHelper.setAttribute(jsObj, "format", format);
    }

    public void setMaxDate(Date maxDate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxDate", maxDate);
    }

    public void setMaxText(String maxText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxText", maxText);
    }

    public void setMinDate(Date minDate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minDate", minDate);
    }

    public void setMinText(String minText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minText", minText);
    }

    public void setMonthNames(String[] monthNames) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monthNames", JavaScriptObjectHelper.arrayConvert(monthNames));
    }

    public void setMonthYearText(String monthYearText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monthYearText", monthYearText);
    }

    public void setNextText(String nextText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "nextText", nextText);
    }

    public void setOkText(String okText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "okText", okText);
    }

    public void setPrevText(String prevText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "prevText", prevText);
    }

    public void setStartDay(int startDay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "startDay", startDay);
    }

    public void setTodayText(String todayText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "todayText", todayText);
    }

    public void setTodayTip(String todayTip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "todayTip", todayTip);
    }
}
