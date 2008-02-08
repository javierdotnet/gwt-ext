/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.grid;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class LargeGridSample extends ShowcasePanel {
    private Store store;

    public String getSourceUrl() {
        return "source/grid/LargeGridSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
			panel = new Panel();
			panel.setLayout(new FitLayout());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("company"),
                            new FloatFieldDef("price"),
                            new FloatFieldDef("change"),
                            new FloatFieldDef("pctChange"),
                            new DateFieldDef("lastChanged", "n/j h:ia"),
                            new StringFieldDef("symbol"),
                            new StringFieldDef("industry")
                    }
            );

            final GridPanel gridPanel = new GridPanel();

            Object[][] data = SampleData.getCompanyDataLarge();
            MemoryProxy proxy = new MemoryProxy(data);

            ArrayReader reader = new ArrayReader(recordDef);
            store = new Store(proxy, reader);
            store.load();
            gridPanel.setStore(store);

            ColumnConfig[] columns = new ColumnConfig[]{
                    //column ID is company which is later used in setAutoExpandColumn
                    new ColumnConfig("Company", "company", 160, true, null, "company"),
                    new ColumnConfig("Price", "price", 35),
                    new ColumnConfig("Change", "change", 45),
                    new ColumnConfig("% Change", "pctChange", 65),
                    new ColumnConfig("Last Updated", "lastChanged", 65),
                    new ColumnConfig("Industry", "industry", 60, true)
            };

            ColumnModel columnModel = new ColumnModel(columns);
            gridPanel.setColumnModel(columnModel);

            gridPanel.setTitle("Large Grid");
            gridPanel.setEnableColumnResize(false);
            gridPanel.setEnableDragDrop(false);
            gridPanel.setEnableColumnHide(false);
            gridPanel.setEnableColumnMove(false);

            Toolbar top = new Toolbar();
            top.addItem(new ToolbarTextItem("This example dynamically generates data to populate the grid. Creating very large Grids might cause the browser to get unstable and might require a restart."));
            gridPanel.setTopToolbar(top);

            Toolbar bottom = new Toolbar();
            bottom.addItem(new ToolbarTextItem("<sup>*</sup>Total time for Grid update includes the time taken to generate the local data"));

            bottom.addFill();
            bottom.addItem(new ToolbarTextItem("Columns"));
            bottom.addSpacer();
            final NumberField cols = new NumberField("Columns", "numCols", 40, 10);
            cols.setAllowDecimals(false);
            bottom.addField(cols);

            bottom.addSeparator();

            bottom.addItem(new ToolbarTextItem("Rows"));
            bottom.addSpacer();
            final NumberField rows = new NumberField("Rows", "numRows", 40, 200);
            rows.setAllowDecimals(false);
            bottom.addField(rows);

            bottom.addSeparator();

            ToolbarButton generateButton = new ToolbarButton("Generate", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    updateGrid(gridPanel, cols.getValue().intValue(), rows.getValue().intValue());
                }
            });
            generateButton.setIconCls("database-add-icon");
            bottom.addButton(generateButton);

            ToolbarButton clearButton = new ToolbarButton("Clear Data", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    store.removeAll();
                }
            });
            clearButton.setIconCls("database-delete-icon");
            bottom.addButton(clearButton);

            gridPanel.setBottomToolbar(bottom);
            panel.add(gridPanel);
        }
        return panel;
    }

    private void updateGrid(GridPanel gridPanel, int cols, int rows) {
        if (store != null) {
            store.removeAll();
        }

        Object[][] data = new Object[rows][cols];
        ColumnConfig[] columns = new ColumnConfig[cols];
        FieldDef[] fields = new FieldDef[cols];

        for (int i = 0; i < cols; i++) {
            String colName = "Column" + i;
            fields[i] = new StringFieldDef(colName);
            columns[i] = new ColumnConfig(colName, colName, 90);
        }

        RecordDef recordDef = new RecordDef(fields);
        ColumnModel columnModel = new ColumnModel(columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = "(" + i + "," + j + ")";
            }
        }

        MemoryProxy proxy = new MemoryProxy(data);
        ArrayReader reader = new ArrayReader(recordDef);
        store = new Store(proxy, reader);
        store.load();

        gridPanel.reconfigure(store, columnModel);
    }
}