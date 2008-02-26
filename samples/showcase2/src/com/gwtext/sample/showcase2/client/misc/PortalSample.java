package com.gwtext.sample.showcase2.client.misc;

import com.gwtext.client.core.Function;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Tool;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.portal.Portal;
import com.gwtext.client.widgets.portal.PortalColumn;
import com.gwtext.client.widgets.portal.Portlet;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;


public class PortalSample extends ShowcasePanel {

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
			Portlet gridPortlet = new Portlet();
			gridPortlet.setTitle("Grid in a Portlet");
			gridPortlet.setLayout(new FitLayout());
			gridPortlet.setTools(tools);
			SampleGrid grid = new SampleGrid(true, new int[]{0, 2, 3});
			grid.setFrame(false);
			gridPortlet.add(grid);
			firstCol.add(gridPortlet);

			Portlet portlet = new Portlet("Another Panel 1", SampleData.getShortBogusMarkup(), tools);
			firstCol.add(portlet);

			//add portal column to portal
			portal.add(firstCol, new ColumnLayoutData(.33));

			//another column
			PortalColumn secondCol = new PortalColumn();
			secondCol.setPaddings(10, 10, 0, 10);
			secondCol.add(new Portlet("Panel 2", SampleData.getShortBogusMarkup(), tools));
			secondCol.add(new Portlet("Another Panel 2", SampleData.getShortBogusMarkup(), tools));
			portal.add(secondCol, new ColumnLayoutData(.33));

			//third column
			PortalColumn thirdCol = new PortalColumn();
			thirdCol.setPaddings(10, 10, 0, 10);
			thirdCol.add(new Portlet("Panel 3", SampleData.getShortBogusMarkup(), tools));
			thirdCol.add(new Portlet("Another Panel 3", SampleData.getShortBogusMarkup(), tools));
			portal.add(thirdCol, new ColumnLayoutData(.33));

			panel.add(portal);
		}
		return panel;
	}
}

