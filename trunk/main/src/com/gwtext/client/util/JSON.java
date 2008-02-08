/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.util;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * JSON Helper class.
 */
public class JSON {

    private JSON() {
    }

    /**
     * Decodes (parses) a JSON string to an object. If the JSON is invalid, this function throws a SyntaxError.
     *
     * @param json the Json String
     * @return the Json object
     */
    public static native JavaScriptObject decode(String json) /*-{
        return $wnd.Ext.util.JSON.decode(json);
    }-*/;

    /**
     * Encodes a Json object.
     *
     * @param json the json object
     * @return the JSon String
     */
    public static native String encode(JavaScriptObject json) /*-{
        return $wnd.Ext.util.JSON.encode(json);
    }-*/;
}
