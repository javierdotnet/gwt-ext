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

import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 *
 * @author Sanjiv Jivan
 */
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

    public void setProperty(String property, Object value) {
        JavaScriptObjectHelper.setAttribute(jsObj, property, value);
    }

    public Object getPropertyAsObject(String property) {
        return JavaScriptObjectHelper.getAttributeAsObject(jsObj, property);
    }
}
