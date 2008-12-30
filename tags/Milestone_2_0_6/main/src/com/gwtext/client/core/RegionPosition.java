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
public class RegionPosition {

    public static RegionPosition NORTH = new RegionPosition("north");
    public static RegionPosition SOUTH = new RegionPosition("south");
    public static RegionPosition EAST = new RegionPosition("east");
    public static RegionPosition WEST = new RegionPosition("west");
    public static RegionPosition CENTER = new RegionPosition("center");

    private String position;

    private RegionPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public static RegionPosition getPosition(String position) {
        if (position.equalsIgnoreCase(NORTH.getPosition())) {
            return NORTH;
        } else if (position.equalsIgnoreCase(SOUTH.getPosition())) {
            return SOUTH;
        } else if (position.equalsIgnoreCase(EAST.getPosition())) {
            return EAST;
        } else if (position.equalsIgnoreCase(WEST.getPosition())) {
            return WEST;
        } else if (position.equalsIgnoreCase(CENTER.getPosition())) {
            return CENTER;
        } else {
            return null;
        }
    }
}