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

public class ExtElement extends BaseElement {

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

    public native JavaScriptObject create(Element elem, boolean forceNew)/*-{
        return new $wnd.Ext.Element(elem, forceNew);
    }-*/;

    public static ExtElement instance(JavaScriptObject jsObj) {
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

    //todo may need to change to EventCallback instead of Funciton in future
    public native void addListener(String eventName, Function cb, ListenerConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.addListener(eventName, function() {
                cb.@com.gwtext.client.core.Function::execute()();
            },
            null,
            config.@com.gwtext.client.core.JsObject::jsObj
        );
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
        return elem.child(selector, true);
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

    public native boolean contains(Element el) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.contains(el);
    }-*/;

    public native ExtElement createChild(DomConfig config) /*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.createChild(configJS);
        return this;
    }-*/;

    public native ExtElement createChild(DomConfig config, Element insertBefore) /*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.createChild(configJS, insertBefore);
        return this;
    }-*/;

    //http://extjs.com/forum/showthread.php?t=568&highlight=createProxy
    public native ExtElement createProxy(DomConfig config) /*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.createProxy(configJS);
        return this;
    }-*/;

    public native ExtElement createProxy(DomConfig config, Element renderTo, boolean matchBox) /*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.createProxy(configJS, renderTo, matchBox);
        return this;
    }-*/;

    public native ExtElement createProxy(String cls) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.createProxy(cls);
        return this;
    }-*/;

    public native ExtElement createProxy(String cls, Element renderTo, boolean matchBox) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.createProxy(cls, renderTo, matchBox);
        return this;
    }-*/;


    public native ExtElement down(String selector) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.down(selector);
        return this;
    }-*/;

    public native ExtElement endMeasure() /*-{
            var elem = this.@com.gwtext.client.core.JsObject::jsObj;
            elem.endMeasure();
            return this;
    }-*/;

    public native Element findParent(String selector) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.findParent(selector);
    }-*/;

    public native Element findParent(String selector, Element container) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.findParent(selector, container);
    }-*/;

    public native Element findParent(String selector, int maxDepth) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.findParent(selector, maxDepth);
    }-*/;

    public native Element findParentNode(String selector, Element container) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.findParentNode(selector, container);
    }-*/;

    public native Element findParentNode(String selector, int maxDepth) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.findParentNode(selector, maxDepth);
    }-*/;

    public native ExtElement focus() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.focus();
        return this;
    }-*/;

    public native int[] getAlignToXY(Element element, String position) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var arrJS = elem.getAlignToXY(element, position);
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    public native int[] getAlignToXY(Element element, String position, int offesets) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var offsetsJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offesets);
        var arrJS = elem.getAlignToXY(element, position, offsetsJS);
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    public native int[] getAnchorXY() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var arrJS = elem.getAnchorXY();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    public native int[] getAnchorXY(String anchor, boolean local, int width, int height) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var arrJS = elem.getAnchorXY(anchor, local, {width: width, height : height});
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    public native String getAttributeNS(String namespace, String name)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getAttributeNS(namespace, name);
    }-*/;

    public native int getBorderWidth(String side)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getBorderWidth(side);
    }-*/;

    public native int getBottom(boolean local)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getBottom(local);
    }-*/;

    public native Box getBox()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var boxJS = elem.getBox();
        return @com.gwtext.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    public native Box getBox(boolean contentBox, boolean local)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var boxJS = elem.getBox(contentBox, local);
        return @com.gwtext.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    public native int[] getCenterXY() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var arrJS = elem.getCenterXY();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    public native String getColor(String attr, String defaultValue)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getColor(attr, defaultValue);
    }-*/;

    public native String getColor(String attr, String defaultValue, String prefix)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getColor(attr, defaultValue, prefix);
    }-*/;

    public native int getComputedHeight()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getComputedHeight();
    }-*/;

    public native int getComputedWidth()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getComputedWidth();
    }-*/;

    public native Element getDOM()/*-{
        var element = this.@com.gwtext.client.core.JsObject::jsObj;
        return element.dom;
    }-*/;

    public native int getFrameWidth(String sides)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getFrameWidth(sides);
    }-*/;

    public native int getHeight()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getHeight();
    }-*/;

    public native int getHeight(boolean contentHeight)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getHeight(contentHeight);
    }-*/;

    public native int getLeft()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getLeft();
    }-*/;

    public native int getLeft(boolean local)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getLeft(local);
    }-*/;

    public native Margins getMargins()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var marginsJS = elem.getMargins();
        return @com.gwtext.client.core.Margins::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(marginsJS);
    }-*/;


    public native Element getNextSibling()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getNextSibling();
    }-*/;

    public native int getPadding(String side)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getPadding(side);
    }-*/;

    public native PositioningConfig getPositioning()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var posJS = elem.getPositioning();
        return @com.gwtext.client.core.PositioningConfig::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(posJS);
    }-*/;

    public native Element getPrevSibling()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getPrevSibling();
    }-*/;

    public native Region getRegion()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var regionJS = elem.getRegion();
        return @com.gwtext.client.core.Region::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(regionJS);
    }-*/;

    //todo test
    public native int[] getScroll()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var scroll = elem.getScroll();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)([scroll.left, scroll.top]);
    }-*/;

    public native Size getSize()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var sizeJS = elem.getSize();
        return @com.gwtext.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sizeJS);
    }-*/;

    public native String getStyle(String property)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getStyle(property);
    }-*/;

    public native int getTop()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getTop();
    }-*/;

    public native int getTop(boolean local)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getTop(local);
    }-*/;

    public native ExtElement up(String selector, Element container) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = elem.up(selector, container);
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public native ExtElement up(String selector, int maxDepth) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = elem.up(selector, maxDepth);
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    public native UpdateManager getUpdateManager()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var umJS = elem.getUpdateManager();
        return @com.gwtext.client.core.UpdateManager::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(umJS);
    }-*/;

    public native String getValue()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getValue();
    }-*/;

    public native float getValueAsNumber()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getValue();
    }-*/;

    public native Size getViewSize()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var sizeJS = elem.getViewSize();
        return @com.gwtext.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sizeJS);
    }-*/;

    public native int getWidth()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getWidth();
    }-*/;

    public native int getWidth(boolean contentWidth)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getWidth(contentWidth);
    }-*/;

    public native int getX()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getX();
    }-*/;

    public native int[] getXY() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var arrJS = elem.getXY();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    public native int getY()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.getY();
    }-*/;

    public native boolean hasClass(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.hasClass(className);
    }-*/;

    //todo initDD, initDDProxy, initDDTarget

    public native ExtElement insertAfter(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.insertAfter(el);
        return this;
    }-*/;

    public native ExtElement insertBefore(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.insertBefore(el);
        return this;
    }-*/;

    public native ExtElement insertFirst(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.insertFirst(el);
        return this;
    }-*/;

    public native ExtElement insertFirst(DomConfig config)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        elem.insertFirst(configJS);
        return this;
    }-*/;

    public native ExtElement insertHtml(String where, String html)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.insertHtml(where, html);
        return this;
    }-*/;

    public native ExtElement insertSibling(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.insertSibling(el);
        return this;
    }-*/;

    public native ExtElement insertSibling(Element el, boolean before)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var where = before ? 'before':'after';
        elem.insertSibling(el, where);
        return this;
    }-*/;

    public native ExtElement insertSibling(DomConfig config)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        elem.insertSibling(configJS);
        return this;
    }-*/;

    public native ExtElement insertSibling(DomConfig config, boolean before)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var where = before ? 'before':'after';
        elem.insertSibling(configJS, where);
        return this;
    }-*/;

    public native boolean is(String selector)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.is(selector);
    }-*/;

    public native boolean isBorderBox()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.isBorderBox();
    }-*/;

    public native boolean isDisplayed()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.isDisplayed();
    }-*/;

    public native boolean isMasked()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.isMasked();
    }-*/;

    public native boolean isScrollable()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.isScrollable();
    }-*/;

    public native boolean isVisible()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.isVisible();
    }-*/;

    public native boolean isVisible(boolean deep)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        return elem.isVisible(deep);
    }-*/;

    //todo load

    public native ExtElement mask()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.mask();
        return this;
    }-*/;

    public native void mask(String msg) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.mask(msg);
    }-*/;

    public native void mask(String msg, String msgClass) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.mask(msg, msgClass);
    }-*/;


    public native void position()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.position();
    }-*/;

    public native void position(String pos, int zIndex, int x, int y)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.position(pos, zIndex, x, y);
    }-*/;

    public static native Element[] query(String selector)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var elemsJS = elem.query(selector);
        return @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(elemsJS);
    }-*/;

    //todo removeListener

    public native ExtElement replace(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.replace(el);
        return this;
    }-*/;

    public native ExtElement scrollIntoView()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.scrollIntoView();
        return this;
    }-*/;

    public native ExtElement scrollIntoView(Element container, boolean hscroll)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.scrollIntoView(container, hscroll);
        return this;
    }-*/;

    public native CompositeElement select(String selector)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var ceJS = elem.select(selector);
        return @com.gwtext.client.core.CompositeElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
    }-*/;

    public native CompositeElement select(String selector, boolean unique)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var ceJS = elem.select(selector, unique);
        if(unique) {
            return @com.gwtext.client.core.CompositeElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
        } else {
            return @com.gwtext.client.core.CompositeElementLite::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
        }
    }-*/;

    //todo test
    public native int[] translatePoints(int x, int y)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var leftTopJS = elem.translatePoints(x, y);
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)([leftTopJS.left, leftTopJS.top]);
    }-*/;

    public native void unclip() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.unclip();
    }-*/;

    public native void unmask() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.unmask();
    }-*/;

    public native void update(String html, boolean loadScripts, Function callback) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.update(html, loadScripts, callback  == null ? null : function() {
            callback.@com.gwtext.client.core.Function::execute()();
        });
    }-*/;
}

