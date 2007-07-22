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
import com.gwtext.client.core.Function;
import com.gwtext.client.core.EventCallback;

public class KeyNavConfig extends BaseConfig {

    public native void onEnter(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['enter'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onLeft(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['left'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onRight(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['right'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onUp(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['up'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;


    public native void onDown(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['down'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onTab(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['tab'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onEsc(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['esc'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onPageUp(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['pageUp'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onPageDown(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['pageDown'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onDel(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['del'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onHome(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['home'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;

    public native void onEnd(EventCallback cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['end'] = function(e) {
            var eJ = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(e);
            cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(eJ);
        };
    }-*/;
}