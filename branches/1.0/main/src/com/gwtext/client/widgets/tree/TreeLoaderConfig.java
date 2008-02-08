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

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.Connection;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration class for {@link TreeLoader}.
 */
public class TreeLoaderConfig extends BaseConfig {

	/**
	 * The request parameters to be added to all nodes created by this loader.
	 * If the attributes sent by the server have an attribute in this object, they take priority.
	 *
	 * @param params the url params
	 */
	public void setBaseAttrs(UrlParam[] params) {
		JavaScriptObject paramObj = UrlParam.getJsObj(params);
		JavaScriptObjectHelper.setAttribute(jsObj, "baseAttrs", paramObj);
	}

	/**
	 * The URL from which to request a Json string which specifies an array of node definition object representing the
	 * child nodes to be loaded.
	 *
	 * @param dataUrl the data URL
	 */
	public void setDataUrl(String dataUrl) {
		JavaScriptObjectHelper.setAttribute(jsObj, "dataUrl", dataUrl);
	}

	/**
	 * The request method (GET OR POST).
	 * 
	 * @param method the request method
	 * @see com.gwtext.client.core.Connection#GET
	 * @see com.gwtext.client.core.Connection#POST
	 */
	public void setMethod(Connection.Method method) {
		JavaScriptObjectHelper.setAttribute(jsObj, "requestMethod", method.getMethod());
	}

	/**
	 * The request method (GET OR POST).
	 *
	 * @param method the request method
	 * @deprecated Use {@link #setMethod(com.gwtext.client.core.Connection.Method)}
	 */
	public void setMethod(String method) {
		JavaScriptObjectHelper.setAttribute(jsObj, "requestMethod", method);
	}

	/**
	 * Request properties which specify HTTP parameters to be passed to each request for child nodes.
	 * 
	 * @param params the request params
	 */
	public void setBaseParams(UrlParam[] params) {
		JavaScriptObject paramObj = UrlParam.getJsObj(params);
		JavaScriptObjectHelper.setAttribute(jsObj, "baseParams", paramObj);
	}

	/**
	 * Default to true. Remove previously existing child nodes before loading.
	 *
	 * @param clearOnLoad true to clear on load
	 */
	public void setClearOnLoad(boolean clearOnLoad) {
		JavaScriptObjectHelper.setAttribute(jsObj, "clearOnLoad", clearOnLoad);
	}

	//todo  uiProviders
}
