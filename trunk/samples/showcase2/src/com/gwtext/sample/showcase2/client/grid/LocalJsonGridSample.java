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
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Toolbar;
import com.gwtext.client.widgets.ToolbarButton;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.grid.GridView;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class LocalJsonGridSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/grid/LocalJsonGridSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            
            final String jsonString = "{\n" +
                    "    \"totalCount\" : 15,\n" +
                    "    \"data\":\n" +
                    "            [\n" +
                    "            {\"abbr\":\"au\", \"name\" : \"Australia\", \"capital\" : \"Canberra\",  \"population\" : 18090000, \"area\" : 7713360},\n" +
                    "            {\"abbr\":\"br\", \"name\" :\"Brazil\", \"capital\" : \"Brasilia\",\"population\" : 170000000, \"area\" : 8547404},\n" +
                    "            {\"abbr\":\"ca\", \"name\" :\"Canada\", \"capital\" : \"Ottawa\",\"population\" : 31000000, \"area\" : 9976140},\n" +
                    "            {\"abbr\":\"cn\", \"name\" :\"China\", \"capital\" : \"Beijing\",  \"population\" : 1222017000, \"area\" : 9596960},\n" +
                    "            {\"abbr\":\"de\", \"name\" :\"Germany\", \"capital\" : \"Berlin\", \"population\" : 80942000, \"area\" : 356910},\n" +
                    "            {\"abbr\":\"fr\", \"name\" :\"France\", \"capital\" : \"Paris\",  \"population\" : 57571000, \"area\" : 551500},\n" +
                    "            {\"abbr\":\"in\", \"name\" :\"India\", \"capital\" :  \"New Delhi\",  \"population\" : 913747000, \"area\" : 3287590},\n" +
                    "            {\"abbr\":\"sc\", \"name\" :\"Seychelles\", \"capital\" : \"Victoria\",  \"population\" : 73000, \"area\" : 280},\n" +
                    "            {\"abbr\":\"us\", \"name\" :\"United States\", \"capital\" : \"Washington, DC\", \"population\" : 260513000, \"area\" : 9372610},\n" +
                    "            {\"abbr\":\"jp\", \"name\" :\"Japan\", \"capital\" : \"Tokyo\",  \"population\" : 125422000, \"area\" : 377800},\n" +
                    "            {\"abbr\":\"ie\", \"name\" :\"Italy\", \"capital\" : \"Rome\", \"population\" : 57867000, \"area\" : 301270},\n" +
                    "            {\"abbr\":\"gh\", \"name\" :\"Ghana\", \"capital\" : \"Accra\", \"population\" : 16944000, \"area\" : 238540},\n" +
                    "            {\"abbr\":\"ie\", \"name\" :\"Iceland\", \"capital\" : \"Reykjavik\", \"population\" : 270000, \"area\" : 103000},\n" +
                    "            {\"abbr\":\"fi\", \"name\" :\"Finland\", \"capital\" : \"Helsinki\", \"population\" : 5033000, \"area\" : 338130},\n" +
                    "            {\"abbr\":\"ch\", \"name\" :\"Switzerland\", \"capital\" : \"Berne\", \"population\" : 6910000, \"area\" : 41290}\n" +
                    "                    ]\n" +
                    "}";

            final RecordDef recordDef = new RecordDef(new FieldDef[]{
                    new StringFieldDef("abbr", "abbr"),
                    new StringFieldDef("name", "name"),
                    new IntegerFieldDef("area", "area"),
                    new IntegerFieldDef("population", "population"),
            });
            JsonReader reader = new JsonReader(recordDef);
            reader.setRoot("data");
            reader.setTotalProperty("totalCount");

            final Store store = new Store(reader);

            //setup column model
            ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                    new ColumnConfig("Abbreviation", "abbr", 100, true),
                    new ColumnConfig("Country", "name", 75, true),
                    new ColumnConfig("Area", "area", 75, true),
                    new ColumnConfig("Population", "population", 75, true)
            });

            GridPanel grid = new GridPanel();
            grid.setTitle("Local Json Grid");
            grid.setStore(store);
            grid.setColumnModel(columnModel);
            grid.setFrame(true);
            grid.setWidth(375);
            grid.setHeight(350);
            grid.stripeRows(true);
            grid.setIconCls("grid-icon");

            GridView view = new GridView();
            view.setEmptyText("Press the Load button to load the Local Json data.");
            grid.setView(view);

            Toolbar toolbar = new Toolbar();

            ToolbarButton button = new ToolbarButton("Load Json Data", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    //load the store using local Json data
                    store.loadJsonData(jsonString, true);
                }
            });
            button.setIconCls("add-icon");

            toolbar.addFill();
            toolbar.addButton(button);
            grid.setBottomToolbar(toolbar);

            panel.add(grid);
        }
        return panel;
    }                                          

    public String getIntro() {
        return "This example shows how to populate a grid from Local Json data.";
    }
}