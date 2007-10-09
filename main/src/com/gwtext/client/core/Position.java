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
 * Position constants.
 */
public class Position {

    public static Position LEFT = new Position("left");
    public static Position RIGHT = new Position("right");
    public static Position TOP = new Position("top");
    public static Position BOTTOM = new Position("bottom");
    public static Position AUTO = new Position("auto");

    private String position;

    private Position(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
