package com.gwtext.client.widgets.map;

import com.gwtext.client.core.Function;

public class GoogleMarker extends Marker {

	public GoogleMarker(LatLonPoint point) {
		super(point);
	}

	/**
	 * Add an event listener. See the <a href="http://code.google.com/apis/maps/documentation/reference.html#GMarker" target="_blank">Google Maps API</a>
	 * for details.
	 *
	 * @param event the event name
	 * @param fn	the function.
	 */
	public native void addListener(String event, Function fn) /*-{
		var js = this.@com.gwtext.client.widgets.map.Marker::toGoogle()();
		$wnd.GEvent.addListener(js, event, function() {
			fn.@com.gwtext.client.core.Function::execute()();
        });
	}-*/;
}
