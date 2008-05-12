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
 

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Field that represents integer data.
 *
 * @author Sanjiv Jivan
 */
public class IntegerFieldDef extends FieldDef {

    /**
     * Construct a new IntegerFieldDef.
     *
     * @param name the name of field
     */
    public IntegerFieldDef(String name) {
        this(name, null, null);
    }

    /**
     * Construct a new IntegerFieldDef
     *
     * @param name    the name of field
     * @param mapping the field mapping. Depending on the Reader used, mapping could be the array index position or an XPath expression when reading from XML
     */
    public IntegerFieldDef(String name, String mapping) {
        this(name, mapping, null);
    }

    /**
     * Construct a new IntegerFieldDef
     *
     * @param name    the name of field
     * @param mapping the field mapping. Depending on the Reader used, mapping could be the array index position or an XPath expression when reading from XML
     */
    public IntegerFieldDef(String name, int mapping) {
        this(name, mapping, null);
    }

    /**
     * Construct a new IntegerFieldDef
     *
     * @param name      the field name
     * @param mapping   the field mapping. Depending on the Reader used, mapping could be the array index position or an XPath expression when readinf from XML
     * @param converter format the incoming data before processing it
     */
    public IntegerFieldDef(String name, String mapping, Converter converter) {
        jsObj = create(name, mapping, converter);
    }

    /**
     * Construct a new IntegerFieldDef
     *
     * @param name      the field name
     * @param mapping   the field mapping. Depending on the Reader used, mapping could be the array index position or an XPath expression when readinf from XML
     * @param converter format the incoming data before processing it
     */
    public IntegerFieldDef(String name, int mapping, Converter converter) {
        this(name, String.valueOf(mapping), converter);
    }

    private static JavaScriptObject create(String name, String mapping, Converter converter) {
        JavaScriptObject jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, "name", name);
        JavaScriptObjectHelper.setAttribute(jsObj, "type", "int");
        if (mapping != null) JavaScriptObjectHelper.setAttribute(jsObj, "mapping", mapping);
        if (converter != null) setConverter(jsObj, converter);
        return jsObj;
    }
}
