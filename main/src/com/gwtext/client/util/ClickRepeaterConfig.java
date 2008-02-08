/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.util;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.BaseConfig;

/**
 * ClickRepeater configuration class.
 */
public class ClickRepeaterConfig extends BaseConfig {

    /**
     * True if autorepeating should start slowly and accelerate.
     * "interval" and "delay" are ignored. "immediate" is honored.
     *
     * @param accelerate true to start slowly and accelerate
     */
    public void setAccelerate(boolean accelerate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "accelerate", accelerate);
    }

    /**
     * The initial delay before the repeating event begins firing. Similar to an autorepeat key delay.
     *
     * @param delay delay in milliseconds. Default is 250
     */
    public void setDelay(int delay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "delay", delay);
    }

    /**
     * The element to act as a button.
     *
     * @param element the element
     */
    public void setElement(Element element) {
        JavaScriptObjectHelper.setAttribute(jsObj, "el", element);
    }

    /**
     * The element to act as a button.
     *
     * @param elementID the element ID
     */
    public void setElement(String elementID) {
        JavaScriptObjectHelper.setAttribute(jsObj, "el", elementID);
    }

    /**
     * The interval between firings of the "click" event. Default is 10 milliseconds.
     *
     * @param interval the firing interval
     */
    public void setInterval(int interval) {
        JavaScriptObjectHelper.setAttribute(jsObj, "interval", interval);
    }

    /**
     * A CSS class name to be applied to the element while pressed.
     *
     * @param pressClass the press CSS class
     */
    public void setPressClass(String pressClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "pressClass", pressClass);
    }

    /**
     * True to prevent the default click event. Default is true.
     *
     * @param preventDefault true to prevent default click
     */
    public void setPreventDefault(boolean preventDefault) {
        JavaScriptObjectHelper.setAttribute(jsObj, "preventDefault", preventDefault);
    }

    /**
     * True to stop the default click event. Default is false.
     *
     * @param stopDefault true to stop default click event
     */
    public void setStopDefault(boolean stopDefault) {
        JavaScriptObjectHelper.setAttribute(jsObj, "stopDefault", stopDefault);
    }
}
