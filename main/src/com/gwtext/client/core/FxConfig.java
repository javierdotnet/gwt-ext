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

import com.gwtext.client.util.JavaScriptObjectHelper;

public class FxConfig extends GenericConfig {

    public FxConfig() {
    }

    public FxConfig(int duration) {
        JavaScriptObjectHelper.setAttribute(jsObj, "duration", duration);
    }

    public void setAfterCls(String afterCls) {
        JavaScriptObjectHelper.setAttribute(jsObj, "afterCls", afterCls);
    }

    public void setAfterStyle(String afterStyle) {
        JavaScriptObjectHelper.setAttribute(jsObj, "afterStyle", afterStyle);
    }

    public void setAfterStyle(GenericConfig afterStyle) {
        JavaScriptObjectHelper.setAttribute(jsObj, "afterStyle", afterStyle.getJsObj());
    }

    public native void setAfterStyle(Function fn) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['afterStyle'] = function() {
                            fn.@com.gwtext.client.core.Function::execute()();
                        };
    }-*/;

    public void setConcurrent(boolean concurrent) {
        JavaScriptObjectHelper.setAttribute(jsObj, "concurrent", concurrent);
    }

    public native void setCallback(Function callback) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['callback'] = function() {
                            callback.@com.gwtext.client.core.Function::execute()();
                        };
    }-*/;

    public void setEndOpacity(float endOpacity) {
        JavaScriptObjectHelper.setAttribute(jsObj, "endOpacity", endOpacity);
    }            
        
    public void setDuration(float duration) {
        JavaScriptObjectHelper.setAttribute(jsObj, "duration", duration);
    }

    public void setEasing(String easing) {
        JavaScriptObjectHelper.setAttribute(jsObj, "easing", easing);
    }

    public void setRemove(boolean remove) {
        JavaScriptObjectHelper.setAttribute(jsObj, "remove", remove);
    }

    //stopFx method present on Element. Dont see need to config property

    public void setUseDisplay(boolean useDisplay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "useDisplay", useDisplay);
    }
}
