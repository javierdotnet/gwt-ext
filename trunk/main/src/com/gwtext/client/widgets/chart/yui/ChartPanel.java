/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Ext;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.DOMUtil;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.Panel;

public abstract class ChartPanel extends Panel {

    static {
        init();
    }

    private static native void init()/*-{
        $wnd.YAHOO.widget.Chart.SWFURL = "js/yui/charts/assets/charts.swf";
    }-*/;

    protected JavaScriptObject chartJS;
    protected JavaScriptObject chartConfig = JavaScriptObjectHelper.createObject();
    protected boolean chartRendered;

    protected Store store;


	public void afterRender() {
        Element element = getBody().getDOM();
        String id = DOMUtil.getID(element);
        if (id == null) {
            id = Ext.generateId();
            DOMUtil.setID(element, id);
        }
        JavaScriptObject dataSource = createDataSource(store, JavaScriptObjectHelper.convertToJavaScriptArray(store.getFields()));
        chartJS = createChart(id, dataSource, chartConfig);
    }

    private native JavaScriptObject createDataSource(Store store, JavaScriptObject fields) /*-{
        var myDataSource = new $wnd.YAHOO.util.DataSource(function() {
            return store.@com.gwtext.client.data.Store::getRecordsAsJS()();
        });
        myDataSource.responseType = $wnd.YAHOO.util.DataSource.TYPE_JSARRAY;
        myDataSource.responseSchema =
        {
            fields: fields
        };
        return myDataSource;
    }-*/;

    protected abstract JavaScriptObject createChart(String containerID, JavaScriptObject dataStore, JavaScriptObject config);

    public native void setChartStyle(String name, String value) /*-{
        var chartJS = this.@com.gwtext.client.widgets.chart.yui.ChartPanel::chartJS;
        chartJS.setStyle(name, value);
    }-*/;

    public void setStore(Store store) {
        this.store = store;
    }

    public native String getChartName() /*-{
        var chartJS = this.@com.gwtext.client.widgets.chart.yui.ChartPanel::chartJS;
        return chartJS.toString();
    }-*/;

    public void setCategoryNames(String[] categoryNames) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "categoryNames", categoryNames);
    }

    public void setBackgroundColor(String backgroundColor) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "backgroundColor", backgroundColor);
    }

    public void setExpressInstall(String url) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "expressInstall", url);
    }

    public void setVersion(String version) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "version", version);
    }

    public void setWMode(String wmode) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "wmode", wmode);
    }

    public void setDataTipFunction(String dataTipFunction) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "dataTipFunction", dataTipFunction);
    }
      
    public void setPollingInterval(int pollingInterval) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "polling", pollingInterval);
    }


    
    public void setSeries(SeriesDef[] series) {
        JavaScriptObject[] seriesJS = new JavaScriptObject[series.length];
        for (int i = 0; i < series.length; i++) {
            SeriesDef seriesDef = series[i];
            seriesJS[i] = seriesDef.getJsObj();
        }
        JavaScriptObjectHelper.setAttribute(chartConfig, "series", JavaScriptObjectHelper.convertToJavaScriptArray(seriesJS));
    }
}
