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
 * This class represents the size of an element.
 *
 * @author Sanjiv Jivan
 * @see ExtElement#getSize()
 */
public class Size {

    private int height;
    private int width;

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
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }
}
