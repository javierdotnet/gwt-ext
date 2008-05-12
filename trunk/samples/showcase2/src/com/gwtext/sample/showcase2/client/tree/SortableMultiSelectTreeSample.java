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
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Radio;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.widgets.tree.*;
import com.gwtext.sample.showcase2.client.Showcase2;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

import java.util.Comparator;

public class SortableMultiSelectTreeSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/tree/SortableMultiSelectTreeSample.java.html";
    }

    public String getXmlDataUrl() {
        return "source/tree/SortableMultiSelectTreeSample.xml.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final TreePanel treePanel = new TreePanel();
            treePanel.setTitle("Sort and Multi-Select");
            treePanel.setAnimate(true);
            treePanel.setEnableDD(true);
            treePanel.setContainerScroll(true);
            treePanel.setRootVisible(true);
            //this property enables multi-select
            treePanel.setSelectionModel(new MultiSelectionModel());
            treePanel.setHeight(360);

            final XMLTreeLoader loader = new XMLTreeLoader();
            loader.setDataUrl("data/countries.xml");
            loader.setMethod(Connection.GET);
            loader.setRootTag("countries");
            loader.setFolderTitleMapping("@title");
            loader.setFolderTag("team");
            loader.setLeafTitleMapping("@title");
            loader.setLeafTag("country");
            loader.setQtipMapping("@qtip");
            loader.setDisabledMapping("@disabled");
            loader.setCheckedMapping("@checked");
            loader.setIconMapping("@icon");
            loader.setAttributeMappings(new String[]{"@rank"});

            AsyncTreeNode root = new AsyncTreeNode("Countries", loader);
            treePanel.setRootNode(root);

            root.expand();
            treePanel.expandAll();
            root.select();

            FormPanel form = new FormPanel();
            form.setBorder(false);
            form.setFrame(false);
            form.setWidth(300);

            FieldSet fieldSet = new FieldSet("Sort Direction");
            fieldSet.setFrame(false);

            final Radio ascRadio = new Radio();
            ascRadio.setName("direction");
            ascRadio.setBoxLabel("Ascending");
            ascRadio.setChecked(true);
            fieldSet.add(ascRadio);

            final Radio descRadio = new Radio();
            descRadio.setName("direction");
            descRadio.setBoxLabel("Descending");
            descRadio.setChecked(false);
            fieldSet.add(descRadio);

            form.add(fieldSet);

            Button selectedButton = new Button("Show Selected", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    MultiSelectionModel selectionModel = (MultiSelectionModel) treePanel.getSelectionModel();
                    TreeNode[] nodes = selectionModel.getSelectedNodes();
                    String nodesString = "";
                    for (int i = 0; i < nodes.length; i++) {
                        TreeNode node = nodes[i];
                        nodesString += "<br>" + node.getText();
                    }
                    Showcase2.showMessage("Selected Nodes", nodesString);
                }
            });


            Button sortButton = new Button("Sort", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    MultiSelectionModel selectionModel = (MultiSelectionModel) treePanel.getSelectionModel();
                    TreeNode[] nodes = selectionModel.getSelectedNodes();
                    if (nodes.length == 0) {
                        nodes = new TreeNode[1];
                        nodes[0] = treePanel.getRootNode();
                    }
                    final boolean asc = ascRadio.getValue();
                    for (int i = 0; i < nodes.length; i++) {
                        TreeNode node = nodes[i];
                        node.sort(new Comparator() {
                            public int compare(Object o1, Object o2) {
                                TreeNode node0 = (TreeNode) o1;
                                TreeNode node1 = (TreeNode) o2;
                                String str1 = node0.getText();
                                String str2 = node1.getText();
                                int val = str1.compareTo(str2);
                                if (!asc) {
                                    val = -1 * val;
                                }
                                return val;
                            }
                        });
                    }
                }
            });

            form.addButton(selectedButton);
            form.addButton(sortButton);

            Panel verticalPanel = new Panel();
            verticalPanel.setLayout(new VerticalLayout(15));
            verticalPanel.add(treePanel);
            verticalPanel.add(form);
            panel.add(verticalPanel);
        }

        return panel;
    }

    public String getIntro() {
        return "This example demonstrates sorting of tree nodes. Select on any Tree Node, pick a sort direction and click the sort button. " +
                "All children will be sorted by the specified sort direction.";
    }
}