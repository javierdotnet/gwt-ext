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
 

package com.gwtext.client.util;

/**
 * Reusable data formatting functions.
 *
 * @author Sanjiv Jivan
 */
public class Format {

    /**
     * Parse a value into a formatted date using the specified format pattern. Format defaults to
     * 'm/d/Y'.
     *
     * @param value the date string
     * @return the formatted date string
     */
    public static native String date(String value)/*-{
        return $wnd.Ext.util.Format.date(value);
    }-*/;

    /**
     * Parse a value into a formatted date using the specified format pattern.
     *
     * @param value  the value to format
     * @param format Any valid date format string (defaults to 'm/d/Y')
     * @return the formatted date string
     */
    public static native String date(String value, String format)/*-{
        return $wnd.Ext.util.Format.date(value, format);
    }-*/;

    /**
     * Truncate a string and add an ellipsis ('...') to the end if it exceeds the specified length.
     *
     * @param value  the string to truncate
     * @param length the maximum length to allow before truncating
     * @return the converted text
     */
    public static native String ellipsis(String value, int length)/*-{
        return $wnd.Ext.util.Format.ellipsis(value, length);
    }-*/;

    /**
     * Convert certain characters (&, <, >, and ') from their HTML character equivalents.
     *
     * @param value the string to decode
     * @return the decoded text
     */
    public static native String htmlDecode(String value)/*-{
        return $wnd.Ext.util.Format.htmlDecode(value);
    }-*/;

    /**
     * Convert certain characters (&, <, >, and ') to their HTML character equivalents for literal display in web pages.
     *
     * @param value the string to encode
     * @return the encoded text
     */
    public static native String htmlEncode(String value)/*-{
        return $wnd.Ext.util.Format.htmlEncode(value);
    }-*/;

    /**
     * Strips all HTML tags.
     *
     * @param value the text from which to strip tags
     * @return the stripped text
     */
    public static native String stripTags(String value)/*-{
        return $wnd.Ext.util.Format.stripTags(value);
    }-*/;

    /**
     * Strips all script tags.
     *
     * @param text the text from which to strip script tags
     * @return the stripped text
     */
    public static native String stripScripts(String text)/*-{
        return $wnd.Ext.util.Format.stripScripts(text);
    }-*/;

    /**
     * Simple format for a file size (xxx bytes, xxx KB, xxx MB).
     *
     * @param size the numeric value to format
     * @return the formatted file size
     */
    public static native String fileSize(double size)/*-{
        return $wnd.Ext.util.Format.fileSize(size);
    }-*/;

    /**
     * Format a number as US currency.
     *
     * @param value the value value to format
     * @return the formatted currency string
     */
    public static native String usMoney(String value)/*-{
        return $wnd.Ext.util.Format.usMoney(value);
    }-*/;

    /**
     * Format a number as US currency.
     *
     * @param value the numeric value to format
     * @return the formatted currency string
     */
    public static native String usMoney(double value)/*-{
        return $wnd.Ext.util.Format.usMoney(value);
    }-*/;

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value  the value to replace token {0}
     * @return the formatted string
     */
    public static String format(String format, int value) {
        return format(format, value + "");
    }

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value  the value to replace token {0}
     * @return the formatted string
     */
    public static native String format(String format, String value) /*-{
        return $wnd.String.format(format, value);
    }-*/;

    //ext should be taking array of strings as secord argument like Template instead of varargs
    //need hack becuase of varargs
    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param values the value to replace token {0}, {1}, ...
     * @return the formatted string
     */
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
            case 6:
                return format(format, values[0], values[1], values[2], values[3], values[4], values[5]);
            case 7:
                return format(format, values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
            default:
                return format(format, values[0], values[1], values[2], values[3], values[4]);
        }
    }

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value1 the value to replace token {0}
     * @param value2 the value to replace token {1}
     * @return the formatted string
     */
    public static String format(String format, int value1, int value2) {
        return format(format,  value1 +"",  value2 + "");
    }

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value1 the value to replace token {0}
     * @param value2 the value to replace token {1}
     * @return the formatted string
     */
    public static native String format(String format, String value1, String value2) /*-{
        return $wnd.String.format(format, value1, value2);
    }-*/;

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value1 the value to replace token {0}
     * @param value2 the value to replace token {1}
     * @param value3 the value to replace token {2}
     * @return the formatted string
     */
    public static String format(String format, int value1, int value2, int value3) {
        return format(format, value1 +"", value2 +"", value3 + "");
    }

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value1 the value to replace token {0}
     * @param value2 the value to replace token {1}
     * @param value3 the value to replace token {2}
     * @return the formatted string
     */
    public static native String format(String format, String value1, String value2, String value3) /*-{
        return $wnd.String.format(format, value1, value2, value3);
    }-*/;

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value1 the value to replace token {0}
     * @param value2 the value to replace token {1}
     * @param value3 the value to replace token {2}
     * @param value4 the value to replace token {3}
     * @return the formatted string
     */
    public static native String format(String format, String value1, String value2, String value3, String value4) /*-{
        return $wnd.String.format(format, value1, value2, value3, value4);
    }-*/;

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value1 the value to replace token {0}
     * @param value2 the value to replace token {1}
     * @param value3 the value to replace token {2}
     * @param value4 the value to replace token {3}
     * @param value5 the value to replace token {4}
     * @return the formatted string
     */
    public static native String format(String format, String value1, String value2, String value3, String value4, String value5) /*-{
        return $wnd.String.format(format, value1, value2, value3, value4, value5);
    }-*/;

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value1 the value to replace token {0}
     * @param value2 the value to replace token {1}
     * @param value3 the value to replace token {2}
     * @param value4 the value to replace token {3}
     * @param value5 the value to replace token {4}
     * @param value6 the value to replace token {5}
     * @return the formatted string
     */
    public static native String format(String format, String value1, String value2, String value3, String value4, String value5, String value6) /*-{
        return $wnd.String.format(format, value1, value2, value3, value4, value5, value6);
    }-*/;

    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens. Each token must be unique, and must increment in the format {0}, {1}, etc.
     *
     * @param format the tokenized string to be formatted
     * @param value1 the value to replace token {0}
     * @param value2 the value to replace token {1}
     * @param value3 the value to replace token {2}
     * @param value4 the value to replace token {3}
     * @param value5 the value to replace token {4}
     * @param value6 the value to replace token {5}
     * @param value7 the value to replace token {6}
     * @return the formatted string
     */
    public static native String format(String format, String value1, String value2, String value3, String value4, String value5, String value6, String value7) /*-{
        return $wnd.String.format(format, value1, value2, value3, value4, value5, value6, value7);
    }-*/;


    /**
     * Pads the left side of a string with a specified character. This is especially useful for normalizing number and date strings.
     * <p/>
     * <pre>
     *  String val = Format.leftPad("123", 5, "0");
     *  //val now containts the String "00123"
     * </pre>
     *
     * @param string the original string
     * @param size   the total length of the output string
     * @return the padded string
     */
    public static native String leftPad(String string, int size) /*-{
        return $wnd.String.leftPad(string, size);
    }-*/;

    /**
     * Pads the left side of a string with a specified character. This is especially useful for normalizing number and date strings.
     * <p/>
     * <pre>
     *  String val = Format.leftPad("123", 5, "0");
     *  //val now containts the String "00123"
     * </pre>
     *
     * @param string    the original string
     * @param size      the total length of the output string
     * @param character he character with which to pad the original string (defaults to empty string " ")
     * @return the padded string
     */
    public static native String leftPad(String string, int size, String character) /*-{
        return $wnd.String.leftPad(string, size, character);
    }-*/;
}
