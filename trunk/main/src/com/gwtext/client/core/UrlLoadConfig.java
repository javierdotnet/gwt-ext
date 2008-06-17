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
 

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * {@link UpdateManager} configuration class.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.core.UpdateManager#update(String, UrlLoadConfig , UrlLoadCallback, boolean)
 */
public class UrlLoadConfig extends BaseConfig {

    /**
     * The url for the request.
     *
     * @param url the request url
     */
    public void setUrl(String url) {
        JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
    }

    /**
     * The parameters to pass as a url encoded string "param1=1&param2=2"
     *
     * @param params the request parameters
     */
    public void setParams(String params) {
        JavaScriptObjectHelper.setAttribute(jsObj, "params", params);
    }

    /**
     * The parameters to pass.
     *
     * @param params the request params
     */
    public void setParams(UrlParam[] params) {
        if(params != null && params.length > 0) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
            JavaScriptObjectHelper.setAttribute(jsObj, "params", paramObj);
        }
    }

    /**
     * By default when you execute an update the defaultUrl is changed to the last used url. If true, it will not store the url.
     *
     * @param discardUrl true to discard url
     */
    public void setDiscardUrl(boolean discardUrl) {
        JavaScriptObjectHelper.setAttribute(jsObj, "discardUrl", discardUrl);
    }

    /**
     * Set the callback when the XHR call is complete.
     *
     * @param callback callback when transaction is complete
     */
    public native void setCallback(UrlLoadCallback callback)/*-{
    	if (callback != null) {
        	var config = this.@com.gwtext.client.core.JsObject::getJsObj()();
        	config['callback'] = function(options, success, response) {
            		callback.@com.gwtext.client.core.UrlLoadCallback::execute(ZILjava/lang/String;)(success, response.status, response.responseText);
            };
		}
    }-*/;

    /**
     * @param nocache false to disable caching
     */
    public void setNocache(boolean nocache) {
        JavaScriptObjectHelper.setAttribute(jsObj, "nocache", nocache);
    }

    /**
     * Loading text.
     *
     * @param text the loading text
     */
    public void setText(String text) {
        JavaScriptObjectHelper.setAttribute(jsObj, "text", text);
    }

    /**
     * The request tiemout.
     *
     * @param timeout request timeout
     */
    public void setTimeout(int timeout) {
        JavaScriptObjectHelper.setAttribute(jsObj, "timeout", timeout);
    }

    /**
     * Whether to execute scripts from the laoded content.
     *
     * @param scripts true to execute scripts
     */
    public void setScripts(boolean scripts) {
        JavaScriptObjectHelper.setAttribute(jsObj, "scripts", scripts);
    }
}