/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * @see ComboBoxListener#doBeforeQuery(com.gwtext.client.widgets.form.ComboBox, ComboBoxCallback)
 */
public class ComboBoxCallback extends JsObject {

    private ComboBoxCallback(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static ComboBoxCallback instance(JavaScriptObject jsObj) {
        return new ComboBoxCallback(jsObj);
    }

    /**
     * Returns the query.
     *
     * @return the query
     */
    public String getQuery() {
        return JavaScriptObjectHelper.getAttribute(jsObj, "query");
    }

    /**
     * Sets the query.
     *
     * @param query the query
     */
    public void setQuery(String query) {
        JavaScriptObjectHelper.setAttribute(jsObj, "query", query);
    }

    /**
     * Set true to force "all" query.
     *
     * @param forceAll true to force "all" query
     */
    public void setForceAll(boolean forceAll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "forceAll", forceAll);
    }

    /**
     * Returns true if query is force "all".
     *
     * @return true if force "all"
     */
    public boolean getForceAll() {
        return JavaScriptObjectHelper.getAttributeAsBoolean(jsObj, "forceAll");
    }
}
