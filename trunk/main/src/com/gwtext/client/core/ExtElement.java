/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public class ExtElement extends BaseElement {

    protected ExtElement() {
    }

    /**
     * Create an ExtElement using an existing native element.
     *
     * @param jsObj native Element object
     */
    public ExtElement(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Create an ExtElement wrapper around en existing DOM Element.
     *
     * @param elem the DOM Element
     */
    public ExtElement(Element elem) {
        this(elem, false);
    }

    /**
     * Create an ExtElement wrapper around an existing DOM Element.
     *
     * @param elem     the DOM Element
     * @param forceNew by default the constructor checks to see if there is already an instance of this element in the cache and if there is it returns the same instance.
     *                 Passing <code>true</code> will skip that check (useful for extending this class)
     */
    public ExtElement(Element elem, boolean forceNew) {
        jsObj = create(elem, forceNew);
    }

    private native JavaScriptObject create(Element elem, boolean forceNew)/*-{
        return new $wnd.Ext.Element(elem, forceNew);
    }-*/;

    private static ExtElement instance(JavaScriptObject jsObj) {
        return new ExtElement(jsObj);
    }

    /**
     * Gets the globally shared flyweight Element, with the passed node as the active element. Do not store a reference to this element -
     * the dom node can be overwritten by other code.
     *
     * @param id the Element id
     * @return the shared ExtElement object
     */
    public static native ExtElement fly(String id)/*-{
        var elem = $wnd.Ext.fly(id);
        return elem == null || elem === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
    }-*/;

    /**
     * Gets the globally shared flyweight ExtElement, with the passed node as the active element. Do not store a reference to this element -
     * the dom node can be overwritten by other code.
     *
     * @param id    the Element id
     * @param named allows for creation of named reusable flyweights to prevent conflicts (e.g. internally Ext uses "_internal")
     * @return the shared ExtElement object
     */
    public static native ExtElement fly(String id, String named)/*-{
        var elem = $wnd.Ext.fly(id, named);
        return elem == null || elem === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
    }-*/;

    /**
     * Static method to retrieve ExtElement objects. Uses simple caching to consistently return the same object. Automatically fixes
     * if an object was recreated with the same id via AJAX or DOM.
     *
     * @param id the id of Element
     * @return the ExtElement object
     */
    public static native ExtElement get(String id)/*-{
        var elem = $wnd.Ext.get(id);
        return elem == null || elem === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
    }-*/;

    //todo support CompositeElements
    /**
     * Appends the passed element to this element.
     *
     * @param child the child element
     * @return this
     */
    public native ExtElement appendChild(Element child) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.appendChild(child);
        return this;
    }-*/;

    /**
     * Appends this element to the passed element.
     *
     * @param el the new parent element
     * @return this
     */
    public native ExtElement appendTo(Element el) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.appendTo(el);
        return this;
    }-*/;

    /**
     * Tries to blur the element. Any exceptions are caught and ignored.
     *
     * @return this
     */
    public native ExtElement blur() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.blur();
        return this;
    }-*/;

    /**
     * Wraps the specified element with a special markup/CSS block that renders by default as a gray container with a gradient background,
     * rounded corners and a 4-way shadow.
     *
     * @return this
     */
    public native ExtElement boxWrap() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var wrap = elem.boxWrap();
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(wrap);
    }-*/;

    /**
     * Wraps the specified element with a special markup/CSS block that renders by default as a gray container with a gradient background,
     * rounded corners and a 4-way shadow.
     *
     * @param boxClass A base CSS class to apply to the containing wrapper element (defaults to 'x-box'). Note that there are a number of
     *                 CSS rules that are dependent on this name to make the overall effect work, so if you supply an alternate base class, make sure you also supply all of the necessary rules.
     * @return this
     */
    public native ExtElement boxWrap(String boxClass) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var wrap = elem.boxWrap(boxClass);
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(wrap);
    }-*/;

    /**
     * Centers the Element in the viewport.
     *
     * @return this
     */
    public native ExtElement center() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.center();
        return this;
    }-*/;

    /**
     * Centers the Element in another Element.
     *
     * @param centerIn the element in which to center the element.
     * @return this
     */
    public native ExtElement center(Element centerIn) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.center(centerIn);
        return this;
    }-*/;

    /**
     * Selects a single child at any depth below this element based on the passed CSS selector
     * (the selector should not contain an id).
     *
     * @param selector the CSS selector
     * @return child element
     */
    public native Element child(String selector) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var e = elem.child(selector, true);
		return e == null || e === undefined ? null : e;
	}-*/;

    /**
     * Clear positioning back to the default when the document was loaded.
     *
     * @return this
     */
    public native ExtElement clearPositioning() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.clearPositioning();
        return this;
    }-*/;

    /**
     * Clear positioning back to the default when the document was loaded
     *
     * @param value the position value
     * @return this
     */
    public native ExtElement clearPositioning(Position value) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var valueJS = value.@com.gwtext.client.core.Position::getPosition()();
        elem.clearPositioning(valueJS);
        return this;
    }-*/;

    /**
     * Whether this element is an ancestor of the passed element.
     *
     * @param el the element to check
     * @return true if this element is an ancestor of the passed element
     */
    public native boolean contains(Element el) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.contains(el);
    }-*/;

    /**
     * Creates the passed DomHelper config and appends it to this element
     *
     * @param config DomHelper element config object. If no tag is specified (e.g., {tag:'input'}) then a div will be automatically generated with the specified attributes.
     * @return the new child element
     */
    public native ExtElement createChild(DomConfig config) /*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var childJS = elem.createChild(configJS);
        var childJ = @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
        return childJ;
    }-*/;

    /**
     * Creates the passed DomHelper config and appends inserts it before the passed child element.
     *
     * @param config       DomHelper element config object. If no tag is specified (e.g., {tag:'input'}) then a div will be automatically generated with the specified attributes.
     * @param insertBefore a child element of this element
     * @return the new child element
     */
    public native ExtElement createChild(DomConfig config, Element insertBefore) /*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var childJS = elem.createChild(configJS, insertBefore);
        var childJ = @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(elem);
        return childJ;
    }-*/;

    //http://extjs.com/forum/showthread.php?t=568&highlight=createProxy
    /**
     * Creates a proxy element of this element.
     *
     * @param config DomHelper config object
     * @return the new proxy element
     */
    public native ExtElement createProxy(DomConfig config) /*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var proxy = elem.createProxy(configJS);
        var proxyJ = @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(proxy);
        return proxyJ;
    }-*/;

    /**
     * Creates a proxy element of this element.
     *
     * @param config   DomHelper config object
     * @param renderTo The element render the proxy to
     * @param matchBox true to align and size the proxy to this element now (defaults to false)
     * @return the new proxy element
     */
    public native ExtElement createProxy(DomConfig config, Element renderTo, boolean matchBox) /*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var proxy = elem.createProxy(configJS, renderTo, matchBox);
        var proxyJ = @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(proxy);
        return proxyJ;
    }-*/;

    /**
     * Creates a proxy element of this element.
     *
     * @param cls the class name of the proxy element
     * @return the new proxy element
     */
    public native ExtElement createProxy(String cls) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.createProxy(cls);
        return this;
    }-*/;

    /**
     * Creates a proxy element of this element.
     *
     * @param cls      the class name of the proxy element
     * @param renderTo The element render the proxy to
     * @param matchBox true to align and size the proxy to this element now (defaults to false)
     * @return the new proxy element
     */
    public native ExtElement createProxy(String cls, Element renderTo, boolean matchBox) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.createProxy(cls, renderTo, matchBox);
        return this;
    }-*/;

    /**
     * Selects a single *direct* child based on the passed CSS selector
     * (the selector should not contain an id).
     *
     * @param selector the CSS selector
     * @return the child element
     */
    public native Element down(String selector) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.down(selector, true);
    }-*/;

    /**
     * Looks at this node and then at parent nodes for a match of the passed simple selector
     * (e.g. div.some-class or span:first-child)
     *
     * @param selector the simple selector to test
     * @return the matching element of null if no node found
     */
    public native Element findParent(String selector) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.findParent(selector);
    }-*/;

    /**
     * Looks at this node and then at parent nodes for a match of the passed simple selector
     * (e.g. div.some-class or span:first-child)
     *
     * @param selector  the simple selector to test
     * @param container search until container element is reached
     * @return the matching element of null if no node found
     */
    public native Element findParent(String selector, Element container) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.findParent(selector, container);
    }-*/;

    /**
     * Looks at this node and then at parent nodes for a match of the passed simple selector
     * (e.g. div.some-class or span:first-child)
     *
     * @param selector the simple selector to test
     * @param maxDepth the max depth to search as a number (defaults to 10)
     * @return the matching element of null if no node found
     */
    public native Element findParent(String selector, int maxDepth) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.findParent(selector, maxDepth);
    }-*/;

    /**
     * Looks at parent nodes for a match of the passed simple selector
     * (e.g. div.some-class or span:first-child)
     *
     * @param selector  the simple selector to test
     * @param container search until container element is reached
     * @return the matching element of null if no node found
     */
    public native Element findParentNode(String selector, Element container) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.findParentNode(selector, container);
    }-*/;

    /**
     * Looks at parent nodes for a match of the passed simple selector
     * (e.g. div.some-class or span:first-child)
     *
     * @param selector the simple selector to test
     * @param maxDepth the max depth to search as a number (defaults to 10)
     * @return the matching element of null if no node found
     */
    public native Element findParentNode(String selector, int maxDepth) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.findParentNode(selector, maxDepth);
    }-*/;

    /**
     * Tries to focus the element. Any exceptions are caught and ignored.
     *
     * @return this
     */
    public native ExtElement focus() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.focus();
        return this;
    }-*/;

    /**
     * Gets the x,y coordinates to align this element with another element.
     *
     * @param element        The element to align to
     * @param anchorPosition the element's anchor point
     * @return an array containing the element's x and y coordinates
     */
    public native int[] getAlignToXY(Element element, String anchorPosition) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var arrJS = elem.getAlignToXY(element, anchorPosition);
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Gets the x,y coordinates to align this element with another element.
     *
     * @param element        The element to align to.
     * @param anchorPosition the element's anchor point
     * @param offesets       offset the positioning by [x, y]
     * @return an array containing the element's x and y coordinates
     */
    public native int[] getAlignToXY(Element element, String anchorPosition, int[] offesets) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var offsetsJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offesets);
        var arrJS = elem.getAlignToXY(element, anchorPosition, offsetsJS);
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Gets the x,y coordinates specified by the anchor position on the element.
     *
     * @return an array containing the element's x and y coordinates
     */
    public native int[] getAnchorXY() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var arrJS = elem.getAnchorXY();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Gets the x,y coordinates specified by the anchor position on the element.
     *
     * @param anchorPosition the specified anchor position.
     * @param local          true to get the local (element top/left-relative) anchor position instead of page coordinates
     * @param width          width to use for calculating anchor position
     * @param height         height to use for calculating anchor position
     * @return an array containing the element's x and y coordinates
     */
    public native int[] getAnchorXY(String anchorPosition, boolean local, int width, int height) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var arrJS = elem.getAnchorXY(anchorPosition, local, {width: width, height : height});
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Returns the value of a namespaced attribute from the element's underlying DOM node.
     *
     * @param namespace the namespace in which to look for the attribute
     * @param name      the attribute name
     * @return the attribute value
     */
    public native String getAttributeNS(String namespace, String name)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getAttributeNS(namespace, name);
    }-*/;

    /**
     * Gets the width of the border for the specified side.
     *
     * @param side the side
     * @return width of the side
     */
    public native int getBorderWidth(Side side)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var sideJS = side.@com.gwtext.client.core.Side::getSide()();
        return elem.getBorderWidth(sideJS);
    }-*/;

    /**
     * Gets the bottom Y coordinate of the element (element Y position + element height)
     *
     * @param local true to get the local css position instead of page coordinate
     * @return the bottom Y coordinate
     */
    public native int getBottom(boolean local)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getBottom(local);
    }-*/;

    /**
     * Return a Box that can be used to set another elements size/location to match this element.
     *
     * @return the box object
     */
    public native Box getBox()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var boxJS = elem.getBox();
        return @com.gwtext.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    /**
     * Return a Box that can be used to set another elements size/location to match this element.
     *
     * @param contentBox if true a box for the content of the element is returned.
     * @param local      if true the element's left and top are returned instead of page x/y
     * @return the box object
     */
    public native Box getBox(boolean contentBox, boolean local)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var boxJS = elem.getBox(contentBox, local);
        return @com.gwtext.client.core.Box::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(boxJS);
    }-*/;

    /**
     * Calculates the x, y to center this element on the screen
     *
     * @return the x, y values [
     */
    public native int[] getCenterXY() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var arrJS = elem.getCenterXY();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Return the CSS color for the specified CSS attribute. rgb, 3 digit (like #fff) and valid values are convert
     * to standard 6 digit hex color.
     *
     * @param attr         the css attribute
     * @param defaultValue the default value to use when a valid color isn't found
     * @return the css color
     */
    public native String getColor(String attr, String defaultValue)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getColor(attr, defaultValue);
    }-*/;

    /**
     * Return the CSS color for the specified CSS attribute. rgb, 3 digit (like #fff) and valid values are convert
     * to standard 6 digit hex color.
     *
     * @param attr         the css attribute
     * @param defaultValue the default value to use when a valid color isn't found
     * @param prefix       defaults to #. Use an empty string when working with YUI color anims.
     * @return the css color
     */
    public native String getColor(String attr, String defaultValue, String prefix)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getColor(attr, defaultValue, prefix);
    }-*/;

    /**
     * Returns either the offsetHeight or the height of this element based on CSS height adjusted by padding or borders
     * when needed to simulate offsetHeight when offsets aren't available. This may not work on display:none elements if
     * a height has not been set using CSS.
     *
     * @return the computed height
     */
    public native int getComputedHeight()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getComputedHeight();
    }-*/;

    /**
     * Returns either the offsetWidth or the width of this element based on CSS width adjusted by padding or borders when
     * needed to simulate offsetWidth when offsets aren't available. This may not work on display:none elements if a width
     * has not been set using CSS.
     *
     * @return the computed width
     */
    public native int getComputedWidth()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getComputedWidth();
    }-*/;

    /**
     * Retursn the underlying DOM Element.
     *
     * @return the DOM element
     */
    public native Element getDOM()/*-{
        var element = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var dom = element.dom;
		return dom === undefined ? null : dom;
	}-*/;

    /**
     * Returns the sum width of the padding and borders for the passed side.
     *
     * @param side the side
     * @return sum of padding and border for the side
     */
    public native int getFrameWidth(Side side)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var sideJS = side.@com.gwtext.client.core.Side::getSide()();
        return elem.getFrameWidth(sideJS);
    }-*/;

    /**
     * Returns the offset height of the element.
     *
     * @return the element's height
     */
    public native int getHeight()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getHeight();
    }-*/;

    /**
     * Returns the offset height of the element.
     *
     * @param contentHeight true to get the height minus borders and padding
     * @return the element's height
     */
    public native int getHeight(boolean contentHeight)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getHeight(contentHeight);
    }-*/;

    /**
     * Gets the left X coordinate
     *
     * @return the left coordinate.
     */
    public native int getLeft()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getLeft();
    }-*/;

    /**
     * Gets the left X coordinate.
     *
     * @param local true to get the local css position instead of page coordinate
     * @return the X cooridinate
     */
    public native int getLeft(boolean local)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getLeft(local);
    }-*/;

    /**
     * Returns the margins of this element.
     *
     * @return the margin
     */
    public native Margins getMargins()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var marginsJS = elem.getMargins();
        return @com.gwtext.client.core.Margins::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(marginsJS);
    }-*/;

    /**
     * Gets the next sibling, skipping text nodes.
     *
     * @return the next sibling or null
     */
    public native Element next()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.next(null, true);
    }-*/;

    /**
     * Gets the next sibling, skipping text nodes.
     *
     * @param selector Find the next sibling that matches the passed simple selector
     * @return the next sibling or null
     */
    public native Element next(String selector)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.next(selector, true);
    }-*/;

    /**
     * Gets the width of the padding for the specified side.
     *
     * @param side the side
     * @return padding
     */
    public native int getPadding(Side side)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var sideJS = side.@com.gwtext.client.core.Side::getSide()();
        return elem.getPadding(sideJS);
    }-*/;

    /**
     * Gets a {@link PositioningConfig} object with all CSS positioning properties. Useful along with setPostioning to get snapshot before
     * performing an update and then restoring the element.
     *
     * @return positioning config object
     */
    public native PositioningConfig getPositioning()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var posJS = elem.getPositioning();
        return @com.gwtext.client.core.PositioningConfig::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(posJS);
    }-*/;

    /**
     * Set positioning with an object returned by getPositioning().
     *
     * @param posCfg the position config
     * @return this
     */
    public native BaseElement setPositioning(PositioningConfig posCfg)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var posCfgJS = posCfg.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.setPositioning(posCfgJS);
        return this;
    }-*/;

    /**
     * Gets the previous sibling, skipping text nodes.
     *
     * @return the previous sibling or null
     */
    public native Element prev()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.prev(null, true);
    }-*/;

    /**
     * Gets the previous sibling, skipping text nodes.
     *
     * @param selector Find the previous sibling that matches the passed simple selector
     * @return the previous sibling or null
     */
    public native Element prev(String selector)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.prev(selector, true);
    }-*/;
    /**
     * Returns the region of the given element. The element must be part of the DOM tree to have a region
     * (display:none or elements not appended return false).
     *
     * @return region of the element
     */
    public native Region getRegion()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var regionJS = elem.getRegion();
        return @com.gwtext.client.core.Region::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(regionJS);
    }-*/;

    //todo test
    /**
     * Returns the current scroll position of the element.
     *
     * @return array of left and top scroll position
     */
    public native int[] getScroll()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var scroll = elem.getScroll();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)([scroll.left, scroll.top]);
    }-*/;

    /**
     * Returns the size of the element..
     *
     * @return element size
     */
    public native Size getSize()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var sizeJS = elem.getSize();
        return @com.gwtext.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sizeJS);
    }-*/;

    /**
     * Normalizes currentStyle and computedStyle.
     *
     * @param property the style property whose value is returned
     * @return the current value of the style property for this element
     */
    public native String getStyle(String property)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getStyle(property);
    }-*/;

    /**
     * Returns the top Y coordinate.
     *
     * @return the Y coordinate
     */
    public native int getTop()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getTop();
    }-*/;

    /**
     * Returns the top Y coordinate.
     *
     * @param local true to get the local css position instead of page coordinate
     * @return the top Y coordinate
     */
    public native int getTop(boolean local)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getTop(local);
    }-*/;

    /**
     * Gets this element's {@link UpdateManager}.
     *
     * @return the UpdateManager
     */
    public native UpdateManager getUpdateManager()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var umJS = elem.getUpdateManager();
        return @com.gwtext.client.core.UpdateManager::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(umJS);
    }-*/;

    /**
     * Returns the value of the "value" attribute
     *
     * @return the value
     */
    public native String getValue()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getValue();
    }-*/;

    /**
     * Returns the value of the "value" attribute as a number.
     *
     * @return tried to parse the value as number
     */
    public native float getValueAsNumber()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getValue();
    }-*/;

    /**
     * Returns the width and height of the viewport.
     *
     * @return the viewport's Size
     */
    public native Size getViewSize()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var sizeJS = elem.getViewSize();
        return @com.gwtext.client.core.Size::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(sizeJS);
    }-*/;

    /**
     * Returns the offset width of the element.
     *
     * @return the elements width
     */
    public native int getWidth()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getWidth();
    }-*/;

    /**
     * Returns the offset width of the element.
     *
     * @param contentWidth true to get the width minus borders and padding
     * @return the elemetns width
     */
    public native int getWidth(boolean contentWidth)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getWidth(contentWidth);
    }-*/;

    /**
     * Gets the current X position of the element based on page coordinates. Element must be part of the DOM tree to have page coordinates
     * (display:none or elements not appended return false).
     *
     * @return the X position of the element
     */
    public native int getX()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getX();
    }-*/;

    /**
     * Gets the current position of the element based on page coordinates. Element must be part of the DOM tree to have page coordinates
     * (display:none or elements not appended return false).
     *
     * @return the XY position of the element
     */
    public native int[] getXY() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var arrJS = elem.getXY();
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)(arrJS);
    }-*/;

    /**
     * Gets the current Y position of the element based on page coordinates. Element must be part of the DOM tree to have page coordinates
     * (display:none or elements not appended return false).
     *
     * @return the Y position of the element
     */
    public native int getY()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.getY();
    }-*/;

    /**
     * Checks if the specified CSS class exists on this element's DOM node.
     *
     * @param className the CSS class to check for
     * @return true if the class exists, else false
     */
    public native boolean hasClass(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.hasClass(className);
    }-*/;

    //todo initDD, initDDProxy, initDDTarget
    /**
     * Inserts this element after the passed element in the DOM.
     *
     * @param el the element to insert after
     * @return this
     */
    public native ExtElement insertAfter(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.insertAfter(el);
        return this;
    }-*/;

    /**
     * Inserts this element before the passed element in the DOM.
     *
     * @param el the element to insert before
     * @return this
     */
    public native ExtElement insertBefore(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.insertBefore(el);
        return this;
    }-*/;

    /**
     * Inserts an element as the first child of the this element.
     *
     * @param el the element to insert
     * @return this
     */
    public native ExtElement insertFirst(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.insertFirst(el);
        return this;
    }-*/;

    /**
     * Creates an element as the first child of the this element.
     *
     * @param config DomHelper config to create element
     * @return the new child                                                             i
     */
    public native ExtElement insertFirst(DomConfig config)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var el = elem.insertFirst(configJS);
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Inserts an html fragment into this element.
     *
     * @param html the html fragment
     * @return the inserted node (or nearest related if more than 1 inserted)
     */
    public native Element insertHtmlBeforeBegin(String html)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.insertHtml('beforeBegin', html, true);
    }-*/;

    /**
     * Inserts an html fragment into this element.
     *
     * @param html the html fragment
     * @return the inserted node (or nearest related if more than 1 inserted)
     */
    public native Element insertHtmlAfterBegin(String html)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.insertHtml('afterBegin', html, true);
    }-*/;

    /**
     * Inserts an html fragment into this element.
     *
     * @param html the html fragment
     * @return the inserted node (or nearest related if more than 1 inserted)
     */
    public native Element insertHtmlBeforeEnd(String html)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.insertHtml('beforeEnd', html, true);
    }-*/;

    /**
     * Inserts an html fragment into this element.
     *
     * @param html the html fragment
     * @return the inserted node (or nearest related if more than 1 inserted)
     */
    public native Element insertHtmlAfterEnd(String html)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.insertHtml('afterEnd', html, true);
    }-*/;

    /**
     * Inserts the passed element as a sibling of this element.
     *
     * @param el the element to insert
     * @return the inserted element
     */
    public native Element insertSibling(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.insertSibling(el, 'before', true);
    }-*/;

    /**
     * Inserts the passed element as a sibling of this element.
     *
     * @param el     the element to insert
     * @param before insert before or after
     * @return the inserted element
     */
    public native ExtElement insertSibling(Element el, boolean before)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var where = before ? 'before':'after';
        return elem.insertSibling(el, where, true);
    }-*/;

    /**
     * Created the passed DomHelper config as a sibling of this element.
     *
     * @param config the DomHelper config
     * @return the inserted element
     */
    public native Element insertSibling(DomConfig config)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return elem.insertSibling(configJS, 'before', true);
    }-*/;

    /**
     * Created the passed DomHelper config as a sibling of this element.
     *
     * @param config the DomHelper config
     * @param before to insert before or after
     * @return the inserted element
     */
    public native ExtElement insertSibling(DomConfig config, boolean before)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var where = before ? 'before':'after';
        elem.insertSibling(configJS, where);
        return this;
    }-*/;

    /**
     * Returns true if this element matches the passed simple selector (e.g. div.some-class or span:first-child)
     *
     * @param selector the simple selector to test
     * @return true if this element matches the selector, else false
     */
    public native boolean is(String selector)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.is(selector);
    }-*/;

    /**
     * Tests various css rules/browsers to determine if this element uses a border box
     *
     * @return true is element uses border box
     */
    public native boolean isBorderBox()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.isBorderBox();
    }-*/;

    /**
     * Returns true if display is not "none".
     *
     * @return true if display is not "none"
     */
    public native boolean isDisplayed()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.isDisplayed();
    }-*/;

    /**
     * Returns true if this element is masked.
     *
     * @return true if this element is masked
     */
    public native boolean isMasked()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.isMasked();
    }-*/;

    /**
     * Returns true if this element is scrollable.
     *
     * @return true if this element is scrollable
     */
    public native boolean isScrollable()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.isScrollable();
    }-*/;

    /**
     * Checks whether the element is currently visible using both visibility and display properties.
     *
     * @return true if visible
     */
    public native boolean isVisible()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.isVisible();
    }-*/;

    /**
     * Checks whether the element is currently visible using both visibility and display properties.
     *
     * @param deep true to walk the dom and see if parent elements are hidden (defaults to false)
     * @return true if visible
     */
    public native boolean isVisible(boolean deep)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.isVisible(deep);
    }-*/;

    /**
     * Puts a mask over this element to disable user interaction. This method can only be applied to elements which accept child nodes.
     *
     * @return the mask element
     */
    public native ExtElement mask()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var me = elem.mask();
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(me);
    }-*/;

    /**
     * Puts a mask over this element to disable user interaction. This method can only be applied to elements which accept child nodes.
     * By default an animated loading icon is added.
     *
     * @param msg a message to display in the mask
     * @return the mask element
     */
    public ExtElement mask(String msg) {
        //by default add animated icon
        return mask(msg, "x-mask-loading");
    }

    /**
     * Puts a mask over this element to disable user interaction. This method can only be applied to elements which accept child nodes.
     * By default an animated loading icon is added.
     *
     * @param msg a message to display in the mask
     * @param animatedIcon true to add animated loading icon, false to skip
     * @return the mask element
     */
    public ExtElement mask(String msg, boolean animatedIcon) {
        if(animatedIcon) {
            return mask(msg, "x-mask-loading");
        } else {
            return mask(msg, null);
        }
    }


    /**
     * Puts a mask over this element to disable user interaction. This method can only be applied to elements which accept child nodes.
     *
     * @param msg      a message to display in the mask
     * @param msgClass a css class to apply to the msg element
     * @return the mask element
     */
    public native ExtElement mask(String msg, String msgClass) /*-{
        var el = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var me = el.mask(msg, msgClass);
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(me);
    }-*/;

    /**
     * Initializes positioning on this element. The element will be positioned relative IF it is not already positioned
     */
    public native void position()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.position();
    }-*/;

    /**
     * Initializes positioning on this element.
     *
     * @param pos    positioning to use
     * @param zIndex the zIndex to apply
     * @param x      set the page X position
     * @param y      set the page Y position
     */
    public native void position(Positioning pos, int zIndex, int x, int y)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var posJS = pos.@com.gwtext.client.core.Positioning::getPositioning()();
        elem.position(posJS, zIndex, x, y);
    }-*/;

    /**
     * Selects child nodes based on the passed CSS selector (the selector should not contain an id).
     *
     * @param selector the CSS selector
     * @return an array of the matched nodes
     */
    public native Element[] query(String selector)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var elemsJS = elem.query(selector);
        return elemsJS == null || elemsJS === undefined ? null : @com.gwtext.client.util.JavaScriptObjectHelper::toElementArray(Lcom/google/gwt/core/client/JavaScriptObject;)(elemsJS);
    }-*/;

    //todo removeListener
    /**
     * Replaces the passed element with this element.
     *
     * @param el the element to replace
     * @return this
     */
    public native ExtElement replace(Element el)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.replace(el);
        return this;
    }-*/;

    /**
     * Scrolls this element into view within the passed container.
     *
     * @return this
     */
    public native ExtElement scrollIntoView()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.scrollIntoView();
        return this;
    }-*/;

    /**
     * Scrolls this element into view within the passed container
     *
     * @param container the container element to scroll (defaults to document.body)
     * @param hscroll   false to disable horizontal scroll (defaults to true)
     * @return this
     */
    public native ExtElement scrollIntoView(Element container, boolean hscroll)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.scrollIntoView(container, hscroll);
        return this;
    }-*/;

    /**
     * Creates a CompositeElement for child nodes based on the passed CSS selector (the selector should not contain an id).
     *
     * @param selector the CSS selector
     * @return the CompositeElement
     */
    public native CompositeElement select(String selector)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var ceJS = elem.select(selector);
        return ceJS == null || ceJS === undefined ? null : @com.gwtext.client.core.CompositeElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
    }-*/;

    /**
     * Creates a CompositeElement for child nodes based on the passed CSS selector (the selector should not contain an id).
     *
     * @param selector the CSS selector
     * @param unique   true to create a unique ExtElement for each child (defaults to false, which creates a single shared flyweight object)
     * @return the CompositeElement
     */
    public native CompositeElement select(String selector, boolean unique)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var ceJS = elem.select(selector, unique);
        if(unique) {
            return ceJS == null || ceJS === undefined ? null : @com.gwtext.client.core.CompositeElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
        } else {
            return ceJS == null || ceJS === undefined ? null : @com.gwtext.client.core.CompositeElementLite::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ceJS);
        }
    }-*/;

    //todo test
    /**
     * Translates the passed page coordinates into left/top css values for this element
     *
     * @param x the page x
     * @param y the page y
     * @return array of left, top values
     */
    public native int[] translatePoints(int x, int y)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var leftTopJS = elem.translatePoints(x, y);
        return @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaIntArray(Lcom/google/gwt/core/client/JavaScriptObject;)([leftTopJS.left, leftTopJS.top]);
    }-*/;

    /**
     * Return clipping (overflow) to original clipping before clip() was called.
     *
     * @return this
     */
    public native ExtElement unclip() /*-{
        var el = this.@com.gwtext.client.core.JsObject::getJsObj()();
        el.unclip();
        return this;
    }-*/;

    /**
     * Removes a previously applied mask. If removeEl is true the mask overlay is destroyed, otherwise it is cached for reuse.
     */
    public native void unmask() /*-{
        var el = this.@com.gwtext.client.core.JsObject::getJsObj()();
        el.unmask();
    }-*/;

    /**
     * Update the innerHTML of this element, optionally searching for and processing scripts.
     *
     * @param html        the new HTML
     * @param loadScripts true to look for and process scripts
     * @param callback    for async script loading you can be notified when the update completes
     */
    public native void update(String html, boolean loadScripts, Function callback) /*-{
        var el = this.@com.gwtext.client.core.JsObject::getJsObj()();
        el.update(html, loadScripts, callback  == null ? null : function() {
            callback.@com.gwtext.client.core.Function::execute()();
        });
    }-*/;

    /**
     * Walks up the dom looking for a parent node that matches the passed simple selector (e.g. div.some-class or span:first-child).
     * The max depth to search defaults to 10 or document.body. This is a shortcut for findParentNode() that always returns an ExtElement
     *
     * @param selector  the simple selector to test
     * @return the matching DOM or null if no match was found
     */
    public native ExtElement up(String selector) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var el = elem.up(selector);
        return el == null || el === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Walks up the dom looking for a parent node that matches the passed simple selector (e.g. div.some-class or span:first-child). This is a shortcut for findParentNode() that always returns an ExtElement
     *
     * @param selector  the simple selector to test
     * @param container the container to stop at
     * @return the matching DOM or null if no match was found
     */
    public native ExtElement up(String selector, Element container) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var el = elem.up(selector, container);
        return el == null || el === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Walks up the dom looking for a parent node that matches the passed simple selector (e.g. div.some-class or span:first-child). This is a shortcut for findParentNode() that always returns an ExtElement
     *
     * @param selector the simple selector to test
     * @param maxDepth The max depth to search (defaults to 10 || document.body)
     * @return the matching DOM or null if no match was found
     */
    public native ExtElement up(String selector, int maxDepth) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var el = elem.up(selector, maxDepth);
        return el == null || el === undefined ? null : @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Return the first child of this element.
     *
     * @return the first child
     */
    public native Element getFirstChild() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.dom.firstChild;
    }-*/;

    /**
     * Return the parent node of this element,
     *
     * @return the parent node
     */
    public native Element getParentNode() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.dom.parentNode;
    }-*/;

	/**
	 * Remove the specified child.
	 *
	 * @param child the child
	 */
	public native void removeChild(Element child) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.dom.removeChild(child);
    }-*/;

	/**
     * Return the client width of the element.
     *
     * @return the client width
     */
    public native int getClientWidth() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return elem.dom.clientWidth;
    }-*/;

	/**
	 * Set the scroll top position.
	 *
	 * @param scrollTop the scroll top position
	 */
	public native void setScrollTop(int scrollTop) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::getJsObj()();
        elem.dom.scrolltop = scrollTop;
    }-*/;
}

