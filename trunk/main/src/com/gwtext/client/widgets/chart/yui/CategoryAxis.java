/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A type of axis that displays items in categories.
 */
public class CategoryAxis extends Axis {

    protected native JavaScriptObject create() /*-{
        return new $wnd.YAHOO.widget.CategoryAxis();
    }-*/;

    /**
     * A list of category names to display along this axis.
     *
     * @param categoryNames the categoryNames
     */
    public void setCategoryNames(String[] categoryNames) {
        JavaScriptObjectHelper.setAttribute(jsObj, "categoryNames", categoryNames);
    }

    /**
     * A list of category names to display along this axis.
     *
     * @return the categoryNames
     */
    public String[] getCategoryNames() {
        return JavaScriptObjectHelper.getAttributeAsStringArray(jsObj, "categoryNames");
    }


}