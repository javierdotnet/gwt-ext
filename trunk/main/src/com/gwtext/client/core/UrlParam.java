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
 * This calass represents a Request URL parameter.
 */
public class UrlParam extends NameValuePair {

    public UrlParam(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public UrlParam(String paramName, String paramValue) {
        super(paramName, paramValue);
    }

    public UrlParam(String paramName, boolean paramValue) {
        super(paramName, paramValue);
    }

    public UrlParam(String paramName, float paramValue) {
        super(paramName, paramValue);
    }

    public UrlParam(String paramName, int paramValue) {
        super(paramName, paramValue);
    }

    private static UrlParam instance(String paramName, String paramValue) {
        return new UrlParam(paramName, paramValue);
    }
}
