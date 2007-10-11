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
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.RegExp;
import com.gwtext.client.core.UpdateManagerConfig;
import com.gwtext.client.core.UrlLoadCallback;
import com.gwtext.client.widgets.event.JsonViewListener;

public class JsonView extends View {

    public JsonView(Element container, String template, JsonViewConfig config) {
        super(container, template, config);
    }

    protected native JavaScriptObject create(Element container, String template, JavaScriptObject config) /*-{
        return new $wnd.Ext.JsonView(container, template, config);
    }-*/;

    protected native JavaScriptObject create(Element container, JavaScriptObject template, JavaScriptObject config) /*-{
        return new $wnd.Ext.JsonView(container, template, config);
    }-*/;

    public native void clearFilter() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.clearFilter();
    }-*/;

    public native void filter(String startsWith) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        view.filter(startsWith);
    }-*/;

    public native void filter(RegExp regexp) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var regexpJS = regexp.@com.gwtext.client.core.JsObject::jsObj;
        view.filter(regexpJS);
    }-*/;

    //todo filterBy

    public native int getCount() /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        return view.getCount();
    }-*/;

    //todo getNodeData

    public void load(String url, UpdateManagerConfig params, UrlLoadCallback callback, boolean discardUrl) {
        load(jsObj, url, params.getJsObj(), callback, discardUrl);
    }

    private static native void load(JavaScriptObject jsonView, String url, JavaScriptObject params, UrlLoadCallback callback, boolean discardUrl)/*-{
        var cb;
        if(callback != null) {
            cb = function(options, success, response) {
                callback.@com.gwtext.client.core.UrlLoadCallback::execute(ZILjava/lang/String;)(success, response.status, response.responseText);
            }
        }
        jsonView.load(url, params, cb, discardUrl);
    }-*/;

    public native void sort(String property, String direction) /*-{
		var jsonView = this.@com.gwtext.client.core.JsObject::jsObj;
		jsonView.sort(property, direction);
	}-*/;

    public native void addJsonViewListener(JsonViewListener listener) /*-{
        var view = this.@com.gwtext.client.core.JsObject::jsObj;
        var viewJ = this;

        view.addListener('beforerender',
                function(self, data) {
                    return listener.@com.gwtext.client.widgets.event.JsonViewListener::doBeforeRender(Lcom/gwtext/client/widgets/JsonView;)(viewJ);
                }
        );

        view.addListener('load',
                function(self, data, response) {
                    listener.@com.gwtext.client.widgets.event.JsonViewListener::onLoad(Lcom/gwtext/client/widgets/JsonView;)(viewJ);
                }
        );

        view.addListener('loadexception',
                function(self, response) {
                    listener.@com.gwtext.client.widgets.event.JsonViewListener::onLoadException(Lcom/gwtext/client/widgets/JsonView;ILjava/lang/String;)(viewJ, response.status, response.responseText)
                }
        );

    }-*/;
}
