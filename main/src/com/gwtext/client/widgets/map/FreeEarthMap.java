/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

/**
 * FreeEarth map implementation.
 */
public class FreeEarthMap extends MapPanel {

    protected native JavaScriptObject doRenderMap(Element element) /*-{
        return new $wnd.Mapstraction(element, 'freeearth');            
    }-*/;
}