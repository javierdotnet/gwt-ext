/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * ColumnChart class for the YUI Charts widget.
 */
public class ColumnChart extends CartesianChart {

    protected native JavaScriptObject createChart(String containerID, JavaScriptObject dataStore, JavaScriptObject config)/*-{
        return new $wnd.YAHOO.widget.ColumnChart(containerID, dataStore, config);    
    }-*/;
}