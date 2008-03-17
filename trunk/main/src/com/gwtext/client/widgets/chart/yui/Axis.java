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
 * Defines a CartesianChart's vertical or horizontal axis.
 */
public class Axis extends JsObject {

    public Axis() {
        jsObj = create();
    }

    protected native JavaScriptObject create() /*-{
        return new $wnd.YAHOO.widget.Axis();
    }-*/;

    /**
     * Set the hideOverlappingLabels. If true, labels that overlap previously drawn labels on the axis will be hidden.
     *
     * @param hideOverlappingLabels the hideOverlappingLabels
     */
    public void setHideOverlappingLabels(boolean hideOverlappingLabels) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideOverlappingLabels", hideOverlappingLabels);
    }

    /**
     * Return the hideOverlappingLabels.
     *
     * @return the hideOverlappingLabels
     */
    public boolean getHideOverlappingLabels() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, "hideOverlappingLabels");
    }

    /**
     * Set the orientation.
     *
     * @param orientation the orientation
     */
    public void setOrientation(Orientation orientation) {
        JavaScriptObjectHelper.setAttribute(jsObj, "orientation", orientation.getOrientation());
    }

    /**
     * Set the orientation.
     *
     */
    public void setLabelFunction(String labelFunction) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelFunction", labelFunction);
    }



    /**
     * Return the orientation.
     *
     * @return the orientation
     */
    public Orientation getOrientation() {
        String orientation = JavaScriptObjectHelper.getAttribute(jsObj, "orientation");
        return Orientation.getInstance(orientation);
    }

    /**
     * Set the reverse value. If true, the items on the axis will be drawn in opposite direction.
     *
     * @param reverse the reverse value
     */
    public void setReverse(boolean reverse) {
        JavaScriptObjectHelper.setAttribute(jsObj, "reverse", reverse);
    }

    /**
     * Return the reverse value.
     *
     * @return the reverse value
     */
    public boolean getReverse() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, "reverse");
    }

    /**
     * The type of axis.
     *
     * @param type the type of axis
     */
    public void setType(ChartType type) {
        JavaScriptObjectHelper.setAttribute(jsObj, "type", type.getType());
    }

    /**
     * The type of axis.
     *
     * @return the type of axis
     */
    public ChartType getType() {
        String type = JavaScriptObjectHelper.getAttribute(jsObj, "type");
        return ChartType.getInstance(type);
    }

    

}
