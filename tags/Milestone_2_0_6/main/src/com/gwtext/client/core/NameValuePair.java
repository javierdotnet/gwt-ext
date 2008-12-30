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
 

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

/**
 * A generic class used a various places that represents a name / value pair.
 *
 * @author Sanjiv Jivan
 */
public class NameValuePair extends JsObject {

    public static final int STRING = 0;
    public static final int BOOLEAN = 1;
    public static final int FLOAT = 2;
    public static final int INT = 3;
    public static final int DATE = 4;

    private int type = STRING;
    private static final String NAME = "name";
    private static final String VALUE = "value";

    public NameValuePair(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public NameValuePair(String name, String value) {
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, NAME, name);
        JavaScriptObjectHelper.setAttribute(jsObj, VALUE, value);
        type = STRING;
    }

    public NameValuePair(String name, Boolean value) {
        this(name, value.booleanValue());
    }
    
    public NameValuePair(String name, boolean value) {
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, NAME, name);
        JavaScriptObjectHelper.setAttribute(jsObj, VALUE, value);
        type = BOOLEAN;
    }

    public NameValuePair(String name, Float value) {
        this(name, value.floatValue());

    }
    public NameValuePair(String name, float value) {
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, NAME, name);
        JavaScriptObjectHelper.setAttribute(jsObj, VALUE, value);
        type = FLOAT;
    }

    public NameValuePair(String name, Integer value) {
        this(name, value.intValue());
    }
    
    public NameValuePair(String name, int value) {
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, NAME, name);
        JavaScriptObjectHelper.setAttribute(jsObj, VALUE, value);
        type = INT;
    }

    public NameValuePair(String name, Date value) {
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, NAME, name);
        JavaScriptObjectHelper.setAttribute(jsObj, VALUE, value);
        type = DATE;
    }

    private static NameValuePair instance(String name, String value) {
        return new NameValuePair(name, value);
    }

    public String getName() {
        return JavaScriptObjectHelper.getAttribute(jsObj, NAME);
    }

    public String getValue() {
        return JavaScriptObjectHelper.getAttribute(jsObj, VALUE);
    }

    public boolean getValueAsBoolean() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, VALUE);
    }

    public float getValueAsFloat() {
        return JavaScriptObjectHelper.getAttributeAsFloat(jsObj, VALUE);
    }

    public int getValueAsInt() {
        return JavaScriptObjectHelper.getAttributeAsInt(jsObj, VALUE);
    }

    public Date getValueAsDate() {
        return JavaScriptObjectHelper.getAttributeAsDate(jsObj, VALUE);
    }

    public int getType() {
        return type;
    }

    public static JavaScriptObject getJsObj(NameValuePair[] nameValuePairs) {
        JavaScriptObject paramObj = JavaScriptObjectHelper.createObject();
        if (nameValuePairs == null) return paramObj;

        for (int i = 0; i < nameValuePairs.length; i++) {
            NameValuePair param = nameValuePairs[i];
            switch (param.getType()) {
                case STRING: {
                    JavaScriptObjectHelper.setAttribute(paramObj, param.getName(), param.getValue());
                    break;
                }
                case BOOLEAN: {
                    JavaScriptObjectHelper.setAttribute(paramObj, param.getName(), param.getValueAsBoolean());
                    break;
                }
                case FLOAT: {
                    JavaScriptObjectHelper.setAttribute(paramObj, param.getName(), param.getValueAsFloat());
                    break;
                }
                case INT: {
                    JavaScriptObjectHelper.setAttribute(paramObj, param.getName(), param.getValueAsInt());
                    break;
                }
                case DATE: {
                    JavaScriptObjectHelper.setAttribute(paramObj, param.getName(), param.getValueAsDate());
					break;
				}
                default: {
                    JavaScriptObjectHelper.setAttribute(paramObj, param.getName(), param.getValue());
                }
            }
        }
        return paramObj;
    }
}
