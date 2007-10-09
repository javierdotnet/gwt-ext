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

/**
 * Provides high performance selector/xpath processing by compiling queries into reusable functions. New pseudo classes and matchers can be plugged.
 * It works on HTML and native XML documents (if a content node is passed in).
 */
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

    /**
     * Compiles a selector/xpath query into a reusable function. The returned function takes one parameter "root" (optional),
     * which is the context node from where the query should start.
     * 
     * @param selector the selector/xpath query
     * @return  the reusable dom query function
     */
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

    /**
     * Compiles a selector/xpath query into a reusable function. The returned function takes one parameter "root" (optional),
     * which is the context node from where the query should start.
     *
     * @param selector the selector/xpath query
     * @param type either {@link #SELECT} (the default) or {@link #SIMPLE} for a simple selector match
     * @return  the reusable dom query function
     */
    public static DomQueryFunction compile(String selector, SelectorType type) {

        String selectorType = type == null ? null : type.getType();
        final JavaScriptObject fn = doCompile(selector, selectorType);

        return new DomQueryFunction() {
            public Element[] query() {
                JavaScriptObject els = doQuery(fn);
                return JavaScriptObjectHelper.toElementArray(els);

            }

            private native JavaScriptObject doQuery(JavaScriptObject fn) /*-{
                return fn();
            }-*/;

            public Element[] query(Element root) {
                JavaScriptObject els = doQuery(fn, root);
                return JavaScriptObjectHelper.toElementArray(els);
            }

            private native JavaScriptObject doQuery(JavaScriptObject fn, Element root) /*-{
                return fn(root);
            }-*/;
        };
    }

    /**
     * Filters an array of elements to only include matches of a simple selector (e.g. div.some-class or span:first-child).
     * 
     * @param els an array of elements to filter
     * @param selector the simple selector to test
     * @param nonMatches if true, it returns the elements that DON'T match the selector instead of the ones that match
     * @return filtered element array
     */
    public static Element[] filter(Element[] els, String selector, boolean nonMatches) {
        JavaScriptObject jsElements = doFilter(JavaScriptObjectHelper.convertToJavaScriptArray(els), selector, nonMatches);
        return JavaScriptObjectHelper.toElementArray(jsElements);
    }

    private static native JavaScriptObject doFilter(JavaScriptObject els, String selector, boolean nonMatches) /*-{
        return $wnd.Ext.DomQuery.filter(els, selector, nonMatches);
    }-*/;

    /**
     * Returns true if the passed element match the passed simple selector (e.g. div.some-class or span:first-child).
     *
     * @param id  the element id
     * @param selector the simple selector to test
     * @return true if matched
     */
    public static native boolean is(String id, String selector)/*-{
        return $wnd.Ext.DomQuery.is(id, selector);
    }-*/;

    /**
     * Returns true if the passed element match the passed simple selector (e.g. div.some-class or span:first-child).
     *
     * @param el  the element
     * @param selector the simple selector to test
     * @return true if matched
     */
    public static native boolean is(Element el, String selector)/*-{
        return $wnd.Ext.DomQuery.is(el, selector);
    }-*/;

    /**
     * Returns true if the passed elements match the passed simple selector (e.g. div.some-class or span:first-child).
     *
     * @param els  the element array
     * @param selector the simple selector to test
     * @return true if matched
     */
    public static boolean is(Element[] els, String selector) {
        return doIs(JavaScriptObjectHelper.convertToJavaScriptArray(els), selector);
    }

    private static native boolean doIs(JavaScriptObject els, String selector) /*-{
        return $wnd.Ext.DomQuery.is(els, selector);
    }-*/;

    /**
     * Selects a group of elements.
     * 
     * @param selector the selector/xpath query (can be a comma separated list of selectors)
     * @return array of selected elements
     */
    public static Element[] select(String selector) {
        JavaScriptObject jsElements = doSelect(selector);
        return JavaScriptObjectHelper.toElementArray(jsElements);
    }

    private static native JavaScriptObject doSelect(String selector) /*-{
        return $wnd.Ext.DomQuery.select(selector);
    }-*/;

    /**
     * Selects a group of elements.
     *
     * @param selector the selector/xpath query (can be a comma separated list of selectors)
     * @param root the start of the query (defaults to document)
     * @return array of selected elements
     */
    public static Element[] select(String selector, Element root) {
        JavaScriptObject jsElements = doSelect(selector, root);
        return JavaScriptObjectHelper.toElementArray(jsElements);
    }

    private static native JavaScriptObject doSelect(String selector, Element root) /*-{
        return $wnd.Ext.DomQuery.select(selector, root);            
    }-*/;

    /**
     * Selects a single element.
     * 
     * @param selector the selector/xpath query
     * @return the selected element
     */
    public static native Element selectNode(String selector) /*-{
        return $wnd.Ext.DomQuery.selectNode(selector);
    }-*/;

    /**
     * Selects a single element.
     *
     * @param selector the selector/xpath query
     * @param root the start of the query (defaults to document). 
     * @return the selected element
     */
    public static native Element selectNode(String selector, Element root) /*-{
        return $wnd.Ext.DomQuery.selectNode(selector, root);
    }-*/;

    /**
     * Selects the value of a node, parsing integers and floats.
     *
     * @param selector the selector/xpath query
     * @return the node value
     */
    public static native float selectNumber(String selector) /*-{
       return $wnd.Ext.DomQuery.selectNumber(selector);
    }-*/;

    /**
     * Selects the value of a node, parsing integers and floats.
     *
     * @param selector the selector/xpath query
     * @param root the start of the query (defaults to document)
     * @return the node value
     */
    public static native float selectNumber(String selector, Element root) /*-{
       return $wnd.Ext.DomQuery.selectNumber(selector, root);
    }-*/;

    /**
     * Selects the value of a node.
     *
     * @param selector the selector/xpath query
     * @return the node value
     */
    public static native String selectValue(String selector) /*-{
        return $wnd.Ext.DomQuery.selectValue(selector);
    }-*/;

    /**
     * Selects the value of a node
     *
     * @param selector the selector/xpath query
     * @param root the start of the query (defaults to document)
     * @return the node value
     */    
    public static native String selectValue(String selector, Element root) /*-{
        return $wnd.Ext.DomQuery.selectValue(selector, root);
    }-*/;

    /**
     * Selects the value of a node, optionally replacing null with the defaultValue
     *
     * @param selector the selector/xpath query
     * @param root the start of the query (defaults to document)
     * @param defaultValue value returned if null
     * @return the node value
     */
    public static native String selectValue(String selector, Element root, String defaultValue) /*-{
        return $wnd.Ext.DomQuery.selectValue(selector, root, defaultValue);
    }-*/;
    
}
