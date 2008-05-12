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
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A type of axis that displays items in categories.
 *
 * @author Sanjiv Jivan
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