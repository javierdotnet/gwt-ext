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

import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class JsonGridSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/JsonGridSample.java.html";
    }

    public String getJsonDataUrl() {
         return "source/grid/JsonGridSample.json.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            HttpProxy dataProxy = new HttpProxy("data/countries.json");
            final RecordDef recordDef = new RecordDef(new FieldDef[]{
                    new StringFieldDef("abbr", "abbr"),
                    new StringFieldDef("name", "name"),
                    new IntegerFieldDef("area", "area"),
                    new IntegerFieldDef("population", "population"),
            });
            JsonReader reader = new JsonReader(recordDef);
            reader.setRoot("data");
            reader.setTotalProperty("totalCount");

            final Store store = new Store(dataProxy, reader, true);
            store.load();

            ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                    new ColumnConfig("Abbreviation", "abbr", 100, true),
                    new ColumnConfig("Country", "name", 75, true),
                    new ColumnConfig("Area", "area", 75, true),
                    new ColumnConfig("Population", "population", 75, true)
            });

            GridPanel grid = new GridPanel();
            grid.setStore(store);
            grid.setColumnModel(columnModel);
            grid.setWidth(375);
            grid.setHeight(350);
            grid.setTitle("Json Grid");
            grid.setFrame(true);
            grid.stripeRows(true);
            grid.setIconCls("grid-icon");

            panel.add(grid);
        }
        return panel;
    }

    public String getIntro() {
        return "This example shows how to create a grid from remote Json data.";
    }
}