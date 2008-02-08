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
package com.gwtext.sample.showcase.client.grid;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.PagingToolbar;
import com.gwtext.client.widgets.PagingToolbarConfig;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class LocalPagingGridPanel extends ShowcaseExampleVSD {

    public String getDataUrl() {
        return "data/CompanyData.java.html";
    }

    public String getSourceUrl() {
        return "grid/LocalPagingGridPanel.java.html";
    }

    public Panel getViewPanel() {
        PagingMemoryProxy proxy = new PagingMemoryProxy(SampleData.getCompanyData());
        RecordDef recordDef = new RecordDef(
                new FieldDef[]{
                        new StringFieldDef("company"),
                        new FloatFieldDef("price"),
                        new FloatFieldDef("change"),
                        new FloatFieldDef("pctChange"),
                        new DateFieldDef("lastChanged", "n/j h:ia")
                }
        );

        ArrayReader reader = new ArrayReader(recordDef);
        Store store = new Store(proxy, reader);

        //setup column model
        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setHeader("Company");
                        setWidth(160);
                        setSortable(true);
                        setLocked(false);
                        setDataIndex("company");
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Price");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("price");
                        setRenderer(new Renderer() {
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                                return "$" + value;
                            }
                        });
                    }
                },
                new ColumnConfig() {
                    {
                        setId("change");
                        setHeader("Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("change");
                        setRenderer(new Renderer() {
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                                if (((Float) value).floatValue() < 0) {
                                    return "<span style='color:red;'>" + value + "</span>";
                                } else {
                                    return value.toString();
                                }
                            }
                        });
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("% Change");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("pctChange");
                    }
                }
        });

        //create and render grid
        GridConfig config = new GridConfig();
        config.setAutoExpandColumn("pctChange");

        final Grid grid = new Grid("grid-local-paging", "420px", "160px", store, columnModel);
        grid.render();

        ExtElement gridFoot = grid.getView().getFooterPanel(true);

        PagingToolbar pagingToolbar = new PagingToolbar(gridFoot, store, new PagingToolbarConfig() {
            {
                setPageSize(5);
                setDisplayInfo(true);
                setDisplayMsg("Displaying companies {0} - {1} of {2}");
                setEmptyMsg("No records to display");
            }
        });

        store.load(0, 5);

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Array Grid Example with Local paging</h1>"));
        panel.add(new HTML("<p>This example shows how to create a grid from Array data with local paging.</p>"));
        panel.add(grid);

        return panel;
    }
}