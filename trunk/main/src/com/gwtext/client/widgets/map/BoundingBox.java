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

/**
 * The bounding box of the map.
 */
public class BoundingBox extends JsObject {

    public BoundingBox(double swlat, double swlon, double nelat, double nelon) {
        jsObj = create(swlat, swlon, nelat, nelon);
    }

    public BoundingBox(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static BoundingBox instance(JavaScriptObject jsObj) {
        return new BoundingBox(jsObj);
    }

    private native JavaScriptObject create(double swlat, double swlon, double nelat, double nelon) /*-{
        return new $wnd.BoundingBox(swlat, swlon, nelat, nelon);
    }-*/;

    /**
     * Whether a given point is within a bounding box.
     *
     * @param latLonPoint the point
     * @return true if given point is within a bounding box
     */
    public native boolean contains(LatLonPoint latLonPoint) /*-{
        var bb = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var ll = latLonPoint.@com.gwtext.client.core.JsObject::getJsObj()();
        return bb.contains(ll);
    }-*/;

    /**
     * LatLonPoint of the north-east point of the bounding box
     *
     * @return LatLonPoint of the north-east point of the bounding box
     */
    public native LatLonPoint getNorthEast() /*-{
        var bb = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var ll = bb.getNorthEast();
        return @com.gwtext.client.widgets.map.LatLonPoint::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ll);
    }-*/;

    /**
     * LatLonPoint of the south-west point of the bounding box
     *
     * @return LatLonPoint of the south-west point of the bounding box
     */
    public native LatLonPoint getSouthWest() /*-{
        var bb = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var ll = bb.getSouthWest();
        return @com.gwtext.client.widgets.map.LatLonPoint::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ll);
    }-*/;

    /**
     * True if this bounding box has zero area.
     *
     * @return true if this bounding box has zero area
     */
    public native boolean isEmpty() /*-{
        var bb = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return bb.isEmpty();
    }-*/;

    /**
     * Return a LatLonPoint with the lat and lon as the height and width of the bounding box.
     *
     * @return a LatLonPoint with the lat and lon as the height and width of the bounding box
     */
    public native LatLonPoint toSpan() /*-{
        var bb = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var ll = bb.toSpan();
        return @com.gwtext.client.widgets.map.LatLonPoint::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ll);
    }-*/;
}
