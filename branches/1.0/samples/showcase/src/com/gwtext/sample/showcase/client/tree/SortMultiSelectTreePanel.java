/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.sample.showcase.client.tree;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.tree.*;
import com.gwtext.sample.showcase.client.Showcase;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

import java.util.Comparator;

public class SortMultiSelectTreePanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "tree/SortMultiSelectTreePanel.java.html";
    }

    public String getDataUrl() {
        return "tree/EditableTreePanel.xml.html";
    }

    public Panel getViewPanel() {

        final TreePanel treePanel = new TreePanel("sort-multiselect-tree", new TreePanelConfig() {
            {
                setAnimate(true);
                setEnableDD(true);
                setContainerScroll(true);
                setRootVisible(true);
                //this property enables multi-select
                setSelectionModel(new MultiSelectionModel());
            }
        });

        final XMLTreeLoader loader = new XMLTreeLoader(new XMLTreeLoaderConfig() {
            {
                setDataUrl("countries.xml");
                setMethod("get");
                setRootTag("countries");
                setFolderTitleMapping("@title");
                setFolderTag("team");
                setLeafTitleMapping("@title");
                setLeafTag("country");
                setQtipMapping("@qtip");
                setDisabledMapping("@disabled");
                setCheckedMapping("@checked");
                setIconMapping("@icon");
                setAttributeMappings(new String[]{"@rank"});
            }
        });
        AsyncTreeNode root = new AsyncTreeNode("Countries", new AsyncTreeNodeConfig() {
            {
                setLoader(loader);
            }
        });

        treePanel.setRootNode(root);
        treePanel.render();

        root.expand();
        treePanel.expandAll();
        root.select();

        Form form = new Form(new FormConfig() {
            {
                setWidth(300);
            }
        });
        form.fieldset(new FieldSetConfig() {
            {
                setHideLabels(true);
                setLegend("Sort Direction");
            }
        });
        final Radio ascRadio = new Radio(new CheckboxConfig() {
            {
                setName("direction");
                setBoxLabel("Ascending");
                setChecked(true);
            }
        });
        form.add(ascRadio);

        final Radio descRadio = new Radio(new CheckboxConfig() {
            {
                setName("direction");
                setBoxLabel("Descending");
                setChecked(false);
            }
        });
        form.add(descRadio);
        form.end();

        Button selectedButton = new Button(new ButtonConfig() {
            {
                setText("Show Selected");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        MultiSelectionModel selectionModel = (MultiSelectionModel) treePanel.getSelectionModel();
                        TreeNode[] nodes = selectionModel.getSelectedNodes();
                        String nodesString = "";
                        for (int i = 0; i < nodes.length; i++) {
                            TreeNode node = nodes[i];
                            nodesString += "<br>" + node.getText();
                        }
                        Showcase.showMessage("Selected Nodes", nodesString);
                    }
                });
            }
        });

        Button sortButton = new Button(new ButtonConfig() {
            {
                setText("Sort");
                setButtonListener(new ButtonListenerAdapter() {
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
            }
        });

        form.addButton(selectedButton);
        form.addButton(sortButton);
        form.render();

        Panel panel = createPanel();
        panel.add(new HTML("<h1>MultiSelect and Sortable Tree</h1>"));
        panel.add(new HTML("<p>This example shows how to create enable node multi select and also sorting of nodes. Use Crtl + click to select multiple nodes. Select a node and click the 'Sort' button to sort the node's children.</p>"));
        panel.add(form);
        panel.add(treePanel);
        return panel;
    }
}