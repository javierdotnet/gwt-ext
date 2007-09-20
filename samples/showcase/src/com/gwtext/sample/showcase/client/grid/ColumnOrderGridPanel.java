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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.*;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class ColumnOrderGridPanel extends ShowcaseExampleVSD {

    public String getDataUrl() {
        return "data/CountryData.java.html";
    }

    public String getSourceUrl() {
       return "grid/ColumnOrderGridPanel.java.html";
    }

    public Panel getViewPanel() {
        MemoryProxy proxy = new MemoryProxy(SampleData.getCountries());
        RecordDef recordDef = new RecordDef(
                new FieldDef[]{
                        new StringFieldDef("abbr"),
                        new StringFieldDef("name"),
                        new StringFieldDef("capital"),
                        new StringFieldDef("continent"),
                        new IntegerFieldDef("population"),
                        new IntegerFieldDef("area")
                }
        );

        ArrayReader reader = new ArrayReader(recordDef);

        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setHeader("Flag");
                        setWidth(50);
                        setSortable(false);
                        setDataIndex("abbr");
                        setRenderer(new Renderer() {
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                                return Format.format("<img src=\"images/flags/{0}.gif\">", new String[]{record.getAsString("abbr")});
                            }
                        });
                    }
                },
                new ColumnConfig() {
                    {
                        setHeader("Country");
                        setWidth(100);
                        setSortable(true);
                        setDataIndex("name");
                    }
                },
                new ColumnConfig() {
                    {
                        setId("capitalCol");
                        setHeader("Capital");
                        setWidth(100);
                        setSortable(true);
                        setDataIndex("capital");
                    }
                },
                new ColumnConfig() {
                    {
                        setId("continentCol");
                        setHeader("Continent");
                        setWidth(100);
                        setDataIndex("continent");
                    }
                }
        });


        Store store = new Store(proxy, reader);

        //create and render grid
        final Grid grid = new Grid("grid-example-col", "460px", "300px", store, columnModel, new GridConfig() {
            {
                setAutoExpandColumn("continentCol");
            }
        });

        grid.render();
        store.load();

        Button show = new Button(new ButtonConfig() {
            {
                setText("Show Capitals");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        grid.showColumn("capitalCol");
                    }
                });
            }
        });

        Button hide = new Button(new ButtonConfig() {
            {
                setText("Hide Capitals");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        grid.hideColumn("capitalCol");
                    }
                });
            }
        });

        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(15);
        buttonPanel.add(show);
        buttonPanel.add(hide);

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Grid Column Order Example</h1>"));
        panel.add(new HTML("<p>This example shows how to programatically hide and display columns.</p>"));
        panel.add(grid);
        panel.add(buttonPanel);

        return panel;
    }
}