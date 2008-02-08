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

import com.google.gwt.user.client.Element;

/**
 * Utility class for working with DOM and/or Templates. It transparently supports using HTML fragments or DOM.
 */
public class DomHelper {

    /**
     * Creates new Dom element(s) and appends them to the parent element.
     *
     * @param parentId the parent element id
     * @param rawHtml raw html blob
     * @return the new node
     */
    public static native Element append(String parentId, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.append(parentId, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and appends them to the parent element.
     *
     * @param parentId the parent element id
     * @param config child dom config
     * @return the new node
     */
    public static native Element append(String parentId, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.append(parentId, configJS);
    }-*/;

    /**
     * Creates new Dom element(s) and appends them to the parent element.
     *
     * @param parent the parent element
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
     * @param child child element
     * @return the new node
     */
    public static native Element append(Element parent, Element child)/*-{
        return $wnd.Ext.DomHelper.append(parent, child);
    }-*/;

    /**
     * Applies a style specification to an element.
     * 
     * @param element the element to apply styles to
     * @param styles a style specification string eg "width:100px"
     */
    public static native void applyStyles(Element element, String styles)/*-{
        return $wnd.Ext.DomHelper.applyStyles(element, styles);
    }-*/;

    /**
     * Creates a new Template from the Dom config spec.
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
     * @param id the element id
     * @param rawHtml raw html blob
     * @return the new node
     */
    public static native Element insertAfter(String id, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertAfter(id, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them after the specified element.
     *
     * @param id the element id
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
     * @param elem the element
     * @param rawHtml the raw html blob
     * @return the new node
     */
    public static native Element insertAfter(Element elem, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertAfter(parent, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them after the specified element.
     *
     * @param elem the element
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
     * @param elem the element
     * @param sibling the sibling element
     * @return the new node
     */
    public static native Element insertAfter(Element elem, Element sibling)/*-{
        return $wnd.Ext.DomHelper.insertAfter(elem, sibling);
    }-*/;

    /**
     * Creates new Dom element and inserts them before the specified element.
     * 
     * @param id the element id
     * @param rawHtml the raw html blob
     * @return the new node
     */
    public static native Element insertBefore(String id, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertBefore(id, rawHtml);
    }-*/;

    /**
     * Creates new Dom element and inserts them before the specified element.
     *
     * @param id the element id
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
     * @param elem the element
     * @param rawHtml the raw html blob
     * @return the new node
     */
    public static native Element insertBefore(Element elem, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertBefore(parent, rawHtml);
    }-*/;

    /**
     * Creates new Dom element and inserts them before the specified element.
     *
     * @param elem the element
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
     * @param elem the element
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
     * @param rawHtml raw html blob
     * @return the new node
     */
    public static native Element insertFirst(String parentId, String rawHtml)/*-{
        return $wnd.Ext.DomHelper.insertFirst(parentId, rawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them as the first child of the parent element.
     *
     * @param parentId the parent element id
     * @param config the child dom config object
     * @return the new node
     */
    public static native Element insertFirst(String parentId, DomConfig config)/*-{
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return $wnd.Ext.DomHelper.insertFirst(parentId, configJS);
    }-*/;

    /**
     * Creates new Dom element(s) and inserts them as the first child of the parent element.
     *
     * @param parent the parent element
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
     * @param child the child element
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
     * @param oldId the old element id
     * @param newRawHtml raw html blob
     * @return the new node
     */
    public static native Element overwrite(String oldId, String newRawHtml)/*-{
        return $wnd.Ext.DomHelper.overwrite(oldId, newRawHtml);
    }-*/;

    /**
     * Creates new Dom element(s) and overwrites the contents of the old element with them.
     *
     * @param oldId the old element id
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
     * @param oldElem the old element
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
     * @param config the dom config object
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
