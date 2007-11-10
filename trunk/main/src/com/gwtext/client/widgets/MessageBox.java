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

/**
 * Utility class for generating different styles of message boxes.
 */
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

	/**
	 * Displays a standard read-only message box with an OK button (comparable to the basic JavaScript Window.alert).
	 *
	 * @param title the title
	 * @param message the message
	 */
	public static native void alert(String title, String message) /*-{
        $wnd.Ext.MessageBox.alert(title, message);
    }-*/;

	/**
	 * Displays a standard read-only message box with an OK button (comparable to the basic JavaScript Window.alert).
	 * If a callback function is passed it will be called after the user clicks the button, and the id of the button that
	 * was clicked will be passed as the only parameter to the callback (could also be the top-right close button).
	 *
	 * @param title the title
	 * @param message the message
	 * @param cb the callback function
	 */
    public static native void alert(String title, String message, AlertCallback cb) /*-{
        $wnd.Ext.MessageBox.alert(title, message, function() {
            cb.@com.gwtext.client.widgets.MessageBox.AlertCallback::execute()();
        });
    }-*/;

	/**
	 * Displays a confirmation message box with Yes and No buttons (comparable to JavaScript's Window.confirm).
	 *
	 * @param title the title
	 * @param message the message
	 */
	public static native void confirm(String title, String message) /*-{
        $wnd.Ext.MessageBox.confirm(title, message);
    }-*/;

	/**
	 * Displays a confirmation message box with Yes and No buttons (comparable to JavaScript's Window.confirm). If a
	 * callback function is passed it will be called after the user clicks either button, and the id of the button that
	 * was clicked will be passed as the only parameter to the callback (could also be the top-right close button).
	 *
	 * @param title the title
	 * @param message the message
	 * @param cb the callback function
	 */
	public static native void confirm(String title, String message, ConfirmCallback cb) /*-{
        $wnd.Ext.MessageBox.confirm(title, message, function(btnID) {
            cb.@com.gwtext.client.widgets.MessageBox.ConfirmCallback::execute(Ljava/lang/String;)(btnID);
        });
    }-*/;

	/**
	 * Hides the message box if it is displayed.
	 */
	public static native void hide() /*-{
        $wnd.Ext.MessageBox.hide();
    }-*/;

	/**
	 * Returns true if the message box is currently displayed.
	 * 
	 * @return true if visible
	 */
	public static native boolean isVisible() /*-{
        $wnd.Ext.MessageBox.isVisible();
    }-*/;

	/**
	 * Displays a message box with a progress bar. This message box has no buttons and is not closeable by the user.
	 * You are responsible for updating the progress bar as needed {@link #updateProgress} and closing the message
	 * box when the process is complete.
	 * 
	 * @param title  the title
	 * @param message the message
	 */
	public static native void progress(String title, String message) /*-{
        $wnd.Ext.MessageBox.progress(title, message);
    }-*/;

	/**
	 * Displays a message box with OK and Cancel buttons prompting the user to enter some text (comparable to JavaScript's Window.prompt).
	 * The prompt can be a single-line or multi-line textbox. If a callback function is passed it will be called after
	 * the user clicks either button, and the id of the button that was clicked (could also be the top-right close button)
	 * and the text that was entered will be passed as the two parameters to the callback.
	 * 
	 * @param title the title
	 * @param message the message
	 */
	public static native void prompt(String title, String message) /*-{
        $wnd.Ext.MessageBox.prompt(title, message);
    }-*/;

	/**
	 * Displays a message box with OK and Cancel buttons prompting the user to enter some text (comparable to JavaScript's Window.prompt).
	 * The prompt can be a single-line or multi-line textbox. If a callback function is passed it will be called after
	 * the user clicks either button, and the id of the button that was clicked (could also be the top-right close button)
	 * and the text that was entered will be passed as the two parameters to the callback.
	 *
	 * @param title the title
	 * @param message the message
	 * @param cb the prompt callback
	 */
	public static native void prompt(String title, String message, PromptCallback cb) /*-{
        $wnd.Ext.MessageBox.prompt(title, message, function(btnID, text) {
            //if no text is entered text is undedined in web mode but raises error in hosted mode typing to
            //coerce to string. Add harmless check for empty string too to keep host mode happy
            if(text === undefined || text == '') text = null;
            cb.@com.gwtext.client.widgets.MessageBox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
        });
    }-*/;

	/**
	 * Displays a new message box, or reinitializes an existing message box, based on the config options passed in.
	 * 
	 * @param config the message box config
	 */
	public static native void show(MessageBoxConfig config) /*-{
        $wnd.Ext.MessageBox.show(config.@com.gwtext.client.core.JsObject::jsObj);
    }-*/;

	/**
	 * Updates a progress-style message box's text and progress bar. Only relevant on message boxes initiated via {@link #progress(String, String)}
	 * or by calling {@link #show) with progress config value true.
	 * 
	 * @param percentage th progress percentage
	 */
	public static native void updateProgress(int percentage) /*-{
        $wnd.Ext.MessageBox.updateProgress(percentage / 100);
    }-*/;

	/**
	 * Updates a progress-style message box's text and progress bar. Only relevant on message boxes initiated via {@link #progress(String, String)}
	 *  or by calling {@link #show) with progress config value true.
	 *
	 * @param percentage the progress percentage
	 * @param message the progress message
	 */
    public static native void updateProgress(int percentage, String message) /*-{
        $wnd.Ext.MessageBox.updateProgress(percentage / 100, message);
    }-*/;

	/**
	 * Updates the message box body text.
	 *
	 * @param message Replaces the message box element's innerHTML with the specified string (defaults to the XHTML-compliant non-breaking space character '&#160;')
	 */
	public static native void updateText(String message) /*-{
        $wnd.Ext.MessageBox.updateText(message);
    }-*/;

	/**
	 * Displays a message box with an infinitely auto-updating progress bar. This can be used to block user interaction
	 * while waiting for a long-running process to complete that does not have defined intervals. You are responsible for closing the message box when the process is complete.
	 * 
	 * @param message the wait message
	 */
	public static native void wait(String message) /*-{
        $wnd.Ext.MessageBox.wait(message);
    }-*/;

	/**
	 * Displays a message box with an infinitely auto-updating progress bar. This can be used to block user interaction
	 * while waiting for a long-running process to complete that does not have defined intervals. You are responsible for closing the message box when the process is complete.
	 *
	 * @param message the wait message
	 * @param title the title
	 */
	public static native void wait(String message, String title) /*-{
        $wnd.Ext.MessageBox.wait(message, title);
    }-*/;
}
