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
package com.gwtext.client.util;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.core.Function;

public class KeyMapConfig extends BaseConfig {

    public KeyMapConfig(int keyCode) {
        JavaScriptObjectHelper.setAttribute(jsObj, "key", keyCode);
    }

    public KeyMapConfig(int[] keyCodes) {
        JavaScriptObjectHelper.setAttribute(jsObj, "key", JavaScriptObjectHelper.convertToJavaScriptArray(keyCodes));
    }

    public KeyMapConfig(String keys) {
        JavaScriptObjectHelper.setAttribute(jsObj, "key", keys);
    }

    public void setCtrl(boolean ctrl) {
        JavaScriptObjectHelper.setAttribute(jsObj, "ctrl", ctrl);
    }

    public void setAlt(boolean alt) {
        JavaScriptObjectHelper.setAttribute(jsObj, "alt", alt);
    }

    public void setShift(boolean shift) {
        JavaScriptObjectHelper.setAttribute(jsObj, "shift", shift);
    }

    public native void setCallback(Function cb) /*-{
        var config = this.@com.gwtext.client.core.JsObject::jsObj;
        config['fn'] = function() {
            cb.@com.gwtext.client.core.Function::execute()();
        };
    }-*/;

}
