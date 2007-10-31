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
 * Anchor Position constants.
 */
public class AnchorPosition {
    /**
     * The top left corner (default).
     */
    public static AnchorPosition TOP_LEFT_CORNER = new AnchorPosition("tl");

    /**
     * The center of the top edge.
     */
    public static AnchorPosition TOP_CENTER = new AnchorPosition("t");

    /**
     * he top right corner.
     */
    public static AnchorPosition TOP_RIGHT_CORNER = new AnchorPosition("tr");

    /**
     * The center of the left edge.
     */
    public static AnchorPosition LEFT_CENTER = new AnchorPosition("l");

    /**
     * In the center of the element.
     */
    public static AnchorPosition CENTER = new AnchorPosition("c");

    /**
     * The center of the right edge.
     */
    public static AnchorPosition RIGHT_CENTER = new AnchorPosition("r");

    /**
     * The bottom left corner.
     */
    public static AnchorPosition BOTTOM_LEFT = new AnchorPosition("bl");

    /**
     * The center of the bottom edge.
     */
    public static AnchorPosition BOTTOM = new AnchorPosition("b");

    /**
     * The bottom right corner.
     */
    public static AnchorPosition BOTTOM_RIGHT = new AnchorPosition("br");

    private String position;

    private AnchorPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}