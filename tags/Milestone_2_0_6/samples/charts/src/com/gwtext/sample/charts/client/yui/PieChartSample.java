/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.sample.charts.client.yui;

import com.gwtext.client.data.*;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.chart.yui.PieChart;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.EditorGridListenerAdapter;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.sample.charts.client.ShowcasePanel;

public class PieChartSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/yui/PieChartSample.java.html";
	}

	public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new VerticalLayout(15));

            MemoryProxy proxy = new MemoryProxy(getData());
            RecordDef recordDef = new RecordDef(
                    new FieldDef[]{
                            new StringFieldDef("response"),
                            new IntegerFieldDef("count"),
                            new StringFieldDef("legend")
                    }
            );

            ArrayReader reader = new ArrayReader(recordDef);
            final Store store = new Store(proxy, reader);
            store.load();

            final PieChart chart = new PieChart();
            chart.setTitle("Survey Chart");
            chart.setWMode("transparent");
            chart.setStore(store);
            chart.setDataField("count");
            chart.setCategoryField("response");

            chart.setExpressInstall("js/yui/assets/expressinstall.swf");
            chart.setWidth(500);
            chart.setHeight(400);

            panel.add(chart);

            ColumnConfig responseConfig = new ColumnConfig("Response", "response", 100, true);
            TextField textField = new TextField();
            textField.setSelectOnFocus(true);
            //responseConfig.setEditor(new GridEditor(textField));

            NumberField numberField = new NumberField();
            numberField.setSelectOnFocus(true);

            ColumnConfig countConfig = new ColumnConfig("Count", "count", 130, true);
            //countConfig.setEditor(new GridEditor(numberField));

            ColumnConfig legendConfig = new ColumnConfig("Legend", "legend", 60, true);
            legendConfig.setRenderer(new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    cellMetadata.setHtmlAttribute("style=\"background:" + value + ";\"");
                    return "";
                }
            });

            ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                    responseConfig,
                    countConfig,
                    legendConfig
            });

            EditorGridPanel grid = new EditorGridPanel();
            grid.setStore(store);
            grid.setClicksToEdit(1);
            grid.setColumnModel(columnModel);
            grid.setWidth(300);

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
                new Object[]{"Summer", new Integer(564815), "#00b8bf"},
                new Object[]{"Fall", new Double(664182), "#8dd5e7"},
                new Object[]{"Spring", new Double(248124), "#c0fff6"},
                new Object[]{"Winter", new Double(271214), "#ffa928"},
                new Object[]{"Undecided", new Double(81845), "#edff9f"}
        };
    }

    public String getIntro() {
        return "<p>This is an example of a Pie Chart.</p>";
    }
}