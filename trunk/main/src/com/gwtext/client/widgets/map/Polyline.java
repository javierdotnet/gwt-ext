/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.map;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A Polyline class. <br>
 * <b>Note that Polylines are not supported by OpenLayers</b>
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