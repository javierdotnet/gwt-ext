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
 * This class represents an Element's Box.
 *
 * @see com.gwtext.client.core.BaseElement#setBox(Box)
 * @see com.gwtext.client.core.BaseElement#setBox(Box, boolean, boolean)
 * @see com.gwtext.client.core.BaseElement#setBox(Box, boolean, AnimationConfig)
 */
public class Box extends JsObject {

    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Constructor
     *
     * @param x      x-position
     * @param y      y-position
     * @param width  the box width
     * @param height the box height
     */
    public Box(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, "x", x);
        JavaScriptObjectHelper.setAttribute(jsObj, "y", y);
        JavaScriptObjectHelper.setAttribute(jsObj, "width", width);
        JavaScriptObjectHelper.setAttribute(jsObj, "height", height);
    }

    private static Box instance(JavaScriptObject jsObj) {
        return new Box(
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "x"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "y"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "width"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "height")
        );
    }

    /**
     * Get the x position value.
     *
     * @return the x value
     */
    public int getX() {
        return x;
    }

    /**
     * Get the y position value.
     *
     * @return the y position
     */
    public int getY() {
        return y;
    }

    /**
     * Get the box width.
     *
     * @return the box width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the box height.
     *
     * @return the box height
     */
    public int getHeight() {
        return height;
    }
}
