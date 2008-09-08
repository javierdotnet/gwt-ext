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
 * Class that represents the margins of an element.
 */
public class Margins extends JsObject {

    private int top;
    private int left;
    private int right;
    private int bottom;

    /**
     * Create a new Margins instance.
     *
     * @param left   the left margin
     * @param top    the top margin
     * @param right  the right margin
     * @param bottom the bottom margin
     */
    public Margins(int top, int left, int right, int bottom) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        jsObj = JavaScriptObject.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, "top", top);
        JavaScriptObjectHelper.setAttribute(jsObj, "left", left);
        JavaScriptObjectHelper.setAttribute(jsObj, "right", right);
        JavaScriptObjectHelper.setAttribute(jsObj, "bottom", bottom);
    }

    private static Margins instance(JavaScriptObject jsObj) {
        return new Margins(
				JavaScriptObjectHelper.getAttributeAsInt(jsObj, "top"),
				JavaScriptObjectHelper.getAttributeAsInt(jsObj, "left"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "right"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "bottom")
        );
    }

    /**
     * @return the top margin
     */
    public int getTop() {
        return top;
    }

    /**
     * @return the left margin
     */
    public int getLeft() {
        return left;
    }

    /**
     * @return the right margin
     */
    public int getRight() {
        return right;
    }

    /**
     * @return the bottom margin
     */
    public int getBottom() {
        return bottom;
    }

	/**
	 * Return the margins as a CSS style string.
	 *
	 * @return margin as style String
	 */
	public String getStyleString() {
	    return "margin:" + top +"px " + right +"px " + bottom +"px " + left+"px;";
	}
}
