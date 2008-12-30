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

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Wait configuration class.
 *
 * @author Sanjiv Jivan
 * @see MessageBoxConfig#setWaitConfig(WaitConfig)
 * @see com.gwtext.client.widgets.ProgressBar#wait(WaitConfig)
 */
public class WaitConfig extends BaseConfig {
    /**
     * Create a new WaitConfig.
     */
    public WaitConfig() {
    }

    /**
     * Create a new WaitConfig.
     *
     * @param duration the length of time in milliseconds that the progress bar should run before resetting itself
     */
    public WaitConfig(int duration) {
        setDuration(duration);
    }

    /**
     * Create a new WaitConfig.
     *
     * @param duration the length of time in milliseconds that the progress bar should run before resetting itself
     * @param interval The length of time in milliseconds between each progress update
     * @param increment the number of progress update segments to display within the progress bar (defaults to 10).
     */
    public WaitConfig(int duration, int interval, int increment) {
        setDuration(duration);
        setInterval(interval);
        setIncrement(increment);
    }

    /**
     * The length of time in milliseconds that the progress bar should run before resetting itself (defaults to undefined,
     * in which case it will run indefinitely until reset is called).
     *
     * @param duration the duration
     */
    public void setDuration(int duration) {
        JavaScriptObjectHelper.setAttribute(jsObj, "duration", duration);
    }

    /**
     * The length of time in milliseconds between each progress update (defaults to 1000 ms).
     *
     * @param interval the interval
     */
    public void setInterval(int interval) {
        JavaScriptObjectHelper.setAttribute(jsObj, "interval", interval);
    }

    /**
     * The number of progress update segments to display within the progress bar (defaults to 10).  If the bar reaches
     * the end and is still updating, it will automatically wrap back to the beginning.
     *
     * @param increment the increment
     */
    public void setIncrement(int increment) {
        JavaScriptObjectHelper.setAttribute(jsObj, "increment", increment);
    }

    /**
     * A callback function to execute after the progress bar finishes auto-updating.
     * This function will be ignored if duration is not specified since in that case the
     * progress bar can only be stopped programmatically, so any required function should be called by the same code after
     * it resets the progress bar.
     *
     * @param callback the callback function
     */
    public native void setCallback(Function callback) /*-{
        var config = this.@com.gwtext.client.core.JsObject::getJsObj()();
        config['fn'] = function() {
                            callback.@com.gwtext.client.core.Function::execute()();
                        };
    }-*/;
}
