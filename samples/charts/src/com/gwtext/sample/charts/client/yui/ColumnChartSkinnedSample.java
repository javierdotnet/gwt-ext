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
import com.gwtext.sample.charts.client.ShowcasePanel;

public class ColumnChartSkinnedSample extends ShowcasePanel {

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

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
}