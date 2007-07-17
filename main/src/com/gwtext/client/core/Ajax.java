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

    public void setDefaultHeaders(NameValuePair[] defaultHeaders) {
        JavaScriptObject paramObj = NameValuePair.getJsObj(defaultHeaders);
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultHeaders", paramObj);
    }

    public void setExtraParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "extraParams", paramObj);
    }

    public void setMethod(String method) {
        JavaScriptObjectHelper.setAttribute(jsObj, "method", method);
    }

    public void setTimeout(int timeout) {
        JavaScriptObjectHelper.setAttribute(jsObj, "timeout", timeout);
    }

    public void setUrl(String url) {
        JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
    }

    public native void serializeForm(String formId) /*-{
        var conn = this.@com.gwtext.client.core.JsObject::jsObj;
        return conn.serializeForm(formId);
    }-*/;

}
