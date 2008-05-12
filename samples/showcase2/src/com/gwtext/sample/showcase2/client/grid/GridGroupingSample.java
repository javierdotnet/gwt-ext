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

import com.gwtext.client.core.SortDir;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GroupingView;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.SampleGrid;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class GridGroupingSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/GridGroupingSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            MemoryProxy proxy = new MemoryProxy(SampleData.getCompanyDataLarge());
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

            ArrayReader reader = new ArrayReader(recordDef);

            GroupingStore store = new GroupingStore();
            store.setReader(reader);
            store.setDataProxy(proxy);
            store.setSortInfo(new SortState("company", SortDir.ASC));
            store.setGroupField("industry");
            store.load();


            GroupingView gridView = new GroupingView();
            gridView.setForceFit(true);
            gridView.setGroupTextTpl("{text} ({[values.rs.length]} {[values.rs.length > 1 ? \"Items\" : \"Item\"]})");

            GridPanel grid = new SampleGrid();
            grid.setStore(store);
            grid.setView(gridView);
            grid.setFrame(true);
            grid.setWidth(620);
            grid.setHeight(400);
            grid.setCollapsible(true);
            grid.setAnimCollapse(false);
            grid.setTitle("Grouping Example");
            grid.setIconCls("grid-icon");

            panel = new Panel();
            panel.add(grid);
        }
        return panel;
    }

    public String getIntro() {
        return "This is an example of a Grouping Grid where data is grouped on a certain data column of the underlying Store. " +
                "In this example the grouping is done on Industry type.";
    }
}