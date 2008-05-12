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
 
package com.gwtext.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.JsObject;

/**
 * Provides a convenient method of performing setTimeout where a new timeout cancels the old timeout.
 * An example would be performing validation on a keypress. You can use this class to buffer the keypress events for a
 * certain number of milliseconds, and perform only if they stop for that amount of time.
 *
 * @author Sanjiv Jivan
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
