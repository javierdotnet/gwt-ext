/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

/**
 * Constants for Sort direction.
 */
public class SortDir {

    public static SortDir ASC = new SortDir("ASC");
    public static SortDir DESC = new SortDir("DESC");

    private String direction;

    private SortDir(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    /**
     * Return the sort dir value based on the passed String direction.
     *
     * @param direction the String direction
     * @return the corresponding SortDir
     */
    public static SortDir getValue(String direction) {
        if (ASC.getDirection().equalsIgnoreCase(direction)) {
            return ASC;
        } else if (DESC.getDirection().equalsIgnoreCase(direction)) {
            return DESC;
        } else {
            throw new IllegalArgumentException("Unrecognized direction value " + direction);
        }
    }
}
