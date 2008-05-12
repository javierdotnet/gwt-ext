/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
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