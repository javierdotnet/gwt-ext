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
 * Inherits the anchoring of {@link AnchorLayout} and adds the ability for x/y positioning using the standard x and y component config options.
 */
public class AbsoluteLayout extends AnchorLayout {

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.layout.AbsoluteLayout(config);
    }-*/;
}
