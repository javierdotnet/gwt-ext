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
 
package com.gwtext.sample.showcase2.client.combination;

import com.gwtext.client.core.*;
import com.gwtext.client.data.*;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.*;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.BorderLayoutData;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class ChartGeneratorSample extends ShowcasePanel {

    private Store store;
    private RecordDef recordDef;
    private static String CHART_URL_PREFIX = "http://chart.apis.google.com/chart";
    private FormPanel chartForm;

    public String getCssUrl() {
        return "source/combination/ChartGeneratorSample.css.html";
    }

    public String getSourceUrl() {
        return "source/combination/ChartGeneratorSample.java.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {

            panel = new Panel();
            panel.setLayout(new FitLayout());

            Panel mainPanel = new Panel();
            mainPanel.setLayout(new BorderLayout());

            //add south region
            BorderLayoutData southLayoutData = new BorderLayoutData(RegionPosition.SOUTH);
            southLayoutData.setSplit(true);
            southLayoutData.setMargins(new Margins(5, 5, 5, 5));

            final Panel previewPanel = new Panel();
            previewPanel.setTitle("Preview");
            previewPanel.setClosable(false);
            previewPanel.setCollapsible(true);
            previewPanel.setAutoScroll(true);
            previewPanel.setHeight(220);
            previewPanel.setPaddings(5);
            previewPanel.setHtml("<span id=\"help\">Once you select a type of chart, fill " +
                    "in the required data, and click on the PREVIEW button." +
                    "<br>At that time, a preview of the chat will appear here.</span>");

            mainPanel.add(previewPanel, southLayoutData);

            BorderLayoutData centerLayoutData = new BorderLayoutData(RegionPosition.CENTER);
            centerLayoutData.setMargins(new Margins(5, 5, 5, 0));

            Panel centerPanel = new Panel();
            centerPanel.setLayout(new BorderLayout());
            centerPanel.setTitle("Dion's ChartMaker");
            centerPanel.addTool(new Tool(Tool.GEAR, new Function() {
                public void execute() {
                    Panel panel = new Panel();
                    panel.setHtml("<p>This example is based on " +
                            "<a href=\"http://almaer.com/blog/chartmaker-ext-2-ui-on-top-" +
                            "of-the-google-chart-api\" target=\"_blank\">Dion's ChartMaker</a>.<p>" +
                            "    <p>" +
                            "        - Enter the core settings<br>" +
                            "        - Choose the type of chart<br>" +
                            "        - Seed Data to get a start, and enter your data<br>" +
                            "        - Click on the GET CHART button<br>" +
                            "        - Copy the URL for the chart<br>" +
                            "    </p>");


                    Window window = new Window();
                    window.setClosable(true);
                    window.setWidth(350);
                    window.setIconCls("paste-icon");
                    window.add(panel);
                    window.setTitle("Chart Maker Help");
                    window.show();
                }
            }, "Settings Help"));

            chartForm = new FormPanel();
            chartForm.setLabelWidth(40);
            chartForm.setLabelAlign(Position.RIGHT);
            chartForm.setWidth(300);
            chartForm.setPaddings(20);
            chartForm.setTitle("Chart Poperties");
            chartForm.add(new TextField("Title", "title", 100, "My Graph"));
            chartForm.add(new NumberField("Width", "width", 40, 280));
            chartForm.add(new NumberField("Height", "height", 40, 140));
            chartForm.add(new TextField("URL", "url", 185));

            final TabPanel tabPanel = new TabPanel();
            tabPanel.setActiveTab(0);
            tabPanel.setResizeTabs(true);
            tabPanel.setMinTabWidth(115);
            tabPanel.setTabWidth(135);

            tabPanel.add(getLineChartPanel());
            tabPanel.add(getPieChartPanel());

            centerPanel.add(chartForm, new BorderLayoutData(RegionPosition.WEST));
            centerPanel.add(tabPanel, new BorderLayoutData(RegionPosition.CENTER));

            Toolbar toolbar = new Toolbar();
            toolbar.addFill();
            ToolbarButton toolbarButton = new ToolbarButton("Update Chart", new ButtonListenerAdapter() {
                public void onClick(Button button, EventObject e) {
                    store.commitChanges();
                    String chartURL = ((ChartPanel) tabPanel.getActiveTab()).getChartURL();
                    previewPanel.getBody().update("<img src =\"" + chartURL + "\"/>");
                    chartForm.getForm().findField("url").setValue(chartURL);
                }
            });
            toolbarButton.setIconCls("image-icon");
            toolbar.addButton(toolbarButton);

            centerPanel.setBottomToolbar(toolbar);
            mainPanel.add(centerPanel, centerLayoutData);
            panel.add(mainPanel);
        }
        return panel;
    }

    private Panel getLineChartPanel() {
        Panel lineChart = new ChartPanel() {
            public String getChartURL() {
                String type = "cht=lc";
                String size = "chs=" + getChartSize();
                String title = "chtt=" + getChartTitle();
                String labels = "chl=";
                String colors = "chco=";
                String data = "chd=t:";
                Record[] records = store.getRecords();
                for (int i = 0; i < records.length; i++) {
                    Record record = records[i];
                    String sport = record.getAsString("sport");
                    String dataVal = record.getAsString("data");
                    String color = record.getAsString("color");
                    labels += sport + "%7C";
                    colors += color + ",";
                    data += dataVal.replaceAll(" ", ",") + "%7C";
                }
                labels = labels.substring(0, labels.length() - 3);
                data = data.substring(0, data.length() - 3);
                colors = colors.substring(0, colors.length() - 1);

                String url = Format.format("{0}?{1}&{2}&{3}&{4}&{5}&{6}",
                        new String[]{CHART_URL_PREFIX, type, size, title, labels, colors, data});
                return url;
            }
        };
        lineChart.setTitle("Line Chart");
        lineChart.setLayout(new FitLayout());
        lineChart.setPaddings(5);
        lineChart.setAutoScroll(true);
        lineChart.setIconCls("line-chart-icon");
        lineChart.add(getGridPanel());
        return lineChart;
    }

    private Panel getPieChartPanel() {
        FormPanel formPanel = new FormPanel();
        formPanel.setLabelWidth(30);
        formPanel.setPaddings(5);
        formPanel.setBorder(false);
        formPanel.setHeight(100);

        FieldSet fsType = new FieldSet("Type");
        final Radio typeRadio = new Radio("2D", "type");
        typeRadio.setChecked(true);
        fsType.add(typeRadio);
        fsType.add(new Radio("3D", "type"));
        fsType.setWidth(150);

        formPanel.add(fsType);

        Panel lineChart = new ChartPanel() {
            public String getChartURL() {
                String type = "cht=";

                if (typeRadio.getValue()) {
                    type += "p";
                } else {
                    type += "p3";
                }
                String size = "chs=" + getChartSize();
                String title = "chtt=" + getChartTitle();
                String labels = "chl=";
                String colors = "chco=";
                String data = "chd=t:";
                Record[] records = store.getRecords();
                for (int i = 0; i < records.length; i++) {
                    Record record = records[i];
                    String sport = record.getAsString("sport");
                    String dataVal = record.getAsString("data");
                    String color = record.getAsString("color");
                    labels += sport + "%7C";
                    colors += color + ",";
                    data += dataVal.replaceAll(" ", ",") + "%7C";
                }
                labels = labels.substring(0, labels.length() - 3);
                data = data.substring(0, data.length() - 3);
                colors = colors.substring(0, colors.length() - 1);

                String url = Format.format("{0}?{1}&{2}&{3}&{4}&{5}&{6}",
                        new String[]{CHART_URL_PREFIX, type, size, title, labels, colors, data});
                return url;
            }
        };
        lineChart.setTitle("Pie Chart");
        lineChart.setLayout(new BorderLayout());
        lineChart.setPaddings(5);
        lineChart.setIconCls("pie-chart-icon");
        GridPanel gridPanel = getGridPanel();

        lineChart.add(formPanel, new BorderLayoutData(RegionPosition.NORTH));
        lineChart.add(gridPanel, new BorderLayoutData(RegionPosition.CENTER));

        return lineChart;
    }

    public GridPanel getGridPanel() {
        if (recordDef == null) {
            recordDef = new RecordDef(new FieldDef[]{
                    new StringFieldDef("sport"),
                    new StringFieldDef("data"),
                    new StringFieldDef("color")
            });

            ArrayReader reader = new ArrayReader(recordDef);
            MemoryProxy proxy = new MemoryProxy(new Object[][]{
                    new Object[]{"Soccer", "10 30 50 70", "ff0000"},
                    new Object[]{"Cricket", "20 20 20 20", "00ff00"},
                    new Object[]{"Rugby", "50 40 30 20", "0000ff"}
            });
            store = new Store(proxy, reader);
            store.load();
        }

        final EditorGridPanel grid = new EditorGridPanel();
        grid.setStripeRows(true);
        grid.setStore(store);

        ColumnConfig sportConfig = new ColumnConfig("Sport", "sport", 150);
        sportConfig.setEditor(new GridEditor(new TextField()));

        ColumnConfig dataConfig = new ColumnConfig("Data", "data", 150);
        dataConfig.setEditor(new GridEditor(new TextField()));

        ColumnConfig colorConfig = new ColumnConfig("Color", "color", 100);
        colorConfig.setEditor(new GridEditor(new TextField()));

        ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                sportConfig,
                dataConfig,
                colorConfig
        });
        grid.setColumnModel(columnModel);

        GridView view = new GridView();
        view.setForceFit(true);
        grid.setView(view);

        Toolbar toolbar = new Toolbar();
        toolbar.addFill();
        ToolbarButton toolbarButton = new ToolbarButton("Add Data", new ButtonListenerAdapter() {
            public void onClick(Button button, EventObject e) {
                Record record = recordDef.createRecord(new Object[]{"My Sport", "5 30 18 25", "0000ff"});
                store.insert(0, record);
                grid.startEditing(0, 0);
            }
        });
        toolbarButton.setIconCls("add-icon");
        toolbar.addButton(toolbarButton);
        grid.setTopToolbar(toolbar);

        return grid;
    }

    private String getChartSize() {
        Form form = chartForm.getForm();
        String width = form.findField("width").getValueAsString();
        String height = form.findField("height").getValueAsString();
        return width + "x" + height;
    }

    private String getChartTitle() {
        Form form = chartForm.getForm();
        return form.findField("title").getValueAsString();
    }
}

abstract class ChartPanel extends Panel {

    public abstract String getChartURL();
}