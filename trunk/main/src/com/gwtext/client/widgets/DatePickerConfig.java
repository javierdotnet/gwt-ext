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

/**
 * {@link com.gwtext.client.widgets.DatePicker} configuration class.
 */
public class DatePickerConfig extends ComponentConfig {

	/**
	 * True to constrain the date picker to the viewport (defaults to true).
	 *
	 * @param constrainToViewport true to constrain to view port
	 */
	public void setConstrainToViewport(boolean constrainToViewport) {
        JavaScriptObjectHelper.setAttribute(jsObj, "constrainToViewport", constrainToViewport);
    }

	/**
	 * Regular expression used to disable a pattern of dates.
	 * 
	 * @param disabledDatesRE regular expression to disable dates
	 */
	public void setDisabledDatesRE(String disabledDatesRE) {
        doSetDisabledDatesRE(jsObj, disabledDatesRE);
    }

    private native void doSetDisabledDatesRE(JavaScriptObject config, String disabledDatesRE) /*-{
        config['disabledDatesRE'] = new RegExp(disabledDatesRE);
    }-*/;

	/**
	 * The tooltip text to display when the date falls on a disabled date (defaults to "").
	 *
	 * @param disabledDatesText disabled dates text
	 */
	public void setDisabledDatesText(String disabledDatesText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDatesText", disabledDatesText);
    }

	/**
	 * An array of days to disable, 0-based. For example, [0, 6] disables Sunday and Saturday.
	 *
	 * @param disabledDays dates to disable
	 */
	public void setDisabledDays(String[] disabledDays) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDays", JavaScriptObjectHelper.convertToJavaScriptArray(disabledDays));
    }

	/**
	 * The tooltip to display when the date falls on a disabled day (defaults to "")
	 *
	 * @param disabledDaysText disabled days text
	 */
	public void setDisabledDaysText(String disabledDaysText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disabledDaysText", disabledDaysText);
    }

	/**
	 * The default date format string which can be overriden for localization support. The format must be a valid pattern (defaults to 'm/d/y').
	 *
	 * 
	 * @param format the date format
	 * @see com.gwtext.client.util.DateUtil
	 */
	public void setFormat(String format) {
        JavaScriptObjectHelper.setAttribute(jsObj, "format", format);
    }

	/**
	 * Maximum allowable date.
	 *
	 * @param maxDate the max date
	 */
	public void setMaxDate(Date maxDate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxDate", maxDate);
    }

	/**
	 * The error text to display if the maxDate validation fails (defaults to "This date is after the maximum date").
	 * 
	 * @param maxText the max error text
	 */
	public void setMaxText(String maxText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxText", maxText);
    }

	/**
	 * Minimum allowable date.
	 * 
	 * @param minDate the min date
	 */
	public void setMinDate(Date minDate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minDate", minDate);
    }

	/**
	 * The error text to display if the minDate validation fails (defaults to "This date is before the minimum date").
	 *
	 * @param minText the min error text
	 */
	public void setMinText(String minText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minText", minText);
    }

	/**
	 * An array of textual month names which can be overriden for localization support.
	 *
	 * @param monthNames the month names
	 */
	public void setMonthNames(String[] monthNames) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monthNames", JavaScriptObjectHelper.arrayConvert(monthNames));
    }

	/**
	 * The header month selector tooltip (defaults to 'Choose a month (Control+Up/Down to move years)').
	 *
	 * @param monthYearText the header month tooltip text
	 */
	public void setMonthYearText(String monthYearText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monthYearText", monthYearText);
    }

	/**
	 * The next month navigation button tooltip (defaults to 'Next Month (Control+Right)').
	 * 
	 * @param nextText the next button tooltip text
	 */
	public void setNextText(String nextText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "nextText", nextText);
    }

	/**
	 * The text to display on the ok button.
	 *
	 * @param okText the OK text
	 */
	public void setOkText(String okText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "okText", okText);
    }

	/**
	 *  The previous month navigation button tooltip (defaults to 'Previous Month (Control+Left)').
	 *
	 * @param prevText the previous month tooltip text
	 */
	public void setPrevText(String prevText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "prevText", prevText);
    }

	/**
	 * Day index at which the week should begin, 0-based (defaults to 0, which is Sunday).
	 *
	 * @param startDay the start day
	 */
	public void setStartDay(int startDay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "startDay", startDay);
    }

	/**
	 * The text to display on the button that selects the current date (defaults to "Today").
	 * 
	 * @param todayText the today text
	 */
	public void setTodayText(String todayText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "todayText", todayText);
    }

	/**
	 * The tooltip to display for the button that selects the current date (defaults to "{current date} (Spacebar)").
	 *                                                                                                               
	 * @param todayTip the tooltip for current date
	 */
	public void setTodayTip(String todayTip) {
        JavaScriptObjectHelper.setAttribute(jsObj, "todayTip", todayTip);
    }
}
