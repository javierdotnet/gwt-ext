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

public class DomQuery {

    public static class SelectorType {
        private String type;

        private SelectorType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static SelectorType SELECT = new SelectorType("select");
    public static SelectorType SIMPLE = new SelectorType("simple");

    public static DomQueryFunction compile(String selector) {
        return compile(selector, null);
    }

    private static native JavaScriptObject doCompile(String selector, String selectorType) /*-{
        if(selectorType == null) {
            return $wnd.Ext.DomQuery.compile(selector);            
        } else {
            return $wnd.Ext.DomQuery.compile(selector, selectorType);
        }

    }-*/;

    public static DomQueryFunction compile(String selector, SelectorType type) {

        String selectorType = type == null ? null : type.getType();
        final JavaScriptObject fn = doCompile(selector, selectorType);

        return new DomQueryFunction() {
            public Element[] query() {
                JavaScriptObject els = doQuery(fn);
                Element[] elements = JavaScriptObjectHelper.toElementArray(els);
                return elements;
            }

            private native JavaScriptObject doQuery(JavaScriptObject fn) /*-{
                return fn();
            }-*/;

            public Element[] query(Element root) {
                JavaScriptObject els = doQuery(fn, root);
                Element[] elements = JavaScriptObjectHelper.toElementArray(els);
                return elements;
            }

            private native JavaScriptObject doQuery(JavaScriptObject fn, Element root) /*-{
                return fn(root);
            }-*/;
        };
    }

    public static Element[] filter(Element[] els, String selector, boolean nonMatches) {
        JavaScriptObject jsElements = doFilter(JavaScriptObjectHelper.convertToJavaScriptArray(els), selector, nonMatches);
        Element[] elements = JavaScriptObjectHelper.toElementArray(jsElements);
        return elements;
    }

    private static native JavaScriptObject doFilter(JavaScriptObject els, String selector, boolean nonMatches) /*-{
        return $wnd.Ext.DomQuery.filter(els, selector, nonMatches);
    }-*/;

    public static native boolean is(String id, String selector)/*-{
        return $wnd.Ext.DomQuery.is(id, selector);
    }-*/;

    public static native boolean is(Element el, String selector)/*-{
        return $wnd.Ext.DomQuery.is(el, selector);
    }-*/;

    public static boolean is(Element[] els, String selector) {
        return doIs(JavaScriptObjectHelper.convertToJavaScriptArray(els), selector);
    }

    private static native boolean doIs(JavaScriptObject els, String selector) /*-{
        return $wnd.Ext.DomQuery.is(els, selector);
    }-*/;

    public static Element[] select(String selector) {
        JavaScriptObject jsElements = doSelect(selector);
        return JavaScriptObjectHelper.toElementArray(jsElements);
    }

    private static native JavaScriptObject doSelect(String selector) /*-{
        return $wnd.Ext.DomQuery.select(selector);
    }-*/;

    public static Element[] select(String selector, Element root) {
        JavaScriptObject jsElements = doSelect(selector, root);
        return JavaScriptObjectHelper.toElementArray(jsElements);
    }

    private static native JavaScriptObject doSelect(String selector, Element root) /*-{
        return $wnd.Ext.DomQuery.select(selector, root);            
    }-*/;

    public static native Element selectNode(String selector) /*-{
        return $wnd.Ext.DomQuery.selectNode(selector);
    }-*/;

    public static native Element selectNode(String selector, Element root) /*-{
        return $wnd.Ext.DomQuery.selectNode(selector, root);
    }-*/;

    public static native int selectNumber(String selector) /*-{
       return $wnd.Ext.DomQuery.selectNumber(selector);
    }-*/;

    public static native int selectNumber(String selector, Element root) /*-{
       return $wnd.Ext.DomQuery.selectNumber(selector, root);
    }-*/;

    public static native String selectValue(String selector) /*-{
        return $wnd.Ext.DomQuery.selectValue(selector);
    }-*/;

    public static native String selectValue(String selector, Element root) /*-{
        return $wnd.Ext.DomQuery.selectValue(selector, root);
    }-*/;

}
