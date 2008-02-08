/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * This class represents an Elements Region.
 *
 * @see com.gwtext.client.core.ExtElement#setRegion(Region, boolean)
 */
public class Region {

    private int top;
    private int left;
    private int right;
    private int bottom;

    public Region(int top, int left, int right, int bottom) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }

    public static Region instance(JavaScriptObject jsObj) {
        return new Region(
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "top"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "left"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "right"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "bottom")
        );
    }

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }
}