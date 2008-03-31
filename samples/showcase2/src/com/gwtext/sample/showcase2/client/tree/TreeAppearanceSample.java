/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.sample.showcase2.client.tree;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.sample.showcase2.client.SampleTree;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class TreeAppearanceSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/tree/TreeAppearanceSample.java.html";
	}

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			final TreePanel treePanel = new SampleTree();
			treePanel.setTitle("Default Appearance");
			treePanel.setWidth(190);
			treePanel.setHeight(400);

			final TreePanel treePanelNoLines = new SampleTree();
			treePanelNoLines.setTitle("No Lines");
			treePanelNoLines.setWidth(190);
			treePanelNoLines.setHeight(400);
			treePanelNoLines.setLines(false);

			final TreePanel treePanelVistaArrows = new SampleTree();
			treePanelVistaArrows.setTitle("Vista Arrows");
			treePanelVistaArrows.setWidth(190);
			treePanelVistaArrows.setHeight(400);
			treePanelVistaArrows.setUseArrows(true);

			Panel horizontalPanel = new Panel();
			horizontalPanel.setLayout(new HorizontalLayout(20));
			horizontalPanel.add(treePanel);
			horizontalPanel.add(treePanelNoLines);
			horizontalPanel.add(treePanelVistaArrows);

			Panel verticalPanel = new Panel();
			verticalPanel.setLayout(new VerticalLayout(15));

			verticalPanel.add(horizontalPanel);

			panel.add(verticalPanel);
		}
		return panel;
	}

	public String getIntro() {
		return "<p>The first TreePanel has the default appearance with dotted lines connecting the tree nodes</p>" +
				"<p>The second TreePanel has has no lines connecting the tree nodes. This is accomplished by calling set treePanel.setLines(false);</p>" +
				"<p>The third TreePanel has Vista Style arrows for tree nodes. This is accomplished by calling set treePanel.setUseArrows(false);</p>" +
				"<p>You can also use your own custom CSS to style the appearance as desired.</p>";
	}
}