/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class PieChart extends CartesianChart {

    protected native JavaScriptObject createChart(String containerID, JavaScriptObject dataStore, JavaScriptObject config)/*-{
        return new $wnd.YAHOO.widget.PieChart(containerID, dataStore, config);
    }-*/;

    /**
     * Set the categoryField.
     *
     * @param categoryField the categoryField
     */
    public void setCategoryField(String categoryField) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "categoryField", categoryField);
    }

    /**
     * Return the categoryField.
     *
     * @return the categoryField
     */
    public String getCategoryField() {
        return JavaScriptObjectHelper.getAttribute(chartConfig, "categoryField");
    }

    public void setDataField(String dataField) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "dataField", dataField);
    }
}