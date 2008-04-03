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
import com.gwtext.client.widgets.chart.yui.*;
import com.gwtext.client.widgets.form.NumberField;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.grid.event.EditorGridListenerAdapter;
import com.gwtext.client.widgets.layout.VerticalLayout;
import com.gwtext.sample.charts.client.ShowcasePanel;

public class IncomeChartSample extends ShowcasePanel {

	public String getSourceUrl() {
		return "source/yui/IncomeChartSample.java.html";
	}

	public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            panel.setLayout(new VerticalLayout(15));


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
            chart.setTitle("Income Chart");
            chart.setWMode("transparent");
			chart.setStore(store);
            chart.setSeries(seriesDef);
            chart.setYField("year");
            chart.setXAxis(currencyAxis);
            chart.setExpressInstall("js/yui/assets/expressinstall.swf");
            chart.setWidth(500);
            chart.setHeight(400);

            panel.add(chart);

            Renderer renderer = new Renderer() {
                public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
                    NumberFormat nf = NumberFormat.getCurrencyFormat();
                    return nf.format(((Number)value).doubleValue());
                }
            };
            ColumnConfig yearConfig = new ColumnConfig("Year", "year", 100, true);
            NumberField yearField = new NumberField();
            yearField.setAllowDecimals(false);
            yearField.setSelectOnFocus(true);
            yearConfig.setEditor(new GridEditor(yearField));

            NumberField revenueField = new NumberField();
            revenueField.setSelectOnFocus(true);

            ColumnConfig revenueConfig = new ColumnConfig("Revenue", "revenue", 130, true);
            revenueConfig.setEditor(new GridEditor(revenueField));
            revenueConfig.setRenderer(renderer);

            NumberField expenseField = new NumberField();
            expenseField.setSelectOnFocus(true);

            ColumnConfig expenseConfig = new ColumnConfig("Expense", "expense", 130, true);
            expenseConfig.setEditor(new GridEditor(expenseField));
            expenseConfig.setRenderer(renderer);

            NumberField incomeField = new NumberField();
            incomeField.setSelectOnFocus(true);

            ColumnConfig incomeConfig = new ColumnConfig("Income", "income", 130, true);
            incomeConfig.setEditor(new GridEditor(incomeField));
            incomeConfig.setRenderer(renderer);

            ColumnModel columnModel = new ColumnModel(new ColumnConfig[] {
                    yearConfig,
                    revenueConfig,
                    expenseConfig,
                    incomeConfig
            });

            EditorGridPanel grid = new EditorGridPanel();
            grid.setStore(store);
            grid.setClicksToEdit(1);
            grid.setColumnModel(columnModel);
            grid.setWidth(500);

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

    public static Object[][] getData() {
        return new Object[][]{
                new Object[]{new Integer(2003), new Integer(1246852), new Integer(1123359), new Integer(123493)},
                new Object[]{new Integer(2004), new Integer(2451876), new Integer(2084952), new Integer(366920)},
                new Object[]{new Integer(2005), new Integer(2917246), new Integer(2587151), new Integer(330095)},
                new Object[]{new Integer(2006), new Integer(3318185), new Integer(3087456), new Integer(230729)}

        };
    }

    public String getIntro() {
        return "<p>This is an example of a Bar Chart.</p>" +
                "<p>The Chart and Grid are share the same underlying Store. Try updating the values in the Grid and the changes will be reflected in the Chart.</p>";
    }    
}