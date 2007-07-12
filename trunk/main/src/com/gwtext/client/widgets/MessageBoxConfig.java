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

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.NameValuePair;
import com.gwtext.client.util.JavaScriptObjectHelper;

public class MessageBoxConfig extends BaseConfig {

    public void setAnimEl(String animEl) {
        JavaScriptObjectHelper.setAttribute(jsObj, "animEl", animEl);
    }
            
    public void setTitle(String title) {
        JavaScriptObjectHelper.setAttribute(jsObj, "title", title);
    }

    public void setClosable(boolean closable) {
        JavaScriptObjectHelper.setAttribute(jsObj, "closable", closable);
    }

    public void setPrompt(boolean prompt) {
        JavaScriptObjectHelper.setAttribute(jsObj, "prompt", prompt);
    }

    public void setMultiline(boolean multiline) {
        JavaScriptObjectHelper.setAttribute(jsObj, "multiline", multiline);
    }

    public void setProgress(boolean progress) {
        JavaScriptObjectHelper.setAttribute(jsObj, "progress", progress);
    }

    public void setValue(String value) {
        JavaScriptObjectHelper.setAttribute(jsObj, "value", value);
    }

    public void setButtons(MessageBox.Button buttons) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buttons", buttons.getJsObj());
    }
    
    public void setButtons(boolean buttons) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buttons", buttons);
    }

    //todo test
    public void setCallback(MessageBox.PromptCallback cb) {
        JavaScriptObjectHelper.setAttribute(jsObj, "fn", getCallbackFunction(cb));        
    }

    private native JavaScriptObject getCallbackFunction(MessageBox.PromptCallback cb) /*-{
        return function(btnID, text) {
            if(btnID === undefined) btnID = null;
            if(text === undefined) text = null;
            cb.@com.gwtext.client.widgets.MessageBox.PromptCallback::execute(Ljava/lang/String;Ljava/lang/String;)(btnID, text);
        }
    }-*/;


    //name = button id, value = button label
    //name has to be one of 'ok, cancel, yes, no, and value is the label to be dispalyed
    public void setButtons(NameValuePair[] buttons) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        for (int i = 0; i < buttons.length; i++) {
            NameValuePair button = buttons[i];
            JavaScriptObjectHelper.setAttribute(config, button.getParamName(), button.getParamValue());
        }
        JavaScriptObjectHelper.setAttribute(jsObj, "buttons", config);
    }
                   
    public void setMsg(String msg) {
        JavaScriptObjectHelper.setAttribute(jsObj, "msg", msg);
    }

    public void setCls(String cls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "cls", cls);
    }

    public void setProxyDrag(boolean proxyDrag) {
        JavaScriptObjectHelper.setAttribute(jsObj, "proxyDrag", proxyDrag);
    }

    public void setModal(boolean modal) {
        JavaScriptObjectHelper.setAttribute(jsObj, "modal", modal);
    }

    public void setMinWidth(int minWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minWidth", minWidth);
    }
    
    public void setMaxWidth(int maxWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "maxWidth", maxWidth);
    }
    
    public void setMinProgressWidth(int minProgressWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "minProgressWidth", minProgressWidth);
    }

    public void setDefaultTextHeight(int defaultTextHeight) {
        JavaScriptObjectHelper.setAttribute(jsObj, "defaultTextHeight", defaultTextHeight);
    }
                        
}
