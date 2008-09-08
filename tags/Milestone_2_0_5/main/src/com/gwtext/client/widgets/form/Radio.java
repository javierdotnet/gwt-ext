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
 

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.form.event.CheckboxListener;

/**
 * Single radio field. Radio grouping is handled automatically by the browser if you give each radio in a group the same name.
 *
 * @author Sanjiv Jivan
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
    
    /**
     * A value to initialize this field with.
     *
     * @param value the field value
     */
    public void setValue(String value) {
        if(!isRendered()) {
            setAttribute("inputValue", value, true);
        }else {
            super.setValue(value);
        }
    }

}
