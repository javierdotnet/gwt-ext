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

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * CartesianSeries class for the YUI Charts widget. Defines a CartesianChart's vertical or horizontal axis.
 *
 * @author Sanjiv Jivan
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