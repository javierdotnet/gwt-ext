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
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.Grid;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class JsonGridPanel extends ShowcaseExampleVSD {

    public String getDataUrl() {
        return "data/CountryData.json.html";
    }

    public String getSourceUrl() {
        return "grid/JsonGridPanel.java.html";
    }

    public Panel getViewPanel() {
        HttpProxy dataProxy = new HttpProxy("countries.json");
        JsonReader reader = new JsonReader(new JsonReaderConfig() {
            {
                setRoot("data");
                setTotalProperty("totalCount");
            }
        }, new RecordDef(new FieldDef[]{
                new StringFieldDef("abbr", "abbr"),
                new StringFieldDef("name", "name"),
                new IntegerFieldDef("area", "area"),
                new IntegerFieldDef("population", "population"),
        }));

        final Store store = new Store(dataProxy, reader, true);
        store.load();

        //setup column model
        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setHeader("Abbreviation");
                        setWidth(160);
                        setSortable(true);
                        setLocked(false);
                        setDataIndex("abbr");
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Country");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("name");
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Area");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("area");
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Population");
                        setWidth(75);
                        setSortable(true);
                        setDataIndex("population");
                    }
                }
        });

        //create and render grid
        final Grid grid = new Grid("grid-example-json", "460px", "300px", store, columnModel);
        grid.render();

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Json Grid Example</h1>"));
        panel.add(new HTML("<p>This example shows how to create a grid from remote Json data.</p>"));
        panel.add(grid);

        return panel;
    }
}