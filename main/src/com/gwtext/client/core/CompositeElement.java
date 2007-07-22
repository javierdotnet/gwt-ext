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

public class CompositeElement extends BaseElement {

    public CompositeElement(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static CompositeElement instance(JavaScriptObject jsObj) {
        return new CompositeElement(jsObj);
    }

    public native CompositeElement add(String selector) /*-{
         var ce = this.@com.gwtext.client.core.JsObject::jsObj;
         ce.add(selector);
         return this;
     }-*/;
    
    public native CompositeElement add(ExtElement element) /*-{
         var ce = this.@com.gwtext.client.core.JsObject::jsObj;
         ce.add(element);
         return this;
     }-*/;

    public native void clear() /*-{
         var ce = this.@com.gwtext.client.core.JsObject::jsObj;
         ce.clear();
     }-*/;

    public native void contains(ExtElement element) /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var elJS = element.@com.gwtext.client.core.JsObject::jsObj;
        return ce.contains(elJS);
    }-*/;

    //todo each

    public native CompositeElement filter(String selector) /*-{
         var ce = this.@com.gwtext.client.core.JsObject::jsObj;
         ce.filter(selector);
         return this;
     }-*/;

    public native ExtElement first() /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = ce.first();
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public native int getCount() /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        return ce.getCount();
    }-*/;

    public native int indexOf(ExtElement element) /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var elJS = element.@com.gwtext.client.core.JsObject::jsObj;
        return ce.indexOf(elJS);
    }-*/;

    public native ExtElement last() /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = ce.last();
        return el == null ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public native CompositeElement removeElement(int index) /*-{
         var ce = this.@com.gwtext.client.core.JsObject::jsObj;
         ce.removeElement(index);
         return this;
     }-*/;

    public native CompositeElement removeElement(int index, boolean removeDom) /*-{
         var ce = this.@com.gwtext.client.core.JsObject::jsObj;
         ce.removeElement(index, removeDom);
         return this;
     }-*/;

    public native CompositeElement removeElement(ExtElement element) /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var elJS = element.@com.gwtext.client.core.JsObject::jsObj;
        ce.removeElement(elJS);
        return this;
     }-*/;

    public native CompositeElement removeElement(ExtElement element, boolean removeDom) /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var elJS = element.@com.gwtext.client.core.JsObject::jsObj;
        ce.removeElement(elJS, removeDom);
        return this;
     }-*/;


    public native CompositeElement replaceElement(int index, ExtElement replacement) /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var replacementJS = replacement.@com.gwtext.client.core.JsObject::jsObj;
        ce.replaceElement(index, replacementJS);
        return this;
     }-*/;

    public native CompositeElement replaceElement(int index, ExtElement replacement, boolean removeDom) /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var replacementJS = replacement.@com.gwtext.client.core.JsObject::jsObj;
        ce.replaceElement(index, replacementJS, removeDom);
        return this;
     }-*/;

    public native CompositeElement replaceElement(ExtElement element, ExtElement replacement) /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var elJS = element.@com.gwtext.client.core.JsObject::jsObj;
        var replacementJS = replacement.@com.gwtext.client.core.JsObject::jsObj;
        ce.replaceElement(elJS, replacementJS);
        return this;
     }-*/;

    public native CompositeElement replaceElement(ExtElement element, ExtElement replacement, boolean removeDom) /*-{
        var ce = this.@com.gwtext.client.core.JsObject::jsObj;
        var elJS = element.@com.gwtext.client.core.JsObject::jsObj;
        var replacementJS = replacement.@com.gwtext.client.core.JsObject::jsObj;
        ce.replaceElement(elJS, replacementJS, removeDom);
        return this;
     }-*/;
}
