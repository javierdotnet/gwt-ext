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
 * This class represents a HTTP Request.
 *
 * @see com.gwtext.client.core.Connection#request(RequestParam)
 */
public class RequestParam extends JsObject {

    public RequestParam() {
        jsObj = JavaScriptObjectHelper.createObject();
    }

    /**
     * The URL of the request.
     *
     * @param url the rul
     */
    public void setUrl(boolean url) {
        JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
    }

    /**
     * The request paameters.
     *
     * @param params the request parameters
     */
    public void setParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "params", paramObj);
    }

    /**
     * The request method (GET or POST).
     *
     * @param method the request method
     */
    public void setMethod(Connection.Method method) {
        JavaScriptObjectHelper.setAttribute(jsObj, "method", method.getMethod());
    }

    /**
     * The ID of the form that you want to use. The request parameters will include the Form's field names and values.
     *
     * @param formId the form ID
     */
    public void setForm(String formId) {
        JavaScriptObjectHelper.setAttribute(jsObj, "form", formId);
    }

    /**
     * Does the form do a file upload.
     *
     * @param isUpload true if file upload
     */
    public void setIsUpload(boolean isUpload) {
        JavaScriptObjectHelper.setAttribute(jsObj, "isUpload", isUpload);
    }

    /**
     * The headers to pass with the request.
     *
     * @param defaultHeaders the headers
     */
    public void setHeaders(NameValuePair[] defaultHeaders) {
        JavaScriptObject paramObj = NameValuePair.getJsObj(defaultHeaders);
        JavaScriptObjectHelper.setAttribute(jsObj, "headers", paramObj);
    }
}
