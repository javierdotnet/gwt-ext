/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

import com.google.gwt.user.client.Element;

/**
 * Utility class for working with DOM and/or Templates. It transparently supports using HTML fragments or DOM.<br><br>
 * <p/>
 * This is an example, where an unordered list with 5 children items is appended to an existing element with id 'my-div':<br>
 * <p/>
 * <pre>
 * <code>
 * <p/>
 *   DomConfig config = new DomConfig("ul", null, "my-list");
 *   config.addChild(new DomConfig("li", "item0", null, "List Item 0"));
 *   config.addChild(new DomConfig("li", "item1", null, "List Item 1"));
 *   config.addChild(new DomConfig("li", "item2", null, "List Item 2"));
 *   config.addChild(new DomConfig("li", "item3", null, "List Item 3"));
 *   config.addChild(new DomConfig("li", "item4", null, "List Item 4"));
 * <p/>
 *   Element list = DomHelper.append("my-div", config);
 * </code>
 * </pre>
 */
public class DomHelper {

    /**
     * Creates new Dom element(s) and appends them to the parent element.
     *
     * @param parentId the parent element id
     * @param rawHtml  raw html blob
     * @return the new node
     */
    public static native Element append(String parentId, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.append(parentId, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and appends them to the parent element.
     *
     * @param parentId the parent element id
     * @param config   child dom config
     * @return the new node
     */
    public static native Element append(String parentId, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.append(parentId, configJS);
    }-*/;

    /**
     * Creates new Dom element(s) and appends them to the parent element.
     *
     * @param parent  the parent element
     * @param rawHtml raw html blob
     * @return the new node
     */
    public static native Element append(Element parent, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.append(parent, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and appends them to the parent element.
     *
     * @param parent the parent element
     * @param config child dom config
     * @return the new node
     */
    public static native Element append(Element parent, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.append(parent, configJS);
    }-*/;

    /**
     * Creates new Dom element(s) and appends them to the parent element.
     *
     * @param parent the parent element
     * @param child  child element
     * @return the new node
     */
    public static native Element append(Element parent, Element child)/*-{
        return $wnd.Ext.DomHelper.append(parent, child);
    }-*/;

    /**
     * Applies a style specification to an element.
     *
     * @param element the element to apply styles to
     * @param styles  a style specification string eg "width:100px"
     */
    public static native void applyStyles(Element element, String styles)/*-{
        return $wnd.Ext.DomHelper.applyStyles(element, styles);
    }-*/;

    /**
     * Creates a new Template from the Dom config spec.
     *
     * @param config the dom config
     * @return the new Template
     */
    public static native Template createTemplate(DomConfig config) /*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        var tpl = $wnd.Ext.DomHelper.createTemplate(configJS);
        return @com.gwtext.client.core.Template::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tpl);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them after the specified element.
     *
     * @param id      the element id
     * @param rawHtml raw html blob
     * @return the new node
     */
    public static native Element insertAfter(String id, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertAfter(id, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them after the specified element.
     *
     * @param id     the element id
     * @param config the element dom config spec
     * @return the new node
     */
    public static native Element insertAfter(String id, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.insertAfter(id, configJS);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them after the specified element.
     *
     * @param elem    the element
     * @param rawHtml the raw html blob
     * @return the new node
     */
    public static native Element insertAfter(Element elem, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertAfter(parent, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them after the specified element.
     *
     * @param elem   the element
     * @param config the element dom config spec
     * @return the new node
     */
    public static native Element insertAfter(Element elem, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.insertAfter(parent, configJS);
    }-*/;

    /**
     * Creates new Dom element and inserts them after the specified element.
     *
     * @param elem    the element
     * @param sibling the sibling element
     * @return the new node
     */
    public static native Element insertAfter(Element elem, Element sibling)/*-{
        return $wnd.Ext.DomHelper.insertAfter(elem, sibling);
    }-*/;

    /**
     * Creates new Dom element and inserts them before the specified element.
     *
     * @param id      the element id
     * @param rawHtml the raw html blob
     * @return the new node
     */
    public static native Element insertBefore(String id, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertBefore(id, rawHtml);
    }-*/;

    /**
     * Creates new Dom element and inserts them before the specified element.
     *
     * @param id     the element id
     * @param config the dom config object
     * @return the new node
     */
    public static native Element insertBefore(String id, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.insertBefore(id, configJS);
    }-*/;

    /**
     * Creates new Dom element and inserts them before the specified element.
     *
     * @param elem    the element
     * @param rawHtml the raw html blob
     * @return the new node
     */
    public static native Element insertBefore(Element elem, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertBefore(parent, rawHtml);
    }-*/;

    /**
     * Creates new Dom element and inserts them before the specified element.
     *
     * @param elem   the element
     * @param config the dom config object
     * @return the new node
     */
    public static native Element insertBefore(Element elem, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.insertBefore(parent, configJS);
    }-*/;

    /**
     * Creates new Dom element and inserts them before the specified element.
     *
     * @param elem    the element
     * @param sibling the sibling element
     * @return the new node
     */
    public static native Element insertBefore(Element elem, Element sibling)/*-{
            return $wnd.Ext.DomHelper.insertBefore(elem, sibling);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them as the first child of the parent element.
     *
     * @param parentId the parent element id
     * @param rawHtml  raw html blob
     * @return the new node
     */
    public static native Element insertFirst(String parentId, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertFirst(parentId, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them as the first child of the parent element.
     *
     * @param parentId the parent element id
     * @param config   the child dom config object
     * @return the new node
     */
    public static native Element insertFirst(String parentId, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.insertFirst(parentId, configJS);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them as the first child of the parent element.
     *
     * @param parent  the parent element
     * @param rawHtml raw html blob
     * @return the new node
     */
    public static native Element insertFirst(Element parent, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertFirst(parent, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them as the first child of the parent element.
     *
     * @param parent the parent element
     * @param config the child dom config object
     * @return the new node
     */
    public static native Element insertFirst(Element parent, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.insertFirst(parent, configJS);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them as the first child of the parent element.
     *
     * @param parent the parent element
     * @param child  the child element
     * @return the new node
     */
    public static native Element insertFirst(Element parent, Element child)/*-{
        return $wnd.Ext.DomHelper.insertFirst(parent, child);
    }-*/;

    /**
     * Returns the markup for the passed Element config.
     *
     * @param config the element config
     * @return markup
     */
    public static native String markup(DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.markup(elem);    
    }-*/;

    /**
     * Creates new Dom element(s) and overwrites the contents of the old element with them.
     *
     * @param oldId      the old element id
     * @param newRawHtml raw html blob
     * @return the new node
     */
    public static native Element overwrite(String oldId, String newRawHtml)/*-{
        return $wnd.Ext.DomHelper.overwrite(oldId, newRawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and overwrites the contents of the old element with them.
     *
     * @param oldId  the old element id
     * @param config the dom config object
     * @return the new node
     */
    public static native Element overwrite(String oldId, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.overwrite(oldId, configJS);
    }-*/;

    /**
     * Creates new Dom element(s) and overwrites the contents of the old element with them.
     *
     * @param oldElem    the old element
     * @param newRawHtml raw html blob
     * @return the new node
     */
    public static native Element overwrite(Element oldElem, String newRawHtml)/*-{
        return $wnd.Ext.DomHelper.overwrite(oldElem, newRawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and overwrites the contents of the old element with them.
     *
     * @param oldElem the old element
     * @param config  the dom config object
     * @return the new node
     */
    public static native Element overwrite(Element oldElem, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.overwrite(oldElem, configJS);
    }-*/;

    /**
     * Creates new Dom element(s) and overwrites the contents of the old element with them.
     *
     * @param oldElem the old element
     * @param newElem the new element
     * @return the new node
     */
    public static native Element overwrite(Element oldElem, Element newElem)/*-{
        return $wnd.Ext.DomHelper.overwrite(oldElem, newElem);
    }-*/;
}
