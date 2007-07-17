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

public class DateField extends Field {

    /**
     * Uses default date parsing via new Date(dataVal);
     * @param name field name
     */
    public DateField(String name) {
        this(name, null, null);
    }

    public DateField(String name, String dateFormat) {
        this(name, null, dateFormat);
    }

    public DateField(String name, String mapping, String dateFormat) {
        jsObj = create(name, mapping, dateFormat);
    }

    public DateField(String name, int mapping, String dateFormat) {
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
