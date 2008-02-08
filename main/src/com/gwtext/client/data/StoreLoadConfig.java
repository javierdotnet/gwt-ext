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
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * StoreLoad configuration class.
 *
 * @see Store#load(StoreLoadConfig)
 * @see Store#reload(StoreLoadConfig)
 */
public class StoreLoadConfig extends BaseConfig {

    /**
     * True to ppend loaded records rather than replace the current cache.
     *
     * @param add true to add
     */
    public void setAdd(boolean add) {
        JavaScriptObjectHelper.setAttribute(jsObj, "add", add);
    }

    /**
     * Parameters to pass as HTTP parameters to a remote data source. Used only with HTTP related proxies.
     * 
     * @param params url parameters
     */
    public void setParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "params", paramObj);
    }
}
