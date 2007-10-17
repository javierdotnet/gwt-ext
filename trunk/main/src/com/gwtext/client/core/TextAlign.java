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

/**
 * Constants for the CSS property 'text-align.
 */
public class TextAlign {
    /**
     * Aligns the text to the left.
     */
    public static TextAlign LEFT = new TextAlign("left");

    /**
     * Aligns the text to the right
     */
    public static TextAlign RIGHT = new TextAlign("right");

    /**
     * Centers the text.
     */
    public static TextAlign CENTER = new TextAlign("center");

    /**
     * f the computed value of text-align is 'justify' while the computed value of white-space is 'pre' or 'pre-line',
     * the actual value of text-align is set to the initial value.
     */
    public static TextAlign JUSTIFY = new TextAlign("justify");

    private String position;

    private TextAlign(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
