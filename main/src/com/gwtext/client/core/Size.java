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
 * This class represents the size of an element.
 *
 * @see ExtElement#getSize()
 */
public class Size {

    private float height;
    private float width;

    public Size() {
    }

    /**
     * Create a new instance.
     *
     * @param width  element width
     * @param height element height
     */
    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private static Size instance(JavaScriptObject jsObj) {
        return new Size(
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "width"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "height")
        );
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param width the width
     */
    public void setWidth(float width) {
        this.width = width;
    }
}
