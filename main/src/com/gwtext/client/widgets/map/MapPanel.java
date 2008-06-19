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
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Function;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Container;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.PanelListenerAdapter;

/**
 * Base Map Panel for various map providers. This class adds support for the <a href="http://www.mapstraction.com/" target="_blank">Mapstraction</a>
 * library.
 * <p/>
 * Mapstraction is a library that provides a common API for various mapping APIs to enable switching from one to another
 * as smoothly as possible. Developers can code their applications once, and then easily switch mapping provider based on project needs,
 * terms and conditions, and new functionality.
 * <p/>
 * Users can switch maps as desired based on personal taste and quality of maps in their local area. Various tools built on
 * top of Mapstraction allow users to easily integrate maps into their own sites, and configure them with different controls, styles,
 * and provider.
 *
 * @author Sanjiv Jivan
 */
public abstract class MapPanel extends Panel {

	protected JavaScriptObject mapJS;
	private boolean mapRendered;
	public static final String MAP_RENDERED_EVENT = "map-rendered";


	private static class MapType {
		private int type;

		private MapType(int type) {
			this.type = type;
		}

		public int getType() {
			return type;
		}
	}

	private static class FilterOperator {
		private String operator;

		private FilterOperator(String operator) {
			this.operator = operator;
		}

		public String getOperator() {
			return operator;
		}
	}

	public static FilterOperator GE = new FilterOperator("ge");
	public static FilterOperator LE = new FilterOperator("le");

	public static MapType ROAD = new MapType(1);
	public static MapType SATELLITE = new MapType(2);
	public static MapType HYBRID = new MapType(3);

	/**
	 * Create a new MapPanel.
	 */
	public MapPanel() {
		addListener("render", new Function() {
			public void execute() {

			}
		});

		addListener(new PanelListenerAdapter() {
			public void onAfterLayout(Container self) {
				if (mapRendered) {
					resizeTo(((Panel) self).getBody().getWidth(), ((Panel) self).getBody().getHeight());
				}
			}
		});
	}

	public boolean isMapRendered() {
		return mapRendered;
	}
	
	protected void afterRender() {
		DeferredCommand.addCommand(new Command() {
			public void execute() {
				ExtElement body = getBody();
				if (body != null) {
					mapJS = doRenderMap(body.getDOM());
					mapRendered = true;
					DeferredCommand.addCommand(new Command() {
						public void execute() {
							fireEvent(MAP_RENDERED_EVENT);
						}
					});
				}
			}
		});
	}

	protected void initComponent() {
		super.initComponent();
		addEvent(MAP_RENDERED_EVENT);
	}

	protected abstract JavaScriptObject doRenderMap(Element element);


	public void setWidth(int width) {
		super.setWidth(width);
		if (mapRendered) {
			doResize();
		}
	}

	public void setHeight(int height) {
		super.setHeight(height);
		if (mapRendered) {
			doResize();
		}
	}

	public void doResize() {
		ExtElement body = getBody();
		resizeTo(body.getWidth(), body.getHeight());
	}

	public void addEventListener(final String event, final Function listener) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddEventListener(event, listener);
				}
			});
		} else {
			doAddEventListener(event, listener);
		}
	}

	private native void doAddEventListener(String event, Function listener) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addEventListener(event, function() {
            listener.@com.gwtext.client.core.Function::execute()();
        });
    }-*/;

	/**
	 * Adds a marker filter.
	 *
	 * @param field the name of attribute to filter on
	 * @param operator the filter operator
	 * @param value the value to compare against
	 */
	public void addFilter(final String field, final FilterOperator operator, final String value) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddFilter(field, operator.getOperator(), value);
				}
			});
		} else {
			doAddFilter(field, operator.getOperator(), value);
		}
	}

	private native void doAddFilter(String field, String op, String value) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addFilter(field, op, value);
    }-*/;

	/**
	 * Adds a marker filter.
	 *
	 * @param field the name of attribute to filter on
	 * @param operator the filter operator
	 * @param value the value to compare against
	 */
	public void addFilter(final String field, final FilterOperator operator, final int value) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddFilter(field, operator.getOperator(), value);
				}
			});
		} else {
			doAddFilter(field, operator.getOperator(), value);
		}
	}

	private native void doAddFilter(String field, String op, int value) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addFilter(field, op, value);
    }-*/;

	/**
	 * Adds a marker filter.
	 *
	 * @param field the name of attribute to filter on
	 * @param operator the filter operator
	 * @param value the value to compare against
	 */
	public void addFilter(final String field, final FilterOperator operator, final double value) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddFilter(field, operator.getOperator(), value);
				}
			});
		} else {
			doAddFilter(field, operator.getOperator(), value);
		}
	}

	private native void doAddFilter(String field, String op, double value) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addFilter(field, op, value);
    }-*/;

	/**
	 * Adds a GeoRSS or KML overlay to the map. Some flavors of GeoRSS and KML are not supported by some of the Map providers
	 *
	 * @param overlayURL adds a GeoRSS or KML overlay to the map
	 */
	public void addOverlay(final String overlayURL) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddOverlay(overlayURL);
				}
			});
		} else {
			doAddOverlay(overlayURL);
		}
	}

	private native void doAddOverlay(String overlayURL) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addOverlay(overlayURL);
    }-*/;

	/**
	 * Sets the imagery type for the map.
	 *
	 * @param mapType the map type
	 */
	public void setMapType(final MapType mapType) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doSetMapType(mapType.getType());
				}
			});
		} else {
			doSetMapType(mapType.getType());
		}
	}

	private native void doSetMapType(int mapType) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.setMapType(mapType);
    }-*/;


	/**
	 * Adds a GeoRSS or KML overlay to the map. Some flavors of GeoRSS and KML are not supported by some of the Map providers
	 *
	 * @param overlayURL		adds a GeoRSS or KML overlay to the map
	 * @param autoCenterAndZoom true to auto center and zoom after the feed is loaded
	 */
	public void addOverlay(final String overlayURL, final boolean autoCenterAndZoom) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddOverlay(overlayURL, autoCenterAndZoom);
				}
			});
		} else {
			doAddOverlay(overlayURL, autoCenterAndZoom);
		}
	}

	private native void doAddOverlay(String overlayURL, boolean autoCenterAndZoom) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addOverlay(overlayURL);
    }-*/;

	/**
	 * Layers an georeferenced image over the map.
	 *
	 * @param id	   unique ID of the image overlay
	 * @param imageURL url of image
	 * @param opacity  0-100
	 * @param west	 the west boundary
	 * @param south	the south boundary
	 * @param east	 the east boundary
	 * @param north	the north boundary
	 */
	public void addImageOverlay(final String id, final String imageURL, final int opacity, final double west, final double south, final double east, final double north) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddImageOverlay(id, imageURL, opacity, west, south, east, north);
				}
			});
		} else {
			doAddImageOverlay(id, imageURL, opacity, west, south, east, north);
		}
	}

	private native void doAddImageOverlay(String id, String imageURL, int opacity, double west, double south, double east, double north) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addImageOverlay(id, imageURL, opacity, west, south, east, north);
    }-*/;

	/**
	 * Adds a large map panning control and zoom buttons to the map. Supported by: yahoo, google,
	 * openstreetmap, multimap, mapquest.
	 */
	public void addLargeControls() {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddLargeControls();
				}
			});
		} else {
			doAddLargeControls();
		}
	}

	private native void doAddLargeControls() /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addLargeControls();
    }-*/;

	/**
	 * Adds a map type control to the map (streets, aerial imagery etc) Supported by: yahoo, google, openstreetmap, multimap, mapquest.
	 */
	public void addMapTypeControls() {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddMapTypeControls();
				}
			});
		} else {
			doAddMapTypeControls();
		}
	}

	private native void doAddMapTypeControls() /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addMapTypeControls();
    }-*/;

	/**
	 * Adds a marker pin to the map.
	 *
	 * @param marker the marker to add
	 */
	public void addMarker(final Marker marker) {
		addMarker(marker, false);
	}

	/**
	 * Adds a marker pin to the map.
	 *
	 * @param marker the marker to add
	 * @param old	If true, doesn't add this marker to the markers array. Used by the "swap" method
	 */
	private void addMarker(final Marker marker, final boolean old) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddMarker(marker, old);
				}
			});
		} else {
			doAddMarker(marker, old);
		}
	}

	private native void doAddMarker(Marker marker, boolean old) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        var markerJS = marker.@com.gwtext.client.core.JsObject::getJsObj()();
        map.addMarker(markerJS, old);
    }-*/;

	/**
	 * Adds a polyline to the map.
	 *
	 * @param polyline the polyline to add
	 */
	public void addPolyline(final Polyline polyline) {
		addPolyline(polyline, false);
	}

	/**
	 * Adds a polyline to the map.
	 *
	 * @param polyline the polyline to add
	 * @param
	 */
	private void addPolyline(final Polyline polyline, final boolean old) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddPolyline(polyline, old);
				}
			});
		} else {
			doAddPolyline(polyline, old);
		}
	}

	private native void doAddPolyline(Polyline polyline, boolean old) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        var polylineJS = polyline.@com.gwtext.client.core.JsObject::getJsObj()();
        map.addPolyline(polylineJS, old);
    }-*/;

	/**
	 * Adds a small map panning control and zoom buttons to the map. Supported by: yahoo, google,
	 * openstreetmap, multimap, mapquest.
	 */
	public void addSmallControls() {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAddSmallControls();
				}
			});
		} else {
			doAddSmallControls();
		}
	}

	private native void doAddSmallControls() /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.addSmallControls();
    }-*/;

	/**
	 * Sets the center and zoom of the map to the smallest bounding box containing all markers
	 */
	public void autoCenterAndZoom() {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doAutoCenterAndZoom();
				}
			});
		} else {
			doAutoCenterAndZoom();
		}
	}

	private native void doAutoCenterAndZoom() /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.autoCenterAndZoom();
    }-*/;

	/**
	 * Executes all filters added since last call
	 */
	public void doFilter() {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					_doFilter();
				}
			});
		} else {
			_doFilter();
		}
	}

	private native void _doFilter() /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.doFilter();
    }-*/;

	/**
	 * Enable/disable dragging of the map (only implemented for yahoo and google) Supported by: yahoo, google,
	 * openstreetmap, multimap.
	 *
	 * @param dragging true to enable dragging
	 */
	public void setDragging(final boolean dragging) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doSetDragging(dragging);
				}
			});
		} else {
			doSetDragging(dragging);
		}
	}

	private native void doSetDragging(boolean dragging) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.dragging(dragging);
    }-*/;

	/**
	 * The maps bounding box. This method should be called only after the map has been rendered.
	 *
	 * @return the BoundingBox
	 */
	public native BoundingBox getBounds()/*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        var boundsJS = map.getBounds();
        return @com.gwtext.client.widgets.map.BoundingBox::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boundsJS);
    }-*/;

	/**
	 * The center of the map. This method should be called only after the map has been rendered.
	 *
	 * @return the center
	 */
	public native LatLonPoint getCenter()/*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        var centerJS = map.getCenter();
        return @com.gwtext.client.widgets.map.LatLonPoint::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(centerJS);
    }-*/;

	/**
	 * Return the native map object. This method should be called only after the map has been rendered.
	 *
	 * @return this native map
	 */
	public native JavaScriptObject getMap() /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        return map.getMap();
    }-*/;

	/**
	 * The zoom level of the map.
	 *
	 * @return the zoom level of the map
	 */
	public native int getZoom() /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        return map.getZoom();
    }-*/;

	/**
	 * This method should be called only after the map has been rendered.
	 *
	 * @param boundingBox the bounding box
	 * @return zoom level
	 */
	public native int getZoomLevelForBoundingBox(BoundingBox boundingBox) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        var boundingBoxJS = boundingBox.@com.gwtext.client.core.JsObject::getJsObj()();
        return map.getZoomLevelForBoundingBox(boundingBoxJS);
    }-*/;

	/**
	 * This method should be called only after the map has been rendered.
	 */
	public native void removeMarker(Marker marker) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
		var markerJS = marker.@com.gwtext.client.core.JsObject::getJsObj()();
		map.removeMarker(markerJS);
    }-*/;

	/**
	 * This method should be called only after the map has been rendered.
	 */
	public native void removeAllMarkers() /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.removeAllMarkers();
    }-*/;


	/**
	 * This method should be called only after the map has been rendered.
	 */
	public native void removePolyline(Polyline polyline) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
		var polylineJS = polyline.@com.gwtext.client.core.JsObject::getJsObj()();
		map.removePolyline(polylineJS);
    }-*/;

	/**
	 * This method should be called only after the map has been rendered.
	 */
	public native void removeAllPolylines() /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.removeAllPolylines();
    }-*/;

	/**
	 * This method should be called only after the map has been rendered.
	 *
	 * @param width  thw width
	 * @param height the height
	 */
	public native void resizeTo(int width, int height) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        map.resizeTo(width, height);
    }-*/;

	public void setCenterAndZoom(final LatLonPoint latLonPoint, final int zoom) {
		if (!mapRendered) {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					doSetCenterAndZoom(latLonPoint, zoom);
				}
			});
		} else {
			doSetCenterAndZoom(latLonPoint, zoom);
		}
	}

	private native void doSetCenterAndZoom(LatLonPoint latLonPoint, int zoom) /*-{
        var map = this.@com.gwtext.client.widgets.map.MapPanel::mapJS;
        var ll = latLonPoint.@com.gwtext.client.core.JsObject::getJsObj()();
        map.setCenterAndZoom(ll, zoom);
    }-*/;

	/**
	 * Add a component to this Panel.
	 *
	 * @param component the component to add
	 */
	public void add(final Component component) {
		if (mapRendered) {
			DeferredCommand.addCommand(new Command() {
				public void execute() {
					component.render(MapPanel.this.getBody().getDOM());
				}
			});

		} else {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					component.render(MapPanel.this.getBody().getDOM());
				}
			});
		}
	}

	/**
	 * Add an absolutely positioned component over the map panel at the specificed location.
	 *
	 * @param component the component to add
	 * @param top the top coordinate
	 * @param right the right coordinate
	 */
	public void add(final Component component, int top, int right) {
		component.setStyle("position:absolute;right:" + right + "px;top:" + top + "px;z-index:1000000;");
		if (mapRendered) {
			component.render(MapPanel.this.getBody().getDOM());
		} else {
			addListener(MAP_RENDERED_EVENT, new Function() {
				public void execute() {
					component.render(MapPanel.this.getBody().getDOM());
				}
			});
		}
	}
}