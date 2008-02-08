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

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Date field class. Following is the list of all currently supported formats:
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
public class DateFieldDef extends FieldDef {

    /**
     * Uses default date parsing via new Date(dataVal);
     *
     * @param name field name
     */
    public DateFieldDef(String name) {
        this(name, null, null);
    }

    /**
     * Create a new DateFieldDef using the specified name and date format.
     *
     * @param name the field name
     * @param dateFormat the date format
     */
    public DateFieldDef(String name, String dateFormat) {
        this(name, null, dateFormat);
    }

    /**
     * Create a new DateFieldDef using the specified name and date format.
     *
     * @param name the field name
     * @param mapping the field mapping. Depending on the Reader used, mapping could be the array index position or an XPath expression when reading from XML
     * @param dateFormat the date format
     */
    public DateFieldDef(String name, String mapping, String dateFormat) {
        jsObj = create(name, mapping, dateFormat);
    }

    /**
     * Create a new DateFieldDef using the specified name and date format.
     *
     * @param name the field name
     * @param mapping the field mapping, position based of local arrays
     * @param dateFormat the date format
     */
    public DateFieldDef(String name, int mapping, String dateFormat) {
        this(name, dateFormat, String.valueOf(mapping));
    }

    private static JavaScriptObject create(String name, String mapping, String dateFormat) {
        JavaScriptObject jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, "name", name);
        JavaScriptObjectHelper.setAttribute(jsObj, "type", "date");
        if (mapping != null) JavaScriptObjectHelper.setAttribute(jsObj, "mapping", mapping);
        if (dateFormat != null) JavaScriptObjectHelper.setAttribute(jsObj, "dateFormat", dateFormat);
        return jsObj;
    }
}
