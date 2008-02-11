/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.JsObject;

/**
 * Provides a convenient method of performing setTimeout where a new timeout cancels the old timeout.
 * An example would be performing validation on a keypress. You can use this class to buffer the keypress events for a
 * certain number of milliseconds, and perform only if they stop for that amount of time.
 */
public class DelayedTask extends JsObject {

    /**
     * Creates a new DelayedTask.
     */
    public DelayedTask() {
        jsObj = create();
    }

    private native JavaScriptObject create() /*-{
        return new $wnd.Ext.util.DelayedTask();
    }-*/;

    /**
     * Cancel the last queued timeout.
     */
    public native void cancel() /*-{
        var dtask = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dtask.cancel();
    }-*/;

    /**
     * Cancels any pending timeout and queues a new one.
     *
     * @param delay the milliseconds to delay
     * @param task  the task
     */
    public native void delay(int delay, Function task) /*-{
        var dtask = this.@com.gwtext.client.core.JsObject::getJsObj()();
        dtask.delay(delay, function() {
            task.@com.gwtext.client.core.Function::execute()();
        });
    }-*/;
}
