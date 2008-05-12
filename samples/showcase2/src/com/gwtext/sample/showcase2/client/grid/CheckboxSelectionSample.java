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