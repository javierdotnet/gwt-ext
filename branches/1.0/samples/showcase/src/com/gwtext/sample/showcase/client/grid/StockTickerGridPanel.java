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

import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.ButtonConfig;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.sample.showcase.client.SampleData;
import com.gwtext.sample.showcase.client.ShowcaseExampleVSD;

public class StockTickerGridPanel extends ShowcaseExampleVSD {

    public String getDataUrl() {
        return "data/CompanyData.java.html";
    }

    public String getSourceUrl() {
        return "grid/StockTickerGridPanel.java.html";
    }

    public Panel getViewPanel() {
        MemoryProxy proxy = new MemoryProxy(SampleData.getCompanyData());
        RecordDef recordDef = new RecordDef(
                new FieldDef[]{
                        new StringFieldDef("company"),
                        new FloatFieldDef("price"),
                        new FloatFieldDef("change"),
                        new FloatFieldDef("pctChange"),
                        new DateFieldDef("lastChanged", "n/j h:ia"),
                        new StringFieldDef("symbol")
                }
        );


        ArrayReader reader = new ArrayReader(recordDef);
        final Store store = new Store(proxy, reader);
        final NumberFormat nf = NumberFormat.getFormat("#,##0.00", "$");
        final NumberFormat nfc = NumberFormat.getFormat("#,##0.00");

        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                new ColumnConfig() {
                    {
                        setHeader("Company");
                        setWidth(160);
                        setSortable(true);
                        setDataIndex("company");
                    }
                },
                 new ColumnConfig() {
                    {
                        setHeader("Symbol");
                        setWidth(50);
                        setSortable(true);
                        setDataIndex("symbol");
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
                                return nf.format(((Number)value).doubleValue());
                            }
                        });
                    }
                },
                new ColumnConfig() {
                    {
                        setId("change");
                        setHeader("Change");
                        setWidth(75);
                        setDataIndex("change");
                        setRenderer(new Renderer() {
                            public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                                double val = ((Number) value).doubleValue();
                                String valString = nfc.format(val);
                                if (val < 0) {
                                    return "<span style='color:red;'>" + valString + "</span>";
                                } else {
                                    return valString;
                                }
                            }
                        });
                    }
                },
        });

        //create and render grid
        final Grid grid = new Grid("grid-example-stock", "380px", "300px", store, columnModel);
        grid.render();

        store.load();

        final Record[] records = store.getRecords();

        final Timer t = new Timer() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Record rec = records[getRandomInRange(records.length)];
                    double oldPrice = rec.getAsDouble("price");
                    boolean add = Math.random() > 0.5;
                    double delta = Math.random();
                    double newPrice = add? oldPrice + delta : oldPrice - delta;
                    rec.set("price", newPrice);
                    rec.set("change", add ? delta : -1*delta);
                    store.commitChanges();
                }
            }
        };

        Button startButton = new Button(new ButtonConfig() {
            {
                setText("Start updates");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        t.scheduleRepeating(1000);
                    }
                });
            }
        });

        Button stopButton = new Button(new ButtonConfig() {
            {
                setText("Stop updates");
                setButtonListener(new ButtonListenerAdapter() {
                    public void onClick(Button button, EventObject e) {
                        t.cancel();
                    }
                });
            }
        });

        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(15);
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        Panel panel = createPanel();
        panel.add(new HTML("<h1>Stock Ticker Grid Example</h1>"));
        panel.add(new HTML("<p>This example shows how to create a grid and then change the displayed data by updating the underlying Record's in the Store</p>"));
        panel.add(grid);
        panel.add(buttonPanel);

        return panel;
    }

    private static int getRandomInRange(int n) {
        return (int) Math.floor(n * Math.random());
    }
}