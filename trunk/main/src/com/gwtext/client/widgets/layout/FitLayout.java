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
 * <p>This is a base class for layouts that contain a single item that automatically expands to fill the layout's container.</p>
 *
 * <p>FitLayout does not have any direct config options (other than inherited ones). To fit a panel to a container using FitLayout, simply set layout to FitLayout
 * on the container and add a single panel to it. If the container has multiple panels, only the first one will be displayed.</p>
 */
public class FitLayout extends ContainerLayout {

    public FitLayout() {
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.layout.FitLayout(config);
    }-*/;
}
