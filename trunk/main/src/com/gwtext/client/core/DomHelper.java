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

public class DomHelper {

    public static native Element append(String parentId, String rawHtml)/*-{
            return $wnd.Ext.DomHelper.append(parentId, rawHtml);
    }-*/;

    public static native Element append(Element parent, String rawHtml)/*-{
            return $wnd.Ext.DomHelper.append(parent, rawHtml);
    }-*/;

    public static native Element append(Element parent, Element child)/*-{
            return $wnd.Ext.DomHelper.append(parent, child);
    }-*/;

    public static native void applyStyles(Element parent, String styles)/*-{
            return $wnd.Ext.DomHelper.applyStyles(parent, styles);
    }-*/;

    public static native Template createTemplate(Element elem) /*-{
        var tpl = $wnd.Ext.DomHelper.createTemplate(elem);
        return @com.gwtext.client.core.Template::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tpl);
    }-*/;

    public static native Element insertAfter(String id, String rawHtml)/*-{
            return $wnd.Ext.DomHelper.insertAfter(id, rawHtml);
    }-*/;

    public static native Element insertAfter(Element elem, String rawHtml)/*-{
            return $wnd.Ext.DomHelper.insertAfter(parent, rawHtml);
    }-*/;

    public static native Element insertAfter(Element elem, Element sibling)/*-{
            return $wnd.Ext.DomHelper.insertAfter(elem, sibling);
    }-*/;

    public static native Element insertBefore(String id, String rawHtml)/*-{
            return $wnd.Ext.DomHelper.insertBefore(id, rawHtml);
    }-*/;

    public static native Element insertBefore(Element elem, String rawHtml)/*-{
            return $wnd.Ext.DomHelper.insertBefore(parent, rawHtml);
    }-*/;

    public static native Element insertBefore(Element elem, Element sibling)/*-{
            return $wnd.Ext.DomHelper.insertBefore(elem, sibling);
    }-*/;

    public static native Element insertFirst(String parentId, String rawHtml)/*-{
            return $wnd.Ext.DomHelper.insertFirst(parentId, rawHtml);
    }-*/;

    public static native Element insertFirst(Element parent, String rawHtml)/*-{
            return $wnd.Ext.DomHelper.insertFirst(parent, rawHtml);
    }-*/;

    public static native Element insertFirst(Element parent, Element child)/*-{
            return $wnd.Ext.DomHelper.insertFirst(parent, child);
    }-*/;

    public static native String markup(Element elem)/*-{
        return $wnd.Ext.DomHelper.markup(elem);    
    }-*/;

    public static native Element overwrite(String oldId, String newRawHtml)/*-{
            return $wnd.Ext.DomHelper.overwrite(oldId, newRawHtml);
    }-*/;

    public static native Element overwrite(Element oldElem, String newRawHtml)/*-{
            return $wnd.Ext.DomHelper.overwrite(oldElem, newRawHtml);
    }-*/;

    public static native Element overwrite(Element oldElem, Element newElem)/*-{
            return $wnd.Ext.DomHelper.overwrite(oldElem, newElem);
    }-*/;

}
