package com.gwtext.sample.maps.client;

import com.gwtext.client.core.Function;
import com.gwtext.client.widgets.map.BoundingBox;
import com.gwtext.client.widgets.map.GoogleMarker;
import com.gwtext.client.widgets.map.LatLonPoint;
import com.gwtext.client.widgets.map.MapPanel;

import java.util.Date;


public class MarkerFiltersSample extends BaseMultiMapPanel {

    public String getSourceUrl() {
        return "source/MarkerFiltersSample.java.html";
    }

    protected void generateMap() {

		mapPanel.setWidth(500);
		mapPanel.setHeight(500);


		LatLonPoint myPoint = new LatLonPoint(51.387745, -0.50914);
		mapPanel.setCenterAndZoom(myPoint, 14);

		mapPanel.addListener(MapPanel.MAP_RENDERED_EVENT, new Function() {
			public void execute() {
				addMarkers(mapPanel, 50);
			}
		});

	}

	private void addMarkers(MapPanel mapPanel, int count) {
		BoundingBox bounds = mapPanel.getBounds();
		LatLonPoint sw = bounds.getSouthWest();
		LatLonPoint ne = bounds.getNorthEast();
		while (count-- != 0) {
			LatLonPoint ll = new LatLonPoint(sw.getLat() + ((ne.getLat() - sw.getLat()) * Math.random()), sw.getLon() + ((ne.getLon() - sw.getLon()) * Math.random()));
			final GoogleMarker marker = new GoogleMarker(ll);

			long number = Math.round(86400000 * Math.random());
			Date d = new Date();
			d.setTime(d.getTime() - (86400000 / 2) + number);
			int h = d.getHours();
			int m = d.getMinutes();
			marker.setInfoBubble("<h1>" + h + ":" + m + "</h1>");
			marker.setAttribute("date", d);
			mapPanel.addMarker(marker);
		}
	}

    public String getIntro() {
        return "An example of creating markers.";
    }
}