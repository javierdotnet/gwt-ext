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

    public static Date create(long time) {
        return new Date(time);
    }

    public static long getTime(Date date) {
        return date.getTime();
    }

    public static native String format(Date date, String format) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        return new $wnd.Date(millis).format(format);
    }-*/;

    public static native Date parseDate(String input, String format)/*-{
        var date = $wnd.Date.parseDate(input, format);
        return @com.gwtext.client.util.DateUtil::create(J)(date.getTime());
    }-*/;

    public static native Date add(Date date, Interval interval, int value)/*-{
        var intervalJS = interval.@com.gwtext.client.util.DateUtil.Interval::getInterval()();
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = dateJS.add(intervalJS, value);
        return  @com.gwtext.client.util.DateUtil::create(J)(newDate.getTime());
    }-*/;

    public static native Date clearTime(Date date)/*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = date.clearTime();
        return @com.gwtext.client.util.DateUtil::create(J)(newDate.getTime());
    }-*/;

    public static native int getDayOfYear(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getDayOfYear();
    }-*/;

    public static native int getDaysInMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getDaysInMonth();
    }-*/;

    public static native Date getFirstDateOfMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = dateJS.getFirstDateOfMonth();
        return @com.gwtext.client.util.DateUtil::create(J)(newDate.getTime());
    }-*/;

    public static native int getFirstDayOfMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getFirstDayOfMonth();
    }-*/;

    public static native String getGMTOffset(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getGMTOffset();
    }-*/;

    public static native Date getLastDateOfMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        var newDate = dateJS.getLastDateOfMonth();
        return @com.gwtext.client.util.DateUtil::create(J)(newDate.getTime());
    }-*/;

    public static native int getLastDayOfMonth(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getLastDayOfMonth();
    }-*/;

    public static native String getTimezone(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.getTimezone();
    }-*/;

    //todo ext function incorrect : see http://extjs.com/forum/showthread.php?t=9727
    public static native int getWeekOfYear(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        //returns string
        var woy = dateJS.getWeekOfYear();
        return @java.lang.Integer::parseInt(Ljava/lang/String;)(woy);
    }-*/;

    public static native boolean isLeapYear(Date date) /*-{
        var millis = @com.gwtext.client.util.DateUtil::getTime(Ljava/util/Date;)(date);
        var dateJS = new $wnd.Date(millis);
        return dateJS.isLeapYear();
    }-*/;

}
