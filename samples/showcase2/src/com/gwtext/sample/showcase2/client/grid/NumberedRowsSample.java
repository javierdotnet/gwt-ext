/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.grid;

import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class NumberedRowsSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/NumberedRowsSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            GridPanel grid = new SampleGrid() {

                protected ColumnModel getColumnConfigs() {
                    BaseColumnConfig[] columnConfigs = new BaseColumnConfig[columns.length + 1];
                    columnConfigs[0] = new RowNumberingColumnConfig();
                    for (int i = 0; i < columns.length; i++) {
                        BaseColumnConfig column = columns[i];
                        columnConfigs[i + 1] = column;
                    }
                    return new ColumnModel(columnConfigs);
                }
            };

            grid.setTitle("Grid with Numbered Rows and Force Fit");
            grid.setHeight(300);
            grid.setWidth(600);
            grid.setIconCls("grid-icon");

            GridView view = new GridView();
            view.setForceFit(true);
            grid.setView(view);

            panel = new Panel();
            panel.add(grid);
        }
        return panel;
    }

    public String getIntro() {
        return "This example has a Grid with row numbering and Force Fit. ";
    }
}