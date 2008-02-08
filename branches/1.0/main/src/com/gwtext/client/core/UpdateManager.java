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
import com.google.gwt.user.client.Element;

/**
 * Provides AJAX-style update for Element object.
 *
 * Usage :
 * <pre>
 * ExtElement el = Ext.get("foo");
 * UpdateManager mgr = el.getUpdateManager();
 * mgr.update("http://myserver.com/index.php", "param1=1&param2=2");
 *
 * mgr.formUpdate("myFormId", "http://myserver.com/index.php");
 *
 * // or directly (returns the same UpdateManager instance)
 * UpdateManager mgr2 = new UpdateManager("myElementId");
 * mgr2.startAutoRefresh(60, "http://myserver.com/index.php");
 * mgr2.addListener("update", new EventCallback() {
 *     public void execute(EventObject e) {
 *         //
 *     }
 * });
 *  </pre>
 *
 */
public class UpdateManager extends JsObject {

    /**
     * Create new UpdateManager directly.
     *
     * @param elementID the elemetn ID
     */
    public UpdateManager(String elementID) {
        jsObj = create(elementID);
    }

    /**
     * Create new UpdateManager directly.
     *
     * @param element the element
     */
    public UpdateManager(Element element) {
        jsObj = create(element);
    }

    /**
     * Create new UpdateManager directly.
     *
     * @param element the element
     */
    public UpdateManager(ExtElement element) {
        jsObj = create(element.getJsObj());
    }
    
    private native JavaScriptObject create(String elementID) /*-{
        return new $wnd.Ext.UpdateManager(elementID);
    }-*/;

    private native JavaScriptObject create(Element element) /*-{
        return new $wnd.Ext.UpdateManager(element);
    }-*/;

    private native JavaScriptObject create(JavaScriptObject element) /*-{
        return new $wnd.Ext.UpdateManager(element);
    }-*/;

    public UpdateManager(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static UpdateManager instance(JavaScriptObject jsObj) {
        return new UpdateManager(jsObj);
    }

    /**
     * Timeout for requests or form posts in seconds (Defaults to 30 seconds).
     *
     * @param timeout the default timeout
     */
    public static native void setDefaultTimeout(int timeout)/*-{
        $wnd.Ext.UpdateManager.defaults.timeout = timeout;
    }-*/;

    /**
     * True to process scripts in the output (Defaults to false).
     * 
     * @param loadScripts true to laod scripts
     */
    public static native void setDefaultLoadScripts(boolean loadScripts)/*-{
        $wnd.Ext.UpdateManager.defaults.loadScripts = loadScripts;
    }-*/;

    /**
     * Blank page URL to use with SSL file uploads (Defaults to "about:blank").
     *
     * @param sslBlankUrl ssl blank url
     */
    public static native void setDefaultSslBlankUrl(String sslBlankUrl)/*-{
        $wnd.Ext.UpdateManager.defaults.sslBlankUrl = sslBlankUrl;
    }-*/;

    /**
     * Whether to append unique parameter on get request to disable caching (Defaults to false).
     * 
     * @param disableCaching true to disable caching
     */
    public static native void setDefaultDisableCaching(boolean disableCaching)/*-{
        $wnd.Ext.UpdateManager.defaults.disableCaching = disableCaching;
    }-*/;

    /**
     * Whether to show indicatorText when loading (Defaults to true).
     *
     * @param showLoadIndicator true to show indicator
     */
    public static native void setDefaultShowLoadIndicator(boolean showLoadIndicator)/*-{
        $wnd.Ext.UpdateManager.defaults.showLoadIndicator = showLoadIndicator;    
    }-*/;

    /**
     * Text for loading indicator (Defaults to  '&lt;div class="loading-indicator"&gt;Loading...&lt;/div&gt;').
     *
     * @param indicatorText the indicator text
     */
    public static native void setDefaultIndicatorText(String indicatorText)/*-{
        $wnd.Ext.UpdateManager.defaults.indicatorText = indicatorText;
    }-*/;

    /**
     * Aborts the executing transaction.
     */
    public native void abort() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.abort();
    }-*/;

    /**
     * Appends an event handler.
     *
     * @param eventName the type of event to append
     * @param cb the event callback
     */
    public native void addListener(String eventName, EventCallback cb) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.addListener(eventName, function(event) {
                var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(e);
            }
        );
    }-*/;

    /**
     * Performs an async form post, updating this element with the response. If the form has the attribute enctype="multipart/form-data", it assumes it's a file upload.
     * Uses this.sslBlankUrl for SSL file uploads to prevent IE security warning.
     * 
     * @param formID the form ID
     */
    public native void formUpdate(String formID) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.formUpdate(formID);
    }-*/;

    /**
     * Performs an async form post, updating this element with the response. If the form has the attribute enctype="multipart/form-data", it assumes it's a file upload.
     * Uses this.sslBlankUrl for SSL file uploads to prevent IE security warning.
     *
     * @param formID the form ID
     * @param url The url to pass the form to. If omitted the action attribute on the form will be used.
     */
    public native void formUpdate(String formID, String url) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.formUpdate(formID, url);
    }-*/;

    /**
     * Performs an async form post, updating this element with the response. If the form has the attribute enctype="multipart/form-data", it assumes it's a file upload.
     * Uses this.sslBlankUrl for SSL file uploads to prevent IE security warning.
     *
     * @param formID the form ID
     * @param url The url to pass the form to. If omitted the action attribute on the form will be used.
     * @param reset Whether to try to reset the form after the update
     * @param callback callback when transaction is complete
     */
    public native void formUpdate(String formID, String url, boolean reset, UrlLoadCallback callback) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        var cb;
        if(callback != null) {
            cb = function(options, success, response) {
                callback.@com.gwtext.client.core.UrlLoadCallback::execute(ZILjava/lang/String;)(success, response.status, response.responseText);
            }
        }
        um.formUpdate(formID, url, reset, cb);
    }-*/;

    /**
     * Get the Element this UpdateManager is bound to.
     *
     * @return the element
     */
    public native ExtElement getEl() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = um.getEl();
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Returns true if an update is in progress.
     *
     * @return true if update in progress
     */
    public native boolean isUpdating() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        return um.isUpdating();
    }-*/;

    /**
     * Refresh the element with the last used url or defaultUrl. If there is no url, it returns immediately.
     */
    public native void refresh() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.refresh();
    }-*/;

    /**
     * Set the defaultUrl used for updates.
     *
     * @param url the default url
     */
    public native void setDefaultUrl(String url) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.setDefaultUrl(url);
    }-*/;

    /**
     * True to disable caching.
     * 
     * @param disableCaching true to disable caching
     */
    public native void setDisableCaching(boolean disableCaching) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.disableCaching = disableCaching;
    }-*/;

    /**
     * Set the loading indicator text.
     *
     * @param indicatorText the indicator text
     */
    public native void setIndicatorText(String indicatorText) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.indicatorText = indicatorText;
    }-*/;

    /**
     * Wheter to load scripts in the contents.
     *
     * @param loadScripts true to laod scripts
     */
    public native void setLoadScripts(boolean loadScripts) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.loadScripts = loadScripts;
    }-*/;

    //TODO this does not work in Ext (possible Ext bug).
    /**
     * Request method (GET or POST).
     *
     * @param method the request method
     */
    public native void setMethod(Connection.Method method) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.method = method.@com.gwtext.client.core.Connection$Method::getMethod()();
    }-*/;

    /**
     * Whether to show the loading indicator.
     *
     * @param showIndicator true to show loading indicator
     */
    public native void setShowIndicator(boolean showIndicator) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.showIndicator = showIndicator;
    }-*/;

    /**
     * Timeout for the request.
     *
     * @param timeout the timeout in seconds
     */
    public native void setTimeout(int timeout) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.timeout = timeout ;
    }-*/;

    /**
     * Set this element to auto refresh.
     *
     * @param interval how often to update in seconds
     */
    public native void startAutoRefresh(int interval) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.startAutoRefresh(interval);
    }-*/;

    /**
     * Set this element to auto refresh.
     *
     * @param interval how often to update in seconds
     * @param url The url for this request or a function to call to get the url (Defaults to the last used url)
     */
    public native void startAutoRefresh(int interval, String url) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.startAutoRefresh(interval, url);
    }-*/;

    /**
     * Set this element to auto refresh.
     *
     * @param interval how often to update in seconds
     * @param url The url for this request or a function to call to get the url (Defaults to the last used url)
     * @param params the parameters to pass as a url encoded string "&param1=1&param2=2"
     * @param cb callback when the transaction is complete
     * @param refreshNow whether to execute the refresh now, or wait the interval
     */
    public native void startAutoRefresh(int interval, String url, String params, Function cb, boolean refreshNow) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.startAutoRefresh(interval, url, params, function() {
            cb.@com.gwtext.client.core.Function::execute()();
        }, refreshNow);
    }-*/;

    /**
     * Stop auto refresh on this element.
     */
    public native void stopAutoRefresh() /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.stopAutoRefresh();
    }-*/;

    /**
     * Performs an async request, updating this element with the response. If params are specified it uses POST,
     * otherwise it uses GET.
     * 
     * @param url the url for this request
     * @param params the parameters to pass as a url encoded string "param1=1&param2=2"
     */
    public native void update(String url, String params) /*-{
        var um = this.@com.gwtext.client.core.JsObject::jsObj;
        um.update(url, params);
    }-*/;

    /**
     * Performs an async request, updating this element with the response. If params are specified it uses POST,
     * otherwise it uses GET.
     *
     * @param url the url for this request
     * @param params the parameters to pass as a url encoded string "param1=1&param2=2"
     * @param callback the callback when transaction is complete
     * @param discardUrl by default when you execute an update the defaultUrl is changed to the last used url. If true, it will not store the url.
     */
    public void update(String url, UpdateManagerConfig params, UrlLoadCallback callback, boolean discardUrl) {
        if(params == null) {
            params = new UpdateManagerConfig();            
        }
        params.setUrl(url);
        update(jsObj, params.getJsObj(), callback, discardUrl);
    }

    private static native void update(JavaScriptObject updateManager,  JavaScriptObject params, UrlLoadCallback callback, boolean discardUrl)/*-{
        var cb;
        if(callback != null) {
            cb = function(options, success, response) {
                callback.@com.gwtext.client.core.UrlLoadCallback::execute(ZILjava/lang/String;)(success, response.status, response.responseText);
            }
        }
        updateManager.update(params, null, cb, discardUrl);
    }-*/;
}
