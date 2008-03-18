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
import com.gwtext.client.widgets.chart.yui.*;
import com.gwtext.sample.charts.client.ShowcasePanel;

public class IncomeChartSample extends ShowcasePanel {

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            MemoryProxy proxy = new MemoryProxy(getData());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new IntegerFieldDef("year"),
                            new IntegerFieldDef("revenue"),
                            new IntegerFieldDef("expense"),
                            new IntegerFieldDef("income")
                    }
            );

            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(proxy, reader);
            store.load();

            SeriesDefX incomeSeries = new SeriesDefX("Income", "income");
            incomeSeries.setType(ChartType.LINE);

            SeriesDef[] seriesDef = new SeriesDef[]{

                    new SeriesDefX("Revenue", "revenue"),
                    new SeriesDefX("Expense", "expense"),
                    incomeSeries
            };

            NumericAxis currencyAxis = new NumericAxis();
            //currencyAxis.setLabelFunction("formatCurrencyAxisLabel");

            final BarChart chart = new BarChart();
            chart.setStore(store);
            chart.setSeries(seriesDef);
            chart.setYField("year");
            chart.setXAxis(currencyAxis);
            chart.setExpressInstall("js/yui/assets/expressinstall.swf");
            chart.setWidth(500);
            chart.setHeight(400);

            panel.add(chart);

        }
        return panel;
    }

    public static Object[][] getData() {
        return new Object[][]{
                new Object[]{new Integer(2003), new Integer(1246852), new Integer(1123359), new Integer(123493)},
                new Object[]{new Integer(2004), new Integer(2451876), new Integer(2084952), new Integer(366920)},
                new Object[]{new Integer(2005), new Integer(2917246), new Integer(2587151), new Integer(330095)},
                new Object[]{new Integer(2006), new Integer(3318185), new Integer(3087456), new Integer(230729)}

        };
    }
}