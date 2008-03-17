/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

public class ChartType {

    public static ChartType LINE = new ChartType("line");
    public static ChartType COLUMN = new ChartType("column");
    public static ChartType BAR = new ChartType("bar");

    private String type;

    private ChartType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static ChartType getInstance(String type) {
        if(type == null) return null;
        if (type.equalsIgnoreCase("line")) {
            return LINE;
        } else if (type.equalsIgnoreCase("column")) {
            return COLUMN;
        } else if (type.equalsIgnoreCase("bar")) {
            return BAR;
        }
        return null;
    }
}