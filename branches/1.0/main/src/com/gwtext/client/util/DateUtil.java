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

package com.gwtext.client.util;

import java.util.Date;

/**
 * The date parsing and format syntax is a subset of PHP's date() function, and the formats that are supported will provide results equivalent to their PHP versions. Following is the list of all currently supported formats:
 *
 *
 * <pre>
 *
 * Sample date:
 * 'Wed Jan 10 2007 15:05:01 GMT-0600 (Central Standard Time)'
 *
 * Format  Output      Description
 * ------  ----------  --------------------------------------------------------------
 *   d      10         Day of the month, 2 digits with leading zeros
 *   D      Wed        A textual representation of a day, three letters
 *   j      10         Day of the month without leading zeros
 *   l      Wednesday  A full textual representation of the day of the week
 *   S      th         English ordinal day of month suffix, 2 chars (use with j)
 *   w      3          Numeric representation of the day of the week
 *   z      9          The julian date, or day of the year (0-365)
 *   W      01         ISO-8601 2-digit week number of year, weeks starting on Monday (00-52)
 *   F      January    A full textual representation of the month
 *   m      01         Numeric representation of a month, with leading zeros
 *   M      Jan        Month name abbreviation, three letters
 *   n      1          Numeric representation of a month, without leading zeros
 *   t      31         Number of days in the given month
 *   L      0          Whether it's a leap year (1 if it is a leap year, else 0)
 *   Y      2007       A full numeric representation of a year, 4 digits
 *   y      07         A two digit representation of a year
 *   a      pm         Lowercase Ante meridiem and Post meridiem
 *   A      PM         Uppercase Ante meridiem and Post meridiem
 *   g      3          12-hour format of an hour without leading zeros
 *   G      15         24-hour format of an hour without leading zeros
 *   h      03         12-hour format of an hour with leading zeros
 *   H      15         24-hour format of an hour with leading zeros
 *   i      05         Minutes with leading zeros
 *   s      01         Seconds, with leading zeros
 *   O      -0600      Difference to Greenwich time (GMT) in hours
 *   T      CST        Timezone setting of the machine running the code
 *   Z      -21600     Timezone offset in seconds (negative if west of UTC, positive if east)
 * </pre>
 */

public class DateUtil {

    public static class Interval {
        private String interval;

        private Interval(String direction) {
            this.interval = direction;
        }

        public String getInterval() {
            return interval;
        }
    }

    public static Interval MILLI = new Interval("ms");
    public static Interval SECOND = new Interval("s");
    public static Interval MINUTE = new Interval("mi");
    public static Interval HOUR = new Interval("h");
    public static Interval DAY = new Interval("d");
    public static Interval MONTH = new Interval("mo");
    public static Interval YEAR = new Interval("y");

    /**
     * Allocates a <code>Date</code> object and initializes it to represent the specified number of milliseconds since the
     * standard base time known as "the epoch", namely January 1, 1970, 00:00:00 GMT.
     *
     * @param time the time in milliseconds
     * @return date
     */
    public static Date create(long time) {
        return new Date(time);
    }

    /**
     * Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object.
     *
     * @param date the date
     * @return time in milliseconds
     */
    public static long getTime(Date date) {
        return date.getTime();
    }

    /**
     * Formats a date given the supplied format string.
     *
     * @param date the date
     * @param format the format string
     * @return the formatted date
     */
    public static native String format(Date date, String format) /*-{
        if(date == null) return "";
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        return new $wnd.Date(millis).format(format);
    }-*/;

    /**
     * Parses the passed string using the specified format. Note that this function expects dates in normal calendar format,
     * meaning that months are 1-based (1 = January) and not zero-based like in JavaScript dates. Any part of the date format
     *  that is not specified will default to the current date value for that part. Time parts can also be specified, but default to 0.
     * Keep in mind that the input date string must precisely match the specified format string or the parse operation will fail.
     *
     * @param input the unparsed date as a string
     * @param format the format string
     * @return the parsed date
     */
    public static native Date parseDate(String input, String format)/*-{
        var date = $wnd.Date.parseDate(input, format);
        return @com.gwtext.client.util.DateUtil::create(J)(date.getTime());
    }-*/;

    /**
     * Provides a convenient method of performing basic date arithmetic. This method does not modify the Date instance
     * being called - it creates and returns a new Date instance containing the resulting date value.
     *
     * @param date the date
     * @param interval the interval enum
     * @param value the value to add
     * @return the new Date
     */
    public static native Date add(Date date, Interval interval, int value)/*-{
        var intervalJS = interval.@com.gwtext.client.util.DateUtil.Interval::getInterval()();
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = dateJS.add(intervalJS, value);
        return  @com.gwtext.client.util.DateUtil::create(J)(newDate.getTime());
    }-*/;

    /**
     * Clears any time information from this date.
     *
     * @param date the date
     * @return the new date
     */
    public static native Date clearTime(Date date)/*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = date.clearTime();
        return @com.gwtext.client.util.DateUtil::create(J)(newDate.getTime());
    }-*/;

    /**
     * Get the numeric day number of the year, adjusted for leap year.
     *
     * @param date the date
     * @return 0 through 364 (365 in leap years)
     */
    public static native int getDayOfYear(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getDayOfYear();
    }-*/;

    /**
     * Get the number of days in the current month, adjusted for leap year.
     * 
     * @param date the date
     * @return the number of days in the month
     */
    public static native int getDaysInMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getDaysInMonth();
    }-*/;

    /**
     * Get the first date of this date's month
     *
     * @param date the date
     * @return the new date
     */
    public static native Date getFirstDateOfMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = dateJS.getFirstDateOfMonth();
        return @com.gwtext.client.util.DateUtil::create(J)(newDate.getTime());
    }-*/;

    /**
     * Get the first day of the current month, adjusted for leap year. The returned value is the numeric day index within the week (0-6).
     *
     * @param date the date
     * @return the day number (0-6)
     */
    public static native int getFirstDayOfMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getFirstDayOfMonth();
    }-*/;

    /**
     * Get the offset from GMT of the current date.
     * 
     * @param date the date
     * @return the 4-character offset string prefixed with + or - (e.g. '-0600')
     */
    public static native String getGMTOffset(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getGMTOffset();
    }-*/;

    /**
     * Get the last date of this date's month.
     *
     * @param date the date
     * @return the new date
     */
    public static native Date getLastDateOfMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = dateJS.getLastDateOfMonth();
        return @com.gwtext.client.util.DateUtil::create(J)(newDate.getTime());
    }-*/;

    /**
     * Get the last day of the current month, adjusted for leap year. The returned value is the numeric day index within the week (0-6).
     *
     * @param date the date
     * @return the day number (0-6)
     */
    public static native int getLastDayOfMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getLastDayOfMonth();
    }-*/;

    /**
     * Get the timezone abbreviation of the current date.
     * 
     * @param date the date
     * @return the abbreviated timezone name (e.g. 'CST')
     */
    public static native String getTimezone(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getTimezone();
    }-*/;

    //todo ext function incorrect : see http://extjs.com/forum/showthread.php?t=9727
    /**
     * Get the string representation of the numeric week number of the year.
     *
     * @param date the date
     * @return 0 through 52
     */
    public static native int getWeekOfYear(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        //returns string
        var woy = dateJS.getWeekOfYear();
        return @java.lang.Integer::parseInt(Ljava/lang/String;)(woy);
    }-*/;

    /**
     * Whether or not the current date is in a leap year.
     *
     * @param date the date
     * @return true if date is in a leap year
     */
    public static native boolean isLeapYear(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.isLeapYear();
    }-*/;

}
