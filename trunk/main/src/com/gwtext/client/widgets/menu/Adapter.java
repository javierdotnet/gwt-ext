/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.Component;

/**
 * A base utility class that adapts a non-menu component so that it can be wrapped by a menu item and added to a menu.
 * It provides basic rendering, activation management and enable/disable logic required to work in menus.
 */
public class Adapter extends BaseItem {

    private Component component;

    public Adapter(Component component) {
        this.component = component;
    }

    protected JavaScriptObject create(JavaScriptObject configJS) {
        JavaScriptObject jsObj = doCreate(component.getOrCreateJsObj(), configJS);
        component = null;
        return jsObj;
    }

    private native JavaScriptObject doCreate(JavaScriptObject componentJS, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.menu.Adapter(componentJS, configJS);
    }-*/;
}
