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

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class NameValuePair extends JsObject {

    public static final int STRING = 0;
    public static final int BOOLEAN = 1;
    public static final int FLOAT = 2;
    public static final int INT = 3;

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

    public NameValuePair(String name, boolean value) {
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, NAME, name);
        JavaScriptObjectHelper.setAttribute(jsObj, VALUE, value);
        type = BOOLEAN;
    }

    public NameValuePair(String name, float value) {
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, NAME, name);
        JavaScriptObjectHelper.setAttribute(jsObj, VALUE, value);
        type = FLOAT;
    }

    public NameValuePair(String name, int value) {
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, NAME, name);
        JavaScriptObjectHelper.setAttribute(jsObj, VALUE, value);
        type = INT;
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
                default: {
                    JavaScriptObjectHelper.setAttribute(paramObj, param.getName(), param.getValue());
                }
            }
        }
        return paramObj;
    }
}
