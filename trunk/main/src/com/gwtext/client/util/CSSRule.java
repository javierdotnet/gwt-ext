/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
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
