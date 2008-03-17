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