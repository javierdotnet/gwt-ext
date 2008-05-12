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
 
package com.gwtext.client.core;

import com.gwtext.client.animation.Easing;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration class for amination settings.
 *
 * @author Sanjiv Jivan
 * @see com.gwtext.client.core.BaseElement
 */
public class AnimationConfig extends BaseConfig {

    /**
     * The duration of the animation in seconds
     *
     * @param duration defaults to 0.35
     */
    public void setDuration(float duration) {
        JavaScriptObjectHelper.setAttribute(jsObj, "duration", duration);
    }

    /**
     * The Easing method.
     *
     * @param easing defaults to {@link com.gwtext.client.animation.Easing#EASE_NONE}
     */
    public void setEasing(Easing easing) {
        JavaScriptObjectHelper.setAttribute(jsObj, "easing", easing.getMethod());
    }

    /**
     * A function to execute when the anim completes.
     *
     * @param callback the callback function
     */
    public native void setCallback(Function callback) /*-{
        var config = this.@com.gwtext.client.core.JsObject::getJsObj()();
        config['callback'] = function() {
                            callback.@com.gwtext.client.core.Function::execute()();
                        };
    }-*/;
}
