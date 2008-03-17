/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

import com.gwtext.client.core.GenericConfig;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class SeriesDefY extends SeriesDef {

    public SeriesDefY() {
        jsObj = JavaScriptObjectHelper.createObject();
    }

    public SeriesDefY(String displayName, String yField) {
        jsObj = JavaScriptObjectHelper.createObject();
        setYField(yField);
        setDisplayName(displayName);
    }

    public SeriesDefY(String displayName, String yField, GenericConfig style) {
        jsObj = JavaScriptObjectHelper.createObject();
        setYField(yField);
        setDisplayName(displayName);
        setStyle(style);
    }

    /**
     * Set the yField.
     *
     * @param yField the yField
     */
    public void setYField(String yField) {
        JavaScriptObjectHelper.setAttribute(jsObj, "yField", yField);
    }

    /**
     * Return the yField.
     *
     * @return the yField
     */
    public String getYField() {
        return JavaScriptObjectHelper.getAttribute(jsObj, "yField");
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
