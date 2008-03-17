/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.Function;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.DOMUtil;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Panel;

public abstract class CartesianChart extends ChartPanel {



    public CartesianChart() {
    }

    public CartesianChart(Store store) {
        this.store = store;
    }

    /**
     * Set the xAxis.
     *
     * @param xAxis the xAxis
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setXAxis(Axis xAxis) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "xAxis", xAxis.getJsObj());
    }

    /**
     * Set the xField.
     *
     * @param xField the xField
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setXField(String xField) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "xField", xField);
    }

    /**
     * Return the xField.
     *
     * @return the xField
     */
    public String getXField() {
        return JavaScriptObjectHelper.getAttribute(chartConfig, "xField");
    }

    /**
     * Set the yAxis.
     *
     * @param yAxis the yAxis
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setYAxis(Axis yAxis) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "yAxis", yAxis.getJsObj());
    }

    /**
     * Set the yField.
     *
     * @param yField the yField
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setYField(String yField) {
        JavaScriptObjectHelper.setAttribute(chartConfig,"yField", yField);
    }

    /**
     * Return the yField.
     *
     * @return the yField
     */
    public String getYField() {
        return JavaScriptObjectHelper.getAttribute(chartConfig, "yField");
    }

}
