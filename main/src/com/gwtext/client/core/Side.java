/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

/**
 * Constants for various sides.
 */
public class Side {

    public static Side TOP = new Side("t");
    public static Side LEFT = new Side("l");
    public static Side RIGHT = new Side("r");
    public static Side BOTTOM = new Side("b");

    private String side;

    private Side(String side) {
        this.side = side;
    }

    public String getSide() {
        return side;
    }
}