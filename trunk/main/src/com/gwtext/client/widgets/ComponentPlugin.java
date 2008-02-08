/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets;

import com.gwtext.client.core.JsObject;

public abstract class ComponentPlugin extends JsObject{

    static {
        doInit();
    }

    private static native void doInit()/*-{

    }-*/;


    public abstract void init(Component component);

}
