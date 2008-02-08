/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.layout;

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.google.gwt.core.client.JavaScriptObject;

public class AbsoluteLayoutData extends LayoutData {

    private int x;
    private int y;
    public AbsoluteLayoutData(int x, int y) {
        this.x = x ;
        this.y = y ;
        JavaScriptObjectHelper.setAttribute(jsObj, "x", x);
        JavaScriptObjectHelper.setAttribute(jsObj, "y", y);
    }

    public JavaScriptObject getContainerAttributes() {
        JavaScriptObject containerJS = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(containerJS, "x", x);
        JavaScriptObjectHelper.setAttribute(containerJS, "y", y);
        return containerJS;
    }
}