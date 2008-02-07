/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This class represents a Regular Expression.
 */
public class RegExp extends JsObject {

    /**
     * Constructs a new REgular Expression.
     *
     * @param re the regular expression String
     */
    public RegExp(String re) {
        jsObj = create(re);
    }

    private native JavaScriptObject create(String re) /*-{
        return new $wnd.RegExp(re);
    }-*/;
}
