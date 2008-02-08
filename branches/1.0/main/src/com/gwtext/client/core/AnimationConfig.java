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
package com.gwtext.client.core;

import com.gwtext.client.animation.Easing;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Configuration class for amination settings.
 *  
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
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['callback'] = function() {
                            callback.@com.gwtext.client.core.Function::execute()();
                        };
    }-*/;
}
