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
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * An implementation of Ext.data.DataProxy that reads a data object from a URL which may be in a domain other than the
 * originating domain of the running page.
 * <p>
 * Note that if you are retrieving data from a page that is in a domain that is NOT the same as the originating domain of
 * the running page, you must use this class, rather than {@link HttpProxy}.
 * <p>
 * The content passed back from a server resource requested by a ScriptTagProxy is executable JavaScript source code that
 * is used as the source inside a &lt;script&gt; tag.
 * <p>
 * In order for the browser to process the returned data, the server must wrap the data object with a call to a callback
 * function, the name of which is passed as a parameter by the ScriptTagProxy. Below is a Java example for a servlet which
 * returns data for either a ScriptTagProxy, or an HttpProxy depending on whether the callback name was passed:
 *
 * <pre>
 * <code>
 *
 * boolean scriptTag = false;
 * String cb = request.getParameter("callback");
 * if (cb != null) {
 *     scriptTag = true;
 *     response.setContentType("text/javascript");
 * } else {
 *     response.setContentType("application/x-json");
 * }
 * Writer out = response.getWriter();
 * if (scriptTag) {
 *     out.write(cb + "(");
 * }
 * out.print(dataBlock.toJsonString());
 * if (scriptTag) {
 *   out.write(");");
 * }
 *
 * </code>
 * </pre>
 */
public class ScriptTagProxy extends DataProxy {

    /**
     * Construct a new ScriptTagProxy.
     *
     * @param url the URL from which to request the data object.
     */
    public ScriptTagProxy(String url) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        jsObj = create(config);
    }

    //excluding nocache options since ScriptTagProxy calls are never cached
    //http://extjs.com/forum/showthread.php?t=7096
    /**
     * Construct a new ScriptTagProxy.
     *
     * @param url the URL from which to request the data object.
     * @param timeout the number of milliseconds to wait for a response. Defaults to 30 seconds.
     */
    public ScriptTagProxy(String url, int timeout) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        if (timeout > 0) JavaScriptObjectHelper.setAttribute(config, "timeout", timeout);
        jsObj = create(config);
    }

    /**
     * Construct a new ScriptTagProxy.
     *
     * @param url the URL from which to request the data object.
     * @param timeout the number of milliseconds to wait for a response. Defaults to 30 seconds.
     * @param callbackParam the name of the parameter to pass to the server which tells the server the name of the callback function set up by the load call to process the returned data object. Defaults to "callback".
     * The server-side processing must read this parameter value, and generate javascript output which calls this named function passing the data object as its only parameter.
     */
    public ScriptTagProxy(String url, int timeout, String callbackParam) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        if(callbackParam != null) JavaScriptObjectHelper.setAttribute(config, "callbackParam", callbackParam);
        if (timeout > 0) JavaScriptObjectHelper.setAttribute(config, "timeout", timeout);
        jsObj = create(config);
    }
    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.data.ScriptTagProxy(config);
    }-*/;
}
