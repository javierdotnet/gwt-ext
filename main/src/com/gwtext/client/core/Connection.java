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
import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.event.ConnectionListener;

public class Connection extends JsObject {

    protected Connection() {
    }

    public Connection(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public Connection(ConnectionConfig config) {
        jsObj = create(config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.Connection(config);
    }-*/;

    public native void abort() /*-{
        var conn = this.@com.gwtext.client.core.JsObject::jsObj;
        conn.abort();
    }-*/;

    public native void abort(long transactionId) /*-{
        var conn = this.@com.gwtext.client.core.JsObject::jsObj;
        conn.abort(transactionId);
    }-*/;

    public native void isLoading() /*-{
        var conn = this.@com.gwtext.client.core.JsObject::jsObj;
        conn.isLoading();
    }-*/;

    public native void isLoading(long transactionId) /*-{
        var conn = this.@com.gwtext.client.core.JsObject::jsObj;
        conn.isLoading(transactionId);
    }-*/;

    public native long request() /*-{
        var conn = this.@com.gwtext.client.core.JsObject::jsObj;
        return conn.request();
    }-*/;

    public native long request(RequestParam param) /*-{
        var conn = this.@com.gwtext.client.core.JsObject::jsObj;
        var paramJS = param.@com.gwtext.client.core.JsObject::jsObj;
        return conn.request(paramJS);
    }-*/;


    public native void addConnectionListener(ConnectionListener listener)/*-{
        var conn = listener.@com.gwtext.client.core.JsObject::jsObj;
        var connJ = this;

        conn.addListener('beforerequest',
                function(conn, options) {
                    return listener.@com.gwtext.client.core.event.ConnectionListener::doBeforeRequest(Lcom/gwtext/client/core/Connection;)(connJ);
                }
        );

        conn.addListener('requestcomplete',
                function(conn, response, options) {
                    return listener.@com.gwtext.client.core.event.ConnectionListener::onRequestComplete(Lcom/gwtext/client/core/Connection;Ljava/lang/String;)(connJ, response.responseXML);
                }
        );

        conn.addListener('requestexception',
                function(conn, response, options) {
                    return listener.@com.gwtext.client.core.event.ConnectionListener::onRequestException(Lcom/gwtext/client/core/Connection;)(connJ)
                }
        );
    }-*/;
}
