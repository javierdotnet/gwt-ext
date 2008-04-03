/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * CartesianSeries class for the YUI Charts widget. Defines a CartesianChart's vertical or horizontal axis.
 */
public class CartesianSeries extends JsObject {

    public CartesianSeries() {
        jsObj = create();
    }

    protected native JavaScriptObject create() /*-{
        return new $wnd.YAHOO.widget.CartesianSeries();
    }-*/;

    /**
     * Set the xField. The field used to access the x-axis value from the items from the data source.
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

    /**
     * The field used to access the y-axis value from the items from the data source.
     *
     * @param yField the yField
     */
    public void setYField(String yField) {
        JavaScriptObjectHelper.setAttribute(jsObj, "yField", yField);
    }

    /**
     * The field used to access the y-axis value from the items from the data source.
     *
     * @return the yField
     */
    public String getYField() {
        return JavaScriptObjectHelper.getAttribute(jsObj, "yField");
    }

    
}