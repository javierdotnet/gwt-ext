package com.gwtext.sample.maps.client;

import com.gwtext.client.widgets.map.LatLonPoint;


public class GeoRSSSample extends BaseMultiMapPanel {

    public String getSourceUrl() {
        return "source/GeoRSSSample.java.html";
    }

    protected void generateMap() {
		mapPanel.setWidth(600);
		mapPanel.setHeight(600);
		LatLonPoint myPoint = new LatLonPoint(37.4041960114344, -122.008194923401);
		mapPanel.setCenterAndZoom(myPoint, 3);

		mapPanel.addOverlay("http://api.flickr.com/services/feeds/groups_pool.gne?id=322338@N20&format=rss_200&georss=1");
	}

    public String getIntro() {
        return "An example of GeoRSS markers. GeoRSS is a location-aware news feed. There are many types of GeoRSS feeds: homes for sale, " +
				" USGS Earthquakes, flickr location-tagged photos, etc. I can imagine so many more excellent applications for it--how about best fishing holes, " +
				"animal migration patterns, disease monitoring, best places to drink beer, ...";
    }
}