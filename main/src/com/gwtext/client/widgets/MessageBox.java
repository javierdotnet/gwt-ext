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

import com.gwtext.client.core.JsObject;

public class MessageBox {

    public abstract static class Button extends JsObject {
        private String type;

        private Button(){}

        private Button(String type) {
            this.type = type;
            init();
        }

        public String toString() {
            return type;
        }

        abstract void init();
    }

    public static Button OK = new Button("OK") {
        native void init() /*-{
            this.@com.gwtext.client.core.JsObject::jsObj = $wnd.Ext.MessageBox.OK;
        }-*/;
    };

    public static Button OKCANCEL = new Button("OKCANCEL") {
        native void init() /*-{
            this.@com.gwtext.client.core.JsObject::jsObj = $wnd.Ext.MessageBox.OKCANCEL;
        }-*/;
    };

    public static Button YESNO = new Button("YESNO") {
        native void init() /*-{
            this.@com.gwtext.client.core.JsObject::jsObj = $wnd.Ext.MessageBox.YESNO;
        }-*/;
    };

    public static Button YESNOCANCEL = new Button("YESNOCANCEL") {
        native void init() /*-{
            this.@com.gwtext.client.core.JsObject::jsObj = $wnd.Ext.MessageBox.YESNOCANCEL;
        }-*/;
    };

    public static interface AlertCallback {
        void execute();
    }

    public static interface ConfirmCallback {
        void execute(String btnID);
    }

    public static interface PromptCallback {
        void execute(String btnID, String text);
    }

    public static native void alert(String title, String message) /*-{
        $wnd.Ext.MessageBox.alert(title, message);
    }-*/;

    public static native void alert(String title, String message, AlertCallback cb) /*-{
        $wnd.Ext.MessageBox.alert(title, message, function() {
            cb.@com.gwtext.client.widgets.MessageBox.AlertCallback::execute()();
        });
    }-*/;

    public static native void confirm(String title, String message) /*-{
        $wnd.Ext.MessageBox.confirm(title, message);
    }-*/;

    public static native void confirm(String title, String message, ConfirmCallback cb) /*-{
        $wnd.Ext.MessageBox.confirm(title, message, function(btnID) {
            cb.@com.gwtext.client.widgets.MessageBox.ConfirmCallback::execute(Ljava/lang/String;)(btnID);
        });
    }-*/;

    public static native void hide() /*-{
        $wnd.Ext.MessageBox.hide();
    }-*/;

    public static native boolean isVisible() /*-{
        $wnd.Ext.MessageBox.isVisible();
    }-*/;

    public static native void progress(String title, String message) /*-{
        $wnd.Ext.MessageBox.progress(title, message);
    }-*/;

    public static native void prompt(String title, String message) /*-{
        $wnd.Ext.MessageBox.prompt(title, message);
    }-*/;

    public static native void prompt(String title, String message, PromptCallback cb) /*-{
        $wnd.Ext.MessageBox.prompt(title, message, function(btnID, text) {
            if(text === undefined) text = null;
            cb.@com.gwtext.client.widgets.MessageBox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
        });
    }-*/;
    
    public static native void show(MessageBoxConfig config) /*-{
        $wnd.Ext.MessageBox.show(config.@com.gwtext.client.core.JsObject::jsObj);
    }-*/;

    public static native void updateProgress(int percentage) /*-{
        $wnd.Ext.MessageBox.updateProgress(percentage / 100);
    }-*/;

    public static native void updateProgress(int percentage, String message) /*-{
        $wnd.Ext.MessageBox.updateProgress(percentage / 100, message);
    }-*/;

    public static native void updateText(String message) /*-{        
        $wnd.Ext.MessageBox.updateText(message);
    }-*/;

    public static native void wait(String message) /*-{
        $wnd.Ext.MessageBox.wait(message);
    }-*/;

    public static native void wait(String message, String title) /*-{
        $wnd.Ext.MessageBox.wait(message, title);
    }-*/;
}
