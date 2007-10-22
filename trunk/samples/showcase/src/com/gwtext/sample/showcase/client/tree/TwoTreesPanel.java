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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.dd.DragDrop;
import com.gwtext.client.widgets.form.CheckboxConfig;
import com.gwtext.client.widgets.form.FieldSetConfig;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.Radio;
import com.gwtext.client.widgets.tree.*;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class TwoTreesPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "tree/TwoTreesPanel.java.html";
    }

    public String getDataUrl() {
        return "tree/TwoTreesPanel.xml.html";
    }

    public Panel getViewPanel() {

        //create form for nody drop style
        Form form = new Form(300);
        form.fieldset(new FieldSetConfig() {
            {
                setHideLabels(true);
                setLegend("Drop style");
            }
        });
        final Radio moveRadio = new Radio(new CheckboxConfig() {
            {
                setName("dropstyle");
                setBoxLabel("Move");
                setChecked(true);
            }
        });
        form.add(moveRadio);

        final Radio copyRadio = new Radio(new CheckboxConfig() {
            {
                setName("dropstyle");
                setBoxLabel("Copy");
            }
        });
        form.add(copyRadio);
        form.end();
        form.render();

        //create source countried tree
        final TreePanel treePanel = new TreePanel("coutries-grouped", new TreePanelConfig() {
            {
                setAnimate(true);
                setEnableDrag(true);
                setEnableDrop(false);
                setContainerScroll(true);
                setRootVisible(true);
            }
        });

        final XMLTreeLoader loader = new XMLTreeLoader(new XMLTreeLoaderConfig() {
            {
                setDataUrl("countries-grouped.xml");
                setMethod("get");
                setRootTag("countries");
                setFolderTitleMapping("@title");
                setFolderTag("continent");
                setLeafTitleMapping("@title");
                setLeafTag("country");
                setQtipMapping("@qtip");
                setIconMapping("@icon");
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

        //create target vacation tree
        final TreePanel tripTreePanel = new TreePanel("vacation-tree", new TreePanelConfig() {
            {
                setAnimate(true);
                setEnableDD(true);
                setContainerScroll(true);
                setRootVisible(true);
            }
        });

        final XMLTreeLoader tripLoader = new XMLTreeLoader(new XMLTreeLoaderConfig() {
            {
                setDataUrl("trip.xml");
                setMethod("get");
                setRootTag("vacations");
                setFolderIdMapping("@title");
                setFolderTag("trip");
                setQtipMapping("@qtip");
                setIconMapping("@icon");
                setAttributeMappings(new String[]{"@trip"});
            }
        });

        AsyncTreeNode tripRoot = new AsyncTreeNode("Places to Visit", new AsyncTreeNodeConfig() {
            {
                setLoader(tripLoader);
            }
        });

        tripTreePanel.setRootNode(tripRoot);
        tripTreePanel.render();

        tripRoot.expand();
        tripTreePanel.expandAll();

        //add trip tree listener that handles move / copy logic
        tripTreePanel.addTreePanelListener(new TreePanelListenerAdapter() {
            public boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, String point, DragDrop source, TreeNode dropNode, DropNodeCallback dropDropNodeCallback) {
                if("true".equals(target.getAttribute("trip"))) {
                    if(copyRadio.getValue()) {
                        TreeNode copyNode = dropNode.clone();
                        dropDropNodeCallback.setDropNode(copyNode);
                    }
                }
                return true;
            }
        });

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        DOM.setElementAttribute(horizontalPanel.getElement(), "id", "two-trees-panel");
        horizontalPanel.setSpacing(50);

        horizontalPanel.add(treePanel);
        horizontalPanel.add(tripTreePanel);

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Two Tree Drag Drop</h1>"));
        panel.add(new HTML("<p>This example shows how to Drag & Drop nodes between trees. Also illustrates how to move a node on drop or make a copy.</p>"));
        panel.add(form);
        panel.add(horizontalPanel);

        return panel;
    }
}