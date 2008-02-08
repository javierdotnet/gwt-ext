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
import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.dd.DragData;
import com.gwtext.client.dd.DragDrop;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.form.CheckboxConfig;
import com.gwtext.client.widgets.form.FieldSetConfig;
import com.gwtext.client.widgets.form.Form;
import com.gwtext.client.widgets.form.Radio;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.tree.*;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class GridTreeDDPanel extends ShowcaseExampleVSD {

    public String getSourceUrl() {
        return null;
    }

    public String getDataUrl() {
        return null;
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

        //create source countries grid
        final Store store = new SimpleStore(new String[]{"abbr", "country"}, SampleData.getCountries());

        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setId("abbr");
                        setHeader("Flag");
                        setWidth(50);
                        setSortable(true);
                        setDataIndex("abbr");
                        setRenderer(new Renderer() {
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                                return Format.format("<img src=\"images/flags/{0}.gif\">", new String[]{record.getAsString("abbr")});
                            }
                        });
                    }
                },
                new ColumnConfig() {
                    {
                        setId("country");
                        setHeader("Country");
                        setWidth(90);
                        setSortable(true);
                        setDataIndex("country");
                    }
                }
        });

        GridConfig gridConfig = new GridConfig();
        gridConfig.setEnableDragDrop(true);
        gridConfig.setDdGroup("myDDGroup");


        final Grid grid = new Grid("grid-tree-example", "160px", "300px", store, columnModel, gridConfig);

        grid.render();
        store.load();

        //create target vacation tree
        final TreePanel tripTreePanel = new TreePanel("vacation-tree2", new TreePanelConfig() {
            {
                setAnimate(true);
                setEnableDD(true);
                setContainerScroll(true);
                setRootVisible(true);
                setDdGroup("myDDGroup");
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
            public boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode, DropNodeCallback dropNodeCallback) {
                if (dragData instanceof GridDragData) {
                    GridDragData gridDragData = (GridDragData) dragData;
                    Record[] records = gridDragData.getSelections();
                    TreeNode[] copyNodes = new TreeNode[records.length];
                    for (int i = 0; i < records.length; i++) {
                        final Record record = records[i];
                        TreeNode copyNode = new TreeNode(record.getAsString("country"), new TreeNodeConfig() {
                            {
                                setIcon("images/flags/" + record.getAsString("abbr") + ".gif");
                            }
                        });

                        copyNodes[i] = copyNode;
                        target.appendChild(copyNode);
                        if (moveRadio.getValue()) {
                            Grid grid = gridDragData.getGrid();
                            Store store = grid.getStore();
                            store.remove(record);
                            store.commitChanges();
                        }
                    }
                }
                return true;
            }
        });

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        DOM.setElementAttribute(horizontalPanel.getElement(), "id", "two-trees-panel");
        horizontalPanel.setSpacing(50);

        horizontalPanel.add(grid);
        horizontalPanel.add(tripTreePanel);

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Grid to Tree Drag Drop</h1>"));
        panel.add(new HTML("<p>This example shows how to Drag & Drop from a Grid to a Tree.</p>"));
        panel.add(form);
        panel.add(horizontalPanel);

        return panel;
    }
}