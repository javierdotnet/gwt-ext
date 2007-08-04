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

public class Format {

    public static native String capitalize(String value)/*-{
        return $wnd.Ext.util.Format.capitalize(value);
    }-*/;

    /**
     * Format defaults to 'm/d/Y'
     *
     * @param value
     * @return
     */
    public static native String date(String value)/*-{
        return $wnd.Ext.util.Format.date(value);
    }-*/;

    public static native String date(String value, String format)/*-{
        return $wnd.Ext.util.Format.date(value, format);
    }-*/;

    public static native String ellipsis(String value, int length)/*-{
        return $wnd.Ext.util.Format.ellipsis(value, length);
    }-*/;

    public static native String htmlDecode(String value)/*-{
        return $wnd.Ext.util.Format.htmlDecode(value);
    }-*/;

    public static native String htmlEncode(String value)/*-{
        return $wnd.Ext.util.Format.htmlEncode(value);
    }-*/;

    public static native String lowercase(String value)/*-{
        return $wnd.Ext.util.Format.lowercase(value);
    }-*/;

    public static native String stripTags(String value)/*-{
        return $wnd.Ext.util.Format.stripTags(value);
    }-*/;

    public static native String substr(String value, int start, int length)/*-{
        return $wnd.Ext.util.Format.substr(value, start, length);
    }-*/;

    public static native String trim(String value)/*-{
        return $wnd.Ext.util.Format.trim(value);
    }-*/;

    public static native String undef(long value)/*-{
        return $wnd.Ext.util.Format.undef(value);
    }-*/;

    public static native String undef(float value)/*-{
        return $wnd.Ext.util.Format.undef(value);
    }-*/;

    public static native String undef(String value)/*-{
        return $wnd.Ext.util.Format.undef(value);
    }-*/;

    public static native String uppercase(String value)/*-{
        return $wnd.Ext.util.Format.uppercase(value);
    }-*/;

    public static native String usMoney(String value)/*-{
        return $wnd.Ext.util.Format.usMoney(value);
    }-*/;

    public static native String usMoney(double value)/*-{
        return $wnd.Ext.util.Format.usMoney(value);
    }-*/;

    public static native String format(String format, String value) /*-{
        return $wnd.String.format(format, value);
    }-*/;

    //ext should be taking array of strings as secord argument like Template instead of varargs
    //need hack becuase of varargs
    public static String format(String format, String[] values) {
        switch (values.length) {
            case 1:
                return format(format, values[0]);
            case 2:
                return format(format, values[0], values[1]);
            case 3:
                return format(format, values[0], values[1], values[2]);
            case 4:
                return format(format, values[0], values[1], values[2], values[3]);
            case 5:
                return format(format, values[0], values[1], values[2], values[3], values[4]);
            default:
                return format(format, values[0], values[1], values[2], values[3], values[4]);
        }
    }

    public static native String format(String format, String value1, String value2) /*-{
        return $wnd.String.format(format, value1, value2);
    }-*/;

    public static native String format(String format, String value1, String value2, String value3) /*-{
        return $wnd.String.format(format, value1, value2, value3);
    }-*/;

    public static native String format(String format, String value1, String value2, String value3, String value4) /*-{
        return $wnd.String.format(format, value1, value2, value3, value4);
    }-*/;

    public static native String format(String format, String value1, String value2, String value3, String value4, String value5) /*-{
        return $wnd.String.format(format, value1, value2, value3, value4, value5);
    }-*/;
}
