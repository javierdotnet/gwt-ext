/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;



//http://extjs.com/forum/showthread.php?t=7072&highlight=Ajax+Connection
//http://extjs.com/forum/showthread.php?t=7737&highlight=Ajax+Connection
//http://extjs.com/forum/showthread.php?t=7249&highlight=Ajax+Connection

/**
 * Global Ajax request class. This class is a singleton and cannot be created directly.
 *
 */
public class Ajax extends Connection {

    private static Ajax instance;

    private Ajax(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public static Ajax getInstance() {
        if (instance == null) {
            instance = new Ajax(getSingleton());
        }
        return instance;
    }

    private static native JavaScriptObject getSingleton() /*-{
        return $wnd.Ext.Ajax;
    }-*/;

    /**
     * Whether a new request should abort any pending requests.
     *
     * @param autoAbort defaults to false
     */
    public void setAutoAbort(boolean autoAbort) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoAbort", autoAbort);
    }

    /**
     *  Request headers which are added to each request made by this object.
     *
     * @param defaultHeaders default header params
     */
    public void setDefaultHeaders(NameValuePair[] defaultHeaders) {
        JavaScriptObject paramObj = NameValuePair.getJsObj(defaultHeaders);
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultHeaders", paramObj);
    }

    /**
     * True to add a unique cache-buster param to GET requests.
     *
     * @param disableCaching defaults to true
     */
    public void setDisableCaching(boolean disableCaching) {
        JavaScriptObjectHelper.setAttribute(jsObj, "disableCaching", disableCaching);
    }

    /**
     * Extra parameters to each request made by this object.
     * 
     * @param params extra params
     */
    public void setExtraParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "extraParams", paramObj);
    }

    /**
     * The default HTTP method to be used for requests.
     *
     * @param method defaults to undefined; if not set but parms are present will use POST, otherwise GET
     */
    public void setMethod(Method method) {
        JavaScriptObjectHelper.setAttribute(jsObj, "method", method.getMethod());
    }

    /**
     * The timeout in milliseconds to be used for requests.
     * 
     * @param timeout defaults to 30000
     */
    public void setTimeout(int timeout) {
        JavaScriptObjectHelper.setAttribute(jsObj, "timeout", timeout);
    }

    /**
     * The default URL to be used for requests to the server.
     *
     * @param url the url to make the request to
     */
    public void setUrl(String url) {
        JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
    }

    /**
     * Serialize the passed form into a url encoded string
     *
     * @param formId the form id
     * @return url encoded String
     */
    public native String serializeForm(String formId) /*-{
        var conn = this.@com.gwtext.client.core.JsObject::jsObj;
        return conn.serializeForm(formId);
    }-*/;
}
