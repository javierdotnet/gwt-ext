/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.charts.client.yui;

import com.google.gwt.i18n.client.NumberFormat;
import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.chart.yui.LineChart;
import com.gwtext.client.widgets.chart.yui.NumericAxis;
import com.gwtext.client.widgets.chart.yui.SeriesDefY;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.EditorGridListenerAdapter;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.sample.charts.client.ShowcasePanel;

public class LineChartSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/yui/LineChartSample.java.html";
	}

	public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new VerticalLayout(15));

            MemoryProxy proxy = new MemoryProxy(getData());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("month"),
                            new FloatFieldDef("rent"),
                            new FloatFieldDef("utilities")
                    }
            );

            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(proxy, reader);
            store.load();

            SeriesDefY[] seriesDef = new SeriesDefY[]{

                    new SeriesDefY("Rent", "rent"),
                    new SeriesDefY("Utilities", "utilities")

            };

            NumericAxis currencyAxis = new NumericAxis();
            currencyAxis.setMinimum(800);
            currencyAxis.setLabelFunction("formatCurrencyAxisLabel");
            final LineChart chart = new LineChart();
            chart.setTitle("Monthly Expenses");
            chart.setWMode("transparent");
            chart.setStore(store);
            chart.setSeries(seriesDef);
            chart.setXField("month");
            chart.setYAxis(currencyAxis);
            chart.setDataTipFunction("getDataTipText");
            chart.setExpressInstall("js/yui/assets/expressinstall.swf");
            chart.setWidth(500);
            chart.setHeight(400);

            panel.add(chart);


            Renderer renderer = new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    NumberFormat nf = NumberFormat.getCurrencyFormat();
                    return nf.format(((Number) value).doubleValue());
                }
            };
            ColumnConfig monthConfig = new ColumnConfig("Month", "month", 150, true);
            TextField monthField = new TextField();
            monthField.setSelectOnFocus(true);
            monthConfig.setEditor(new GridEditor(monthField));

            NumberField rentField = new NumberField();
            rentField.setSelectOnFocus(true);

            ColumnConfig rentConfig = new ColumnConfig("Rent", "rent", 100, true);
            rentConfig.setEditor(new GridEditor(rentField));
            rentConfig.setRenderer(renderer);

            NumberField utilitiesField = new NumberField();
            utilitiesField.setSelectOnFocus(true);

            ColumnConfig utilitiesConfig = new ColumnConfig("Utilities", "utilities", 100, true);
            utilitiesConfig.setEditor(new GridEditor(utilitiesField));
            utilitiesConfig.setRenderer(renderer);

            ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                    monthConfig,
                    rentConfig,
                    utilitiesConfig
            });

            EditorGridPanel grid = new EditorGridPanel();
            grid.setStore(store);
            grid.setClicksToEdit(1);
            grid.setColumnModel(columnModel);
            grid.setWidth(360);

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
                new Object[]{"January", new Double(880.00), new Double(894.68)},
                new Object[]{"February", new Double(880.00), new Double(901.35)},
                new Object[]{"March", new Double(880.00), new Double(889.32)},
                new Object[]{"April", new Double(880.00), new Double(884.71)},
                new Object[]{"May", new Double(910.00), new Double(879.811)},
                new Object[]{"June", new Double(910.00), new Double(897.95)}
        };
    }

    public String getIntro() {
        return "<p>This is an example of a Line Chart.</p>" +
                "<p>The Chart and Grid are share the same underlying Store. Try updating the values in the Grid and the changes will be reflected in the Chart.</p>";
    }
}
