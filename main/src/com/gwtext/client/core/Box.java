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

public class Box extends JsObject {

    private int x;
    private int y;
    private int width;
    private int height;

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

    public static Box instance(JavaScriptObject jsObj) {
        return new Box(
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "x"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "y"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "width"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "height")
        );
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
