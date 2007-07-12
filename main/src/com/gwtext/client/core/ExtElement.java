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
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;

public class ExtElement extends JsObject {

    public ExtElement(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ExtElement(Element elem) {
        jsObj = create(elem);
    }

    private static ExtElement instance(JavaScriptObject jsObj) {
        return new ExtElement(jsObj);
    }

    public static native ExtElement fly(String id)/*-{
        var elem = $wnd.Ext.fly(id);
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
    }-*/;

    public static native ExtElement fly(String id, String named)/*-{
        var elem = $wnd.Ext.fly(id, named);
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
    }-*/;

    public static native ExtElement get(String id)/*-{
        var elem = $wnd.Ext.get(id);
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
    }-*/;

    public native ExtElement addClass(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClass(className);
        return this;
    }-*/;

    public native ExtElement addClassOnClick(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClassOnClick(className);
        return this;
    }-*/;

    public native ExtElement addClassOnFocus(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClassOnFocus(className);
        return this;
    }-*/;

    //todo
    //addKeyListener
    //addKeyMap

    public native ExtElement alignTo(String id, String position)/*-{        
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.alignTo(id, position);
        return this;
    }-*/;

    public native ExtElement alignTo(String id, String position, int[] offsetXY, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.alignTo(id, position, offsetXY, animate);
        return this;
    }-*/;


    public native ExtElement anchorTo(String id, String position)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.anchorTo(id, position);
        return this;
    }-*/;


    public native ExtElement anchorTo(String id, String position, int[] offsetXY, boolean animate, int bufferDelay)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.anchorTo(id, position, offsetXY, animate, bufferDelay);
        return this;
    }-*/;

    //todo
    //animate

    public ExtElement appendChild(ExtElement elem) {
        appendChild(jsObj, elem.getJsObj());
        return this;
    }

    private native void appendChild(JavaScriptObject elem, JavaScriptObject child) /*-{
        elem.appendChild(child);
    }-*/;

    public native JavaScriptObject create(Element elem)/*-{
        return new $wnd.Ext.Element(elem);
    }-*/;

    public native void toggleClass(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
    }-*/;

    public native Element getDOM()/*-{
        var element = this.@com.gwtext.client.core.JsObject::jsObj;
        return element.dom;
    }-*/;


    public native void mask(String msg) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.mask(msg);
    }-*/;

    public native void mask(String msg, String msgClass) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.mask(msg, msgClass);
    }-*/;


    public native void unmask() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.unmask();
    }-*/;

    public native void update(String html, boolean loadScripts) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.update(html, loadScripts);
    }-*/;
}
