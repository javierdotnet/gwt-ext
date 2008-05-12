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

import com.gwtext.client.core.Connection;
import com.gwtext.client.data.Node;
import com.gwtext.client.dd.DragData;
import com.gwtext.client.dd.DragDrop;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Radio;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.widgets.tree.*;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class TwoTreesSample extends ShowcasePanel {

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
            final TreePanel treePanel = new TreePanel();
			treePanel.setTitle("Countries");
			treePanel.setAnimate(true);
            treePanel.setEnableDD(true);
            treePanel.setContainerScroll(true);
            treePanel.setRootVisible(true);
            treePanel.setWidth(200);
            treePanel.setHeight(400);
            treePanel.setSelectionModel(new MultiSelectionModel());

            final XMLTreeLoader loader = new XMLTreeLoader();
            loader.setDataUrl("data/countries-grouped.xml");
            loader.setMethod(Connection.GET);
            loader.setRootTag("countries");
            loader.setFolderTitleMapping("@title");
            loader.setFolderTag("continent");
            loader.setLeafTitleMapping("@title");
            loader.setLeafTag("country");
            loader.setQtipMapping("@qtip");
            loader.setIconMapping("@icon");

            AsyncTreeNode root = new AsyncTreeNode("Countries", loader);
            treePanel.setRootNode(root);
            root.expand();
            treePanel.expandAll();

            //create target vacation tree
            final TreePanel tripTreePanel = new TreePanel();
			tripTreePanel.setTitle("Trip Planner");
			tripTreePanel.setAnimate(true);
            tripTreePanel.setEnableDD(true);
            tripTreePanel.setContainerScroll(true);
            tripTreePanel.setRootVisible(true);
            tripTreePanel.setWidth(200);
            tripTreePanel.setHeight(400);            

            final XMLTreeLoader tripLoader = new XMLTreeLoader();
            tripLoader.setDataUrl("data/trip.xml");
            tripLoader.setMethod(Connection.GET);
            tripLoader.setRootTag("vacations");
            tripLoader.setFolderIdMapping("@title");
            tripLoader.setFolderTag("trip");
            tripLoader.setQtipMapping("@qtip");
            tripLoader.setIconMapping("@icon");
            tripLoader.setAttributeMappings(new String[]{"@trip"});

            final AsyncTreeNode tripRoot = new AsyncTreeNode("Places to Visit", tripLoader);

            tripTreePanel.setRootNode(tripRoot);

            //add trip tree listener that handles move / copy logic
            tripTreePanel.addListener(new TreePanelListenerAdapter() {
                public void onRender(Component component) {
                    tripRoot.expand();
                    tripTreePanel.expandAll();
                }

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
            horizontalPanel.add(tripTreePanel);

            Panel verticalPanel = new Panel();
            verticalPanel.setLayout(new VerticalLayout(15));

            verticalPanel.add(formPanel);
            verticalPanel.add(horizontalPanel);

            panel.add(verticalPanel);
        }
        return panel;
    }

    public String getIntro() {
        return "This example demonstrates Drag & Drop nodes between trees. It also illustrates how to move a node on drop or make a copy.";
    }
}