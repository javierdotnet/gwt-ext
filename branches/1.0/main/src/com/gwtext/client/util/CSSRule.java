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

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;

/**
 * CSS Rule class.
 */
public class CSSRule extends JsObject {

    /**
     * Constructs a new rule using a native object.
     *
     * @param jsObj the native object
     */
    public CSSRule(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static CSSRule instance(JavaScriptObject jsObj) {
        return new CSSRule(jsObj);
    }

    /**
     * The CSS text.
     *
     * @return css text
     */
    public native String getCssText() /*-{
        var rule = this.@com.gwtext.client.core.JsObject::jsObj;
        return rule.cssText;
    }-*/;

    /**
     * Returns the parent rule.
     *
     * @return the parent rule
     */
    public native CSSRule getParentRule()/*-{
        var rule = this.@com.gwtext.client.core.JsObject::jsObj;
        var parentRule = rule.parentRule;
        if(parentRule == null || parentRule === undefined) {
            return null;
        } else  {
            return @com.gwtext.client.util.CSSRule::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parentRule);
        }
    }-*/;
}
