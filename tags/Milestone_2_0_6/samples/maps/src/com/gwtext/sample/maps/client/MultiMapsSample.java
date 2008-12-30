package com.gwtext.sample.maps.client;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Tool;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.map.*;
import com.gwtext.client.widgets.portal.Portal;
import com.gwtext.client.widgets.portal.PortalColumn;
import com.gwtext.client.widgets.portal.Portlet;


public class MultiMapsSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/MultiMapsSample.java.html";
    }

    public Panel getViewPanel() {

		if (panel == null) {
			panel = new Panel();
			panel.setLayout(new FitLayout());

			//create some shared tools
			Tool gear = new Tool(Tool.GEAR, new Function() {
				public void execute() {
					MessageBox.alert("Message", "The Settings Tool was clicked");
				}
			});

			Tool close = new Tool(Tool.CLOSE, new Function() {
				public void execute() {
					MessageBox.alert("Message", "The Settings Tool was clicked");
				}
			});

			Tool[] tools = new Tool[]{gear, close};

			//create a portal
			Portal portal = new Portal();

			//create portal columns
			PortalColumn firstCol = new PortalColumn();
			firstCol.setPaddings(10, 10, 0, 10);

			//add portlets to portal columns
			Portlet googlePortlet = new Portlet();
			googlePortlet.setTitle("Google Map");
			googlePortlet.setLayout(new FitLayout());
			googlePortlet.setTools(tools);
			MapPanel google = new GoogleMap();
			drawMap(google);
			googlePortlet.add(google);
			firstCol.add(googlePortlet);

			Portlet yahooPortlet = new Portlet();
			yahooPortlet.setTitle("Yahoo Map");
			yahooPortlet.setLayout(new FitLayout());
			yahooPortlet.setTools(tools);
			MapPanel yahoo = new YahooMap();
			drawMap(yahoo);
			yahooPortlet.add(yahoo);
			firstCol.add(yahooPortlet);

			Portlet osmPortlet = new Portlet();
			osmPortlet.setTitle("Open Street Map");
			osmPortlet.setLayout(new FitLayout());
			osmPortlet.setTools(tools);
			MapPanel osm = new OpenStreetMap();
			drawMap(osm);
			osmPortlet.add(osm);
			firstCol.add(osmPortlet);

			//add portal column to portal
			portal.add(firstCol, new ColumnLayoutData(.33));

			//another column
			PortalColumn secondCol = new PortalColumn();
			secondCol.setPaddings(10, 10, 0, 10);

			Portlet msPortlet = new Portlet();
			msPortlet.setTitle("Microsoft Map");
			msPortlet.setLayout(new FitLayout());
			msPortlet.setTools(tools);
			MapPanel microsoft = new MicrosoftMap();
			drawMap(microsoft);
			msPortlet.add(microsoft);
			secondCol.add(msPortlet);

			/*Portlet map24Portlet = new Portlet();
			map24Portlet.setTitle("Map24 Map");
			map24Portlet.setLayout(new FitLayout());
			map24Portlet.setTools(tools);
			MapPanel map24 = new Map24Map();
			drawMap(map24);
			map24Portlet.add(map24);
			secondCol.add(map24Portlet);*/

			Portlet mapQuestPortlet = new Portlet();
			mapQuestPortlet.setTitle("MapQuest Map");
			mapQuestPortlet.setLayout(new FitLayout());
			mapQuestPortlet.setTools(tools);
			MapPanel mapquest = new YahooMap();
			drawMap(mapquest);
			mapQuestPortlet.add(mapquest);
			secondCol.add(mapQuestPortlet);

			Portlet multiMapPortlet = new Portlet();
			multiMapPortlet.setTitle("MultiMap");
			multiMapPortlet.setLayout(new FitLayout());
			multiMapPortlet.setTools(tools);
			MapPanel multiMap = new YahooMap();
			drawMap(multiMap);
			multiMapPortlet.add(multiMap);
			secondCol.add(multiMapPortlet);

			portal.add(secondCol, new ColumnLayoutData(.33));

			//third column
			PortalColumn thirdCol = new PortalColumn();
			thirdCol.setPaddings(10, 10, 0, 10);


			Portlet fePortlet = new Portlet();
			fePortlet.setTitle("Free Earth Map");
			fePortlet.setLayout(new FitLayout());
			fePortlet.setTools(tools);
			MapPanel freeEarth = new FreeEarthMap();
			drawMap(freeEarth);
			fePortlet.add(freeEarth);
			thirdCol.add(fePortlet);

			Portlet openLayersPortlet = new Portlet();
			openLayersPortlet.setTitle("OpenLayers Map");
			openLayersPortlet.setLayout(new FitLayout());
			openLayersPortlet.setTools(tools);
			MapPanel openLayers = new OpenLayersMap();
			drawMap(openLayers);
			openLayersPortlet.add(openLayers);
			thirdCol.add(openLayersPortlet);

			portal.add(thirdCol, new ColumnLayoutData(.33));
			panel.add(portal);

		}
		return panel;
	}

	private static void drawMap(MapPanel map) {
		map.setCenterAndZoom(new LatLonPoint(37.4041960114344, -122.008194923401), 10);
		map.setHeight(200);

		final Button button = new Button("Filter");
		button.setStyle("position:absolute;right:4px;top:4px;z-index:1000000;");

		button.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				super.onClick(button, e);
				e.stopEvent();
				MessageBox.alert("button clicked");
			}
		});

		map.add(button);
	}
        
}