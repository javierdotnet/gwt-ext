/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 
package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Class that represents the Paddings around an element.
 *
 * @author Sanjiv Jivan
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