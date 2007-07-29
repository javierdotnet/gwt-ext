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

public class UpdateManager extends JsObject {

    public UpdateManager(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static UpdateManager instance(JavaScriptObject jsObj) {
        return new UpdateManager(jsObj);
    }

    public static native void setDefaultTimeout(int timeout)/*-{
        $wnd.Ext.UpdateManager.defaults.timeout = timeout;
    }-*/;

    public static native void setDefaultLoadScripts(boolean loadScripts)/*-{
        $wnd.Ext.UpdateManager.defaults.loadScripts = loadScripts;
    }-*/;

    public static native void setDefaultSslBlankUrl(String sslBlankUrl)/*-{
        $wnd.Ext.UpdateManager.defaults.sslBlankUrl = sslBlankUrl;
    }-*/;

    public static native void setDefaultDisableCaching(boolean disableCaching)/*-{
        $wnd.Ext.UpdateManager.defaults.disableCaching = disableCaching;
    }-*/;

    public static native void setDefaultShowLoadIndicator(boolean showLoadIndicator)/*-{
        $wnd.Ext.UpdateManager.defaults.showLoadIndicator = showLoadIndicator;    
    }-*/;

    public static native void setDefaultIndicatorText(String indicatorText)/*-{
        $wnd.Ext.UpdateManager.defaults.indicatorText = indicatorText;
    }-*/;

    public native void abort() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.abort();
    }-*/;

    public native void formUpdate(String formID) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.formUpdate(formID);
    }-*/;

    public native void formUpdate(String formID, String url, boolean reset, UrlLoadCallback callback) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        var cb;
        if(callback != null) {
            cb = function(options, success, response) {
                callback.@com.gwtext.client.core.UrlLoadCallback::execute(ZLjava/lang/String;)(success, response.responseText);
            }
        }
        um.formUpdate(formID, url, reset, cb);
    }-*/;

    public native void getEl() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = um.getEl();
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public native boolean isUpdating() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        return um.isUpdating();
    }-*/;

    public native void refresh() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.refresh();
    }-*/;

    public native void setDefaultUrl(String url) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.setDefaultUrl(url);
    }-*/;

    public native void setDisableCaching(boolean disableCaching) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.disableCaching = disableCaching;
    }-*/;

    public native void setIndicatorText(String indicatorText) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.indicatorText = indicatorText;
    }-*/;

    public native void setLoadScripts(boolean loadScripts) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.loadScripts = loadScripts;
    }-*/;

    public native void setShowIndicator(boolean showIndicator) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.showIndicator = showIndicator;
    }-*/;

    public native void setTimeout(int timeout) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.timeout = timeout ;
    }-*/;
   
    public native void startAutoRefresh(int interval) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.startAutoRefresh(interval);
    }-*/;

    public native void stopAutoRefresh() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.stopAutoRefresh();
    }-*/;

    public void update(String url, UpdateManagerConfig params, UrlLoadCallback callback, boolean discardUrl) {
        update(jsObj, url, params == null ? null : params.getJsObj(), callback, discardUrl);
    }

    private static native void update(JavaScriptObject updateManager, String url, JavaScriptObject params, UrlLoadCallback callback, boolean discardUrl)/*-{
        var cb;
        if(callback != null) {
            cb = function(options, success, response) {
                callback.@com.gwtext.client.core.UrlLoadCallback::execute(ZLjava/lang/String;)(success, response.responseText);
            }
        }
        updateManager.update(url, params, cb, discardUrl);
    }-*/;
}
