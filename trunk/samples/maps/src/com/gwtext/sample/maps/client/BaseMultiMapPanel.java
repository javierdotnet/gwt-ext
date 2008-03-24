/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.maps.client;

import com.gwtext.client.widgets.CycleButton;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.CycleButtonListenerAdapter;
import com.gwtext.client.widgets.map.*;
import com.gwtext.client.widgets.menu.CheckItem;

public abstract class BaseMultiMapPanel extends ShowcasePanel {

	protected MapPanel mapPanel;
	private Panel wrapper;

	public Panel getViewPanel() {

		if (panel == null) {
			panel = new Panel();
			panel.setPaddings(15);

			mapPanel = getInitialMap();
			if (mapPanel == null) {
				mapPanel = new GoogleMap();
			}
			generateMap();

			wrapper = new Panel();
			wrapper.setBorder(true);
			wrapper.setHeight(mapPanel.getHeight());
			wrapper.setWidth(mapPanel.getWidth());
			wrapper.add(mapPanel);
			wrapper.add(getButton());

			panel.add(wrapper);

		}
		return panel;
	}

	public MapPanel getInitialMap() {
		return null;
	}

	protected abstract void generateMap();


	private CycleButton getButton() {

		final CheckItem googleItem = new CheckItem("Google", true);
		final CheckItem yahooItem = new CheckItem("Yahoo");
		final CheckItem msItem = new CheckItem("Microsoft");
		final CheckItem osmItem = new CheckItem("OpenStreetMap");
		final CheckItem mat24Item = new CheckItem("Map 24");


		CycleButtonListenerAdapter listener = new CycleButtonListenerAdapter() {
			public void onChange(CycleButton self, CheckItem item) {
				wrapper.remove(mapPanel, true);
				if (item.equals(googleItem)) {
					mapPanel = new GoogleMap();
				} else if (item.equals(yahooItem)) {
					mapPanel = new YahooMap();
				} else if (item.equals(msItem)) {
					mapPanel = new MicrosoftMap();
				} else if (item.equals(mat24Item)) {
					mapPanel = new Map24Map();
				} else if (item.equals(osmItem)) {
					mapPanel = new OpenStreetMap();
				}
				generateMap();
				wrapper.insert(0, mapPanel);
				wrapper.doLayout();
			}
		};
		CycleButton button = new CycleButton();

		button.addListener(listener);
		button.setShowText(true);
		button.addItem(googleItem);
		button.addItem(yahooItem);
		button.addItem(msItem);
		button.addItem(osmItem);
		button.addItem(mat24Item);

		button.setStyle("position:absolute;right:" + 5 + "px;top:" + 5 + "px;z-index:1000000;");

		return button;
	}
}
