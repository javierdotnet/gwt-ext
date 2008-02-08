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
import com.gwtext.client.core.Template;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.ComboBoxConfig;
import com.gwtext.client.widgets.tree.*;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class EditableTreePanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return "tree/EditableTreePanel.java.html";
    }

    public String getDataUrl() {
        return "tree/EditableTreePanel.xml.html";
    }

    public Panel getViewPanel() {

        final Store store = new SimpleStore(new String[]{"abbr", "country"}, SampleData.getCountries());

        final Template template = new Template("<div class=\"x-combo-list-item\"><img src=\"images/flags/{abbr}.gif\"> " +
                "{country}<div class=\"x-clear\"></div></div>");


        ComboBox cb = new ComboBox(new ComboBoxConfig() {
            {
                setMinChars(1);
                setFieldLabel("Countries");
                setStore(store);
                setDisplayField("country");
                setMode("local");
                setTriggerAction("all");
                setEmptyText("Select Country");
                setTypeAhead(true);
                setSelectOnFocus(true);
                setWidth(60);
                setResizable(true);
                setTpl(template);
                setTitle("Countries");
                setAllowBlank(false);
            }
        });

        final TreePanel editableTreePanel = new TreePanel("editable-tree", new TreePanelConfig() {
            {
                setAnimate(true);
                setEnableDD(true);
                setContainerScroll(true);
                setRootVisible(true);
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

        editableTreePanel.setRootNode(root);
        editableTreePanel.render();

        root.expand();
        editableTreePanel.expandAll();

        TreeEditor treeEditor = new TreeEditor(editableTreePanel, cb);

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Editable Tree</h1>"));
        panel.add(new HTML("<p>This example shows how to create an Editable Ajax Tree loaded asynchronously using XML data retreived from the server. Double click the tree node to edit its value. The tree also supports Drag and Drop.</p>"));
        panel.add(editableTreePanel);

        return panel;
    }
}