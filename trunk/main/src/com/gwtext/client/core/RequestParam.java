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
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class RequestParam extends JsObject {

    public RequestParam() {
        jsObj = JavaScriptObjectHelper.createObject();
    }

    public void setUrl(boolean url) {
        JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
    }

    public void setParams(UrlParam[] params) {
        JavaScriptObject paramObj = JavaScriptObjectHelper.createObject();
        for (int i = 0; i < params.length; i++) {
            UrlParam param = params[i];
            JavaScriptObjectHelper.setAttribute(paramObj, param.getParamName(), param.getParamValue());
        }
        JavaScriptObjectHelper.setAttribute(jsObj, "params", paramObj);
    }

    public void setMethod(String method) {
        JavaScriptObjectHelper.setAttribute(jsObj, "method", method);
    }

    public void setForm(String formId) {
        JavaScriptObjectHelper.setAttribute(jsObj, "form", formId);
    }

    public void setIsUpload(boolean isUpload) {
        JavaScriptObjectHelper.setAttribute(jsObj, "isUpload", isUpload);
    }

    public void setHeaders(NameValuePair[] defaultHeaders) {
        JavaScriptObject paramObj = JavaScriptObjectHelper.createObject();
        for (int i = 0; i < defaultHeaders.length; i++) {
            NameValuePair header = defaultHeaders[i];
            JavaScriptObjectHelper.setAttribute(paramObj, header.getParamName(), header.getParamValue());
        }
        JavaScriptObjectHelper.setAttribute(jsObj, "headers", paramObj);
    }
}
