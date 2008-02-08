/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

import com.gwtext.client.util.JavaScriptObjectHelper;

public class ListenerConfig extends BaseConfig {

    public void setStopEvent(boolean stopEvent) {
        JavaScriptObjectHelper.setAttribute(jsObj, "stopEvent", stopEvent);
    }

    public void setPreventDefault(boolean preventDefault) {
        JavaScriptObjectHelper.setAttribute(jsObj, "preventDefault", preventDefault);
    }

    public void setStopPropagation(boolean stopPropagation) {
        JavaScriptObjectHelper.setAttribute(jsObj, "stopPropagation", stopPropagation);
    }

    public void setDelay(int delay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "delay", delay);
    }

    public void setSingle(boolean single) {
        JavaScriptObjectHelper.setAttribute(jsObj, "single", single);
    }

    public void setBuffer(int buffer) {
        JavaScriptObjectHelper.setAttribute(jsObj, "buffer", buffer);
    }
}
