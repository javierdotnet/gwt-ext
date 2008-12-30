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

import com.google.gwt.user.client.Timer;
import com.gwtext.client.core.Connection;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Tool;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.tree.AsyncTreeNode;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.XMLTreeLoader;
import com.gwtext.sample.showcase2.client.Showcase2;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class CheckboxTreePanel extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/tree/CheckboxTreePanel.java.html";
    }

    public String getXmlDataUrl() {
        return "source/tree/CheckboxTreePanel.xml.html";
    }

    public String getCssUrl() {
        return "source/tree/CheckboxTreePanel.css.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            final TreePanel treePanel = new TreePanel();
            treePanel.setTitle("Checkbox Tree");
            treePanel.setCollapsible(true);
            treePanel.setIconCls("world-icon");
            treePanel.setHeight(400);
            treePanel.setWidth(200);
            treePanel.setAnimate(true);
            treePanel.setEnableDD(true);
            treePanel.setContainerScroll(true);
            treePanel.setAutoScroll(true);
            treePanel.setRootVisible(true);
            treePanel.setFrame(true);


            XMLTreeLoader loader = new XMLTreeLoader();
            loader.setDataUrl("countries-cb.xml");
            loader.setMethod(Connection.GET);
            loader.setRootTag("countries");
            loader.setFolderIdMapping("@id");
            loader.setLeafIdMapping("@id");
            loader.setFolderTitleMapping("@title");
            loader.setFolderTag("team");
            loader.setLeafTitleMapping("@title");
            loader.setLeafTag("country");
            loader.setQtipMapping("@qtip");
            loader.setDisabledMapping("@disabled");
            loader.setCheckedMapping("@checked");
            loader.setIconMapping("@icon");
            loader.setAttributeMappings(new String[]{"@rank"});

            final AsyncTreeNode root = new AsyncTreeNode("Countries", loader);
            treePanel.setRootNode(root);

            root.expand();

            treePanel.addTool(new Tool(Tool.REFRESH, new Function() {
                public void execute() {
                    treePanel.getEl().mask("Loading", "x-mask-loading");
                    root.reload();
                    root.collapse(true, false);
                    Timer timer = new Timer() {
                        public void run() {
                            treePanel.getEl().unmask();
                            root.expand(true, true);
                        }
                    };
                    timer.schedule(1000);
                }
            }, "Refresh"));

            treePanel.expandAll();


            Button button = new Button("Show Checked", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    TreeNode[] checkedNodes = treePanel.getChecked();
                    String checkedNodesString = "";
                    for (int i = 0; i < checkedNodes.length; i++) {
                        TreeNode checkedNode = checkedNodes[i];
                        checkedNodesString += "<br>" + checkedNode.getText();
                    }
                    Showcase2.showMessage("Checked Nodes", checkedNodesString);
                }
            });

            Button toggle = new Button("Toggle Team A", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    treePanel.getNodeById("team-a").getUI().toggleCheck();
                }
            });

            treePanel.addButton(button);
            treePanel.addButton(toggle);

            panel.add(treePanel);
        }
        return panel;

    }

    public String getIntro() {
        return "This example demonstrates TreeNodes with Checkboxes.";
    }
}