/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.form.event.CheckboxListener;

/**
 * Single radio field. Radio grouping is handled automatically by the browser if you give each radio in a group the same name.
 *
 */
public class Radio extends Checkbox {

	private static JavaScriptObject configPrototype;

	static {
		init();
	}

	private static native void init()/*-{
		var c = new $wnd.Ext.form.Radio();
		@com.gwtext.client.widgets.form.Radio::configPrototype = c.initialConfig;
	}-*/;


	protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}
	
	public String getXType() {
		return "radio";
	}

	public Radio() {
    }

    public Radio(String label) {
        super(label);
    }

    public Radio(String fieldLabel, String name) {
        super(fieldLabel, name);
    }

    public Radio(String label, CheckboxListener listener) {
        super(label, listener);
    }

    public Radio(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.form.Radio(config);    
    }-*/;

    /**
     * If this radio is part of a group, it will return the selected value.
     * 
     * @return the group value
     */
    public native String getGroupValue() /*-{
        var rb = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        return rb.getGroupValue();
    }-*/;
}
