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
import com.gwtext.client.widgets.chart.yui.PieChart;
import com.gwtext.client.widgets.chart.yui.SeriesDefY;
import com.gwtext.sample.charts.client.ShowcasePanel;

public class PieChartSample extends ShowcasePanel {

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            MemoryProxy proxy = new MemoryProxy(getData());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("response"),
                            new IntegerFieldDef("count")
                    }
            );

            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(proxy, reader);
            store.load();

            SeriesDefY[] seriesDef = new SeriesDefY[]{
                    new SeriesDefY("Rent", "rent"),
                    new SeriesDefY("Utilities", "utilities")
            };


            final PieChart chart = new PieChart();
			chart.setWMode("transparent");
			chart.setStore(store);
            chart.setDataField("count");
            chart.setCategoryField("response");
            chart.setSeries(seriesDef);

            chart.setExpressInstall("js/yui/assets/expressinstall.swf");
            chart.setWidth(500);
            chart.setHeight(400);

            panel.add(chart);

        }
        return panel;
    }

    private static Object[][] getData() {
        return new Object[][]{
                new Object[]{"Summer", new Integer(564815)},
                new Object[]{"Fall", new Double(664182)},
                new Object[]{"Spring", new Double(248124)},
                new Object[]{"Winter", new Double(271214)},
                new Object[]{"Undecided", new Double(81845)}
        };
    }
}