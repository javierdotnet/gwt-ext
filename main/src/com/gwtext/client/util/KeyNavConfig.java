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
package com.gwtext.client.util;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.EventCallback;

/**
 * KeyNav configuration class.
 */
public class KeyNavConfig extends BaseConfig {

    /**
     * Register handler for the Enter key.
     *
     * @param cb the key handler
     */
    public native void onEnter(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['enter'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the Left arrow key.
     *
     * @param cb the key handler
     */
    public native void onLeft(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['left'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the Right arrow key.
     *
     * @param cb the key handler
     */
    public native void onRight(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['right'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the Up arrow key.
     *
     * @param cb the key handler
     */
    public native void onUp(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['up'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the Down arrow key.
     *
     * @param cb the key handler
     */
    public native void onDown(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['down'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the Tab key.
     *
     * @param cb the key handler
     */
    public native void onTab(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['tab'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the Esc key.
     *
     * @param cb the key handler
     */
    public native void onEsc(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['esc'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the PageUp key.
     *
     * @param cb the key handler
     */
    public native void onPageUp(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['pageUp'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the PageDown key.
     *
     * @param cb the key handler
     */
    public native void onPageDown(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['pageDown'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the Del key.
     *
     * @param cb the key handler
     */
    public native void onDel(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['del'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the Home key.
     *
     * @param cb the key handler
     */
    public native void onHome(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['home'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    /**
     * Register handler for the End key.
     *
     * @param cb the key handler
     */
    public native void onEnd(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['end'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;
}