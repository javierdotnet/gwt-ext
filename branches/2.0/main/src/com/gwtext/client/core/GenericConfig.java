/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

import com.gwtext.client.util.JavaScriptObjectHelper;

public class GenericConfig extends BaseConfig {

    public void setProperty(String property, String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, property, value);
    }

    public String getProperty(String property) {
        return JavaScriptObjectHelper.getAttribute(jsObj, property);
    }

    public void setProperty(String property, int value) {
        JavaScriptObjectHelper.setAttribute(jsObj, property, value);
    }

    public int getPropertyAsInt(String property) {
        return JavaScriptObjectHelper.getAttributeAsInt(jsObj, property);
    }

    public void setProperty(String property, boolean value) {
        JavaScriptObjectHelper.setAttribute(jsObj, property, value);
    }

    public boolean getPropertyAsBoolean(String property) {
        return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, property);
    }

    public void setProperty(String property, int[] value) {
        JavaScriptObjectHelper.setAttribute(jsObj, property, value);
    }

    public int[] getPropertyAsIntArray(String property) {
        return JavaScriptObjectHelper.getAttributeAsIntArray(jsObj, property);
    }

    public void setProperty(String property, String[] value) {
        JavaScriptObjectHelper.setAttribute(jsObj, property, value);
    }

    public String[] getPropertyAsStringArray(String property) {
        return JavaScriptObjectHelper.getAttributeAsStringArray(jsObj, property);
    }

    public void setProperty(String property, GenericConfig value) {
        JavaScriptObjectHelper.setAttribute(jsObj, property, value.getJsObj());
    }
}
