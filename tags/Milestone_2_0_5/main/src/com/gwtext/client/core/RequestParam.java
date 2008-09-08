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
 * This class represents a HTTP Request.
 *
 * @author Sanjiv Jivan
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
    public void setUrl(String url) {
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
