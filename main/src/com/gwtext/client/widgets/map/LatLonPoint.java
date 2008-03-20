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
 * LatLonPoint is a point containing a latitude and longitude.
 */
public class LatLonPoint extends JsObject implements MapProviders {


    /**
     * Create a new LatLonPoint.
     *
     * @param lat the latitude
     * @param lon the longitude
     */
    public LatLonPoint(double lat, double lon) {
        jsObj = create(lat, lon);
    }

    public LatLonPoint(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static LatLonPoint instance(JavaScriptObject jsObj) {
        return new LatLonPoint(jsObj);
    }

    private native JavaScriptObject create(double lat, double lon) /*-{
        return new $wnd.LatLonPoint(lat, lon);
    }-*/;

    /**
     * The distance in kilometers between two points.
     *
     * @param otherPoint the other point
     * @return the distance in kilometers between two points.
     */
    public native double distance(LatLonPoint otherPoint) /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var llOther = otherPoint.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.distance(llOther);
    }-*/;

    /**
     * A FreeEarth point.
     *
     * @return a FE.LatLng object
     */
    public native JavaScriptObject toFreeEarth() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.toFreeEarth();
    }-*/;

    /**
     * A Google Maps point.
     *
     * @return a GLatLng object
     */
    public native JavaScriptObject toGoogle() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.toGoogle();
    }-*/;

    /**
     * A Map24 point.
     *
     * @return a Map24.Point object
     */
    public native JavaScriptObject toMap24() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.toMap24();
    }-*/;

    /**
     * A MapQuest point.
     *
     * @return a MQLatLng object
     */
    public native JavaScriptObject toMapQuest() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.toMapQuest();
    }-*/;

    /**
     * A Microsoft Virtual Earth point.
     *
     * @return a VELatLong object
     */
    public native JavaScriptObject toMicrosoft() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.toMicrosoft();
    }-*/;

    /**
     * A MultiMap point.
     *
     * @return a MMLatLon object
     */
    public native JavaScriptObject toMultiMap() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.toMultiMap();
    }-*/;

    /**
     * An OpenLayers point.
     *
     * @return a OpenLayers.LonLat object
     */
    public native JavaScriptObject toOpenLayers() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.toOpenLayers();
    }-*/;

    /**
     * A Yahoo point.
     *
     * @return a YGeoPoint object
     */
    public native JavaScriptObject toYahoo() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.toYahoo();
    }-*/;

    public native double getLat() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.lat;
    }-*/;

    public native double getLon() /*-{
        var ll = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return ll.lon;
    }-*/;

    public String toString() {
        return "{" + getLat() + ", " + getLon() + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof LatLonPoint)) return false;

        LatLonPoint that = (LatLonPoint) o;

        if (new Double(that.getLat()).floatValue() != new Double(getLat()).floatValue()) return false;
        if (new Double(that.getLon()).floatValue() != new Double(getLon()).floatValue()) return false;

        return true;
    }   
}
