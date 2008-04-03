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

/**
 * A type of axis that displays items in categories.
 */
public class NumericAxis extends Axis {

    protected native JavaScriptObject create() /*-{
        return new $wnd.YAHOO.widget.NumericAxis();
    }-*/;

    /**
     * If true, and the bounds are calculated automatically, either the minimum or maximum will be set to zero.
     *
     * @param alwaysShowZero always show zero
     */
    public void setAlwaysShowZero(boolean alwaysShowZero) {
        JavaScriptObjectHelper.setAttribute(jsObj, "alwaysShowZero", alwaysShowZero);
    }

    /**
     * The spacing between major intervals on this axis.
     *
     * @param majorUnit the spacing between major intervals on this axis.
     */
    public void setMajorUnit(int majorUnit) {
        JavaScriptObjectHelper.setAttribute(jsObj, "majorUnit", majorUnit);
    }

    /**
     * The maximum value drawn by the axis. If not set explicitly, the axis maximum will be calculated automatically.
     *
     * @param maximum the maximum value drawn by the axis. If not set explicitly, the axis maximum will be calculated automatically.
     */
    public void setMaximum(int maximum) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maximum", maximum);
    }

    /**
     * The minimum value drawn by the axis. If not set explicitly, the axis minimum will be calculated automatically.
     *
     * @param minimum the minimum value drawn by the axis. If not set explicitly, the axis minimum will be calculated automatically.
     */
    public void setMinimum(int minimum) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minimum", minimum);
    }

    /**
     * The spacing between minor intervals on this axis.
     *
     * @param minorUnit the spacing between minor intervals on this axis.
     */
    public void setMinorUnit(int minorUnit) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minorUnit", minorUnit);
    }

    /**
     * The scaling algorithm to use on this axis. May be "linear" or "logarithmic".
     *
     * @param scale the scaling algorithm to use on this axis. May be "linear" or "logarithmic".
     */
    public void setScale(int scale) {
        JavaScriptObjectHelper.setAttribute(jsObj, "scale", scale);
    }

    /**
     * If true, the labels, ticks, gridlines, and other objects will snap to the nearest major or minor unit. If false, their position will be based on the minimum value.
     *
     * @param snapToUnits true to snap to units
     */
    public void setSnapToUnits(boolean snapToUnits) {
        JavaScriptObjectHelper.setAttribute(jsObj, "snapToUnits", snapToUnits);
    }
}