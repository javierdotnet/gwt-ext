/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.grid;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class CheckboxSelectionSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/CheckboxSelectionSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new VerticalLayout(15));

            final CheckboxSelectionModel cbSelectionModel = new CheckboxSelectionModel();

            GridPanel grid = new SampleGrid() {

                protected ColumnModel getColumnConfigs() {
                    BaseColumnConfig[] columnConfigs = new BaseColumnConfig[columns.length + 1];
                    columnConfigs[0] = new CheckboxColumnConfig(cbSelectionModel);
                    for (int i = 0; i < columns.length; i++) {
                        BaseColumnConfig column = columns[i];
                        columnConfigs[i + 1] = column;
                    }
                    return new ColumnModel(columnConfigs);
                }
            };

            grid.setSelectionModel(cbSelectionModel);
            grid.setWidth(600);
            grid.setHeight(300);
            grid.setFrame(true);
            grid.setTitle("Framed with Checkbox Selection with Horizontal Scrolling");
            grid.setIconCls("grid-icon");

            Button button = new Button("Get Selected", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    Record[] records = cbSelectionModel.getSelections();
                    String msg = "";
                    for (int i = 0; i < records.length; i++) {
                        Record record = records[i];
                        msg += record.getAsString("company") + " ";
                    }
                    log(MESSAGE, "Records Selected :" + msg);
                }
            });

            panel.add(grid);
            panel.add(button);
        }
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "In this example the Grid has a Frame with a Checkbox selection column.";
    }
}