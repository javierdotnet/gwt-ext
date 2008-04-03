/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.charts.client.yui;

import com.gwtext.client.core.GenericConfig;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.chart.yui.ColumnChart;
import com.gwtext.client.widgets.chart.yui.SeriesDefY;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.EditorGridListenerAdapter;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.sample.charts.client.ShowcasePanel;

public class ColumnChartSkinnedSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/yui/ColumnChartSkinnedSample.java.html";
	}

	public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            panel.setLayout(new VerticalLayout(15));

            MemoryProxy proxy = new MemoryProxy(getData());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("month"),
                            new IntegerFieldDef("pork"),
                            new IntegerFieldDef("beef")
                    }
            );

            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(proxy, reader);
            store.load();

            GenericConfig porkStyle = new GenericConfig();
            porkStyle.setProperty("image", "images/tube.png");
            porkStyle.setProperty("mode", "no-repeat");
            porkStyle.setProperty("color", "0x2e434d");
            porkStyle.setProperty("size", 40);

            GenericConfig beefStyle = new GenericConfig();
            beefStyle.setProperty("image", "images/tube.png");
            beefStyle.setProperty("mode", "no-repeat");
            beefStyle.setProperty("color", "0xc2d81e");
            beefStyle.setProperty("size", 40);

            SeriesDefY[] seriesDef = new SeriesDefY[]{
                    new SeriesDefY("Sales of Pork", "pork", porkStyle),
                    new SeriesDefY("Sales of Beef", "beef", beefStyle)
            };


            final ColumnChart chart = new ColumnChart();
			chart.setWMode("transparent");
            chart.setStore(store);
            chart.setSeries(seriesDef);
            chart.setXField("month");

            chart.setExpressInstall("js/yui/assets/expressinstall.swf");
            chart.setWidth(500);
            chart.setHeight(400);

            panel.add(chart);

            ColumnConfig monthConfig = new ColumnConfig("Month", "month", 60, true);
            monthConfig.setId("monthCol");
            TextField textField = new TextField();
            textField.setSelectOnFocus(true);
            monthConfig.setEditor(new GridEditor(textField));

            NumberField numberField = new NumberField();
            numberField.setSelectOnFocus(true);

            NumberField numberField2 = new NumberField();
            numberField2.setSelectOnFocus(true);

            ColumnConfig porkConfig = new ColumnConfig("Pork", "pork", 150, true);
            porkConfig.setEditor(new GridEditor(numberField));

            ColumnConfig beefConfig = new ColumnConfig("Beef", "beef", 150, true);
            beefConfig.setEditor(new GridEditor(numberField2));

            ColumnModel columnModel = new ColumnModel(new ColumnConfig[] {
                    monthConfig,
                    porkConfig,
                    beefConfig
            });

            EditorGridPanel grid = new EditorGridPanel();
            grid.setStore(store);
            grid.setClicksToEdit(1);
            grid.setColumnModel(columnModel);
            grid.setWidth(500);
            grid.setAutoExpandColumn("monthCol");

            grid.addEditorGridListener(new EditorGridListenerAdapter() {
                public void onAfterEdit(GridPanel grid, Record record, String field, Object newValue, Object oldValue, int rowIndex, int colIndex) {
                    store.commitChanges();
                    chart.refresh();
                }
            });

            panel.add(grid);
        }
        return panel;
    }

    private static Object[][] getData() {
        return new Object[][]{
                new Object[]{"Oct", new Integer(1354), new Integer(1442)},
                new Object[]{"Nov", new Integer(1326), new Integer(1496)},
                new Object[]{"Dec", new Integer(1292), new Integer(1582)},
                new Object[]{"Jan", new Integer(1387), new Integer(1597)},
                new Object[]{"Feb", new Integer(1376), new Integer(1603)}
        };
    }

    public String getIntro() {
        return "<p>This is an example of a Column Chart. This example demonstrates how to modify the YUI Charts Control's styles to give it a custom appearance.</p>" +
                "<p>The Chart and Grid are based on the same underlying Store. Try updating the values in the Grid and the changes will be reflected in the Chart.</p>";
    }
}