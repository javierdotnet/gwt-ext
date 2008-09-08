/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * An implementation of DataProxy that reads a data object from a URL which may be in a domain other than the
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
 * <p/>
 * <pre>
 * <code>
 * <p/>
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
 * <p/>
 * </code>
 * </pre>
 * <p/>
 * Consider the following code :
 * </p><pre><code>
 *  RecordDef recordDef = new RecordDef(new FieldDef[]{
 *             new StringFieldDef("name", "name"), // "mapping" property not needed if it's the same as "name"
 *             new StringFieldDef("occupation")    // this field will use "occupation" as the mapping.
 *     });
 * <p/>
 *  JsonReader reader = new JsonReader(new JsonReaderConfig() {
 *      {
 *          setTotalProperty("results"); // The property which contains the total dataset size (optional)
 *          setRoot("rows");             // The property which contains an Array of row objects
 *          setId("id");                 // The property within each row object that provides an ID for the record (optional)
 *      }}, recordDef);
 * </code>
 * </pre>
 * <p>
 * <p/>
 * If the data is being server from the same domain, then you don;t need to use ScriptTagProxy but instead need to use
 * {@link com.gwtext.client.data.HttpProxy} pointing to the URL that returns data in the following format :<br>
 * <p/>
 * </p><pre><code>{ <em>'results'</em>: 2, <em>'rows'</em>: [
 *     { <em>'id'</em>: 1, <em>'name'</em>: <em>'Bill'</em>, occupation: <em>'Gardener'</em> },
 *     { <em>'id'</em>: 2, <em>'name'</em>: <em>'Ben'</em>, occupation: <em>'Horticulturalist'</em> } ]
 * }</code></pre>
 * <p/>
 * However if this data is being read from another domain, a couple of things need to be done.<br>
 * <p/>
 * First, you need to use ScriptTagProxy pointing to the external url. For example
 * <pre>
 * <code>
 * ScriptTagProxy proxy = new ScriptTagProxy("http://externalurl:8023/foo/bar.php");
 * </code>
 * </pre>
 * <p/>
 * Now bar.php cannot return standard Json like the one above when using HttpProxy. Instead it needs to wrap the
 * Json data in a callback. This is required when reading data from antoher domain. When the ScriptTagProxy tries
 * for fetch data, it will issue an HTTP request to the specified URL passing the name of the callback function that
 * it needs the results to be wrapped in. For example http://externalurl:8023/foo/bar.php?start=0&limit=25&sort=nome&dir=DESC&_dc=1196661274168&<b>callback=stcCallback1002</b>
 * <br>
 * Notice the request paramter "callback" has a value of "stcCallback1002" in the above example. This means that the
 * request to http://externalurl:8023/foo/bar.php should return Json data wrapped in the callback funtion "stcCallback1002".
 * <p/>
 * <br>
 * </p><pre><code><b>stcCallback1002(</b>{ <em>'results'</em>: 2, <em>'rows'</em>: [
 *     { <em>'id'</em>: 1, <em>'name'</em>: <em>'Bill'</em>, occupation: <em>'Gardener'</em> },
 *     { <em>'id'</em>: 2, <em>'name'</em>: <em>'Ben'</em>, occupation: <em>'Horticulturalist'</em> }]<b>);</b>
 * }</code></pre>
 * <br>
 * So for ScriptTagProxy to work, the URL that it is reading data from is responsible to read the "callback" paramter,
 * and wrap the Json data using the name of the passed callback function. By default the name of the callback
 * request parameter is "callback" but you can specify a different one using the constructor {@link #ScriptTagProxy(String, int, String)}.
 *
 * @author Sanjiv Jivan
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
     * @param url     the URL from which to request the data object.
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
     * @param url           the URL from which to request the data object.
     * @param timeout       the number of milliseconds to wait for a response. Defaults to 30 seconds.
     * @param callbackParam the name of the parameter to pass to the server which tells the server the name of the callback function set up by the load call to process the returned data object. Defaults to "callback".
     *                      The server-side processing must read this parameter value, and generate javascript output which calls this named function passing the data object as its only parameter.
     */
    public ScriptTagProxy(String url, int timeout, String callbackParam) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        if (callbackParam != null) JavaScriptObjectHelper.setAttribute(config, "callbackParam", callbackParam);
        if (timeout > 0) JavaScriptObjectHelper.setAttribute(config, "timeout", timeout);
        jsObj = create(config);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.data.ScriptTagProxy(config);
    }-*/;
}
