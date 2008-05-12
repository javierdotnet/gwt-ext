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

import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.data.*;
import com.gwtext.client.dd.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Radio;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.widgets.tree.DropNodeCallback;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import com.gwtext.sample.showcase2.client.OutlookTreePanel;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class TreeDragDropSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/tree/TwoTreesSample.java.html";
	}

	public String getXmlDataUrl() {
		return "source/tree/TwoTreesSample.xml.html";
	}

	public Panel getViewPanel() {
		if (panel == null) {
			panel = new Panel();

			//create form for nody drop style
			FormPanel formPanel = new FormPanel();
			formPanel.setBorder(false);
			formPanel.setHideLabels(true);

			FieldSet fieldSet = new FieldSet("Drop style");
			fieldSet.setWidth(420);
			formPanel.add(fieldSet);

			final Radio moveRadio = new Radio();
			moveRadio.setName("dropstyle");
			moveRadio.setBoxLabel("Move");
			moveRadio.setChecked(true);
			fieldSet.add(moveRadio);

			final Radio copyRadio = new Radio();
			copyRadio.setName("dropstyle");
			copyRadio.setBoxLabel("Copy");
			fieldSet.add(copyRadio);

			//create source countries tree
			TreePanel treePanel = new OutlookTreePanel();
			treePanel.setEnableDD(true);
			treePanel.setDdGroup("treeDD");
			treePanel.expandAll();

			//create target vacation tree
			final TreePanel treePanel2 = new OutlookTreePanel();
			treePanel2.setEnableDD(true);
			treePanel2.setDdGroup("treeDD");

			//add trip tree listener that handles move / copy logic
			treePanel2.addListener(new TreePanelListenerAdapter() {

				public boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode, DropNodeCallback dropDropNodeCallback) {
					if ("true".equals(target.getAttribute("trip"))) {
						if (copyRadio.getValue()) {
							TreeNode copyNode = dropNode.cloneNode();
							Node[] children = copyNode.getChildNodes();
							for (int i = 0; i < children.length; i++) {
								Node child = children[i];
								copyNode.removeChild(child);
							}
							dropDropNodeCallback.setDropNode(copyNode);
						}
					}
					return true;
				}
			});

			Panel horizontalPanel = new Panel();
			horizontalPanel.setLayout(new HorizontalLayout(20));
			horizontalPanel.add(treePanel);
			horizontalPanel.add(treePanel2);

			Panel verticalPanel = new Panel();
			verticalPanel.setLayout(new VerticalLayout(15));

			verticalPanel.add(formPanel);
			verticalPanel.add(horizontalPanel);


			ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
					new ColumnConfig("Nane", "name", 50)
			});
			final RecordDef recordDef = new RecordDef(new FieldDef[]{
					new StringFieldDef("name", "name"),
			});

			Store store = new Store(recordDef);

			final GridPanel gridPanel = new GridPanel();
			gridPanel.setTitle("Countries");
			gridPanel.setStore(store);
			gridPanel.setColumnModel(columnModel);
			gridPanel.setWidth(300);
			gridPanel.setHeight(200);
			gridPanel.setEnableDragDrop(true);

			gridPanel.doOnRender(new Function() {
				public void execute() {
                    DropTargetConfig config = new DropTargetConfig();
                    config.setdDdGroup("treeDD");
                    DropTarget dropTarget = new DropTarget(gridPanel.getElement(), config) {
						public void onDragOver(EventObject e, String id) {
							super.onDragOver(e, id);
						}

						public boolean notifyDrop(DragSource source, EventObject e, DragData data) {
							return super.notifyDrop(source, e, data);
						}
					};
				}
			});


			verticalPanel.add(gridPanel);

			panel.add(verticalPanel);
		}
		return panel;
	}

	public String getIntro() {
		return "This example demonstrates Drag & Drop nodes between trees. It also illustrates how to move a node on drop or make a copy.";
	}
}