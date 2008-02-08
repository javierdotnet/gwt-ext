/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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
