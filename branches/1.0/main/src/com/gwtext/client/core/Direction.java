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
 * Direction constants.
 */
public class Direction {

    public static final Direction LEFT = new Direction("left");
    public static final Direction RIGHT = new Direction("right");
    public static final Direction TOP = new Direction("top");
    public static final Direction UP = new Direction("up");
    public static final Direction BOTTOM = new Direction("bottom");
    public static final Direction DOWN = new Direction("down");

    private String direction;

    private Direction(String position) {
        this.direction = position;
    }

    public String getDirection() {
        return direction;
    }
}