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