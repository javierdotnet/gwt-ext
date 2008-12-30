package com.gwtext.sample.maps.client;

import com.gwtext.client.widgets.map.LatLonPoint;
import com.gwtext.client.widgets.map.MapPanel;


public class ImageOverlaySample extends BaseMultiMapPanel {

	protected void generateMap() {
		mapPanel.setWidth(500);
		mapPanel.setHeight(500);
		LatLonPoint myPoint = new LatLonPoint(18.47, -69.9);
		mapPanel.setCenterAndZoom(myPoint, 11);
		mapPanel.setMapType(MapPanel.SATELLITE);

		mapPanel.addImageOverlay("over", "images/santodomingo.png", 50, -70.01544, 18.39777, -69.80567, 18.563517);
		mapPanel.addSmallControls();
	}
}