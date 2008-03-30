/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.grid;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class BasicArrayGridSample extends ShowcasePanel {


	public String getSourceUrl() {
		return "source/grid/BasicArrayGridSample.java.html";
	}

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();
			final GridPanel grid = new SampleGrid();
			grid.setHeight(350);
			grid.setWidth(600);
			grid.setTitle("Array Grid");

			Toolbar bottomToolbar = new Toolbar();
			bottomToolbar.addFill();
			bottomToolbar.addButton(new ToolbarButton("Clear Sort", new ButtonListenerAdapter() {
				public void onClick(Button button, EventObject e) {
					grid.clearSortState(true);
				}
			}));
			grid.setBottomToolbar(bottomToolbar);

			panel.add(grid);
		}
		return panel;
	}

	public String getIntro() {
		return "<p>This is an example of a basic Grid. The data for a Grid comes from its backing Store. In this example, the Store is populated using local array data.</p>" +
				"<p>Some simple Column Renderer's are also assigned to the 'Change' column to style the cell depending on the data</p> ";
	}
}