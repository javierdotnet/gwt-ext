/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

/**
 * Position constants.
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