/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.charts.client.yui;

import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.chart.yui.LineChart;
import com.gwtext.client.widgets.chart.yui.NumericAxis;
import com.gwtext.client.widgets.chart.yui.SeriesDefY;
import com.gwtext.sample.charts.client.ShowcasePanel;

public class
        LineChartSample extends ShowcasePanel {

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

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
}
