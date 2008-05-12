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
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.WidgetComponent;

/**
 * A marker pin.
 *
 * @author Sanjiv Jivan
 */
public class Marker extends JsObject implements MapProviders {

	/**
	 * Create a new Marker.
	 *
	 * @param point the LatLonPoint
	 */
	public Marker(LatLonPoint point) {
		jsObj = create(point.getJsObj());
	}

	public Marker(JavaScriptObject jsObj) {
		super(jsObj);
	}

	public static Marker instance(JavaScriptObject jsObj) {
		return new Marker(jsObj);
	}

	private native JavaScriptObject create(JavaScriptObject latLonJS) /*-{
        return new $wnd.Marker(latLonJS);
    }-*/;

	/**
	 * Hide the marker.
	 */
	public native void hide() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.hide();
    }-*/;

	/**
	 * Opens the infoBubble.
	 */
	public native void openBubble() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.openBubble();
    }-*/;

	public native void setAttribute(String name, Object value) /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.setAttribute(name, value);
    }-*/;

	public native void setChild(JavaScriptObject proprietaryMarker) /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.setChild(proprietaryMarker);
    }-*/;

	/**
	 * Sets the icon for a marker.
	 *
	 * @param iconUrl the icon url
	 */
	public native void setIcon(String iconUrl) /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.setIcon(iconUrl);
    }-*/;

	/**
	 * The html/text content for a bubble popup for a marker.
	 *
	 * @param html the html/text content for a bubble popup for a marker
	 */
	public native void setInfoBubble(String html) /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.setInfoBubble(html);
    }-*/;

	/**
	 * Sets the info bubble to be a Widget. Only supported by GoogleMaps. For other map providers use
	 * {@link #setInfoBubble(String)}.
	 *
	 * @param widget the widget to add to the info bubble.
	 */
	public void setInfoBubble(Widget widget) {
		if (widget instanceof Component) {
			Component component = (Component) widget;
			if (!component.isRendered()) {
				WidgetComponent.createHiddenDiv();
				component.render(WidgetComponent.hiddenDivID);
			}
		} else {
			if (!widget.isAttached()) {
				WidgetComponent.createHiddenDiv();
				RootPanel.get(WidgetComponent.hiddenDivID).add(widget);
			}
		}
		setInfoBubble(widget.getElement());
	}

	/**
	 * Sets the info bubble to be the specified Element. Only supported by GoogleMaps. For other map providers use
	 * {@link #setInfoBubble(String)}.
	 *
	 * @param widget the widget to add to the info bubble.
	 */
	public native void setInfoBubble(Element element) /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.setInfoBubble(element);
    }-*/;

	/**
	 * Sets the text and the id of the div element where to the information useful for putting information in a div
	 * outside of the map.
	 *
	 * @param html  the html/text you want displayed
	 * @param divID the element id to use for displaying the text/html
	 */
	public native void setInfoDiv(String html, String divID) /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.setInfoDiv(html, divID);
    }-*/;

	/**
	 * Set the label of the marker.
	 *
	 * @param labelText the label text
	 */
	public native void setLabel(String labelText) /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.setLabel(labelText);
    }-*/;

	/**
	 * Show the marker.
	 */
	public native void show() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        marker.show();
    }-*/;

	/**
	 * A FreeEarth compatible Marker.
	 *
	 * @return a FE.Pushpin object
	 */
	public native JavaScriptObject toFreeEarth() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toFreeEarth();
    }-*/;

	/**
	 * A Google Maps compatible Marker.
	 *
	 * @return a GMarker object
	 */
	public native JavaScriptObject toGoogle() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toGoogle();
    }-*/;

	/**
	 * A Map24 Marker.
	 *
	 * @return a Map24.Location object
	 */
	public native JavaScriptObject toMap24() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toMap24();
    }-*/;

	/**
	 * A MapQuest compatible Marker.
	 *
	 * @return a MQPoi object
	 */
	public native JavaScriptObject toMapQuest() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toMapQuest();
    }-*/;

	/**
	 * A Microsoft Virtual Earth compatible Marker.
	 *
	 * @return a VEPushpin object
	 */
	public native JavaScriptObject toMicrosoft() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toMicrosoft();
    }-*/;

	/**
	 * A MultiMap compatible Marker.
	 *
	 * @return a MMMarkerOverlay object
	 */
	public native JavaScriptObject toMultiMap() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toMultiMap();
    }-*/;

	/**
	 * An OpenLayers compatible Marker.
	 *
	 * @return a OpenLayers.Marker object
	 */
	public native JavaScriptObject toOpenLayers() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toOpenLayers();
    }-*/;

	/**
	 * A Yahoo compatible Marker.
	 *
	 * @return a YMarker object
	 */
	public native JavaScriptObject toYahoo() /*-{
        var marker = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return marker.toYahoo();
    }-*/;
}