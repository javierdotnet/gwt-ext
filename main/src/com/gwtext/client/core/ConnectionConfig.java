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
