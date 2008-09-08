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
 
package com.gwtext.client.widgets.chart.yui;

import com.gwtext.client.core.GenericConfig;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 *
 * @author Sanjiv Jivan
 */
public class SeriesDefX extends SeriesDef {

    public SeriesDefX() {
        jsObj = JavaScriptObjectHelper.createObject();
    }

    public SeriesDefX(String displayName, String yField) {
        jsObj = JavaScriptObjectHelper.createObject();
        setXField(yField);
        setDisplayName(displayName);
    }

    public SeriesDefX(String displayName, String yField, GenericConfig style) {
        jsObj = JavaScriptObjectHelper.createObject();
        setXField(yField);
        setDisplayName(displayName);
        setStyle(style);
    }

    /**
     * Set the xField.
     *
     * @param xField the xField
     */
    public void setXField(String xField) {
        JavaScriptObjectHelper.setAttribute(jsObj, "xField", xField);
    }

    /**
     * Return the xField.
     *
     * @return the xField
     */
    public String getXField() {
        return JavaScriptObjectHelper.getAttribute(jsObj, "xField");
    }

    public void setType(ChartType type) {
        JavaScriptObjectHelper.setAttribute(jsObj, "type", type.getType());
    }

    /**
     * Set the displayName.
     *
     * @param displayName the displayName
     */
    public void setDisplayName(String displayName) {
        JavaScriptObjectHelper.setAttribute(jsObj, "displayName", displayName);
    }

    /**
     * Return the displayName.
     *
     * @return the displayName
     */
    public String getDisplayName() {
        return JavaScriptObjectHelper.getAttribute(jsObj, "displayName");
    }

    /**
     * Set the style.
     *
     * @param style the style
     */
    public void setStyle(GenericConfig style) {
        JavaScriptObjectHelper.setAttribute(jsObj, "style", style.getJsObj());
    }


}