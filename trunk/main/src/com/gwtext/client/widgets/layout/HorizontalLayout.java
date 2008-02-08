/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.layout;

/**
 * Horizontal layout which allows you to lay out components horizontally in a row with the specified spacing between
 * components.
 */
public class HorizontalLayout extends TableLayout {

    /**
     * Create a new HorizontalLayout.
     *
     * @param spacing the spacing between components added
     */
    public HorizontalLayout(int spacing) {
        setSpacing("padding:0 " + spacing + "px 0 0");
    }
}
