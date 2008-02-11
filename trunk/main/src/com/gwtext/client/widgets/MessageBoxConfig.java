/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.NameValuePair;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * {@link com.gwtext.client.widgets.MessageBox} configuration class.
 *
 * @see com.gwtext.client.widgets.MessageBox#show(MessageBoxConfig)
 */
public class MessageBoxConfig extends BaseConfig {

    /**
     * An id from which the message box should animate as it opens and closes (defaults to undefined).
     *
     * @param animEl the anim elem ID
     */
    public void setAnimEl(String animEl) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animEl", animEl);
    }

    /**
     * The title text.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        JavaScriptObjectHelper.setAttribute(jsObj, "title", title);
    }

    /**
     * False to hide the top-right close button (defaults to true).  Note that progress and wait dialogs will ignore
     * this property and always hide the close button as they can only be closed programmatically.
     *
     * @param closable true for closable
     */
    public void setClosable(boolean closable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "closable", closable);
    }

    /**
     * A custom CSS class to apply to the message box element.
     *
     * @param cls the css class
     */
    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    /**
     * The default height in pixels of the message box's multiline textarea if displayed (defaults to 75).
     *
     * @param defaultTextHeight the default text height
     */
    public void setDefaultTextHeight(int defaultTextHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultTextHeight", defaultTextHeight);
    }

    /**
     * True to prompt the user to enter single-line text (defaults to false).
     *
     * @param prompt true to prompt
     */
    public void setPrompt(boolean prompt) {
        JavaScriptObjectHelper.setAttribute(jsObj, "prompt", prompt);
    }

    /**
     * True to prompt the user to enter multi-line text (defaults to false).
     *
     * @param multiline true for multiline prompt
     */
    public void setMultiline(boolean multiline) {
        JavaScriptObjectHelper.setAttribute(jsObj, "multiline", multiline);
    }

    /**
     * True to display a progress bar (defaults to false)
     * 
     * @param progress true for progress bar
     */
    public void setProgress(boolean progress) {
        JavaScriptObjectHelper.setAttribute(jsObj, "progress", progress);
    }

    /**
     * The text to display inside the progress bar if progress = true (defaults to '').
     *
     * @param progressText the progress text
     */
    public void setProgressText(String progressText) {
        JavaScriptObjectHelper.setAttribute(jsObj, "progressText", progressText);
    }

    /**
     * he string value to set into the active textbox element if displayed.
     *
     * @param value the value text
     */
    public void setValue(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    /**
     * The button to display.
     *
     * @param buttons the buttons
     */
    public void setButtons(MessageBox.Button buttons) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buttons", buttons.getJsObj());
    }

    /**
     * False to not show any buttons.
     *
     * @param buttons display buttons
     */
    public void setButtons(boolean buttons) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buttons", buttons);
    }

    /**
     * A callback function to execute after closing the dialog.  The arguments to the function will be btn
     * (the name of the button that was clicked, if applicable, e.g. "ok"),
     * and text (the value of the active text field, if applicable).
     * Progress and wait dialogs will ignore this option since they do not respond to user actions and can only be
     * closed programmatically, so any required function should be called by the same code after it closes the dialog.
     *
     * @param cb the callback
     */
    public native void setCallback(MessageBox.PromptCallback cb)/*-{
        var config = this.@com.gwtext.client.core.JsObject::getJsObj()();
        config['fn'] = function(btnID, text) {
                            if(btnID === undefined) btnID = null;
                            if(text === undefined || text == '') text = null;
                            cb.@com.gwtext.client.widgets.MessageBox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
                        };
    }-*/;

    /**
     * name = button id, value = button label
     * Name has to be one of 'ok, cancel, yes, no, and value is the label to be dispalyed
     *
     * @param buttons the nambe value pairs for the buttons
     */
    public void setButtons(NameValuePair[] buttons) {
        JavaScriptObject config = NameValuePair.getJsObj(buttons);
        JavaScriptObjectHelper.setAttribute(jsObj, "buttons", config);
    }

    /**
     * The string that will replace the existing message box body text (defaults to the XHTML-compliant non-breaking space
     * character ' ')
     *
     * @param msg the message
     */
    public void setMsg(String msg) {
        JavaScriptObjectHelper.setAttribute(jsObj, "msg", msg);
    }

    /**
     * A CSS class that provides a background image to be used as an icon for the dialog (e.g., Ext.MessageBox.WARNING
     * or 'custom-class', defaults to '').
     *
     * @param iconCls the icon CSS class
     */
    public void setIconCls(String iconCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "icon", iconCls);
    }

    /**
     * True to display a lightweight proxy while dragging (defaults to false).
     *
     * @param proxyDrag true for proxy drag
     */
    public void setProxyDrag(boolean proxyDrag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "proxyDrag", proxyDrag);
    }

    /**
     * False to allow user interaction with the page while the message box is displayed
     * (defaults to true).
     *
     * @param modal false for non modal
     */
    public void setModal(boolean modal) {
        JavaScriptObjectHelper.setAttribute(jsObj, "modal", modal);
    }

    /**
     * The minimum width in pixels of the message box (defaults to 100).
     *
     * @param minWidth the min width
     */
    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }

    /**
     * The maximum width in pixels of the message box (defaults to 600).
     *
     * @param maxWidth the max width
     */
    public void setMaxWidth(int maxWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxWidth", maxWidth);
    }

    /**
     * The minimum width in pixels of the message box if it is a progress-style dialog. This is useful for setting a
     * different minimum width than text-only dialogs may need (defaults to 250)
     *
     * @param minProgressWidth the minimum width in pixels of the message box if it is a progress-style dialog.
     */
    public void setMinProgressWidth(int minProgressWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minProgressWidth", minProgressWidth);
    }

    /**
     * True to display a progress bar (defaults to false).
     *
     * @param wait true to display progress bar
     */
    public void setWait(boolean wait) {
        JavaScriptObjectHelper.setAttribute(jsObj, "wait", wait);
    }

    /**
     * Applies a wait with the specified waitConfig object (applies only if wait = true).
     *
     * @param waitConfig the wait config
     */
    public void setWaitConfig(WaitConfig waitConfig) {
        JavaScriptObjectHelper.setAttribute(jsObj, "waitConfig", waitConfig.getJsObj());
    }

    /**
     * The width of the dialog in pixels.
     *
     * @param width the dialog width
     */
    public void setWidth(int width) {
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
    }
}
