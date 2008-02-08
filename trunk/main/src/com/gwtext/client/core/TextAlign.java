/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.core;

/**
 * Constants for the CSS property 'text-align.
 */
public class TextAlign {
    /**
     * Aligns the text to the left.
     */
    public static final TextAlign LEFT = new TextAlign("left");

    /**
     * Aligns the text to the right
     */
    public static final TextAlign RIGHT = new TextAlign("right");

    /**
     * Centers the text.
     */
    public static final TextAlign CENTER = new TextAlign("center");

    /**
     * f the computed value of text-align is 'justify' while the computed value of white-space is 'pre' or 'pre-line',
     * the actual value of text-align is set to the initial value.
     */
    public static final TextAlign JUSTIFY = new TextAlign("justify");

    private String position;

    private TextAlign(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
