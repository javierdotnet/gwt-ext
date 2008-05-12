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

/**
 * Position constants.
 *
 * @author Sanjiv Jivan
 */
public class Position {

    public static Position LEFT = new Position("left");
    public static Position RIGHT = new Position("right");
    public static Position CENTER = new Position("center");
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
