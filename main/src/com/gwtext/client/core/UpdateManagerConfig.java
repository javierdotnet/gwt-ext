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
 * {@link UpdateManager} configuration class.
 *
 * @see com.gwtext.client.core.UpdateManager#update(String, UpdateManagerConfig, UrlLoadCallback, boolean)
 */
public class UpdateManagerConfig extends BaseConfig {

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
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "params", paramObj);
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
     *
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