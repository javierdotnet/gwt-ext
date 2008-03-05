/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.layout;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * This is a multi-pane, application-oriented UI layout style that supports multiple nested panels, automatic split bars
 * between regions and built-in expanding and collapsing of regions.
 *
 * <b>Note that when using BorderLayout, you must have a Panel assigned to the CENTER region.</b>
 *
 * @see com.gwtext.client.widgets.layout.BorderLayoutData
 * @see com.gwtext.client.core.RegionPosition
 */
public class BorderLayout extends ContainerLayout {

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.layout.BorderLayout(config);
    }-*/;
}
