/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

/**
 * CSS Positioning constants.
 */
public class Positioning {

    public static Positioning RELATIVE = new Positioning("relative");
    public static Positioning ABSOLUTE = new Positioning("absolute");
    public static Positioning FIXED = new Positioning("fixed");

    private String positioning;

    private Positioning(String positioning) {
        this.positioning = positioning;
    }

    public String getPositioning() {
        return positioning;
    }
}
