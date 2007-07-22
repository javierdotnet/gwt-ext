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
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.util.KeyMap;
import com.gwtext.client.util.KeyMapConfig;

public class ExtElement extends JsObject {

	protected ExtElement() {
	}
	
    public ExtElement(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ExtElement(Element elem) {
        this(elem, false);
    }

    public ExtElement(Element elem, boolean forceNew) {
        jsObj = create(elem, forceNew);
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

    public ExtElement addClass(String[] classNames){
        return doAddClass(JavaScriptObjectHelper.convertToJavaScriptArray(classNames));
    }
    
    private  native ExtElement doAddClass(JavaScriptObject classNames)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClass(classNames);
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

    public native ExtElement addClassOnOver(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClassOnOver(className);
        return this;
    }-*/;

    public native ExtElement addClassOnOver(String className, boolean preventFlicker)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClassOnOver(className, preventFlicker);
        return this;
    }-*/;

    public native KeyMap addKeyListener(int keyCode, Function cb)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var km = elem.addKeyListener(keyCode, function() {
              cb.@com.gwtext.client.core.Function::execute()();
            });
        return @com.gwtext.client.util.KeyMap::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(km);
    }-*/;
    
    public native KeyMap addKeyListener(int[] keyCodes, Function cb)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var keyCodesJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(keyCodes);
        var km = elem.addKeyListener(keyCodesJS, function() {
              cb.@com.gwtext.client.core.Function::execute()();
            });
        return @com.gwtext.client.util.KeyMap::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(km);
    }-*/;
    
    public native KeyMap addKeyListener(String keys, Function cb)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var km = elem.addKeyListener(keys, function() {
              cb.@com.gwtext.client.core.Function::execute()();
            });
        return @com.gwtext.client.util.KeyMap::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(km);
    }-*/;

    public native KeyMap addKeyMap(KeyMapConfig config)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        var km = elem.addKeyMap(configJS);
        return @com.gwtext.client.util.KeyMap::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(km);
    }-*/;

    public native void addListener(String eventName, Function cb) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.addListener(eventName, function() {
                cb.@com.gwtext.client.core.Function::execute()();
            }
        );
    }-*/;
    
    public native ExtElement alignTo(String id, String position)/*-{        
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.alignTo(id, position);
        return this;
    }-*/;

    public native ExtElement alignTo(String id, String position, int[] offsetXY, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        elem.alignTo(id, position, offsetJS, animate);
        return this;
    }-*/;

    public native ExtElement anchorTo(String id, String position)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.anchorTo(id, position);
        return this;
    }-*/;

    public native ExtElement anchorTo(String id, String position, int[] offsetXY, boolean animate, int bufferDelay)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        elem.anchorTo(id, position, offsetJS, animate, bufferDelay);
        return this;
    }-*/;

    public native ExtElement animate(GenericConfig args)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var argsJS = args == null ? null : args.@com.gwtext.client.core.JsObject::jsObj;
        elem.animate(argsJS);
        return this;
    }-*/;

    public native ExtElement animate(GenericConfig args, float duration, Function onComplete, String easing, String animType)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var argsJS = args == null ? null : args.@com.gwtext.client.core.JsObject::jsObj;
        elem.animate(argsJS, duration, function() {
            onComplete.@com.gwtext.client.core.Function::execute()();
        }, easing, animType);
        return this;
    }-*/;

    //todo support CompositeElements
    public native ExtElement appendChild(Element child) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.appendChild(child);
        return this;
    }-*/;

    public native ExtElement appendTo(Element el) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.appendTo(el);
        return this;
    }-*/;

    public native ExtElement applyStyles(String style) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.applyStyles(style);
        return this;
    }-*/;

    public native ExtElement autoHeight() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.autoHeight();
        return this;
    }-*/;

    public native ExtElement autoHeight(boolean animate, float duration, Function onComplete, String easing)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.autoHeight(animate, duration, function() {
            onComplete.@com.gwtext.client.core.Function::execute()();
        }, easing);
        return this;
    }-*/;

    public native ExtElement beginMeasure() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.beginMeasure();
        return this;
    }-*/;
    
    public native ExtElement blur() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.blur();
        return this;
    }-*/;

    public native ExtElement boxWrap() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.boxWrap();
        return this;
    }-*/;

    public native ExtElement boxWrap(String boxClass) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.boxWrap(boxClass);
        return this;
    }-*/;

    public native ExtElement center() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.center();
        return this;
    }-*/;

    public native ExtElement center(Element centerIn) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.center(centerIn);
        return this;
    }-*/;

    public native Element child(String selector) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.child(selector, true);
    }-*/;

    public native void clean() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clean();
    }-*/;

    public native void clean(boolean forceClean) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clean(forceClean);
    }-*/;
    
    public native ExtElement clearOpacity() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clearOpacity();
        return this;
    }-*/;

    public native ExtElement clearPositioning() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clearPositioning();
        return this;
    }-*/;

    public native ExtElement clearPositioning(String value) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clearPositioning(value);
        return this;
    }-*/;

    public native ExtElement clip() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clip();
        return this;
    }-*/;
    
    public native boolean contains(Element el) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.contains(el);
    }-*/;

    //todo --> continue adding methods from here
    
    public native JavaScriptObject create(Element elem, boolean forceNew)/*-{
        return new $wnd.Ext.Element(elem, forceNew);
    }-*/;

    public native ExtElement toggleClass(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.toggleClass(className);
        return this;
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

    public native void update(String html, boolean loadScripts, Function callback) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.update(html, loadScripts, function() {
            callback.@com.gwtext.client.core.Function::execute()();
        });
    }-*/;
}
