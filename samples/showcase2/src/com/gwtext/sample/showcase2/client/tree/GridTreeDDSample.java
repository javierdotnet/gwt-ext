/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.sample.showcase2.client.tree;

import com.gwtext.client.core.Connection;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.dd.DragData;
import com.gwtext.client.dd.DragDrop;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Component;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.FieldSet;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Radio;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.client.widgets.tree.*;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class GridTreeDDSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/tree/GridTreeDDSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            //create form for nody drop style
            FormPanel formPanel = new FormPanel();
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

            //create source countries grid
            final Store store = new SimpleStore(new String[]{"abbr", "country"}, SampleData.getCountries());
            store.load();

            ColumnConfig[] columns = {
                    new ColumnConfig("Flag", "abbr", 45, true, new Renderer() {
                        public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                            return Format.format("<img src=\"images/flags/{0}.gif\">", new String[]{record.getAsString("abbr")});
                        }
                    }, "abbr"),
                    new ColumnConfig("Code", "abbr", 45),
                    new ColumnConfig("Country", "country", 90, true, null, "country")
            };

            ColumnModel columnModel = new ColumnModel(columns);
            GridPanel countriesGrid = new GridPanel();
			countriesGrid.setTitle("Countries");
			countriesGrid.setStore(store);
            countriesGrid.setColumnModel(columnModel);
            countriesGrid.setHeight(390);
            countriesGrid.setWidth(200);
            countriesGrid.setAutoExpandColumn("country");
            countriesGrid.setEnableDragDrop(true);
            countriesGrid.setDdGroup("myDDGroup");

            //create target vacation tree
            final TreePanel tripTreePanel = new TreePanel();
			tripTreePanel.setTitle("Trip Planner");
			tripTreePanel.setAnimate(true);
            tripTreePanel.setEnableDrop(true);
            tripTreePanel.setDdGroup("myDDGroup");
            tripTreePanel.setContainerScroll(true);
            tripTreePanel.setRootVisible(true);
            tripTreePanel.setWidth(200);
            tripTreePanel.setHeight(390);            

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
            tripRoot.expand();
            tripTreePanel.expandAll();

            //add trip tree listener that handles move / copy logic
            tripTreePanel.addListener(new TreePanelListenerAdapter() {
                public boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, DragData dragData, String point,
                                                DragDrop source, TreeNode dropNode, DropNodeCallback dropDropNodeCallback) {
                    if (dragData instanceof GridDragData) {
                        GridDragData gridDragData = (GridDragData) dragData;
                        Record[] records = gridDragData.getSelections();
                        TreeNode[] copyNodes = new TreeNode[records.length];
                        for (int i = 0; i < records.length; i++) {
                            Record record = records[i];
                            TreeNode copyNode = new TreeNode(record.getAsString("country"));
                            copyNode.setIcon("images/flags/" + record.getAsString("abbr") + ".gif");
                            copyNodes[i] = copyNode;
                            target.appendChild(copyNode);
                            if (moveRadio.getValue()) {
                                GridPanel grid = gridDragData.getGrid();
                                Store store = grid.getStore();
                                store.remove(record);
                                store.commitChanges();
                            }
                        }
                    }
                    return true;
                }
            });

            Panel horizontalPanel = new Panel();
            horizontalPanel.setLayout(new HorizontalLayout(25));
            horizontalPanel.add(countriesGrid);
            horizontalPanel.add(tripTreePanel);

            Panel verticalPanel = new Panel();
            verticalPanel.setLayout(new VerticalLayout(15));

            verticalPanel.add(fieldSet);
            verticalPanel.add(horizontalPanel);

            panel.add(verticalPanel);
        }
        return panel;

    }

    public String getIntro() {
        return "This example demonstrates Drag & Drop from a Grid to a Tree";
    }
}