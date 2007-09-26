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
import com.gwtext.client.widgets.tree.*;
import com.gwtext.sample.showcase.client.Showcase;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class CheckboxTreePanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "tree/CheckboxTreePanel.java.html";
    }

    public String getDataUrl() {
        return "tree/CheckboxTreePanel.xml.html";
    }

    public Panel getViewPanel() {

        final TreePanel treePanel = new TreePanel("cb-tree", new TreePanelConfig() {
            {
                setAnimate(true);
                setEnableDD(true);
                setContainerScroll(true);
                setRootVisible(true);
            }
        });

        final XMLTreeLoader loader = new XMLTreeLoader(new XMLTreeLoaderConfig() {
            {
                setDataUrl("countries-cb.xml");
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

        Button button = new Button(new ButtonConfig() {
            {
                setText("Show Checked");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        TreeNode[] checkedNodes = treePanel.getChecked();
                        String checkedNodesString = "";
                        for (int i = 0; i < checkedNodes.length; i++) {
                            TreeNode checkedNode = checkedNodes[i];
                            checkedNodesString += "<br>" + checkedNode.getText();
                        }
                        Showcase.showMessage("Checked Nodes", checkedNodesString);
                    }
                });
            }
        });


        Panel panel = createPanel();
        panel.add(new HTML("<h1>Checkbox Tree</h1>"));
        panel.add(new HTML("<p>This example shows how to create an Checkbox Tree loaded from XML data</p>"));
        panel.add(treePanel);
        panel.add(button);
        return panel;
    }
}