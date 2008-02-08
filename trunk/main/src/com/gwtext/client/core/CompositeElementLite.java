/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Flyweight composite class. Reuses the same Ext.Element for element operations.
 */
public class CompositeElementLite extends CompositeElement {

    public CompositeElementLite(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static CompositeElementLite instance(JavaScriptObject jsObj) {
        return new CompositeElementLite(jsObj);
    }

    /**
     * Returns a flyweight Element of the dom element object at the specified index.
     *
     * @param index the element index
     * @return the element at index
     */
    public native ExtElement item(int index) /*-{
        var cel = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = cel.item();
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;
}