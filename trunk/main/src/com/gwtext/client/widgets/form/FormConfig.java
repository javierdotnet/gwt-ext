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
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.Reader;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.FormListener;

public class FormConfig extends BaseConfig {

    private int width = -1;
    private String widthStr;

    private String header;
    private FormListener formListener;
    private boolean surroundWithBox;

    public void setSurrondWithBox(boolean surroundWithBox) {
        this.surroundWithBox = surroundWithBox;
    }

    public boolean isSurroundWithBox() {
        return surroundWithBox;
    }

    //http://extjs.com/forum/showthread.php?t=4814&highlight=doAction
    //acts like hidden form fields
    public void setBaseParams(UrlParam[] params) {
        JavaScriptObject paramObj = UrlParam.getJsObj(params);
        JavaScriptObjectHelper.setAttribute(jsObj, "baseParams", paramObj);
    }

    public void setButtonAlign(String buttonAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buttonAlign", buttonAlign);
    }

    public void setErrorReader(Reader errorReader) {
        JavaScriptObjectHelper.setAttribute(jsObj, "errorReader", errorReader.getJsObj());
    }

    public void setFileUpload(boolean fileUpload) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fileUpload", fileUpload);
    }

    //http://extjs.com/forum/archive/index.php/t-7316.html
    public void setHideLabels(boolean hideLabels) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideLabels", hideLabels);
    }

    public void setItemCls(String itemCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "itemCls", itemCls);
    }

    public void setLabelAlign(String labelAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelAlign", labelAlign);
    }

    public void setLabelWidth(int labelWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelWidth", labelWidth);
    }

    //TODO enum
    public void setMethod(String method) {
        JavaScriptObjectHelper.setAttribute(jsObj, "method", method);
    }

    public void setMinButtonWidth(int minButtonWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minButtonWidth", minButtonWidth);
    }

    public void setMonitorPoll(int monitorPoll) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monitorPoll", monitorPoll);
    }

    //http://extjs.com/forum/showthread.php?t=5108&highlight=formBind
    public void setMonitorValid(boolean monitorValid) {
        JavaScriptObjectHelper.setAttribute(jsObj, "monitorValid", monitorValid);
    }

    public void setReader(Reader reader) {
        JavaScriptObjectHelper.setAttribute(jsObj, "reader", reader.getJsObj());
    }

    public void setTimeout(int timeout) {
        JavaScriptObjectHelper.setAttribute(jsObj, "timeout", timeout);
    }

    public void setTrackResetOnLoad(boolean trackResetOnLoad) {
        JavaScriptObjectHelper.setAttribute(jsObj, "trackResetOnLoad", trackResetOnLoad);
    }

    public void setUrl(String url) {
        JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
    }

    //synthetic param
    public void setWidth(int width) {
        this.width = width;
        this.widthStr = null;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.widthStr = width;
        this.width = -1;
    }

    public String getWidthStr() {
        return widthStr;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public FormListener getFormListener() {
        return formListener;
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

    public void setWaitMsgTarget(String waitMsgTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "waitMsgTarget", waitMsgTarget);
    }

    public void setWaitMsgTarget(boolean waitMsgTarget) {
        JavaScriptObjectHelper.setAttribute(jsObj, "waitMsgTarget", waitMsgTarget);
    }
}
