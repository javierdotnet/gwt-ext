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

/**
 * Base class for YUI based Charts. You must inherit the module <pre>&lt;inherits name="com.gwtext.Charts"/&gt;</pre> in your module file
 * in order to use this functionality.
 */
public abstract class ChartPanel extends Panel {

    static {
        init();
    }

    private static native void init()/*-{
        $wnd.YAHOO.widget.Chart.SWFURL = $moduleBase + "js/yui/charts/assets/charts.swf";
    }-*/;

    protected JavaScriptObject chartJS;
    protected JavaScriptObject chartConfig = JavaScriptObjectHelper.createObject();
    protected boolean chartRendered;

    protected Store store;

    protected ChartPanel() {
        setExpressInstall("js/yui/assets/expressinstall.swf");
    }

    public void afterRender() {
        Element element = getBody().getDOM();
        String id = DOMUtil.getID(element);
        if (id == null) {
            id = Ext.generateId();
            DOMUtil.setID(element, id);
        }
        JavaScriptObject dataSource = createDataSource(store, JavaScriptObjectHelper.convertToJavaScriptArray(store.getFields()));
        chartJS = createChart(id, dataSource, chartConfig);
        chartRendered = true;
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

    /**
     * Set the datastore for the chart.
     *
     * @param store the store
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * The chart name.
     *
     * @return the chart name
     */
    public native String getChartName() /*-{
        var chartJS = this.@com.gwtext.client.widgets.chart.yui.ChartPanel::chartJS;
        return chartJS.toString();
    }-*/;

    /**
     * The names of the categories to be displayed in the Chart.
     *
     * @param categoryNames the names of the categories to be displayed in the Chart.
     */
    public void setCategoryNames(String[] categoryNames) {
        JavaScriptObjectHelper.setAttribute(chartConfig, "categoryNames", categoryNames);
    }

    /**
     * The background color of the SWF.
     *
     * @param backgroundColor the background color of the SWF.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setBackgroundColor(String backgroundColor) throws IllegalStateException {
        if(!chartRendered) {
            JavaScriptObjectHelper.setAttribute(chartConfig, "backgroundColor", backgroundColor);
        } else {
            error("The charts background color can only be set before the chart has been rendered.");
        }
    }

    /**
     * URL pointing to a SWF file that handles Flash Player's express install feature.
     *
     * @param url URL pointing to a SWF file that handles Flash Player's express install feature.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setExpressInstall(String url) throws IllegalStateException {
        JavaScriptObjectHelper.setAttribute(chartConfig, "expressInstall", url);
    }

    /**
     * Minimum required version for the SWF file.
     *
     * @param version minimum required version for the SWF file.
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setVersion(String version) throws IllegalStateException {
        JavaScriptObjectHelper.setAttribute(chartConfig, "version", version);
    }

    /**
     * Sets the window mode of the Flash Player control. May be "window", "opaque", or "transparent".
     *
     * @param wmode sets the window mode of the Flash Player control. May be "window", "opaque", or "transparent".
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setWMode(String wmode) throws IllegalStateException {
        JavaScriptObjectHelper.setAttribute(chartConfig, "wmode", wmode);
    }

    /**
     * The string representation of a globally-accessible function that may be called by the SWF to
     * generate the datatip text for a Chart's item.
     *
     * @param dataTipFunction the data tip function
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setDataTipFunction(String dataTipFunction) throws IllegalStateException {
        JavaScriptObjectHelper.setAttribute(chartConfig, "dataTipFunction", dataTipFunction);
    }

    /**
     * A numeric value indicating the number of milliseconds between polling requests to the DataSource.
     *
     * @param pollingInterval polling interval
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setPollingInterval(int pollingInterval) throws IllegalStateException {
        JavaScriptObjectHelper.setAttribute(chartConfig, "polling", pollingInterval);
    }

    /**
     * Defines the series to be displayed by the Chart.
     *
     * @param series the series to be displayed by the Chart.
     */
    public void setSeries(SeriesDef[] series) {
        JavaScriptObject[] seriesJS = new JavaScriptObject[series.length];
        for (int i = 0; i < series.length; i++) {
            SeriesDef seriesDef = series[i];
            seriesJS[i] = seriesDef.getJsObj();
        }
        JavaScriptObjectHelper.setAttribute(chartConfig, "series", JavaScriptObjectHelper.convertToJavaScriptArray(seriesJS));
    }

    /**
     * Refresh the charts dispaly based on the datasource.
     */
    public void refresh() {
        if(chartRendered) {
            doRefresh(chartJS);
        } else {
            throw new IllegalStateException("This method can be called only after the chart had been rendered");
        }
    }

    private native void doRefresh(JavaScriptObject chartJS)/*-{
        chartJS.set("dataSource", chartJS.get("dataSource"));
    }-*/;
}
