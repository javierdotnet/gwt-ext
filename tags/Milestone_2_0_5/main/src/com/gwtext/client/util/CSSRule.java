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
import com.gwtext.client.core.JsObject;

/**
 * CSS Rule class.
 *
 * @author Sanjiv Jivan
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
        var rule = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return rule.cssText;
    }-*/;

    /**
     * Returns the parent rule.
     *
     * @return the parent rule
     */
    public native CSSRule getParentRule()/*-{
        var rule = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var parentRule = rule.parentRule;
        if(parentRule == null || parentRule === undefined) {
            return null;
        } else  {
            return @com.gwtext.client.util.CSSRule::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(parentRule);
        }
    }-*/;
}
