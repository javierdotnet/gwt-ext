/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

/**
 * Direction constants.
 */
public class Direction {

    public static Direction LEFT = new Direction("left");
    public static Direction RIGHT = new Direction("right");
    public static Direction TOP = new Direction("top");
    public static Direction UP = new Direction("up");
    public static Direction BOTTOM = new Direction("bottom");
    public static Direction DOWN = new Direction("down");

    private String direction;

    private Direction(String position) {
        this.direction = position;
    }

    public String getDirection() {
        return direction;
    }
}