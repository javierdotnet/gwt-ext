/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.resizable;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Resizable;
import com.gwtext.client.widgets.ResizableConfig;
import com.gwtext.client.widgets.event.ResizableListenerAdapter;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class ResizablePanelSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/panel/PanelsSample.java.html";
	}

	public String getCssUrl() {
		return "source/panel/PanelsSample.css.html";
	}

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();


			final Panel resizablePanel = new Panel();
			resizablePanel.setTitle("Collapsible Panel");
			resizablePanel.setIconCls("paste-icon");
			resizablePanel.setWidth(200);
			resizablePanel.setCollapsible(true);
			resizablePanel.setHtml(SampleData.getShortBogusMarkup());

			ResizableConfig config = new ResizableConfig();
			config.setHandles(Resizable.SOUTH_EAST);

			final Resizable resizable = new Resizable(resizablePanel, config);
			resizable.addListener(new ResizableListenerAdapter() {
				public void onResize(Resizable self, int width, int height) {
					resizablePanel.setWidth(width);
					resizablePanel.setHeight(height);
				}
			});
			panel.add(resizablePanel);
		}
		return panel;
	}

	public String getIntro() {
		return "A demonstration of a resizable panel with handles on the south-east corner. Resizable Handles ";
	}
}