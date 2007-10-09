/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
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
     * @param x x-position
     * @param y y-position
     * @param width the box width
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
