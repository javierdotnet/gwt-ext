/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;

public class Hidden extends Field {

    private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init()/*-{
			var c = new $wnd.Ext.form.Hidden();
			@com.gwtext.client.widgets.form.Hidden::configPrototype = c.initialConfig;
		}-*/;


    protected JavaScriptObject getConfigPrototype() {
        return configPrototype;
    }

    public String getXType() {
        return "hidden";
    }

    /**
     * Create a new hidden field.
     */
    public Hidden() {
    }

    /**
     * Create a new hidden field.
     *
     * @param name the field name
     * @param value the field value
     */
    public Hidden(String name, String value) {
        setName(name);
        setValue(value);
    }

    public Hidden(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject jsObj) /*-{
        return new $wnd.Ext.form.Hidden(jsObj);
    }-*/;
}
