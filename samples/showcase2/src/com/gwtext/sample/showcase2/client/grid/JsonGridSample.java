/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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