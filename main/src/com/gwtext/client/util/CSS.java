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

package com.gwtext.client.util;

/**
 * Utility class for manipulating CSS rules.
 */
public class CSS {

    /**
     * Very simple dynamic creation of stylesheets from a text blob of rules. The text will wrapped in a style tag and appended to the HEAD of the document.
     *
     * @param cssText the text containing the css rules
     * @param id an id to add to the stylesheet for later removal
     */
    public static native void createStyleSheet(String cssText, String id)/*-{
        $wnd.Ext.util.CSS.createStyleSheet(cssText, id);
    }-*/;

    /**
     * Gets an an individual CSS rule by selector(s).
     *
     * @param selector the CSS selector or an array of selectors to try. The first selector that is found is returned
     * @param refreshCache true to refresh the internal cache if you have recently updated any rules or added styles dynamically 
     * @return the CSS rule or null if one is not found
     */
    public static native CSSRule getRule(String selector, boolean refreshCache)/*-{
        var rule = $wnd.Ext.util.CSS.getRule(selector, refreshCache);
        if(rule == null ||  rule === undefined) {
            return null;
        } else {
            return @com.gwtext.client.util.CSSRule::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(rule);
        }
    }-*/;

    //todo getRules

    /**
     * Refresh the rule cache if you have dynamically added stylesheets.
     */
    public static native void refreshCache()/*-{
        $wnd.Ext.util.CSS.refreshCache();
    }-*/;

    /**
     * Removes a style or link tag by id
     *
     * @param id stylesheet id
     */
    public static native void removeStyleSheet(String id)/*-{
        $wnd.Ext.util.CSS.removeStyleSheet(id);
    }-*/;

    /**
     * Dynamically swaps an existing stylesheet reference for a new one.
     *
     * @param id the id of an existing link tag to remove
     * @param url the href of the new stylesheet to include
     */
    public static native void swapStyleSheet(String id, String url)/*-{
        $wnd.Ext.util.CSS.swapStyleSheet(id, url);
    }-*/;

    /**
     * Updates a rule property.
     *
     * @param selector the seelctor. Stops immediately once one is found.
     * @param property the css property
     * @param value the new value for the property
     */
    public static native void updateRule(String selector, String property, String value)/*-{
        $wnd.Ext.util.CSS.updateRule(selector, property, value);
    }-*/;
}
