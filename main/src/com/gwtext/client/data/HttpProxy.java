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

public class HttpProxy extends DataProxy {

    /**
     * @param url data url, defaults to POST
     */
    public HttpProxy(String url) {
        this(url, null);
    }

    /**
     * @param url data url
     * @param method  GET or POST
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

    public Connection getConnection() {
        return new Connection(getConnection(jsObj));
    }

    private native JavaScriptObject getConnection(JavaScriptObject proxy) /*-{
        proxy.getConnection();
    }-*/;


}