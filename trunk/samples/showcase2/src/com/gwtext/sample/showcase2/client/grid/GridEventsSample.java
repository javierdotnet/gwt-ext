/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.grid;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.event.*;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class GridEventsSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/GridEventsSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            GridPanel grid = new SampleGrid(true);
            grid.setTitle("Grid Events");
            grid.setHeight(350);
            grid.setWidth(600);

            grid.addGridCellListener(new GridCellListener() {
                public void onCellClick(GridPanel grid, int rowIndex, int colindex, EventObject e) {
                    log(EVENT, "GridCellListener.onCellClick::row(" + rowIndex + "), col(" + colindex + ");");
                }

                public void onCellContextMenu(GridPanel grid, int rowIndex, int colIndex, EventObject e) {
                    log(EVENT, "GridCellListener.onCellContextMenu::row(" + rowIndex + "), col(" + colIndex + ");");
                }

                public void onCellDblClick(GridPanel grid, int rowIndex, int colIndex, EventObject e) {
                    log(EVENT, "GridCellListener.onCellDblClick::row(" + rowIndex + "), col(" + colIndex + ");");
                }
            });

            grid.addGridColumnListener(new GridColumnListener() {
                public void onColumnMove(GridPanel grid, int oldIndex, int newIndex) {
                    log(EVENT, Format.format("GridCellListener.onColumnMove::oldIndex({0}), newIndex({1})", oldIndex, newIndex));
                }

                public void onColumnResize(GridPanel grid, int colIndex, int newSize) {
                    log(EVENT, Format.format("GridCellListener.onColumnResize::oldIndex({0}), newSize({1})", colIndex, newSize));
                }
            });

            grid.addGridHeaderListener(new GridHeaderListener() {
                public void onHeaderClick(GridPanel grid, int colIndex, EventObject e) {
                    log(EVENT, Format.format("GridHeaderListener.onHeaderClick::colIndex({0}))", colIndex));
                }

                public void onHeaderContextMenu(GridPanel grid, int colIndex, EventObject e) {
                    log(EVENT, Format.format("GridHeaderListener.onHeaderContextMenu::colIndex({0}))", colIndex));
                }

                public void onHeaderDblClick(GridPanel grid, int colIndex, EventObject e) {
                    log(EVENT, Format.format("GridHeaderListener.onHeaderDblClick::colIndex({0}))", colIndex));
                }
            });

            grid.addGridListener(new GridListener() {
                public void onBodyScroll(int scrollLeft, int scrollTop) {
                    log(EVENT, Format.format("GridListener.onBodyScroll::scrollLeft({0}, scrollTop({1})))", scrollLeft, scrollTop));
                }

                public void onClick(EventObject e) {
                    log(EVENT, "GridListener.onClick");
                }

                public void onContextMenu(EventObject e) {
                    log(EVENT, "GridListener.onContextMenu");
                }

                public void onDblClick(EventObject e) {
                    log(EVENT, "GridListener.onDblClick");
                }

                public void onKeyDown(EventObject e) {
                    log(EVENT, "GridListener.onKeyDown");
                }

                public void onKeyPress(EventObject e) {
                    log(EVENT, "GridListener.onKeyPress");
                }
            });


            grid.addGridRowListener(new GridRowListener() {
                public void onRowClick(GridPanel grid, int rowIndex, EventObject e) {
                    log(EVENT, Format.format("GridRowListener.onRowClick::rowIndex({0})", rowIndex));
                }

                public void onRowDblClick(GridPanel grid, int rowIndex, EventObject e) {
                    log(EVENT, Format.format("GridRowListener.onRowDblClick::rowIndex({0})", rowIndex));
                }

                public void onRowContextMenu(GridPanel grid, int rowIndex, EventObject e) {
                    log(EVENT, Format.format("GridRowListener.onRowContextMenu::rowIndex({0}), x({1}), y({2})", rowIndex, e.getPageX(), e.getPageY()));
                }
            });

            panel.add(grid);
        }
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "This example illustrates various events that a Grid fires.";
    }
}