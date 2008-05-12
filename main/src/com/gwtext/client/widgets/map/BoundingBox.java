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

/**
 * The bounding box of the map.
 *
 * @author Sanjiv Jivan
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
