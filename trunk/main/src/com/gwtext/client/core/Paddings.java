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
 * Class that represents the Paddings around an element.
 */
public class Paddings {

    private int top;
    private int left;
    private int right;
    private int bottom;

    /**
     * Create a new instance.
     *
     * @param top    the top padding
     * @param left   the left padding
     * @param right  the right padding
     * @param bottom the bottom padding
     */
    public Paddings(int top, int left, int right, int bottom) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }

    private static Paddings instance(JavaScriptObject jsObj) {
        return new Paddings(
                JavaScriptObjectHelper.getIntArrayValue(jsObj, 0),
                JavaScriptObjectHelper.getIntArrayValue(jsObj, 1),
                JavaScriptObjectHelper.getIntArrayValue(jsObj, 2),
                JavaScriptObjectHelper.getIntArrayValue(jsObj, 3)
        );
    }

    /**
     * @return the top padding
     */
    public int getTop() {
        return top;
    }

    /**
     * @return the left padding
     */
    public int getLeft() {
        return left;
    }

    /**
     * @return the right padding
     */
    public int getRight() {
        return right;
    }

    /**
     * @return the bottom padding
     */
    public int getBottom() {
        return bottom;
    }

	/**
	 * Return the paddings as a CSS style string.
	 *
	 * @return padding as style String
	 */
	public String getStyleString() {
	    return "padding:" + top +"px " + right +"px " + bottom +"px " + left+"px;";
	}
}