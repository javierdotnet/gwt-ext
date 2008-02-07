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
