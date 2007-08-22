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

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Connection;
import com.gwtext.client.util.JavaScriptObjectHelper;


/**
 * An implementation of {@link DataProxy} that reads a data object from the specified URL.
 * Note that this class cannot be used to retrieve data from a domain other than the domain from which the
 * running page was served.
 * For cross-domain access to remote data, use an {@link ScriptTagProxy}.
 * Be aware that to enable the browser to parse an XML document, the server must set the Content-Type header in the
 * HTTP response to "text/xml".
 *
 * @author Sanjiv Jivan
 * @since 0.9
 * @see com.gwtext.client.data.ScriptTagProxy
 */
public class HttpProxy extends DataProxy {

    /**
     * Construct a new HttpProxy to the specified URL
     * @param url data url, defaults to POST
     */
    public HttpProxy(String url) {
        this(url, null);
    }

    /**
     * Construct a new HttpProxy using the specified URL and method.
     *
     * @param url data url
     * @param method GET or POST
     */
    public HttpProxy(String url, String method) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        if (method != null) JavaScriptObjectHelper.setAttribute(config, "method", method);
        jsObj = create(config);
    }

    private native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.data.HttpProxy(config);
    }-*/;

    /**
     * Return the Connection object being used by this Proxy.
     * 
     * @return the Connection object. This object may be used to subscribe to events on a finer-grained basis.
     */
    public Connection getConnection() {
        return new Connection(getConnection(jsObj));
    }

    private native JavaScriptObject getConnection(JavaScriptObject proxy) /*-{
        return proxy.getConnection();
    }-*/;
}