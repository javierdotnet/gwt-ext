/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

public class Orientation {

    public static Orientation VERTICAL = new Orientation("vertical");
    public static Orientation HORIZONTAL = new Orientation("horizontal");

    private String orientation;

    private Orientation(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }

    public static Orientation getInstance(String orientation) {
        if(orientation == null) return null;
        if(orientation.equalsIgnoreCase("vertical")) {
            return VERTICAL;
        } else if (orientation.equalsIgnoreCase("horizontal")) {
            return HORIZONTAL;
        }
        return null;
    }
}
