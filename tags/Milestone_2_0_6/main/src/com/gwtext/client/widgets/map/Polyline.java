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
 
package com.gwtext.client.widgets.map;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A Polyline class. <br>
 * <b>Note that Polylines are not supported by OpenLayers</b>
 *
 * @author Sanjiv Jivan
 */
public class Polyline extends JsObject implements MapProviders {

	/**
	 * Create a new Polyline.
	 *
	 * @param points the points for the Polyline
	 */
	public Polyline(LatLonPoint[] points) {
		jsObj = create(JavaScriptObjectHelper.convertToJavaScriptArray(points));
	}

	public Polyline(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public static Polyline instance(JavaScriptObject jsObj) {
		return new Polyline(jsObj);
	}

	private native JavaScriptObject create(JavaScriptObject pointsJS) /*-{
        return new $wnd.Polyline(pointsJS);
    }-*/;

	public native void setChild(JavaScriptObject proprietaryPolyline) /*-{
        var line = this.@com.gwtext.client.core.JsObject::getJsObj()();
        line.setChild(proprietaryPolyline);
    }-*/;

	/**
	 * Set the line color in hex for (eg #RRGGBB).
	 *
	 * @param color the line color
	 */
	public native void setColor(String color) /*-{
        var line = this.@com.gwtext.client.core.JsObject::getJsObj()();
        line.setColor(color);
    }-*/;

	/**
	 * Sets the line opacity.
	 *
	 * @param opacity a float between 0.0 and 1.0
	 */
	public native void setOpacity(float opacity) /*-{
        var line = this.@com.gwtext.client.core.JsObject::getJsObj()();
        line.setOpacity(opacity);
    }-*/;

	/**
	 * The width / thickness of the polyline in pixels. Defaults to 3.
	 *
	 * @param width the width / thickness of the polyline
	 */
	public native void setWidth(int width) /*-{
        var line = this.@com.gwtext.client.core.JsObject::getJsObj()();
        line.setWidth(width);
    }-*/;

	/**
	 * A FreeEarth compatible Polyline.
	 *
	 * @return a FE.Polyline object
	 */
	public native JavaScriptObject toFreeEarth() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toFreeEarth();
    }-*/;

	/**
	 * A Google Maps compatible Polyline.
	 *
	 * @return a GPolyline object
	 */
	public native JavaScriptObject toGoogle() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toGoogle();
    }-*/;

	/**
	 * A Map24 Polyline.
	 *
	 * @return a Map24.Polyline object
	 */
	public native JavaScriptObject toMap24() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toMap24();
    }-*/;

	/**
	 * A MapQuest compatible Polyline.
	 *
	 * @return a MQLineOverlay object
	 */
	public native JavaScriptObject toMapQuest() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toMapQuest();
    }-*/;

	/**
	 * A Microsoft Virtual Earth compatible Polyline.
	 *
	 * @return a VEPolyline object
	 */
	public native JavaScriptObject toMicrosoft() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toMicrosoft();
    }-*/;

	/**
	 * A MultiMap compatible Polyline.
	 *
	 * @return a MMPolyLineOverlay object
	 */
	public native JavaScriptObject toMultiMap() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toMultiMap();
    }-*/;

	/**
	 * <b>Polylines are not supported by OpenLayers
	 *
	 * @throws UnsupportedOperationException
	 */
	public JavaScriptObject toOpenLayers() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Polylines are not supported by OpenLayers");
	}

	/**
	 * A Yahoo compatible Polyline.
	 *
	 * @return a YPolyline object
	 */
	public native JavaScriptObject toYahoo() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toYahoo();
    }-*/;
}