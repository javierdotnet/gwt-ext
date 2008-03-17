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
 * A type of axis that displays items in categories.
 */
public class NumericAxis extends Axis {

    protected native JavaScriptObject create() /*-{
        return new $wnd.YAHOO.widget.NumericAxis();
    }-*/;

    public void setAlwaysShowZero(boolean alwaysShowZero) {
        JavaScriptObjectHelper.setAttribute(jsObj, "alwaysShowZero", alwaysShowZero);
    }

    public void setMajorUnit(int majorUnit) {
        JavaScriptObjectHelper.setAttribute(jsObj, "majorUnit", majorUnit);
    }

    public void setMinimum(int minimum) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minimum", minimum);
    }

    public void setMinorUnit(int minorUnit) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minorUnit", minorUnit);
    }

    public void setScale(int scale) {
        JavaScriptObjectHelper.setAttribute(jsObj, "scale", scale);
    }

    public void setSnapToUnits(boolean snapToUnits) {
        JavaScriptObjectHelper.setAttribute(jsObj, "snapToUnits", snapToUnits);
    }


}