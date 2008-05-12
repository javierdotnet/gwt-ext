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
 * Defines a CartesianChart's vertical or horizontal axis.
 *
 * @author Sanjiv Jivan
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
