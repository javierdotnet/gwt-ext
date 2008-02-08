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
 * Intefrace used / returned by certain {@link com.gwtext.client.core.DomQuery} methods.
 *
 * @see com.gwtext.client.core.DomQuery#compile(String)
 * @see com.gwtext.client.core.DomQuery#compile(String, com.gwtext.client.core.DomQuery.SelectorType)
 */
public interface DomQueryFunction {

    /**
     * Execute the query represented by this function.
     *
     * @return result of query
     */
    Element[] query();

    /**
     * Execute the query represented by this function starting with the specified root element.
     *
     * @param root the root element
     * @return result of query
     */
    Element[] query(Element root);
}
