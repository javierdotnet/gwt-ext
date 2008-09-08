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
 
package com.gwtext.client.widgets;

import com.gwtext.client.core.JsObject;

/**
 * Utility class for generating different styles of message boxes.
 *
 * <br/><br/>
 * Note that the MessageBox is asynchronous. Unlike a regular JavaScript alert (which will halt browser execution), showing a MessageBox will not cause the code to stop. For this reason, if you have code that should only run after some user feedback from the MessageBox, you must use a callback function.
 *
 * @author Sanjiv Jivan
 */
public class MessageBox {

    public static String INFO = "ext-mb-info";
    public static String QUESTION = "ext-mb-question";
    public static String WARNING = "ext-mb-warning";
    public static String ERROR = "ext-mb-error";

    public abstract static class Button extends JsObject {
        private String type;

        private Button() {
        }

        private Button(String type) {
            this.type = type;
            init();
        }

        public String toString() {
            return type;
        }

        /**
         * @return the button ID
         */
        public String getID() {
            return type;
        }

        abstract void init();
    }

    public static Button CANCEL = new Button("CANCEL") {
        native void init() /*-{
            this.@com.gwtext.client.core.JsObject::jsObj = $wnd.Ext.MessageBox.CANCEL;
        }-*/;
    };

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
     * @param message the message
     */
    public static void alert(String message) {
      alert("", message);
    }
    
    /**
     * Displays a standard read-only message box with an OK button (comparable to the basic JavaScript Window.alert).
     *
     * @param title   the title
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
     * @param title   the title
     * @param message the message
     * @param cb      the callback function
     */
    public static native void alert(String title, String message, AlertCallback cb) /*-{
        $wnd.Ext.MessageBox.alert(title, message, function() {
            cb.@com.gwtext.client.widgets.MessageBox.AlertCallback::execute()();
        });
    }-*/;

    /**
     * Displays a confirmation message box with Yes and No buttons (comparable to JavaScript's Window.confirm).
     *
     * @param title   the title
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
     * @param title   the title
     * @param message the message
     * @param cb      the callback function
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
        return $wnd.Ext.MessageBox.isVisible();
    }-*/;

    /**
     * Displays a message box with a progress bar. This message box has no buttons and is not closeable by the user.
     * You are responsible for updating the progress bar as needed {@link #updateProgress} and closing the message
     * box when the process is complete.
     *
     * @param title   the title
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
     * @param title   the title
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
     * @param title   the title
     * @param message the message
     * @param cb      the prompt callback
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
     * Displays a message box with OK and Cancel buttons prompting the user to enter some text (comparable to JavaScript's Window.prompt).
     * The prompt can be a single-line or multi-line textbox. If a callback function is passed it will be called after
     * the user clicks either button, and the id of the button that was clicked (could also be the top-right close button)
     * and the text that was entered will be passed as the two parameters to the callback.
     *
     * @param title   the title
     * @param message the message
     * @param multiline true for multiline
     * @param cb      the prompt callback
     */
    public static native void prompt(String title, String message, PromptCallback cb, boolean multiline) /*-{
        $wnd.Ext.MessageBox.prompt(title, message, function(btnID, text) {
            //if no text is entered text is undedined in web mode but raises error in hosted mode typing to
            //coerce to string. Add harmless check for empty string too to keep host mode happy
            if(text === undefined || text == '') text = null;
            cb.@com.gwtext.client.widgets.MessageBox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
        }, $wnd, multiline);
    }-*/;

    /**
     * Adds the specified icon to the dialog. By default, the class 'ext-mb-icon' is applied for default styling, and
     * the class passed in is expected to supply the background image url. Pass in empty string ('') to clear any existing icon. The following built-in icon classes are supported,
     * but you can also pass in a custom class name:
     * <pre>
     *
     * MessageBox.INFO
     * MessageBox.WARNING
     * MessageBox.QUESTION
     * MessageBox.ERROR
     * </pre>
     * 
     * @param iconCls a CSS classname specifying the icon's background image url, or empty string to clear the icon
     */
    public static native void setIconCls(String iconCls) /*-{
        $wnd.Ext.MessageBox.setIcon(iconCls);
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
     * or by calling {@link #show} with progress config value true.
     *
     * @param percentage the progress percentage
     */
    public static native void updateProgress(int percentage) /*-{
        $wnd.Ext.MessageBox.updateProgress(percentage / 100);
    }-*/;

    /**
     * Updates a progress-style message box's text and progress bar. Only relevant on message boxes initiated via {@link #progress(String, String)}
     * or by calling {@link #show} with progress config value true.
     *
     * @param percentage the progress percentage
     * @param message    the progress message
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
     * @param title   the title
     */
    public static native void wait(String message, String title) /*-{
        $wnd.Ext.MessageBox.wait(message, title);
    }-*/;

    /**
     * The default height in pixels of the message box's multiline textarea if displayed (defaults to 75).
     *
     * @param height the default height
     */
    public static native void setDefaultTextHeight(int height) /*-{
        $wnd.Ext.MessageBox.defaultTextHeight = height;
    }-*/;

    /**
     * The maximum width in pixels of the message box (defaults to 600).
     *
     * @param width the max width
     */
    public static native void setMaxWidth(int width) /*-{
        $wnd.Ext.MessageBox.maxWidth = width;
    }-*/;

    /**
     * The minimum width in pixels of the message box if it is a progress-style dialog. This is useful for setting a different minimum width than text-only dialogs may need (defaults to 250).
     *
     * @param minProgressWidth the min progress width
     */
    public static native void setMinProgressWidth(int minProgressWidth) /*-{
        $wnd.Ext.MessageBox.minProgressWidth = minProgressWidth;
    }-*/;

    /**
     * The minimum width in pixels of the message box (defaults to 100).
     * 
     * @param minWidth the min width
     */
    public static native void setMinWidth(int minWidth) /*-{
        $wnd.Ext.MessageBox.minWidth = minWidth;
    }-*/;

    /**
     * Returns a reference to the underlying Window element.
     *
     * @return the window
     */
    public static native Window getDialog() /*-{
        var dialog = $wnd.Ext.MessageBox.getDialog();
        return @com.gwtext.client.widgets.Window::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(dialog);
    }-*/;
}
