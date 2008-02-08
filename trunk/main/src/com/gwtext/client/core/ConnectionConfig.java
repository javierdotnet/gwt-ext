/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Connection configuration class.
 */
public class ConnectionConfig extends BaseConfig {

    /**
     * Whether this request should abort any pending requests.
     *
     * @param autoAbort defaults to false
     */
    public void setAutoAbort(boolean autoAbort) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoAbort", autoAbort);
    }

    /**
     * Request headers which are added to each request made by this object.
     *
     * @param defaultHeaders default headers
     */
    public void setDefaultHeaders(NameValuePair[] defaultHeaders) {
        JavaScriptObject paramObj = NameValuePair.getJsObj(defaultHeaders);
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultHeaders", paramObj);
    }

    /**
     * Properties which are used as extra parameters to each request made by this object.
     *
     * @param params request parameters
     */
    public void setExtraParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "extraParams", paramObj);
    }

    /**
     * Sets the method (GET or POST) for the operation.
     *
     * @param method the method
     * @see com.gwtext.client.core.Connection#GET
     * @see com.gwtext.client.core.Connection#POST
     */
    public void setMethod(Connection.Method method) {
        JavaScriptObjectHelper.setAttribute(jsObj, "method", method.getMethod());
    }

    /**
     * The timeout in milliseconds to be used for requests. (defaults to 30000)
     *
     * @param timeout timout
     */
    public void setTimeout(int timeout) {
        JavaScriptObjectHelper.setAttribute(jsObj, "timeout", timeout);
    }

    /**
     * The default URL to be used for requests to the server.
     *
     * @param url defaults to undefined
     */
    public void setUrl(String url) {
        JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
    }
}
