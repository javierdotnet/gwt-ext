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

/**
 *
 * @author Sanjiv Jivan
 */
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
