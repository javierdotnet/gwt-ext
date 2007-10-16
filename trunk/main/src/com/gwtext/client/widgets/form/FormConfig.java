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

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.Connection;
import com.gwtext.client.core.Position;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.Reader;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.FormListener;

/**
 * Form configuration class.
 */
public class FormConfig extends BaseConfig {

    private int width = -1;
    private String widthStr;

    private String header;
    private FormListener formListener;
    private boolean surroundWithBox;

    /**
     * Surround the Form with a box decoration.
     *
     * @param surroundWithBox true to surround Form with box
     */
    public void setSurroundWithBox(boolean surroundWithBox) {
        this.surroundWithBox = surroundWithBox;
    }

    /**
     * Returns true is surround Form with box.
     *
     * @return true if surround with box
     */
    public boolean isSurroundWithBox() {
        return surroundWithBox;
    }

    //http://extjs.com/forum/showthread.php?t=4814&highlight=doAction
    //acts like hidden form fields
    /**
     * Parameters to pass with all requests. This effectively acts like Form hidden fields.
     *
     * @param params the base params
     */
    public void setBaseParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "baseParams", paramObj);
    }

    /**
     * Valid values are "left," "center" and "right" (defaults to "center").
     * 
     * @param buttonAlign form button position
     */
    public void setButtonAlign(Position buttonAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buttonAlign", buttonAlign.getPosition());
    }

    /**
     * A {@link Reader} (e.g. {@link com.gwtext.client.data.XmlReader}) to be used to read data when reading validation errors on "submit" actions.
     * This is completely optional as there is built-in support for processing JSON.
     *
     * @param errorReader the error reader
     */
    public void setErrorReader(Reader errorReader) {
        JavaScriptObjectHelper.setAttribute(jsObj, "errorReader", errorReader.getJsObj());
    }

    /**
     * Set true if this form is a file upload.
     *
     * @param fileUpload true if file upload
     */
    public void setFileUpload(boolean fileUpload) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fileUpload", fileUpload);
    }

    //http://extjs.com/forum/archive/index.php/t-7316.html
    /**
     * Set to true to hide all field labels.
     *
     * @param hideLabels true to hide field labels
     */
    public void setHideLabels(boolean hideLabels) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideLabels", hideLabels);
    }

    /**
     * A CSS class to apply to the x-form-item of fields. This property cascades to child containers.
     * 
     * @param itemCls CSS class
     */
    public void setItemCls(String itemCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "itemCls", itemCls);
    }

    /**
     * Valid values are "left," "top" and "right" (defaults to "left"). This property cascades to child containers if not set.
     *
     * @param labelAlign label alignment
     */
    public void setLabelAlign(Position labelAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelAlign", labelAlign.getPosition());
    }

    /**
     * The width of labels. This property cascades to child containers.
     * 
     * @param labelWidth the label width
     */
    public void setLabelWidth(int labelWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelWidth", labelWidth);
    }

    /**
     * The request method to use (GET or POST) for form actions if one isn't supplied in the action options.
     * 
     * @param method the request method
     */
    public void setMethod(Connection.Method method) {
        JavaScriptObjectHelper.setAttribute(jsObj, "method", method.getMethod());
    }

    
    /**
     * The request method to use (GET or POST) for form actions if one isn't supplied in the action options.
     *
     * @param method the request method
     * @deprecated Use {@link #setMethod(com.gwtext.client.core.Connection.Method)} instead
     */
    public void setMethod(String method) {
        JavaScriptObjectHelper.setAttribute(jsObj, "method", method);
    }

    /**
     * Minimum width of all buttons in pixels (defaults to 75).
     * 
     * @param minButtonWidth min button width
     */
    public void setMinButtonWidth(int minButtonWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minButtonWidth", minButtonWidth);
    }

    /**
     * The milliseconds to poll valid state, ignored if monitorValid is not true (defaults to 200).
     * 
     * @param monitorPoll the monitor poll in milliseconds
     */
    public void setMonitorPoll(int monitorPoll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monitorPoll", monitorPoll);
    }

    //http://extjs.com/forum/showthread.php?t=5108&highlight=formBind
    /**
     * If true the form monitors its valid state client-side and fires a looping event with that state. This is required
     * to bind buttons to the valid state using the config value formBind:true on the button.
     *
     * @param monitorValid true to enable monitoring
     */
    public void setMonitorValid(boolean monitorValid) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monitorValid", monitorValid);
    }

    /**
     * A {@link Reader} (e.g. {@link com.gwtext.client.data.XmlReader}) to be used to read data when executing "load" actions.
     * This is optional as there is built-in support for processing JSON.
     *
     * @param reader the load Reader
     */
    public void setReader(Reader reader) {
        JavaScriptObjectHelper.setAttribute(jsObj, "reader", reader.getJsObj());
    }

    /**
     * Timeout for form actions in seconds (default is 30 seconds).
     * 
     * @param timeout timeout in seconds
     */
    public void setTimeout(int timeout) {
        JavaScriptObjectHelper.setAttribute(jsObj, "timeout", timeout);
    }

    /**
     * If set to true, form.reset() resets to the last loaded or setValues() data instead of when the form was first created.
     *
     * @param trackResetOnLoad true to track reset on load
     */
    public void setTrackResetOnLoad(boolean trackResetOnLoad) {
        JavaScriptObjectHelper.setAttribute(jsObj, "trackResetOnLoad", trackResetOnLoad);
    }

    /**
     * The URL to use for form actions if one isn't supplied in the action options.
     * 
     * @param url the url
     */
    public void setUrl(String url) {
        JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
    }

    //synthetic param
    /**
     * Sets the Form width.
     *
     * @param width the form width
     */
    public void setWidth(int width) {
        this.width = width;
        this.widthStr = null;
    }

    /**
     * Returns the Form width
     *
     * @return the form width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the Form width.
     *
     * @param width the form width
     */
    public void setWidth(String width) {
        this.widthStr = width;
        this.width = -1;
    }

    /**
     * Return the forms width.
     *
     * @return the forms width
     */
    public String getWidthStr() {
        return widthStr;
    }

    /**
     * Set the Form's header text.
     *
     * @param header the forms header
     */
    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Header text for the form.
     *
     * @return form header
     */
    public String getHeader() {
        return header;
    }

    /**
     * Return the Form's listener.
     *
     * @return the forms listener
     */
    public FormListener getFormListener() {
        return formListener;
    }

    /**
     * Set the Form's listener
     *
     * @param formListener the listener
     */
    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

    /**
     * By default wait messages are displayed with {@link com.gwtext.client.widgets.MessageBox#wait(long)}.
     * You can target a specific element by passing its id.
     * 
     * @param waitMsgTarget ID of the Element to mask
     */
    public void setWaitMsgTarget(String waitMsgTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "waitMsgTarget", waitMsgTarget);
    }

    /**
     * By default wait messages are displayed with {@link com.gwtext.client.widgets.MessageBox#wait(long)}.
     * You can mask the form itself by passing in true.
     *
     * @param waitMsgTarget true to mask the form
     */
    public void setWaitMsgTarget(boolean waitMsgTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "waitMsgTarget", waitMsgTarget);
    }
}
